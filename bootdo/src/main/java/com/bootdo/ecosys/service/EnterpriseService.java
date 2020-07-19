package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.CommonDO;
import com.bootdo.ecosys.domain.EnterpriseDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public interface EnterpriseService {
	
	EnterpriseDO get(Integer enterpriseId);
	
	List<EnterpriseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EnterpriseDO enterprise);
	
	int update(EnterpriseDO enterprise);
	
	int remove(Integer enterpriseId);
	
	int batchRemove(Integer[] enterpriseIds);

	EnterpriseDO getenterprise (String  enterpriseName,String socialCreditCode);

	List<CommonDO> loadEnterpriseProportion(Map<String, Object> params);

	List<CommonDO> loadEnterpriseNatureCode(Map<String, Object> params);

	List<CommonDO> loadPollutionCode(Map<String, Object> params);

	List<EnterpriseDO> enterpriseHigh(Map<String, Object> params);

	EnterpriseDO getenterprise (String  enterpriseName,String socialCreditCode,Integer enterpriseId);

	List<EnterpriseDO> fireEquipHigh(Map<String, Object> params);

	List<EnterpriseDO> getEnterpriselist(Map<String, Object> params);

	double getEnvprotectionChart(Map<String, Object> params);

}
