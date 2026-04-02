package com.autojava.checkgenai.pages.Func;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.autojava.checkgenai.pages.UI.UI_QuanLychude;
import java.time.Duration;
import java.util.List;

public class Func_QuanLychude {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public final UI_QuanLychude ui;

    public Func_QuanLychude(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.ui = new UI_QuanLychude(driver);

    }

    // Lấy title của trang QL Chu De
    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(ui.pageTitle));
        return ui.pageTitle.getText().trim();
    }

    // Click vào button Thêm mới
    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.addButton));
        ui.addButton.click();
    }

    // Get tất cả column trong trang QL chu de
    public boolean verifyColumnByIndex(int columnIndex, String expectedName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(ui.allColumnHeaders));

        List<WebElement> headers = ui.allColumnHeaders;

        if (columnIndex < 1 || columnIndex > headers.size()) {
            return false;
        }

        String actualName = headers.get(columnIndex - 1).getText().trim();
        return actualName.equals(expectedName);
    }

    // Click vào button Lưu trong form thêm mới hoặc chỉnh sửa
    public void clickbuttonLuu() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.buttonLuuEnabled));
        ui.buttonLuuEnabled.click();
    }

    // Click vào button Hủy trong form thêm mới hoặc chỉnh sửa
    public void clickbuttonHuy() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.buttonHuy));
        ui.buttonHuy.click();
    }

    // Verify form thêm mới chủ đề
    public boolean verifyAddNewTopicForm() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.addNewTopicFormTitle));
            wait.until(ExpectedConditions.visibilityOf(ui.labelMaChuDe));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTenChuDe));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTruCot));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTrangThai));
            wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
            wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe));
            wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
            wait.until(ExpectedConditions.visibilityOf(ui.toggleTrangThai));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // Nhập dữ liệu hợp lệ vào mã chủ đề và verify
    public String verifyMaChuDewheninputValiddata() {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
        ui.txtMaChuDe.clear();
        ui.txtMaChuDe.sendKeys("KITU001");
        return ui.txtMaChuDe.getAttribute("value").trim();
    }

    // Nhập dữ liệu không hợp lệ vào mã chủ đề (ví dụ: quá dài) và verify
    public String verifyMaChuDewheninputInvaliddata() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
        // ✅ Clear với retry
        ui.txtMaChuDe.click();

        // ✅ Select all text (Ctrl+A)
        ui.txtMaChuDe.sendKeys(Keys.CONTROL + "a");

        // ✅ Xóa text đã chọn
        ui.txtMaChuDe.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        ui.txtMaChuDe.sendKeys("KITU001DAILAM");
        return ui.txtMaChuDe.getAttribute("value").trim();
    }

    // Nhấn lưu khi để trống mã chủ đề và verify message lỗi
    public String verifyEmtyMaChuDe() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
        ui.txtMaChuDe.click();
        ui.txtMaChuDe.sendKeys(Keys.CONTROL + "a");
        ui.txtMaChuDe.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định

        return ui.errorEmptyMaChuDe.getText().trim();
    }

    // Hàm random dữ liệu cho Mã chủ đề
    public void RandomMaChuDe() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
        ui.txtMaChuDe.click();
        ui.txtMaChuDe.sendKeys(Keys.CONTROL + "a");
        ui.txtMaChuDe.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        String timestamp = String.valueOf(System.currentTimeMillis());
        timestamp = timestamp.substring(0, 10);
        ui.txtMaChuDe.sendKeys("CD" + timestamp);
    }

    // Hàm random dữ liệu cho Tên chủ đề
    public void RandomTenChuDe() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe));
        ui.txtTenChuDe.click();
        ui.txtTenChuDe.sendKeys(Keys.CONTROL + "a");
        ui.txtTenChuDe.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        String timestamp = String.valueOf(System.currentTimeMillis());
        ui.txtTenChuDe.sendKeys("AUTO_TEN" + timestamp);
    }

    // Hàm random dữ liệu cho Tên chủ đề trong form edit (để phân biệt với tên chủ
    // đề đã tồn tại khi thêm mới)
    public void RandomTenChuDeforUpdate() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe));
        ui.txtTenChuDe.click();
        ui.txtTenChuDe.sendKeys(Keys.CONTROL + "a");
        ui.txtTenChuDe.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        String timestamp = String.valueOf(System.currentTimeMillis());
        ui.txtTenChuDe.sendKeys("AUTO_TEN" + timestamp + "UPDATE");
    }

    // Hàm random chọn Trụ cột
    public void RandomTruCot() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
        ui.selectTruCot.click();
        Thread.sleep(1000);
        ui.selectTruCot.sendKeys(Keys.ARROW_DOWN);
        ui.selectTruCot.sendKeys(Keys.ENTER);
    }

    // Hàm random chọn Trụ cột trong form edit (để phân biệt với trụ cột đã tồn tại
    // khi thêm mới)
    public void RandomTruCotforUpdate() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
        ui.selectTruCot.click();
        Thread.sleep(1000);
        ui.selectTruCot.sendKeys(Keys.ARROW_UP);
        ui.selectTruCot.sendKeys(Keys.ENTER);
    }

    // Verify nhập dữ liệu hợp lệ vào tên chủ đề
    public String verifyTenChuDewheninputValiddata() {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe));
        ui.txtTenChuDe.clear();
        ui.txtTenChuDe.sendKeys("Chủ đề 1");
        return ui.txtTenChuDe.getAttribute("value").trim();
    }

    // Verify nhập dữ liệu không hợp lệ vào tên chủ đề (ví dụ: quá dài)
    public String verifyTenChuDewheninputInvaliddata() {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe));
        ui.txtTenChuDe.click();
        ui.txtTenChuDe.sendKeys(Keys.CONTROL + "a");
        ui.txtTenChuDe.sendKeys(Keys.DELETE);
        ui.txtTenChuDe.sendKeys(
                "Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tảng");
        return ui.txtTenChuDe.getAttribute("value").trim();
    }

    // Verify để trống tên chủ đề và nhấn lưu để kiểm tra message lỗi
    public String verifyEmtyTenChuDe() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe));
        ui.txtTenChuDe.click();
        ui.txtTenChuDe.sendKeys(Keys.CONTROL + "a");
        ui.txtTenChuDe.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định

        return ui.errorEmptyTenChuDe.getText().trim();
    }

    // Verify để trống trụ cột và nhấn lưu để kiểm tra message lỗi
    public String verifyEmtyTruCot() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
        ui.selectTruCot.click();
        clearTruCotSelect();
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định

        return ui.errorEmptyTrucot.getText().trim();
    }

    // Click vào select box Trụ cột
    public void clickTruCotSelect() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.selectTruCot));
        ui.selectTruCot.click();
        Thread.sleep(1000);
    }

    // Click vào icon clear trong select box Trụ cột để bỏ chọn
    public void clearTruCotSelect() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.clearTruCotSelect));
        ui.clearTruCotSelect.click();
        Thread.sleep(1000);
    }

    // Lấy text của phần tử đầu tiên trong dropdown sau khi click vào select box Trụ
    // cột
    public String GetitemTruCot() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
        // ui.selectTruCot.click();
        Thread.sleep(1000);
        WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'ant-select-item-option-content')][1]")));

        String text = firstOption.getText().trim();
        firstOption.click(); // Click vào phần tử đầu tiên để chọn nó
        Thread.sleep(1000); // Đợi 1s sau khi click để đảm bảo

        // Đóng dropdown
        /*
         * ui.selectTruCot.click();
         * Thread.sleep(3000);
         */
        return text;
    }

    // Hàm lấy mã chủ đề đã tồn tại để test case mã chủ đề bị trùng khi thêm mới
    public void GetMaChuDeTrung() throws InterruptedException {
        ui.iconClosePopup.click();
        Thread.sleep(1000);
        String maChuDe = ui.MaChuDeRecord.getText().trim();
        System.out.println("Ma Chu De da co san trong record: " + maChuDe);
        Thread.sleep(1000);
        ui.addButton.click();
        Thread.sleep(1000);
        ui.txtMaChuDe.click();
        Thread.sleep(1000);
        ui.txtMaChuDe.sendKeys(maChuDe);
        Thread.sleep(1000);
        ui.txtTenChuDe.click();
        Thread.sleep(1000);
        ui.txtTenChuDe.sendKeys("Ten Chu De Trung");
        ui.selectTruCot.click();
        Thread.sleep(1000);
        ui.selectTruCot.sendKeys(Keys.ARROW_DOWN);
        ui.selectTruCot.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    // Hàm lấy text của message thông báo sau khi thêm mới chủ đề thành công hoặc
    // thất bại
    public String GetNotificationMessage() {
        String message = wait.until(ExpectedConditions.visibilityOf(ui.NotificationMessage)).getText().trim();
        return message;
    }

    // Hàm lấy text của mã chủ đề, tên chủ đề, trụ cột trong record đầu tiên sau khi
    // thêm mới để verify
    public String GetTextMaChuDeInput() {
        String maChuDe = wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe))
                .getAttribute("value")
                .trim();
        System.out.println("Ma Chu De trong input: " + maChuDe);
        return maChuDe;
    }

    // Hàm kiểm tra xem textbox Mã chủ đề có bị disabled hay không sau khi thêm mới
    // thành công
    public boolean CheckDisabledMaChuDe() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
            return !ui.txtMaChuDe.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    // Hàm lấy text của tên chủ đề trong input để verify
    public String GetTextTenChuDeInput() {
        String tenChuDe = wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe))
                .getAttribute("value")
                .trim();
        System.out.println("Ten Chu De trong input: " + tenChuDe);
        return tenChuDe;
    }

    // Hàm lấy text của trụ cột đã chọn trong input để verify
    public String GetTextTruCotInput() {
        String truCot = wait.until(ExpectedConditions.visibilityOf(ui.selectedTruCotText))
                .getText()
                .trim();
        System.out.println("Tru Cot trong input: " + truCot);
        return truCot;
    }

    // Hàm lấy text của mã chủ đề, tên chủ đề, trụ cột trong record đầu tiên sau khi
    // thêm mới để verify
    public String GetTextMaChuDeRecord() {
        String maChuDe = wait.until(ExpectedConditions.visibilityOf(ui.MaChuDeRecord)).getText().trim();
        return maChuDe;
    }

    // Hàm lấy text của tên chủ đề trong record đầu tiên sau khi thêm mới để verify
    public String GetTextTenChuDeRecord() {
        String tenChuDe = wait.until(ExpectedConditions.visibilityOf(ui.TenChuDeRecord)).getText().trim();
        return tenChuDe;
    }

    // Hàm lấy text của trụ cột trong record đầu tiên sau khi thêm mới để verify
    public String GetTextTruCotRecord() {
        String truCot = wait.until(ExpectedConditions.visibilityOf(ui.TruCotRecord)).getText().trim();
        return truCot;
    }

    // Hàm verify message thêm mới chủ đề thành công
    public boolean VerifyMessageThemMoiChuDeThanhCong() {
        String message = wait.until(ExpectedConditions.visibilityOf(ui.MessageThemMoiChuDeThanhCong)).getText().trim();
        return message.contains("Thêm mới chủ đề thành công");
    }
        // Hàm verify message thêm mới chủ đề thành công
    public boolean VerifyMessageCapNhatChuDeThanhCong() {
        String message = wait.until(ExpectedConditions.visibilityOf(ui.MessageCapNhatChuDeThanhCong)).getText().trim();
        return message.contains("Cập nhật chủ đề thành công");
    }


    // Click icon edit theo mã chủ đề
    public void clickEditByMa(String ma) {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(ui.btnEditByMa(ma)));
        btn.click();
    }

    // Hàm verify các field trong form edit chủ đề khi click vào icon edit
    public boolean verifyEditTopicForm() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.EditTopicFormTitle));
            wait.until(ExpectedConditions.visibilityOf(ui.labelMaChuDe));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTenChuDe));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTruCot));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTrangThai));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // Hàm Verify title của popup confirm khi click vào button Hủy trong form thêm
    // mới hoặc chỉnh sửa
    public String VerifyTitlePopupConfirm() {
        String title = wait.until(ExpectedConditions.visibilityOf(ui.TitlePopupHuy)).getText().trim();
        return title;
    }

    // Hàm Verify content của popup confirm khi click vào button Hủy trong form thêm
    // mới hoặc chỉnh sửa
    public String VerifyContentPopupConfirm() {
        String content = wait.until(ExpectedConditions.visibilityOf(ui.ContentPopupHuy)).getText().trim();
        return content;
    }

    // Hàm click vào button Hủy trong popup confirm khi click vào button Hủy trong
    // form thêm mới hoặc chỉnh sửa
    public void clickIconHuyConfirm() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.buttonHuyPopupHuy));
        ui.buttonHuyPopupHuy.click();
    }

    // Hàm click vào button Xác nhận trong popup confirm khi click vào button Hủy
    // trong form thêm mới hoặc chỉnh sửa
    public void clickIconXacNhanConfirm() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(ui.buttonXacNhanPopupHuy));
        ui.buttonXacNhanPopupHuy.click();
    }

    //
    public boolean VerifyPopupConfirmClosed() {
        try {
            wait.until(ExpectedConditions.invisibilityOf(ui.TitlePopupHuy));
            return true; // Popup đã đóng
        } catch (Exception e) {
            return false; // Popup vẫn còn hiển thị
        }

    }

}