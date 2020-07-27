package com.bootdo.ecosys.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.CodeDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 数据字典表
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
@Mapper
public interface CodeDao {

	CodeDO get(Long id);
	
	List<CodeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CodeDO code);
	
	int update(CodeDO code);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	CodeDO getName(@Param("codeId") String  codeId, @Param("parentId")String parentId);

	List<CodeDO> listSon(Map<String, Object> map);

	CodeDO getCode(Map<String, Object> map);

	List<CodeDO> getList(Map<String, Object> map);

	List<CodeDO> getListByIds(Map<String, Object> map);
}
