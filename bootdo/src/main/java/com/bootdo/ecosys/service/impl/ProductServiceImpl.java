package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.ProductDao;
import com.bootdo.ecosys.domain.ProductDO;
import com.bootdo.ecosys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Override
	public ProductDO get(Integer productId){
		return productDao.get(productId);
	}
	
	@Override
	public List<ProductDO> list(Map<String, Object> map){
		return productDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productDao.count(map);
	}
	
	@Override
	public int save(ProductDO product){
		return productDao.save(product);
	}
	
	@Override
	public int update(ProductDO product){
		return productDao.update(product);
	}
	
	@Override
	public int remove(Integer productId){
		return productDao.remove(productId);
	}
	
	@Override
	public int batchRemove(Integer[] productIds){
		return productDao.batchRemove(productIds);
	}

	@Override
	public ProductDO getData(Integer enterpriseId) {
		return productDao.getData(enterpriseId);
	}

}
