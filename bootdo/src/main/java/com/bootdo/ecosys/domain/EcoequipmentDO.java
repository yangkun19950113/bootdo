package com.bootdo.ecosys.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public class EcoequipmentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//设备id
	private Integer equipmentId;
	//设备名称
	private String equipmentName;
	//设备编码
	private String equipmentCode;
	//企业id
	private Integer enterpriseId;
	//产品id
	private Long productId;
	//设备负责人
	private String protectionPerson;
	//联系电话
	private String phoneNumber;
	//设备类型
	private String equipmentType;
	//对应产污环节名称
	private String pollutionName;
	//污染物种类
	private String pollutionType;
	//排放方式
	private String emissionWay;
	//安装时间
	private Date installTime;
	//监测时间
	private Date monitTime;
	//维护周期
	private String maintenanceCycle;
	//易损耗材
	private String lossMaterial;
	//
	private String surveytedPersonName;
	//
	private String surveytedPersonPosition;
	//
	private Date fullFormTime;
	//
	private String surveyPersonName;
	//
	private Date createTime;
	//
	private String createUserName;
	//
	private Integer createBy;
	//
	private Date modifyTime;
	//
	private String modifyUserName;
	//
	private Integer modifyBy;
	//
	private String deleteFlag;
	//行政区划
	private Integer administrativeDivision;
	//城乡分类
	private Integer urbanorrural;
	private String ecoequipmentMinImgUrl;

	private String enterpriseName;

	public String getEcoequipmentMinImgUrl() {
		return ecoequipmentMinImgUrl;
	}

	public void setEcoequipmentMinImgUrl(String ecoequipmentMinImgUrl) {
		this.ecoequipmentMinImgUrl = ecoequipmentMinImgUrl;
	}

	/**
	 * 设置：设备id
	 */
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	/**
	 * 获取：设备id
	 */
	public Integer getEquipmentId() {
		return equipmentId;
	}
	/**
	 * 设置：设备名称
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getEquipmentName() {
		return equipmentName;
	}
	/**
	 * 设置：设备编码
	 */
	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	/**
	 * 获取：设备编码
	 */
	public String getEquipmentCode() {
		return equipmentCode;
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
	 * 设置：产品id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品id
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * 设置：设备负责人
	 */
	public void setProtectionPerson(String protectionPerson) {
		this.protectionPerson = protectionPerson;
	}
	/**
	 * 获取：设备负责人
	 */
	public String getProtectionPerson() {
		return protectionPerson;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 设置：设备类型
	 */
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	/**
	 * 获取：设备类型
	 */
	public String getEquipmentType() {
		return equipmentType;
	}
	/**
	 * 设置：对应产污环节名称
	 */
	public void setPollutionName(String pollutionName) {
		this.pollutionName = pollutionName;
	}
	/**
	 * 获取：对应产污环节名称
	 */
	public String getPollutionName() {
		return pollutionName;
	}
	/**
	 * 设置：污染物种类
	 */
	public void setPollutionType(String pollutionType) {
		this.pollutionType = pollutionType;
	}
	/**
	 * 获取：污染物种类
	 */
	public String getPollutionType() {
		return pollutionType;
	}
	/**
	 * 设置：排放方式
	 */
	public void setEmissionWay(String emissionWay) {
		this.emissionWay = emissionWay;
	}
	/**
	 * 获取：排放方式
	 */
	public String getEmissionWay() {
		return emissionWay;
	}
	/**
	 * 设置：安装时间
	 */
	public void setInstallTime(Date installTime) {
		this.installTime = installTime;
	}
	/**
	 * 获取：安装时间
	 */
	public Date getInstallTime() {
		return installTime;
	}
	/**
	 * 设置：监测时间
	 */
	public void setMonitTime(Date monitTime) {
		this.monitTime = monitTime;
	}
	/**
	 * 获取：监测时间
	 */
	public Date getMonitTime() {
		return monitTime;
	}
	/**
	 * 设置：维护周期
	 */
	public void setMaintenanceCycle(String maintenanceCycle) {
		this.maintenanceCycle = maintenanceCycle;
	}
	/**
	 * 获取：维护周期
	 */
	public String getMaintenanceCycle() {
		return maintenanceCycle;
	}
	/**
	 * 设置：易损耗材
	 */
	public void setLossMaterial(String lossMaterial) {
		this.lossMaterial = lossMaterial;
	}
	/**
	 * 获取：易损耗材
	 */
	public String getLossMaterial() {
		return lossMaterial;
	}
	/**
	 * 设置：
	 */
	public void setSurveytedPersonName(String surveytedPersonName) {
		this.surveytedPersonName = surveytedPersonName;
	}
	/**
	 * 获取：
	 */
	public String getSurveytedPersonName() {
		return surveytedPersonName;
	}
	/**
	 * 设置：
	 */
	public void setSurveytedPersonPosition(String surveytedPersonPosition) {
		this.surveytedPersonPosition = surveytedPersonPosition;
	}
	/**
	 * 获取：
	 */
	public String getSurveytedPersonPosition() {
		return surveytedPersonPosition;
	}
	/**
	 * 设置：
	 */
	public void setFullFormTime(Date fullFormTime) {
		this.fullFormTime = fullFormTime;
	}
	/**
	 * 获取：
	 */
	public Date getFullFormTime() {
		return fullFormTime;
	}
	/**
	 * 设置：
	 */
	public void setSurveyPersonName(String surveyPersonName) {
		this.surveyPersonName = surveyPersonName;
	}
	/**
	 * 获取：
	 */
	public String getSurveyPersonName() {
		return surveyPersonName;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	/**
	 * 获取：
	 */
	public String getCreateUserName() {
		return createUserName;
	}
	/**
	 * 设置：
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：
	 */
	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}
	/**
	 * 获取：
	 */
	public String getModifyUserName() {
		return modifyUserName;
	}
	/**
	 * 设置：
	 */
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * 获取：
	 */
	public Integer getModifyBy() {
		return modifyBy;
	}
	/**
	 * 设置：
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	/**
	 * 获取：
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * 设置：行政区划
	 */
	public void setAdministrativeDivision(Integer administrativeDivision) {
		this.administrativeDivision = administrativeDivision;
	}
	/**
	 * 获取：行政区划
	 */
	public Integer getAdministrativeDivision() {
		return administrativeDivision;
	}
	/**
	 * 设置：城乡分类
	 */
	public void setUrbanorrural(Integer urbanorrural) {
		this.urbanorrural = urbanorrural;
	}
	/**
	 * 获取：城乡分类
	 */
	public Integer getUrbanorrural() {
		return urbanorrural;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
}
