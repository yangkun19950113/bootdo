package com.bootdo.ecosys.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EnterpriseDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
@Mapper
public interface EnterpriseDao {

	EnterpriseDO get(Integer enterpriseId);
	
	List<EnterpriseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EnterpriseDO enterprise);
	
	int update(EnterpriseDO enterprise);
	
	int remove(Integer enterprise_id);
	
	int batchRemove(Integer[] enterpriseIds);
}
