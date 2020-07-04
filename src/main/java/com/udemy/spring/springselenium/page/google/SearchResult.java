package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.kelvin.annotation.PageFragment;
import com.udemy.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends Base {

    @FindBy(css = "div.rc")
    private List<WebElement> results;

    @Override
    public boolean isLoaded() {
        return this.wait.until(d -> !this.results.isEmpty());
    }

    public int getCount() {
        return this.results.size();
    }
}
