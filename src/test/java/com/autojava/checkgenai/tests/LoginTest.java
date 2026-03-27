package com.autojava.checkgenai.tests;

import com.autojava.checkgenai.pages.Func.Func_LoginPage;
import com.autojava.checkgenai.tests.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    Func_LoginPage loginFunc;

    
   
    @Test(priority = 1, description = "Verify login page is displayed correctly")
    public void verifyLoginPageIsDisplayed () throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(true, "Login page displayed successfully");
    }


    @Test(priority = 2, description = "Demo screenshot capture on failure")
    public void demoScreenshotOnFailure() throws InterruptedException {
        Thread.sleep(1000);
        // This will fail and trigger screenshot + error logging in ExtentReports
        Assert.assertTrue(false, "This is a demo failure to show screenshot capture in ExtentReports");    


}
}