package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.TrainingDao;
import com.bootdo.ecosys.domain.EcoequipmentDO;
import com.bootdo.ecosys.domain.TrainingDO;
import com.bootdo.ecosys.service.TrainingService;
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
public class TrainingServiceImpl implements TrainingService {
	@Autowired
	private TrainingDao trainingDao;
	
	@Override
	public TrainingDO get(Integer trainingId){
		return trainingDao.get(trainingId);
	}

	@Override
	public TrainingDO getData(Integer enterpriseId) {
		return trainingDao.getData(enterpriseId);
	}

	@Override
	public List<TrainingDO> list(Map<String, Object> map){
		return trainingDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return trainingDao.count(map);
	}
	
	@Override
	public int save(TrainingDO training){
		return trainingDao.save(training);
	}
	
	@Override
	public int update(TrainingDO training){
		return trainingDao.update(training);
	}
	
	@Override
	public int remove(Integer trainingId){
		return trainingDao.remove(trainingId);
	}
	
	@Override
	public int batchRemove(Integer[] trainingIds){
		return trainingDao.batchRemove(trainingIds);
	}

	@Override
	public void showExcelInfo(List<TrainingDO> trainingList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(trainingList.size() > 0){
			dataMap = convertData(trainingList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\安全生产培训信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\安全生产培训基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<TrainingDO> trainingList) {
		Map<String,String> dataMap = new HashMap<>();

		TrainingDO firstTrainingDO = trainingList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstTrainingDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstTrainingDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstTrainingDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstTrainingDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);
		// 企业名称
		dataMap.put("enterpriseName",firstTrainingDO.getEnterpriseName());

		// 数据循环写入
		for(int i = 0; i < trainingList.size(); i++){
			TrainingDO currTrainingDO = trainingList.get(i);
			// 是否建立安全培训制度
			String trainingFlgContent = currTrainingDO.getTrainingFlg().equals("0")? "无":"有";
			dataMap.put("trainingFlg" + i, trainingFlgContent);
			// 是否为劳动者提供防护用品
			String laProvideFlgContent = currTrainingDO.getLaProvideFlg().equals("0")? "无":"有";
			dataMap.put("laProvideFlg" + i,laProvideFlgContent);
			// 培训时间
			dataMap.put("trainTime" + i,sdf.format(currTrainingDO.getTrainTime()));
			// 培训主题
			dataMap.put("trainName" + i,currTrainingDO.getTrainName());
			// 培训类型
			dataMap.put("trainType" + i,currTrainingDO.getTrainType());
			// 参加人数
			dataMap.put("personNumber" + i,Long.toString(currTrainingDO.getPersonNumber()));
			// 参加部门
			dataMap.put("deptCode" + i,sdf.format(currTrainingDO.getDeptCode()));
			// 有无培训资料
			String traningFileFlgContent = currTrainingDO.getTraningFileFlg().equals("0")? "无":"有";
			dataMap.put("traningFileFlg" + i, traningFileFlgContent);
			// 联系电话
			dataMap.put("phoneNumber" + i,currTrainingDO.getPhoneNumber());

		}

		return dataMap;
	}


}
