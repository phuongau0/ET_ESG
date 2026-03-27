package com.autojava.checkgenai.tests;

import com.autojava.checkgenai.pages.Func.Func_HomePage;
import com.autojava.checkgenai.pages.Func.Func_LoginPage;
import com.autojava.checkgenai.pages.Func.Func_QuanLychude;
import com.autojava.checkgenai.tests.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class QLChuDeTest extends BaseTest {

    private Func_HomePage HomeFunc;
    private Func_QuanLychude QLChuDeFunc;

    

    @Test(priority = 1, description = "Kiem tra trang QL Chu De duoc hien thi dung")
    public void TC_1_verifyQLChuDePageIsDisplayed () throws InterruptedException {
        Thread.sleep(2000);
        HomeFunc = new Func_HomePage(driver);
        HomeFunc.clickMasterData();
        HomeFunc.clickQLChuDe();
        Thread.sleep(2000);
        QLChuDeFunc = new Func_QuanLychude(driver);
        String pageTitle = QLChuDeFunc.getPageTitle();
        Assert.assertEquals(pageTitle, "Quảnd lý chủ đề", "Page title should be 'Quản lý chủ đề'");  

    }

    /* 
    @Test(priority = 1, description = "Kiem tra trang QL Chu De duoc hien thi dung")
    public void TC2_VerifyListTable () throws InterruptedException {
        Thread.sleep(2000);
        HomeFunc = new Func_HomePage(driver);
        HomeFunc.clickMasterData();
        HomeFunc.clickQLChuDe();
        Thread.sleep(2000);
        QLChuDeFunc = new Func_QuanLychude(driver);
        String pageTitle = QLChuDeFunc.getPageTitle();
        Assert.assertEquals(pageTitle, "Quản lý chủ đề", "Page title should be 'Quản lý chủ đề'");  

    }
*/


}