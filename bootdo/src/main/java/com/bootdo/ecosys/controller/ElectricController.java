package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.ElectricDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.service.ElectricService;
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
@RequestMapping("/ecosys/electric")
public class ElectricController {
	@Autowired
	private ElectricService electricService;
	@Autowired
	private EnterpriseService enterpriseService;
	
	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:electric:electric")
	String Electric(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/electric/electric";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:electric:electric")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<ElectricDO> electricList = electricService.list(query);
		int total = electricService.count(query);
		PageUtils pageUtils = new PageUtils(electricList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{enterpriseId}")
	@RequiresPermissions("ecosys:electric:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/electric/add";
	}

	@GetMapping("/edit/{equipmentId}")
	@RequiresPermissions("ecosys:electric:edit")
	String edit(@PathVariable("equipmentId") Integer equipmentId,Model model){
		ElectricDO electric = electricService.get(equipmentId);
		EnterpriseDO enterprise = enterpriseService.get(electric.getEnterpriseId());
		electric.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("electric", electric);
	    return "ecosys/electric/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:electric:add")
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
	@RequiresPermissions("ecosys:electric:edit")
	public R update( ElectricDO electric){
		if(electricService.update(electric)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ecosys:electric:remove")
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
	@RequiresPermissions("ecosys:electric:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] equipmentIds){
		electricService.batchRemove(equipmentIds);
		return R.ok();
	}
	
}
