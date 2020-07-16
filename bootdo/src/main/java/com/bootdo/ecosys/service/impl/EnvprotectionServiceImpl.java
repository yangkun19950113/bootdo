package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.CodeDao;
import com.bootdo.ecosys.dao.EnvprotectionDao;
import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.service.EnvprotectionService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Service
public class EnvprotectionServiceImpl implements EnvprotectionService {
	@Autowired
	private EnvprotectionDao envprotectionDao;
	@Autowired
	private CodeDao codeDao;

	
	@Override
	public EnvprotectionDO get(Integer envirProtectionId){
		return envprotectionDao.get(envirProtectionId);
	}
	
	@Override
	public List<EnvprotectionDO> list(Map<String, Object> map){
		List<EnvprotectionDO> list = envprotectionDao.list(map);
		String codeNamelist = "";
		for(int i = 0;i<list.size();i++){
			EnvprotectionDO envprotection = list.get(i);
			String[] ids = envprotection.getIndustryCode().split(",");
			Map<String, Object> map1 = new HashMap<>();
			map1.put("idsArray", ids);
			List<CodeDO> codelist = codeDao.getList(map1);
			if(codelist.size()>0){
				for(int j = 0;j<codelist.size();j++){
					CodeDO code = codelist.get(j);
					codeNamelist = code.getName() + "," + codeNamelist;
				}
			}
			envprotection.setIndustryName(codeNamelist);
		}
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return envprotectionDao.count(map);
	}
	
	@Override
	public int save(EnvprotectionDO envprotection){
		return envprotectionDao.save(envprotection);
	}
	
	@Override
	public int update(EnvprotectionDO envprotection){
		return envprotectionDao.update(envprotection);
	}
	
	@Override
	public int remove(Integer envirProtectionId){
		return envprotectionDao.remove(envirProtectionId);
	}
	
	@Override
	public int batchRemove(Integer[] envirProtectionIds){
		return envprotectionDao.batchRemove(envirProtectionIds);
	}

	@Override
	public EnvprotectionDO getData(Integer enterpriseId) {
		return envprotectionDao.getData(enterpriseId);
	}

}
