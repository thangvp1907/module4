package com.example.e2_classiclibrary.model;

public class DictionaryLanguage {
    private String vietnamese;
    private String english;

    public DictionaryLanguage() {

    }

    public DictionaryLanguage(String vietnamese, String english) {
        this.vietnamese = vietnamese;
        this.english = english;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
