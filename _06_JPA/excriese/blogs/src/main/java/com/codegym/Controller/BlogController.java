package com.codegym.Controller;

import com.codegym.Entity.Blog;
import com.codegym.Service.IService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final IService service;


    public BlogController(IService service) {
        this.service = service;
    }


    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("Blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("Blog") Blog blog) {
        service.create(blog);
        return "redirect:/blog/list";
    }


    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("Blog", service.findAll());
        return "/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/blog/list";
    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("Blog", service.findById(id));
        return "/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", service.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        service.update(blog);
        return "redirect:/blog/list";
    }

}
