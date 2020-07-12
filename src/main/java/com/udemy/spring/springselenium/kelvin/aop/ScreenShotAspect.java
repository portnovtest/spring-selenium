package com.udemy.spring.springselenium.kelvin.aop;

import com.udemy.spring.springselenium.kelvin.annotation.TakeScreenShot;
import com.udemy.spring.springselenium.kelvin.service.ScreenShotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenShotAspect {

    @Autowired
    private ScreenShotService screenShotService;

    @After("@annotation(takeScreenShot)")
    public void after(TakeScreenShot takeScreenShot) throws IOException {
        this.screenShotService.takeScreenShot();
    }
}
