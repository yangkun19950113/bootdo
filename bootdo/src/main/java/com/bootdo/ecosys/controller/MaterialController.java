package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.MaterialDO;
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

	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:material:material")
	String Material(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/material/material";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:material:material")
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
	@RequiresPermissions("ecosys:material:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
		return "ecosys/material/add";
	}

	@GetMapping("/edit/{materialId}")
	@RequiresPermissions("ecosys:material:edit")
	String edit(@PathVariable("materialId") Integer materialId,Model model){
		MaterialDO material = materialService.get(materialId);
		EnterpriseDO enterprise = enterpriseService.get(material.getEnterpriseId());
		material.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("material", material);
	    return "ecosys/material/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:material:add")
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
	@RequiresPermissions("ecosys:material:edit")
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
	@RequiresPermissions("ecosys:material:remove")
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
	@RequiresPermissions("ecosys:material:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] materialIds){
		materialService.batchRemove(materialIds);
		return R.ok();
	}
	
}
