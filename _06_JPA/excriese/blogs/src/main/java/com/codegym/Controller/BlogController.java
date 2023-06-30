package com.codegym.Controller;

import com.codegym.Entity.Blog;
import com.codegym.Service.IServiceBlog;
import com.codegym.Service.IServiceCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final IServiceCategory iServiceCategory;

    private final IServiceBlog iServiceBlog;


    public BlogController(IServiceBlog iServiceBlog, IServiceCategory iServiceCategory) {
        this.iServiceBlog = iServiceBlog;
        this.iServiceCategory = iServiceCategory;
    }


    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("Blog", new Blog());
        model.addAttribute("categories",iServiceCategory.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("Blog") Blog blog) {
        blog.setCategory(iServiceCategory.findById(blog.getCategory().getIdCategory()));
        iServiceBlog.create(blog);
        return "redirect:/blog/list";
    }


//    @GetMapping("/list")
//    public String showList(Model model) {
//        model.addAttribute("blog", iServiceBlog.findAll());
//        model.addAttribute("Category",iServiceCategory.findAll());
//        return "/list";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iServiceBlog.deleteById(id);
        return "redirect:/blog/list";
    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("Blog", iServiceBlog.findById(id));
        return "/detail";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("blog", iServiceBlog.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("blog") Blog blog) {
        iServiceBlog.update(blog);
        return "redirect:/blog/list";
    }


    @GetMapping("/list")
    public ModelAndView listBlog(Pageable pageable){
        Page<Blog> listBlog = iServiceBlog.findAllPage(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blog",listBlog);
        return modelAndView;
    }

}
