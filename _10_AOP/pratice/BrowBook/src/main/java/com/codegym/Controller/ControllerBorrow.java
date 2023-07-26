package com.codegym.Controller;

import com.codegym.Entity.Book;
import com.codegym.Entity.Oder;
import com.codegym.Service.IBookService;
import com.codegym.Service.IOderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("ListBook")
public class ControllerBorrow {

    final
    IBookService iBookService;
    IOderService iOderService;

    public ControllerBorrow(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("Home");
        modelAndView.addObject("books", iBookService.findAll());
        return modelAndView;
    }

    @GetMapping("/oder/{id}")
    public ModelAndView showOder(){
        ModelAndView modelAndView = new ModelAndView("Error");
        modelAndView.addObject("oder",new Oder());
        return  modelAndView;
    }

    @PostMapping("/oder/{id}")
    public ModelAndView oder(@PathVariable Integer id) throws Exception {
        Book book = iBookService.findById(id).get();
        if (book.getCount() == 0) {
            return new ModelAndView("Error");
        }

        book.setCount(book.getCount() - 1);

        Oder oder = new Oder();

        long code = (long) (Math.random() * (99999 - 10000) + 10000);
        oder.setCode(code);

        long millis = System.currentTimeMillis();
        oder.setDate(new java.sql.Date(millis));

        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);

        iBookService.create(book);
        iOderService.create(oder);

        ModelAndView modelAndView = new ModelAndView("redirect:/Home");
        return modelAndView;
    }
}
