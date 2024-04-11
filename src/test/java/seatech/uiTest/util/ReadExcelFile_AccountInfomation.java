package seatech.uiTest.util;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import seatech.common.config.Log;

public class ReadExcelFile_AccountInfomation {
    WebDriver driver;
    public ReadExcelFile_AccountInfomation(WebDriver driver){
        this.driver =driver;
    }
    static SoftAssert softAssert = new SoftAssert();
    @Step("Step: Expand account payment")
    public void expandAccountPayment(String action){
        //div[2]/div[1]/div[1]/span[1]/span[1]
        try{
            driver.findElement(By.xpath("//div[2]/div[1]/div[1]/span[1]/span[1]")).click();
            Log.info("Nhấn nút mở rộng Tài khoản thanh toán");
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút mở rộng Tài khoản thanh toán");
        }
    }
    @Step("Step: Expand account deposit")
    public void expandAccountDeposit(String action){
        try{
            driver.findElement(By.xpath("//div[2]/div[2]/div[1]/span[1]/span[1]")).click();
            Log.info("Nhấn nút mở rộng Tài khoản tiền gửi có kỳ hạn");
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút mở rộng Tài khoản tiền gửi có kỳ hạn");
        }
    }
    @Step("Step: Click choose account: {1}")
    public void clickChooseAccount(String action, String data){
        try{
            driver.findElement(By.linkText(data)).click();
            Log.info("Step: "+action+" | "+"Nhấn chọn tài khoản cần xem: "+data);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy tài khoản");
        }
    }
    @Step("Step: Click export PDF")
    public void clickExportPDF_accountPayment(String action){
        try{
            driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div[2]/a[1]")).click();
            Log.info("Step: "+action+" | "+"Nhấn tải file PDF");
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút tải file PDF");
        }
    }
    @Step("Step: Click export PDF")
    public void clickExportExcel_accountPayment(String action){
        try{
            driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div[2]/a[2]")).click();
            Log.info("Step: "+action+" | "+"Nhấn tải file Excel");
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút tải file Excel");
        }
    }
}
