package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.RiskDao;
import com.bootdo.ecosys.domain.RiskDO;
import com.bootdo.ecosys.domain.TrainingDO;
import com.bootdo.ecosys.service.RiskService;
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
public class RiskServiceImpl implements RiskService {
	@Autowired
	private RiskDao riskDao;
	
	@Override
	public RiskDO get(Integer safeTroubleId){
		return riskDao.get(safeTroubleId);
	}

	@Override
	public RiskDO getData(Integer enterpriseId) {
		return riskDao.getData(enterpriseId);
	}

	@Override
	public List<RiskDO> list(Map<String, Object> map){
		return riskDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return riskDao.count(map);
	}
	
	@Override
	public int save(RiskDO risk){
		return riskDao.save(risk);
	}
	
	@Override
	public int update(RiskDO risk){
		return riskDao.update(risk);
	}
	
	@Override
	public int remove(Integer safeTroubleId){
		return riskDao.remove(safeTroubleId);
	}
	
	@Override
	public int batchRemove(Integer[] safeTroubleIds){
		return riskDao.batchRemove(safeTroubleIds);
	}

	@Override
	public void showExcelInfo(List<RiskDO> riskList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(riskList.size() > 0){
			dataMap = convertData(riskList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\安全隐患信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\安全隐患基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<RiskDO> riskList) {
		Map<String,String> dataMap = new HashMap<>();

		RiskDO firstRiskDO = riskList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstRiskDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstRiskDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstRiskDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstRiskDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		// 数据循环写入
		for(int i = 0; i < riskList.size(); i++){
			RiskDO currRiskDO = riskList.get(i);
			// 发现人员
			dataMap.put("peopleName" + i, currRiskDO.getPeopleFindName());
			// 发现时间
			dataMap.put("findTime" + i, sdf.format(currRiskDO.getFindTime()));
			// 隐患级别
			dataMap.put("level" + i, currRiskDO.getLevel());
			// 隐患类型
			dataMap.put("type" + i, currRiskDO.getType());
			// 隐患描述
			dataMap.put("remark" + i, currRiskDO.getRemark());
			// 隐患部位
			dataMap.put("apart" + i, currRiskDO.getApart());
			// 整改情况
			dataMap.put("rectificat" + i, currRiskDO.getRectificat());
			// 整改人
			dataMap.put("rectUserName" + i, currRiskDO.getRectUserName());

		}

		return dataMap;
	}

}
