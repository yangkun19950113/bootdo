package com.bootdo.ecosys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/enterprisemsg")
public class MainController {
    @GetMapping("/{enterpriseId}")
    String EnterpriseMain(@PathVariable("enterpriseId") Long enterpriseId,Model model){
        model.addAttribute("enterpriseId", enterpriseId);
        return "../public/chart/enterprisemsg";
    }
}
