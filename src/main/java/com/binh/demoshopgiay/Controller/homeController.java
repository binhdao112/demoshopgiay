package com.binh.demoshopgiay.Controller;

import com.binh.demoshopgiay.Model.accountModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class homeController {

    @RequestMapping(value = {"home",""})
    public String Home(Model model){
        model.addAttribute("account", new accountModel());
        return "index";
    }
}
