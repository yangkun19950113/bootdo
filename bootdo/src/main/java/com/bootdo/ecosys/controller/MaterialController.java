package com.bootdo.ecosys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.MaterialDO;
import com.bootdo.ecosys.domain.ProductDO;
import com.bootdo.ecosys.service.CodeService;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.MaterialService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
 
@Controller
@RequestMapping("/ecosys/material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private CodeService codeService;

	@GetMapping("/{enterpriseId}")
//	@RequiresPermissions("ecosys:material:material")
	String Material(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/material/material";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
//	@RequiresPermissions("ecosys:material:material")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<MaterialDO> materialList = materialService.list(query);
		int total = materialService.count(query);
		PageUtils pageUtils = new PageUtils(materialList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{enterpriseId}")
//	@RequiresPermissions("ecosys:material:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",enterprise.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		String administrativeDivisionName = code.getName();
		String administrativeDivision = enterprise.getAdministrativeDivision();
		String country = contry.getOrderNum().toString();
		String countryName = contry.getName();
		model.addAttribute("administrativeDivisionName", administrativeDivisionName);
		model.addAttribute("administrativeDivision", administrativeDivision);
		model.addAttribute("country", country);
		model.addAttribute("countryName", countryName);

		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
		return "ecosys/material/add";
	}

	@GetMapping("/edit/{materialId}")
//	@RequiresPermissions("ecosys:material:edit")
	String edit(@PathVariable("materialId") Integer materialId,Model model){
		MaterialDO material = materialService.get(materialId);
		EnterpriseDO enterprise = enterpriseService.get(material.getEnterpriseId());
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",material.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		material.setAdministrativeDivisionName(code.getName());
		material.setCountryName(contry.getName());
		material.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("material", material);
	    return "ecosys/material/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("ecosys:material:add")
	public R save( MaterialDO material){
		if(materialService.save(material)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
//	@RequiresPermissions("ecosys:material:edit")
	public R update( MaterialDO material){
		if(materialService.update(material)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
//	@RequiresPermissions("ecosys:material:remove")
	public R remove( Integer materialId){
		if(materialService.remove(materialId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
//	@RequiresPermissions("ecosys:material:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] materialIds){
		materialService.batchRemove(materialIds);
		return R.ok();
	}

	/**
	 * 获取产品原料表格信息
	 * @param enterpriseId
	 * @param model
	 * @return
	 */
	@GetMapping("/showExcelInfo/{enterpriseId}")
	//@RequiresPermissions("ecosys:envprotection:excelInfo")
	String materialExcelInfo(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId,Model model) throws IOException {
		model.addAttribute("enterpriseId", enterpriseId);

		params.put("enterpriseId",enterpriseId);
		params.put("limit", 10);
		params.put("offset", 0);
		Query query = new Query(params);
		List<MaterialDO> materialList = materialService.list(query);

		// 设置环保表格信息
		materialService.showExcelInfo(materialList);

		// 跳转写成的html页面
		return "ecosys/enterprisemsg/excelmsg";
	}
	
}
