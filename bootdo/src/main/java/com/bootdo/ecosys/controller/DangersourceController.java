package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.DangersourceDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.service.DangersourceService;
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
@RequestMapping("/ecosys/dangersource")
public class DangersourceController {
	@Autowired
	private DangersourceService dangersourceService;
	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:dangersource:dangersource")
	String Dangersource(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/dangersource/dangersource";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:dangersource:dangersource")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<DangersourceDO> dangersourceList = dangersourceService.list(query);
		int total = dangersourceService.count(query);
		PageUtils pageUtils = new PageUtils(dangersourceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{enterpriseId}")
	@RequiresPermissions("ecosys:dangersource:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
		return "ecosys/dangersource/add";
	}

	@GetMapping("/edit/{dangerSourceId}")
	@RequiresPermissions("ecosys:dangersource:edit")
	String edit(@PathVariable("dangerSourceId") Integer dangerSourceId,Model model){
		DangersourceDO dangersource = dangersourceService.get(dangerSourceId);
		model.addAttribute("dangersource", dangersource);
	    return "ecosys/dangersource/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:dangersource:add")
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
	@RequiresPermissions("ecosys:dangersource:edit")
	public R update( DangersourceDO dangersource){
		dangersourceService.update(dangersource);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ecosys:dangersource:remove")
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
	@RequiresPermissions("ecosys:dangersource:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] dangerSourceIds){
		dangersourceService.batchRemove(dangerSourceIds);
		return R.ok();
	}
	
}
