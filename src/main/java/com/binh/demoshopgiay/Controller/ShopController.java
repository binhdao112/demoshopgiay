package com.binh.demoshopgiay.Controller;

import com.binh.demoshopgiay.Model.ProductModel;
import com.binh.demoshopgiay.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ProductRepository productRepository;
    private int roundUP(double d){
        double dAbs = Math.abs(d);
        int i = (int) dAbs;
        double result = dAbs - (double) i;
        if(result==0.0){
            return (int) d;
        }else{
            return (int) d<0 ? -(i+1) : i+1;
        }
    }
    private List<Integer> totalpage(){
        List<Integer> list=new ArrayList<Integer>();
        for (int i=1;i<=roundUP(productRepository.findAll().size()/6.0);i++){
            list.add(i);
        }
        return list;
    }
    @RequestMapping("/shop")
    public String Shop(HttpServletRequest rq,Model model){
        int pagenum=1;
        try{
            Cookie[] cookies= rq.getCookies();
            for (Cookie c: cookies){
            if (c.getName().equals("name")){
                model.addAttribute("logincheck","true");
            }
            }
        }catch (NullPointerException ex){
            System.err.println(ex);
        }

        List<ProductModel> listProduct=productRepository.findAll();
        List<ProductModel> listproductPage=new ArrayList<ProductModel>();
        int start=(pagenum-1)*3;
        for(int i=start;i<start+6;i++){
            if(i>=listProduct.size()){
                break;
            }else{
                listproductPage.add(listProduct.get(i));
            }
        }
        if(listproductPage.isEmpty()){
            model.addAttribute("mess","No product in here");
        }
        model.addAttribute("product", new ProductModel());
        model.addAttribute("page",totalpage());
        model.addAttribute("listproduct",listproductPage);
        return "shop";
    }
    @RequestMapping("/shop/{pagenum}")
    public String ShopPage(HttpServletRequest rq, @PathVariable int pagenum, Model model){
        try{
            Cookie[] cookies= rq.getCookies();
            for (Cookie c: cookies){
                if (c.getName().equals("name")){
                    model.addAttribute("logincheck","true");
                }
            }
        }catch (NullPointerException ex){
            System.err.println(ex);
        }
        List<ProductModel> listProduct=productRepository.findAll();
        List<ProductModel> listproductPage=new ArrayList<ProductModel>();
        int start=(pagenum-1)*6;
        for(int i=start;i<start+6;i++){
            if(i>=listProduct.size()){
                break;
            }else{
                listproductPage.add(listProduct.get(i));
            }
        }
        if(listproductPage.isEmpty()){
            model.addAttribute("mess","No product in here");
        }
        model.addAttribute("page",totalpage());
        model.addAttribute("product", new ProductModel());
        model.addAttribute("listproduct",listproductPage);
        return "shop";
    }
}
