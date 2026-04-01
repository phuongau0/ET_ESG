package com.autojava.checkgenai.tests.test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.autojava.checkgenai.pages.Func.Func_LoginPage;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    protected Func_LoginPage loginFunc;
    
    // Method for listeners to access driver
    public WebDriver getDriver() {
        return driver;
    }
    
    // Cấu hình default
    private static final String DEFAULT_BROWSER = "chrome";
    private static final int IMPLICIT_WAIT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 30;

    @BeforeClass
    public void setupClass() {
        // Setup WebDriverManager một lần duy nhất cho toàn bộ test run
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional(DEFAULT_BROWSER) String browser) {
        driver = initDriver(browser);
        configDriver();
        // loginFunc = new Func_LoginPage(driver);
        // openLoginPage(); 
        // loginFunc.loginAs("admin","GREENFEED@2026");// Skip opening page to avoid browser issues
    }

    /**
     * Khởi tạo WebDriver theo browser type
     */
    private WebDriver initDriver(String browser) {
        String lowerBrowser = browser.toLowerCase();
        if ("firefox".equals(lowerBrowser)) {
            return new FirefoxDriver();
        } else if ("edge".equals(lowerBrowser)) {
            return new EdgeDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            return new ChromeDriver(options);
        }
    }

    /**
     * Cấu hình chung cho WebDriver
     */
    private void configDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
    }

    /**
     * Mở login page - có thể override nếu test khác cần mở page khác
     */
    protected void openLoginPage() {
        loginFunc.open();
    }

    @AfterTest
    public void teardown() {
    //    Don't quit driver here - let listeners handle screenshots first
        if (driver != null) {
            driver.quit();
          driver = null;
        }

        
    }
    
    /**
     * Helper: Chụp screenshot khi test fail (có thể dùng trong test)
     */
    protected void takeScreenshot(String fileName) {
        // Implement screenshot logic nếu cần
        // Ví dụ: dùng TakesScreenshot interface
    }
}