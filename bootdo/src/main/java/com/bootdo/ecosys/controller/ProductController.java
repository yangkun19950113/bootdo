package com.bootdo.ecosys.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.ecosys.domain.EnterpriseDO;
import com.bootdo.ecosys.domain.ProductDO;
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

	@GetMapping("/{enterpriseId}")
	@RequiresPermissions("ecosys:product:product")
	String Product(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		model.addAttribute("enterpriseId", enterpriseId);
		return "ecosys/product/product";
	}
	
	@ResponseBody
	@GetMapping("/list/{enterpriseId}")
	@RequiresPermissions("ecosys:product:product")
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
	@RequiresPermissions("ecosys:product:add")
	String add(@PathVariable("enterpriseId") Long enterpriseId,Model model){
		EnterpriseDO enterprise = enterpriseService.get(enterpriseId.intValue());
		String enterpriseName = enterprise.getEnterpriseName();
		model.addAttribute("enterpriseId", enterpriseId);
		model.addAttribute("enterpriseName", enterpriseName);
	    return "ecosys/product/add";
	}

	@GetMapping("/edit/{productId}")
	@RequiresPermissions("ecosys:product:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		ProductDO product = productService.get(productId);
		EnterpriseDO enterprise = enterpriseService.get(product.getEnterpriseId());
		product.setEnterpriseName(enterprise.getEnterpriseName());
		model.addAttribute("product", product);
	    return "ecosys/product/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ecosys:product:add")
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
	@RequiresPermissions("ecosys:product:edit")
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
	@RequiresPermissions("ecosys:product:remove")
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
	@RequiresPermissions("ecosys:product:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		productService.batchRemove(productIds);
		return R.ok();
	}
	
}
