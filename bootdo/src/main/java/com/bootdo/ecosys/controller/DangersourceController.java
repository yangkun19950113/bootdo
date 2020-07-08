package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.DangersourceDO;
import com.bootdo.ecosys.service.DangersourceService;
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
@RequestMapping("/system/dangersource")
public class DangersourceController {
	@Autowired
	private DangersourceService dangersourceService;
	
	@GetMapping()
	@RequiresPermissions("system:dangersource:dangersource")
	String Dangersource(){
	    return "system/dangersource/dangersource";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:dangersource:dangersource")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DangersourceDO> dangersourceList = dangersourceService.list(query);
		int total = dangersourceService.count(query);
		PageUtils pageUtils = new PageUtils(dangersourceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:dangersource:add")
	String add(){
	    return "system/dangersource/add";
	}

	@GetMapping("/edit/{dangerSourceId}")
	@RequiresPermissions("system:dangersource:edit")
	String edit(@PathVariable("dangerSourceId") Integer dangerSourceId,Model model){
		DangersourceDO dangersource = dangersourceService.get(dangerSourceId);
		model.addAttribute("dangersource", dangersource);
	    return "system/dangersource/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:dangersource:add")
	public R save( DangersourceDO dangersource){
		if(dangersourceService.save(dangersource)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:dangersource:edit")
	public R update( DangersourceDO dangersource){
		dangersourceService.update(dangersource);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:dangersource:remove")
	public R remove( Integer dangerSourceId){
		if(dangersourceService.remove(dangerSourceId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:dangersource:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] dangerSourceIds){
		dangersourceService.batchRemove(dangerSourceIds);
		return R.ok();
	}
	
}
