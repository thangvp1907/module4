package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class choose_spice{
    @GetMapping(value = {"" ,"/home"})
    public String DisplayChoose() {
        return "choose_spice";
    }

    @PostMapping(value = "/save")
    public String result(@RequestParam("condiment") String[] condiment, Model model){
        String choose = Arrays.toString(condiment);
        model.addAttribute("choose",choose);
        return "choose_spice";
    }
}
