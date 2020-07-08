package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.ElectricDao;
import com.bootdo.ecosys.domain.ElectricDO;
import com.bootdo.ecosys.service.ElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class ElectricServiceImpl implements ElectricService {
	@Autowired
	private ElectricDao electricDao;
	
	@Override
	public ElectricDO get(Integer equipmentId){
		return electricDao.get(equipmentId);
	}
	
	@Override
	public List<ElectricDO> list(Map<String, Object> map){
		return electricDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return electricDao.count(map);
	}
	
	@Override
	public int save(ElectricDO electric){
		return electricDao.save(electric);
	}
	
	@Override
	public int update(ElectricDO electric){
		return electricDao.update(electric);
	}
	
	@Override
	public int remove(Integer equipmentId){
		return electricDao.remove(equipmentId);
	}
	
	@Override
	public int batchRemove(Integer[] equipmentIds){
		return electricDao.batchRemove(equipmentIds);
	}
	
}
