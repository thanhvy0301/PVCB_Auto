package seatech.uiTest.ibv.test;


import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

import org.testng.ITestResult;
import org.testng.annotations.*;
import seatech.common.baseBrowser.Base;
import seatech.common.config.PropertiesFile;
import seatech.uiTest.util.ReadExcelFile_CKNhanh247;
import seatech.uiTest.util.ReadExcelFile_CKTongHT;
import seatech.uiTest.util.Log;
import seatech.uiTest.util.TestListener;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Listeners(TestListener.class)
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
    @Test( testName = "TC-1", priority = 1)
    @Step
    @Feature("Chuyển khoản trong hệ thống")
    public void Ck_Trong() throws InterruptedException {
        Log.info("Run TC-1");
        ReadExcelFile_CKTongHT readExcelFile= new ReadExcelFile_CKTongHT(driver);
        readExcelFile.startExecution("Sheet1");
    }
    @Test( testName = "TC-2", priority = 2)
    @Step
    @Feature("Chuyển khoản nhanh 247")
    public void Ck_Nhanh247() throws InterruptedException {
        Log.info("Run TC-1");
        ReadExcelFile_CKNhanh247 readExcelFile= new ReadExcelFile_CKNhanh247(driver);
        readExcelFile.startExecution("247");
    }




}