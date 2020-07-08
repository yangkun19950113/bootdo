package com.bootdo.ecosys.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 数据字典表
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public class CodeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String codeId;
	//上级部门ID，一级部门为0
	private Long parentId;
	//部门名称
	private String name;
	//排序
	private Integer orderNum;
	//是否删除  -1：已删除  0：正常
	private String delFlag;
	//备用字段1
	private String alternate1;
	//备用字段2
	private String alternate2;
	//备用字段3
	private String alternate3;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	/**
	 * 获取：
	 */
	public String getCodeId() {
		return codeId;
	}
	/**
	 * 设置：上级部门ID，一级部门为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级部门ID，一级部门为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：是否删除  -1：已删除  0：正常
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	public String getDelFlag() {
		return delFlag;
	}
	/**
	 * 设置：备用字段1
	 */
	public void setAlternate1(String alternate1) {
		this.alternate1 = alternate1;
	}
	/**
	 * 获取：备用字段1
	 */
	public String getAlternate1() {
		return alternate1;
	}
	/**
	 * 设置：备用字段2
	 */
	public void setAlternate2(String alternate2) {
		this.alternate2 = alternate2;
	}
	/**
	 * 获取：备用字段2
	 */
	public String getAlternate2() {
		return alternate2;
	}
	/**
	 * 设置：备用字段3
	 */
	public void setAlternate3(String alternate3) {
		this.alternate3 = alternate3;
	}
	/**
	 * 获取：备用字段3
	 */
	public String getAlternate3() {
		return alternate3;
	}
}
