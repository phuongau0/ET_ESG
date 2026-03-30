package com.autojava.checkgenai.tests;
import com.autojava.checkgenai.listeners.ExtentReportListener;
import com.autojava.checkgenai.listeners.TestListener;
import com.autojava.checkgenai.pages.Func.Func_HomePage;
import com.autojava.checkgenai.pages.Func.Func_LoginPage;
import com.autojava.checkgenai.pages.Func.Func_QuanLychude;
import com.autojava.checkgenai.tests.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

@Listeners({ExtentReportListener.class, TestListener.class})
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
        Assert.assertEquals(pageTitle, "Quản lý chủ đề", "Page title should be 'Quản lý chủ đề'");  

    }

    @Test(priority = 2, dependsOnMethods = "TC_1_verifyQLChuDePageIsDisplayed", description = "Kiem tra cac column duoc hien thi dung")
    public void TC_2_VerifyColumnQLChuDe () throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(1, "Mã chủ đề"), "Column 1 should be 'Mã chủ đề'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(2, "Tên chủ đề"), "Column 2 should be 'Tên chủ đề'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(3, "Trụ cột"), "Column 3 should be 'Trụ cột'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(4, "Trạng thái"), "Column 4 should be 'Trạng thái'");


    }


}