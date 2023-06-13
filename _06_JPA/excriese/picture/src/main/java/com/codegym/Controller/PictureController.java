package com.codegym.Controller;

import com.codegym.Entity.Picture;
import com.codegym.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Controller
public class PictureController {
    private final IService service;

    public PictureController(IService service) {
        this.service = service;
    }

    @GetMapping("/view")
    public String showPicture(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        String todayString =  today.format(formatter);
        model.addAttribute("pictures", service.findAllToday(todayString));
        model.addAttribute("picture", new Picture());
        return "/view";
    }

    @PostMapping("/saveComment")
    public String doCreate(@ModelAttribute("picture")Picture picture){
        service.addComment(picture);
        return "redirect:/view";
    }

    @GetMapping("/likeComment")
    public String likeComment(@RequestParam("id")int id) throws Exception {
        service.addLike(service.findById(id));
        return "redirect:/view";
    }
}
