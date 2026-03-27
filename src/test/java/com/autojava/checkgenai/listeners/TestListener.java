package com.autojava.checkgenai.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static final String SCREENSHOT_DIR = "target/screenshots/";
    private static final String REPORT_DIR = "target/test-reports/";

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🚀 Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test PASSED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test FAILED: " + result.getMethod().getMethodName());

        // Lấy WebDriver từ test class
        WebDriver driver = getDriverFromTest(result);
        if (driver != null) {
            takeScreenshot(driver, result);
        }

        // Ghi lý do lỗi chi tiết
        logFailureDetails(result);

        // Quit driver after capturing screenshot
        quitDriver(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭️ Test SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("📋 Test Suite started: " + context.getName());
        createDirectories();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("📊 Test Suite finished: " + context.getName());
        System.out.println("📈 Results: Passed=" + context.getPassedTests().size() +
                          ", Failed=" + context.getFailedTests().size() +
                          ", Skipped=" + context.getSkippedTests().size());
    }

    private WebDriver getDriverFromTest(ITestResult result) {
        try {
            // Lấy driver từ test class thông qua method getDriver()
            Object testClass = result.getInstance();
            if (testClass instanceof com.autojava.checkgenai.tests.test.BaseTest) {
                WebDriver driver = ((com.autojava.checkgenai.tests.test.BaseTest) testClass).getDriver();
                System.out.println("✅ Successfully got WebDriver from BaseTest.getDriver()");
                return driver;
            } else {
                System.out.println("❌ Test class is not instance of BaseTest");
                return null;
            }
        } catch (Exception e) {
            System.out.println("❌ Could not get WebDriver: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private void takeScreenshot(WebDriver driver, ITestResult result) {
        try {
            // Tạo tên file với timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String testName = result.getMethod().getMethodName();
            String fileName = testName + "_FAIL_" + timestamp + ".png";

            // Tạo thư mục nếu chưa có
            File screenshotDir = new File(SCREENSHOT_DIR);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Chụp ảnh
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(SCREENSHOT_DIR + fileName);

            // Copy file
            FileHandler.copy(screenshot, destFile);

            System.out.println("📸 Screenshot saved: " + destFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }

    private void logFailureDetails(ITestResult result) {
        try {
            // Tạo thư mục reports
            File reportDir = new File(REPORT_DIR);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            // Tạo tên file
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String testName = result.getMethod().getMethodName();
            String fileName = testName + "_ERROR_" + timestamp + ".txt";

            // Ghi chi tiết lỗi
            File errorFile = new File(REPORT_DIR + fileName);
            StringBuilder errorDetails = new StringBuilder();

            errorDetails.append("=== TEST FAILURE REPORT ===\n");
            errorDetails.append("Test Class: ").append(result.getTestClass().getName()).append("\n");
            errorDetails.append("Test Method: ").append(result.getMethod().getMethodName()).append("\n");
            errorDetails.append("Failure Time: ").append(new Date()).append("\n");
            errorDetails.append("Test Parameters: ").append(java.util.Arrays.toString(result.getParameters())).append("\n");
            errorDetails.append("\n=== EXCEPTION DETAILS ===\n");
            errorDetails.append("Exception Type: ").append(result.getThrowable().getClass().getName()).append("\n");
            errorDetails.append("Exception Message: ").append(result.getThrowable().getMessage()).append("\n");
            errorDetails.append("\n=== STACK TRACE ===\n");

            // Ghi stack trace
            for (StackTraceElement element : result.getThrowable().getStackTrace()) {
                errorDetails.append(element.toString()).append("\n");
            }

            // Ghi file
            java.nio.file.Files.write(errorFile.toPath(), errorDetails.toString().getBytes());

            System.out.println("📝 Error details saved: " + errorFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("❌ Failed to save error details: " + e.getMessage());
        }
    }

    private void quitDriver(ITestResult result) {
        try {
            Object testClass = result.getInstance();
            if (testClass instanceof com.autojava.checkgenai.tests.test.BaseTest) {
                WebDriver driver = ((com.autojava.checkgenai.tests.test.BaseTest) testClass).getDriver();
                if (driver != null) {
                    driver.quit();
                    System.out.println("🛑 Driver quit after test failure");
                    // Note: We can't set driver to null through method, but that's ok
                }
            }
        } catch (Exception e) {
            System.out.println("⚠️ Could not quit driver: " + e.getMessage());
        }
    }

    private void createDirectories() {
        try {
            File screenshotDir = new File(SCREENSHOT_DIR);
            File reportDir = new File(REPORT_DIR);

            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                System.out.println("📁 Created screenshots directory: " + screenshotDir.getAbsolutePath());
            }

            if (!reportDir.exists()) {
                reportDir.mkdirs();
                System.out.println("📁 Created reports directory: " + reportDir.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to create directories: " + e.getMessage());
        }
    }
}