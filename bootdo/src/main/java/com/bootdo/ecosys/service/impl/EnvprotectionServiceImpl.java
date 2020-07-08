package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.EnvprotectionDao;
import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.service.EnvprotectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class EnvprotectionServiceImpl implements EnvprotectionService {
	@Autowired
	private EnvprotectionDao envprotectionDao;
	
	@Override
	public EnvprotectionDO get(Integer envirProtectionId){
		return envprotectionDao.get(envirProtectionId);
	}
	
	@Override
	public List<EnvprotectionDO> list(Map<String, Object> map){
		return envprotectionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return envprotectionDao.count(map);
	}
	
	@Override
	public int save(EnvprotectionDO envprotection){
		return envprotectionDao.save(envprotection);
	}
	
	@Override
	public int update(EnvprotectionDO envprotection){
		return envprotectionDao.update(envprotection);
	}
	
	@Override
	public int remove(Integer envirProtectionId){
		return envprotectionDao.remove(envirProtectionId);
	}
	
	@Override
	public int batchRemove(Integer[] envirProtectionIds){
		return envprotectionDao.batchRemove(envirProtectionIds);
	}
	
}
