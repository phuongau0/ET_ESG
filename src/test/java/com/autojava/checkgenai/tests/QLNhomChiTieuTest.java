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
    public Func_QuanLychude QLChuDeFunc;
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

    @Test(priority = 5, description = "Kiem tra khi nha du lieu hop le ma nhom chi tieu")
    public void TC_5_VerifyMaNhomChiTieuWhenInputValidData() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC5 : Verify Ma Nhom Chi Tieu field accepts valid input");
        logger.info("1. Entering valid Ma Nhom Chi Tieu 'KITU001' into Ma Nhom Chi Tieu field");
        String actualMaNhomChiTieu = QLNhomChiTieuFunc.verifyMaNhomChiTieuwheninputValiddata();
        logger.info("2. Verifying Ma Nhom Chi Tieu field accepts valid input and displays 'KITU001'");
        Assert.assertEquals(actualMaNhomChiTieu, "KITU001", "Ma Nhom Chi Tieu should be 'KITU001'");
    }

    @Test(priority = 6, description = "Kiem tra khi nhap du lieu khong hop le ma nhom chi tieu")
    public void TC_6_VerifyMaNhomChiTieuWhenInputInvalidData() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC6 : Verify Ma Nhom Chi Tieu field does not accept invalid input");
        logger.info("1. Entering invalid Ma Nhom Chi Tieu 'KITU@001' into Ma Nhom Chi Tieu field");
        String actualMaNhomChiTieu = QLNhomChiTieuFunc.verifyMaNhomChiTieuwheninputInvaliddata();
        logger.info("2. Verifying Ma Nhom Chi Tieu field does not accept invalid input and displays 'KITUU001DAILAM'");
        Assert.assertEquals(actualMaNhomChiTieu, "KITU001DAI", "Ma Nhom Chi Tieu should be 'KITUU001DAILAM'");

    }

    @Test(priority = 7, description = "Kiem tra khi khong nhap ma nhom chi tieu")
    public void TC_7_VerifyEmptyMaNhomChiTieu() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC7 : Verify error message when Ma Nhom Chi Tieu field is empty");
        logger.info("1. Leaving Ma Nhom Chi Tieu field empty and clicking 'Lưu' button");
        String actualError = QLNhomChiTieuFunc.verifyEmtyMaNhomChiTieu();
        logger.info("2. Verifying error message 'Vui lòng nhập thông tin này' is displayed");
        Assert.assertEquals(actualError, "Vui lòng nhập thông tin này",
                "Error message should be 'Vui lòng nhập thông tin'");
    }

    @Test(priority = 8, description = "Kiem tra khi nhap du lieu hop le ten nhom chi tieu")
    public void TC_8_VerifyTenNhomChiTieuWhenInputValidData() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC8 : Verify Ten Nhom Chi Tieu field accepts valid input");
        logger.info("1. Entering valid Ten Nhom Chi Tieu 'Nhóm chỉ tiêu 1' into Ten Nhom Chi Tieu field");
        String actualTenNhomChiTieu = QLNhomChiTieuFunc.verifyTenNhomChiTieuwheninputValiddata();
        logger.info("2. Verifying Ten Nhom Chi Tieu field accepts valid input and displays 'Nhóm chỉ tiêu 1'");
        Assert.assertEquals(actualTenNhomChiTieu, "Tên nhóm chỉ tiêu 1",
                "Ten Nhom Chi Tieu should be 'Nhóm chỉ tiêu 1'");
    }

    @Test(priority = 9, description = "Kiem tra khi nhap du lieu khong hop le ten nhom chi tieu")
    public void TC_9_VerifyTenNhomChiTieuWhenInputInvalidData() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC9 : Verify Ten Nhom Chi Tieu field does not accept invalid input");
        logger.info("1. Entering invalid Ten Nhom Chi Tieu 'Nhóm chỉ tiêu 1@' into Ten Nhom Chi Tieu field");
        String actualTenNhomChiTieu = QLNhomChiTieuFunc.verifyTenNhomChiTieuwheninputInvaliddata();
        logger.info(
                "2. Verifying Ten Nhom Chi Tieu field does not accept invalid input and displays 'Nhóm chỉ tiêu 1DAILAM'");
        Assert.assertEquals(actualTenNhomChiTieu,
                "Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tả",
                "Ten Nhom Chi Tieu should be 'Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tả'");
    }

    @Test(priority = 10, description = "Kiem tra khi khong nhap ten nhom chi tieu")
    public void TC_10_VerifyEmptyTenNhomChiTieu() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC10 : Verify error message when Ten Nhom Chi Tieu field is empty");
        logger.info("1. Leaving Ten Nhom Chi Tieu field empty and clicking 'Lưu' button");
        String actualError = QLNhomChiTieuFunc.verifyEmtyTenNhomChiTieu();
        logger.info("2. Verifying error message 'Vui lòng nhập thông tin này' is displayed");
        Assert.assertEquals(actualError, "Vui lòng nhập thông tin này",
                "Error message should be 'Vui lòng nhập thông tin này'");

    }

    @Test(priority = 11, description = "Kiem tra khi nhap du lieu chu de khong hop le")
    public void TC_11_VerifyChuDeWhenInputInvalidData() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC11 : Verify error message when invalid Chu De is selected");
        logger.info("1. Selecting invalid Chu De 'Chủ đề 1' from Chu De dropdown");
        QLNhomChiTieuFunc.NhapChuDe("@@");
        Assert.assertEquals(QLNhomChiTieuFunc.VerifySearchResultEmpty(), "Trống",
                "Error message should be 'Không có dữ liệu' when selecting invalid Chu De");
    }

    @Test(priority = 12, description = "Open new tab and get topic info")
    public void TC_12_VerifyChuDeTruCotWhenInputValid() throws InterruptedException {

        String originalWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://esg.exceltech.vn/main/master-data/topics");
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("topics"));

        QLChuDeFunc = new Func_QuanLychude(driver);
        String TenChuDe = QLChuDeFunc.GetTextTenChuDeRecord();
        String TenTruCot = QLChuDeFunc.GetTextTruCotRecord();

        System.out.println(TenTruCot);
        System.out.println(TenChuDe);
        Thread.sleep(1000);

        // Đóng tab mới, quay lại tab gốc
        driver.close();
        driver.switchTo().window(originalWindow);

        QLNhomChiTieuFunc = new Func_QuanLyNhomChiTieu(driver);
        // QLNhomChiTieuFunc.SwitchTab();

        QLNhomChiTieuFunc.NhapChuDe(TenChuDe);

        Thread.sleep(5000);
        QLNhomChiTieuFunc.SendkeysENTER();
        Thread.sleep(3000);
        Assert.assertEquals(QLNhomChiTieuFunc.GetTextChuDeInput(), TenChuDe);
        Assert.assertEquals(QLNhomChiTieuFunc.GetTextTruCotInput(), TenTruCot);
        System.out.println("✅ Back to original tab: " + driver.getCurrentUrl());

    }

    @Test(priority = 13, description = "Kiem tra khi khong chon chu de nao")
    public void TC_13_VerifyEmptyChuDe() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("Starting test: TC13 : Verify error message when no option is selected in 'Trụ cột' select box");
        logger.info("1. Leaving 'Chủ đề' select box with no option selected    and clicking 'Lưu' button");
        String actualError = QLNhomChiTieuFunc.verifyEmtyTenChuDe();
        logger.info("2. Verifying error message 'Vui lòng chọn thông tin này' is displayed");
        Assert.assertEquals(actualError, "Vui lòng chọn thông tin này",
                "Error message should be 'Vui lòng chọn thông tin'");

    }

}
