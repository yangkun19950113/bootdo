package com.bootdo.ecosys.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.ecosys.domain.*;
import com.bootdo.ecosys.service.*;
import com.bootdo.tool.MessageResult;
import com.bootdo.tool.R;
import com.bootdo.tool.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// 获取前台显示信息

	@GetMapping("/enterpriseList")
	public ResponseData enterpriseList(String enterpriseName){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ShowDataDO ShowData = new ShowDataDO();
		Map<String, Object> params = new HashMap<>();
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
		// 卡片图片路径
		String minImgUrl = enterprise.getMinImgUrl();
		ShowData.setMinImgUrl(minImgUrl);
		// 企业id
		Integer enterpriseId = enterprise.getEnterpriseId();
		ShowData.setEnterpriseId(enterpriseId);
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
		ShowData.setRegisteredTime(registeredTime);
		//  注册资金
		Float registeredFund = enterprise.getRegisteredFund();
		ShowData.setRegisteredFund(registeredFund);
		// 员工数
		Long employeeNum = enterprise.getEmployeeNum();
		ShowData.setEmployeeNum(employeeNum);


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
		String envprotectionMinImgUrl = EnvprotectionDO.getEnvprotectionMinImgUrl();
		ShowData.setEnvprotectionMinImgUrl(envprotectionMinImgUrl);

		// 企业产品及产能
		ProductDO productDO = productService.getData(enterpriseId);
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
		String productMinImgUrl = productDO.getProductMinImgUrl();
		ShowData.setProductMinImgUrl(productMinImgUrl);

		// 产品原材料
		MaterialDO materialDO = materialService.getData(enterpriseId);
		// 原材料类型
		String materialType = materialDO.getMaterialType();
		ShowData.setMaterialType(materialType);
		// 原材料名称
		String materialName = materialDO.getMaterialName();
		ShowData.setMaterialName(materialName);
		//月使用量
		BigDecimal monthConsumption = materialDO.getMonthConsumption();
		ShowData.setMonthConsumption(monthConsumption);
		String materialMinImgUrl = materialDO.getMaterialMinImgUrl();
		ShowData.setMaterialMinImgUrl(materialMinImgUrl);

		//  防治设备
		EcoequipmentDO ecoequipmentDO = ecoequipmentService.getData(enterpriseId);
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
		String ecoequipmentMinImgUrl = ecoequipmentDO.getEcoequipmentMinImgUrl();
		ShowData.setEcoequipmentMinImgUrl(ecoequipmentMinImgUrl);

		// 重点部位（危险源)
		DangersourceDO dangersourceDO = dangersourceService.getData(enterpriseId);
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
		String dangersourceMinImgUrl = dangersourceDO.getDangersourceMinImgUrl();
		ShowData.setDangersourceMinImgUrl(dangersourceMinImgUrl);


		// 安全生产培训
		TrainingDO trainingDO = trainingService.getData(enterpriseId);
		// 是否建立安全培训制度
		String traningEcosysFlg = trainingDO.getTraningEcosysFlg();
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
		String trainingMinImgUrl = trainingDO.getTrainingMinImgUrl();
		ShowData.setTrainingMinImgUrl(trainingMinImgUrl);


		// 用电设备
		ElectricDO electricDO = electricService.getData(enterpriseId);
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
		String electricMinImgUrl = electricDO.getElectricMinImgUrl();
		ShowData.setElectricMinImgUrl(electricMinImgUrl);

		// 安全隐患表
		RiskDO riskDO = riskService.getData(enterpriseId);
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
		String riskMinImgUrl = riskDO.getRiskMinImgUrl();
		ShowData.setRiskMinImgUrl(riskMinImgUrl);

		// 消防设备
		FiredeviceDO firedeviceDO = firedeviceService.getData(enterpriseId);
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
		String firedeviceMinImgUrl = firedeviceDO.getFiredeviceMinImgUrl();
		ShowData.setFiredeviceMinImgUrl(firedeviceMinImgUrl);
		return MessageResult.success("200","", ShowData);
	}
}
