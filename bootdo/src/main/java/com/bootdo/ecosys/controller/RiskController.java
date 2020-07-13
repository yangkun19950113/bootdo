package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.RiskDO;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.RiskService;
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
@RequestMapping("/ecosys/risk")
public class RiskController {
	@Autowired
	private RiskService riskService;
	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:risk:risk")
	String Risk(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/risk/risk";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:risk:risk")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<RiskDO> riskList = riskService.list(query);
		int total = riskService.count(query);
		PageUtils pageUtils = new PageUtils(riskList, total);
		return pageUtils;
	}

	@GetMapping("/add/{enterpriseId}")
	@RequiresPermissions("ecosys:risk:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
	    return "ecosys/risk/add";
	}

	@GetMapping("/edit/{safeTroubleId}")
	@RequiresPermissions("ecosys:risk:edit")
	String edit(@PathVariable("safeTroubleId") Integer safeTroubleId,Model model){
		RiskDO risk = riskService.get(safeTroubleId);
		EnterpriseDO enterprise = enterpriseService.get(risk.getEnterpriseId());
		risk.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("risk", risk);
	    return "ecosys/risk/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:risk:add")
	public R save( RiskDO risk){
		if(riskService.save(risk)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ecosys:risk:edit")
	public R update( RiskDO risk){
		if(riskService.update(risk)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ecosys:risk:remove")
	public R remove( Integer safeTroubleId){
		if(riskService.remove(safeTroubleId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ecosys:risk:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] safeTroubleIds){
		riskService.batchRemove(safeTroubleIds);
		return R.ok();
	}
	
}
