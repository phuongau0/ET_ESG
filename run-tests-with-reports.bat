@echo off
echo ========================================
echo    AutoJava Test Runner with Reports
echo ========================================
echo.

echo [1/4] Cleaning previous reports...
if exist target\screenshots rmdir /s /q target\screenshots
if exist target\test-reports rmdir /s /q target\test-reports
if exist target\extent-reports rmdir /s /q target\extent-reports
echo.

echo [2/4] Running tests...
mvn clean test
echo.

echo [3/4] Generating test summary...
echo ========================================
echo TEST RESULTS SUMMARY
echo ========================================
if exist target\surefire-reports\testng-results.xml (
    echo Test results available in: target\surefire-reports\
    echo ExtentReports available in: target\extent-reports\
    echo Screenshots available in: target\screenshots\
    echo Error details available in: target\test-reports\
) else (
    echo No test results found!
)
echo.

echo [4/4] Opening reports...
if exist target\extent-reports (
    for /f %%i in ('dir /b target\extent-reports\*.html') do (
        echo Opening ExtentReport: target\extent-reports\%%i
        start target\extent-reports\%%i
    )
)
echo.
echo ========================================
echo    Test execution completed!
echo ========================================