package com.autojava.checkgenai.pages.UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_QuanLychude {

  // Menu item "Quản lý chủ đề" bên trái

  // Title trên trang sau khi click
  @FindBy(xpath = "//div[contains(text(), 'Quản lý chủ đề')]")
  public WebElement pageTitle;

  // Table header - bảng
  @FindBy(css = "thead.ant-table-thead tr th")
  public List<WebElement> allColumnHeaders;

  // Table body - tất cả rows
  @FindBy(css = "tbody.ant-table-tbody tr")
  public List<WebElement> tableRows;

  @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
  public WebElement addButton;

  // Form thêm mới chủ đề
  @FindBy(xpath = "//div[contains(text(), 'Thêm mới')]")
  public WebElement addNewTopicFormTitle;

  // Form thêm mới chủ đề
  @FindBy(xpath = "//div[contains(text(), 'Chỉnh sửa')]")
  public WebElement EditTopicFormTitle;

  // Label Mã chủ đề
  @FindBy(xpath = "//label[contains(text(),'Mã chủ đề')]")
  public WebElement labelMaChuDe;

  // Label Tên chủ đề
  @FindBy(xpath = "//label[contains(text(),'Tên chủ đề')]")
  public WebElement labelTenChuDe;

  // Label Trụ cột
  @FindBy(xpath = "//label[contains(text(),'Trụ cột')]")
  public WebElement labelTruCot;

  // Label Trạng thái
  @FindBy(xpath = "//label[contains(text(),'Trạng thái')]")
  public WebElement labelTrangThai;

  // Textbox Mã chủ đề
  @FindBy(id = "code")
  public WebElement txtMaChuDe;

  // Textbox Tên chủ đề
  @FindBy(id = "name")
  public WebElement txtTenChuDe;

  // Selectbox trụ cột
  @FindBy(id = "pillarId")
  public WebElement selectTruCot;

  // Text sau khi chọn trụ cột
  @FindBy(xpath = "//input[@id='pillarId']/parent::div")
  public WebElement selectedTruCotText;

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

  // Message bỏ trống Mã chủ đề
  @FindBy(xpath = "//input[@id='code'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
  public WebElement errorEmptyMaChuDe;

  // Message bỏ trống tên chủ đề
  @FindBy(xpath = "//input[@id='name'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
  public WebElement errorEmptyTenChuDe;

  // Icon clear trong select trụ cột
  @FindBy(xpath = "//div[@class='ant-select-clear']//span[@aria-label='close-circle']//*[name()='svg']")
  public WebElement clearTruCotSelect;

  // Message bỏ trống Trụ cột
  @FindBy(xpath = "//input[@id='pillarId'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
  public WebElement errorEmptyTrucot;

  // Record đầu tiên sau khi thêm mới thành công
  @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[1]")
  public WebElement MaChuDeRecord;

  @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[2]")
  public WebElement TenChuDeRecord;

  @FindBy(xpath = "(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[3]")
  public WebElement TruCotRecord;

  @FindBy(xpath = "//tbody/tr[(contains(@class,'ant-table-row ant-table-row-level-0 bg-white'))][1]/td[4]/div/button")
  public WebElement TrangThaiRecord;

  // Icon đóng popup

  @FindBy(xpath = "//*[name()='path' and contains(@d,'M799.86 16')]")
  public WebElement iconClosePopup;

  // Noti Error message khi mã chủ đề bị trùng
  @FindBy(xpath = "//div[@class='ant-notification-notice-description']")
  public WebElement NotificationMessage;

  @FindBy(xpath = "//span[contains(text(),'Thêm mới chủ đề thành công')]")
  public WebElement MessageThemMoiChuDeThanhCong;

  @FindBy(xpath = "//span[contains(text(),'Cập nhật chủ đề thành công')]")
  public WebElement MessageCapNhatChuDeThanhCong;

  @FindBy(xpath = "//span[contains(text(),'Vô hiệu hóa chủ đề thành công')]")
  public WebElement MessageVoHieuHoaThanhCong;

  @FindBy(xpath = "//span[contains(text(),'Kích hoạt chủ đề thành công')]")
  public WebElement MessageKichHoatChuDeThanhCong;

  public UI_QuanLychude(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//div[@class='text-base font-semibold py-2']")
  public WebElement TitlePopupHuy;

  @FindBy(xpath = "//div[@class='text-[#535862]']")
  public WebElement ContentPopupHuy;

  @FindBy(xpath = "//button[.='Xác nhận']")
  public WebElement buttonXacNhanPopupHuy;

  @FindBy(xpath = "  //div[@role='dialog' and .//text()[contains(.,'Bạn có xác nhận')]] //button[normalize-space()='Hủy']")
  public WebElement buttonHuyPopupHuy;

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

  // ===== DYNAMIC ELEMENT dùng để edit mã chủ đề =====
  public By btnEditByMa(String ma) {
    return By.xpath("//td[normalize-space()='" + ma + "']/ancestor::tr//button[.//span[contains(@aria-label,'edit')]]");
  }

}
