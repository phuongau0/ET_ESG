package com.autojava.checkgenai.pages.Func;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autojava.checkgenai.pages.UI.UI_HomePage;

import java.time.Duration;
public class Func_HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public final UI_HomePage ui; // Composition: chứa object UI

    public Func_HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.ui = new UI_HomePage(driver); 
        
    }




    public void clickMasterData() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.liMasterData));
        ui.liMasterData.click();
    }

  public void clickQLChuDe() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.liQLChuDe));
        ui.liQLChuDe.click();
    }

   
}


