package com.autojava.checkgenai.pages.Func;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autojava.checkgenai.pages.UI.UI_LoginPage;

import java.time.Duration;
public class Func_LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public final UI_LoginPage ui; // Composition: chứa object UI

    public Func_LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.ui = new UI_LoginPage(driver); 
        
    }

    public void open() {
        driver.get(UI_LoginPage.getUrl());
        wait.until(ExpectedConditions.urlToBe(UI_LoginPage.getUrl()));
        wait.until(ExpectedConditions.urlToBe(UI_LoginPage.getUrl()));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(ui.txtUsername));
        ui.txtUsername.clear();
        ui.txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(ui.txtPassword));
        ui.txtPassword.clear();
        ui.txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.btnLogin));
        ui.btnLogin.click();
    }


    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}


