package com.autojava.checkgenai.pages.UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_QuanLyNhomChiTieu {

    // Menu item "Quản lý nhóm chỉ tiêu" bên trái

    // Title trên trang sau khi click
    @FindBy(xpath = "//div[contains(text(), 'Quản lý nhóm chỉ tiêu')]")
    public WebElement pageTitle;

    // Table header - bảng
    @FindBy(css = "thead.ant-table-thead tr th")
    public List<WebElement> allColumnHeaders;

    // Table body - tất cả rows
    @FindBy(css = "tbody.ant-table-tbody tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    public WebElement addButton;

    // Form thêm mới nhóm chỉ tiêu
    @FindBy(xpath = "//div[contains(text(), 'Thêm mới')]")
    public WebElement addNewTopicFormTitle;

    // Form Chỉnh sửa nhóm chỉ tiêu
    @FindBy(xpath = "//div[contains(text(), 'Chỉnh sửa')]")
    public WebElement EditTopicFormTitle;

    // Label Mã nhom chỉ tiêu
    @FindBy(xpath = "//label[contains(text(),'Mã nhóm chỉ tiêu')]")
    public WebElement labelMaNhomChiTieu;

    // Label Tên nhóm chỉ tiêu
    @FindBy(xpath = "//label[contains(text(),'Tên nhóm chỉ tiêu')]")
    public WebElement labelTenNhomChiTieu;

    // Label Chủ đề
    @FindBy(xpath = "//label[contains(text(),'Tên Chủ đề')]")
    public WebElement labelChuDe;

    // Label Trụ cột
    @FindBy(xpath = "//label[contains(text(),'Trụ cột')]")
    public WebElement labelTruCot;

    // Label Trạng thái
    @FindBy(xpath = "//label[contains(text(),'Trạng thái')]")
    public WebElement labelTrangThai;

    // Label chú thích
    @FindBy(xpath = "//label[contains(text(),'Trạng thái')]")
    public WebElement labelChuThich;

    // Textbox Mã nhóm chỉ tiêu
    @FindBy(id = "code")
    public WebElement txtMaNhomChiTieu;

    // Textbox Tên nhóm chỉ tiêu
    @FindBy(id = "name")
    public WebElement txtTenNhomChiTieu;

    // Textbox chủ đề
    @FindBy(id = "topicId")
    public WebElement txtChuDe;

    // Select trụ cột
    @FindBy(id = "pillarId")
    public WebElement selectTruCot;
    // Text sau khi chọn trụ cột
  @FindBy(xpath = "//input[@id='pillarId']/parent::div")
  public WebElement selectedTruCotText;

    // Chú thích
    @FindBy(id = "description")
    public WebElement txtChuThich;

    // Toogle Trạng thái
    @FindBy(xpath = "//button[@id='isActive']")
    public WebElement toggleTrangThai;

    // Button Hủy
    @FindBy(xpath = "//button[.='Hủy']")
    public WebElement buttonHuy;

    // Button Lưu - Disabled
    @FindBy(xpath = "//button[.='Lưu' and @disabled]")
    public WebElement buttonLuuDisabled;

    // Button Lưu - Enable
    @FindBy(xpath = "//button[.='Lưu' and not(@disabled)]")
    public WebElement buttonLuuEnabled;
    // Icon clear trong select trụ cột
  @FindBy(xpath = "//div[@class='ant-select-clear']//span[@aria-label='close-circle']//*[name()='svg']")
  public WebElement clearText;

    // Message bỏ trống Mã nhóm chỉ tiêu
    @FindBy(xpath = "//input[@id='code'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
    public WebElement errorEmptyMaNhomChiTieu;

    // Message bỏ trống tên nhóm chỉ tiêu
    @FindBy(xpath = "//input[@id='name'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
    public WebElement errorEmptyTenNhomChiTieu;

   // Message bỏ trống tên chủ đề
  @FindBy(xpath = "//input[@id='topicId'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
  public WebElement errorEmptyTenChuDe;

    // Text sau khi chọn chu de
  @FindBy(xpath = "//input[@id='topicId']/parent::div")
  public WebElement selectedChuDeText;

    // Record đầu tiên sau khi thêm mới thành công
    @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[1]")
    public WebElement MaNhomChiTieuRecordDauTien;

    @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[2]")
    public WebElement TenNhomChiTieuRecordDauTien;

    @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[3]")
    public WebElement ChuDeRecordDauTien;

    @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[4]")
    public WebElement TruCotRecordDauTien;

    @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[5]")
    public WebElement TrangThaiRecordDauTien;

    // Icon đóng popup

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M799.86 16')]")
    public WebElement iconClosePopup;

    // Noti Error message khi mã nhóm chỉ tiêu bị trùng
    @FindBy(xpath = "//div[@class='ant-notification-notice-description']")
    public WebElement NotificationMessage;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới nhóm chỉ tiêu thành công')]")
    public WebElement MessageThemMoiNhomChiTieuThanhCong;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật nhóm chỉ tiêu thành công')]")
    public WebElement MessageCapNhatNhomChiTieuThanhCong;

    @FindBy(xpath = "//span[contains(text(),'Vô hiệu hóa nhóm chỉ tiêu thành công')]")
    public WebElement MessageVoHieuHoaThanhCong;

    @FindBy(xpath = "//span[contains(text(),'Kích hoạt nhóm chỉ tiêu thành công')]")
    public WebElement MessageKichHoatNhomChiTieuThanhCong;

    @FindBy(xpath = "//div[@class='text-base font-semibold py-2']")
    public WebElement TitlePopupHuy;

    @FindBy(xpath = "//div[@class='text-[#535862]']")
    public WebElement ContentPopupHuy;

    @FindBy(xpath = "//button[.='Xác nhận']")
    public WebElement buttonXacNhanPopupHuy;

    @FindBy(xpath = "//input[@placeholder='Tìm kiếm']")
    public WebElement txtSearch;

    @FindBy(xpath = "//input[@id='_r_gc_']")
    public WebElement filterStatus;

    @FindBy(xpath = "//div[contains(text(),'Kích hoạt')]")
    public WebElement filterStatusKichHoat;

    @FindBy(xpath = "//div[contains(text(),'Vô hiệu hóa')]")
    public WebElement filterStatusVoHieuHoa;

    @FindBy(xpath = "//div[@class='ant-empty-description']")
    public WebElement emptySearchResultMessage;

    @FindBy(xpath = "//span[normalize-space()='Export']")
    public WebElement buttonExport;

    @FindBy(xpath = "//span[normalize-space()='Import']")
    public WebElement buttonImport;

    @FindBy(xpath = "//span[normalize-space()='Không']")
    public WebElement optionKhong;

    @FindBy(xpath = "//span[normalize-space()='Có']")
    public WebElement optionCo;

    // ===== DYNAMIC ELEMENT dùng để edit mã nhóm chỉ tiêu =====
    public By btnEditByMa(String ma) {
        return By.xpath(
                "//td[normalize-space()='" + ma + "']/ancestor::tr//button[.//span[contains(@aria-label,'edit')]]");
    }
    @FindBy(xpath = "  //div[@role='dialog' and .//text()[contains(.,'Bạn có xác nhận')]] //button[normalize-space()='Hủy']")
  public WebElement buttonHuyPopupHuy;

    public UI_QuanLyNhomChiTieu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
