# AutoJava Test Framework - Enhanced with Reporting

## 🚀 Tính năng mới

### 📸 Chụp ảnh lỗi tự động
- Khi test FAIL, tự động chụp screenshot
- Lưu tại: `target/screenshots/`
- Định dạng: `{testName}_FAIL_{timestamp}.png`

### 📝 Ghi chi tiết lỗi
- Tạo file text chi tiết lỗi tại: `target/test-reports/`
- Chứa: exception type, message, stack trace, test info
- Định dạng: `{testName}_ERROR_{timestamp}.txt`

### 📊 Báo cáo HTML đẹp
- ExtentReports với giao diện hiện đại
- Lưu tại: `target/extent-reports/`
- Chứa screenshots, chi tiết lỗi, thống kê

## 🛠️ Cách sử dụng

### Chạy test với báo cáo đầy đủ:
```bash
# Windows
run-tests-with-reports.bat

# Hoặc manual
mvn clean test
```

### Xem báo cáo:
- **ExtentReports**: Mở file HTML trong `target/extent-reports/`
- **Screenshots**: Xem trong `target/screenshots/`
- **Error Details**: Đọc file text trong `target/test-reports/`

## 📁 Cấu trúc thư mục reports

```
target/
├── screenshots/           # Ảnh chụp khi fail
│   └── testName_FAIL_timestamp.png
├── test-reports/          # Chi tiết lỗi dạng text
│   └── testName_ERROR_timestamp.txt
├── extent-reports/        # Báo cáo HTML đẹp
│   └── TestReport_timestamp.html
└── surefire-reports/      # Reports mặc định của TestNG
```

## 🔧 Cấu hình

### TestNG Listeners
Đã cấu hình trong `testng.xml`:
```xml
<listeners>
    <listener class-name="com.autojava.checkgenai.listeners.TestListener"/>
    <listener class-name="com.autojava.checkgenai.listeners.ExtentReportListener"/>
</listeners>
```

### Dependencies
Đã thêm trong `pom.xml`:
- `com.aventstack:extentreports:5.0.9`

## 📋 Ví dụ output khi test fail

### Console output:
```
❌ Test FAILED: verifyLoginPageIsDisplayed
📸 Screenshot saved: target/screenshots/verifyLoginPageIsDisplayed_FAIL_20240327_143052.png
📝 Error details saved: target/test-reports/verifyLoginPageIsDisplayed_ERROR_20240327_143052.txt
```

### Error details file:
```
=== TEST FAILURE REPORT ===
Test Class: com.autojava.checkgenai.tests.LoginTest
Test Method: verifyLoginPageIsDisplayed
Failure Time: Thu Mar 27 14:30:52 ICT 2026
Test Parameters: []

=== EXCEPTION DETAILS ===
Exception Type: org.openqa.selenium.NoSuchElementException
Exception Message: no such element: Unable to locate element

=== STACK TRACE ===
org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element
...
```

## 🎯 Lợi ích

1. **Debug nhanh**: Screenshot cho thấy trạng thái UI khi lỗi
2. **Chi tiết lỗi**: Stack trace và context đầy đủ
3. **Báo cáo đẹp**: ExtentReports dễ đọc và share
4. **Tự động**: Không cần can thiệp manual
5. **Lưu trữ**: Tất cả evidence được lưu file

## 🔍 Troubleshooting

### Screenshot không được tạo:
- Kiểm tra WebDriver có khởi tạo đúng không
- Đảm bảo thư mục `target/screenshots/` có quyền ghi

### ExtentReports không hiển thị:
- Kiểm tra file HTML có tồn tại trong `target/extent-reports/`
- Mở bằng browser hiện đại

### Test chạy chậm:
- Screenshots và reports làm chậm execution
- Có thể disable trong môi trường CI/CD nếu cần