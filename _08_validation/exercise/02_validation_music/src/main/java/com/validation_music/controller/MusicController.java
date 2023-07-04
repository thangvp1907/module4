package com.validation_music.controller;

import com.validation_music.dto.MusicDto;
import com.validation_music.model.Music;
import com.validation_music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String showMusic(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

//        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);

            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
            return "redirect:/music";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("musicList", iMusicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        iMusicService.remove(music.getId());
        redirect.addFlashAttribute("success", "Removed the song successfully!");
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("musicDto", iMusicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            iMusicService.update(music);
            redirectAttributes.addFlashAttribute("messa", "edit successfully!");
            return "redirect:/music";
        }
    }
}
