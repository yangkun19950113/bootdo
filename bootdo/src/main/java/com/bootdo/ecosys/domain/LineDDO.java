package com.bootdo.ecosys.domain;

import java.io.Serializable;
import java.util.List;


/**
 * 数据字典表
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public class LineDDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String [] yearList;

	private List<LineDO> lineList;

	public String[] getYearList() {
		return yearList;
	}

	public void setYearList(String[] yearList) {
		this.yearList = yearList;
	}

	public List<LineDO> getLineList() {
		return lineList;
	}

	public void setLineList(List<LineDO> lineList) {
		this.lineList = lineList;
	}
}
