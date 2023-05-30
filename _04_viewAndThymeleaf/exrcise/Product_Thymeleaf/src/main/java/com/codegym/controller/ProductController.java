package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.imp.categoryImp;
import com.codegym.service.imp.productImp;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final productImp productImp;
    private final categoryImp categoryImp;

    public ProductController(productImp productImp, categoryImp categoryImp) {
        this.productImp = productImp;
        this.categoryImp = categoryImp;
    }

//    @GetMapping("")
//    public String showList(Model model){
//        model.addAttribute("products",productImp.findAll());
//        return "list";
//    }

    @GetMapping("")
    public ModelAndView modelAndView(){
        return new ModelAndView("list","products",productImp.findAll());
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable ("id") int id,Model model){
        Product product = productImp.findById(id);
        model.addAttribute("product",product);
        return "/detail";
    }

    @GetMapping("/create")
    public String showCreat(Model model){
        model.addAttribute("product" , new Product());
        model.addAttribute("categories",categoryImp.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String doCreat(@ModelAttribute ("product") Product product, RedirectAttributes redirectAttributes){
        product.setCategory(categoryImp.findById(product.getCategory().getCategoryId()));
        productImp.create(product);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int id,Model model){
        Product product = productImp.findById(id);
        model.addAttribute("product",product);
        model.addAttribute("categories",categoryImp.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute ("product") Product product){
        product.setCategory(categoryImp.findById(product.getCategory().getCategoryId()));
        productImp.update(product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute ("id") int id){
        productImp.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/search")
    public String getProduct(@RequestParam("name") String name,Model model) {
        List<Product> products = productImp.findByName(name);
        model.addAttribute("products", products);
        return "/list";
    }
}
