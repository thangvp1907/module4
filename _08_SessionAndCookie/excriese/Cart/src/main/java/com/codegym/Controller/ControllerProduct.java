package com.codegym.Controller;


import com.codegym.Entity.Product;
import com.codegym.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ControllerProduct {

    @Autowired
    private ProductService productService;



    @GetMapping("/list")
    public String showList(Model model){
        List<Product> products =productService.findAll();
        model.addAttribute("products", products);
        return "view/product/list";
    }
}
