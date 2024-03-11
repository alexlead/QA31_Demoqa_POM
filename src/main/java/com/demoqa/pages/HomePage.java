package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card:nth-child(2)")
    WebElement forms;

    public SidePanel getForms() {
        // clickWithJS(forms,0,300);
        click(forms);
        return new SidePanel(driver);
    }

    @FindBy(css = ".fc-button-label")
    WebElement buttonLabel;

    public HomePage confirmCookie() {
//        click(buttonLabel);
        return this;
    }

    @FindBy(css = ".card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePanel getAlertFrameWindows() {
        click(alertsFrameWindows);
        return new SidePanel(driver);
    }

    @FindBy(css=".card:nth-child(4)")
    WebElement widget;
    public SidePanel getWidgets() {

        clickWithJS(widget, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(css=".card:nth-child(1)")
    WebElement brokenElement;
    public SidePanel getElements() {
        clickWithJS(brokenElement, 0, 300);
        return new SidePanel(driver);
    }
}
