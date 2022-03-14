package com.binh.demoshopgiay.Controller;

import com.binh.demoshopgiay.Model.ProductModel;
import com.binh.demoshopgiay.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        for (int i=1;i<=roundUP(productRepository.findAll().size()/3.0);i++){
            list.add(i);
        }
        return list;
    }
    @RequestMapping("/shop")
    public String Shop(Model model){
        int pagenum=1;
        for(int i: totalpage()){
            System.out.println(i);
        }
        List<ProductModel> listProduct=productRepository.findAll();
        List<ProductModel> listproductPage=new ArrayList<ProductModel>();
        int start=(pagenum-1)*3;
        for(int i=start;i<start+3;i++){
            if(i>=listProduct.size()){
                break;
            }else{
                System.out.println(listProduct.get(i).getName());
                listproductPage.add(listProduct.get(i));
            }
        }
        if(listproductPage.isEmpty()){
            model.addAttribute("mess","No product in here");
        }

        model.addAttribute("page",totalpage());
        model.addAttribute("listproduct",listproductPage);
        return "shop";
    }
    @RequestMapping("/shop/{pagenum}")
    public String ShopPage(@PathVariable int pagenum, Model model){
        List<ProductModel> listProduct=productRepository.findAll();
        List<ProductModel> listproductPage=new ArrayList<ProductModel>();
        int start=(pagenum-1)*3;
        for(int i=start;i<start+3;i++){
            if(i>=listProduct.size()){
                break;
            }else{
                System.out.println(listProduct.get(i).getName());
                listproductPage.add(listProduct.get(i));
            }
        }
        if(listproductPage.isEmpty()){
            model.addAttribute("mess","No product in here");
        }
        model.addAttribute("page",totalpage());

        model.addAttribute("listproduct",listproductPage);
        return "shop";
    }
}
