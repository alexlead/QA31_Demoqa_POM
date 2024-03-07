package com.demoqa.tests;

import com.demoqa.pages.BrowseWindowsTabPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowseWindowsTabTest extends TestBase {


    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectBrowserWindows();
    }

    @Test
    public void selectNewTabTest () {
        new BrowseWindowsTabPage(driver).switchToNextTab(1).verifyNewTabText("This is a sample page");
    }
}
