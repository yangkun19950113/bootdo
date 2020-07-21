package com.bootdo.ecosys.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.CommonDO;
import com.bootdo.ecosys.domain.DangersourceDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.FiredeviceDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
@Mapper
public interface EnterpriseDao {

	EnterpriseDO get(Integer enterpriseId);

	List<EnterpriseDO> getCoordinates(@Param("administrativeDivision") String administrativeDivision,@Param("country")  String country);
	EnterpriseDO getdatabycoordinates(String coordinates);

	List<EnterpriseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EnterpriseDO enterprise);
	
	int update(EnterpriseDO enterprise);
	
	int remove(Integer enterprise_id);
	
	int batchRemove(Integer[] enterpriseIds);

	List<EnterpriseDO>getListByAdminStr(Map<String, Object> map);

	List<CommonDO> loadEnterpriseNatureCode(Map<String, Object> params);
	//查询最近五年的企业
	List<EnterpriseDO> getEnterpriseFive(Map<String, Object> map);

	EnterpriseDO getenterprise (@Param("enterpriseName") String  enterpriseName,@Param("socialCreditCode") String socialCreditCode,@Param("enterpriseId")Integer enterpriseId);

	List<EnterpriseDO> fireEquipHigh(Map<String, Object> params);

	int getCountEvn(Map<String, Object> map);

	List<FiredeviceDO> getEffectFireEquip(Map<String, Object> params);

	List<DangersourceDO> getDangerData(Map<String, Object> params);
}
