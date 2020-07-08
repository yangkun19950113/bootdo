package com.bootdo.ecosys.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.DangersourceDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
@Mapper
public interface DangersourceDao {

	DangersourceDO get(Integer dangerSourceId);
	
	List<DangersourceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DangersourceDO dangersource);
	
	int update(DangersourceDO dangersource);
	
	int remove(Integer danger_source_id);
	
	int batchRemove(Integer[] dangerSourceIds);
}
