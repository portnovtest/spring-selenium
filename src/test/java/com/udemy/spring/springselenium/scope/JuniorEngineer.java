package com.udemy.spring.springselenium.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JuniorEngineer {

    @Autowired
    private Salaries salaries;

    public Salaries getSalaries() {
        return salaries;
    }

    public void setAmount(int amount) {
        this.salaries.setAmount(amount);
    }
}
