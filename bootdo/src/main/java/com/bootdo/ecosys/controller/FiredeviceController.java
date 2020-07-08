package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.FiredeviceDO;
import com.bootdo.ecosys.service.FiredeviceService;
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
@RequestMapping("/system/firedevice")
public class FiredeviceController {
	@Autowired
	private FiredeviceService firedeviceService;
	
	@GetMapping()
	@RequiresPermissions("system:firedevice:firedevice")
	String Firedevice(){
	    return "system/firedevice/firedevice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:firedevice:firedevice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FiredeviceDO> firedeviceList = firedeviceService.list(query);
		int total = firedeviceService.count(query);
		PageUtils pageUtils = new PageUtils(firedeviceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:firedevice:add")
	String add(){
	    return "system/firedevice/add";
	}

	@GetMapping("/edit/{equipmentId}")
	@RequiresPermissions("system:firedevice:edit")
	String edit(@PathVariable("equipmentId") Integer equipmentId,Model model){
		FiredeviceDO firedevice = firedeviceService.get(equipmentId);
		model.addAttribute("firedevice", firedevice);
	    return "system/firedevice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:firedevice:add")
	public R save( FiredeviceDO firedevice){
		if(firedeviceService.save(firedevice)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:firedevice:edit")
	public R update( FiredeviceDO firedevice){
		firedeviceService.update(firedevice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:firedevice:remove")
	public R remove( Integer equipmentId){
		if(firedeviceService.remove(equipmentId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:firedevice:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] equipmentIds){
		firedeviceService.batchRemove(equipmentIds);
		return R.ok();
	}
	
}
