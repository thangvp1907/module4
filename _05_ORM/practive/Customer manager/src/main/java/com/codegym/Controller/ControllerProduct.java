package com.codegym.Controller;

import com.codegym.Entity.Product;
import com.codegym.Service.iServiceCategory;
import com.codegym.Service.iServiceProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product_management")
public class ControllerProduct {
    private final iServiceProduct iServiceProduct;
    private final iServiceCategory iServiceCategory;

    public ControllerProduct(iServiceProduct iServiceProduct, iServiceCategory iServiceCategory) {
        this.iServiceProduct = iServiceProduct;
        this.iServiceCategory = iServiceCategory;
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("products", iServiceProduct.findAll());
        model.addAttribute("categories", iServiceCategory.findAll());
        return "list";
    }

    //    @GetMapping("")
//    public ModelAndView modelAndView() {
//        return new ModelAndView("list", "products", productImp.findAll());
//    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        Product product = iServiceProduct.findById(id);
        model.addAttribute("product", product);
        return "/detail";
    }

    @GetMapping("/create")
    public String showCreat(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", iServiceCategory.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String doCreat(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        product.setCategory(iServiceCategory.findById(product.getCategory().getCategoryId()));
        iServiceProduct.create(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model) {
        Product product = iServiceProduct.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", iServiceCategory.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product) {
        product.setCategory(iServiceCategory.findById(product.getCategory().getCategoryId()));
        iServiceProduct.update(product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute("id") int id) {
        iServiceProduct.delete(id);
        return "redirect:/product_management";
    }

}
