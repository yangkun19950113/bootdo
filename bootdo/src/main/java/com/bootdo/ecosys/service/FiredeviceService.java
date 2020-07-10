package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.FiredeviceDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public interface FiredeviceService {
	
	FiredeviceDO get(Integer equipmentId);
	FiredeviceDO getData(Integer enterpriseId);
	
	List<FiredeviceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FiredeviceDO firedevice);
	
	int update(FiredeviceDO firedevice);
	
	int remove(Integer equipmentId);
	
	int batchRemove(Integer[] equipmentIds);
}
