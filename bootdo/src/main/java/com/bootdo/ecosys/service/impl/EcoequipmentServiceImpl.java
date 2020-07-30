package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.EcoequipmentDao;
import com.bootdo.ecosys.domain.EcoequipmentDO;
import com.bootdo.ecosys.domain.ProductDO;
import com.bootdo.ecosys.service.EcoequipmentService;
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
public class EcoequipmentServiceImpl implements EcoequipmentService {
	@Autowired
	private EcoequipmentDao ecoequipmentDao;
	
	@Override
	public EcoequipmentDO get(Integer equipmentId){
		return ecoequipmentDao.get(equipmentId);
	}
	
	@Override
	public List<EcoequipmentDO> list(Map<String, Object> map){
		return ecoequipmentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ecoequipmentDao.count(map);
	}
	
	@Override
	public int save(EcoequipmentDO ecoequipment){
		return ecoequipmentDao.save(ecoequipment);
	}
	
	@Override
	public int update(EcoequipmentDO ecoequipment){
		return ecoequipmentDao.update(ecoequipment);
	}
	
	@Override
	public int remove(Integer equipmentId){
		return ecoequipmentDao.remove(equipmentId);
	}
	
	@Override
	public int batchRemove(Integer[] equipmentIds){
		return ecoequipmentDao.batchRemove(equipmentIds);
	}

	@Override
	public EcoequipmentDO getData(Integer enterpriseId) {
		return ecoequipmentDao.getData(enterpriseId);
	}

	@Override
	public void showExcelInfo(List<EcoequipmentDO> ecoequipmentList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(ecoequipmentList.size() > 0){
			dataMap = convertData(ecoequipmentList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\产污防治信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\产污防治基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<EcoequipmentDO> ecoequipmentList) {
		Map<String,String> dataMap = new HashMap<>();

		EcoequipmentDO firstEcoequipmentDO = ecoequipmentList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstEcoequipmentDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstEcoequipmentDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstEcoequipmentDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstEcoequipmentDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);
		// 企业名称
		dataMap.put("enterpriseName",firstEcoequipmentDO.getEnterpriseName());
		// 设备负责人
		dataMap.put("protectionPerson",firstEcoequipmentDO.getProtectionPerson());
		// 联系电话
		dataMap.put("phoneNumber",firstEcoequipmentDO.getPhoneNumber());


		// 数据循环写入
		for(int i = 0; i < ecoequipmentList.size(); i++){
			EcoequipmentDO currEcoequipmentDO = ecoequipmentList.get(i);
			// 生产设备名称
			dataMap.put("equipName" + i,currEcoequipmentDO.getEquipmentName());
			// 对应产污环节名称
			dataMap.put("polluName" + i,currEcoequipmentDO.getPollutionName());
			// 污染物种类
			dataMap.put("polluType" + i,currEcoequipmentDO.getPollutionType());
			// 排放形式
			dataMap.put("emissionWay" + i,currEcoequipmentDO.getEmissionWay());
			// 安装时间
			dataMap.put("installTime" + i,sdf.format(currEcoequipmentDO.getInstallTime()));
			// 监测时间
			dataMap.put("monitTime" + i,sdf.format(currEcoequipmentDO.getMonitTime()));
			// 维护周期
			dataMap.put("cycle" + i,currEcoequipmentDO.getMaintenanceCycle());
			// 易损耗材
			dataMap.put("lossMat" + i,currEcoequipmentDO.getLossMaterial());

		}

		return dataMap;
	}

}
