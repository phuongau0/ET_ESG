package com.autojava.checkgenai.tests;

import com.autojava.checkgenai.listeners.ExtentReportListener;
import com.autojava.checkgenai.listeners.TestListener;
import com.autojava.checkgenai.pages.Func.Func_HomePage;
import com.autojava.checkgenai.pages.Func.Func_LoginPage;
import com.autojava.checkgenai.pages.Func.Func_QuanLychude;
import com.autojava.checkgenai.pages.Func.Func_QuanLyNhomChiTieu;
import com.autojava.checkgenai.tests.test.BaseTest;
import com.beust.ah.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

@Listeners({ TestListener.class, ExtentReportListener.class })
public class QLNhomChiTieuTest extends BaseTest {

    public Func_HomePage HomeFunc;
    public Func_LoginPage LoginPageFunc;
    // public Func_QuanLychude QLChuDeFunc;
    public Func_QuanLyNhomChiTieu QLNhomChiTieuFunc;
    private static final Logger logger = LoggerFactory.getLogger(QLNhomChiTieuTest.class);

    // Module danh sach nhóm chỉ tiêu

    @Test(priority = 1, description = "Verify that the 'Quản lý nhóm chỉ tiêu' page is displayed correctly")
    public void TC_1_VerifyQuanLyNhomChiTieuPageDisplayed() throws InterruptedException {
        logger.info("TC_1: Verify that the 'Quản lý nhóm chỉ tiêu' page is displayed correctly");
        logger.info("Starting test: TC1 : Verify Quan Ly Chu De page is displayed correctly");
        Thread.sleep(2000);
        loginFunc = new Func_LoginPage(driver);
        logger.info("1. Opening login page");
        openLoginPage();
        logger.info("2. Logging in with valid credentials");
        loginFunc.loginAs("admin", "GREENFEED@2026");
        HomeFunc = new Func_HomePage(driver);
        logger.info("3. Navigating to Quan Ly Chu De page");
        HomeFunc.clickMasterData();
        logger.info("4. Clicking on 'Quản lý nhóm chỉ tiêu' menu item");
        HomeFunc.clickQLNhomChiTieu();
        Thread.sleep(2000);
        logger.info("5. Verifying Quan Ly Chu De page is displayed");
        QLNhomChiTieuFunc = new Func_QuanLyNhomChiTieu(driver);
        String pageTitStringle = QLNhomChiTieuFunc.getPageTitle();
        Assert.assertEquals(pageTitStringle, "Quản lý nhóm chỉ tiêu", "Page title should be 'Quản lý nhóm chỉ tiêu'");

    }

    @Test(priority = 2, description = "Kiem tra cac column duoc hien thi dung")
    public void TC_2_VerifyColumnQLNhomChiTieu() throws InterruptedException {
        Thread.sleep(2000);
        QLNhomChiTieuFunc = new Func_QuanLyNhomChiTieu(driver);
        logger.info("Starting test: TC2 : Verify columns in Quan Ly Nhom Chi Tieu page");
        logger.info("1. Verifying column 1 is 'Mã nhóm chỉ tiêu'");
        Assert.assertTrue(QLNhomChiTieuFunc.verifyColumnByIndex(1, "Mã nhóm chỉ tiêu"),
                "Column 1 should be 'Mã nhóm chỉ tiêu'");
        logger.info("2. Verifying column 2 is 'Tên nhóm chỉ tiêu'");
        Assert.assertTrue(QLNhomChiTieuFunc.verifyColumnByIndex(2, "Tên nhóm chỉ tiêu"),
                "Column 2 should be 'Tên nhóm chỉ tiêu'");
        logger.info("3. Verifying column 3 is ' chủ đề'");
        Assert.assertTrue(QLNhomChiTieuFunc.verifyColumnByIndex(3, "Chủ đề"), "Column 3 should be 'Chủ đề'");
        logger.info("4. Verifying column 4 is 'Trụ cột'");
        Assert.assertTrue(QLNhomChiTieuFunc.verifyColumnByIndex(4, "Trụ cột"), "Column 4 should be 'Trụ cột'");
        logger.info("5. Verifying column 5 is 'Trạng thái'");
        Assert.assertTrue(QLNhomChiTieuFunc.verifyColumnByIndex(5, "Trạng thái"), "Column 5 should be 'Trạng thái'");
    }

    // Module quản lý nhóm chỉ tiêu

    @Test(priority = 3, description = "Kiem tra khi click vao form them moi")
    public void TC_3_VerifyAddNewNhomChiTieuForm() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC3 : Verify Add New Nhom Chi Tieu form is displayed correctly");
        logger.info("1. Clicking on 'Thêm mới' button");
        QLNhomChiTieuFunc.clickAddButton();
        Thread.sleep(2000);
        logger.info("2. Verifying Add New Nhom Chi Tieu form is displayed");
        Assert.assertTrue(QLNhomChiTieuFunc.verifyAddNewNhomChiTieuForm(),
                "Add new nhom chi tieu form should be displayed");
    }

    @Test(priority = 4, description = "Kiem tra validate disabled Tru cot")
    public void TC_4_VerifyValidateDisabledTruCot() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC4 : Verify that 'Trụ cột' field is disabled when 'Chủ đề' is not selected");
        logger.info("1. Verifying 'Trụ cột' field is disabled when 'Chủ đề' is not selected");
        Assert.assertTrue(QLNhomChiTieuFunc.verifyTruCotDisabled(),
                "'Trụ cột' field should be disabled when 'Chủ đề' is not selected");

    }

    @Test(priority = 5 , description="Kiem tra khi nha du lieu hop le ma nhom chi tieu")
    public void TC_5_VerifyMaNhomChiTieuWhenInputValidData() throws InterruptedException {
        Thread.sleep(2000);
                logger.info("Starting test: TC5 : Verify Ma Nhom Chi Tieu field accepts valid input");
                logger.info("1. Entering valid Ma Nhom Chi Tieu 'KITU001' into Ma Nhom Chi Tieu field");
                String actualMaNhomChiTieu = QLNhomChiTieuFunc.verifyMaNhomChiTieuwheninputValiddata();
                logger.info("2. Verifying Ma Nhom Chi Tieu field accepts valid input and displays 'KITU001'");
                Assert.assertEquals(actualMaNhomChiTieu, "KITU001", "Ma Nhom Chi Tieu should be 'KITU001'");
        }
}