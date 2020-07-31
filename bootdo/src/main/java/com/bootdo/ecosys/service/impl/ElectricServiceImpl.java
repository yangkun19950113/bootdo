package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.ElectricDao;
import com.bootdo.ecosys.domain.ElectricDO;
import com.bootdo.ecosys.domain.TrainingDO;
import com.bootdo.ecosys.service.ElectricService;
import com.bootdo.tool.InformationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Service
public class ElectricServiceImpl implements ElectricService {
	@Autowired
	private ElectricDao electricDao;
	
	@Override
	public ElectricDO get(Integer equipmentId){
		return electricDao.get(equipmentId);
	}

	@Override
	public ElectricDO getData(Integer enterpriseId) {
		return electricDao.getData(enterpriseId);
	}

	@Override
	public List<ElectricDO> list(Map<String, Object> map){
		return electricDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return electricDao.count(map);
	}
	
	@Override
	public int save(ElectricDO electric){
		return electricDao.save(electric);
	}
	
	@Override
	public int update(ElectricDO electric){
		return electricDao.update(electric);
	}
	
	@Override
	public int remove(Integer equipmentId){
		return electricDao.remove(equipmentId);
	}
	
	@Override
	public int batchRemove(Integer[] equipmentIds){
		return electricDao.batchRemove(equipmentIds);
	}

	@Override
	public void showExcelInfo(List<ElectricDO> electricList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(electricList.size() > 0){
			dataMap = convertData(electricList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\用电设施信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\用电设施基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<ElectricDO> electricList) {
		Map<String,String> dataMap = new HashMap<>();

		ElectricDO firstElectricDO = electricList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstElectricDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstElectricDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstElectricDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstElectricDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		// 数据循环写入
		for(int i = 0; i < electricList.size(); i++){
			ElectricDO currElectricDO = electricList.get(i);
			// 用电设备名称
			dataMap.put("equipmentName" + i, currElectricDO.getEquipmentName());
			// 设备用途
			dataMap.put("equipmentUse" + i, currElectricDO.getEquipmentUse());
			// 用电设备功率kw
			dataMap.put("equipmentPower" + i, currElectricDO.getEquipmentPower());
			// 相数
			dataMap.put("pNum" + i,Integer.toString(currElectricDO.getPhaseNumber()));
			// 台数
			dataMap.put("num" + i,Integer.toString(currElectricDO.getNumber()));
			// 安装位置
			dataMap.put("installPosition" + i, currElectricDO.getInstallPosition());
			// 电缆是否穿管
			String isOrNotThroughContent = currElectricDO.getIsOrNotThrough().equals("0")?"是":"否";
			dataMap.put("isThrough" + i, isOrNotThroughContent);

		}

		return dataMap;
	}


}
