package com.bootdo.ecosys.service.impl;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.ecosys.dao.CodeDao;
import com.bootdo.ecosys.dao.EnterpriseDao;
import com.bootdo.ecosys.dao.EnvprotectionDao;
import com.bootdo.ecosys.dao.FiredeviceDao;
import com.bootdo.ecosys.domain.*;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.tool.InformationUtil;
import com.deepoove.poi.XWPFTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	@Autowired
	private EnterpriseDao enterpriseDao;
	@Autowired
	private CodeDao codeDao;
	@Autowired
	private EnvprotectionDao envprotectionDao;
	@Autowired
	private FiredeviceDao firedeviceDao;

	
	@Override
	public EnterpriseDO get(Integer enterpriseId){
		return enterpriseDao.get(enterpriseId);
	}
	
	@Override
	public List<EnterpriseDO> list(Map<String, Object> map){
		return enterpriseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return enterpriseDao.count(map);
	}
	
	@Override
	public int save(EnterpriseDO enterprise){
		return enterpriseDao.save(enterprise);
	}
	
	@Override
	public int update(EnterpriseDO enterprise){
		return enterpriseDao.update(enterprise);
	}
	
	@Override
	public int remove(Integer enterpriseId){
		EnterpriseDO enterpriseDO = enterpriseDao.get(enterpriseId);
		EnterpriseDO enterpriseUpdate = new EnterpriseDO();
		enterpriseUpdate.setDeleteFlag("1");
		enterpriseUpdate.setEnterpriseId(enterpriseId);
		return enterpriseDao.update(enterpriseUpdate);

		/*return enterpriseDao.remove(enterpriseId);*/
	}
	
	@Override
	public int batchRemove(Integer[] enterpriseIds){
		return enterpriseDao.batchRemove(enterpriseIds);
	}


	@Autowired
	public List<CommonDO> loadEnterpriseProportion(Map<String, Object> params){
		List<CommonDO> commonList = new ArrayList();
		//加载所有企业
		List<EnterpriseDO> enterpriseList = enterpriseDao.list(params);
		//1、根据行政区划进行分组
		Map<String, List<EnterpriseDO>> administrativeDivisionList = enterpriseList.stream().collect(Collectors.groupingBy(EnterpriseDO::getAdministrativeDivision));
		for(String admin:administrativeDivisionList.keySet()) {
			//2、根据村子进行分组
			List<EnterpriseDO> adminList = administrativeDivisionList.get(admin);
			Map<String, List<EnterpriseDO>> collectCountry = adminList.stream().collect(Collectors.groupingBy(EnterpriseDO::getCountry));
			for (String countryKey : collectCountry.keySet()) {
				List<EnterpriseDO> countryList = collectCountry.get(countryKey);
				int num = countryList.size();
				//根据行政区划查询乡镇
				Map<String, Object> map = new HashMap<>();
				map.put("codeId",countryList.get(0).getAdministrativeDivision());
				CodeDO levelOne = codeDao.getCode(map);
				//根据乡镇id和orderNum查询村子
				Map<String, Object> map1 = new HashMap<>();
				map1.put("parentId",levelOne.getId());
				map1.put("orderNum",countryList.get(0).getCountry());
				CodeDO levelTwo = codeDao.getCode(map1);

				CommonDO common = new CommonDO();
				common.setName(levelTwo.getName());
				common.setValue(String.valueOf(num));
				commonList.add(common);
			}
		}
		return commonList;
	}

	@Override
	public List<CommonDO> loadEnterpriseNatureCode(Map<String, Object> params) {
		return enterpriseDao.loadEnterpriseNatureCode(params);
	}

	@Override
	public List<CommonDO> loadPollutionCode(Map<String, Object> params) {
		List<EnvprotectionDO> envprotectionListNew = new ArrayList<>();
		List<CommonDO> commonList = new ArrayList();
		//查询出所有的污染类型
		List<EnvprotectionDO> envprotectionList = envprotectionDao.list(params);
		if(envprotectionList.size()>0){
			for(int i = 0;i<envprotectionList.size();i++){
				EnvprotectionDO envprotectionSelect = envprotectionList.get(i);
				String[] pollutionCodeList = envprotectionSelect.getPollutionCategoryCode().split(",");
				if(pollutionCodeList.length > 1 ){
					for(int j = 0;j<pollutionCodeList.length;j++){
						EnvprotectionDO envprotectionDO = new EnvprotectionDO();
						envprotectionDO.setEnterpriseId(envprotectionSelect.getEnterpriseId());
						envprotectionDO.setPollutionCategoryCode(pollutionCodeList[j]);
						envprotectionListNew.add(envprotectionDO);
					}
				}else{
					envprotectionListNew.add(envprotectionSelect);
				}
			}
		}
		//根据污染物类别分组
		if(envprotectionListNew.size()>0){
			Map<String, List<EnvprotectionDO>> pollutionCodeList = envprotectionListNew.stream().collect(Collectors.groupingBy(EnvprotectionDO::getPollutionCategoryCode));
			for(String pollutionCode:pollutionCodeList.keySet()) {
				List<EnvprotectionDO> listNew = pollutionCodeList.get(pollutionCode);
				int num = listNew.size();
				//根据行政区划查询乡镇
				Map<String, Object> map = new HashMap<>();
				map.put("codeId",listNew.get(0).getPollutionCategoryCode());
				CodeDO level = codeDao.getCode(map);
				CommonDO common = new CommonDO();
				common.setName(level.getName());
				common.setValue(String.valueOf(num));
				commonList.add(common);
			}
		}
		return commonList;
	}

	@Override
	public List<EnterpriseDO> enterpriseHigh(Map<String, Object> params) {
		List<EnterpriseDO> enterpriseList = enterpriseDao.getEnterpriseFive(params);
		return enterpriseList;
	}

	@Override
	public EnterpriseDO getenterprise(String enterpriseName, String socialCreditCode, Integer enterpriseId) {
		EnterpriseDO getenterprise = enterpriseDao.getenterprise(enterpriseName,socialCreditCode,enterpriseId);
		return getenterprise;
	}

	@Override
	public List<EnterpriseDO> fireEquipHigh(Map<String, Object> params) {
		return enterpriseDao.fireEquipHigh(params);
	}

	@Override
	public List<EnterpriseDO> getEnterpriselist(Map<String, Object> params) {
		List<EnterpriseDO> fireList = new ArrayList<>();
		List<EnterpriseDO> enterpriselist = enterpriseDao.list(params);
		//组织企业id
		String enIdStr = "";
		if(enterpriselist.size()>0){
			for(int i = 0;i<enterpriselist.size();i++){
				EnterpriseDO enterprise = enterpriselist.get(i);
				enIdStr = enterprise.getEnterpriseId() + "," + enIdStr;
			}
			//查询这些企业下面的消防设备个数
			String[] idArray = enIdStr.split(",");
			Map<String, Object> map = new HashMap<>();
			map.put("idArray",idArray);
			fireList = firedeviceDao.getFireLine(map);
		}
		return fireList;
	}

	@Override
	public double getEnvprotectionChart(Map<String, Object> params) {
		//查询共有多少家企业，作为分母
		int count = enterpriseDao.count(params);
		//环保信息大于0的企业
		int num = enterpriseDao.getCountEvn(params);
		double numResult = 0;
		if(count > 0 && num > 0){
			numResult = num * 1.0 / count * 100;
		}
		return numResult;
	}

	@Override
	public List<FiredeviceDO> getEffectFireEquip(Map<String, Object> params) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sim1 = new SimpleDateFormat("yyyyMMdd");
		List<FiredeviceDO> list = enterpriseDao.getEffectFireEquip(params);
		if(list.size()>0){
			for(int i = 0;i<list.size();i++){
				FiredeviceDO firedevice = list.get(i);
				String str = sim.format(firedevice.getEffectTime());
				Date operateTime = null;
				try {
					operateTime = sim1.parse(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				firedevice.setEffectTime(operateTime);
			}
		}
		return list;
	}

	@Override
	public List<DangersourceDO> getDangerData(Map<String, Object> params) {
		return enterpriseDao.getDangerData(params);
	}

	@Override
	public void showExcelInfo(EnterpriseDO enterprise) throws IOException {

		// 数据转换
		Map<String,String> dataMap = convertData(enterprise);

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\企业基本信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\企业基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);

	}

	private Map<String, String> convertData(EnterpriseDO enterprise) {
		Map<String,String> dataMap = new HashMap<String,String>();

		// 被调查人姓名
		dataMap.put("surveytedPersonName",enterprise.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",enterprise.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",enterprise.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = enterprise.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		// 企业名称
		dataMap.put("enterpriseName",enterprise.getEnterpriseName());
		// 社会信用编码
		dataMap.put("socialCreditCode",enterprise.getSocialCreditCode());
		// 注册地址
		dataMap.put("registeredAddress",enterprise.getRegisteredAddress());
		// 坐标位置
		dataMap.put("coordinates",enterprise.getCoordinates());
		// 企业规模(大中小) todo
		String enterpriseScope = enterprise.getEnterpriseScope();
		String enterpriseScopeContent = "";
		if(enterpriseScope.equals("1")){
			enterpriseScopeContent = "大";
		} else if(enterpriseScope.equals("2")){
			enterpriseScopeContent = "中";
		} else if(enterpriseScope.equals("3")) {
			enterpriseScopeContent = "小";
		}
		dataMap.put("enterpriseScope",enterpriseScopeContent);
		// 员工数
		dataMap.put("employeeNum",Long.toString(enterprise.getEmployeeNum()));
		// 注册时间
		dataMap.put("registeredTime",sdf.format(enterprise.getRegisteredTime()));
		// 注册资金
		dataMap.put("registeredFund",enterprise.getRegisteredFund() == null?"":Float.toString(enterprise.getRegisteredFund()));
		// 企业性质
		String enterpriseNatureContent = codeToString(enterprise.getEnterpriseNatureCode());
		dataMap.put("enterpriseNatureCode",enterpriseNatureContent);
		// 企业法人
		dataMap.put("enterpriseLegalPerson",enterprise.getEnterpriseLegalPerson());
		// 法人联系电话
		dataMap.put("legalPersonPhoneNumber",enterprise.getLegalPersonPhoneNumber());
		// 环保负责人
		dataMap.put("enProtectionPerson",enterprise.getEnvironmentalProtectionPerson());
		// 环保负责人联系电话
		dataMap.put("enPersonPhoneNumber",enterprise.getEnPersonPhoneNumber());
		// 安全生产负责人
		dataMap.put("safeProdectPerson",enterprise.getSafeProdectPerson());
		// 安全生产负责人联系电话
		dataMap.put("safePerPhoneNumber",enterprise.getSafePerPhoneNumber());
		// 经营范围
		dataMap.put("businessScope",enterprise.getBusinessScope());
		// 经营面积
		dataMap.put("businessArea",Float.toString(enterprise.getBusinessArea()));
		// 经营场所取得
		String businessAreaNatureContent = codeToString(enterprise.getBusinessAreaNatureCode());
		dataMap.put("businessAreaNatureCode",businessAreaNatureContent);
		// 部门设置
		dataMap.put("dept",enterprise.getDept());
		// 纳税人性质
		String taxpayerContent = codeToString(enterprise.getTaxpayerCode());
		dataMap.put("taxpayerCode",taxpayerContent);
		// 互联网营销
		String marketContent = codeToString(enterprise.getMarketCode());
		dataMap.put("marketCode",marketContent);

		return dataMap;
	}

	private String codeToString(String codeIds) {
		Map<String, Object> map = new HashMap<>();
		String convertContent = "";
		if (StringUtils.isNotEmpty(codeIds)){
			List<String> idsArray = Arrays.asList(codeIds.split(","));

			map.put("idsArray",idsArray);
			List<CodeDO> codeDoList = codeDao.getListByIds(map);
			for(int i = 0 ; i <codeDoList.size(); i++){
				CodeDO currCodeDo = codeDoList.get(i);
				if(i != (codeDoList.size() - 1)){
					convertContent += (currCodeDo.getName()+",");
				}else {
					convertContent += currCodeDo.getName();
				}
			}

		}

		return  convertContent;

	}

}
