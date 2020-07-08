package com.bootdo.ecosys.service;


import com.bootdo.ecosys.domain.CodeDO;

import java.util.List;
import java.util.Map;

/**
 * 数据字典表
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
public interface CodeService {
	
	CodeDO get(Long id);
	
	List<CodeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CodeDO code);
	
	int update(CodeDO code);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
