package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.MaterialDao;
import com.bootdo.ecosys.domain.MaterialDO;
import com.bootdo.ecosys.domain.ProductDO;
import com.bootdo.ecosys.service.MaterialService;
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
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialDao materialDao;
	
	@Override
	public MaterialDO get(Integer materialId){
		return materialDao.get(materialId);
	}
	
	@Override
	public List<MaterialDO> list(Map<String, Object> map){
		return materialDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return materialDao.count(map);
	}
	
	@Override
	public int save(MaterialDO material){
		return materialDao.save(material);
	}
	
	@Override
	public int update(MaterialDO material){
		return materialDao.update(material);
	}
	
	@Override
	public int remove(Integer materialId){
		return materialDao.remove(materialId);
	}
	
	@Override
	public int batchRemove(Integer[] materialIds){
		return materialDao.batchRemove(materialIds);
	}

	@Override
	public MaterialDO getData(Integer enterpriseId) {
		return materialDao.getData(enterpriseId);
	}

	@Override
	public void showExcelInfo(List<MaterialDO> materialList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(materialList.size() > 0){
			dataMap = convertData(materialList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\原材料信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\原材料基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<MaterialDO> materialList) {
		Map<String,String> dataMap = new HashMap<>();

		MaterialDO firstMaterialDO = materialList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstMaterialDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstMaterialDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstMaterialDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstMaterialDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		// 数据循环写入
		for(int i = 0; i < materialList.size(); i++){
			MaterialDO currMaterialDO = materialList.get(i);
			// 类型
			String matTypeCode = currMaterialDO.getMaterialType();
			String matTypeContent = "";
			if(matTypeCode.equals("0")) {
				matTypeContent = "原材料";
			} else if(matTypeCode.equals("1")){
				matTypeContent = "辅料";
			}
			dataMap.put("matType" + i, matTypeContent);
			// 名称
			dataMap.put("matName" + i,currMaterialDO.getMaterialName());
			// 规格
			dataMap.put("specifical" + i,currMaterialDO.getSpecifical());
			// 进货渠道
			dataMap.put("orgionWay" + i,currMaterialDO.getOrgionWay());
			// 月使用量
			String monthConsumptionContent = currMaterialDO.getMonthConsumption();
			dataMap.put("monConsum" + i,monthConsumptionContent);
			// 有毒有害物质
			dataMap.put("danMat" + i,currMaterialDO.getDangerMaterial());
			// 含量
			dataMap.put("content" + i,currMaterialDO.getContent());

		}

		return dataMap;
	}


}
