package com.example.e2_classiclibrary.controller;

import com.example.e2_classiclibrary.model.DictionaryLanguage;
import com.example.e2_classiclibrary.service.iService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class classicLibrary {

    private final iService iservice;

    public classicLibrary(iService iservice){
        this.iservice = iservice;
    }

    @GetMapping("/")
    public String search() {
        return "library";
    }

    @PostMapping("/search")
    public String meaing(@RequestParam String keyword, Model model) {
        List<DictionaryLanguage> dictionaryLanguages = iservice.findAll();
        for (int i = 0; i < dictionaryLanguages.size(); i++) {
            if (keyword.toLowerCase().equalsIgnoreCase(dictionaryLanguages.get(i).getEnglish())) {
                model.addAttribute("word", (dictionaryLanguages.get(i)).getVietnamese());
                model.addAttribute("key", keyword);
                break;
            } else {
                model.addAttribute("word", "Not Found !");
            }
        }
        return "library";
    }
}

