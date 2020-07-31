package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.FiredeviceDao;
import com.bootdo.ecosys.domain.FiredeviceDO;
import com.bootdo.ecosys.domain.RiskDO;
import com.bootdo.ecosys.service.FiredeviceService;
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
public class FiredeviceServiceImpl implements FiredeviceService {
	@Autowired
	private FiredeviceDao firedeviceDao;
	
	@Override
	public FiredeviceDO get(Integer equipmentId){
		return firedeviceDao.get(equipmentId);
	}

	@Override
	public FiredeviceDO getData(Integer enterpriseId) {
		return firedeviceDao.getData(enterpriseId);
	}

	@Override
	public List<FiredeviceDO> list(Map<String, Object> map){
		return firedeviceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return firedeviceDao.count(map);
	}
	
	@Override
	public int save(FiredeviceDO firedevice){
		return firedeviceDao.save(firedevice);
	}
	
	@Override
	public int update(FiredeviceDO firedevice){
		return firedeviceDao.update(firedevice);
	}
	
	@Override
	public int remove(Integer equipmentId){
		return firedeviceDao.remove(equipmentId);
	}
	
	@Override
	public int batchRemove(Integer[] equipmentIds){
		return firedeviceDao.batchRemove(equipmentIds);
	}

	@Override
	public void showExcelInfo(List<FiredeviceDO> firedeviceList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(firedeviceList.size() > 0){
			dataMap = convertData(firedeviceList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\消防设备信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\消防设备基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<FiredeviceDO> firedeviceList) {
		Map<String,String> dataMap = new HashMap<>();

		FiredeviceDO firstFiredeviceDO = firedeviceList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstFiredeviceDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstFiredeviceDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstFiredeviceDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstFiredeviceDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		// 数据循环写入
		for(int i = 0; i < firedeviceList.size(); i++){
			FiredeviceDO currFiredeviceDO = firedeviceList.get(i);
			// 设备编号
			dataMap.put("equipCode" + i, currFiredeviceDO.getEquipmentCode());
			// 设备名称
			dataMap.put("equipName" + i,currFiredeviceDO.getEquipmentName());
			// 设备型号
			dataMap.put("model" + i, currFiredeviceDO.getModel());
			// 设备类型
			dataMap.put("equipType" + i, currFiredeviceDO.getEquipmentType());
			// 采购时间
			dataMap.put("buyTime" + i, sdf.format(currFiredeviceDO.getBuyTime()));
			// 有效时间
			dataMap.put("effectTime" + i, sdf.format(currFiredeviceDO.getEffectTime()));
			// 品牌
			dataMap.put("brand" + i, currFiredeviceDO.getBrand());
			// 安装位置
			dataMap.put("installPosition" + i, currFiredeviceDO.getInstallPosition());
			// 责任人
			dataMap.put("protectionPerson" + i, currFiredeviceDO.getProtectionPerson());

		}

		return dataMap;
	}


}
