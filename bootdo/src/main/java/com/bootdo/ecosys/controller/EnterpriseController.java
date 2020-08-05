package com.bootdo.ecosys.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bootdo.common.domain.FileDO;
import com.bootdo.ecosys.dao.CodeDao;
import com.bootdo.ecosys.domain.*;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.EnvprotectionService;
import com.bootdo.ecosys.service.ProductService;
import com.bootdo.tool.MessageResult;
import com.bootdo.tool.R;
import com.bootdo.tool.ResponseData;
import org.apache.commons.lang.StringUtils;
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
	@Autowired
	private CodeDao codeDao;
	
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
	String enterpriseExcelInfo(@PathVariable("enterpriseId") Integer enterpriseId,Model model) throws IOException {

		// 根据企业Id查询企业基本信息
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId);
		// 纳税人性质
		String taxpayerCode = enterprise.getTaxpayerCode();
		CodeDO codeDO = codeDao.getName(taxpayerCode,"10");
		taxpayerCode = codeDO.getName();
		enterprise.setTaxpayerCode(taxpayerCode);
		// 企业性质
		String enterpriseNatureCode = enterprise.getEnterpriseNatureCode();
		CodeDO code = codeDao.getName(enterpriseNatureCode,"1");
		enterpriseNatureCode = code.getName();
		enterprise.setEnterpriseNatureCode(enterpriseNatureCode);
		String marketCode = enterprise.getMarketCode();
		if(null ==marketCode ||"".equals(marketCode)){
		}else {
			Map<String, Object> productPackIdsmap = new HashMap<String, Object>();
			productPackIdsmap.put("productPackIds", marketCode);
			productPackIdsmap.put("parent_id","14");
			List<CodeDO> codeList = codeDao.getNames(productPackIdsmap);
			String [] str = new  String [codeList.size()];
			for(int i=0;i<codeList.size();i++){
				CodeDO CodeDO = codeList.get(i);
				String name = CodeDO.getName();
				str[i] = name;
			}
			marketCode = StringUtils.join(str,",");
			enterprise.setMarketCode(marketCode);


		}
		// 设置环保表格信息
//		enterpriseService.showExcelInfo(enterprise);
		// 跳转写成的html页面
		model.addAttribute("enterprise", enterprise);
		return "ecosys/enterprisemsg/excelmsg";
	}


}
