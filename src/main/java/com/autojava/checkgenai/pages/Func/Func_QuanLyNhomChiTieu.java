package com.autojava.checkgenai.pages.Func;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.autojava.checkgenai.pages.UI.UI_QuanLyNhomChiTieu;
import java.time.Duration;
import java.util.List;

public class Func_QuanLyNhomChiTieu {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public final UI_QuanLyNhomChiTieu ui;

    public Func_QuanLyNhomChiTieu(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.ui = new UI_QuanLyNhomChiTieu(driver);
    }

    // Lấy title của trang QL Nhóm Chi Tiêu
    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(ui.pageTitle));
        return ui.pageTitle.getText().trim();
    }

    // Click vào button Thêm mới
    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.addButton));
        ui.addButton.click();
    }

    // Get tất cả column trong trang QL nhom chi tieu
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

    // Verify form thêm mới nhóm chỉ tiêu
    public boolean verifyAddNewNhomChiTieuForm() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.addNewTopicFormTitle));
            wait.until(ExpectedConditions.visibilityOf(ui.labelMaNhomChiTieu));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTenNhomChiTieu));
            wait.until(ExpectedConditions.visibilityOf(ui.labelChuThich));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTruCot));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTrangThai));
            wait.until(ExpectedConditions.visibilityOf(ui.txtMaNhomChiTieu));
            wait.until(ExpectedConditions.visibilityOf(ui.txtTenNhomChiTieu));
            wait.until(ExpectedConditions.visibilityOf(ui.txtChuThich));
            wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
            wait.until(ExpectedConditions.visibilityOf(ui.toggleTrangThai));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // Nhập dữ liệu hợp lệ vào mã chủ đề và verify
    public String verifyMaNhomChiTieuwheninputValiddata() {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaNhomChiTieu));
        ui.txtMaNhomChiTieu.clear();
        ui.txtMaNhomChiTieu.sendKeys("KITU001");
        return ui.txtMaNhomChiTieu.getAttribute("value").trim();
    }

    // Nhập dữ liệu không hợp lệ vào mã chủ đề (ví dụ: quá dài) và verify
    public String verifyMaNhomChiTieuwheninputInvaliddata() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaNhomChiTieu));
        // ✅ Clear với retry
        ui.txtMaNhomChiTieu.click();

        // ✅ Select all text (Ctrl+A)
        ui.txtMaNhomChiTieu.sendKeys(Keys.CONTROL + "a");

        // ✅ Xóa text đã chọn
        ui.txtMaNhomChiTieu.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        ui.txtMaNhomChiTieu.sendKeys("KITU001DAILAM");
        return ui.txtMaNhomChiTieu.getAttribute("value").trim();
    }

    // Nhấn lưu khi để trống mã chủ đề và verify message lỗi
    public String verifyEmtyMaNhomChiTieu() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaNhomChiTieu));
        ui.txtMaNhomChiTieu.click();
        ui.txtMaNhomChiTieu.sendKeys(Keys.CONTROL + "a");
        ui.txtMaNhomChiTieu.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định

        return ui.errorEmptyMaNhomChiTieu.getText().trim();
    }

    // Hàm random dữ liệu cho Mã nhóm chỉ tiêu
    public void RandomMaNhomChiTieu() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaNhomChiTieu));
        ui.txtMaNhomChiTieu.click();
        ui.txtMaNhomChiTieu.sendKeys(Keys.CONTROL + "a");
        ui.txtMaNhomChiTieu.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        String timestamp = String.valueOf(System.currentTimeMillis());
        timestamp = timestamp.substring(0, 10);
        ui.txtMaNhomChiTieu.sendKeys("KITU" + timestamp);
    }

    // Hàm random dữ liệu cho Tên nhóm chỉ tiêu
    public void RandomTenNhomChiTieu() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenNhomChiTieu));
        ui.txtTenNhomChiTieu.click();
        ui.txtTenNhomChiTieu.sendKeys(Keys.CONTROL + "a");
        ui.txtTenNhomChiTieu.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        String timestamp = String.valueOf(System.currentTimeMillis());
        ui.txtTenNhomChiTieu.sendKeys("AUTO_TEN" + timestamp);
    }

    // Hàm random dữ liệu cho Tên nhóm chỉ tiêu trong form edit (để phân biệt với tên nhóm chỉ tiêu đã tồn tại khi thêm mới)
    public void RandomTenNhomChiTieuforUpdate() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenNhomChiTieu));
        ui.txtTenNhomChiTieu.click();
        ui.txtTenNhomChiTieu.sendKeys(Keys.CONTROL + "a");
        ui.txtTenNhomChiTieu.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
        String timestamp = String.valueOf(System.currentTimeMillis());
        ui.txtTenNhomChiTieu.sendKeys("AUTO_TEN" + timestamp + "UPDATE");
    }

    // Hàm  Truyền Topic vào select box Chủ đề
    public void RandomTruCot(String topicname) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
        ui.selectTruCot.click();
        Thread.sleep(1000);
        ui.selectTruCot.sendKeys(topicname);
        ui.selectTruCot.sendKeys(Keys.ENTER);
        

    }


    // So sánh trụ cột được get bên chủ đề

    public boolean verifyTruCotSelected(String expectedTruCot) {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
            String actualTruCot = ui.selectTruCot.getText().trim();
            return actualTruCot.equals(expectedTruCot);
        } catch (Exception e) {
            return false;
        }
    }



    // Verify trụ cột bị disable
    public boolean verifyTruCotDisabled() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
            return !ui.selectTruCot.isEnabled();
        } catch (Exception e) {
            return false;
        }
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
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenNhomChiTieu));
        ui.txtTenNhomChiTieu.clear();
        ui.txtTenNhomChiTieu.sendKeys("Tên nhóm chỉ tiêu 1");
        return ui.txtTenNhomChiTieu.getAttribute("value").trim();
    }

    // Verify nhập dữ liệu không hợp lệ vào tên chủ đề (ví dụ: quá dài)
    public String verifyTenChuDewheninputInvaliddata() {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenNhomChiTieu));
        ui.txtTenNhomChiTieu.click();
        ui.txtTenNhomChiTieu.sendKeys(Keys.CONTROL + "a");
        ui.txtTenNhomChiTieu.sendKeys(Keys.DELETE);
        ui.txtTenNhomChiTieu.sendKeys(
                "Quản lý dữ liệu khách hàng và tối ưu trải nghiệm người dùng trên nền tảng số nhằm nâng cao hiệu quả kinh doanh và cải thiện chất lượng dịch vụ trong hệ thống quản trị doanh nghiệp hiện đại với khả năng mở rộng linh hoạt và tích hợp đa nền tảng,  đa nền tảng");
        return ui.txtTenNhomChiTieu.getAttribute("value").trim();
    }

    // Verify để trống tên chủ đề và nhấn lưu để kiểm tra message lỗi
    public String verifyEmtyTenChuDe() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenNhomChiTieu));
        ui.txtTenNhomChiTieu.click();
        ui.txtTenNhomChiTieu.sendKeys(Keys.CONTROL + "a");
        ui.txtTenNhomChiTieu.sendKeys(Keys.DELETE);
        Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định

        return ui.errorEmptyTenNhomChiTieu.getText().trim();
    }

    // // Verify để trống trụ cột và nhấn lưu để kiểm tra message lỗi
    // public String verifyEmtyTruCot() throws InterruptedException {
    //     wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
    //     ui.selectTruCot.click();
    //     clearTruCotSelect();
    //     Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định

    //     return ui.errorEmptyTrucot.getText().trim();
    // }

    // Click vào select box Trụ cột
    public void clickTruCotSelect() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.selectTruCot));
        ui.selectTruCot.click();
        Thread.sleep(1000);
    }

    // // Click vào icon clear trong select box Trụ cột để bỏ chọn
    // public void clearTruCotSelect() throws InterruptedException {
    //     wait.until(ExpectedConditions.elementToBeClickable(ui.clearTruCotSelect));
    //     ui.clearTruCotSelect.click();
    //     Thread.sleep(1000);
    // }

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
    public void GetMaChuDeTrung(String maChuDe) throws InterruptedException {
        ui.iconClosePopup.click();
        Thread.sleep(1000);
        String maNhomChitieuString = ui.MaNhomChiTieuRecordDauTien.getText().trim();
        System.out.println("Ma Nhom Chi Tieu da co san trong record: " + maNhomChitieuString);
        Thread.sleep(1000);
        ui.addButton.click();
        Thread.sleep(1000);
        ui.txtMaNhomChiTieu.click();
        Thread.sleep(1000);
        ui.txtMaNhomChiTieu.sendKeys(maChuDe);
        Thread.sleep(1000);
        ui.txtTenNhomChiTieu.click();
        Thread.sleep(1000);
        ui.txtTenNhomChiTieu.sendKeys("Ten Nhom Chi Tieu Trung");
        ui.txtChuDe.sendKeys(maChuDe);
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
    public String GetTextMaNhomChiTieuInput() {
        String maNhomChiTieuString = wait.until(ExpectedConditions.visibilityOf(ui.txtMaNhomChiTieu))
                .getAttribute("value")
                .trim();
        System.out.println("Ma Nhom Chi Tieu trong input: " + maNhomChiTieuString);
        return maNhomChiTieuString;
    }

    // Hàm kiểm tra xem textbox Mã chủ đề có bị disabled hay không sau khi thêm mới
    // thành công
    public boolean CheckDisabledMaNhomChiTieu() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.txtMaNhomChiTieu));
            return !ui.txtMaNhomChiTieu.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    // Hàm lấy text của tên chủ đề trong input để verify
    public String GetTextTenNhomChiTieuInput() {
        String tenNhomChiTieu = wait.until(ExpectedConditions.visibilityOf(ui.txtTenNhomChiTieu))
                .getAttribute("value")
                .trim();
        System.out.println("Ten Nhom Chi Tieu trong input: " + tenNhomChiTieu);
        return tenNhomChiTieu;
    }

    // Hàm lấy text của chủ đề
    public String GetTextChuDeInput() {
        String chuDe = wait.until(ExpectedConditions.visibilityOf(ui.txtChuDe))
                .getAttribute("value")
                .trim();
        System.out.println("Chu De trong input: " + chuDe);
        return chuDe;
    }   

    // Hàm lấy text của trụ cột đã chọn trong input để verify
    public String GetTextTruCotInput() {
        String truCot = wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot))
                .getText()
                .trim();
        System.out.println("Tru Cot trong input: " + truCot);
        return truCot;
    }

    // Hàm lấy text của mã chủ đề, tên chủ đề, trụ cột trong record đầu tiên sau khi
    // thêm mới để verify
    public String GetTextMaNhomChiTieuRecord() {
        String maNhomChiTieu = wait.until(ExpectedConditions.visibilityOf(ui.MaNhomChiTieuRecordDauTien)).getText().trim();
        return maNhomChiTieu;
    }

    // Hàm lấy text của tên chủ đề trong record đầu tiên sau khi thêm mới để verify
    public String GetTextTenNhomChiTieuRecord() {
        String tenNhomChiTieu = wait.until(ExpectedConditions.visibilityOf(ui.TenNhomChiTieuRecordDauTien)).getText().trim();
        return tenNhomChiTieu;
    }

    // Hàm lấy text của chủ đề trong record đầu tiên sau khi thêm mới để verify
    public String GetTextChuDeRecord() {
        String chuDe = wait.until(ExpectedConditions.visibilityOf(ui.ChuDeRecordDauTien)).getText().trim();
        return chuDe;
    }

    // Hàm lấy text của trụ cột trong record đầu tiên sau khi thêm mới để verify
    public String GetTextTruCotRecord() {
        String truCot = wait.until(ExpectedConditions.visibilityOf(ui.TruCotRecordDauTien)).getText().trim();
        return truCot;
    }

    public String GetTextTrangThaiRecord() {
        String trangThai = wait.until(ExpectedConditions.visibilityOf(ui.TrangThaiRecordDauTien)).getAttribute("aria-checked")
                .trim();
        System.out.println("Trang Thai trong record: " + trangThai);
        return trangThai;
    }

    // Hàm verify message thêm mới chủ đề thành công
    public boolean VerifyMessageThemMoiNhomChiTieuThanhCong() {
        String message = wait.until(ExpectedConditions.visibilityOf(ui.MessageThemMoiNhomChiTieuThanhCong)).getText().trim();
        return message.contains("Thêm mới chủ đề thành công");
    }

    // Hàm verify message thêm mới chủ đề thành công
    public boolean VerifyMessageCapNhatNhomChiTieuThanhCong() {
        String message = wait.until(ExpectedConditions.visibilityOf(ui.MessageCapNhatNhomChiTieuThanhCong)).getText().trim();
        return message.contains("Cập nhật nhóm chi tiêu thành công");
    }

    public boolean VerifyMessageVoHieuHoaThanhCong() {
        String message = wait.until(ExpectedConditions.visibilityOf(ui.MessageVoHieuHoaThanhCong)).getText().trim();
        return message.contains("Vô hiệu hóa nhóm chi tiêu thành công");
    }

    public boolean VerifyMessageKichHoatNhomChiTieuThanhCong() {
        String message = wait.until(ExpectedConditions.visibilityOf(ui.MessageKichHoatNhomChiTieuThanhCong)).getText().trim();
        return message.contains("Kích hoạt nhóm chi tiêu thành công");
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
            wait.until(ExpectedConditions.visibilityOf(ui.labelMaNhomChiTieu));
            wait.until(ExpectedConditions.visibilityOf(ui.labelTenNhomChiTieu));
            wait.until(ExpectedConditions.visibilityOf(ui.labelChuDe));
            wait.until(ExpectedConditions.visibilityOf(ui.labelChuThich));
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

    // Hàm verify popup confirm đã đóng sau khi click vào button Hủy hoặc Xác nhận
    public boolean VerifyPopupConfirmClosed() {
        try {
            wait.until(ExpectedConditions.invisibilityOf(ui.ContentPopupHuy));
            return true; // Popup đã đóng
        } catch (Exception e) {
            return false; // Popup vẫn còn hiển thị
        }

    }

    // Hàm click vào toggle trạng thái trong form edit để tắt trạng thái
    public void clickToogleTrangThai() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.toggleTrangThai));
        ui.toggleTrangThai.click();
        Thread.sleep(1000);
    }

    // Verify trạng thái của toggle trạng thái trong form edit sau khi click để tắt
    // trạng thái
    public String VerifyToggleTrangThai() {
        wait.until(ExpectedConditions.visibilityOf(ui.toggleTrangThai));
        String ariaChecked = ui.toggleTrangThai.getAttribute("aria-checked").trim();
        return ariaChecked;
    }

    // Hàm click vào toggle trạng thái trong record để tắt trạng thái
    public void clickToogleTrangThaiInRecord() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.TrangThaiRecordDauTien));
        ui.TrangThaiRecordDauTien.click();
        Thread.sleep(1000);
    }

    public void InputSearch(String keyword) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ui.txtSearch));
        ui.txtSearch.sendKeys(Keys.CONTROL + "a");
        ui.txtSearch.sendKeys(Keys.DELETE);
        ui.txtSearch.sendKeys(keyword);
        ui.txtSearch.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public boolean VerifySearchResultMaNhomChiTieu(String expectedMaNhomChiTieu) {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.MaNhomChiTieuRecordDauTien));

            String actualMaNhomChiTieu = ui.MaNhomChiTieuRecordDauTien.getText().trim();

            return actualMaNhomChiTieu.equals(expectedMaNhomChiTieu);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean VerifySearchResultTenNhomChiTieu(String expectedTenNhomChiTieu) {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.TenNhomChiTieuRecordDauTien));

            String actualTenNhomChiTieu = ui.TenNhomChiTieuRecordDauTien.getText().trim();

            return actualTenNhomChiTieu.equals(expectedTenNhomChiTieu);
        } catch (Exception e) {
            return false;
        }
    }

    // Hàm verify chức năng tìm kiếm không thấy kết quả
    public boolean VerifySearchResultEmpty() {
        try {
            wait.until(ExpectedConditions.visibilityOf(ui.emptySearchResultMessage));
            String message = ui.emptySearchResultMessage.getText().trim();
            return message.equals("Dữ liệu trống");
        } catch (Exception e) {
            return false;
        }
    }

    public void clickExportButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.buttonExport));
        ui.buttonExport.click();
        Thread.sleep(1000);
    }

    public void clickImportButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.buttonImport));
        ui.buttonImport.click();
        Thread.sleep(1000);
    }

    public void clickButtonKhong() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.optionKhong));
        ui.optionKhong.click();
        Thread.sleep(1000);
    }

    public void clickButtonCo() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ui.optionCo));
        ui.optionCo.click();
        Thread.sleep(1000);
    }

}