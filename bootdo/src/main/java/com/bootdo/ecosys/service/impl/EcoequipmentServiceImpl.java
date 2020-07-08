package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.EcoequipmentDao;
import com.bootdo.ecosys.domain.EcoequipmentDO;
import com.bootdo.ecosys.service.EcoequipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class EcoequipmentServiceImpl implements EcoequipmentService {
	@Autowired
	private EcoequipmentDao ecoequipmentDao;
	
	@Override
	public EcoequipmentDO get(Integer equipmentId){
		return ecoequipmentDao.get(equipmentId);
	}
	
	@Override
	public List<EcoequipmentDO> list(Map<String, Object> map){
		return ecoequipmentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ecoequipmentDao.count(map);
	}
	
	@Override
	public int save(EcoequipmentDO ecoequipment){
		return ecoequipmentDao.save(ecoequipment);
	}
	
	@Override
	public int update(EcoequipmentDO ecoequipment){
		return ecoequipmentDao.update(ecoequipment);
	}
	
	@Override
	public int remove(Integer equipmentId){
		return ecoequipmentDao.remove(equipmentId);
	}
	
	@Override
	public int batchRemove(Integer[] equipmentIds){
		return ecoequipmentDao.batchRemove(equipmentIds);
	}
	
}
