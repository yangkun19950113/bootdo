package com.bootdo.ecosys.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.CodeDO;
import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.ProductDO;
import com.bootdo.ecosys.service.CodeService;
import com.bootdo.ecosys.service.EnterpriseService;
import com.bootdo.ecosys.service.ProductService;
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
@RequestMapping("/ecosys/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private CodeService codeService;

	@GetMapping("/{enterpriseId}")
//	@RequiresPermissions("ecosys:product:product")
	String Product(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
//	@RequiresPermissions("ecosys:product:product")
	public PageUtils list(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId){
		//查询列表数据
		params.put("enterpriseId",enterpriseId);
        Query query = new Query(params);
		List<ProductDO> productList = productService.list(query);
		int total = productService.count(query);
		PageUtils pageUtils = new PageUtils(productList, total);
		return pageUtils;
	}

	@GetMapping("/add/{enterpriseId}")
//	@RequiresPermissions("ecosys:product:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
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
		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
	    return "ecosys/product/add";
	}

	@GetMapping("/edit/{productId}")
//	@RequiresPermissions("ecosys:product:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		ProductDO product = productService.get(productId);
		EnterpriseDO enterprise = enterpriseService.get(product.getEnterpriseId());
		//乡镇
		Map<String, Object> map = new HashMap<>();
		map.put("codeId",product.getAdministrativeDivision());
		CodeDO code = codeService.getCode(map);
		//村
		Map<String, Object> map1 = new HashMap<>();
		map1.put("parentId",code.getId());
		map1.put("orderNum",enterprise.getCountry());
		CodeDO contry = codeService.getCode(map1);

		product.setAdministrativeDivisionName(code.getName());
		product.setCountryName(contry.getName());

		product.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("product", product);
	    return "ecosys/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("ecosys:product:add")
	public R save( ProductDO product){
		if(productService.save(product)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
//	@RequiresPermissions("ecosys:product:edit")
	public R update( ProductDO product){
		if(productService.update(product)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
//	@RequiresPermissions("ecosys:product:remove")
	public R remove( Integer productId){
		if(productService.remove(productId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
//	@RequiresPermissions("ecosys:product:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		productService.batchRemove(productIds);
		return R.ok();
	}

	/**
	 * 获取产品产能表格信息
	 * @param enterpriseId
	 * @param model
	 * @return
	 */
	@GetMapping("/showExcelInfo/{enterpriseId}")
	//@RequiresPermissions("ecosys:envprotection:excelInfo")
	String productExcelInfo(@RequestParam Map<String, Object> params,@PathVariable("enterpriseId") Long enterpriseId,Model model) throws IOException {
		model.addAttribute("enterpriseId", enterpriseId);

		params.put("enterpriseId",enterpriseId);
		params.put("limit", 15);
		params.put("offset", 0);
		Query query = new Query(params);
		List<ProductDO> productList = productService.list(query);
		if(productList.size()>0){
			ProductDO product = new ProductDO();
			for(ProductDO ProductDO :productList){
				String surveytedPersonName = ProductDO.getSurveytedPersonName();
				String surveytedPersonPosition = ProductDO.getSurveytedPersonPosition();
				String surveyPersonName = ProductDO.getSurveyPersonName();
				Date fullFormTime = ProductDO.getFullFormTime();
				product.setSurveytedPersonName(surveytedPersonName);
				product.setSurveytedPersonPosition(surveytedPersonPosition);
				product.setFullFormTime(fullFormTime);
				product.setSurveyPersonName(surveyPersonName);
				break;
			}
			model.addAttribute("product", product);
			model.addAttribute("productList", productList);
			// 设置环保表格信息
//		productService.showExcelInfo(productList);

			// 跳转写成的html页面
			return "ecosys/enterprisemsg/productexcel";
		}else {
			return "ecosys/enterprisemsg/msg";
		}

	}

}
