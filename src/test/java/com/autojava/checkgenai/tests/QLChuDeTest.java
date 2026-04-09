package com.autojava.checkgenai.tests;

import com.autojava.checkgenai.listeners.ExtentReportListener;
import com.autojava.checkgenai.listeners.TestListener;
import com.autojava.checkgenai.pages.Func.Func_HomePage;
import com.autojava.checkgenai.pages.Func.Func_LoginPage;
import com.autojava.checkgenai.pages.Func.Func_QuanLychude;
import com.autojava.checkgenai.tests.test.BaseTest;
import com.beust.ah.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

@Listeners({ ExtentReportListener.class, TestListener.class })
public class QLChuDeTest extends BaseTest {

        public Func_HomePage HomeFunc;
        public Func_QuanLychude QLChuDeFunc;
        private static final Logger logger = LoggerFactory.getLogger(QLChuDeTest.class);

        /// Module danh sach chủ đề

        @Test(priority = 1, description = "Kiem tra trang QL Chu De duoc hien thi dung")
        public void TC_1_verifyQLChuDePageIsDisplayed() throws InterruptedException {
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
                logger.info("4. Clicking on Quan Ly Chu De menu item");
                HomeFunc.clickQLChuDe();
                Thread.sleep(2000);
                logger.info("5. Verifying Quan Ly Chu De page is displayed");
                QLChuDeFunc = new Func_QuanLychude(driver);
                String pageTitle = QLChuDeFunc.getPageTitle();
                Assert.assertEquals(pageTitle, "Quản lý chủ đề", "Page title should be 'Quản lý chủ đề'");

        }

        @Test(priority = 2, description = "Kiem tra cac column duoc hien thi dung")
        public void TC_2_VerifyColumnQLChuDe() throws InterruptedException {
                Thread.sleep(2000);
                QLChuDeFunc = new Func_QuanLychude(driver);
                logger.info("Starting test: TC2 : Verify columns in Quan Ly Chu De page");
                logger.info("1. Verifying column 1 is 'Mã chủ đề'");
                Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(1, "Mã chủ đề"), "Column 1 should be 'Mã chủ đề'");
                logger.info("2. Verifying column 2 is 'Tên chủ đề'");
                Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(2, "Tên chủ đề"), "Column 2 should be 'Tên chủ đề'");
                logger.info("3. Verifying column 3 is 'Trụ cột'");
                Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(3, "Trụ cột"), "Column 3 should be 'Trụ cột'");
                logger.info("4. Verifying column 4 is 'Trạng thái'");
                Assert.assertTrue(QLChuDeFunc.verifyColumnByIndex(4, "Trạng thái"), "Column 4 should be 'Trạng thái'");
        }

        // Module quản lý chủ đề

        @Test(priority = 3, description = "Kiem tra khi click vao form them moi")
        public void TC_3_VerifyAddNewTopicForm() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC3 : Verify Add New Topic form is displayed correctly");
                logger.info("1. Clicking on 'Thêm mới' button");
                QLChuDeFunc.clickAddButton();
                Thread.sleep(2000);
                logger.info("2. Verifying Add New Topic form is displayed");
                Assert.assertTrue(QLChuDeFunc.verifyAddNewTopicForm(), "Add new topic form should be displayed");
        }

        @Test(priority = 4, description = "Kiem tra khi nhap du lieu hop le vao ma chu de")
        public void TC_4_VerifyMaChuDeWhenInputValidData() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC4 : Verify Ma Chu De field accepts valid input");
                logger.info("1. Entering valid Ma Chu De 'KITU001' into Ma Chu De field");
                String actualMaChuDe = QLChuDeFunc.verifyMaChuDewheninputValiddata();
                logger.info("2. Verifying Ma Chu De field accepts valid input and displays 'KITU001'");
                Assert.assertEquals(actualMaChuDe, "KITU001", "Ma Chu De should be 'KITU001'");
        }

        @Test(priority = 5, description = "Kiem tra khi nhap du lieu khong hop le vao ma chu de")
        public void TC_5_VerifyMaChuDeWhenInputInvalidData() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC5 : Verify Ma Chu De field does not accept invalid input");
                logger.info("1. Entering invalid Ma Chu De");
                String actualMaChuDe = QLChuDeFunc.verifyMaChuDewheninputInvaliddata();
                logger.info("2. Verifying Ma Chu De field does not accept invalid input and displays 'KITU001DAI'");
                Assert.assertEquals(actualMaChuDe, "KITU001DAI", "Ma Chu De should be 'KITU001DAI'");
        }

        @Test(priority = 6, description = "Kiem tra khi khong nhap ma chu de")
        public void TC_6_VerifyEmptyMaChuDe() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC6 : Verify error message when Ma Chu De field is empty");
                logger.info("1. Leaving Ma Chu De field empty and clicking 'Lưu' button");
                String actualError = QLChuDeFunc.verifyEmtyMaChuDe();
                logger.info("2. Verifying error message 'Vui lòng nhập thông tin này' is displayed");
                Assert.assertEquals(actualError, "Vui lòng nhập thông tin này",
                                "Error message should be 'Vui lòng nhập thông tin'");
        }

        @Test(priority = 7, description = "Kiem tra khi nhap ten chu de hop le ")
        public void TC_7_VerifyValidTenChuDe() throws InterruptedException {
                logger.info("Starting test: TC7 : Verify Ten Chu De field accepts valid input");
                logger.info("1. Entering valid Ten Chu De 'Chủ đề 1' into Ten Chu De field");
                Thread.sleep(2000);
                String actualTenChuDe = QLChuDeFunc.verifyTenChuDewheninputValiddata();
                logger.info("2. Verifying Ten Chu De field accepts valid input and displays 'Chủ đề 1'");
                Assert.assertEquals(actualTenChuDe, "Chủ đề 1", "Ten Chu De should be 'Chủ đề 1'");
        }

        @Test(priority = 8, description = "Kiem tra khi nhap ten chu de hop le ")
        public void TC_8_VerifyInvalidTenChuDe() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC8 : Verify Ten Chu De field does not accept invalid input");
                logger.info("1. Entering invalid Ten Chu De into Ten Chu De field");
                String actualTenChuDe = QLChuDeFunc.verifyTenChuDewheninputInvaliddata();
                logger.info("2. Verifying Ten Chu De field does not accept invalid input and displays the expected error message");
                Assert.assertEquals(actualTenChuDe,
                                "Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tả",
                                "Ten Chu De should be 'Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tả'");
        }

        @Test(priority = 9, description = "Kiem tra khi ten chu de bo trong ")
        public void TC_9_VerifyInvalidTenChuDe() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC9 : Verify error message when Ten Chu De field is empty");
                logger.info("1. Leaving Ten Chu De field empty and clicking 'Lưu' button");
                String actualError = QLChuDeFunc.verifyEmtyTenChuDe();
                logger.info("2. Verifying error message 'Vui lòng nhập thông tin này' is displayed");
                Assert.assertEquals(actualError, "Vui lòng nhập thông tin này",
                                "Error message should be 'Vui lòng nhập thông tin'");
        }

        @Test(priority = 10, description = "Kiem tra lay phan tu dau tien trong selectbox tru cot")
        public void TC10_GetFirstTruCot() throws InterruptedException {
                QLChuDeFunc.clickTruCotSelect();
                Thread.sleep(1000);
                logger.info("Starting test: TC10 : Verify first option in 'Trụ cột' select box is correct");
                logger.info("1. Clicking on 'Trụ cột' select box and getting the first option");
                // Get phần tử đầu tiên
                String firstOption = QLChuDeFunc.GetitemTruCot();
                logger.info("2. Verifying first option in 'Trụ cột' select box is 'Năng lượng và môi trường'");
                Assert.assertEquals(firstOption, "Năng lượng và môi trường",
                                "First option in 'Trụ cột' should be 'Trụ cột 1'");
        }

        @Test(priority = 11, description = "Kiem tra khi khong chon tru cot nao")
        public void TC_11_VerifyEmptyTruCot() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC11 : Verify error message when no option is selected in 'Trụ cột' select box");
                logger.info("1. Leaving 'Trụ cột' select box with no option selected    and clicking 'Lưu' button");
                String actualError = QLChuDeFunc.verifyEmtyTruCot();
                logger.info("2. Verifying error message 'Vui lòng chọn thông tin này' is displayed");
                Assert.assertEquals(actualError, "Vui lòng chọn thông tin này",
                                "Error message should be 'Vui lòng chọn thông tin'");

        }

        @Test(priority = 12, description = "Kiem tra ma chu de trung")
        public void TC_12_VerifyMaChuDeTrung() throws InterruptedException {
                logger.info("Starting test: TC12 : Verify error message when Ma Chu De is duplicated");
                logger.info("1. Entering duplicate Ma Chu De into Ma Chu De field and clicking 'Lưu' button");
                Thread.sleep(2000);
                QLChuDeFunc.GetMaChuDeTrung();
                Thread.sleep(1000);
                logger.info("2. Verifying error message 'Mã chủ đề đã được sử dụng' is displayed in notification");
                QLChuDeFunc.clickbuttonLuu();
                String actualMessage = QLChuDeFunc.GetNotificationMessage();
                Assert.assertEquals(actualMessage, "Mã chủ đề đã được sử dụng",
                                "Notification message should be 'Mã chủ đề đã được sử dụng'");
        }

        @Test(priority = 13, description = "Kiem tra khi click vao icon Huy trên form them moi")
        public void TC_13_VerifyClickIconHuy() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC13 : Verify cancel functionality in Add New Topic form");
                logger.info("1. Clicking on 'Hủy' button in Add New Topic form");
                QLChuDeFunc.clickbuttonHuy();
                logger.info("2. Verifying confirm popup is displayed with correct title and content");
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
                logger.info("Starting test: TC14 : Verify canceling the cancel action in Add New Topic form");
                logger.info("1. Clicking on 'Hủy' button in cancel confirmation popup");
                QLChuDeFunc.clickIconHuyConfirm();
                logger.info("2. Verifying confirm popup is closed and Add New Topic form is still displayed");
                Assert.assertTrue(QLChuDeFunc.VerifyPopupConfirmClosed(),
                                "Popup confirm should be closed after clicking Hủy");
        }

        @Test(priority = 15, description = "Kiem tra khi click vao nut Xac Nhan trong popup confirm khi click vao icon Huy tren form them moi")
        public void TC_15_VerifyXacNhanPopupConfirm() throws InterruptedException {
                logger.info("Starting test: TC15 : Verify confirming the cancel action in Add New Topic form");
                Thread.sleep(2000);
                logger.info("1. Clicking on 'Hủy' button in Add New Topic form");
                QLChuDeFunc.clickbuttonHuy();
                Thread.sleep(2000);
                logger.info("2. Clicking on 'Xác nhận' button in cancel confirmation popup");
                QLChuDeFunc.clickIconXacNhanConfirm();
                logger.info("3. Verifying Add New Topic form is closed after confirming cancel action");
                Assert.assertFalse(QLChuDeFunc.verifyAddNewTopicForm(), "Add new topic form should be  not displayed");
        }

        @Test(priority = 16, description = "Them moi chu de thanh cong")
        public void TC_16_VerifyAddNewTopicSuccess() throws InterruptedException {
                logger.info("Starting test: TC16 : Verify adding new topic successfully");
                logger.info("1. Clicking on 'Thêm mới' button and filling in valid data for all fields");
                QLChuDeFunc.clickAddButton();
                Thread.sleep(2000);
                logger.info("2. Entering valid data into Ma Chu De");
                QLChuDeFunc.RandomMaChuDe();
                Thread.sleep(2000);
                logger.info("3. Entering random valid Ten Chu De");
                QLChuDeFunc.RandomTenChuDe();
                Thread.sleep(2000);
                logger.info("4. Selecting random valid option in 'Trụ cột' select box");
                QLChuDeFunc.RandomTruCot();
                Thread.sleep(2000);
                logger.info("5. Get data input fields before saving to compare with data in record after saving");
                String Machude = QLChuDeFunc.GetTextMaChuDeInput();
                String Tenchude = QLChuDeFunc.GetTextTenChuDeInput();
                String TruCot = QLChuDeFunc.GetTextTruCotInput();
                logger.info("6. Clicking 'Lưu' button to save the new topic");
                QLChuDeFunc.clickbuttonLuu();
                Thread.sleep(2000);
                logger.info("7. Verifying success message 'Thêm mới chủ đề thành công' is displayed");
                Assert.assertTrue(QLChuDeFunc.VerifyMessageThemMoiChuDeThanhCong(),
                                "Message 'Thêm mới chủ đề thành công' should be displayed");
                Thread.sleep(2000);
                logger.info("8. Verifying the new topic is added successfully with correct data displayed in the first record of the topic list");
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
                logger.info("Starting test: TC17 : Verify Edit Topic functionality");
                QLChuDeFunc.clickEditByMa(QLChuDeFunc.GetTextMaChuDeRecord());
                Thread.sleep(2000);
                logger.info("1. Clicking on Edit icon of the first topic record");
                Assert.assertTrue(QLChuDeFunc.verifyEditTopicForm(),
                                "Edit topic form should be displayed");
                logger.info("2. Verifying data in edit form matches data in the record");
                Assert.assertEquals(QLChuDeFunc.GetTextMaChuDeInput(),
                                QLChuDeFunc.GetTextMaChuDeRecord(),
                                "Mã chủ đề in edit form should match record");
                logger.info("3. Verifying Ten Chu De in edit form matches Ten Chu De in record");
                Assert.assertEquals(QLChuDeFunc.GetTextTenChuDeInput(),
                                QLChuDeFunc.GetTextTenChuDeRecord(),
                                "Tên chủ đề in edit form should match record");
                logger.info("4. Verifying Tru Cot in edit form matches Tru Cot in record");
                Assert.assertEquals(QLChuDeFunc.GetTextTruCotInput(),
                                QLChuDeFunc.GetTextTruCotRecord(),
                                "Trụ cột in edit form should match record");
                logger.info("5. Verifying Ma Chu De field is disabled in edit form");
                Assert.assertTrue(QLChuDeFunc.CheckDisabledMaChuDe(),
                                "Mã chủ đề field should be disabled in edit form");
        }

        @Test(priority = 18, description = "Kiem tra khi click vao nut Huy trong popup confirm khi click vao icon Huy tren form edit chu de")
        public void TC_18_VerifyHuyPopupConfirmWhenEdit() throws InterruptedException {
                logger.info("Starting test: TC18 : Verify canceling the edit action in Edit Topic form");
                logger.info("1. Modifying data in edit form and clicking on 'Hủy' button");
                QLChuDeFunc.RandomTenChuDeforUpdate();
                Thread.sleep(2000);
                QLChuDeFunc.clickbuttonHuy();
                logger.info("2. Verifying confirm popup is displayed with correct title and content");
                Assert.assertEquals(QLChuDeFunc.VerifyTitlePopupConfirm(), "Bạn có xác nhận hủy chỉnh sửa?",
                                "Title of confirm popup should be correct");
                Assert.assertEquals(QLChuDeFunc.VerifyContentPopupConfirm(),
                                "Sau khi xác nhận, dữ liệu đã nhập sẽ không được lưu",
                                "Content of confirm popup should be correct");
                Thread.sleep(2000);

        }

        @Test(priority = 19, description = "Kiem tra khi click vao nut Huy trong popup confirm khi click vao icon Huy tren form edit chu de")
        public void TC_19_VerifyHuyPopupConfirmWhenEdit() throws InterruptedException {
                logger.info("Starting test: TC19 : Verify canceling the edit action in Edit Topic form");
                Thread.sleep(2000);
                logger.info("1. Clicking on 'Hủy' button in cancel confirmation popup");
                QLChuDeFunc.clickIconHuyConfirm();
                logger.info("2. Verifying confirm popup is closed and Edit Topic form is still displayed");
                Assert.assertTrue(QLChuDeFunc.VerifyPopupConfirmClosed(),
                                "Edit topic form should be  not displayed after canceling edit");
        }

        @Test(priority = 20, description = "Kiem tra khi click vao nut Xac Nhan trong popup confirm khi click vao icon Huy tren form edit chu de")
        public void TC_20_VerifyXacNhanPopupConfirmWhenEdit() throws InterruptedException {
                logger.info("Starting test: TC20 : Verify confirming the cancel action in Edit Topic form");
                Thread.sleep(2000);
                logger.info("1. Clicking on 'Hủy' button in Edit Topic form");
                QLChuDeFunc.clickbuttonHuy();
                Thread.sleep(2000);
                logger.info("2. Clicking on 'Xác nhận' button in cancel confirmation popup");
                QLChuDeFunc.clickIconXacNhanConfirm();
                logger.info("3. Verifying Edit Topic form is closed after confirming cancel action");
                Assert.assertFalse(QLChuDeFunc.verifyEditTopicForm(),
                                "Edit topic form should be  not displayed after confirming cancel edit");
        }

        @Test(priority = 21, description = "Kiem tra chuc nang update chu de")
        public void TC_21_VerifyUpdateChuDeSuccess() throws InterruptedException {
                logger.info("Starting test: TC21 : Verify updating topic successfully");
                logger.info("1. Clicking on Edit icon of the first topic record");
                QLChuDeFunc.clickEditByMa(QLChuDeFunc.GetTextMaChuDeRecord());
                Thread.sleep(2000);
                logger.info("2. Modifying data in edit form and clicking 'Lưu' button");
                QLChuDeFunc.RandomTenChuDeforUpdate();
                Thread.sleep(2000);
                QLChuDeFunc.RandomTruCotforUpdate();

                Thread.sleep(2000);
                String Machude = QLChuDeFunc.GetTextMaChuDeInput();
                String Tenchude = QLChuDeFunc.GetTextTenChuDeInput();
                String TruCot = QLChuDeFunc.GetTextTruCotInput();

                QLChuDeFunc.clickbuttonLuu();
                Thread.sleep(2000);
                logger.info("3. Verifying success message 'Cập nhật chủ đề thành công' is displayed");
                Assert.assertTrue(QLChuDeFunc.VerifyMessageCapNhatChuDeThanhCong(),
                                "Message 'Cập nhật chủ đề thành công' should be displayed");
                Thread.sleep(2000);
                logger.info("4. Verifying the topic is updated successfully with correct data displayed in the first record of the topic list");
                Assert.assertEquals(QLChuDeFunc.GetTextMaChuDeRecord(), Machude,
                                "Mã chủ đề in record should match input");
                Thread.sleep(2000);

                Assert.assertEquals(QLChuDeFunc.GetTextTenChuDeRecord(), Tenchude,
                                "Tên chủ đề in record should match input");
                Thread.sleep(2000);

                Assert.assertEquals(QLChuDeFunc.GetTextTruCotRecord(), TruCot,
                                "Trụ cột in record should match input");
        }

        @Test(priority = 22, description = "Kiem tra popup toggle trang thai ON => OFF")
        public void TC_22_VerifyToggleTrangThai() throws InterruptedException {
                logger.info("Starting test: TC22 : Verify toggling topic status from ON to OFF");
                logger.info("1. Clicking on Edit icon of the first topic record");
                QLChuDeFunc.clickEditByMa(QLChuDeFunc.GetTextMaChuDeRecord());
                Thread.sleep(2000);
                logger.info("2. Clicking on toggle status to change status from ON to OFF");
                QLChuDeFunc.clickToogleTrangThai();
                Thread.sleep(2000);
                logger.info("3. Verifying confirm popup is displayed with correct title and content for toggling status from ON to OFF");
                Assert.assertEquals(QLChuDeFunc.VerifyTitlePopupConfirm(),
                                "Bạn có xác nhận vô hiệu hoá thông tin chủ đề không?", "Toggle status should be false");
                Assert.assertEquals(QLChuDeFunc.VerifyContentPopupConfirm(),
                                "Sau khi xác nhận, chủ đề sẽ bị vô hiệu hoá và không hiển thị trong quá trình tạo thông tin nhập liệu",
                                "Content of confirm popup should be correct");
        }

        @Test(priority = 23, description = "Kiem tra ON =>OFF khi click vao nut Hủy trong popup confirm khi click vao toggle trang thai")
        public void TC_23_VerifyHuyPopupConfirmWhenToggleTrangThai() throws InterruptedException {
                logger.info("Starting test: TC23 : Verify canceling the toggle status action in Edit Topic form");
                Thread.sleep(2000);
                logger.info("1. Clicking on 'Hủy' button in toggle status confirmation popup");
                QLChuDeFunc.clickIconHuyConfirm();
                logger.info("2. Verifying confirm popup is closed and Edit Topic form is still displayed, and toggle status remains unchanged");
                Assert.assertTrue(QLChuDeFunc.VerifyPopupConfirmClosed(),
                                "Edit topic form should be  not displayed after canceling edit");
                Assert.assertTrue(QLChuDeFunc.VerifyToggleTrangThai().equals("true"),
                                "Toggle status should be false after canceling toggle status change");
        }

        @Test(priority = 24, description = "Kiem tra khi click vao nut Xac Nhan trong popup confirm khi click vao icon Huy tren form edit chu de")
        public void TC_24_VerifyXacNhanPopupConfirmWhenToggleTrangThai() throws InterruptedException {
                logger.info("Starting test: TC24 : Verify confirming the toggle status action in Edit Topic form");
                Thread.sleep(2000);
                logger.info("1. Clicking on toggle status to change status from ON to OFF");
                QLChuDeFunc.clickToogleTrangThai();
                Thread.sleep(2000);
                logger.info("2. Clicking on 'Xác nhận' button in toggle status confirmation popup");
                QLChuDeFunc.clickIconXacNhanConfirm();
                logger.info("3. Verifying toggle status is changed to OFF in edit form after confirming toggle status change");
                Assert.assertTrue(QLChuDeFunc.VerifyToggleTrangThai().equals("false"),
                                "Trạng thái của chủ đề should be OFF after confirming toggle status change");

        }

        @Test(priority = 25, description = "Kiem tra popup toggle trang thai OFF => ON")
        public void TC_25_VerifyToggleTrangThaiOFFtoON() throws InterruptedException {
                logger.info("Starting test: TC25 : Verify toggling topic status from OFF to ON");
                logger.info("1. Clicking on toggle status to change status from OFF to ON");
                QLChuDeFunc.clickToogleTrangThai();
                Thread.sleep(2000);
                logger.info("2. Verifying confirm popup is displayed with correct title and content for toggling status from OFF to ON");
                Assert.assertEquals(QLChuDeFunc.VerifyTitlePopupConfirm(),
                                "Bạn có xác nhận kích hoạt thông tin chủ đề không?", "Toggle status should be true");

        }

        @Test(priority = 26, description = "Kiem tra ON =>OFF khi click vao nut Hủy trong popup confirm khi click vao toggle trang thai")
        public void TC_26_VerifyHuyPopupConfirmWhenToggleTrangThaiOFFtoON() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC26 : Verify canceling the toggle status action from OFF to ON in Edit Topic form");
                logger.info("1. Clicking on 'Hủy' button in toggle status confirmation popup");
                QLChuDeFunc.clickIconHuyConfirm();
                logger.info("2. Verifying confirm popup is closed and Edit Topic form is still displayed, and toggle status remains unchanged");
                Assert.assertTrue(QLChuDeFunc.VerifyPopupConfirmClosed(),
                                "Edit topic form should be  not displayed after canceling edit");
                Assert.assertTrue(QLChuDeFunc.VerifyToggleTrangThai().equals("false"),
                                "Toggle status should be false after canceling toggle status change");
        }

        @Test(priority = 27, description = "Kiem tra khi click vao nut Xac Nhan trong popup confirm khi click vao icon Huy tren form edit chu de")
        public void TC_27_VerifyXacNhanPopupConfirmWhenToggleTrangThaiOFFtoON() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC27 : Verify confirming the toggle status action from OFF to ON in Edit Topic form");
                logger.info("1. Clicking on toggle status to change status from OFF to ON");
                QLChuDeFunc.clickToogleTrangThai();
                Thread.sleep(2000);
                logger.info("2. Clicking on 'Xác nhận' button in toggle status confirmation popup");
                QLChuDeFunc.clickIconXacNhanConfirm();
                logger.info("3. Verifying toggle status is changed to ON in edit form after confirming toggle status change");
                Assert.assertTrue(QLChuDeFunc.VerifyToggleTrangThai().equals("true"),
                                "Trạng thái của chủ đề should be ON after confirming toggle status change");

        }

        @Test(priority = 28, description = "Kiem tra chuc nang LUU RECORD KHI TRANG THAI OFF")
        public void TC_28_VerifyUpdateRecordWhenTrangThaiOFF() throws InterruptedException {
                logger.info("Starting test: TC28 : Verify updating topic record when status is OFF");
                logger.info("1. Clicking on Edit icon of the first topic record");
                QLChuDeFunc.clickToogleTrangThai();
                Thread.sleep(2000);
                logger.info("2. Modifying data in edit form and clicking 'Lưu' button");
                QLChuDeFunc.clickIconXacNhanConfirm();
                Thread.sleep(2000);
                QLChuDeFunc.clickbuttonLuu();
                Thread.sleep(2000);
                logger.info("3. Verifying success message 'Cập nhật chủ đề thành công' is displayed");
                Assert.assertTrue(QLChuDeFunc.VerifyMessageCapNhatChuDeThanhCong(),
                                "Message 'Cập nhật chủ đề thành công' should be displayed");
                Thread.sleep(2000);
                Assert.assertEquals(QLChuDeFunc.GetTextTrangThaiRecord(), "false",
                                "Trạng thái của chủ đề should be OFF in record after update");
        }

        @Test(priority = 29, description = "Kiem tra chuc nang LUU RECORD KHI TRANG THAI OFF")
        public void TC_29_VerifyUpdateRecordWhenTrangThaiON() throws InterruptedException {
                logger.info("Starting test: TC29 : Verify updating topic record when status is ON");
                logger.info("1. Clicking on Edit icon of the first topic record");
                QLChuDeFunc.clickEditByMa(QLChuDeFunc.GetTextMaChuDeRecord());
                Thread.sleep(2000);
                logger.info("2. Modifying data in edit form and clicking 'Lưu' button");
                QLChuDeFunc.clickToogleTrangThai();
                Thread.sleep(2000);
                QLChuDeFunc.clickIconXacNhanConfirm();
                Thread.sleep(2000);
                QLChuDeFunc.clickbuttonLuu();
                Thread.sleep(2000);
                logger.info("3. Verifying success message 'Cập nhật chủ đề thành công' is displayed");
                Assert.assertTrue(QLChuDeFunc.VerifyMessageCapNhatChuDeThanhCong(),
                                "Message 'Cập nhật chủ đề thành công' should be displayed");
                Thread.sleep(2000);
                Assert.assertEquals(QLChuDeFunc.GetTextTrangThaiRecord(), "true",
                                "Trạng thái của chủ đề should be ON in record after update");
        }

        @Test(priority = 30, description = "Kiem tra ON => OFF TRẠNG THÁI TRÊN DANH SÁCH CHỦ ĐỀ")
        public void TC_30_VerifyToggleTrangThaiOFFInTopicList() throws InterruptedException {
                logger.info("Starting test: TC30 : Verify toggling topic status from ON to OFF is reflected in topic list");
                logger.info("1. Clicking on Edit icon of the first topic record");
                QLChuDeFunc.clickToogleTrangThaiInRecord();
                Thread.sleep(2000);
                Assert.assertEquals(QLChuDeFunc.VerifyTitlePopupConfirm(),
                                "Bạn có xác nhận vô hiệu hoá thông tin chủ đề không?", "Toggle status should be false");
                Assert.assertEquals(QLChuDeFunc.VerifyContentPopupConfirm(),
                                "Sau khi xác nhận, chủ đề sẽ bị vô hiệu hoá và không hiển thị trong quá trình tạo thông tin nhập liệu",
                                "Content of confirm popup should be correct");
                QLChuDeFunc.clickIconXacNhanConfirm();
                Thread.sleep(2000);
                logger.info("2. Verifying toggle status is changed to OFF in topic list after confirming toggle status change");

                Assert.assertTrue(QLChuDeFunc.VerifyMessageVoHieuHoaThanhCong(),
                                "Message 'Vô hiệu hóa chủ đề thành công' should be displayed");
                Assert.assertEquals(QLChuDeFunc.GetTextTrangThaiRecord(), "false",
                                "Trạng thái của chủ đề should be OFF in record after update");

        }

        @Test(priority = 31, description = "Kiem tra OFF => ON TRẠNG THÁI TRÊN DANH SÁCH CHỦ ĐỀ")
        public void TC_31_VerifyToggleTrangThaiONInTopicList() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC31 : Verify toggling topic status from OFF to ON is reflected in topic list");
                logger.info("1. Clicking on toggle status in the first topic record to change status from OFF to ON");
                QLChuDeFunc.clickToogleTrangThaiInRecord();
                Thread.sleep(2000);
                Assert.assertEquals(QLChuDeFunc.VerifyTitlePopupConfirm(),
                                "Bạn có xác nhận kích hoạt thông tin chủ đề không?", "Toggle status should be true");
                QLChuDeFunc.clickIconXacNhanConfirm();
                Thread.sleep(2000);
                logger.info("2. Verifying toggle status is changed to ON in topic list after confirming toggle status change");
                Assert.assertTrue(QLChuDeFunc.VerifyMessageKichHoatChuDeThanhCong(),
                                "Message 'Kích hoạt chủ đề thành công' should be displayed");
                Assert.assertEquals(QLChuDeFunc.GetTextTrangThaiRecord(), "true",
                                "Trạng thái của chủ đề should be ON in record after update");
        }

        @Test(priority = 32, description = "Kiem tra chuc nang TÌM KIẾM CHỦ ĐỀ THEO MÃ CHỦ ĐỀ")
        public void TC_32_VerifySearchChuDeByMa() throws InterruptedException {
                logger.info("Starting test: TC32 : Verify searching for a topic by its code");
                logger.info("1. Entering the topic code in the search box");
                String MaChuDe = QLChuDeFunc.GetTextMaChuDeRecord();
                QLChuDeFunc.InputSearch(MaChuDe);
                Thread.sleep(2000);
                logger.info("2. Verifying the search results display the correct topic with matching code");
                Assert.assertEquals(QLChuDeFunc.VerifySearchResultMaChuDe(MaChuDe), true,
                                "Mã chủ đề in search result should match search input");

        }

        @Test(priority = 33, description = "Kiem tra chuc nang TÌM KIẾM CHỦ ĐỀ THEO TÊN CHỦ ĐỀ")
        public void TC_33_VerifySearchChuDeByTen() throws InterruptedException {
                logger.info("Starting test: TC33 : Verify searching for a topic by its name");
                logger.info("1. Entering the topic name in the search box");
                String TenChuDe = QLChuDeFunc.GetTextTenChuDeRecord();
                QLChuDeFunc.InputSearch(TenChuDe);
                Thread.sleep(2000);
                logger.info("2. Verifying the search results display the correct topic with matching name");
                Assert.assertEquals(QLChuDeFunc.VerifySearchResultTenChuDe(TenChuDe), true,
                                "Tên chủ đề in search result should match search input");
        }

        @Test(priority = 34, description = "Kiem tra chuc nang TÌM KIẾM KHÔNG THẤY KẾT QUẢ")
        public void TC_34_VerifySearchChuDeNoResult() throws InterruptedException {
                logger.info("Starting test: TC34 : Verify searching for a topic with no matching results");
                logger.info("1. Entering a non-existing topic code or name in the search box");
                QLChuDeFunc.InputSearch("NonExistingTopic123");
                Thread.sleep(2000);
                logger.info("2. Verifying the search results display 'Không tìm thấy kết quả nào' message");
                Assert.assertTrue(QLChuDeFunc.VerifySearchResultEmpty());
        }

        @Test(priority = 35, description = "Kiem tra khi click vao nut Export ")
        public void TC_35_VerifyWhenClickExportButton() throws InterruptedException {
                Thread.sleep(2000);
                logger.info("Starting test: TC35 : Verify clicking on Export button initiates file download");
                QLChuDeFunc.InputSearch("");
                Thread.sleep(2000);
                QLChuDeFunc.clickExportButton();
                Thread.sleep(2000);
                logger.info("1. Clicking on 'Export' button");
                logger.info("2. Verifying file download is initiated (this can be verified by checking");
                Assert.assertEquals(QLChuDeFunc.VerifyTitlePopupConfirm(), "Xác nhận xuất dữ liệu");
                Assert.assertEquals(QLChuDeFunc.VerifyContentPopupConfirm(),
                                "Bạn có muốn xuất dữ liệu này không?",
                                "Content of confirm popup should be correct");
        }

        @Test(priority = 36, description = "Kiem tra khi click vao nut Khong trong popup confirm khi click vao nut Export")
        public void TC_36_VerifyWhenClickNoInExportPopup() throws InterruptedException {
                
                Thread.sleep(2000);
                QLChuDeFunc.clickButtonKhong();
                Thread.sleep(2000);
                logger.info("1. Clicking on 'Export' button");
                logger.info("2. Clicking 'No' in the confirm popup");
                Assert.assertTrue(QLChuDeFunc.VerifyPopupConfirmClosed(),
                                "Confirm popup should be closed after clicking 'No'"); 
        }





        

        


}
