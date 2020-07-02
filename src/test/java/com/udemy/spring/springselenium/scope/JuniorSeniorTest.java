package com.udemy.spring.springselenium.scope;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class JuniorSeniorTest extends SpringBaseTestNGTest {

    @Autowired
    private JuniorEngineer junior;

    @Autowired
    private SeniorEngineer senior;

    @Test
    public void scopeTest() {
        this.junior.setAmount(100);
        System.out.println("Junior :: " + this.junior.getSalaries().getAmount());
        this.senior.setAmount(200);
        System.out.println("Senior :: " + this.senior.getSalaries().getAmount());
        System.out.println("Junior :: " + this.junior.getSalaries().getAmount());
    }
}
