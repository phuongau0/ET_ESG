package com.autojava.checkgenai.pages.Func;

import org.openqa.selenium.Keys;
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

public void clickbuttonLuu() {
    wait.until(ExpectedConditions.elementToBeClickable(ui.buttonLuuEnabled));
    ui.buttonLuuEnabled.click();
}

public void clickbuttonHuy() {
    wait.until(ExpectedConditions.elementToBeClickable(ui.buttonHuy));
    ui.buttonHuy.click();
}



// Verify form thêm mới chủ đề
public boolean verifyAddNewTopicForm() {
    try {
        wait.until(ExpectedConditions.visibilityOf(ui.addNewTopicFormTitle));
        wait.until(ExpectedConditions.visibilityOf(ui.labelMaChuDe));
        wait.until(ExpectedConditions.visibilityOf(ui.labelTenChuDe));
        wait.until(ExpectedConditions.visibilityOf(ui.labelTruCot));
        wait.until(ExpectedConditions.visibilityOf(ui.labelTrangThai));
        wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
        wait.until(ExpectedConditions.visibilityOf(ui.txtTenChuDe));
        wait.until(ExpectedConditions.visibilityOf(ui.selectTruCot));
        wait.until(ExpectedConditions.visibilityOf(ui.toggleTrangThai));
        return true;
    } catch (Exception e) {
        return false;
    }


}


public String verifyMaChuDewheninputValiddata() {
    wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
    ui.txtMaChuDe.clear();
    ui.txtMaChuDe.sendKeys("KITU001");
    return ui.txtMaChuDe.getAttribute("value").trim();
}

public String verifyMaChuDewheninputInvaliddata() throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOf(ui.txtMaChuDe));
        // ✅ Clear với retry
      ui.txtMaChuDe.click();
    
    // ✅ Select all text (Ctrl+A)
    ui.txtMaChuDe.sendKeys(Keys.CONTROL + "a");
    
    // ✅ Xóa text đã chọn
    ui.txtMaChuDe.sendKeys(Keys.DELETE);
    Thread.sleep(1000); // Đợi 1s sau khi clear để đảm bảo trạng thái ổn định
    ui.txtMaChuDe.sendKeys("KITU001DAILAM");
    return ui.txtMaChuDe.getAttribute("value").trim();
}
}

