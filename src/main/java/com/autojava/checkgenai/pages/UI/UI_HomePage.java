package com.autojava.checkgenai.pages.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_HomePage {

    

    @FindBy(xpath = "//li[@role='none']")
    @CacheLookup    
    public WebElement liMasterData;

    @FindBy(xpath = "//li[@title='Quản lý chủ đề']")
    @CacheLookup    
    public WebElement liQLChuDe;
    

    public UI_HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
