package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.iService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class hospitalController {
    private final iService iService;

    public hospitalController(iService iService) {
        this.iService = iService;
    }

    //hien thi list
    @GetMapping("/list")
    public ModelAndView showList() {
        return new ModelAndView("list", "declarationList", iService.findAll());
    }

    //hien thi phieu dang ky
    @GetMapping("/phieu")
    public String formDeclaration(Model model) {
        model.addAttribute("declaration", new Declaration());
        return "index";
    }

    //Chuc nang save sau khi dien
    @PostMapping("/save")
    public String save(@ModelAttribute Declaration declaration, RedirectAttributes redirectAttributes) {
        iService.saveDeclaration(declaration);
        redirectAttributes.addFlashAttribute("mess", "them thanh cong");
        return "redirect:/list";
    }
}
