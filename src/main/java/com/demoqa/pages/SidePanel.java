package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage{

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;
    public PracticeFormPage selectAlerts() {
        click(alerts);
        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;
    public PracticeFormPage selectBrowserWindows() {

        click(browserWindows);

        return new PracticeFormPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;
    public SelectMenuPage getSelectMenu() {
        clickWithJS(selectMenu, 0, 700);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement selectBroken;
    public SelectMenuPage selectBrokenLinks() {
        clickWithJS(selectBroken, 0, 200);
        return new SelectMenuPage(driver);
    }
}
