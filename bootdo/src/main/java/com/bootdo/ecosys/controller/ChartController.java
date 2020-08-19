package com.bootdo.ecosys.controller;

import com.alibaba.fastjson.JSON;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;
import com.bootdo.ecosys.dao.EnterpriseDao;
import com.bootdo.ecosys.domain.*;
import com.bootdo.ecosys.service.CodeService;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.tool.MessageResult;
import com.bootdo.tool.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 数据字典表
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:01
 */
 
@RestController
@RequestMapping("/ecosys/chart")
public class ChartController {
	@Autowired
	private CodeService codeService;
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private EnterpriseDao enterpriseDao;

	//各村街企业占比（初始化）
	@ResponseBody
	@GetMapping("/loadEnterpriseProportion")
	public ResponseData loadEnterpriseProportion(@RequestParam Map<String, Object> params){
		List<CommonDO> valueList = enterpriseService.loadEnterpriseProportion(params);
		if(valueList.size() == 0){
			CommonDO common = new CommonDO();
			common.setName("无");
			common.setValue("0");
			valueList.add(common);
		}
		return MessageResult.success("200","", valueList);
	}

	@ResponseBody
	@GetMapping("/loadEnterpriseSum")
	public ResponseData loadEnterpriseSum(@RequestParam Map<String, Object> params){
		List<EnterpriseDTO> valueList = enterpriseDao.loadEnterpriseSum(params);
		return MessageResult.success("200","", valueList);
	}

	//企业性质占比分析（初始化）
	@ResponseBody
	@GetMapping("/loadEnterpriseNatureCode")
	public ResponseData loadEnterpriseNatureCode(@RequestParam Map<String, Object> params){
		List<CommonDO> valueList = enterpriseService.loadEnterpriseNatureCode(params);
		if(valueList.size() == 0){
			CommonDO common = new CommonDO();
			common.setName("无");
			common.setValue("0");
			valueList.add(common);
		}
		return MessageResult.success("200","", valueList);
	}

	//加载污染类别占比
	@ResponseBody
	@GetMapping("/loadPollutionCode")
	public ResponseData loadPollutionCode(@RequestParam Map<String, Object> params){
		List<CommonDO> valueList = enterpriseService.loadPollutionCode(params);
		if(valueList.size() == 0){
			CommonDO common = new CommonDO();
			common.setName("无");
			common.setValue("0");
			valueList.add(common);
		}
		return MessageResult.success("200","", valueList);
	}
	//各类企业增长分析
	@ResponseBody
	@GetMapping("/enterpriseHigh")
	public ResponseData enterpriseHigh(@RequestParam Map<String, Object> params){
		String administrativeDivision = null;
		String country = null;
		if(null != params.get("administrativeDivision") && !params.get("administrativeDivision").equals("")){
			administrativeDivision = params.get("administrativeDivision").toString();
		}
		if(null != params.get("country") && !params.get("country").equals("")){
			country = params.get("country").toString();
		}
		List<LineDO> lineList = new ArrayList<>();
		String [] yearArray = null;//x轴
		//取最近五年按从小到达排列
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date date = new Date();
		int year = Integer.valueOf(format.format(date)) - 5;//五年前年份
		String yearStr = "";
		for(int i = 1; i < 6; i ++){
			int yearsNew = year + i;
			yearStr = yearStr + yearsNew + "," ;
		}
		yearArray = yearStr.split(",");
		//查询企业性质
		Map<String, Object> map = new HashMap<>();
		map.put("parentId",1);
		List<CodeDO> codeList = codeService.list(map);
		for(int i = 0;i<codeList.size();i++){
			CodeDO code = codeList.get(i);
			Map<String, Object> map1 = new HashMap<>();
			map1.put("codeId",code.getCodeId());
			map1.put("administrativeDivision",administrativeDivision);
			map1.put("country",country);
			List<EnterpriseDO> enterpriseList = enterpriseService.enterpriseHigh(map1);
			if(enterpriseList.size() > 0) {
				String dataStr = "";
				if (enterpriseList.size() > 0 && enterpriseList.size() == 5) {
					for (int j = 0; j < enterpriseList.size(); j++) {
						EnterpriseDO enterprise = enterpriseList.get(j);
						dataStr = dataStr + enterprise.getNum() + ",";
					}
					LineDO line = new LineDO();
					line.setName(enterpriseList.get(0).getEnterpriseNatureName());
					line.setType("line");
					line.setStack("总量");
					line.setData(dataStr.split(","));
					lineList.add(line);
				} else {
					List<EnterpriseDO> yearList = new ArrayList<>();
					for(int m = 0;m<yearArray.length;m++){
						EnterpriseDO year1 = new EnterpriseDO();
						year1.setYear(yearArray[m]);
						yearList.add(year1);
					}
					//验证哪个年份没有，data里面赋值为0
					for (int j = 0; j < enterpriseList.size(); j++) {
						EnterpriseDO enterprise = enterpriseList.get(j);
						for (int k = 0; k < yearArray.length; k++) {
							if (enterprise.getYear().equals(yearArray[k])) {
								dataStr = dataStr + enterprise.getNum() + ",";
//								yearList.remove(k);
								break;
							} else {
								dataStr = dataStr + 0 + ",";
							}
						}
					}
					String[] strArray = dataStr.split(",");
					if(strArray.length != yearArray.length){
						for(int g = 0; g<yearArray.length - strArray.length;g++){
							dataStr = dataStr + 0 + ",";
						}
					}
					LineDO line = new LineDO();
					line.setName(enterpriseList.get(0).getEnterpriseNatureName());
					line.setType("line");
					line.setStack("总量");
					line.setData(dataStr.split(","));
					lineList.add(line);
				}
			}
		}
		if(lineList.size()==0){
			String dataStr = "0,0,0,0,0,";
			for(int i = 0;i<codeList.size();i++){
				LineDO line = new LineDO();
				line.setName(codeList.get(i).getName());
				line.setType("line");
				line.setStack("总量");
				line.setData(dataStr.split(","));
				lineList.add(line);
			}
		}
		LineDDO lineDDO = new LineDDO();
		lineDDO.setYearList(yearArray);
		lineDDO.setLineList(lineList);
		return MessageResult.success("200","", lineDDO);
	}
	//各类企业消防设备分析
	@ResponseBody
	@GetMapping("/fireEquipHigh")
	public ResponseData fireEquipHigh(@RequestParam Map<String, Object> params){
		String administrativeDivision = null;
		String country = null;
		if(null != params.get("administrativeDivision") && !params.get("administrativeDivision").equals("")){
			administrativeDivision = params.get("administrativeDivision").toString();
		}
		if(null != params.get("country") && !params.get("country").equals("")){
			country = params.get("country").toString();
		}
		List<LineDO> lineList = new ArrayList<>();
		String [] monthArray = null;//x轴
		String [] monthArray1 = null;
		//取最近五个月按从小到达排列
		SimpleDateFormat format = new SimpleDateFormat("MM");
		Date date = new Date();
		int month = Integer.valueOf(format.format(date)) - 5;
		String monthStr = "";
		String monthStr1 = "";
		for(int i = 1; i < 6; i ++){
			int monthNew = month + i;
			monthStr = monthStr + monthNew + "," ;
			monthStr1 = monthStr1 + monthNew + "月,";
		}
		monthArray = monthStr.split(",");
		monthArray1 = monthStr1.split(",");

		//查询企业性质
		Map<String, Object> map = new HashMap<>();
		map.put("parentId",1);
		List<CodeDO> codeList = codeService.list(map);
		for(int i = 0;i<codeList.size();i++) {
			CodeDO code = codeList.get(i);
			Map<String, Object> map1 = new HashMap<>();
			map1.put("enterpriseNatureCode", code.getCodeId());
			map1.put("administrativeDivision",administrativeDivision);
			map1.put("country",country);
			List<EnterpriseDO> fireList = enterpriseService.getEnterpriselist(map1);
			if(fireList.size()>0){
				String dataStr = "";
				if (fireList.size() == 5) {
					for (int j = 0; j < fireList.size(); j++) {
						EnterpriseDO fire = fireList.get(j);
						dataStr = dataStr + fire.getNum() + ",";
					}
					LineDO line = new LineDO();
					line.setName(code.getName());
					line.setType("line");
					line.setStack("总量");
					line.setData(dataStr.split(","));
					lineList.add(line);
				}else {
					List<EnterpriseDO> monthList = new ArrayList<>();
					for(int m = 0;m<monthArray.length;m++){
						EnterpriseDO month1 = new EnterpriseDO();
						month1.setMonth(monthArray[m]);
						monthList.add(month1);
					}
					//验证哪个月份没有，data里面赋值为0
					for (int j = 0; j < fireList.size(); j++) {
						EnterpriseDO fire = fireList.get(j);
						for (int k = 0; k < monthList.size(); k++) {
							if (fire.getMonth().equals(monthList.get(k).getMonth())) {
								dataStr = dataStr + fire.getNum() + ",";
								monthList.remove(k);
								break;
							} else {
								dataStr = dataStr + 0 + ",";
							}
						}
					}
					//补齐剩余的data数据
					String[] strArray = dataStr.split(",");
					if(strArray.length != monthArray.length){
						for(int g = 0; g<monthArray.length - strArray.length;g++){
							dataStr = dataStr + 0 + ",";
						}
					}
					LineDO line = new LineDO();
					line.setName(code.getName());
					line.setType("line");
					line.setStack("总量");
					line.setData(dataStr.split(","));
					lineList.add(line);
				}
			}
		}
		if(lineList.size()==0){
			String dataStr = "0,0,0,0,0,";
			for(int i = 0;i<codeList.size();i++){
				LineDO line = new LineDO();
				line.setName(codeList.get(i).getName());
				line.setType("line");
				line.setStack("总量");
				line.setData(dataStr.split(","));
				lineList.add(line);
			}
		}
		LineDDO lineDDO = new LineDDO();
		lineDDO.setYearList(monthArray1);//实际是月份
		lineDDO.setLineList(lineList);
		return MessageResult.success("200","", lineDDO);
	}


	//环保信息完成率
	@ResponseBody
	@GetMapping("/envprotectionChart")
	public ResponseData envprotectionChart(@RequestParam Map<String, Object> params){
		double num = enterpriseService.getEnvprotectionChart(params);
		return MessageResult.success("200","", num);
	}

	@ResponseBody
	@GetMapping("/getEffectFireEquip")
	public ResponseData getEffectFireEquip(@RequestParam Map<String, Object> params){
		List<FiredeviceDO> List =  enterpriseService.getEffectFireEquip(params);
		return MessageResult.success("200","", List);
	}
	@ResponseBody
	@GetMapping("/getEecoequipment")
	public ResponseData getEecoequipment(@RequestParam Map<String, Object> params){
		List<EcoequipmentDO> List =  enterpriseService.getEecoequipment(params);
		return MessageResult.success("200","", List);
	}

	//获取有危险源企业的信息
	@ResponseBody
	@GetMapping("/getDangerData")
	public ResponseData getDangerData(@RequestParam Map<String, Object> params){
		List<DangersourceDO> List =  enterpriseService.getDangerData(params);
		return MessageResult.success("200","", List);
	}



}
