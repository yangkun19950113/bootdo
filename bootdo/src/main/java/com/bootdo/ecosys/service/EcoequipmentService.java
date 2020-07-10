package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.EcoequipmentDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public interface EcoequipmentService {
	
	EcoequipmentDO get(Integer equipmentId);
	
	List<EcoequipmentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EcoequipmentDO ecoequipment);
	
	int update(EcoequipmentDO ecoequipment);
	
	int remove(Integer equipmentId);
	
	int batchRemove(Integer[] equipmentIds);
	EcoequipmentDO getData(Integer enterpriseId);
}
