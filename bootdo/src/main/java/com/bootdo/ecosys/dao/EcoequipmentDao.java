package com.bootdo.ecosys.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EcoequipmentDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
@Mapper
public interface EcoequipmentDao {

	EcoequipmentDO get(Integer equipmentId);
	
	List<EcoequipmentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EcoequipmentDO ecoequipment);
	
	int update(EcoequipmentDO ecoequipment);
	
	int remove(Integer equipment_id);
	
	int batchRemove(Integer[] equipmentIds);
}
