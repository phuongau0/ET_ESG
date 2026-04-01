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

    public Func_HomePage HomeFunc;
    public Func_QuanLychude QLChuDeFunc;

    

    
    /// Module danh sach chủ đề

    @Test(priority = 1, description = "Kiem tra trang QL Chu De duoc hien thi dung")
    public void TC_1_verifyQLChuDePageIsDisplayed () throws InterruptedException {
        Thread.sleep(2000);
        loginFunc = new Func_LoginPage(driver);
        openLoginPage(); 
        loginFunc.loginAs("admin","GREENFEED@2026");
        HomeFunc = new Func_HomePage(driver);
        HomeFunc.clickMasterData();
        HomeFunc.clickQLChuDe();
        Thread.sleep(2000);
        QLChuDeFunc = new Func_QuanLychude(driver);
        String pageTitle = QLChuDeFunc.getPageTitle();
        Assert.assertEquals(pageTitle, "Quản lý chủ đề", "Page title should be 'Quản lý chủ đề'");  

    }

    @Test(priority = 2, description = "Kiem tra cac column duoc hien thi dung")
    public void TC_2_VerifyColumnQLChuDe () throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc = new Func_QuanLychude(driver);
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(1, "Mã chủ đề"), "Column 1 should be 'Mã chủ đề'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(2, "Tên chủ đề"), "Column 2 should be 'Tên chủ đề'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(3, "Trụ cột"), "Column 3 should be 'Trụ cột'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(4, "Trạng thái"), "Column 4 should be 'Trạng thái'");
    }

    // Module quản lý chủ đề

    @Test(priority = 3, description = "Kiem tra khi click vao form them moi")
    public void TC_3_VerifyAddNewTopicForm () throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc.clickAddButton();
        Thread.sleep(2000);
        Assert.assertTrue(QLChuDeFunc.verifyAddNewTopicForm(), "Add new topic form should be displayed");
    }


    @Test(priority = 4, description = "Kiem tra khi nhap du lieu hop le vao ma chu de")
    public void TC_4_VerifyMaChuDeWhenInputValidData () throws InterruptedException {
        Thread.sleep(2000);
        String actualMaChuDe = QLChuDeFunc.verifyMaChuDewheninputValiddata();
        Assert.assertEquals(actualMaChuDe, "KITU001", "Ma Chu De should be 'KITU001'");
    }   
    
    @Test(priority = 5, description = "Kiem tra khi nhap du lieu khong hop le vao ma chu de")
    public void TC_5_VerifyMaChuDeWhenInputInvalidData () throws InterruptedException {
        Thread.sleep(2000);
        String actualMaChuDe = QLChuDeFunc.verifyMaChuDewheninputInvaliddata();
        Assert.assertEquals(actualMaChuDe, "KITU001DAI", "Ma Chu De should be 'KITU001DAI'");
    } 

    
}