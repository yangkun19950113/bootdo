package com.bootdo.ecosys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public class EnterpriseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//企业id
	private Integer enterpriseId;
	//企业名称
	private String enterpriseName;
	//社会信用编码
	private String socialCreditCode;
	//注册地址
	private String registeredAddress;
	//注册时间
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date registeredTime;
	//注册资金
	private Float registeredFund;
	//员工数
	private Long employeeNum;
	//企业规模
	private String enterpriseScope;
	//坐标位置
	private String coordinates;
	//企业性质
	private String enterpriseNatureCode;
	//企业法人
	private String enterpriseLegalPerson;
	//法人电话
	private String legalPersonPhoneNumber;
	//环保负责人
	private String environmentalProtectionPerson;
	//环保负责人电话
	private String enPersonPhoneNumber;
	//安全生产责任人
	private String safeProdectPerson;
	//安全生产责任人电话
	private String safePerPhoneNumber;
	//经营范围
	private String businessScope;
	//经营面积
	private Float businessArea;
	//经营场所取得
	private String businessAreaNatureCode;
	//部门设置
	private String dept;
	//纳税人性质
	private String taxpayerCode;
	//互联网营销方式
	private String marketCode;
	//被调查人姓名
	private String surveytedPersonName;
	//被调查人职务
	private String surveytedPersonPosition;
	//填表日期
	private Date fullFormTime;
	//调查人
	private String surveyPersonName;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	//
	private String createUserName;
	//
	private Integer createBy;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifyTime;
	//
	private String modifyUserName;
	//
	private Integer modifyBy;
	//
	private String deleteFlag;
	//行政区划（乡镇）
	private String administrativeDivision;
	//街道（村）
	private String country;
	//城乡分类
	private Integer urbanorrural;

	private String imgUrl;

	private String[] imgUrls;

	private String minImgUrl;

	private String enterpriseNatureName;

	private String year;

	private String num;

	private String month;
	private String marketCodeStr[];

	public String[] getMarketCodeStr() {
		return marketCodeStr;
	}

	public void setMarketCodeStr(String[] marketCodeStr) {
		this.marketCodeStr = marketCodeStr;
	}

	public String getMinImgUrl() {
		return minImgUrl;
	}

	public void setMinImgUrl(String minImgUrl) {
		this.minImgUrl = minImgUrl;
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
	 */
	public Date getRegisteredTime() {
		return registeredTime;
	}
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
	/**
	 * 设置：企业规模
	 */
	public void setEnterpriseScope(String enterpriseScope) {
		this.enterpriseScope = enterpriseScope;
	}
	/**
	 * 获取：企业规模
	 */
	public String getEnterpriseScope() {
		return enterpriseScope;
	}
	/**
	 * 设置：坐标位置
	 */
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	/**
	 * 获取：坐标位置
	 */
	public String getCoordinates() {
		return coordinates;
	}
	/**
	 * 设置：企业性质
	 */
	public void setEnterpriseNatureCode(String enterpriseNatureCode) {
		this.enterpriseNatureCode = enterpriseNatureCode;
	}
	/**
	 * 获取：企业性质
	 */
	public String getEnterpriseNatureCode() {
		return enterpriseNatureCode;
	}
	/**
	 * 设置：企业法人
	 */
	public void setEnterpriseLegalPerson(String enterpriseLegalPerson) {
		this.enterpriseLegalPerson = enterpriseLegalPerson;
	}
	/**
	 * 获取：企业法人
	 */
	public String getEnterpriseLegalPerson() {
		return enterpriseLegalPerson;
	}
	/**
	 * 设置：法人电话
	 */
	public void setLegalPersonPhoneNumber(String legalPersonPhoneNumber) {
		this.legalPersonPhoneNumber = legalPersonPhoneNumber;
	}
	/**
	 * 获取：法人电话
	 */
	public String getLegalPersonPhoneNumber() {
		return legalPersonPhoneNumber;
	}
	/**
	 * 设置：环保负责人
	 */
	public void setEnvironmentalProtectionPerson(String environmentalProtectionPerson) {
		this.environmentalProtectionPerson = environmentalProtectionPerson;
	}
	/**
	 * 获取：环保负责人
	 */
	public String getEnvironmentalProtectionPerson() {
		return environmentalProtectionPerson;
	}
	/**
	 * 设置：环保负责人电话
	 */
	public void setEnPersonPhoneNumber(String enPersonPhoneNumber) {
		this.enPersonPhoneNumber = enPersonPhoneNumber;
	}
	/**
	 * 获取：环保负责人电话
	 */
	public String getEnPersonPhoneNumber() {
		return enPersonPhoneNumber;
	}
	/**
	 * 设置：安全生产责任人
	 */
	public void setSafeProdectPerson(String safeProdectPerson) {
		this.safeProdectPerson = safeProdectPerson;
	}
	/**
	 * 获取：安全生产责任人
	 */
	public String getSafeProdectPerson() {
		return safeProdectPerson;
	}
	/**
	 * 设置：安全生产责任人电话
	 */
	public void setSafePerPhoneNumber(String safePerPhoneNumber) {
		this.safePerPhoneNumber = safePerPhoneNumber;
	}
	/**
	 * 获取：安全生产责任人电话
	 */
	public String getSafePerPhoneNumber() {
		return safePerPhoneNumber;
	}
	/**
	 * 设置：经营范围
	 */
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	/**
	 * 获取：经营范围
	 */
	public String getBusinessScope() {
		return businessScope;
	}
	/**
	 * 设置：经营面积
	 */
	public void setBusinessArea(Float businessArea) {
		this.businessArea = businessArea;
	}
	/**
	 * 获取：经营面积
	 */
	public Float getBusinessArea() {
		return businessArea;
	}
	/**
	 * 设置：经营场所取得
	 */
	public void setBusinessAreaNatureCode(String businessAreaNatureCode) {
		this.businessAreaNatureCode = businessAreaNatureCode;
	}
	/**
	 * 获取：经营场所取得
	 */
	public String getBusinessAreaNatureCode() {
		return businessAreaNatureCode;
	}
	/**
	 * 设置：部门设置
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * 获取：部门设置
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * 设置：纳税人性质
	 */
	public void setTaxpayerCode(String taxpayerCode) {
		this.taxpayerCode = taxpayerCode;
	}
	/**
	 * 获取：纳税人性质
	 */
	public String getTaxpayerCode() {
		return taxpayerCode;
	}
	/**
	 * 设置：互联网营销方式
	 */
	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	/**
	 * 获取：互联网营销方式
	 */
	public String getMarketCode() {
		return marketCode;
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
	public void setAdministrativeDivision(String administrativeDivision) {
		this.administrativeDivision = administrativeDivision;
	}
	/**
	 * 获取：行政区划
	 */
	public String getAdministrativeDivision() {
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEnterpriseNatureName() {
		return enterpriseNatureName;
	}

	public void setEnterpriseNatureName(String enterpriseNatureName) {
		this.enterpriseNatureName = enterpriseNatureName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
}
