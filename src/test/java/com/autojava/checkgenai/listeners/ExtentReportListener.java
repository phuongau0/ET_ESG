package com.autojava.checkgenai.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static final String REPORT_PATH = "target/extent-reports/";

    @Override
    public void onStart(ITestContext context) {
        // Tạo thư mục reports
        File reportDir = new File(REPORT_PATH);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Khởi tạo ExtentReports
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportName = "TestReport_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(REPORT_PATH + reportName);
        spark.config().setDocumentTitle("AutoJava Test Report");
        spark.config().setReportName("CheckGenAI Test Suite");
        spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        System.out.println("📊 ExtentReports initialized: " + reportDir.getAbsolutePath() + "/" + reportName);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test PASSED: " + result.getMethod().getMethodName());
        test.log(Status.INFO, "Execution time: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test FAILED: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Failure Reason: " + result.getThrowable().getMessage());

        // Thêm stack trace
        test.log(Status.FAIL, "Stack Trace: " + result.getThrowable());

        // Chụp ảnh và thêm vào report
        WebDriver driver = getDriverFromTest(result);
        if (driver != null) {
            String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
            if (screenshotPath != null) {
                try {
                    test.fail("Screenshot on failure:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } catch (Exception e) {
                    test.fail("Failed to attach screenshot: " + e.getMessage());
                }
            }
        }

        // Thêm thông tin chi tiết
        test.log(Status.INFO, "Test Class: " + result.getTestClass().getName());
        test.log(Status.INFO, "Test Method: " + result.getMethod().getMethodName());
        test.log(Status.INFO, "Parameters: " + java.util.Arrays.toString(result.getParameters()));
        test.log(Status.INFO, "Execution time: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test SKIPPED: " + result.getMethod().getMethodName());
        test.log(Status.SKIP, "Skip Reason: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("📊 ExtentReports generated successfully");
        System.out.println("📈 Final Results: Passed=" + context.getPassedTests().size() +
                          ", Failed=" + context.getFailedTests().size() +
                          ", Skipped=" + context.getSkippedTests().size());
    }

    private WebDriver getDriverFromTest(ITestResult result) {
        try {
            Object testClass = result.getInstance();
            return (WebDriver) testClass.getClass().getField("driver").get(testClass);
        } catch (Exception e) {
            return null;
        }
    }

    private String captureScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = testName + "_FAIL_" + timestamp + ".png";

            File screenshotDir = new File("target/screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotDir, fileName);
            org.openqa.selenium.io.FileHandler.copy(screenshot, destFile);

            String absolutePath = destFile.getAbsolutePath();
            System.out.println("📸 Saved screenshot to: " + absolutePath);
            return absolutePath; // Absolute path so Extent can find it

        } catch (Exception e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }
}