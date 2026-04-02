package com.autojava.checkgenai.tests;

import com.autojava.checkgenai.listeners.ExtentReportListener;
import com.autojava.checkgenai.listeners.TestListener;
import com.autojava.checkgenai.pages.Func.Func_HomePage;
import com.autojava.checkgenai.pages.Func.Func_LoginPage;
import com.autojava.checkgenai.pages.Func.Func_QuanLychude;
import com.autojava.checkgenai.tests.test.BaseTest;
import com.beust.ah.A;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

@Listeners({ ExtentReportListener.class, TestListener.class })
public class QLChuDeTest extends BaseTest {

    public Func_HomePage HomeFunc;
    public Func_QuanLychude QLChuDeFunc;

    /// Module danh sach chủ đề

    @Test(priority = 1, description = "Kiem tra trang QL Chu De duoc hien thi dung")
    public void TC_1_verifyQLChuDePageIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        loginFunc = new Func_LoginPage(driver);
        openLoginPage();
        loginFunc.loginAs("admin", "GREENFEED@2026");
        HomeFunc = new Func_HomePage(driver);
        HomeFunc.clickMasterData();
        HomeFunc.clickQLChuDe();
        Thread.sleep(2000);
        QLChuDeFunc = new Func_QuanLychude(driver);
        String pageTitle = QLChuDeFunc.getPageTitle();
        Assert.assertEquals(pageTitle, "Quản lý chủ đề", "Page title should be 'Quản lý chủ đề'");

    }

    @Test(priority = 2, description = "Kiem tra cac column duoc hien thi dung")
    public void TC_2_VerifyColumnQLChuDe() throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc = new Func_QuanLychude(driver);
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(1, "Mã chủ đề"), "Column 1 should be 'Mã chủ đề'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(2, "Tên chủ đề"), "Column 2 should be 'Tên chủ đề'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(3, "Trụ cột"), "Column 3 should be 'Trụ cột'");
        Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(4, "Trạng thái"), "Column 4 should be 'Trạng thái'");
    }

    // Module quản lý chủ đề

    @Test(priority = 3, description = "Kiem tra khi click vao form them moi")
    public void TC_3_VerifyAddNewTopicForm() throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc.clickAddButton();
        Thread.sleep(2000);
        Assert.assertTrue(QLChuDeFunc.verifyAddNewTopicForm(), "Add new topic form should be displayed");
    }

    @Test(priority = 4, description = "Kiem tra khi nhap du lieu hop le vao ma chu de")
    public void TC_4_VerifyMaChuDeWhenInputValidData() throws InterruptedException {
        Thread.sleep(2000);
        String actualMaChuDe = QLChuDeFunc.verifyMaChuDewheninputValiddata();
        Assert.assertEquals(actualMaChuDe, "KITU001", "Ma Chu De should be 'KITU001'");
    }

    @Test(priority = 5, description = "Kiem tra khi nhap du lieu khong hop le vao ma chu de")
    public void TC_5_VerifyMaChuDeWhenInputInvalidData() throws InterruptedException {
        Thread.sleep(2000);
        String actualMaChuDe = QLChuDeFunc.verifyMaChuDewheninputInvaliddata();
        Assert.assertEquals(actualMaChuDe, "KITU001DAI", "Ma Chu De should be 'KITU001DAI'");
    }

    @Test(priority = 6, description = "Kiem tra khi khong nhap ma chu de")
    public void TC_6_VerifyEmptyMaChuDe() throws InterruptedException {
        Thread.sleep(2000);
        String actualError = QLChuDeFunc.verifyEmtyMaChuDe();
        Assert.assertEquals(actualError, "Vui lòng nhập thông tin này",
                "Error message should be 'Vui lòng nhập thông tin'");
    }

    @Test(priority = 7, description = "Kiem tra khi nhap ten chu de hop le ")
    public void TC_7_VerifyValidTenChuDe() throws InterruptedException {
        Thread.sleep(2000);
        String actualTenChuDe = QLChuDeFunc.verifyTenChuDewheninputValiddata();
        Assert.assertEquals(actualTenChuDe, "Chủ đề 1", "Ten Chu De should be 'Chủ đề 1'");
    }

    @Test(priority = 8, description = "Kiem tra khi nhap ten chu de hop le ")
    public void TC_8_VerifyInvalidTenChuDe() throws InterruptedException {
        Thread.sleep(2000);
        String actualTenChuDe = QLChuDeFunc.verifyTenChuDewheninputInvaliddata();
        Assert.assertEquals(actualTenChuDe,
                "Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tả",
                "Ten Chu De should be 'Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tả'");
    }

    @Test(priority = 9, description = "Kiem tra khi ten chu de bo trong ")
    public void TC_9_VerifyInvalidTenChuDe() throws InterruptedException {
        Thread.sleep(2000);
        String actualError = QLChuDeFunc.verifyEmtyTenChuDe();
        Assert.assertEquals(actualError, "Vui lòng nhập thông tin này",
                "Error message should be 'Vui lòng nhập thông tin'");
    }

    @Test(priority = 10, description = "Kiem tra lay phan tu dau tien trong selectbox tru cot")
    public void TC10_GetFirstTruCot() throws InterruptedException {
        QLChuDeFunc.clickTruCotSelect();
        Thread.sleep(1000);

        // Get phần tử đầu tiên
        String firstOption = QLChuDeFunc.GetitemTruCot();

        Assert.assertEquals(firstOption, "Năng lượng và môi trường", "First option in 'Trụ cột' should be 'Trụ cột 1'");
    }

    @Test(priority = 11, description = "Kiem tra khi khong chon tru cot nao")
    public void TC_11_VerifyEmptyTruCot() throws InterruptedException {
        Thread.sleep(2000);
        String actualError = QLChuDeFunc.verifyEmtyTruCot();
        Assert.assertEquals(actualError, "Vui lòng chọn thông tin này",
                "Error message should be 'Vui lòng chọn thông tin'");

    }

    @Test(priority = 12, description = "Kiem tra ma chu de trung")
    public void TC_12_VerifyMaChuDeTrung() throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc.GetMaChuDeTrung();
        Thread.sleep(1000);
        QLChuDeFunc.clickbuttonLuu();
        String actualMessage = QLChuDeFunc.GetNotificationMessage();
        Assert.assertEquals(actualMessage, "Mã chủ đề đã được sử dụng",
                "Notification message should be 'Mã chủ đề đã được sử dụng'");
    }

    @Test(priority = 13, description = "Kiem tra khi click vao icon Huy trên form them moi")
    public void TC_13_VerifyClickIconHuy() throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc.clickbuttonHuy();
        Assert.assertEquals(QLChuDeFunc.VerifyTitlePopupConfirm(), "Bạn có xác nhận hủy thêm mới?",
                "Title of confirm popup should be correct");
        Assert.assertEquals(QLChuDeFunc.VerifyContentPopupConfirm(),
                "Sau khi xác nhận, dữ liệu đã nhập sẽ không được lưu",
                "Content of confirm popup should be correct");
        Thread.sleep(2000);

    }

    @Test(priority = 14, description = "Kiem tra khi click vao nut Huy trong popup confirm khi click vao icon Huy tren form them moi")
    public void TC_14_VerifyHuyPopupConfirm() throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc.clickIconHuyConfirm();
        Assert.assertTrue(QLChuDeFunc.VerifyPopupConfirmClosed(), "Popup confirm should be closed after clicking Hủy");
    }

    @Test(priority = 15, description = "Kiem tra khi click vao nut Xac Nhan trong popup confirm khi click vao icon Huy tren form them moi")
    public void TC_15_VerifyXacNhanPopupConfirm() throws InterruptedException {
        Thread.sleep(2000);
        QLChuDeFunc.clickbuttonHuy();
        Thread.sleep(2000);
        QLChuDeFunc.clickIconXacNhanConfirm();
        Assert.assertFalse(QLChuDeFunc.verifyAddNewTopicForm(), "Add new topic form should be  not displayed");
    }

    @Test(priority = 16, description = "Them moi chu de thanh cong")
    public void TC_16_VerifyAddNewTopicSuccess() throws InterruptedException {

        QLChuDeFunc.clickAddButton();
        Thread.sleep(2000);
        QLChuDeFunc.RandomMaChuDe();
        Thread.sleep(2000);
        QLChuDeFunc.RandomTenChuDe();
        Thread.sleep(2000);
        QLChuDeFunc.RandomTruCot();
        Thread.sleep(2000);
        String Machude = QLChuDeFunc.GetTextMaChuDeInput();
        String Tenchude = QLChuDeFunc.GetTextTenChuDeInput();
        String TruCot = QLChuDeFunc.GetTextTruCotInput();

        QLChuDeFunc.clickbuttonLuu();
        Thread.sleep(2000);
        Assert.assertTrue(QLChuDeFunc.VerifyMessageThemMoiChuDeThanhCong(),
                "Message 'Thêm mới chủ đề thành công' should be displayed");
        Thread.sleep(2000);
        Assert.assertEquals(QLChuDeFunc.GetTextMaChuDeRecord(), Machude,
                "Mã chủ đề in record should match input");
        Thread.sleep(2000);

        Assert.assertEquals(QLChuDeFunc.GetTextTenChuDeRecord(), Tenchude,
                "Tên chủ đề in record should match input");
        Thread.sleep(2000);

        Assert.assertEquals(QLChuDeFunc.GetTextTruCotRecord(), TruCot,
                "Trụ cột in record should match input");

    }

    @Test(priority = 17, description = "Kiem tra chuc nang sua chu de")
    public void TC_17_VerifyWhenClickEdit() throws InterruptedException {
        QLChuDeFunc.clickEditByMa(QLChuDeFunc.GetTextMaChuDeRecord());
        Thread.sleep(2000);
        Assert.assertTrue(QLChuDeFunc.verifyEditTopicForm(),
                "Edit topic form should be displayed");
        Assert.assertEquals(QLChuDeFunc.GetTextMaChuDeInput(),
                QLChuDeFunc.GetTextMaChuDeRecord(),
                "Mã chủ đề in edit form should match record");
        Assert.assertEquals(QLChuDeFunc.GetTextTenChuDeInput(),
                QLChuDeFunc.GetTextTenChuDeRecord(),
                "Tên chủ đề in edit form should match record");
        Assert.assertEquals(QLChuDeFunc.GetTextTruCotInput(),
                QLChuDeFunc.GetTextTruCotRecord(),
                "Trụ cột in edit form should match record");
        Assert.assertTrue(QLChuDeFunc.CheckDisabledMaChuDe(),
                "Mã chủ đề field should be disabled in edit form");
    }


    @Test(priority = 18, description = "Kiem tra chuc nang update chu de")
    public void TC_18_VerifyUpdateChuDeSuccess() throws InterruptedException {
        QLChuDeFunc.RandomTenChuDeforUpdate();
        Thread.sleep(2000);
        QLChuDeFunc.RandomTruCotforUpdate(); 
        Thread.sleep(2000);
        Thread.sleep(2000);
        String Machude = QLChuDeFunc.GetTextMaChuDeInput();
        String Tenchude = QLChuDeFunc.GetTextTenChuDeInput();
        String TruCot = QLChuDeFunc.GetTextTruCotInput();

        QLChuDeFunc.clickbuttonLuu();
        Thread.sleep(2000);

          Assert.assertTrue(QLChuDeFunc.VerifyMessageCapNhatChuDeThanhCong(),
                "Message 'Cập nhật chủ đề thành công' should be displayed");
        Thread.sleep(2000);
        Assert.assertEquals(QLChuDeFunc.GetTextMaChuDeRecord(), Machude,
                "Mã chủ đề in record should match input");
        Thread.sleep(2000);

        Assert.assertEquals(QLChuDeFunc.GetTextTenChuDeRecord(), Tenchude,
                "Tên chủ đề in record should match input");
        Thread.sleep(2000);

        Assert.assertEquals(QLChuDeFunc.GetTextTruCotRecord(), TruCot,
                "Trụ cột in record should match input");


    
    }

}
