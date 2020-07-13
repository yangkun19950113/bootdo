package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.TrainingDO;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.TrainingService;
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
@RequestMapping("/ecosys/training")
public class TrainingController {
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:training:training")
	String Training(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/training/training";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:training:training")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<TrainingDO> trainingList = trainingService.list(query);
		int total = trainingService.count(query);
		PageUtils pageUtils = new PageUtils(trainingList, total);
		return pageUtils;
	}

	@GetMapping("/add/{enterpriseId}")
	@RequiresPermissions("ecosys:training:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
	    return "ecosys/training/add";
	}

	@GetMapping("/edit/{trainingId}")
	@RequiresPermissions("ecosys:training:edit")
	String edit(@PathVariable("trainingId") Integer trainingId,Model model){
		TrainingDO training = trainingService.get(trainingId);
		EnterpriseDO enterprise = enterpriseService.get(training.getEnterpriseId());
		training.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("training", training);
	    return "ecosys/training/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:training:add")
	public R save( TrainingDO training){
		if(trainingService.save(training)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ecosys:training:edit")
	public R update( TrainingDO training){
		if(trainingService.update(training)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ecosys:training:remove")
	public R remove( Integer trainingId){
		if(trainingService.remove(trainingId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ecosys:training:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] trainingIds){
		trainingService.batchRemove(trainingIds);
		return R.ok();
	}
	
}
