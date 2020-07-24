package com.bootdo.ecosys.controller;

import com.bootdo.ecosys.dao.EnterpriseDao;
import com.bootdo.ecosys.domain.EnterpriseDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecosys/enterprisemsg")
public class MainController {
    @Autowired
    private EnterpriseDao enterpriseDao;
    @GetMapping("/{enterpriseId}")
    String EnterpriseMain(@PathVariable("enterpriseId") Integer enterpriseId,Model model){
        EnterpriseDO  EnterpriseDO = enterpriseDao.get(enterpriseId);
        String socialCreditCode = EnterpriseDO.getSocialCreditCode();
        model.addAttribute("socialCreditCode", socialCreditCode);
        model.addAttribute("enterpriseId", enterpriseId);
        return "../public/chart/enterprisemsg";
    }
}
