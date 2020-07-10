package com.bootdo.ecosys.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.TrainingDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
@Mapper
public interface TrainingDao {

	TrainingDO get(Integer trainingId);
	TrainingDO getData(Integer enterpriseId);
	List<TrainingDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TrainingDO training);
	
	int update(TrainingDO training);
	
	int remove(Integer training_id);
	
	int batchRemove(Integer[] trainingIds);
}
