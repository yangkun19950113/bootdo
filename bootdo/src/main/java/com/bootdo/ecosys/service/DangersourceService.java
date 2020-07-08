package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.DangersourceDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public interface DangersourceService {
	
	DangersourceDO get(Integer dangerSourceId);
	
	List<DangersourceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DangersourceDO dangersource);
	
	int update(DangersourceDO dangersource);
	
	int remove(Integer dangerSourceId);
	
	int batchRemove(Integer[] dangerSourceIds);
}
