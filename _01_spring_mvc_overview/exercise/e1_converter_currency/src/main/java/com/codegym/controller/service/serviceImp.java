package com.codegym.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceImp implements Iservice {
    @Override
    public double convert(String usd) {
        double result= Double.parseDouble(usd) * 23000;
        return result;
    }
}
