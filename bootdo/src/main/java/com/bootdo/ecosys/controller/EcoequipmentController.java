package com.bootdo.ecosys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EcoequipmentDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.MaterialDO;
import com.bootdo.ecosys.service.CodeService;
import com.bootdo.ecosys.service.EcoequipmentService;
import com.bootdo.ecosys.service.EnterpriseService;
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
 * @date 2020-07-07 11:41:01
 */
 
@Controller
@RequestMapping("/ecosys/ecoequipment")
public class EcoequipmentController {
	@Autowired
	private EcoequipmentService ecoequipmentService;
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private CodeService codeService;

	@GetMapping("/{enterpriseId}")
	String Ecoequipment(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/ecoequipment/ecoequipment";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<EcoequipmentDO> ecoequipmentList = ecoequipmentService.list(query);
		int total = ecoequipmentService.count(query);
		PageUtils pageUtils = new PageUtils(ecoequipmentList, total);
		return pageUtils;
	}

	@GetMapping("/add/{enterpriseId}")
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
	    return "ecosys/ecoequipment/add";
	}

	@GetMapping("/edit/{equipmentId}")
	String edit(@PathVariable("equipmentId") Integer equipmentId,Model model){
		EcoequipmentDO ecoequipment = ecoequipmentService.get(equipmentId);
		EnterpriseDO enterprise = enterpriseService.get(ecoequipment.getEnterpriseId());
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",ecoequipment.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		ecoequipment.setAdministrativeDivisionName(code.getName());
		ecoequipment.setCountryName(contry.getName());
		ecoequipment.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("ecoequipment", ecoequipment);
	    return "ecosys/ecoequipment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( EcoequipmentDO ecoequipment){
		if(ecoequipmentService.save(ecoequipment)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( EcoequipmentDO ecoequipment){
		if(ecoequipmentService.update(ecoequipment)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer equipmentId){
		if(ecoequipmentService.remove(equipmentId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] equipmentIds){
		ecoequipmentService.batchRemove(equipmentIds);
		return R.ok();
	}

	/**
	 * 获取产污及防治设备表格信息
	 * @param enterpriseId
	 * @param model
	 * @return
	 */
	@GetMapping("/showExcelInfo/{enterpriseId}")
	//@RequiresPermissions("ecosys:envprotection:excelInfo")
	String ecoequipmentExcelInfo(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId,Model model) throws IOException {
		model.addAttribute("enterpriseId", enterpriseId);

		params.put("enterpriseId",enterpriseId);
		params.put("limit", 10);
		params.put("offset", 0);
		Query query = new Query(params);
		List<EcoequipmentDO> ecoequipmentList = ecoequipmentService.list(query);

		if(ecoequipmentList.size() > 0) {
			EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
			ecoequipmentList.get(0).setEnterpriseName(enterprise.getEnterpriseName());
		}

		// 设置产污及防治设备表格信息
		ecoequipmentService.showExcelInfo(ecoequipmentList);

		// 跳转写成的html页面
		return "ecosys/enterprisemsg/excelmsg";
	}

}
