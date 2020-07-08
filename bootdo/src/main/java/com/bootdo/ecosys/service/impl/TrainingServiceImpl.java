package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.TrainingDao;
import com.bootdo.ecosys.domain.TrainingDO;
import com.bootdo.ecosys.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class TrainingServiceImpl implements TrainingService {
	@Autowired
	private TrainingDao trainingDao;
	
	@Override
	public TrainingDO get(Integer trainingId){
		return trainingDao.get(trainingId);
	}
	
	@Override
	public List<TrainingDO> list(Map<String, Object> map){
		return trainingDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return trainingDao.count(map);
	}
	
	@Override
	public int save(TrainingDO training){
		return trainingDao.save(training);
	}
	
	@Override
	public int update(TrainingDO training){
		return trainingDao.update(training);
	}
	
	@Override
	public int remove(Integer trainingId){
		return trainingDao.remove(trainingId);
	}
	
	@Override
	public int batchRemove(Integer[] trainingIds){
		return trainingDao.batchRemove(trainingIds);
	}
	
}
