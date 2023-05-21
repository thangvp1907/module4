package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "/home")
    public String displayCalculator() {
        return "calculator/calculator_home";
    }

    @PostMapping(value = "/calculators")
    public String showResult(@RequestParam("inputOne") double one,
                             @RequestParam("inputTwo") double two,
                             @RequestParam("enter") String enter,
                             Model model) {
        double result = 0;
        switch (enter) {
            case "X":
                result = one * two;
                break;
            case "+":
                result = one + two;
                break;
            case "/":
                try {
                    result = one / two;
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "-":
                result = one - two;
                break;
        }
        model.addAttribute("result", result);
        return "calculator/calculator_home";
    }
}
