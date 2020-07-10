package com.bootdo.ecosys.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public class FiredeviceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//设备id
	private Integer equipmentId;
	//设备名称
	private String equipmentName;
	//设备编码
	private String equipmentCode;
	//企业id
	private Integer enterpriseId;
	//型号
	private String model;
	//采购时间
	private Date buyTime;
	//有效时间
	private Date effectTime;
	//品牌
	private String brand;
	//安装位置
	private String installPosition;
	//产品id
	private Integer productId;
	//设备负责人
	private String protectionPerson;
	//联系电话
	private String phoneNumber;
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
	//
	private Integer administrativeDivision;
	//
	private Integer urbanorrural;

	private String enterpriseName;
	private String firedeviceMinImgUrl;

	public String getFiredeviceMinImgUrl() {
		return firedeviceMinImgUrl;
	}

	public void setFiredeviceMinImgUrl(String firedeviceMinImgUrl) {
		this.firedeviceMinImgUrl = firedeviceMinImgUrl;
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
	 * 设置：型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：型号
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：采购时间
	 */
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	/**
	 * 获取：采购时间
	 */
	public Date getBuyTime() {
		return buyTime;
	}
	/**
	 * 设置：有效时间
	 */
	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}
	/**
	 * 获取：有效时间
	 */
	public Date getEffectTime() {
		return effectTime;
	}
	/**
	 * 设置：品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：品牌
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * 设置：安装位置
	 */
	public void setInstallPosition(String installPosition) {
		this.installPosition = installPosition;
	}
	/**
	 * 获取：安装位置
	 */
	public String getInstallPosition() {
		return installPosition;
	}
	/**
	 * 设置：产品id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：产品id
	 */
	public Integer getProductId() {
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
	 * 设置：
	 */
	public void setAdministrativeDivision(Integer administrativeDivision) {
		this.administrativeDivision = administrativeDivision;
	}
	/**
	 * 获取：
	 */
	public Integer getAdministrativeDivision() {
		return administrativeDivision;
	}
	/**
	 * 设置：
	 */
	public void setUrbanorrural(Integer urbanorrural) {
		this.urbanorrural = urbanorrural;
	}
	/**
	 * 获取：
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
