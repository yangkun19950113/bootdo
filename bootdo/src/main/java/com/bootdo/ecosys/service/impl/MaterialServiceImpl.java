package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.MaterialDao;
import com.bootdo.ecosys.domain.MaterialDO;
import com.bootdo.ecosys.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialDao materialDao;
	
	@Override
	public MaterialDO get(Integer materialId){
		return materialDao.get(materialId);
	}
	
	@Override
	public List<MaterialDO> list(Map<String, Object> map){
		return materialDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return materialDao.count(map);
	}
	
	@Override
	public int save(MaterialDO material){
		return materialDao.save(material);
	}
	
	@Override
	public int update(MaterialDO material){
		return materialDao.update(material);
	}
	
	@Override
	public int remove(Integer materialId){
		return materialDao.remove(materialId);
	}
	
	@Override
	public int batchRemove(Integer[] materialIds){
		return materialDao.batchRemove(materialIds);
	}
	
}
