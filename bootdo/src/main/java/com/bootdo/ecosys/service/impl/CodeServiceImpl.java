package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.CodeDao;
import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class CodeServiceImpl implements CodeService {
	@Autowired
	private CodeDao codeDao;
	
	@Override
	public CodeDO get(Long id){
		return codeDao.get(id);
	}
	
	@Override
	public List<CodeDO> list(Map<String, Object> map){
		return codeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return codeDao.count(map);
	}
	
	@Override
	public int save(CodeDO code){
		return codeDao.save(code);
	}
	
	@Override
	public int update(CodeDO code){
		return codeDao.update(code);
	}
	
	@Override
	public int remove(Long id){
		return codeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return codeDao.batchRemove(ids);
	}
	
}
