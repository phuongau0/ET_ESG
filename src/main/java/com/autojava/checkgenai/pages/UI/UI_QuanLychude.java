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

    @FindBy(css="//button[@class='ant-btn css-1t2537o css-var-_r_0_ ant-btn-primary ant-btn-color-primary ant-btn-variant-solid']"    )
        public WebElement addButton;


    public UI_QuanLychude(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
