package com.bootdo.ecosys.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.ElectricDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
@Mapper
public interface ElectricDao {

	ElectricDO get(Integer equipmentId);
	ElectricDO getData(Integer enterpriseId);
	
	List<ElectricDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ElectricDO electric);
	
	int update(ElectricDO electric);
	
	int remove(Integer equipment_id);
	
	int batchRemove(Integer[] equipmentIds);
}
