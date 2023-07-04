package com.codegym.Controller;

import com.codegym.Dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("")
    public ModelAndView showCart(@SessionAttribute(name="product",required = false) CartDto cardDto){
        return new ModelAndView("cart/list","cart",cardDto);
    }
}
