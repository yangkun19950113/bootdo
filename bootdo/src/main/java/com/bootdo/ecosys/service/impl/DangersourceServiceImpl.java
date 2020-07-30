package com.bootdo.ecosys.service.impl;

import com.bootdo.ecosys.dao.DangersourceDao;
import com.bootdo.ecosys.domain.DangersourceDO;
import com.bootdo.ecosys.domain.ProductDO;
import com.bootdo.ecosys.service.DangersourceService;
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
public class DangersourceServiceImpl implements DangersourceService {
	@Autowired
	private DangersourceDao dangersourceDao;
	
	@Override
	public DangersourceDO get(Integer dangerSourceId){
		return dangersourceDao.get(dangerSourceId);
	}

	@Override
	public DangersourceDO getData(Integer enterpriseId) {
		return dangersourceDao.getData(enterpriseId);
	}

	@Override
	public List<DangersourceDO> list(Map<String, Object> map){
		return dangersourceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dangersourceDao.count(map);
	}
	
	@Override
	public int save(DangersourceDO dangersource){
		return dangersourceDao.save(dangersource);
	}
	
	@Override
	public int update(DangersourceDO dangersource){
		return dangersourceDao.update(dangersource);
	}
	
	@Override
	public int remove(Integer dangerSourceId){
		return dangersourceDao.remove(dangerSourceId);
	}
	
	@Override
	public int batchRemove(Integer[] dangerSourceIds){
		return dangersourceDao.batchRemove(dangerSourceIds);
	}

	@Override
	public void showExcelInfo(List<DangersourceDO> dangersourceList) throws IOException {

		// 数据转换
		Map<String,String> dataMap = new HashMap<>();
		if(dangersourceList.size() > 0){
			dataMap = convertData(dangersourceList);
		}

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\安全重点部位信息模板.docx";
		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\安全重点部位基本信息.docx";
		String sourceDocFileName = InformationUtil.fileAccordingData(templateFileName ,targetDataFileName ,dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		InformationUtil.docxToHtml(sourceDocFileName,targetHtmlFileName);
	}

	private Map<String, String> convertData(List<DangersourceDO> dangersourceList) {
		Map<String,String> dataMap = new HashMap<>();

		DangersourceDO firstDangersourceDO = dangersourceList.get(0);
		// 被调查人姓名
		dataMap.put("surveytedPersonName",firstDangersourceDO.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",firstDangersourceDO.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",firstDangersourceDO.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = firstDangersourceDO.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		// 数据循环写入
		for(int i = 0; i < dangersourceList.size(); i++){
			DangersourceDO currDangersourceDO = dangersourceList.get(i);
			// 危险源名称
			dataMap.put("danSourceName" + i,currDangersourceDO.getDangerSourceName());
			// 具体位置
			dataMap.put("partDetail" + i,currDangersourceDO.getPartDetail());
			// 危险程度
			dataMap.put("degreeCode" + i,currDangersourceDO.getDegreeCode());
			// 可能发生的事故类型
			dataMap.put("accidentType" + i,currDangersourceDO.getAccidentType());
			// 监控措施
			dataMap.put("monit" + i,currDangersourceDO.getMonit());
			// 责任人
			dataMap.put("proPerson" + i,currDangersourceDO.getProtectionPerson());
			// 联系电话
			dataMap.put("phoneNumber" + i,currDangersourceDO.getPhoneNumber());

		}

		return dataMap;
	}


}
