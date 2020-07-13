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
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//产品id
	private Integer productId;
	//企业id
	private Integer enterpriseId;
	//企业名称
	private String enterpriseName;
	//产品名称
	private String prodectName;
	//规格
	private String specifical;
	//型号
	private String model;
	//生产工艺
	private String produtProcess;
	//产品参数
	private String prodectParam;
	//最低价格
	private String minPrice;
	//最高价格
	private BigDecimal maxPrice;
	//设备名称
	private String deviceName;
	//月产量
	private BigDecimal monthProduction;
	//功能作用
	private String functionRemark;
	//备注
	private String remark;
	//被调查人姓名
	private String surveytedPersonName;
	//被调查人职位
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
	private String productMinImgUrl;

	public String getProductMinImgUrl() {
		return productMinImgUrl;
	}

	public void setProductMinImgUrl(String productMinImgUrl) {
		this.productMinImgUrl = productMinImgUrl;
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
	 * 设置：产品名称
	 */
	public void setProdectName(String prodectName) {
		this.prodectName = prodectName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProdectName() {
		return prodectName;
	}
	/**
	 * 设置：规格
	 */
	public void setSpecifical(String specifical) {
		this.specifical = specifical;
	}
	/**
	 * 获取：规格
	 */
	public String getSpecifical() {
		return specifical;
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
	 * 设置：生产工艺
	 */
	public void setProdutProcess(String produtProcess) {
		this.produtProcess = produtProcess;
	}
	/**
	 * 获取：生产工艺
	 */
	public String getProdutProcess() {
		return produtProcess;
	}
	/**
	 * 设置：产品参数
	 */
	public void setProdectParam(String prodectParam) {
		this.prodectParam = prodectParam;
	}
	/**
	 * 获取：产品参数
	 */
	public String getProdectParam() {
		return prodectParam;
	}
	/**
	 * 设置：最低价格
	 */
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	/**
	 * 获取：最低价格
	 */
	public String getMinPrice() {
		return minPrice;
	}
	/**
	 * 设置：最高价格
	 */
	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	/**
	 * 获取：最高价格
	 */
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}
	/**
	 * 设置：设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 设置：月产量
	 */
	public void setMonthProduction(BigDecimal monthProduction) {
		this.monthProduction = monthProduction;
	}
	/**
	 * 获取：月产量
	 */
	public BigDecimal getMonthProduction() {
		return monthProduction;
	}
	/**
	 * 设置：功能作用
	 */
	public void setFunctionRemark(String functionRemark) {
		this.functionRemark = functionRemark;
	}
	/**
	 * 获取：功能作用
	 */
	public String getFunctionRemark() {
		return functionRemark;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：被调查人职位
	 */
	public void setSurveytedPersonPosition(String surveytedPersonPosition) {
		this.surveytedPersonPosition = surveytedPersonPosition;
	}
	/**
	 * 获取：被调查人职位
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
}
