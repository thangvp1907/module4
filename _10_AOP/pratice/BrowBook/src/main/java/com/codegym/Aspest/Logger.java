package com.codegym.Aspest;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing(value = "execution(* com.codegym.Controller.ControllerBorrow.oder(..))")
    public void checkEx(){
        System.out.println("-----------");
        System.out.println("ERROR");
    }

    @After(value = "execution(* com.codegym.Controller.ControllerBorrow.oder(..))")
    public void DONE(){
        System.out.println("-----------");
        System.out.println("done");
    }
}
