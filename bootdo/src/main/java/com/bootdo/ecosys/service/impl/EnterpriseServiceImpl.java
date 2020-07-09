package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.EnterpriseDao;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class EnterpriseServiceImpl implements EnterpriseService {
	@Autowired
	private EnterpriseDao enterpriseDao;
	
	@Override
	public EnterpriseDO get(Integer enterpriseId){
		return enterpriseDao.get(enterpriseId);
	}
	
	@Override
	public List<EnterpriseDO> list(Map<String, Object> map){
		return enterpriseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return enterpriseDao.count(map);
	}
	
	@Override
	public int save(EnterpriseDO enterprise){
		return enterpriseDao.save(enterprise);
	}
	
	@Override
	public int update(EnterpriseDO enterprise){
		return enterpriseDao.update(enterprise);
	}
	
	@Override
	public int remove(Integer enterpriseId){
		EnterpriseDO enterpriseDO = enterpriseDao.get(enterpriseId);
		EnterpriseDO enterpriseUpdate = new EnterpriseDO();
		enterpriseUpdate.setDeleteFlag("1");
		enterpriseUpdate.setEnterpriseId(enterpriseId);
		return enterpriseDao.update(enterpriseUpdate);

		/*return enterpriseDao.remove(enterpriseId);*/
	}
	
	@Override
	public int batchRemove(Integer[] enterpriseIds){
		return enterpriseDao.batchRemove(enterpriseIds);
	}

	@Override
	public EnterpriseDO getenterprise(String enterpriseName) {
		return enterpriseDao.getenterprise(enterpriseName);
	}

}
