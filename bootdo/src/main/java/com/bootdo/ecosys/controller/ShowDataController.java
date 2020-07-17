package com.bootdo.ecosys.controller;

import com.bootdo.ecosys.dao.CodeDao;
import com.bootdo.ecosys.dao.EnterpriseDao;
import com.bootdo.ecosys.domain.*;
import com.bootdo.ecosys.service.*;
import com.bootdo.tool.MessageResult;
import com.bootdo.tool.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */

@RestController
@RequestMapping("/showData/showData")
public class ShowDataController {
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private EnvprotectionService envprotectionService;
	@Autowired
	private ProductService productService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private EcoequipmentService ecoequipmentService;
	@Autowired
	private DangersourceService dangersourceService;
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private ElectricService electricService;
	@Autowired
	private RiskService riskService;
	@Autowired
	private FiredeviceService firedeviceService;
	@Autowired
	private CodeDao codeDao;
	@Autowired
	private EnterpriseDao enterpriseDao;

	// 获取前台显示信息

	@GetMapping("/enterpriseList")
	public ResponseData enterpriseList(String enterpriseName,String socialCreditCode,Integer enterpriseId){
		if((null == enterpriseName&&null == socialCreditCode&&null==enterpriseId)||("".equals(enterpriseName)&&"".equals(socialCreditCode)&&null==enterpriseId)){
			return MessageResult.success("200","", null);
		}else {


		ShowDataDO ShowData = new ShowDataDO();
		// 企业信息
		EnterpriseDO enterprise = enterpriseService.getenterprise(enterpriseName,socialCreditCode,enterpriseId);
		String imgUrl = enterprise.getImgUrl();
		String[] strArray = imgUrl.split(",");
		System.out.println(strArray);
		for(String s : strArray){
			System.out.println(s);
		}
		enterprise.setImgUrls(strArray);
		// 轮播图片
		ShowData.setImgUrls(strArray);
		// 卡片图片路径
		ShowData.setMinImgUrl("../img/enterprise.png");
		// 企业id
		enterpriseId = enterprise.getEnterpriseId();
		ShowData.setEnterpriseId(enterpriseId);
		// 企业名称
		enterpriseName = enterprise.getEnterpriseName();
		ShowData.setEnterpriseName(enterpriseName);
		// 社会信用编码
		socialCreditCode = enterprise.getSocialCreditCode();
		ShowData.setSocialCreditCode(socialCreditCode);
		// 注册地址
		String registeredAddress = enterprise.getRegisteredAddress();
		ShowData.setRegisteredAddress(registeredAddress);
		// 注册时间
		Date registeredTime = enterprise.getRegisteredTime();
		ShowData.setRegisteredTime(registeredTime);
		//  注册资金
		Float registeredFund = enterprise.getRegisteredFund();
		ShowData.setRegisteredFund(registeredFund);
		// 员工数
		Long employeeNum = enterprise.getEmployeeNum();
		ShowData.setEmployeeNum(employeeNum);
		// 企业性质
		String enterpriseNatureCode = enterprise.getEnterpriseNatureCode();
		CodeDO codeDO = codeDao.getName(enterpriseNatureCode,"1");
		enterpriseNatureCode = codeDO.getName();
		ShowData.setEnterpriseNatureCode(enterpriseNatureCode);


		// 环保基本信息
		EnvprotectionDO EnvprotectionDO = envprotectionService.getData(enterpriseId);
		if(null !=EnvprotectionDO ){
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
			ShowData.setEnvprotectionMinImgUrl("../img/envprotection.png");
			// 行业类别
//			String industryCode = EnvprotectionDO.getIndustryCode();
//			CodeDO EnvprotectionDOCodeDO = codeDao.getName(industryCode,"26");
//			industryCode = EnvprotectionDOCodeDO.getName();
//			ShowData.setIndustryCode(industryCode);
		}else {
			// 是否有环评文号

			ShowData.setEcoEstimateFlg("-");
			// 环评文号

			ShowData.setEcoLicence("-");
			// 是够属于园区
			ShowData.setParkFlg("-");
			// 是否有环保制度
			ShowData.setEcoEstimateFlg("-");
			ShowData.setEnvprotectionMinImgUrl("../img/envprotection.png");
			ShowData.setIndustryCode("-");
		}


		// 企业产品及产能
		ProductDO productDO = productService.getData(enterpriseId);
		if(null !=productDO ){
			// 产品名称
			String prodectName = productDO.getProdectName();
			ShowData.setProdectName(prodectName);
			//规格
			String specifical = productDO.getSpecifical();
			ShowData.setSpecifical(specifical);
			//型号
			String model = productDO.getModel();
			ShowData.setModel(model);
			//生产工艺
			String produtProcess = productDO.getProdutProcess();
			ShowData.setProdutProcess(produtProcess);
			ShowData.setProductMinImgUrl("../img/product.png");
			// 月产量
			BigDecimal monthProduction = productDO.getMonthProduction();
			ShowData.setMonthProduction(monthProduction);
		}else {
			ShowData.setProdectName("-");
			//规格
			ShowData.setSpecifical("-");
			//型号
			ShowData.setModel("-");
			//生产工艺
			ShowData.setProdutProcess("-");
			ShowData.setProductMinImgUrl("../img/product.png");
			// 月产量
			ShowData.setMonthProduction(new BigDecimal(0));
		}



		// 产品原材料
		MaterialDO materialDO = materialService.getData(enterpriseId);
		if(null!=materialDO){
			// 原材料类型
			String materialType = materialDO.getMaterialType();
			CodeDO materialDOCodeDO = codeDao.getName(materialType,"103");
			if(null ==materialDOCodeDO){
				ShowData.setMaterialType("-");
			}else {
				materialType = materialDOCodeDO.getName();
				ShowData.setMaterialType(materialType);
			}

			// 原材料名称
			String materialName = materialDO.getMaterialName();
			ShowData.setMaterialName(materialName);
			//月使用量
			BigDecimal monthConsumption = materialDO.getMonthConsumption();
			ShowData.setMonthConsumption(monthConsumption);
			ShowData.setMaterialMinImgUrl("../img/material.png");
		}else {
			ShowData.setMaterialType("-");
			// 原材料名称
			ShowData.setMaterialName("-");
			//月使用量
			ShowData.setMonthConsumption(new BigDecimal(0));
			ShowData.setMaterialMinImgUrl("../img/material.png");
		}

		//

		//  防治设备
		EcoequipmentDO ecoequipmentDO = ecoequipmentService.getData(enterpriseId);
		if(null!=ecoequipmentDO ){
			//设备名称
			String equipmentName = ecoequipmentDO.getEquipmentName();
			ShowData.setEquipmentName(equipmentName);
			//设备编码
			String equipmentCode = ecoequipmentDO.getEquipmentCode();
			ShowData.setEquipmentCode(equipmentCode);
			//设备负责人
			String protectionPerson = ecoequipmentDO.getProtectionPerson();
			ShowData.setProtectionPerson(protectionPerson);
			//联系电话
			String phoneNumber = ecoequipmentDO.getPhoneNumber();
			ShowData.setPhoneNumber(phoneNumber);
			ShowData.setEcoequipmentMinImgUrl("../img/ecoequipment.png");
		}else {
			ShowData.setEquipmentName("-");
			//设备编码
			ShowData.setEquipmentCode("-");
			//设备负责人
			ShowData.setProtectionPerson("-");
			//联系电话
			ShowData.setPhoneNumber("-");
			ShowData.setEcoequipmentMinImgUrl("../img/ecoequipment.png");
		}


		// 重点部位（危险源)
		DangersourceDO dangersourceDO = dangersourceService.getData(enterpriseId);
		if(null != dangersourceDO){
			//危险源信息名称
			String dangerSourceName = dangersourceDO.getDangerSourceName();
			ShowData.setDangerSourceName(dangerSourceName);
			//具体位置
			String partDetail = dangersourceDO.getPartDetail();
			ShowData.setPartDetail(partDetail);
			//危险程度
			String degreeCode = dangersourceDO.getDegreeCode();
			ShowData.setDegreeCode(degreeCode);
			//可能会发生的事故类型
			String accidentType = dangersourceDO.getAccidentType();
			ShowData.setAccidentType(accidentType);
			//监控措施
			String monit = dangersourceDO.getMonit();
			ShowData.setMonit(monit);
			//危险责任人
			String dangerprotectionPerson = dangersourceDO.getProtectionPerson();
			ShowData.setDangerprotectionPerson(dangerprotectionPerson);
			ShowData.setDangersourceMinImgUrl("../img/dangersource.png");
		}else {
			ShowData.setDangerSourceName("-");
			//具体位置-
			ShowData.setPartDetail("-");
			//危险程度-
			ShowData.setDegreeCode("-");
			//可能会发生的事故类型-
			ShowData.setAccidentType("-");
			//监控措施-
			ShowData.setMonit("-");
			//危险责任人-
			ShowData.setDangerprotectionPerson("-");
			ShowData.setDangersourceMinImgUrl("../img/dangersource.png");
		}



		// 安全生产培训
		TrainingDO trainingDO = trainingService.getData(enterpriseId);
		if(null!=trainingDO){
			// 是否建立安全培训制度
			String traningEcosysFlg = trainingDO.getTrainingFlg();
			ShowData.setTraningSystemFlg(traningEcosysFlg);
			//是否为劳动者提供防护用品
			String laProvideFlg = trainingDO.getLaProvideFlg();
			ShowData.setLaProvideFlg(laProvideFlg);
			//培训主题
			String trainName = trainingDO.getTrainName();
			ShowData.setTrainName(trainName);
			//培训类型
			String trainType = trainingDO.getTrainType();
			ShowData.setTrainType(trainType);
			//参加人数
			Long personNumber = trainingDO.getPersonNumber();
			ShowData.setPersonNumber(personNumber);
			ShowData.setTrainingMinImgUrl("../img/training.png");
		}else{
			ShowData.setTraningSystemFlg("-");
			ShowData.setLaProvideFlg("-");
			ShowData.setTrainName("-");
			ShowData.setTrainType("-");
			ShowData.setPersonNumber( Long.parseLong("0"));
			ShowData.setTrainingMinImgUrl("../img/training.png");
		}

		// 用电设备
		ElectricDO electricDO = electricService.getData(enterpriseId);
		if(null != electricDO ){
			// 设备名称
			String eleequipmentName = electricDO.getEquipmentName();
			ShowData.setEleequipmentName(eleequipmentName);
			//设备编码
			String eleequipmentCode = electricDO.getEquipmentCode();
			ShowData.setEleequipmentCode(eleequipmentCode);
			//相数
			Integer phaseNumber = electricDO.getPhaseNumber();
			ShowData.setPhaseNumber(phaseNumber);
			//台数
			Integer number = electricDO.getNumber();
			ShowData.setNumber(number);
			ShowData.setElectricMinImgUrl("../img/electric.png");
		}else {
			ShowData.setEleequipmentName("-");
			//设备编码-
			ShowData.setEleequipmentCode("-");
			//相数-
			ShowData.setPhaseNumber(0);
			//台数-
			ShowData.setNumber(0);
			ShowData.setElectricMinImgUrl("../img/electric.png");
		}


		// 安全隐患表
		RiskDO riskDO = riskService.getData(enterpriseId);
		if(null != riskDO){
			//发现人员
			String peopleFindName = riskDO.getPeopleFindName();
			ShowData.setPeopleFindName(peopleFindName);
			//发现时间
			Date findTime = riskDO.getFindTime();
			ShowData.setFindTime(findTime);
			//级别
			String level = riskDO.getLevel();
			ShowData.setLevel(level);
			//类型
			String type = riskDO.getType();
			ShowData.setType(type);
			ShowData.setRiskMinImgUrl("../img/risk.png");
		}else {
			ShowData.setPeopleFindName("-");
			//发现时间
			//级别
			ShowData.setLevel("-");
			//类型-
			ShowData.setType("-");
			ShowData.setRiskMinImgUrl("../img/risk.png");
		}


		// 消防设备
		FiredeviceDO firedeviceDO = firedeviceService.getData(enterpriseId);
		if(null != firedeviceDO){
			//设备名称
			String fireequipmentName = firedeviceDO.getEquipmentName();
			ShowData.setFireequipmentName(fireequipmentName);
			//设备编码
			String fireequipmentCode = firedeviceDO.getEquipmentCode();
			ShowData.setFireequipmentCode(fireequipmentCode);
			//型号
			String firemodel = firedeviceDO.getModel();
			ShowData.setFiremodel(firemodel);
			//采购时间
			Date buyTime = firedeviceDO.getBuyTime();
			ShowData.setBuyTime(buyTime);
			ShowData.setFiredeviceMinImgUrl("../img/firedevice.png");
		}else {
			ShowData.setFireequipmentName("-");
			//设备编码-
			ShowData.setFireequipmentCode("-");
			//型号-
			ShowData.setFiremodel("-");
			//采购时间
			ShowData.setFiredeviceMinImgUrl("../img/firedevice.png");
		}

		return MessageResult.success("200","", ShowData);
		}
	}
	@GetMapping("/getCoordinates")
	public ResponseData getCoordinates(){
		List<CoordinatesDO> coordinatesList = new ArrayList<>();
		List<EnterpriseDO> enterpriseList= enterpriseDao.getCoordinates();
		for(EnterpriseDO enterpriseDO :enterpriseList){
			CoordinatesDO coordinatesDO = new CoordinatesDO();
			String coordinates = enterpriseDO.getCoordinates();
			String[] member = coordinates.split(",");
			String x = member[0];
			coordinatesDO.setX(x);
			String y = member[1];
			coordinatesDO.setY(y);
			coordinatesList.add(coordinatesDO);
		}
		return MessageResult.success("200","", coordinatesList);
	}
	@GetMapping("/getdatabycoordinates")
	public ResponseData getdatabycoordinates(String coordinates){
		EnterpriseDO enterprise= enterpriseDao.getdatabycoordinates(coordinates);
		return MessageResult.success("200","", enterprise);
	}

//	@GetMapping("/getalldatabycoordinates")
//	public ResponseData getalldatabycoordinates(String coordinates){
//		EnterpriseDO enterprise= enterpriseDao.getdatabycoordinates(coordinates);
//		String enterpriseName = null;
//		String socialCreditCode = null;
//		ResponseData ShowDataDO = enterpriseList(enterpriseName,socialCreditCode,coordinates);
//		return MessageResult.success("200","", null);
//	}


}
