package com.bootdo.ecosys.service;

import com.bootdo.ecosys.domain.RiskDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public interface RiskService {
	
	RiskDO get(Integer safeTroubleId);
	
	List<RiskDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RiskDO risk);
	
	int update(RiskDO risk);
	
	int remove(Integer safeTroubleId);
	
	int batchRemove(Integer[] safeTroubleIds);
}