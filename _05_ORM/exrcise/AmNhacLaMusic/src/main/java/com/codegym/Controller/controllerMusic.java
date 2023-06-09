package com.codegym.Controller;

import com.codegym.Entity.Music;
import com.codegym.Entity.MusicForm;
import com.codegym.Service.iServiceMusic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/list_music")
public class controllerMusic {
    private final iServiceMusic serviceMusic;


    public controllerMusic(iServiceMusic serviceMusic) {
        this.serviceMusic = serviceMusic;
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("music", serviceMusic.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("MusicForm",new MusicForm());
        return "/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("musicForm") MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getPlay();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getPlay(), new File( file + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        serviceMusic.create(music);
        redirectAttributes.addFlashAttribute("mess", "them thanh cong");
        return "redirect:/list_music/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        serviceMusic.delete(id);
        return "redirect:/list_music";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        Music music = serviceMusic.findById(id);
        model.addAttribute("music",music);
        return "/update";
    }

}
