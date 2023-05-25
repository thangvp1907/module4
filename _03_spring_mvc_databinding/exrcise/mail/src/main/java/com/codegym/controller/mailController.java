package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.iService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class mailController {
    @Autowired
    private iService iService;

    @GetMapping("/list")
    public ModelAndView showList() {
        return new ModelAndView("list", "mail", iService.findAll());
    }

    @GetMapping("/update")
    public String showEdit(@RequestParam int id, Model model){
        model.addAttribute("mailList",iService.findById(id));
        model.addAttribute("languagesList",iService.findByLanguagesList());
        model.addAttribute("pageSize",iService.findByPageSize());
        return "update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Mail mail, RedirectAttributes redirectAttributes){
        iService.save(mail);
        redirectAttributes.addFlashAttribute("mess","thành công");
        return "redirect:/list";
    }
}


