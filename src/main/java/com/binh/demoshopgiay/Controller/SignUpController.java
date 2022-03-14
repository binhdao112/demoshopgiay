package com.binh.demoshopgiay.Controller;

import com.binh.demoshopgiay.Common.PasswordEncode;
import com.binh.demoshopgiay.Model.accountModel;
import com.binh.demoshopgiay.Repository.accountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("account")
public class SignUpController {
    @Autowired
    private accountRepository accountRepository;
    @PostMapping("/register")
    public String Register(@Valid @ModelAttribute accountModel account, RedirectAttributes redirAttrs, PasswordEncode passwordEncodee){
        List<accountModel> listAccount=accountRepository.findaccountModelByEmail(account.getEmail());
        if(listAccount.size()>0){
            redirAttrs.addFlashAttribute("error", "Sign Up fail");
            redirAttrs.addFlashAttribute("errorDetail", "Email already exists");
            return "redirect:http://localhost:8081/login";
        }else{
            account.setRole("usr");
            account.setPassword(passwordEncodee.getMd5(account.getPassword()));
            accountRepository.save(account);
            redirAttrs.addFlashAttribute("success", "Sign Up Successfully !!");
            return "redirect:http://localhost:8081/login";
        }



    }
}
