package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowseWindowsTabPage extends BasePage{
    public BrowseWindowsTabPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="tabButton")
    WebElement tabButton;

    public BrowseWindowsTabPage switchToNextTab( int index) {
        click(tabButton);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public BrowseWindowsTabPage verifyNewTabText(String tabMessage) {
        Assert.assertTrue(shouldHaveText(sampleHeading,tabMessage, 15 ));
        return this;
    }

    private boolean shouldHaveText(WebElement sampleHeading, String tabMessage, int i) {
        return new WebDriverWait(driver, Duration.ofSeconds(i)).until(ExpectedConditions.textToBePresentInElement(sampleHeading, tabMessage));
    }
}
