package com.codegym.Controller;

import com.codegym.Entity.Client;
import com.codegym.Entity.FootballPitches;
import com.codegym.Service.IAddressService;
import com.codegym.Service.IClientService;
import com.codegym.Service.IFootballPitchesService;
import com.codegym.Service.ITimeForRentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Home")
public class ControllerFootball {
    private final IFootballPitchesService iFootballPitchesService;
    private final IAddressService iAddressService;
    private final ITimeForRentService iTimeForRentService;

    private final IClientService iClientService;

    public ControllerFootball(IFootballPitchesService iFootballPitchesService, IAddressService iAddressService, ITimeForRentService iTimeForRentService, IClientService iClientService) {
        this.iFootballPitchesService = iFootballPitchesService;
        this.iAddressService = iAddressService;
        this.iTimeForRentService = iTimeForRentService;
        this.iClientService = iClientService;
    }


    @GetMapping("/List")
    public String listByPage(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<FootballPitches> page = iFootballPitchesService.findAll(pageable);
        model.addAttribute("listPitches", page);
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("time", iTimeForRentService.findAll());
        return "view/List";
    }

    @GetMapping("/Create")
    public String showCreate(Model model) {
        model.addAttribute("listPitches", new FootballPitches());
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("time", iTimeForRentService.findAll());
        return "view/Create";
    }

    @PostMapping("/Create")
    public String doCreate(@Validated @ModelAttribute("listPitches") FootballPitches footballPitches, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("address", iAddressService.findAll());
            model.addAttribute("time", iTimeForRentService.findAll());
            return "/view/Create";
        }
        iFootballPitchesService.create(footballPitches);
        return "redirect:/Home/List";
    }

    @GetMapping("/MyOrder")
    public ModelAndView showMyOrder() {
        ModelAndView modelAndView = new ModelAndView("order/MyOrder");
        modelAndView.addObject("client", iClientService.findAll());
        return modelAndView;
    }

    @GetMapping("/Order/{id}")
    public String showOrder(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listPitches", iFootballPitchesService.findById(id));
        model.addAttribute("client", new Client());
        return "order/Order";
    }

    @PostMapping("/Order")
    public String doOrder(@Validated @ModelAttribute("client") Client client, BindingResult bindingResult,
                          @RequestParam("id") Integer id, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listPitches", iFootballPitchesService.findById(id));
            return "/order/Order";
        }
        client.setFootballPitches(iFootballPitchesService.findById(id));
        iClientService.order(client);
        return "redirect:/Home/MyOrder";
    }

    @GetMapping("/Edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listPitches", iFootballPitchesService.findById(id));
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("time", iTimeForRentService.findAll());
        return "view/Edit";
    }

    @PostMapping("/Edit")
    public String doEdit(@ModelAttribute("listPitches") FootballPitches footballPitches) {
        iFootballPitchesService.create(footballPitches);
        return "redirect:/Home/List";
    }

    @GetMapping("/Detail/{id}")
    public String doDetail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listPitches", iFootballPitchesService.findById(id));
        return "view/Detail";
    }

    @GetMapping("/Delete/{id}")
    public String doDelete(@PathVariable("id") Integer id) {
        iFootballPitchesService.delete(id);
        return "redirect:/Home/List";
    }

    @GetMapping("/Search")
    public String search(@PageableDefault(value = 3) Pageable pageable, @RequestParam("name") String name, Model model) {
        Page<FootballPitches> footballPitches = iFootballPitchesService.findFootballPitchesByNamePitchesContaining(name, pageable);
        model.addAttribute("listPitches", footballPitches);
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("name", name);
        return "view/List";
    }

    @GetMapping("/SearchAddress")
    public String searchAddress(@PageableDefault(value = 3) Pageable pageable, @RequestParam("id") Integer id, Model model) {
        Page<FootballPitches> footballPitches = iFootballPitchesService.findFootballPitchesByAddress_Id(id, pageable);
        model.addAttribute("listPitches", footballPitches);
        model.addAttribute("address", iAddressService.findAll());
        model.addAttribute("id", id);
        return "view/List";
    }
}
