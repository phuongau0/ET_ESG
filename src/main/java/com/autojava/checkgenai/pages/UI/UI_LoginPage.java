package com.autojava.checkgenai.pages.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UI_LoginPage {

    private static final String URL = "https://esg.exceltech.vn/main/login";

    @FindBy(id = "username")
    @CacheLookup    
    public WebElement txtUsername;

    @FindBy(id = "password")
    @CacheLookup
    public WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    @CacheLookup
    public WebElement btnLogin;

    /* 
    @FindBy(css = "div.alert.alert-danger")
    public WebElement alertInvalid;
*/
    public UI_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static String getUrl() {
        return URL;
    }
}
