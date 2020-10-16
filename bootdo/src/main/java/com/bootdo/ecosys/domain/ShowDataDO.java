package com.bootdo.ecosys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public class ShowDataDO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 企业信息
	//企业id
	private Integer enterpriseId;
	//企业名称
	private String enterpriseName;
	//社会信用编码
	private String socialCreditCode;
	//注册地址
	private String registeredAddress;
	private String enterpriseNatureCode;
	private String industryCode;


	//注册时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registeredTime;
	//注册资金
	private Float registeredFund;
	//员工数
	private Long employeeNum;

	private String imgUrl;

	private String minImgUrl;

	private String[] imgUrls;
	// 环保基本信息
	//是否有环评文号
	private String ecoEstimateFlg;
	//环评文号
	private String ecoLicence;
	//是够属于园区
	private String parkFlg;
	//是否有环保制度
	private String ecoStandardFlg;
	// 企业产品及产能
	//产品名称
	private String prodectName;
	//规格
	private String specifical;
	//型号
	private String model;
	//生产工艺
	private String produtProcess;
	//产品原材料
	// 原材料类型
	private String materialType;
	// 原材料名称
	private String materialName;
	//月使用量
	private String monthConsumption;
	// 防治设备
	//设备名称
	private String equipmentName;
	//设备编码
	private String equipmentCode;
	//设备负责人
	private String protectionPerson;
	//联系电话
	private String phoneNumber;
	// 重点部位（危险源)
	//危险源信息名称
	private String dangerSourceName;
	//具体位置
	private String partDetail;
	//危险程度
	private String degreeCode;
	//可能会发生的事故类型
	private String accidentType;
	//监控措施
	private String monit;
	//危险责任人
	private String dangerprotectionPerson;
	// 安全生产培训
	// 是否建立安全培训制度
	private String traningSystemFlg;
	//是否为劳动者提供防护用品
	private String laProvideFlg;
	//培训主题
	private String trainName;
	//培训类型
	private String trainType;
	//参加人数
	private Long personNumber;
	// 用电设备
	// 设备名称
	private String eleequipmentName;
	//设备编码
	private String eleequipmentCode;
	//相数
	private Integer phaseNumber;
	//台数
	private Integer number;
	// 安全隐患表
	//发现人员
	private String peopleFindName;
	//发现时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date findTime;
	//级别
	private String level;
	//类型
	private String type;
	// 消防设备
   //设备名称
	private String fireequipmentName;
	//设备编码
	private String fireequipmentCode;
	//型号
	private String firemodel;
	//采购时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date buyTime;
	private String envprotectionMinImgUrl;
	private String materialMinImgUrl;
	private String ecoequipmentMinImgUrl;
	private String dangersourceMinImgUrl;
	private String trainingMinImgUrl;
	private String electricMinImgUrl;
	private String riskMinImgUrl;
	private String firedeviceMinImgUrl;
	private String monthProduction;

	public String getMonthProduction() {
		return monthProduction;
	}

	public void setMonthProduction(String monthProduction) {
		this.monthProduction = monthProduction;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getEnterpriseNatureCode() {
		return enterpriseNatureCode;
	}

	public void setEnterpriseNatureCode(String enterpriseNatureCode) {
		this.enterpriseNatureCode = enterpriseNatureCode;
	}

	public String getFiredeviceMinImgUrl() {
		return firedeviceMinImgUrl;
	}

	public void setFiredeviceMinImgUrl(String firedeviceMinImgUrl) {
		this.firedeviceMinImgUrl = firedeviceMinImgUrl;
	}


	public String getRiskMinImgUrl() {
		return riskMinImgUrl;
	}

	public void setRiskMinImgUrl(String riskMinImgUrl) {
		this.riskMinImgUrl = riskMinImgUrl;
	}

	public String getElectricMinImgUrl() {
		return electricMinImgUrl;
	}

	public void setElectricMinImgUrl(String electricMinImgUrl) {
		this.electricMinImgUrl = electricMinImgUrl;
	}

	public String getTrainingMinImgUrl() {
		return trainingMinImgUrl;
	}

	public void setTrainingMinImgUrl(String trainingMinImgUrl) {
		this.trainingMinImgUrl = trainingMinImgUrl;
	}

	public String getDangersourceMinImgUrl() {
		return dangersourceMinImgUrl;
	}

	public void setDangersourceMinImgUrl(String dangersourceMinImgUrl) {
		this.dangersourceMinImgUrl = dangersourceMinImgUrl;
	}

	public String getEcoequipmentMinImgUrl() {
		return ecoequipmentMinImgUrl;
	}

	public void setEcoequipmentMinImgUrl(String ecoequipmentMinImgUrl) {
		this.ecoequipmentMinImgUrl = ecoequipmentMinImgUrl;
	}

	public String getMaterialMinImgUrl() {
		return materialMinImgUrl;
	}

	public void setMaterialMinImgUrl(String materialMinImgUrl) {
		this.materialMinImgUrl = materialMinImgUrl;
	}

	public String getEnvprotectionMinImgUrl() {
		return envprotectionMinImgUrl;
	}

	public void setEnvprotectionMinImgUrl(String envprotectionMinImgUrl) {
		this.envprotectionMinImgUrl = envprotectionMinImgUrl;
	}
	private String productMinImgUrl;

	public String getProductMinImgUrl() {
		return productMinImgUrl;
	}

	public void setProductMinImgUrl(String productMinImgUrl) {
		this.productMinImgUrl = productMinImgUrl;
	}

	public Date getRegisteredTime() {
		return registeredTime;
	}

	public String getMinImgUrl() {
		return minImgUrl;
	}

	public void setMinImgUrl(String minImgUrl) {
		this.minImgUrl = minImgUrl;
	}

	public String getEcoLicence() {
		return ecoLicence;
	}

	public void setEcoLicence(String ecoLicence) {
		this.ecoLicence = ecoLicence;
	}

	public String getParkFlg() {
		return parkFlg;
	}

	public void setParkFlg(String parkFlg) {
		this.parkFlg = parkFlg;
	}

	public String getEcoStandardFlg() {
		return ecoStandardFlg;
	}

	public void setEcoStandardFlg(String ecoStandardFlg) {
		this.ecoStandardFlg = ecoStandardFlg;
	}

	public String getProdectName() {
		return prodectName;
	}

	public void setProdectName(String prodectName) {
		this.prodectName = prodectName;
	}

	public String getSpecifical() {
		return specifical;
	}

	public void setSpecifical(String specifical) {
		this.specifical = specifical;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProdutProcess() {
		return produtProcess;
	}

	public void setProdutProcess(String produtProcess) {
		this.produtProcess = produtProcess;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMonthConsumption() {
		return monthConsumption;
	}

	public void setMonthConsumption(String monthConsumption) {
		this.monthConsumption = monthConsumption;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getProtectionPerson() {
		return protectionPerson;
	}

	public void setProtectionPerson(String protectionPerson) {
		this.protectionPerson = protectionPerson;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDangerSourceName() {
		return dangerSourceName;
	}

	public void setDangerSourceName(String dangerSourceName) {
		this.dangerSourceName = dangerSourceName;
	}

	public String getPartDetail() {
		return partDetail;
	}

	public void setPartDetail(String partDetail) {
		this.partDetail = partDetail;
	}

	public String getDegreeCode() {
		return degreeCode;
	}

	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}

	public String getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	public String getMonit() {
		return monit;
	}

	public void setMonit(String monit) {
		this.monit = monit;
	}

	public String getDangerprotectionPerson() {
		return dangerprotectionPerson;
	}

	public void setDangerprotectionPerson(String dangerprotectionPerson) {
		this.dangerprotectionPerson = dangerprotectionPerson;
	}

	public String getTraningSystemFlg() {
		return traningSystemFlg;
	}

	public void setTraningSystemFlg(String traningSystemFlg) {
		this.traningSystemFlg = traningSystemFlg;
	}

	public String getLaProvideFlg() {
		return laProvideFlg;
	}

	public void setLaProvideFlg(String laProvideFlg) {
		this.laProvideFlg = laProvideFlg;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public Long getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(Long personNumber) {
		this.personNumber = personNumber;
	}

	public String getEleequipmentName() {
		return eleequipmentName;
	}

	public void setEleequipmentName(String eleequipmentName) {
		this.eleequipmentName = eleequipmentName;
	}

	public String getEleequipmentCode() {
		return eleequipmentCode;
	}

	public void setEleequipmentCode(String eleequipmentCode) {
		this.eleequipmentCode = eleequipmentCode;
	}

	public Integer getPhaseNumber() {
		return phaseNumber;
	}

	public void setPhaseNumber(Integer phaseNumber) {
		this.phaseNumber = phaseNumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPeopleFindName() {
		return peopleFindName;
	}

	public void setPeopleFindName(String peopleFindName) {
		this.peopleFindName = peopleFindName;
	}

	public Date getFindTime() {
		return findTime;
	}

	public void setFindTime(Date findTime) {
		this.findTime = findTime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFireequipmentName() {
		return fireequipmentName;
	}

	public void setFireequipmentName(String fireequipmentName) {
		this.fireequipmentName = fireequipmentName;
	}

	public String getFireequipmentCode() {
		return fireequipmentCode;
	}

	public void setFireequipmentCode(String fireequipmentCode) {
		this.fireequipmentCode = fireequipmentCode;
	}

	public String getFiremodel() {
		return firemodel;
	}

	public void setFiremodel(String firemodel) {
		this.firemodel = firemodel;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public String getEcoEstimateFlg() {
		return ecoEstimateFlg;
	}

	public void setEcoEstimateFlg(String ecoEstimateFlg) {
		this.ecoEstimateFlg = ecoEstimateFlg;
	}

	public String[] getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(String[] imgUrls) {
		this.imgUrls = imgUrls;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/**
	 * 设置：企业id
	 */
	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：企业id
	 */
	public Integer getEnterpriseId() {
		return enterpriseId;
	}
	/**
	 * 设置：企业名称
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	/**
	 * 获取：企业名称
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * 设置：社会信用编码
	 */
	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}
	/**
	 * 获取：社会信用编码
	 */
	public String getSocialCreditCode() {
		return socialCreditCode;
	}
	/**
	 * 设置：注册地址
	 */
	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}
	/**
	 * 获取：注册地址
	 */
	public String getRegisteredAddress() {
		return registeredAddress;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegisteredTime(Date registeredTime) {
		this.registeredTime = registeredTime;
	}
	/**
	 * 获取：注册时间
	 * @param registeredTime
	 */

	/**
	 * 设置：注册资金
	 */
	public void setRegisteredFund(Float registeredFund) {
		this.registeredFund = registeredFund;
	}
	/**
	 * 获取：注册资金
	 */
	public Float getRegisteredFund() {
		return registeredFund;
	}
	/**
	 * 设置：员工数
	 */
	public void setEmployeeNum(Long employeeNum) {
		this.employeeNum = employeeNum;
	}
	/**
	 * 获取：员工数
	 */
	public Long getEmployeeNum() {
		return employeeNum;
	}

}
