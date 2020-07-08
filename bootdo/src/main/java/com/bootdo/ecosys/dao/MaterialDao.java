package com.bootdo.ecosys.dao;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.MaterialDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
@Mapper
public interface MaterialDao {

	MaterialDO get(Integer materialId);
	
	List<MaterialDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MaterialDO material);
	
	int update(MaterialDO material);
	
	int remove(Integer material_id);
	
	int batchRemove(Integer[] materialIds);
}
