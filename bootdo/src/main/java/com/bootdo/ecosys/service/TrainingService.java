package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.TrainingDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public interface TrainingService {
	
	TrainingDO get(Integer trainingId);
	TrainingDO getData(Integer enterpriseId);
	
	List<TrainingDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TrainingDO training);
	
	int update(TrainingDO training);
	
	int remove(Integer trainingId);
	
	int batchRemove(Integer[] trainingIds);
}
