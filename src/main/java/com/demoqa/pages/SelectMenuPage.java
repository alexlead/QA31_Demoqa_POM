package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.List;

public class SelectMenuPage extends BasePage{


    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);

        System.out.println("**********************************");
        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        System.out.println("**********************************");

        System.out.println(select.getFirstSelectedOption().getText()+ " is selected");
        return this;
    }

    @FindBy(id="react-select-4-input")
    WebElement multiSelectMenu;

    @FindBy(css = "html")
    WebElement space;
    public SelectMenuPage multiSelect(String[] colors) {

        for (int i = 0; i < colors.length; i++) {
            if(colors[i] != null) {
                multiSelectMenu.sendKeys(colors[i]);
                multiSelectMenu.sendKeys(Keys.ENTER);
            }
        }
        click(space);

        return this;
    }


    @FindBy(id="cars")
    WebElement standardMultiSelectMenu;

    public SelectMenuPage standardMultiSelect(int index) {
        Select multi = new Select(standardMultiSelectMenu);
        if(multi.isMultiple()) {
            multi.selectByIndex(index);
        }
        return this;
    }
}
