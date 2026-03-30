package com.autojava.checkgenai.pages.Func;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.autojava.checkgenai.pages.UI.UI_QuanLychude;
import java.time.Duration;
import java.util.List;

public class Func_QuanLychude {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public final UI_QuanLychude ui;



    public Func_QuanLychude(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.ui = new UI_QuanLychude(driver);
    }


    // Lấy title của trang QL Chu De
    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(ui.pageTitle));
        return ui.pageTitle.getText().trim();
    }

    
    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ui.addButton));
        ui.addButton.click();
    }


    // Get tất cả column trong trang QL chu de
public boolean verifyColumnByIndex(int columnIndex, String expectedName) {
    wait.until(ExpectedConditions.visibilityOfAllElements(ui.allColumnHeaders));
    
    List<WebElement> headers = ui.allColumnHeaders;
    
    if (columnIndex < 1 || columnIndex > headers.size()) {
        return false;
    }
    
    String actualName = headers.get(columnIndex - 1).getText().trim();
    return actualName.equals(expectedName);
}


    
}


