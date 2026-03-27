package com.autojava.checkgenai.pages.UI;
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


    public UI_QuanLychude(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
