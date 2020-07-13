package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EcoequipmentDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.service.EcoequipmentService;
import com.bootdo.ecosys.service.EnterpriseService;
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
 * @date 2020-07-07 11:41:01
 */
 
@Controller
@RequestMapping("/ecosys/ecoequipment")
public class EcoequipmentController {
	@Autowired
	private EcoequipmentService ecoequipmentService;
	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:ecoequipment:ecoequipment")
	String Ecoequipment(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/ecoequipment/ecoequipment";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:ecoequipment:ecoequipment")
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
	@RequiresPermissions("ecosys:ecoequipment:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
	    return "ecosys/ecoequipment/add";
	}

	@GetMapping("/edit/{equipmentId}")
	@RequiresPermissions("ecosys:ecoequipment:edit")
	String edit(@PathVariable("equipmentId") Integer equipmentId,Model model){
		EcoequipmentDO ecoequipment = ecoequipmentService.get(equipmentId);
		EnterpriseDO enterprise = enterpriseService.get(ecoequipment.getEnterpriseId());
		ecoequipment.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("ecoequipment", ecoequipment);
	    return "ecosys/ecoequipment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:ecoequipment:add")
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
	@RequiresPermissions("ecosys:ecoequipment:edit")
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
	@RequiresPermissions("ecosys:ecoequipment:remove")
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
	@RequiresPermissions("ecosys:ecoequipment:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] equipmentIds){
		ecoequipmentService.batchRemove(equipmentIds);
		return R.ok();
	}
	
}
