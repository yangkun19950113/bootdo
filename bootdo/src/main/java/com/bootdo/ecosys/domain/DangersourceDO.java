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
public class DangersourceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//危险源信息id
	private Integer dangerSourceId;
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
	//责任人
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
	private Integer enterpriseId;
	//
	private Integer administrativeDivision;
	//
	private Integer urbanorrural;

	private String dangersourceMinImgUrl;

	private String enterpriseName;

	public String getDangersourceMinImgUrl() {
		return dangersourceMinImgUrl;
	}

	public void setDangersourceMinImgUrl(String dangersourceMinImgUrl) {
		this.dangersourceMinImgUrl = dangersourceMinImgUrl;
	}

	/**
	 * 设置：危险源信息id
	 */
	public void setDangerSourceId(Integer dangerSourceId) {
		this.dangerSourceId = dangerSourceId;
	}
	/**
	 * 获取：危险源信息id
	 */
	public Integer getDangerSourceId() {
		return dangerSourceId;
	}
	/**
	 * 设置：危险源信息名称
	 */
	public void setDangerSourceName(String dangerSourceName) {
		this.dangerSourceName = dangerSourceName;
	}
	/**
	 * 获取：危险源信息名称
	 */
	public String getDangerSourceName() {
		return dangerSourceName;
	}
	/**
	 * 设置：具体位置
	 */
	public void setPartDetail(String partDetail) {
		this.partDetail = partDetail;
	}
	/**
	 * 获取：具体位置
	 */
	public String getPartDetail() {
		return partDetail;
	}
	/**
	 * 设置：危险程度
	 */
	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	/**
	 * 获取：危险程度
	 */
	public String getDegreeCode() {
		return degreeCode;
	}
	/**
	 * 设置：可能会发生的事故类型
	 */
	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}
	/**
	 * 获取：可能会发生的事故类型
	 */
	public String getAccidentType() {
		return accidentType;
	}
	/**
	 * 设置：监控措施
	 */
	public void setMonit(String monit) {
		this.monit = monit;
	}
	/**
	 * 获取：监控措施
	 */
	public String getMonit() {
		return monit;
	}
	/**
	 * 设置：责任人
	 */
	public void setProtectionPerson(String protectionPerson) {
		this.protectionPerson = protectionPerson;
	}
	/**
	 * 获取：责任人
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
