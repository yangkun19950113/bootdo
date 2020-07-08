package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.MaterialDO;
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
@RequestMapping("/system/material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	
	@GetMapping()
	@RequiresPermissions("system:material:material")
	String Material(){
	    return "system/material/material";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:material:material")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MaterialDO> materialList = materialService.list(query);
		int total = materialService.count(query);
		PageUtils pageUtils = new PageUtils(materialList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:material:add")
	String add(){
	    return "system/material/add";
	}

	@GetMapping("/edit/{materialId}")
	@RequiresPermissions("system:material:edit")
	String edit(@PathVariable("materialId") Integer materialId,Model model){
		MaterialDO material = materialService.get(materialId);
		model.addAttribute("material", material);
	    return "system/material/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:material:add")
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
	@RequiresPermissions("system:material:edit")
	public R update( MaterialDO material){
		materialService.update(material);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:material:remove")
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
	@RequiresPermissions("system:material:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] materialIds){
		materialService.batchRemove(materialIds);
		return R.ok();
	}
	
}
