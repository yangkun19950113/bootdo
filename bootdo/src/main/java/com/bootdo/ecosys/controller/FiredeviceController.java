package com.bootdo.ecosys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.FiredeviceDO;
import com.bootdo.ecosys.service.CodeService;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.FiredeviceService;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author yangkun
 * @email 1992lcg@163.com
 * @date 2020-07-07 11:41:02
 */
 
@Controller
@RequestMapping("/ecosys/firedevice")
public class FiredeviceController {
	@Autowired
	private FiredeviceService firedeviceService;
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private CodeService codeService;
	
	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:firedevice:firedevice")
	String Firedevice(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
	    return "ecosys/firedevice/firedevice";
	}

	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:firedevice:firedevice")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		params.put("enterpriseId",enterpriseId);
		Query query = new Query(params);
		//查询列表数据
		List<FiredeviceDO> firedeviceList = firedeviceService.list(query);
		int total = firedeviceService.count(query);
		PageUtils pageUtils = new PageUtils(firedeviceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{enterpriseId}")
	@RequiresPermissions("ecosys:firedevice:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		//TODO
		//行政区划与乡村编码截取
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",enterprise.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		String administrativeDivisionName = code.getName();
		String administrativeDivision = enterprise.getAdministrativeDivision();
		String country = contry.getOrderNum().toString();
		String countryName = contry.getName();
		model.addAttribute("administrativeDivisionName", administrativeDivisionName);
		model.addAttribute("administrativeDivision", administrativeDivision);
		model.addAttribute("country", country);
		model.addAttribute("countryName", countryName);
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/firedevice/add";
	}

	@GetMapping("/edit/{equipmentId}")
	@RequiresPermissions("ecosys:firedevice:edit")
	String edit(@PathVariable("equipmentId") Integer equipmentId,Model model){
		FiredeviceDO firedevice = firedeviceService.get(equipmentId);
		EnterpriseDO enterprise = enterpriseService.get(firedevice.getEnterpriseId());
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",firedevice.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		firedevice.setAdministrativeDivisionName(code.getName());
		firedevice.setEnterpriseName(enterprise.getEnterpriseName());
		firedevice.setCountryName(contry.getName());
		model.addAttribute("firedevice", firedevice);
	    return "ecosys/firedevice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:firedevice:add")
	public R save( FiredeviceDO firedevice){
		if(firedeviceService.save(firedevice)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ecosys:firedevice:edit")
	public R update( FiredeviceDO firedevice){
		if(firedeviceService.update(firedevice)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ecosys:firedevice:remove")
	public R remove( Integer equipmentId){
		if(firedeviceService.remove(equipmentId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ecosys:firedevice:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] equipmentIds){
		firedeviceService.batchRemove(equipmentIds);
		return R.ok();
	}
	
}
