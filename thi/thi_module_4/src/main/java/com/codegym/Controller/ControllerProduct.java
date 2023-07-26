package com.codegym.Controller;


import com.codegym.Entity.Product;
import com.codegym.Service.ICategoryService;
import com.codegym.Service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/Home")
public class ControllerProduct {

    private final ICategoryService iCategoryService;

    private final IProductService iProductService;

    public ControllerProduct(ICategoryService iCategoryService, IProductService iProductService) {
        this.iCategoryService = iCategoryService;
        this.iProductService = iProductService;
    }


//    @GetMapping("/List")
//    public String listByPage(@PageableDefault(value = 3) Pageable pageable, Model model) {
//        Page<Product> page = iProductService.findAll(pageable);
//        model.addAttribute("Product", page);
//        model.addAttribute("Category", iCategoryService.findAll());
//        return "view/List";
//    }


    @GetMapping("/List")
    public String productList(
            @PageableDefault(value = 3) Pageable pageable,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) String price,
            @RequestParam(value = "id", required = false) Integer id,
            Model model
    ) {
        Page<Product> products;

        if (name != null) {
            products = iProductService.findProductByNameProductContaining(name, pageable);
        } else if (price != null) {
            products = iProductService.findProductByPrice(Double.valueOf(price), pageable);
        } else if (id != null) {
            model.addAttribute("Category",iCategoryService.findById(id));
            products = iProductService.findProductByCategory_Id(id, pageable);
        } else {
            // Nếu không có tham số tìm kiếm, hiển thị danh sách sản phẩm trang chủ theo mặc định
            products = iProductService.findAll(pageable);
        }

        model.addAttribute("Product", products);
        model.addAttribute("Category", iCategoryService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("id", id);

        return "view/List";
    }



    @GetMapping("/Create")
    public String showCreate(Model model) {
        model.addAttribute("Product", new Product());
        model.addAttribute("Category", iCategoryService.findAll());
        return "view/Create";
    }

    @PostMapping("/Create")
    public String doCreate(@Valid @ModelAttribute("Product") Product product, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new Product().validate(product,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("Category",iCategoryService.findAll());
            return "/view/Create";
        }
        model.addAttribute("Category",iCategoryService.findAll());
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/Home/List";
    }

    @GetMapping("/Delete/{id}")
    public String doDelete(@PathVariable("id") Integer id) {
        iProductService.delete(id);
        return "redirect:/Home/List";
    }

    @GetMapping("/Edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("Product", iProductService.findById(id));
        model.addAttribute("Category", iCategoryService.findAll());
        return "view/Edit";
    }

    @PostMapping("/Edit")
    public String doEdit(@Validated @ModelAttribute("Product") Product product,BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) {
        new Product().validate(product,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("Category",iCategoryService.findAll());
            return "/view/Create";
        }
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/Home/List";
    }

    @GetMapping("/Search")
    public String search(@PageableDefault(value = 3) Pageable pageable, @RequestParam("name") String name, Model model) {
        Page<Product> products = iProductService.findProductByNameProductContaining(name, pageable);
        model.addAttribute("Product",products);
        model.addAttribute("Category",iCategoryService.findAll());
        model.addAttribute("name", name);
        return "view/List";
    }

    @GetMapping("/SearchCategory")
    public String searchAddress(@PageableDefault(value = 3) Pageable pageable, @RequestParam("id") Integer id, Model model) {
        Page<Product> products = iProductService.findProductByCategory_Id(id, pageable);
        model.addAttribute("Product", products);
        model.addAttribute("Category",iCategoryService.findById(id));
        model.addAttribute("id",id);
        return "view/List";
    }
    @GetMapping("/SearchPrice")
    public String searchPrice(@PageableDefault(value = 3) Pageable pageable, @RequestParam("price") Double price, Model model) {
        Page<Product> products = iProductService.findProductByPrice(price, pageable);
        model.addAttribute("Product", products);
        model.addAttribute("Category",iCategoryService.findAll());
        return "view/List";
    }
}

