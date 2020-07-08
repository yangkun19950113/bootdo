package com.bootdo.ecosys.service;

import com.bootdo.ecosys.domain.ElectricDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public interface ElectricService {
	
	ElectricDO get(Integer equipmentId);
	
	List<ElectricDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ElectricDO electric);
	
	int update(ElectricDO electric);
	
	int remove(Integer equipmentId);
	
	int batchRemove(Integer[] equipmentIds);
}
