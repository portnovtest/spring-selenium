package com.udemy.spring.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Television {

    @Value("${tv.name:sony}")
    private String name;

    public Television() {
        System.out.println(String.format("Inside the constructor : %s", this.name));
    }

    @PostConstruct
    private void init() {
        System.out.println(String.format("Inside the init : %s", this.name));
        System.out.println("TV is turned on...");
    }

    public void playMovie() {
        for (int i = 1; i < 6; i++) {
            System.out.println(String.format("Playing scene %s", i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    public void turnOff() {
        System.out.println("TV is turned off...");
    }
}
