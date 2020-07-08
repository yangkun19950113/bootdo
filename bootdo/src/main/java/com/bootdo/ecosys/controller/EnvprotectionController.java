package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.service.EnvprotectionService;
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
@RequestMapping("/system/envprotection")
public class EnvprotectionController {
	@Autowired
	private EnvprotectionService envprotectionService;
	
	@GetMapping()
	@RequiresPermissions("system:envprotection:envprotection")
	String Envprotection(){
	    return "system/envprotection/envprotection";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:envprotection:envprotection")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EnvprotectionDO> envprotectionList = envprotectionService.list(query);
		int total = envprotectionService.count(query);
		PageUtils pageUtils = new PageUtils(envprotectionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:envprotection:add")
	String add(){
	    return "system/envprotection/add";
	}

	@GetMapping("/edit/{envir protectionId}")
	@RequiresPermissions("system:envprotection:edit")
	String edit(@PathVariable("envir protectionId") Integer envirProtectionId,Model model){
		EnvprotectionDO envprotection = envprotectionService.get(envirProtectionId);
		model.addAttribute("envprotection", envprotection);
	    return "system/envprotection/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:envprotection:add")
	public R save( EnvprotectionDO envprotection){
		if(envprotectionService.save(envprotection)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:envprotection:edit")
	public R update( EnvprotectionDO envprotection){
		envprotectionService.update(envprotection);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:envprotection:remove")
	public R remove( Integer envirProtectionId){
		if(envprotectionService.remove(envirProtectionId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:envprotection:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] envirProtectionIds){
		envprotectionService.batchRemove(envirProtectionIds);
		return R.ok();
	}
	
}
