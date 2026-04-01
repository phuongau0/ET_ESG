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

    @FindBy(xpath="//span[contains(text(),'Thêm mới')]")  
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
    @FindBy(xpath  = "//div[@class='ant-select ant-select-outlined ant-select-in-form-item css-var-_r_0_ ant-select-css-var css-1t2537o ant-select-single ant-select-show-arrow ant-select-show-search']")
    public WebElement selectTruCot;

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

      public UI_QuanLychude(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
