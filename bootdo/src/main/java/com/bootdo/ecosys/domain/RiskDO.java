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
public class RiskDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//培训会议id
	private Integer safeTroubleId;
	//企业id
	private Integer enterpriseId;
	//设备id
	private Integer equipmentId;
	//发现人员
	private String peopleFindName;
	//发现时间
	private Date findTime;
	//级别
	private String level;
	//类型
	private String type;
	//隐患部位
	private String apart;
	//隐患描述
	private String remark;
	//整改情况
	private String rectificat;
	//整改人
	private Date rectUserName;
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
	private String riskMinImgUrl;

	public String getRiskMinImgUrl() {
		return riskMinImgUrl;
	}

	public void setRiskMinImgUrl(String riskMinImgUrl) {
		this.riskMinImgUrl = riskMinImgUrl;
	}

	/**
	 * 设置：培训会议id
	 */
	public void setSafeTroubleId(Integer safeTroubleId) {
		this.safeTroubleId = safeTroubleId;
	}
	/**
	 * 获取：培训会议id
	 */
	public Integer getSafeTroubleId() {
		return safeTroubleId;
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
	 * 设置：设备id

	/**
	 * 设置：发现人员
	 */
	public void setPeopleFindName(String peopleFindName) {
		this.peopleFindName = peopleFindName;
	}
	/**
	 * 获取：发现人员
	 */
	public String getPeopleFindName() {
		return peopleFindName;
	}
	/**
	 * 设置：发现时间
	 */
	public void setFindTime(Date findTime) {
		this.findTime = findTime;
	}
	/**
	 * 获取：发现时间
	 */
	public Date getFindTime() {
		return findTime;
	}
	/**
	 * 设置：级别
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：级别
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：隐患部位
	 */
	public void setApart(String apart) {
		this.apart = apart;
	}
	/**
	 * 获取：隐患部位
	 */
	public String getApart() {
		return apart;
	}
	/**
	 * 设置：隐患描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：隐患描述
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：整改情况
	 */
	public void setRectificat(String rectificat) {
		this.rectificat = rectificat;
	}
	/**
	 * 获取：整改情况
	 */
	public String getRectificat() {
		return rectificat;
	}
	/**
	 * 设置：整改人
	 */
	public void setRectUserName(Date rectUserName) {
		this.rectUserName = rectUserName;
	}
	/**
	 * 获取：整改人
	 */
	public Date getRectUserName() {
		return rectUserName;
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

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
}
