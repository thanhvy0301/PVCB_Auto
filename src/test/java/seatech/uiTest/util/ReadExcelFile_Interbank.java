package seatech.uiTest.util;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelFile_Interbank{
    WebDriver driver;
    public ReadExcelFile_Interbank(WebDriver driver){
        this.driver =driver;
    }
    static SoftAssert softAssert = new SoftAssert();
    static String accountNo_interBank;
    static String receiveAccount;
    static  String receiveName;
    static String stringAmount;
    static String accountNo_s2;
    static String amount_s2;
    static String fee;
    static String asTotal_s2;
    static String contentTran_s2;
    static String asTotalReceive;
    static String nameReceive_s2;
    static String bankReceive_s2;
    static String stringNameAmount_s2;

    public static String getStringNameAmount_s2() {
        return stringNameAmount_s2;
    }

    public static void setStringNameAmount_s2(String stringNameAmount_s2) {
        ReadExcelFile_Interbank.stringNameAmount_s2 = stringNameAmount_s2;
    }

    public static String getBankReceive_s2() {
        return bankReceive_s2;
    }

    public static void setBankReceive_s2(String bankReceive_s2) {
        ReadExcelFile_Interbank.bankReceive_s2 = bankReceive_s2;
    }

    public static String getAsTotal_s2() {
        return asTotal_s2;
    }

    public static void setAsTotal_s2(String asTotal_s2) {
        ReadExcelFile_Interbank.asTotal_s2 = asTotal_s2;
    }

    public static String getContentTran_s2() {
        return contentTran_s2;
    }

    public static void setContentTran_s2(String contentTran_s2) {
        ReadExcelFile_Interbank.contentTran_s2 = contentTran_s2;
    }

    public static String getAsTotalReceive() {
        return asTotalReceive;
    }

    public static void setAsTotalReceive(String asTotalReceive) {
        ReadExcelFile_Interbank.asTotalReceive = asTotalReceive;
    }

    public static String getNameReceive_s2() {
        return nameReceive_s2;
    }

    public static void setNameReceive_s2(String nameReceive_s2) {
        ReadExcelFile_Interbank.nameReceive_s2 = nameReceive_s2;
    }

    public static String getContentTran() {
        return contentTran;
    }

    public static void setContentTran(String contentTran) {
        ReadExcelFile_Interbank.contentTran = contentTran;
    }

    public static String getFee() {
        return fee;
    }

    public static void setFee(String fee) {
        ReadExcelFile_Interbank.fee = fee;
    }

    public static String getAmount_s2() {
        return amount_s2;
    }

    public static void setAmount_s2(String amount_s2) {
        ReadExcelFile_Interbank.amount_s2 = amount_s2;
    }

    public static String getAccountNo_s2() {
        return accountNo_s2;
    }

    public static void setAccountNo_s2(String accountNo_s2) {
        ReadExcelFile_Interbank.accountNo_s2 = accountNo_s2;
    }

    static String receiveAccount_s2;

    public static String getReceiveAccount_s2() {
        return receiveAccount_s2;
    }

    public static void setReceiveAccount_s2(String receiveAccount_s2) {
        ReadExcelFile_Interbank.receiveAccount_s2 = receiveAccount_s2;
    }

    public static String getStringAmount() {
        return stringAmount;
    }
    public static void setStringAmount(String stringAmount) {
        ReadExcelFile_Interbank.stringAmount = stringAmount;
    }
    public static String getAccountNo_interBank() {
        return accountNo_interBank;
    }
    public static void setAccountNo_interBank(String accountNo_interBank) {
        ReadExcelFile_Interbank.accountNo_interBank = accountNo_interBank;
    }

    public static String getBankReceive() {
        return bankReceive;
    }

    public static void setBankReceive(String bankReceive) {
        ReadExcelFile_Interbank.bankReceive = bankReceive;
    }

    static String bankReceive;

    public String getReceiveName() {
        return receiveName;
    }
    public void setReceiveName(String receiveName) {
        ReadExcelFile_Interbank.receiveName = receiveName;
    }

    static String amount;
    static String contentTran;

    public static String getAmount() {
        return amount;
    }

    public static void setAmount(String amount) {
        ReadExcelFile_Interbank.amount = amount;
    }

    public static String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        ReadExcelFile_Interbank.receiveAccount = receiveAccount;
    }

    public static String getContentTran_interBank() {
        return contentTran;
    }
    public  void setContentTran_interBank(String contentTran) {
        ReadExcelFile_Interbank.contentTran = contentTran;
    }
    @Step("Step: Select Account number")
    public  void selectAccountNo_interBank(String action, String data){
        try {
            Select boxAccountNo = new Select(driver.findElement(By.id("selectAccountNo")));
            boxAccountNo.selectByValue(data);
            setAccountNo_interBank(data);
            Log.info("Step: " + action + " | " + "Chọn tk trích nợ: " + getAccountNo_interBank());
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy ô chọn TK Trích nợ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /*@Step
    public void selectAccount_interBank(String action, String data) throws InterruptedException {
        Select slAccount = new Select(driver.findElement(By.id("selectAccountNo")));
        slAccount.selectByValue(data);
        setAccountNo_interBank(data);
        Log.info("Step: " + action + " | " + "Chọn tk trích nợ: " + data);
        Thread.sleep(2000);
    }*/
    @Step("Step: Enter receive account_interBank: {1}")
    public void enterReceiveAccount_interBank(String action, String data){
        try{
            WebElement txbReceiveNo =driver.findElement(By.id("beneficiaryAccount"));
            if(txbReceiveNo.isDisplayed()){
                txbReceiveNo.clear();
                txbReceiveNo.sendKeys(data);
                String a = txbReceiveNo.getAttribute("value");
                setReceiveAccount(a);
                Log.info("Set tài khoản thụ hưởng: "+getReceiveAccount());
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Nhập tài khoản thụ hưởng: "+data);
            }
        }catch (NoSuchElementException ignored){} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Enter receive account_interBank: {1}")
    public void enterReceiveName_interBank(String action, String data){
        try{
            WebElement txbReceiveName =driver.findElement(By.id("beneficiaryName"));
            if(txbReceiveName.isDisplayed()){
                txbReceiveName.clear();
                txbReceiveName.sendKeys(data);
                String a = txbReceiveName.getAttribute("value");
                setReceiveName(a);
                Log.info("Set tên người thụ hưởng: "+getReceiveName());
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Nhập tài khoản thụ hưởng: "+data);
            }
        }catch (NoSuchElementException ignored){} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Select bank receive: {1}")
    public void selectBankNo_interBank(String action, String data){
        if(data.isEmpty()){
            Log.info("Ngân hàng thụ hưởng rỗng");
        }
        else {
            try{
                Select boxAccountNo = new Select(driver.findElement(By.id("correspondentBank")));
                boxAccountNo.selectByVisibleText(data);
                setBankReceive(data);
                Log.info("Step: "+action+" | "+"Chọn ngân hàng thụ hưởng: "+data);
                Thread.sleep(2000);
            }catch (NoSuchElementException ignored){
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Step("Step: Enter amount_interBank: {1}")
    public void enterAmount_interBank(String action, String data){
        try{
            WebElement txbAmount =driver.findElement(By.id("amount"));
            if(txbAmount.isDisplayed()){
                txbAmount.clear();
                txbAmount.sendKeys(data);
                String a = txbAmount.getAttribute("value");
                setAmount(a);
                Log.info("Set số tiền: "+getAmount());
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Nhập số tiền: "+data);
                try {
                    WebElement textAmount = driver.findElement(By.id("amtUpcase"));
                    textAmount.click();
                    String txtAmount = textAmount.getText();
                    Thread.sleep(2000);
                    Log.info("Step: " + action + " | " + "Số tiền bằng chữ: " + txtAmount);
                    setStringAmount(txtAmount);
                } catch (NoSuchElementException e) {
                    Log.error("Không hiển thị số tiền bằng chữ");
                }
            }
        }catch (NoSuchElementException ignored){
            Log.info("Không tìm thấy ô nhập số tiền");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Enter content_interBank: {1}")
    public void enterContent_interBank(String action, String data){
        try{
            WebElement txbContent =driver.findElement(By.id("remark"));
            if(txbContent.isDisplayed()){
                txbContent.clear();
                txbContent.sendKeys(data);
                String a = txbContent.getAttribute("value");
                setContentTran_interBank(a);
                Log.info("Set số tiền: "+getContentTran_interBank());
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Nhập nội dung chuyển khoản: "+data);
            }
        }catch (NoSuchElementException ignored){
            Log.info("Không tìm thấy ô nhập nội dung");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step ("Step: Tick agree condition_interBank")
    public void tickAgreeCondition_interBank(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("chkApp")));
            if (!checkbox.isSelected()) {
                checkbox.click();
                Log.info("Step: " + action + " | " + "Đã tick vào đồng ý điều khoản (Ck Ngoài)");// Tick vào checkbox nếu chưa được tick
            } else {
                Log.info("Điều khoản đã được tick chọn trước đó (Ck Ngoài)");
            }
            Thread.sleep(1000);
        } catch (NoSuchElementException | InterruptedException ignored) {
        }
    }
    @Step("Step: Click link condition")
    public void clickLinkCondition_interBank(String action) throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Bản điều khoản & điều kiện Ngân hàng điện tử')]")).click();
        Log.info("Step: " + action + " | " + "Click vào link điều khoản - điều kiện");
        Thread.sleep(2000);
    }
    @Step("Step: Click button radio 'Có' to save template trans_interBank: {1}")
    public  void clickOkSaveTemplateTrans_interBank(String action, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.findElement(By.id("yesSave")).click();
            Log.info("Step: " + action + " | " + "Nhấn radio button 'Có' lưu mẫu giao dịch (Khác chủ)");
            try {
                Log.info("Hiển thị alert mẫu giao dịch đã tồn tại");
                driver.switchTo().alert().accept();
                Log.info("Nhấn Ok alert");
            } catch (NoAlertPresentException e) {
                Log.error("Khong hien thi alert");
            }
            WebElement dialogSaveTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[4]")));
            if (dialogSaveTemplate.isDisplayed()) {
                if (data.isEmpty()) {
                    driver.findElement(By.xpath("//button[@title='Close']")).click();
                    Thread.sleep(2000);
                } else {
                    driver.findElement(By.id("templateNameId")).sendKeys(data);
                    Log.info("Step: " + action + " | " + "Nhập tên giao dịch mẫu: " + data);
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//button[@type='button'][contains(.,'OK')]")).click();
                    Log.info("Step: " + action + " | " + "Nhấn Ok lưu mẫu");
                }
            }
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút 'Có' lưu giao dịch mẫu");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click to choose save receive account_interBank: {1}")
    public  void chooseSaveReceiveAccount_interBank(String action, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.findElement(By.xpath("//span[contains(@title,'Chọn Tài khoản thụ hưởng')]")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút chọn Người thụ hưởng đã lưu");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[5]")));
            driver.findElement(By.xpath("//table[1]/tbody[1]/tr[" + data + "]/td[1]/input[1]")).click();
            Log.info("Step: " + action + " | " + "Nhấn chọn  mẫu đã lưu: " + data);
            driver.findElement(By.id("submitInBeneficiary")).click();
            Log.info("Step: " + action + " | " + "Nhấn Tiếp tuc");
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Chọn Lưu người thụ hưởng");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click button Step1")
    public void clickBtnContinueS1_interBank(String action) {
        try {
            List<String> getDataList_interBank = new ArrayList<>();
            getDataList_interBank.add(getAccountNo_interBank());
            getDataList_interBank.add(getReceiveAccount());
            getDataList_interBank.add(getReceiveName());
            getDataList_interBank.add(getBankReceive());
            getDataList_interBank.add(getAmount());
            getDataList_interBank.add(getContentTran_interBank());
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Tiếp tục sang buớc 2");
            Thread.sleep(2000);
            try {
                driver.switchTo().alert().accept();
                Log.info("Alert message accepted.");
                }
            catch (NoAlertPresentException ignored){}
            for (int item = 0; item < getDataList_interBank.size(); item++) {
                String currentItem = getDataList_interBank.get(item);
                if (item == 0 && currentItem.isEmpty()) {
                    String txtErrAccountNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/font[1]")).getText();
                    Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrAccountNo);
                    break;
                } else if (item == 1 && currentItem.isEmpty()) {
                    String txtErrReceiveNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]/font[1]")).getText();
                    Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrReceiveNo);
                    break;
                } else if (item == 2 && currentItem.isEmpty()) {
                    String txtErrReceiveName = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[8]/td[2]/font[1]")).getText();
                    Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrReceiveName);
                    break;
                } else if (item == 3 && currentItem.isEmpty()) {
                    String txtErrBankReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[19]/td[2]/font[1]")).getText();
                    Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrBankReceive);
                    break;
                } else if (item == 4 && currentItem.isEmpty()) {
                    String txtErrAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[20]/td[2]/div[2]/font[1]")).getText();
                    Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrAmount);
                    break;
                } else if (item == 5 && currentItem.isEmpty()) {
                    String txtErrContent = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[30]/td[2]")).getText();
                    Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrContent);
                    break;
                    }
                }
            /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            try {
                Log.info("Hiển thị alert thông báo cutoff");
                driver.switchTo().alert().accept();
                Log.info("Nhấn Ok alert");
            } catch (NoAlertPresentException e) {
                Log.error("Khong hien thi alert");
            }
            try{
                for (int item = 0; item < getDataList_interBank.size(); item++) {
                    String currentItem = getDataList_interBank.get(item);
                    Log.info(currentItem);
                    if (item == 0 && currentItem.isEmpty()) {
                        String txtErrAccountNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrAccountNo); break;
                    }else if (item == 1 && currentItem.isEmpty()) {
                        String txtErrReceiveNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrReceiveNo); break;
                    } else if (item == 2 && currentItem.isEmpty()) {
                        String txtErrReceiveName = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[8]/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrReceiveName); break;
                    } else if (item == 3 && currentItem.isEmpty()) {
                        String txtErrBankReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[19]/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrBankReceive); break;
                    }
                    else if (item == 4 && currentItem.isEmpty()) {
                        String txtErrAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[20]/td[2]/div[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrAmount); break;
                    }else if (item == 5 && currentItem.isEmpty()) {
                        String txtErrContent = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[30]/td[2]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrContent); break;
                    }
                }
            }catch (NoSuchElementException ignored) {
                Log.error("Không tìm thấy:");
            }*/
        } catch (NoSuchElementException | InterruptedException e) {
            Log.error("Không tìm thấy nút Tiếp tục");
        }
    }
    @Step("Step: Verify data trans_Step 2")
    public void clickBtnContinueS2_interBank(String action){
        Log.info("Verify nội dung chuyển khoản ở b2");
        try {
            /*String txtAccountNo = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
            Log.info("Step: " + action + " | " + "Tài khoản trích nợ: " + txtAccountNo);
            softAssert.assertEquals(txtAccountNo, getAccountNo_interBank());
            setAccountNo_s2(txtAccountNo);
            Log.info("Verify tài khoản trích nợ: " + txtAccountNo + " | " + getAccountNo_s2());

            String txtReceiveNo = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Log.info("Step: " + action + " | " + "Tài khoản thụ hưởng: " + txtReceiveNo);
            softAssert.assertEquals(txtReceiveNo, getReceiveAccount());
            setReceiveAccount_s2(txtReceiveNo);
            Log.info("Verify tài khoản thụ hưởng: " + txtReceiveNo + " | " + getReceiveAccount_s2());

            String txtNameReceive = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[5]/td[2]")).getText();
            softAssert.assertEquals(txtNameReceive, getReceiveName());
            setNameReceive_s2(txtNameReceive);
            Log.info("Verify số tiền: " + txtNameReceive + " | " + getNameReceive_s2());

            String txtBankName = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]")).getText();
            softAssert.assertEquals(txtBankName, getBankReceive());
            setBankReceive_s2(txtBankName);
            Log.info("Verify số tiền: " + txtBankName + " | " + getBankReceive_s2());

            String txtAmount = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[7]/td[2]")).getText();
            softAssert.assertEquals(txtAmount, getAmount());
            setAmount_s2(txtAmount);
            Log.info("Verify số tiền: " + txtAmount + " | " + getAmount_s2());

            String asFee = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[8]/td[2]")).getText();
            setFee(asFee);
            Log.info("Phí giao dịch: " + asFee);

            String asTotal = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[9]/td[2]")).getText();
            setAsTotal_s2(asTotal);
            Log.info("Số tiền trích nợ: " + asTotal);

            String asStringAmount = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[10]/td[2]")).getText();
            softAssert.assertEquals(asStringAmount, getStringAmount());
            setStringNameAmount_s2(asStringAmount);
            Log.info("Verify số tiền bằng chữ: " + asStringAmount + " | " + getStringNameAmount_s2());

            String asTotalReceive = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[10]/td[2]")).getText();
            setAsTotalReceive(asTotalReceive);
            Log.info("Số tiền thực nhận: " + asTotalReceive);

            String asStringContent = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[11]/td[2]")).getText();
            softAssert.assertEquals(asStringContent, getContentTran_interBank());
            setContentTran_s2(asStringContent);
            Log.info("Verify nội dung chuyển khoản: " + asStringContent + " | " + getContentTran_s2());*/
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: " + action + " | " + "Click tiếp tục sang bước 3");
            Thread.sleep(3000);
        } catch (NoSuchElementException | InterruptedException e) {
            Log.error("Không tìm thấy Button Tiếp tục");
        }
    }
    @Step("Step: Click button to end trans")
    public  void clickButtonEndTran_interBank(String action){
        //ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        /*try {
            Log.info("Verify nội dung chuyển khoản ở bước 3");
            String asAccountNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
            Assert.assertEquals(asAccountNo, getAccountNo_s3());
            Log.info("Verify tài khoản trích nợ: " + asAccountNo + " | " + getAccountNo_s3());

            String asAccountReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Assert.assertEquals(asAccountReceive, getReceiveAccount_s3());
            Log.info("Verify tài khoản thụ hưởng: " + asAccountReceive + " | " + getReceiveAccount_s3());

            String asNameAccountReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[5]/td[2]")).getText();
            Assert.assertEquals(asNameAccountReceive, getNameReceiveAccount_s3());
            Log.info("Verify tên nguười thụ hưởng: " + asNameAccountReceive + " | " + getNameReceiveAccount_s3());

            String asAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[7]/td[2]")).getText();
            Assert.assertEquals(asAmount, getAmount_s3());
            Log.info("Verify số tiền: " + asAmount + " | " + getAmount_s3());

            String asFee = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[8]/td[2]")).getText();
            Assert.assertEquals(asFee, getFee());
            Log.info("Verify Phí giao dịch: " + asFee + " | " + getFee());

            String asTotal = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[9]/td[2]")).getText();
            Assert.assertEquals(asTotal, getAsTotal_s3());
            Log.info("Verify Số tiền trích nợ: " + asTotal + " | " + getAsTotal_s3());

            String asTotalReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[11]/td[2]")).getText();
            Assert.assertEquals(asTotalReceive, getAsTotalReceive());
            Log.info("Số tiền thực nhận: " + asTotalReceive + " | " + getAsTotalReceive());

            String asStringContent = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[12]/td[2]")).getText();
            Assert.assertEquals(asStringContent, getContentTran_s3());
            Log.info("Verify nội dung chuyển khoản: " + asStringContent + " | " + getContentTran_s3());
        } catch (NoSuchElementException e) {
        }*/
        try {
            driver.findElement(By.xpath("//input[@value='Kết thúc']")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Kết thúc ở bước 3");
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Kết thúc");
        }
    }
}
