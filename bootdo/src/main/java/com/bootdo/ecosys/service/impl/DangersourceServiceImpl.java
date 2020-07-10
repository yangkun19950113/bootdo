package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.DangersourceDao;
import com.bootdo.ecosys.domain.DangersourceDO;
import com.bootdo.ecosys.service.DangersourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class DangersourceServiceImpl implements DangersourceService {
	@Autowired
	private DangersourceDao dangersourceDao;
	
	@Override
	public DangersourceDO get(Integer dangerSourceId){
		return dangersourceDao.get(dangerSourceId);
	}

	@Override
	public DangersourceDO getData(Integer enterpriseId) {
		return dangersourceDao.getData(enterpriseId);
	}

	@Override
	public List<DangersourceDO> list(Map<String, Object> map){
		return dangersourceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dangersourceDao.count(map);
	}
	
	@Override
	public int save(DangersourceDO dangersource){
		return dangersourceDao.save(dangersource);
	}
	
	@Override
	public int update(DangersourceDO dangersource){
		return dangersourceDao.update(dangersource);
	}
	
	@Override
	public int remove(Integer dangerSourceId){
		return dangersourceDao.remove(dangerSourceId);
	}
	
	@Override
	public int batchRemove(Integer[] dangerSourceIds){
		return dangersourceDao.batchRemove(dangerSourceIds);
	}
	
}
