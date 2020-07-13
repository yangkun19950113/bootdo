package com.bootdo.ecosys.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * traningEcosysFlg
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public class TrainingDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//培训会议id
	private Integer trainingId;
	//企业id
	private Integer enterpriseId;
	//是否建立安全培训制度
	private String trainingFlg;
	//是否为劳动者提供防护用品
	private String laProvideFlg;
	//培训主题
	private String trainName;
	//培训类型
	private String trainType;
	//参加人数
	private Long personNumber;
	//参加部门
	private String deptCode;
	//是否有资料
	private String traningFileFlg;
	//联系电话
	private String phoneNumber;
	//培训时间
	private Date trainTime;
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
	private Long createBy;
	//
	private Date modifyTime;
	//
	private String modifyUserName;
	//
	private Long modifyBy;
	//
	private String deleteFlag;
	//
	private Integer administrativeDivision;
	//
	private Integer urbanorrural;
	private String trainingMinImgUrl;

	private String enterpriseName;

	public String getTrainingMinImgUrl() {
		return trainingMinImgUrl;
	}

	public void setTrainingMinImgUrl(String trainingMinImgUrl) {
		this.trainingMinImgUrl = trainingMinImgUrl;
	}

	/**
	 * 设置：培训会议id
	 */
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	/**
	 * 获取：培训会议id
	 */
	public Integer getTrainingId() {
		return trainingId;
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
	 * 设置：是否为劳动者提供防护用品
	 */
	public void setLaProvideFlg(String laProvideFlg) {
		this.laProvideFlg = laProvideFlg;
	}
	/**
	 * 获取：是否为劳动者提供防护用品
	 */
	public String getLaProvideFlg() {
		return laProvideFlg;
	}
	/**
	 * 设置：培训主题
	 */
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	/**
	 * 获取：培训主题
	 */
	public String getTrainName() {
		return trainName;
	}
	/**
	 * 设置：培训类型
	 */
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	/**
	 * 获取：培训类型
	 */
	public String getTrainType() {
		return trainType;
	}
	/**
	 * 设置：参加人数
	 */
	public void setPersonNumber(Long personNumber) {
		this.personNumber = personNumber;
	}
	/**
	 * 获取：参加人数
	 */
	public Long getPersonNumber() {
		return personNumber;
	}
	/**
	 * 设置：参加部门
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/**
	 * 获取：参加部门
	 */
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * 设置：是否有资料
	 */
	public void setTraningFileFlg(String traningFileFlg) {
		this.traningFileFlg = traningFileFlg;
	}
	/**
	 * 获取：是否有资料
	 */
	public String getTraningFileFlg() {
		return traningFileFlg;
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
	 * 设置：培训时间
	 */
	public void setTrainTime(Date trainTime) {
		this.trainTime = trainTime;
	}
	/**
	 * 获取：培训时间
	 */
	public Date getTrainTime() {
		return trainTime;
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
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public Long getCreateBy() {
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
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * 获取：
	 */
	public Long getModifyBy() {
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

	public String getTrainingFlg() {
		return trainingFlg;
	}

	public void setTrainingFlg(String trainingFlg) {
		this.trainingFlg = trainingFlg;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
}
