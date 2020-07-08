package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.ElectricDO;
import com.bootdo.ecosys.service.ElectricService;
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
@RequestMapping("/system/electric")
public class ElectricController {
	@Autowired
	private ElectricService electricService;
	
	@GetMapping()
	@RequiresPermissions("system:electric:electric")
	String Electric(){
	    return "system/electric/electric";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:electric:electric")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ElectricDO> electricList = electricService.list(query);
		int total = electricService.count(query);
		PageUtils pageUtils = new PageUtils(electricList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:electric:add")
	String add(){
	    return "system/electric/add";
	}

	@GetMapping("/edit/{equipmentId}")
	@RequiresPermissions("system:electric:edit")
	String edit(@PathVariable("equipmentId") Integer equipmentId,Model model){
		ElectricDO electric = electricService.get(equipmentId);
		model.addAttribute("electric", electric);
	    return "system/electric/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:electric:add")
	public R save( ElectricDO electric){
		if(electricService.save(electric)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:electric:edit")
	public R update( ElectricDO electric){
		electricService.update(electric);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:electric:remove")
	public R remove( Integer equipmentId){
		if(electricService.remove(equipmentId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:electric:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] equipmentIds){
		electricService.batchRemove(equipmentIds);
		return R.ok();
	}
	
}
