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
public class EnvprotectionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//环保基础信息id
	private Integer envirProtectionId;
	//企业id
	private Integer enterpriseId;
	//企业名称
	private String enterpriseName;
	//是否有环评文号
	private String ecoEstimateFlg;
	//环评文号
	private String ecoLicence;
	//是够属于园区
	private String parkFlg;
	//是否有环保制度
	private String ecoStandardFlg;
	//行业类别code
	private String industryCode;
	//项目管理类别code
	private String projectManageCode;
	//是否竣工验收
	private String isOrNotAcceptance;
	//排污许可管理类别
	private String tradablePermitsCode;
	//是否核发排污许可证
	private String pollutionLicenseFlg;
	//污染类别
	private String pollutionCategoryCode;
	//年检监测是否有效
	private String annualInspectionFlg;
	//所在区域
	private String areaCode;
	//主要能源
	private String mainEnergyCode;
	//污染治理措施
	private String measures;
	//常规因子
	private String normalFactorsCode;
	//特征因子
	private String specialFactorsCode;
	//一般固体废物
	private String nomalWaste;
	//危险废物
	private String dangerWaste;
	//被调查人姓名
	private String surveytedPersonName;
	//被调查人职务
	private String surveytedPersonPosition;
	//填表日期
	private Date fullFormTime;
	//调查人
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
	//行政区划
	private Integer administrativeDivision;
	//城乡分类
	private Integer urbanorrural;

	private String envprotectionMinImgUrl;

	public String getEnvprotectionMinImgUrl() {
		return envprotectionMinImgUrl;
	}

	public void setEnvprotectionMinImgUrl(String envprotectionMinImgUrl) {
		this.envprotectionMinImgUrl = envprotectionMinImgUrl;
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
	 * 设置：是否有环评文号
	 */
	public void setEcoEstimateFlg(String ecoEstimateFlg) {
		this.ecoEstimateFlg = ecoEstimateFlg;
	}
	/**
	 * 获取：是否有环评文号
	 */
	public String getEcoEstimateFlg() {
		return ecoEstimateFlg;
	}
	/**
	 * 设置：环评文号
	 */
	public void setEcoLicence(String ecoLicence) {
		this.ecoLicence = ecoLicence;
	}
	/**
	 * 获取：环评文号
	 */
	public String getEcoLicence() {
		return ecoLicence;
	}
	/**
	 * 设置：是够属于园区
	 */
	public void setParkFlg(String parkFlg) {
		this.parkFlg = parkFlg;
	}
	/**
	 * 获取：是够属于园区
	 */
	public String getParkFlg() {
		return parkFlg;
	}
	/**
	 * 设置：是否有环保制度
	 */
	public void setEcoStandardFlg(String ecoStandardFlg) {
		this.ecoStandardFlg = ecoStandardFlg;
	}
	/**
	 * 获取：是否有环保制度
	 */
	public String getEcoStandardFlg() {
		return ecoStandardFlg;
	}
	/**
	 * 设置：行业类别code
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	/**
	 * 获取：行业类别code
	 */
	public String getIndustryCode() {
		return industryCode;
	}
	/**
	 * 设置：项目管理类别code
	 */
	public void setProjectManageCode(String projectManageCode) {
		this.projectManageCode = projectManageCode;
	}
	/**
	 * 获取：项目管理类别code
	 */
	public String getProjectManageCode() {
		return projectManageCode;
	}
	/**
	 * 设置：是否竣工验收
	 */
	public void setIsOrNotAcceptance(String isOrNotAcceptance) {
		this.isOrNotAcceptance = isOrNotAcceptance;
	}
	/**
	 * 获取：是否竣工验收
	 */
	public String getIsOrNotAcceptance() {
		return isOrNotAcceptance;
	}
	/**
	 * 设置：排污许可管理类别
	 */
	public void setTradablePermitsCode(String tradablePermitsCode) {
		this.tradablePermitsCode = tradablePermitsCode;
	}
	/**
	 * 获取：排污许可管理类别
	 */
	public String getTradablePermitsCode() {
		return tradablePermitsCode;
	}
	/**
	 * 设置：是否核发排污许可证
	 */
	public void setPollutionLicenseFlg(String pollutionLicenseFlg) {
		this.pollutionLicenseFlg = pollutionLicenseFlg;
	}
	/**
	 * 获取：是否核发排污许可证
	 */
	public String getPollutionLicenseFlg() {
		return pollutionLicenseFlg;
	}
	/**
	 * 设置：污染类别
	 */
	public void setPollutionCategoryCode(String pollutionCategoryCode) {
		this.pollutionCategoryCode = pollutionCategoryCode;
	}
	/**
	 * 获取：污染类别
	 */
	public String getPollutionCategoryCode() {
		return pollutionCategoryCode;
	}
	/**
	 * 设置：年检监测是否有效
	 */
	public void setAnnualInspectionFlg(String annualInspectionFlg) {
		this.annualInspectionFlg = annualInspectionFlg;
	}
	/**
	 * 获取：年检监测是否有效
	 */
	public String getAnnualInspectionFlg() {
		return annualInspectionFlg;
	}
	/**
	 * 设置：所在区域
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * 获取：所在区域
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * 设置：主要能源
	 */
	public void setMainEnergyCode(String mainEnergyCode) {
		this.mainEnergyCode = mainEnergyCode;
	}
	/**
	 * 获取：主要能源
	 */
	public String getMainEnergyCode() {
		return mainEnergyCode;
	}
	/**
	 * 设置：污染治理措施
	 */
	public void setMeasures(String measures) {
		this.measures = measures;
	}
	/**
	 * 获取：污染治理措施
	 */
	public String getMeasures() {
		return measures;
	}
	/**
	 * 设置：常规因子
	 */
	public void setNormalFactorsCode(String normalFactorsCode) {
		this.normalFactorsCode = normalFactorsCode;
	}
	/**
	 * 获取：常规因子
	 */
	public String getNormalFactorsCode() {
		return normalFactorsCode;
	}
	/**
	 * 设置：特征因子
	 */
	public void setSpecialFactorsCode(String specialFactorsCode) {
		this.specialFactorsCode = specialFactorsCode;
	}
	/**
	 * 获取：特征因子
	 */
	public String getSpecialFactorsCode() {
		return specialFactorsCode;
	}
	/**
	 * 设置：一般固体废物
	 */
	public void setNomalWaste(String nomalWaste) {
		this.nomalWaste = nomalWaste;
	}
	/**
	 * 获取：一般固体废物
	 */
	public String getNomalWaste() {
		return nomalWaste;
	}
	/**
	 * 设置：危险废物
	 */
	public void setDangerWaste(String dangerWaste) {
		this.dangerWaste = dangerWaste;
	}
	/**
	 * 获取：危险废物
	 */
	public String getDangerWaste() {
		return dangerWaste;
	}
	/**
	 * 设置：被调查人姓名
	 */
	public void setSurveytedPersonName(String surveytedPersonName) {
		this.surveytedPersonName = surveytedPersonName;
	}
	/**
	 * 获取：被调查人姓名
	 */
	public String getSurveytedPersonName() {
		return surveytedPersonName;
	}
	/**
	 * 设置：被调查人职务
	 */
	public void setSurveytedPersonPosition(String surveytedPersonPosition) {
		this.surveytedPersonPosition = surveytedPersonPosition;
	}
	/**
	 * 获取：被调查人职务
	 */
	public String getSurveytedPersonPosition() {
		return surveytedPersonPosition;
	}
	/**
	 * 设置：填表日期
	 */
	public void setFullFormTime(Date fullFormTime) {
		this.fullFormTime = fullFormTime;
	}
	/**
	 * 获取：填表日期
	 */
	public Date getFullFormTime() {
		return fullFormTime;
	}
	/**
	 * 设置：调查人
	 */
	public void setSurveyPersonName(String surveyPersonName) {
		this.surveyPersonName = surveyPersonName;
	}
	/**
	 * 获取：调查人
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


	public Integer getEnvirProtectionId() {
		return envirProtectionId;
	}

	public void setEnvirProtectionId(Integer envirProtectionId) {
		this.envirProtectionId = envirProtectionId;
	}
}
