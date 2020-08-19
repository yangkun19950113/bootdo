package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.*;

import java.io.FileNotFoundException;
import java.io.IOException;
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



	List<CommonDO> loadEnterpriseProportion(Map<String, Object> params);

	List<CommonDO> loadEnterpriseNatureCode(Map<String, Object> params);

	List<CommonDO> loadPollutionCode(Map<String, Object> params);

	List<EnterpriseDO> enterpriseHigh(Map<String, Object> params);

	EnterpriseDO getenterprise (String  enterpriseName,String socialCreditCode,Integer enterpriseId);

	List<EnterpriseDO> fireEquipHigh(Map<String, Object> params);

	List<EnterpriseDO> getEnterpriselist(Map<String, Object> params);

	double getEnvprotectionChart(Map<String, Object> params);

	List<FiredeviceDO> getEffectFireEquip(Map<String, Object> params);
	List<EcoequipmentDO> getEecoequipment(Map<String, Object> params);

	List<DangersourceDO> getDangerData(Map<String, Object> params);

	void showExcelInfo(EnterpriseDO enterprise) throws IOException;


}
