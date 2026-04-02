package com.autojava.checkgenai.pages.UI;

import java.util.List;

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
  @FindBy(id="pillarId")
  public WebElement selectTruCot;

  @FindBy(xpath =  "//input[@id='pillarId']/parent::div")
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

  @FindBy(xpath = "//input[@id='code'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
  public WebElement errorEmptyMaChuDe;

  @FindBy(xpath = "//input[@id='name'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
  public WebElement errorEmptyTenChuDe;


  @FindBy(xpath="//div[@class='ant-select-clear']//span[@aria-label='close-circle']//*[name()='svg']")
  public WebElement clearTruCotSelect;

  @FindBy(xpath = "//input[@id='pillarId'] /ancestor::div[contains(@class,'ant-form-item')] //div[contains(@class,'ant-form-item-explain-error')]")
  public WebElement errorEmptyTrucot;


  @FindBy(xpath="(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[1]")
  public WebElement MaChuDeRecord;

  @FindBy(xpath="(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[2]")
  public WebElement TenChuDeRecord;

    @FindBy(xpath="(//tbody/tr[not(contains(@class,'measure-row'))])[1]/td[3]")
  public WebElement TruCotRecord;



  @FindBy(xpath="//*[name()='path' and contains(@d,'M799.86 16')]")
  public WebElement iconClosePopup;

@FindBy(xpath = "//div[@class='ant-notification-notice-description']")
public WebElement NotificationMessage;



@FindBy(xpath = "//span[contains(text(),'Thêm mới chủ đề thành công')]")
public WebElement MessageThemMoiChuDeThanhCong;

  public UI_QuanLychude(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }



  

}
