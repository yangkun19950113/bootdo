package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.FiredeviceDao;
import com.bootdo.ecosys.domain.FiredeviceDO;
import com.bootdo.ecosys.service.FiredeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class FiredeviceServiceImpl implements FiredeviceService {
	@Autowired
	private FiredeviceDao firedeviceDao;
	
	@Override
	public FiredeviceDO get(Integer equipmentId){
		return firedeviceDao.get(equipmentId);
	}
	
	@Override
	public List<FiredeviceDO> list(Map<String, Object> map){
		return firedeviceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return firedeviceDao.count(map);
	}
	
	@Override
	public int save(FiredeviceDO firedevice){
		return firedeviceDao.save(firedevice);
	}
	
	@Override
	public int update(FiredeviceDO firedevice){
		return firedeviceDao.update(firedevice);
	}
	
	@Override
	public int remove(Integer equipmentId){
		return firedeviceDao.remove(equipmentId);
	}
	
	@Override
	public int batchRemove(Integer[] equipmentIds){
		return firedeviceDao.batchRemove(equipmentIds);
	}
	
}
