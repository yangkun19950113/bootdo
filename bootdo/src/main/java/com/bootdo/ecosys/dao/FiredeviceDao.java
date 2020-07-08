package com.bootdo.ecosys.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.FiredeviceDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
@Mapper
public interface FiredeviceDao {

	FiredeviceDO get(Integer equipmentId);
	
	List<FiredeviceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FiredeviceDO firedevice);
	
	int update(FiredeviceDO firedevice);
	
	int remove(Integer equipment_id);
	
	int batchRemove(Integer[] equipmentIds);
}
