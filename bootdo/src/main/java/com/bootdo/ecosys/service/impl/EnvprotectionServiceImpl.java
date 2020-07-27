package com.bootdo.ecosys.service.impl;

import com.bootdo.common.utils.StringUtils;
import com.bootdo.ecosys.dao.CodeDao;
import com.bootdo.ecosys.dao.EnvprotectionDao;
import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EnvprotectionDO;
import com.bootdo.ecosys.service.EnvprotectionService;
import com.deepoove.poi.XWPFTemplate;
import fr.opensagres.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class EnvprotectionServiceImpl implements EnvprotectionService {
	@Autowired
	private EnvprotectionDao envprotectionDao;
	@Autowired
	private CodeDao codeDao;

	
	@Override
	public EnvprotectionDO get(Integer envirProtectionId){
		return envprotectionDao.get(envirProtectionId);
	}
	
	@Override
	public List<EnvprotectionDO> list(Map<String, Object> map){
		List<EnvprotectionDO> list = envprotectionDao.list(map);
		String codeNamelist = "";
		for(int i = 0;i<list.size();i++){
			EnvprotectionDO envprotection = list.get(i);
			String[] ids = envprotection.getIndustryCode().split(",");
			Map<String, Object> map1 = new HashMap<>();
			map1.put("idsArray", ids);
			List<CodeDO> codelist = codeDao.getList(map1);
			if(codelist.size()>0){
				for(int j = 0;j<codelist.size();j++){
					CodeDO code = codelist.get(j);
					codeNamelist = code.getName() + "," + codeNamelist;
				}
			}
			envprotection.setIndustryName(codeNamelist);
		}
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return envprotectionDao.count(map);
	}
	
	@Override
	public int save(EnvprotectionDO envprotection){
		return envprotectionDao.save(envprotection);
	}
	
	@Override
	public int update(EnvprotectionDO envprotection){
		return envprotectionDao.update(envprotection);
	}
	
	@Override
	public int remove(Integer envirProtectionId){
		return envprotectionDao.remove(envirProtectionId);
	}
	
	@Override
	public int batchRemove(Integer[] envirProtectionIds){
		return envprotectionDao.batchRemove(envirProtectionIds);
	}

	@Override
	public EnvprotectionDO getData(Integer enterpriseId) {
		return envprotectionDao.getData(enterpriseId);
	}

	@Override
	public void showExcelInfo(EnvprotectionDO envprotection) throws FileNotFoundException, FileNotFoundException {

		// 数据转换
		Map<String,String> dataMap = convertData(envprotection);

		// 根据动态数据生成word文件
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String sourceDocFileName = fileAccordingData(dataMap);
		String targetHtmlFileName = path.getAbsolutePath() + "\\templates\\ecosys\\enterprisemsg\\excelmsg.html";

		// 根据word文件写成html文件
		docxToHtml(sourceDocFileName,targetHtmlFileName);

	}

	private Map<String, String> convertData(EnvprotectionDO envprotection) {
		Map<String,String> dataMap = new HashMap<String,String>();

		// code转化字符串,并设置内容
		// 行业类别
		String industryContent = codeToString(envprotection.getIndustryCode());
		dataMap.put("industryCode", industryContent);
		// 项目管理类别
		String projectManageContent = codeToString(envprotection.getProjectManageCode());
		dataMap.put("projectManageCode", projectManageContent);
		// 排污许可管理类别
		String tradablePermitsContent = codeToString(envprotection.getTradablePermitsCode());
		dataMap.put("tradablePermitsCode", tradablePermitsContent);
		// 污染类别
		String pollutionCategoryContent = codeToString(envprotection.getPollutionCategoryCode());
		dataMap.put("pollutionCategoryCode", pollutionCategoryContent);
		// 所在区域
		String areaCodeContent = codeToString(envprotection.getAreaCode());
		dataMap.put("areaCode", areaCodeContent);
		// 常规因子
		String normalFactorsContent = codeToString(envprotection.getNormalFactorsCode());
		dataMap.put("normalFactorsCode", normalFactorsContent);
		// 特征因子
		String specialFactorsContent = codeToString(envprotection.getSpecialFactorsCode());
		dataMap.put("specialFactorsCode", specialFactorsContent);
		// 主要能源
		String mainEnergyContent = codeToString(envprotection.getMainEnergyCode());
		dataMap.put("mainEnergyCode", mainEnergyContent);


		// 是否，有无设置
		dataMap.put("ecoEstimateFlg",envprotection.getEcoEstimateFlg() == "1"?"是":"否");
		dataMap.put("parkFlg",envprotection.getParkFlg() == "1"?"是":"否");
		dataMap.put("ecoStandardFlg",envprotection.getEcoStandardFlg() == "1"?"有":"无");
		dataMap.put("isOrNotAcceptance",envprotection.getIsOrNotAcceptance() == "1"?"是":"否");
		dataMap.put("pollutionLicenseFlg",envprotection.getPollutionLicenseFlg() == "1"?"是":"否");
		dataMap.put("annualInspectionFlg",envprotection.getAnnualInspectionFlg() == "1"?"是":"否");

		dataMap.put("normalWast",envprotection.getNomalWaste());
		dataMap.put("dangerWast",envprotection.getDangerWaste());
		dataMap.put("measures",envprotection.getMeasures());

		// 企业名称
		dataMap.put("enterpriseName",envprotection.getEnterpriseName());
		// 被调查人姓名
		dataMap.put("surveytedPersonName",envprotection.getSurveytedPersonName());
		// 被调查人职务
		dataMap.put("surveytedPersonPosition",envprotection.getSurveytedPersonPosition());
		// 调查人
		dataMap.put("surveyPersonName",envprotection.getSurveyPersonName());
		// 填表日期
		Date fullFormTime = envprotection.getFullFormTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fullFormTimeContent = sdf.format(fullFormTime);
		dataMap.put("fullFormTime",fullFormTimeContent);

		return dataMap;
	}

	private String codeToString(String codeIds) {
		Map<String, Object> map = new HashMap<>();
		String convertContent = "";
		if (StringUtils.isNotEmpty(codeIds)){
			List<String> idsArray = Arrays.asList(codeIds.split(","));

			map.put("idsArray",idsArray);
			List<CodeDO> codeDoList = codeDao.getListByIds(map);
			for(int i = 0 ; i <codeDoList.size(); i++){
				CodeDO currCodeDo = codeDoList.get(i);
				if(i != (codeDoList.size() - 1)){
					convertContent += (currCodeDo.getName()+",");
				}else {
					convertContent += currCodeDo.getName();
				}
			}

		}

		return  convertContent;

	}

	private String fileAccordingData(Map<String, String> dataMap) throws FileNotFoundException {

		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String templateFileName = path.getAbsolutePath() + "\\static\\docs\\环保基本信息模板.docx";
		XWPFTemplate template = XWPFTemplate.compile(templateFileName).render(dataMap);

		String targetDataFileName =  path.getAbsolutePath() + "\\static\\docs\\环保信息.docx";
		try {
			FileOutputStream out = new FileOutputStream(targetDataFileName);//要导出的文件名
			template.write(out);
			out.flush();
			out.close();
			template.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return targetDataFileName;
	}

	private void docxToHtml(String sourceDocFileName, String targetHtmlFileName) {
		OutputStreamWriter outputStreamWriter = null;
		try {
			XWPFDocument document = new XWPFDocument(new FileInputStream(sourceDocFileName));
			//XHTMLOptions options = XHTMLOptions.create();
			// 存放图片的文件夹
			//options.setExtractor(new FileImageExtractor(new File(imagePath)));
			// html中图片的路径
			//options.URIResolver(new BasicURIResolver("image"));
			outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetHtmlFileName), "utf-8");
			XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
			xhtmlConverter.convert(document, outputStreamWriter, null);

//			InputStream in = new FileInputStream(new File("D:\\wordTemplet\\个人信息.docx"));//要转化的word
//			XWPFDocument document = new XWPFDocument(in);
//			OutputStream baos = new ByteArrayOutputStream();
//			XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
//			xhtmlConverter.convert(document, baos,null);
//			content = baos.toString();//转化好的html代码
//
//			baos.close();
			outputStreamWriter.flush();


		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				outputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
