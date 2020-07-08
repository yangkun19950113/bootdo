package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.MaterialDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public interface MaterialService {
	
	MaterialDO get(Integer materialId);
	
	List<MaterialDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MaterialDO material);
	
	int update(MaterialDO material);
	
	int remove(Integer materialId);
	
	int batchRemove(Integer[] materialIds);
}