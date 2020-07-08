package com.bootdo.ecosys.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.RiskDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
@Mapper
public interface RiskDao {

	RiskDO get(Integer safeTroubleId);
	
	List<RiskDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RiskDO risk);
	
	int update(RiskDO risk);
	
	int remove(Integer safe_trouble_id);
	
	int batchRemove(Integer[] safeTroubleIds);
}
