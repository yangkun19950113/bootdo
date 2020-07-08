package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.service.CodeService;
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
 * 数据字典表
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
 
@Controller
@RequestMapping("/ecosys/code")
public class CodeController {
	@Autowired
	private CodeService codeService;
	
	@GetMapping()
	@RequiresPermissions("ecosys:code:code")
	String Code(){
	    return "ecosys/code/code";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<CodeDO> codeList = codeService.list(params);
		int total = codeService.count(params);
		PageUtils pageUtils = new PageUtils(codeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ecosys:code:add")
	String add(){
	    return "ecosys/code/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ecosys:code:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CodeDO code = codeService.get(id);
		model.addAttribute("code", code);
	    return "ecosys/code/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:code:add")
	public R save( CodeDO code){
		if(codeService.save(code)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ecosys:code:edit")
	public R update( CodeDO code){
		codeService.update(code);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ecosys:code:remove")
	public R remove( Long id){
		if(codeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ecosys:code:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		codeService.batchRemove(ids);
		return R.ok();
	}
	
}
