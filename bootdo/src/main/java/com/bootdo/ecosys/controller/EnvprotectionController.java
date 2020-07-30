package com.bootdo.ecosys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.service.CodeService;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.EnvprotectionService;
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
@RequestMapping("/ecosys/envprotection")
public class EnvprotectionController {
	@Autowired
	private EnvprotectionService envprotectionService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private EnterpriseService enterpriseService;
	
	@GetMapping("/{enterpriseId}")
	String Envprotection(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/envprotection/envprotection";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<EnvprotectionDO> envprotectionList = envprotectionService.list(query);
		int total = envprotectionService.count(query);
		PageUtils pageUtils = new PageUtils(envprotectionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{enterpriseId}")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",enterprise.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		String administrativeDivisionName = code.getName();
		String administrativeDivision = enterprise.getAdministrativeDivision();
		String country = contry.getOrderNum().toString();
		String countryName = contry.getName();
		model.addAttribute("administrativeDivisionName", administrativeDivisionName);
		model.addAttribute("administrativeDivision", administrativeDivision);
		model.addAttribute("country", country);
		model.addAttribute("countryName", countryName);
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/envprotection/add";
	}

	@GetMapping("/edit/{envirProtectionId}")
	String edit(@PathVariable("envirProtectionId") Integer envirProtectionId,Model model){
		EnvprotectionDO envprotection = envprotectionService.get(envirProtectionId);
		EnterpriseDO enterprise = enterpriseService.get(envprotection.getEnterpriseId());
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",envprotection.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		envprotection.setAdministrativeDivisionName(code.getName());
		envprotection.setEnterpriseName(enterprise.getEnterpriseName());
		envprotection.setCountryName(contry.getName());
		model.addAttribute("envprotection", envprotection);
	    return "ecosys/envprotection/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
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
	public R update( EnvprotectionDO envprotection){
		envprotectionService.update(envprotection);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
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
	public R remove(@RequestParam("ids[]") Integer[] envirProtectionIds){
		envprotectionService.batchRemove(envirProtectionIds);
		return R.ok();
	}

	/**
	 * 获取环保表格信息
	 * @param enterpriseId
	 * @param model
	 * @return
	 */
	@GetMapping("/showExcelInfo/{enterpriseId}")
	String envprotectionExcelInfo(@PathVariable("enterpriseId") Integer enterpriseId,Model model) throws IOException {
		model.addAttribute("enterpriseId", enterpriseId);

		// 根据企业Id查询环保信息主数据
		EnvprotectionDO envprotection = envprotectionService.getData(enterpriseId);

		// 根据企业Id查询企业
		EnterpriseDO enterprise = enterpriseService.get(envprotection.getEnterpriseId());
		// 设置环保信息的企业名称
		if(envprotection != null){
			envprotection.setEnterpriseName(enterprise.getEnterpriseName());
		}

		// 设置环保表格信息
		envprotectionService.showExcelInfo(envprotection);

		// 跳转写成的html页面
		return "ecosys/enterprisemsg/excelmsg";
	}
	
}
