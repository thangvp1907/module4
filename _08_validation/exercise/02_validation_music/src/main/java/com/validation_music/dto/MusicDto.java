package com.validation_music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;

    @NotBlank(message = "Trường này không được để trống")
    @Size(max = 800,message = "Trường này không quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "trường này không chứa kí tự đặt biệt và dấu tiếng việt")
    private String musicName;

    @NotBlank(message = "Trường này không được để trống")
    @Size(max = 300,message = "Trường này không quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "trường này không chứa kí tự đặt biệt và dấu tiếng việt")
    private String singerName;

    @NotBlank(message = "Trường này không được để trống")
    @Size(max = 1000,message = "Trường này không quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$",message = "Trường này ngoại trừ dấu phẩy thì kí tự dặt biệt không nhận")
    private String category;

    public MusicDto() {
    }

    public MusicDto(int id, String musicName, String singerName, String category) {
        this.id = id;
        this.musicName = musicName;
        this.singerName = singerName;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
