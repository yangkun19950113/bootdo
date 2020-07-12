package com.bootdo.ecosys.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public class MaterialDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer materialId;
	//
	private String materialType;
	//
	private Integer productId;
	//
	private String materialName;
	//
	private String specifical;
	//
	private String model;
	//
	private String orgionWay;
	//月使用量
	private BigDecimal monthConsumption;
	//
	private String dangerMaterial;
	//
	private String content;
	//
	private String remark;
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
	private String createBy;
	//
	private Date modifyTime;
	//
	private String modifyUserName;
	//
	private String modifyBy;
	//
	private String deleteFlag;
	//
	private Integer enterpriseId;
	//行政区划
	private Integer administrativeDivision;
	//城乡分类
	private Integer urbanorrural;

	private String materialMinImgUrl;

	private String enterpriseName;

	public String getMaterialMinImgUrl() {
		return materialMinImgUrl;
	}

	public void setMaterialMinImgUrl(String materialMinImgUrl) {
		this.materialMinImgUrl = materialMinImgUrl;
	}

	/**
	 * 设置：
	 */
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	/**
	 * 获取：
	 */
	public Integer getMaterialId() {
		return materialId;
	}
	/**
	 * 设置：
	 */
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	/**
	 * 获取：
	 */
	public String getMaterialType() {
		return materialType;
	}
	/**
	 * 设置：
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * 设置：
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 * 获取：
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * 设置：
	 */
	public void setSpecifical(String specifical) {
		this.specifical = specifical;
	}
	/**
	 * 获取：
	 */
	public String getSpecifical() {
		return specifical;
	}
	/**
	 * 设置：
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：
	 */
	public void setOrgionWay(String orgionWay) {
		this.orgionWay = orgionWay;
	}
	/**
	 * 获取：
	 */
	public String getOrgionWay() {
		return orgionWay;
	}
	/**
	 * 设置：月使用量
	 */
	public void setMonthConsumption(BigDecimal monthConsumption) {
		this.monthConsumption = monthConsumption;
	}
	/**
	 * 获取：月使用量
	 */
	public BigDecimal getMonthConsumption() {
		return monthConsumption;
	}
	/**
	 * 设置：
	 */
	public void setDangerMaterial(String dangerMaterial) {
		this.dangerMaterial = dangerMaterial;
	}
	/**
	 * 获取：
	 */
	public String getDangerMaterial() {
		return dangerMaterial;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
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
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public String getCreateBy() {
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
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * 获取：
	 */
	public String getModifyBy() {
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
	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	/**
	 * 获取：
	 */
	public Integer getEnterpriseId() {
		return enterpriseId;
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
