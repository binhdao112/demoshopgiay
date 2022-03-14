package com.binh.demoshopgiay.Controller;

import com.binh.demoshopgiay.Common.PasswordEncode;
import com.binh.demoshopgiay.Model.accountLogin;
import com.binh.demoshopgiay.Model.accountModel;
import com.binh.demoshopgiay.Repository.accountRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
=======
>>>>>>> f0f0c7dfbb985317d35cf113345ca3aeabe0b27a
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private accountRepository accountRepository;
    @RequestMapping("")
    public String LoginPage(Model model){
        model.addAttribute("account", new accountModel());
        model.addAttribute("accountlogin",new accountLogin());
        return "account";
    }
    @PostMapping("/goto")
    public String Login(@ModelAttribute accountLogin account, HttpServletResponse response, RedirectAttributes redirectAttributes, PasswordEncode passwordEncode) throws UnsupportedEncodingException {
        String hashPass=passwordEncode.getMd5(account.getPassword());
        List<accountModel> listaccount = accountRepository.findaccountModelByEmailAndPass(account.getEmail(),hashPass);
        if (!listaccount.isEmpty()){
            Cookie cookie= new Cookie("name", URLEncoder.encode(listaccount.get(0).getName(),"UTF-8"));
            cookie.setPath("/");
            System.out.println(URLDecoder.decode(URLEncoder.encode(listaccount.get(0).getName(),"UTF-8"),"UTF-8"));
            response.addCookie(cookie);
            redirectAttributes.addFlashAttribute("loginSuccess","Login Successfully");
            return "redirect:http://localhost:8081/";
        }else {
            redirectAttributes.addFlashAttribute("loginError","Login Fail");
            return "redirect:http://localhost:8081/login";
        }

    }
    @RequestMapping("/logout")
    public String Logout(HttpServletResponse response){
        Cookie cookie = new Cookie("name", null);
        Cookie cookieJSESSIONID = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookieJSESSIONID.setMaxAge(0);
        cookieJSESSIONID.setPath("/");
        response.addCookie(cookie);
        response.addCookie(cookieJSESSIONID);
        return "redirect:http://localhost:8081/";
    }
    @RequestMapping("/checklogin")
    public String CheckLogin(HttpServletRequest request, RedirectAttributes red){
        Cookie[]  cookies= request.getCookies();
        if(cookies!= null){
            for (Cookie c : cookies) {
                System.out.println(c.getName() +":"+c.getValue());
                if (c.getName().equals("name"))
                {
                    return "redirect:http://localhost:8081/";
                }

            }
        }

        return "redirect:http://localhost:8081/login";
    }
}
