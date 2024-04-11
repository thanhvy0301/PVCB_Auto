package seatech.uiTest.pvcb.test;

import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import org.testng.ITestResult;
import org.testng.annotations.*;
import seatech.common.baseBrowser.Base;
import seatech.common.config.PropertiesFile;
import seatech.uiTest.util.Keywords;
import seatech.uiTest.util.ReadExcelFile_Napas247;
import seatech.common.config.Log;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

//@Listeners(TestListener.class)
public class ExecuteTest extends Base{
    Properties prop = new Properties();
    WebDriver driver ;
    @BeforeMethod //Hàm setup sẽ được khởi tạo sau mỗi lần thực thi 1 tc
    public void setup(){
        PropertiesFile .setPropertiesFile();
        Properties prop = new Properties();
        driver= init_driver(PropertiesFile.getPropValue("browser"));
        //driver.get(PropertiesFile.getPropValue("url"));//driver nào sẽ được sử dụng khi được lấy trong file config.properties với key là: browser
    }
    @Test( testName = "TC-1", priority = 1, enabled = false)
    @Step("Run file")
    @Severity(SeverityLevel.CRITICAL)
    public void Ck_Trong() throws InterruptedException {
        Log.info("Run TC-1");
        Keywords key= new Keywords(driver);
        key.ReadFile("Sheet1");
    }
    @Step("Run file")
    @Test( testName = "TC-2", priority = 2, enabled = false)
    public void Ck_Nhanh247() throws InterruptedException {
        Log.info("Run TC-1");
        ReadExcelFile_Napas247 napas247= new ReadExcelFile_Napas247(driver);
        napas247.startExecution("247");
    }
    @Step("Chuyển khoản ngoài hệ thống")
    @Test( testName = "TC-2", priority = 3)
    public void Ck_NgoaiHT() throws InterruptedException {
        Log.info("Run TC-1");
        Keywords key= new Keywords(driver);
        key.ReadFile("Sheet6");
    }
    @AfterMethod
    public void TakeScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                if (driver != null) { // Kiểm tra nếu driver không null
                    TakesScreenshot ts = (TakesScreenshot) driver;
                    File source = ts.getScreenshotAs(OutputType.FILE);
                    // Kiểm tra folder tồn tại. Nếu không, tạo mới folder
                    File theDir = new File("./Screenshots/");
                    if (!theDir.exists()) {
                        theDir.mkdirs();
                    }
                    File screenshotFile = new File("./Screenshots/" + result.getName() + ".png");
                    FileHandler.copy(source, screenshotFile);
                    System.out.println("Đã chụp màn hình: " + result.getName());
                    // Đính kèm ảnh chụp màn hình vào báo cáo Allure
                    Allure.addAttachment("Page screenshot", FileUtils.openInputStream(screenshotFile));
                    byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshotFile);
                    saveScreenshotPNG(screenshotBytes);
                }
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            } finally {
                if (driver != null) { // Đảm bảo rằng driver không null trước khi gọi quit()
                    driver.quit();
                }
            }
        }
        else {
            driver.quit();
        }
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(byte[] screenshotBytes) {
        return screenshotBytes;
    }
    @AfterTest
    public void AttachLogFile() {
//        try {
//            String projectPath = System.getProperty("user.dir");
//            String propertiesFilePathRoot = "/logs/app-properties.log";
//            File logFile = new File(projectPath + propertiesFilePathRoot);
//            // Kiểm tra và ghi log vào báo cáo Allure
//            if (logFile.exists()) {
//                byte[] logBytes = FileUtils.readFileToByteArray(logFile);
//                attachLogToAllure(logFile);
//            } else {
//                System.out.println("File log không tồn tại");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        driver.quit();
    }
    @Attachment(value = "Attach log file", type = "text/html")
    public byte[] attachLogToAllure(File file ) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException ignored) {
        }
        return null;
    }
}
