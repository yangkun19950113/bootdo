package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.RiskDao;
import com.bootdo.ecosys.domain.RiskDO;
import com.bootdo.ecosys.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class RiskServiceImpl implements RiskService {
	@Autowired
	private RiskDao riskDao;
	
	@Override
	public RiskDO get(Integer safeTroubleId){
		return riskDao.get(safeTroubleId);
	}

	@Override
	public RiskDO getData(Integer enterpriseId) {
		return riskDao.getData(enterpriseId);
	}

	@Override
	public List<RiskDO> list(Map<String, Object> map){
		return riskDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return riskDao.count(map);
	}
	
	@Override
	public int save(RiskDO risk){
		return riskDao.save(risk);
	}
	
	@Override
	public int update(RiskDO risk){
		return riskDao.update(risk);
	}
	
	@Override
	public int remove(Integer safeTroubleId){
		return riskDao.remove(safeTroubleId);
	}
	
	@Override
	public int batchRemove(Integer[] safeTroubleIds){
		return riskDao.batchRemove(safeTroubleIds);
	}
	
}
