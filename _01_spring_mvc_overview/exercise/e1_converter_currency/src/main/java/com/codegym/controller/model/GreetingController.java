package com.codegym.controller.model;
import com.codegym.controller.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private final Iservice iservice;

    public GreetingController(Iservice iservice){
        this.iservice = iservice;
    }

    @GetMapping("/")
    public String calulate(){
        return "/index";
    }

    @PostMapping("/usd")
    public String currency(String usd, Model model) {
        double result = iservice.convert(usd);
        model.addAttribute("result", result);
        return "/index";
    }
}