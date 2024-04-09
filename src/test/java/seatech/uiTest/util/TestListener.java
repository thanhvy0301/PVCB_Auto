package seatech.uiTest.util;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import seatech.common.baseBrowser.Base;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener{
    Base base = new Base();
    @Override
    public void onFinish(ITestContext arg0) {
        attachLogFile(arg0)
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
    takeScreenshot(arg0);
    }
    // Hàm takeScreenshot sẽ được thực thi sau khi mỗi testcase kết thúc (Với điều kiện testcase đó fail)
    public void takeScreenshot(ITestResult result) {
        try {
            if (ITestResult.FAILURE == result.getStatus() && base.driver != null) {
                TakesScreenshot ts = (TakesScreenshot) base.driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                // Kiểm tra và tạo thư mục nếu cần
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                File screenshotFile = new File("./Screenshots/" + result.getName() + ".png");
                FileHandler.copy(source, screenshotFile);
                System.out.println("Đã chụp màn hình: " + result.getName());

                // Đính kèm ảnh chụp màn hình vào báo cáo Allure
                byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshotFile);
                attachScreenshotToAllure(screenshotBytes, result.getName());
            }
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        } finally {
            if (base.driver != null) {
                base.driver.quit();
            }
        }
    }
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] attachScreenshotToAllure(byte[] screenshotBytes, String screenshotName) {
        return screenshotBytes;
    }
    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
    public void attachLogFile() {
        try {
            String projectPath = System.getProperty("user.dir");
            String propertiesFilePathRoot = "app-properties.log";
            File logFile = new File(projectPath + "/" + propertiesFilePathRoot);

            // Kiểm tra và ghi log vào báo cáo Allure
            if (logFile.exists()) {
                byte[] logBytes = FileUtils.readFileToByteArray(logFile);
                attachLogToAllure(logBytes);
            } else {
                System.out.println("File log không tồn tại");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Attachment(value = "Attach log file", type = "text/plain")
    public byte[] attachLogToAllure(byte[] logBytes) {
        return logBytes;
    }
    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
}
