package com.bootdo.ecosys.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EnvprotectionDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
@Mapper
public interface EnvprotectionDao {

	EnvprotectionDO get(Integer envirProtectionId);
	
	List<EnvprotectionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EnvprotectionDO envprotection);
	
	int update(EnvprotectionDO envprotection);
	
	int remove(Integer envirProtectionId);
	
	int batchRemove(Integer[] envirProtectionIds);
	EnvprotectionDO getData(Integer envirProtectionId);
}
