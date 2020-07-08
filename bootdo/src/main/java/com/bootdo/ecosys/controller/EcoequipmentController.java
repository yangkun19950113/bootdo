package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EcoequipmentDO;
import com.bootdo.ecosys.service.EcoequipmentService;
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
@RequestMapping("/system/ecoequipment")
public class EcoequipmentController {
	@Autowired
	private EcoequipmentService ecoequipmentService;
	
	@GetMapping()
	@RequiresPermissions("system:ecoequipment:ecoequipment")
	String Ecoequipment(){
	    return "system/ecoequipment/ecoequipment";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:ecoequipment:ecoequipment")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EcoequipmentDO> ecoequipmentList = ecoequipmentService.list(query);
		int total = ecoequipmentService.count(query);
		PageUtils pageUtils = new PageUtils(ecoequipmentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:ecoequipment:add")
	String add(){
	    return "system/ecoequipment/add";
	}

	@GetMapping("/edit/{equipmentId}")
	@RequiresPermissions("system:ecoequipment:edit")
	String edit(@PathVariable("equipmentId") Integer equipmentId,Model model){
		EcoequipmentDO ecoequipment = ecoequipmentService.get(equipmentId);
		model.addAttribute("ecoequipment", ecoequipment);
	    return "system/ecoequipment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:ecoequipment:add")
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
	@RequiresPermissions("system:ecoequipment:edit")
	public R update( EcoequipmentDO ecoequipment){
		ecoequipmentService.update(ecoequipment);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:ecoequipment:remove")
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
	@RequiresPermissions("system:ecoequipment:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] equipmentIds){
		ecoequipmentService.batchRemove(equipmentIds);
		return R.ok();
	}
	
}
