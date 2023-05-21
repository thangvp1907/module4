package com.example.e2_classiclibrary.service;

import com.example.e2_classiclibrary.model.DictionaryLanguage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class serviceImp implements iService{
    private static Map<Integer, DictionaryLanguage> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(1, new DictionaryLanguage("xin chào", "hello"));
        dictionaryMap.put(2, new DictionaryLanguage("con chó", "dog"));
        dictionaryMap.put(3, new DictionaryLanguage("con mèo", "cat"));
        dictionaryMap.put(4, new DictionaryLanguage("con hổ", "Lion"));
        dictionaryMap.put(5, new DictionaryLanguage("con chuột", "mouse"));
        dictionaryMap.put(6, new DictionaryLanguage("con gà", "chicken"));
    }

    //add vao 1 list findAll
    @Override
    public List<DictionaryLanguage> findAll(){
        return new ArrayList<>(dictionaryMap.values());
    }
}
