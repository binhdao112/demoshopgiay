package com.binh.demoshopgiay.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CardController {
    @PostMapping("/addcard")
    public String AddCard(HttpServletRequest rq, RedirectAttributes rd){
        try {
            Cookie[] cookies=rq.getCookies();
            if(cookies.length>0){
                for (Cookie c: cookies){
                    if (c.getName().equals("name")){
                        rd.addFlashAttribute("addsuc","Add product to card success");
                        return "redirect:"+rq.getHeader("Referer");
                    }
                }
            }
            rd.addFlashAttribute("adderr","Not login");
            return "redirect:"+rq.getHeader("Referer");
        }catch (NullPointerException ex){
            rd.addFlashAttribute("adderr","Not login");
            return "redirect:"+rq.getHeader("Referer");
        }

    }
}
