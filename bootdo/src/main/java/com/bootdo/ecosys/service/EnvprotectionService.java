package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.EnvprotectionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public interface EnvprotectionService {
	
	EnvprotectionDO get(Integer envirProtectionId);
	
	List<EnvprotectionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EnvprotectionDO envprotection);
	
	int update(EnvprotectionDO envprotection);
	
	int remove(Integer envirProtectionId);
	
	int batchRemove(Integer[] envirProtectionIds);
	EnvprotectionDO getData(Integer enterpriseId);
}
