package com.bootdo.ecosys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.domain.ShowDataDO;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.EnvprotectionService;
import com.bootdo.ecosys.service.ProductService;
import com.bootdo.tool.MessageResult;
import com.bootdo.tool.R;
import com.bootdo.tool.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

@RestController
@RequestMapping("/ecosys/enterprise")
public class EnterpriseController {
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private EnvprotectionService envprotectionService;
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	@RequiresPermissions("ecosys:enterprise:enterprise")
	String Enterprise(){
	    return "ecosys/enterprise/enterprise";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ecosys:enterprise:enterprise")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EnterpriseDO> enterpriseList = enterpriseService.list(query);
		int total = enterpriseService.count(query);
		PageUtils pageUtils = new PageUtils(enterpriseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ecosys:enterprise:add")
	String add(){
	    return "ecosys/enterprise/add";
	}

	@GetMapping("/edit/{enterpriseId}")
	@RequiresPermissions("ecosys:enterprise:edit")
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
	@RequiresPermissions("ecosys:enterprise:add")
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
	@RequiresPermissions("ecosys:enterprise:edit")
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
	@RequiresPermissions("ecosys:enterprise:remove")
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
	@RequiresPermissions("ecosys:enterprise:batchRemove")
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

	// 获取前台显示信息

	@GetMapping("/enterpriseList")
	public ResponseData enterpriseList(String enterpriseName){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ShowDataDO ShowData = new ShowDataDO();
		Map<String, Object> params = new HashMap<>();
		enterpriseName = "德云社";
		params.put("enterpriseName","德云社");
//		params.put("socialCreditCode",socialCreditCode);
		// 企业信息
		EnterpriseDO enterprise = enterpriseService.getenterprise(enterpriseName);
		String imgUrl = enterprise.getImgUrl();
		String[] strArray = imgUrl.split(",");
		System.out.println(strArray);
		for(String s : strArray){
			System.out.println(s);
		}
		enterprise.setImgUrls(strArray);
		// 轮播图片
		ShowData.setImgUrls(strArray);
		// 企业名称
		ShowData.setEnterpriseName(enterpriseName);
		// 社会信用编码
		String socialCreditCode = enterprise.getSocialCreditCode();
		ShowData.setSocialCreditCode(socialCreditCode);
		// 注册地址
		String registeredAddress = enterprise.getRegisteredAddress();
		ShowData.setRegisteredAddress(registeredAddress);
		// 注册时间
		Date registeredTime = enterprise.getRegisteredTime();
		ShowData.getRegisteredTime(registeredTime);
		//  注册资金
		Float registeredFund = enterprise.getRegisteredFund();
		ShowData.setRegisteredFund(registeredFund);
		// 员工数
		Long employeeNum = enterprise.getEmployeeNum();
		ShowData.setEmployeeNum(employeeNum);
		// 企业id
		Integer enterpriseId = enterprise.getEnterpriseId();

		// 环保基本信息
		EnvprotectionDO EnvprotectionDO = envprotectionService.getData(enterpriseId);
		// 是否有环评文号
		String ecoEstimateFlg = EnvprotectionDO.getEcoEstimateFlg();
		ShowData.setEcoEstimateFlg(ecoEstimateFlg);
		// 环评文号
		String ecoLicence = EnvprotectionDO.getEcoLicence();
		ShowData.setEcoLicence(ecoLicence);
		// 是够属于园区
		String parkFlg = EnvprotectionDO.getParkFlg();
		ShowData.setParkFlg(parkFlg);
		// 是否有环保制度
		String ecoStandardFlg = EnvprotectionDO.getEcoEstimateFlg();
		ShowData.setEcoEstimateFlg(ecoStandardFlg);

		// 企业产品及产能


		return MessageResult.success("200","", ShowData);
	}
}
