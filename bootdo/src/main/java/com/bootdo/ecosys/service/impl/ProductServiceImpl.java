package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.ProductDao;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.ProductDO;
import com.bootdo.ecosys.service.ProductService;
import com.bootdo.tool.InformationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

	@Override
	public void showExcelInfo(List<ProductDO> productList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(productList.size() > 0){
			dataMap = convertData(productList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\产品及产能信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\产品及产能基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<ProductDO> productList) {
		Map<String,String> dataMap = new HashMap<>();

		ProductDO firstProductDO = productList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstProductDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstProductDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstProductDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstProductDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		// 数据循环写入
		for(int i = 0; i < productList.size(); i++){
			ProductDO currProductDO = productList.get(i);
			// 产品名称
			dataMap.put("prodectName" + i,currProductDO.getProdectName());
			// 规格型号
			dataMap.put("specifical" + i,currProductDO.getSpecifical());
			// 生产工艺
			dataMap.put("produtProcess" + i,currProductDO.getProdutProcess());
			// 产品参数
			dataMap.put("prodectParam" + i,currProductDO.getProdectParam());
			// 价格区间
			dataMap.put("minPrice" + i,currProductDO.getMinPrice());
			// 生产设施
			dataMap.put("deviceName" + i,currProductDO.getDeviceName());
			// 月产量
			BigDecimal monthProductionContent = currProductDO.getMonthProduction();
			dataMap.put("monProduction" + i,monthProductionContent.toString());
			// 功能作用
			dataMap.put("functionRemark" + i,currProductDO.getFunctionRemark());

		}

		return dataMap;
	}

}
