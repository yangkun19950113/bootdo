package com.bootdo.ecosys.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.ecosys.domain.CommonDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.domain.ShowDataDO;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.EnvprotectionService;
import com.bootdo.ecosys.service.ProductService;
import com.bootdo.tool.MessageResult;
import com.bootdo.tool.R;
import com.bootdo.tool.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */

@Controller
@RequestMapping("/ecosys/enterprise")
public class EnterpriseController {
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private EnvprotectionService envprotectionService;
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	String Enterprise(){
	    return "ecosys/enterprise/enterprise";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EnterpriseDO> enterpriseList = enterpriseService.list(query);
		int total = enterpriseService.count(query);
		PageUtils pageUtils = new PageUtils(enterpriseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "ecosys/enterprise/add";
	}

	@GetMapping("/edit/{enterpriseId}")
	String edit(@PathVariable("enterpriseId") Integer enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId);
		model.addAttribute("enterprise", enterprise);
	    return "ecosys/enterprise/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(EnterpriseDO enterprise){
		if(enterpriseService.save(enterprise)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( EnterpriseDO enterprise){
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			String registeredTime = enterprise.getRegisteredTime().toString();
			registeredTime = registeredTime.replace("Z", " UTC");
			Date d = format.parse(registeredTime);

			String fullFormTime = enterprise.getFullFormTime().toString();
			fullFormTime = fullFormTime.replace("Z", " UTC");
			Date d1 = format.parse(fullFormTime);
			enterprise.setRegisteredTime(d);
			enterprise.setFullFormTime(d1);

		} catch (ParseException e) {

		}

		if(enterpriseService.update(enterprise)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer enterpriseId){
		if(enterpriseService.remove(enterpriseId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] enterpriseIds){
		enterpriseService.batchRemove(enterpriseIds);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/getEnterpriseById")
	public EnterpriseDO getEnterpriseById(@RequestParam Map<String, Object> params){
		Integer enterpriseId = Integer.parseInt(params.get("enterpriseId").toString());
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId);
		return enterprise;
	}


	/**
	 * 获取企业表格信息
	 * @param enterpriseId
	 * @param model
	 * @return
	 */
	@GetMapping("/showExcelInfo/{enterpriseId}")
	//@RequiresPermissions("ecosys:envprotection:excelInfo")
	String enterpriseExcelInfo(@PathVariable("enterpriseId") Integer enterpriseId,Model model) throws IOException {
		model.addAttribute("enterpriseId", enterpriseId);

		// 根据企业Id查询企业基本信息
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId);

		// 设置环保表格信息
		enterpriseService.showExcelInfo(enterprise);

		// 跳转写成的html页面
		return "ecosys/enterprisemsg/excelmsg";
	}


}
