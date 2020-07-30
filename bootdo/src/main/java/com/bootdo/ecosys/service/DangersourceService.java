package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.DangersourceDO;
import com.bootdo.ecosys.domain.MaterialDO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public interface DangersourceService {
	
	DangersourceDO get(Integer dangerSourceId);
	DangersourceDO getData(Integer enterpriseId);
	
	List<DangersourceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DangersourceDO dangersource);
	
	int update(DangersourceDO dangersource);
	
	int remove(Integer dangerSourceId);
	
	int batchRemove(Integer[] dangerSourceIds);

	void showExcelInfo(List<DangersourceDO> dangersourceList) throws IOException;
}
