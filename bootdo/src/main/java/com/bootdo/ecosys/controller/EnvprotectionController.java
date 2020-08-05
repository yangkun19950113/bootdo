package com.bootdo.ecosys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.dao.CodeDao;
import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.service.CodeService;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.EnvprotectionService;
import org.apache.commons.lang.StringUtils;
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
	@Autowired
	private CodeDao codeDao;
	
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
		if(null !=enterprise){
			// 设置环保信息的企业名称
			if(envprotection != null){
				envprotection.setEnterpriseName(enterprise.getEnterpriseName());
			}
			// 行业类别
			String industryCode = envprotection.getIndustryCode();
			if(null == industryCode || "".equals(industryCode)){

			}else {
				Map<String, Object> productPackIdsmap = new HashMap<String, Object>();
				productPackIdsmap.put("productPackIds", industryCode);
				productPackIdsmap.put("parent_id","26");
				List<CodeDO> codeList = codeDao.getNames(productPackIdsmap);

				String [] str = new  String [codeList.size()];
				for(int i=0;i<codeList.size();i++){
					CodeDO CodeDO = codeList.get(i);
					String name = CodeDO.getName();
					str[i] = name;
				}
				industryCode = StringUtils.join(str,",");
				envprotection.setIndustryCode(industryCode);
			}

			// 项目管理类别
			String projectManageCode = envprotection.getProjectManageCode();
			if(null == projectManageCode ||"".equals(projectManageCode)){

			}else {
				Map<String, Object> productPackIdsmaps = new HashMap<String, Object>();
				productPackIdsmaps.put("productPackIds", projectManageCode);
				productPackIdsmaps.put("parent_id","26");
				List<CodeDO> codeLists = codeDao.getNames(productPackIdsmaps);

				String [] strs = new  String [codeLists.size()];
				for(int i=0;i<codeLists.size();i++){
					CodeDO CodeDO = codeLists.get(i);
					String name = CodeDO.getName();
					strs[i] = name;
				}
				projectManageCode = StringUtils.join(strs,",");
				envprotection.setProjectManageCode(projectManageCode);
			}

			// 污染类别
			String pollutionCategoryCode = envprotection.getPollutionCategoryCode();
			if(null ==pollutionCategoryCode||"".equals(pollutionCategoryCode)){

			}else {
				Map<String, Object> pollutionCategoryCodemaps = new HashMap<String, Object>();
				pollutionCategoryCodemaps.put("productPackIds", pollutionCategoryCode);
				pollutionCategoryCodemaps.put("parent_id","42");
				List<CodeDO> pollutionCategoryLists = codeDao.getNames(pollutionCategoryCodemaps);

				String [] pollutionCategorystrs = new  String [pollutionCategoryLists.size()];
				for(int i=0;i<pollutionCategoryLists.size();i++){
					CodeDO CodeDO = pollutionCategoryLists.get(i);
					String name = CodeDO.getName();
					pollutionCategorystrs[i] = name;
				}
				pollutionCategoryCode = StringUtils.join(pollutionCategorystrs,",");
				envprotection.setPollutionCategoryCode(pollutionCategoryCode);
			}


			// 所在区域
			String areaCode = envprotection.getAreaCode();
			if(null==areaCode||"".equals(areaCode)){

			}else {
				Map<String, Object> areaCodeCodemaps = new HashMap<String, Object>();
				areaCodeCodemaps.put("productPackIds", areaCode);
				areaCodeCodemaps.put("parent_id","48");
				List<CodeDO> pollutionLists = codeDao.getNames(areaCodeCodemaps);
				String [] pollutionstrs = new  String [pollutionLists.size()];
				for(int i=0;i<pollutionLists.size();i++){
					CodeDO CodeDO = pollutionLists.get(i);
					String name = CodeDO.getName();
					pollutionstrs[i] = name;
				}
				areaCode = StringUtils.join(pollutionstrs,",");
				envprotection.setAreaCode(areaCode);
			}

			// 主要能源
			String mainEnergyCode = envprotection.getMainEnergyCode();
			if(null==mainEnergyCode||"".equals(mainEnergyCode)){

			}else {
				Map<String, Object> mainEnergymaps = new HashMap<String, Object>();
				mainEnergymaps.put("productPackIds", mainEnergyCode);
				mainEnergymaps.put("parent_id","53");
				List<CodeDO> mainEnergyLists = codeDao.getNames(mainEnergymaps);
				String [] mainEnergystrs = new  String [mainEnergyLists.size()];
				for(int i=0;i<mainEnergyLists.size();i++){
					CodeDO CodeDO = mainEnergyLists.get(i);
					String name = CodeDO.getName();
					mainEnergystrs[i] = name;
				}
				mainEnergyCode = StringUtils.join(mainEnergystrs,",");
				envprotection.setMainEnergyCode(mainEnergyCode);
			}

			// 常规因子
			String normalFactorsCode = envprotection.getNormalFactorsCode();
			if(null==normalFactorsCode||"".equals(normalFactorsCode)){

			}else {
				Map<String, Object> normalFactorsmaps = new HashMap<String, Object>();
				normalFactorsmaps.put("productPackIds", normalFactorsCode);
				normalFactorsmaps.put("parent_id","57");
				List<CodeDO> normalFactorsLists = codeDao.getNames(normalFactorsmaps);
				String [] normalFactorsstrs = new  String [normalFactorsLists.size()];
				for(int i=0;i<normalFactorsLists.size();i++){
					CodeDO CodeDO = normalFactorsLists.get(i);
					String name = CodeDO.getName();
					normalFactorsstrs[i] = name;
				}
				normalFactorsCode = StringUtils.join(normalFactorsstrs,",");
				envprotection.setNormalFactorsCode(normalFactorsCode);
			}

			// 特征因子
			String specialFactorsCode = envprotection.getSpecialFactorsCode();
			if(null ==specialFactorsCode || "".equals(specialFactorsCode)){

			}else {
				Map<String, Object> specialFactorsmaps = new HashMap<String, Object>();
				specialFactorsmaps.put("productPackIds", specialFactorsCode);
				specialFactorsmaps.put("parent_id","57");
				List<CodeDO> specialFactorsLists = codeDao.getNames(specialFactorsmaps);
				String [] specialFactorsstrs = new  String [specialFactorsLists.size()];
				for(int i=0;i<specialFactorsLists.size();i++){
					CodeDO CodeDO = specialFactorsLists.get(i);
					String name = CodeDO.getName();
					specialFactorsstrs[i] = name;
				}
				specialFactorsCode = StringUtils.join(specialFactorsstrs,",");
				envprotection.setSpecialFactorsCode(specialFactorsCode);
			}
			// 排污许可管理类别
			String tradablePermitsCode = envprotection.getTradablePermitsCode();
			if(null==tradablePermitsCode ||"".equals(tradablePermitsCode) ){

			}else {
				Map<String, Object> specialFactorsmaps = new HashMap<String, Object>();
				specialFactorsmaps.put("productPackIds", tradablePermitsCode);
				specialFactorsmaps.put("parent_id","38");
				List<CodeDO> specialFactorsLists = codeDao.getNames(specialFactorsmaps);
				String [] specialFactorsstrs = new  String [specialFactorsLists.size()];
				for(int i=0;i<specialFactorsLists.size();i++){
					CodeDO CodeDO = specialFactorsLists.get(i);
					String name = CodeDO.getName();
					specialFactorsstrs[i] = name;
				}
				tradablePermitsCode = StringUtils.join(specialFactorsstrs,",");
				envprotection.setTradablePermitsCode(tradablePermitsCode);
			}

			// 设置环保表格信息
//		envprotectionService.showExcelInfo(envprotection);
			model.addAttribute("envprotection", envprotection);
			// 跳转写成的html页面
			return "ecosys/enterprisemsg/envprotectionexcel";
		}else {
			return "ecosys/enterprisemsg/msg";
		}

	}
	
}
