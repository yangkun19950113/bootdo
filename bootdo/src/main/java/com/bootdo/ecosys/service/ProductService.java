package com.bootdo.ecosys.service;

import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.ProductDO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
public interface ProductService {
	
	ProductDO get(Integer productId);
	
	List<ProductDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductDO product);
	
	int update(ProductDO product);
	
	int remove(Integer productId);
	
	int batchRemove(Integer[] productIds);
	ProductDO getData(Integer enterpriseId);

	void showExcelInfo(List<ProductDO> productList) throws IOException;
}
