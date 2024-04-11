package seatech.uiTest.util;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import seatech.common.config.Log;

import java.text.Normalizer;
import java.time.Duration;
import java.util.*;
import java.util.regex.Pattern;

public class ReadExcelFile_InternalBank {

    WebDriver driver;
    public ReadExcelFile_InternalBank(WebDriver driver){
        this.driver =driver;
    }
    static SoftAssert softAssert = new SoftAssert();
    static String accountNo;
    static String receiveAccount;
    static String amount;
    static String contentTran;
    static String fee;
    static String accountNo_s3;
    static String receiveAccount_s3;
    static String amount_s3;
    static String contentTran_s3;
    static String asTotal_s3;
    static String asTotalReceive;
    static String nameReceiveAccount;
    static String nameReceiveAccount_s3;
    static String stringAmount;
    static String stringAmount_s3;
    public String getStringAmount_s3() {
        return stringAmount_s3;
    }

    public void setStringAmount_s3(String stringAmount_s3) {
        this.stringAmount_s3 = stringAmount_s3;
    }

    public String getStringAmount() {
        return stringAmount;
    }

    public void setStringAmount(String stringAmount) {
        this.stringAmount = stringAmount;
    }

    public String getNameReceiveAccount_s3() {
        return nameReceiveAccount_s3;
    }

    public void setNameReceiveAccount_s3(String nameReceiveAccount_s3) {
        this.nameReceiveAccount_s3 = nameReceiveAccount_s3;
    }

    public String getNameReceiveAccount() {
        return nameReceiveAccount;
    }

    public void setNameReceiveAccount(String nameReceiveAccount) {
        this.nameReceiveAccount = nameReceiveAccount;
    }

    public String getAsTotalReceive() {
        return asTotalReceive;
    }

    public void setAsTotalReceive(String asTotalReceive) {
        this.asTotalReceive = asTotalReceive;
    }

    public String getAsTotal_s3() {
        return asTotal_s3;
    }

    public void setAsTotal_s3(String asTotal_s3) {
        this.asTotal_s3 = asTotal_s3;
    }

    public  static String getAccountNo_s3() {
        return accountNo_s3;
    }

    public void setAccountNo_s3(String accountNo_s3) {
        this.accountNo_s3 = accountNo_s3;
    }

    public String getReceiveAccount_s3() {
        return receiveAccount_s3;
    }

    public void setReceiveAccount_s3(String receiveAccount_s3) {
        this.receiveAccount_s3 = receiveAccount_s3;
    }

    public String getAmount_s3() {
        return amount_s3;
    }

    public void setAmount_s3(String amount_s3) {
        this.amount_s3 = amount_s3;
    }

    public String getContentTran_s3() {
        return contentTran_s3;
    }

    public void setContentTran_s3(String contentTran_s3) {
        this.contentTran_s3 = contentTran_s3;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public  String getAccountNo() {
        return accountNo;
    }

    public void  setAccountNo(String accountNo) {
        ReadExcelFile_InternalBank.accountNo = accountNo;
    }

    public  String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public static String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public static String getContentTran() {
        return contentTran;
    }


    public  void setContentTran(String contentTran) {
        this.contentTran = contentTran;
    }
    @Step("Step: Enter Url: {0}")
    public void enterUrl(String action, String data){
        driver.get(data);
        Log.info("Step: " + action + " | " + "Khởi tạo đường dẫn: " + data);
    }
    @Step("Step: Enter Username")
    public void enterUserName(String action, String data){
        try {
            driver.findElement(By.id("t_userName")).sendKeys(data);
            Log.info("Step: " + action + " | " + "Nhập username " + data);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy username");
        }
    }
    @Step("Step: Enter Password")
    public void enterPassword(String action, String data) throws InterruptedException {
        try {
            driver.findElement(By.id("t_password")).sendKeys(data);
            Log.info("Step: " + action + " | " + "Nhập username " + data);
            Thread.sleep(10000);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy password");
        }
    }
    @Step("Step: Click button to Login")
    public void btnLogin(String action){
        try {
            driver.findElement(By.xpath("//button[contains(.,'Đăng nhập')]")).click();
            Log.info("Step: " + action + " | " + "Nhấn vào button đăng nhập");
            try {
                driver.findElement(By.xpath("//input[contains(@name,'button')]")).click();
                Log.info("Nhấn vào button đồng ý");
            } catch (NoSuchElementException e) {
                Log.error("Không hiển thị trang session");
            }
        }catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Đăng nhập");
        }
    }
    @Step("Step: Click verify OTP Later")
    public void clickVerifyOTPLater(String action) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement displayHome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[2]/div[2]/div[2]/span[1]")));
        Assert.assertTrue(displayHome.isDisplayed());
        driver.findElement(By.xpath("//button[@class='cancel awesome'][contains(.,'Kích hoạt sau')]")).click();
        Log.info("Step: " + action + " | " + "Nhấn vào button kích hoạt smart OTP sau");
        Thread.sleep(3000);
    }
    @Step("Step: Navigate to Menu")
    public  void navigateMenu(String action, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (action.equalsIgnoreCase("navigateMenu")) {
            String[] menuItems = data.split(",\\s*"); // Split chuỗi dựa trên dấu phẩy và khoảng trắng sau dấu phẩy
            ArrayList<String> menuList = new ArrayList<>();
            for (String menuItem : menuItems) {
                menuList.add(menuItem.trim()); // Thêm mục menu vào ArrayList và loại bỏ khoảng trắng ở hai đầu
            }
            if (menuItems.length < 2) {
                String firstMenuItem = menuItems[0].trim();
                // Tìm và click vào phần tử chỉ định trên trang web (ở đây dùng xpath làm ví dụ)
                try {
                    WebElement menuItemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#'][contains(.,'" + firstMenuItem + "')]")));
                    menuItemElement.click();
                    Log.info("Click vào menu cấp 1: " + menuItemElement);
                } catch (NoSuchElementException e) {
                    System.out.println("Không tìm thấy phần tử menu: " + e.getMessage());
                }
            }
            if (menuItems.length >= 2) {
                // Lấy phần tử đầu tiên từ mảng menuItems để click vào phần tử chỉ định trên trang web
                String firstMenuItem = menuItems[0].trim();
                // Tìm và click vào phần tử chỉ định trên trang web (ở đây dùng xpath làm ví dụ)
                try {
                    WebElement menuItemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#'][contains(.,'" + firstMenuItem + "')]")));
                    menuItemElement.click();
                    Log.info("Click vào menu cấp 1: " + menuItemElement);
                } catch (NoSuchElementException e) {
                    System.out.println("Không tìm thấy phần tử menu cấp 1: " + e.getMessage());
                }
                // Lấy phần tử thứ hai từ mảng menuItems để click vào phần tử chỉ định trên trang web
                String secondMenuItem = menuItems[1].trim();
                try {
                    WebElement menuItemElementLv2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'" + secondMenuItem + "')]")));
                    menuItemElementLv2.click();
                    Log.info("Click vào menu cấp 2: " + menuItemElementLv2);
                } catch (NoSuchElementException e) {
                    System.out.println("Không tìm thấy phần tử menu cấp 2 : " + e.getMessage());
                }
                if (menuItems.length >= 3) {
                    String thirdMenuItem = menuItems[2].trim();
                    try {
                        WebElement menuItemElementLv3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(thirdMenuItem)));
                        menuItemElementLv3.click();
                        Log.info("Click vào menu cấp 3: " + menuItemElementLv3);
                    } catch (NoSuchElementException e) {
                        System.out.println("Không tìm thấy phần tử menu cấp 3 : " + e.getMessage());
                    }
                }
            }
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("tranFrame")));
            Log.info("Chuyển sang frame");
        }
    }
    @Step("Step: Select tab Trans")
    public  void selectTabTrans(String action, String data){
        try {
            WebElement typeTran = driver.findElement(By.xpath("//label[contains(text(),'" + data + "')]"));
            typeTran.click();
            Log.info("Step: " + action + " | " + "Chọn loại ck: " + typeTran.getText());
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy tab loại tk");
        }
    }
    @Step("Step: Select Account number")
    public  void selAccountNo(String action, String data){
        try {
            ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
            Select boxAccountNo = new Select(driver.findElement(By.id("selectAccountNo")));
            boxAccountNo.selectByValue(data);
            setAccountNo(data);
            Log.info("Step: " + action + " | " + "Chọn tk trích nợ: " + data);
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy ô chọn TK Trích nợ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //=================================CÙNG CHỦ====================================
    @Step("Step: Select Receive account_SA")
    public void selectReceiveAcc_SA(String action, String data){
        try {
            ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
            WebElement txbReceiveAccount = driver.findElement(By.id("receiveAccount"));
            txbReceiveAccount.sendKeys(data);
            if (txbReceiveAccount.isDisplayed()) {
                Select boxReceiveAccount = new Select(driver.findElement(By.id("receiveAccount")));
                boxReceiveAccount.selectByValue(data);
                setReceiveAccount(data);
                Log.info("Step: " + action + " | " + "Chọn tk nhận: " + data);
                Thread.sleep(2000);
            }
        } catch (NoSuchElementException ignored) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Select amount_SA")
    public  void enterAmount_SameAccount(String action, String data){
        try {
            WebElement txbAmount = driver.findElement(By.id("amount"));
            ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
            if (txbAmount.isDisplayed()) {
                txbAmount.clear();
                txbAmount.sendKeys(data);
                String gettextAmount = txbAmount.getAttribute("value");
                setAmount(gettextAmount);
                Thread.sleep(2000);
                Log.info("Step: " + action + " | " + "Nhập số tiền: " + data);
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
        } catch (NoSuchElementException e) {
            Log.error("Không hiển thị ô nhập số tiền");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Select content_SA")
    public void enterContent_SA(String action, String data){
        ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
            WebElement txbContent = driver.findElement(By.id("_textarea"));
            if (txbContent.isDisplayed()) {
                txbContent.clear();
                txbContent.sendKeys(data);
                String gettextContent = txbContent.getAttribute("value");
                setContentTran(gettextContent);
                Thread.sleep(1000);
                Log.info("Step: " + action + " | " + "Nhập nội dung: " + data);
            }
        } catch (NoSuchElementException ignored) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Tick agree condition")
    public void tickAgreeCondition(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("chkApp1")));
            if (!checkbox.isSelected()) {
                checkbox.click();
                Log.info("Step: " + action + " | " + "Đã tick vào đồng ý điều khoản");// Tick vào checkbox nếu chưa được tick
            } else {
                Log.info("Điều khoản đã được tick chọn trước đó");
            }
            Thread.sleep(1000);
        } catch (NoSuchElementException e) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click button Step1")
    public void clickBtnContinueS1_SameAccount(String action) {
        try {
            List<String> getDataList = new ArrayList<>();
            getDataList.add(getAccountNo());
            getDataList.add(getReceiveAccount());
            getDataList.add(getAmount());
            getDataList.add(getContentTran());
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Tiếp tục sang buớc 2");
            try{
                for (int item = 0; item < getDataList.size(); item++) {
                    String currentItem = getDataList.get(item);
                    if (item == 0 && currentItem.isEmpty()) {
                        String txtErrAccountNo = driver.findElement(By.xpath("//tbody/tr[@id='errorSourceAccounttNull']/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrAccountNo); break;
                    } else if (item == 1 && currentItem.isEmpty()) {
                        String txtErrReceiveNo = driver.findElement(By.xpath("//tbody/tr[@id='errorSourceAccounttNull']/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrReceiveNo); break;
                    } else if (item == 2 && currentItem.isEmpty()) {
                        String txtErrAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[3]/tbody[1]/tr[3]/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrAmount); break;
                    } else if (item == 3 && currentItem.isEmpty()) {
                        String txtErrContent = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[3]/tbody[1]/tr[7]/td[2]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrContent); break;
                    }
                }
            }catch (NoSuchElementException ignored) {}
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Tiếp tục");
        }
    }
    @Step("Step: Verify data trans_Step 2")
    public void clickBtnContinueS2_SameAccount(String action){
        Log.info("Verify nội dung chuyển khoản ở b2");
        ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
            String txtAccountNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[2]")).getText();
            Log.info("Step: " + action + " | " + "Tài khoản trích nợ: " + txtAccountNo);
            softAssert.assertEquals(txtAccountNo, getAccountNo());
            setAccountNo_s3(txtAccountNo);
            Log.info("Verify tài khoản trích nợ: " + txtAccountNo + " | " + getAccountNo());

            String txtReceiveNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
            Log.info("Step: " + action + " | " + "Tài khoản thụ hưởng: " + txtReceiveNo);
            Assert.assertEquals(txtReceiveNo, getReceiveAccount());
            setReceiveAccount_s3(txtReceiveNo);
            Log.info("Verify tài khoản thụ hưởng: " + txtReceiveNo + " | " + getReceiveAccount());

            String txtAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Assert.assertEquals(txtAmount, getAmount());
            setAmount_s3(txtAmount);
            Log.info("Verify số tiền: " + txtAmount + " | " + getAmount());

            String asFee = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[5]/td[2]")).getText();
            setFee(asFee);
            Log.info("Phí giao dịch: " + asFee);

            String asTotal = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]")).getText();
            setAsTotal_s3(asTotal);
            Log.info("Số tiền trích nợ: " + asTotal);

            String asStringAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[7]/td[2]")).getText();
            Assert.assertEquals(asStringAmount, getStringAmount());
            setStringAmount(asStringAmount);
            Log.info("Verify số tiền bằng chữ: " + asStringAmount + " | " + getStringAmount());

            String asTotalReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[8]/td[2]")).getText();
            setAsTotalReceive(asTotalReceive);
            Log.info("Số tiền thực nhan: " + asTotalReceive);

            String asStringContent = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[9]/td[2]")).getText();
            Assert.assertEquals(asStringContent, getContentTran());
            setContentTran_s3(asStringContent);
            Log.info("Verify nội dung chuyển khoản: " + asStringContent + " | " + getContentTran());

            driver.findElement(By.id("submit1")).click();
            Log.info("Step: " + action + " | " + "Click tiếp tục sang bước 3");
            Thread.sleep(3000);
        } catch (NoSuchElementException | InterruptedException e) {
            Log.error("Không tìm thấy Button Tiếp tục");
        }
    }
    @Step("Step:Click button end Trans_SameAccount ")
    public void clickButtonEndTran_SameAccount(String action){
        Log.info("Verify nội dung chuyển khoản ở b3");
        try {
            String txtIdTran = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
            Log.info("Step: " + action + " | " + "Số hiệu giao dịch: " + txtIdTran);

            String txtAccountNo_s3 = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
            Assert.assertEquals(txtAccountNo_s3, getAccountNo_s3());
            Log.info("Verify tài khoản trích nợ: " + txtAccountNo_s3 + " | " + getAccountNo_s3());

            String txtReceiveNo_s3 = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Log.info(getReceiveAccount_s3());
            Assert.assertEquals(txtReceiveNo_s3, getReceiveAccount_s3());

            Log.info("Verify tài khoản thụ hưởng: " + txtReceiveNo_s3 + " | " + getReceiveAccount_s3());

            String txtAmount_s3 = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[5]/td[2]")).getText();
            Assert.assertEquals(txtAmount_s3, getAmount_s3());
            Log.info("Verify số tiền: " + txtAmount_s3 + " | " + getAmount());

            String asFee = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]")).getText();
            Assert.assertEquals(asFee, getFee());
            Log.info("Verify phí giao dịch: " + asFee + " | " + getFee());

            String asTotal = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[7]/td[2]")).getText();
            Assert.assertEquals(asTotal, getAsTotal_s3());
            Log.info("Verify số tiền trích nợ: " + asTotalReceive + " | " + getAsTotal_s3());

            String asStringAmount = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[8]/td[2]")).getText();
            Assert.assertEquals(asStringAmount, getStringAmount_s3());
            Log.info("Verify số tiền bằng chữ: " + asStringAmount + " | " + getStringAmount_s3());

            String asTotalReceive = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[9]/td[2]")).getText();
            Assert.assertEquals(asTotalReceive, getAsTotalReceive());
            Log.info("Verify số tiền thực nhan: " + asTotalReceive + " | " + getAsTotalReceive());

            String asStringContent = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[10]/td[2]")).getText();
            Assert.assertEquals(asStringContent, getContentTran_s3());
            Log.info("Verify nội dung chuyển khoản: " + asStringContent + " | " + getContentTran_s3());

            driver.findElement(By.xpath("//input[contains(@class,'button_bg awesome')]")).click();
            Log.info("Step: " + action + " | " + "Click kết thúc giao dịch");
            Thread.sleep(3000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy Button Kết thúc");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: End Tran _ Out Frame")
    public void clickButtonEndTran_OF_SameAccount(String action) {
        Log.info("Verify nội dung chuyển khoản ở b3");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
            String txtIdTran = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
            Log.info("Step: " + action + " | " + "Số hiệu giao dịch: " + txtIdTran);

            String txtAccountNo_s3 = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
            Assert.assertEquals(txtAccountNo_s3, getAccountNo_s3());
            Log.info("Verify tài khoản trích nợ: " + txtAccountNo_s3 + " | " + getAccountNo_s3());

            String txtReceiveNo_s3 = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Assert.assertEquals(txtReceiveNo_s3, getReceiveAccount_s3());
            Log.info("Verify tài khoản thụ hưởng: " + txtReceiveNo_s3 + " | " + getReceiveAccount_s3());

            String txtAmount_s3 = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[5]/td[2]")).getText();
            Assert.assertEquals(txtAmount_s3, getAmount_s3());
            Log.info("Verify số tiền: " + txtAmount_s3 + " | " + getAmount());

            String asFee = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]")).getText();
            Assert.assertEquals(asFee, getFee());
            Log.info("Verify phí giao dịch: " + asFee + " | " + getFee());

            String asTotal = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[7]/td[2]")).getText();
            Assert.assertEquals(asTotal, getAsTotal_s3());
            Log.info("Verify số tiền trích nợ: " + asTotalReceive + " | " + getAsTotal_s3());

            String asStringAmount = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[8]/td[2]")).getText();
            Assert.assertEquals(asStringAmount, getStringAmount_s3());
            Log.info("Verify số tiền bằng chữ: " + asStringAmount + " | " + getStringAmount_s3());

            String asTotalReceive = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[9]/td[2]")).getText();
            Assert.assertEquals(asTotalReceive, getAsTotalReceive());
            Log.info("Verify số tiền thực nhan: " + asTotalReceive + " | " + getAsTotalReceive());

            String asStringContent = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[10]/td[2]")).getText();
            Assert.assertEquals(asStringContent, getContentTran_s3());
            Log.info("Verify nội dung chuyển khoản: " + asStringContent + " | " + getContentTran_s3());

            WebElement displayTranScreen = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='noidung']"))));
            Assert.assertTrue(displayTranScreen.isDisplayed());
            driver.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy Button Kết thúc");
        }
    }
    @Step("Step: Click link condition")
    public void clickLinkCondition(String action) throws InterruptedException {
        driver.findElement(By.xpath("//tbody/tr[1]/th[1]/div[1]/label[1]/a[1]")).click();
        Log.info("Step: " + action + " | " + "Click vào link điều khoản - điều kiện");
        Thread.sleep(3000);
    }
    @Step ("Step: Click button logout")
    public void clickAcceptLogout(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//a[contains(@onclick,'return lout();')]")).click();
            Log.info("Step: " + action + " | " + "Nhấn button Logout");
            driver.switchTo().alert().accept();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Đăng nhập tài khoản khác")))).click();
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy button Logout");
        }
    }
    @Step("Step: Click button save trans")
    public  void saveTrans_SameAccount(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.findElement(By.id("save1")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Lưu nháp");
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//a[@class='al-close al-ok-btn'][contains(.,'OK')]")).click();
            Log.info("Step: " + action + " | " + "Nhấn Ok alert lưu nháp thành công");
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("tranFrame")));
            Log.info("Chuyển sang frame");
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Lưu nháp");
        }
    }
    @Step ("Step: Click button reset")
    public void clickBtnReset_SameAccount(String action){
        try {
            driver.findElement(By.id("reset1")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Thiết lập lại");
            Thread.sleep(2000);
        } catch (NoSuchElementException | InterruptedException e) {
            Log.error("Không tìm thấy nút Thiết lập lại");
        }
    }
    @Step("Click button return")
    public void clickBtnReturn(String action){
        try {
            driver.findElement(By.id("return1")).click();
            Thread.sleep(3000);
            Log.info("Step: " + action + " | " + "Nhấn nút Trở về bước Nhập thông tin");
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Trở về");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //===================================KHÁC CHỦ=======================
    @Step ("Step: Enter receive account")
    public void enterReceiveAccount_DiffAccount(String action, String data){
//        ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
            WebElement txbReceive = driver.findElement(By.id("receiveAccount2"));
            txbReceive.clear();
            txbReceive.sendKeys(data);
            String txtRec = txbReceive.getAttribute("value");
            setReceiveAccount(txtRec);
            Log.info("Step: " + action + " | " + "Nhập tài khoản thụ hưởng (Khác chủ): " + txtRec);
            Thread.sleep(2000);
        } catch (NoSuchElementException ignored) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement txtNameRe = driver.findElement(By.xpath("//table[4]/tbody[1]/tr[2]/td[2]"));
        txtNameRe.click();
        String nameRec = txtNameRe.getText();
        setNameReceiveAccount(nameRec);
        Log.info("Step: " + action + " | " + "Tên tài khoản thụ hưởng: " + nameRec);
        String normalized = Normalizer.normalize(nameRec, Normalizer.Form.NFD);
        // Sử dụng biểu thức chính quy để loại bỏ các dấu thanh
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String n = pattern.matcher(normalized).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
        setNameReceiveAccount(n);
        Log.info("Chuyển đổi tên người thụ hưởng thành không dấu: " + n);
    }
    @Step ("Step: enter amount: {0} - {1}")
    public  void enterAmount_DiffAccount(String action, String data){
        ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
            WebElement txbAmount = driver.findElement(By.id("amount2"));
            txbAmount.clear();
            txbAmount.sendKeys(data);
            String txtRec = txbAmount.getAttribute("value");
            setAmount(txtRec);
            Thread.sleep(2000);
            Log.info("Step: " + action + " | " + "Nhập số tiền (Khác chủ): " + txtRec);
            try {
                WebElement textAmount = driver.findElement(By.id("amtUpcase2"));
                textAmount.click();
                Thread.sleep(2000);
                Log.info("Step: " + action + " | " + "Số tiền bằng chữ: " + textAmount.getText());
            } catch (NoSuchElementException e) {
                Log.error("Không hiển thị số tiền bằng chữ");
            }
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy ô nhập số tiền");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Enter content trans_Diff Account: {0} - {1}")
    public void enterContentTrans_DiffAccount(String action, String data){
        ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
            WebElement txbContent_Diff = driver.findElement(By.id("textarea2"));
            txbContent_Diff.clear();
            txbContent_Diff.sendKeys(data);
            String txtCont = txbContent_Diff.getAttribute("value");
            setContentTran(txtCont);
            Thread.sleep(2000);
            Log.info("Step: " + action + " | " + "Nhập nội dung ck (Khác chủ): " + txtCont);
        } catch (NoSuchElementException ignored) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step ("Step: Tick agree condition")
    public void tickAgreeCondition_DiffAccount(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("chkApp")));
            if (!checkbox.isSelected()) {
                checkbox.click();
                Log.info("Step: " + action + " | " + "Đã tick vào đồng ý điều khoản (Khác chủ)");// Tick vào checkbox nếu chưa được tick
            } else {
                Log.info("Điều khoản đã được tick chọn trước đó (Khác chủ)");
            }
            Thread.sleep(1000);
        } catch (NoSuchElementException | InterruptedException ignored) {
        }
    }
    @Step("Step: Click button continue to step 2_Diff Account")
    public  void clickBtnContinueS1_DiffAccount(String action){
        //ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
            List<String>getDataList_DiffAcc = new ArrayList<>();
            getDataList_DiffAcc.add(getAccountNo());
            getDataList_DiffAcc.add(getReceiveAccount());
            getDataList_DiffAcc.add(getAmount());
            getDataList_DiffAcc.add(getContentTran());
            driver.findElement(By.id("submit2")).click();
            Log.info("Step: "+action+" | "+"Nhấn tiếp tục để sang bước 2 (Khác chủ)");
            Thread.sleep(2000);
            try{
                for (int item = 0; item < getDataList_DiffAcc.size(); item++) {
                    String currentItem = getDataList_DiffAcc.get(item);
                    if (item == 0 && currentItem.isEmpty()) {
                        String txtErrAccountNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[5]/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrAccountNo); break;
                    } else if (item == 1 && currentItem.isEmpty()) {
                        String txtErrReceiveNo = driver.findElement(By.xpath("//table[4]/tbody[1]/tr[1]/td[2]/span[1]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrReceiveNo); break;
                    } else if (item == 2 && currentItem.isEmpty()) {
                        String txtErrAmount = driver.findElement(By.xpath("//table[4]/tbody[1]/tr[4]/td[2]/font[1]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrAmount); break;
                    } else if (item == 3 && currentItem.isEmpty()) {
                        String txtErrContent = driver.findElement(By.xpath("//table[4]/tbody[1]/tr[15]/td[2]")).getText();
                        Log.info("Step: "+action+" | "+"Hiển thị thông báo: "+txtErrContent); break;
                    }
                }
            }catch (NoSuchElementException ignored) {}
        }
        catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút Tiếp tục ở bước 1 (Khác chu )");
        }
    }
    @Step("Test: Click button continue to step 3")
    public void clickBtnContinueS2_DiffAccount(String action){
        try{
            String asAccountNo = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[2]")).getText();
            softAssert.assertEquals(asAccountNo,getAccountNo());
            setAccountNo_s3(asAccountNo);
            Log.info("Verify tài khoản trích nợ: " + asAccountNo +" | "+ getAccountNo());

            String asAccountReceive= driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
            softAssert.assertEquals(asAccountReceive,getReceiveAccount());
            setReceiveAccount_s3(asAccountReceive);
            Log.info("Verify tài khoản thụ hưởng: " + asAccountReceive + " | "+ getReceiveAccount());

            String asNameAccountReceive= driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Assert.assertEquals(asNameAccountReceive, getNameReceiveAccount());
            setNameReceiveAccount_s3(asNameAccountReceive);
            Log.info("Verify tên nguười thụ hưởng: " + asNameAccountReceive + " | "+ getNameReceiveAccount());

            String asAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]")).getText();
            Assert.assertEquals(asAmount, getAmount());
            setAmount_s3(asAmount);
            Log.info("Verify số tiền: " + asAmount + " | "+ getAmount());

            String asFee = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[7]/td[2]")).getText();
            setFee(asFee);
            Log.info("Phí giao dịch: "+asFee);

            String asTotal = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[8]/td[2]")).getText();
            setAsTotal_s3(asTotal);
            Log.info("Số tiền trích nợ: "+asTotal);

            String asStringAmount = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[9]/td[2]")).getText();
            setContentTran_s3(asStringAmount);
            Log.info("Số tiền bằng chữ: "+asStringAmount);

            String asTotalReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[10]/td[2]")).getText();
            setAsTotalReceive(asTotalReceive);
            Log.info("Số tiền thực nhận: "+asTotalReceive);

            String asStringContent = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[11]/td[2]")).getText();
            Assert.assertEquals(asStringContent,getContentTran());
            setContentTran_s3(asStringContent);
            Log.info("Verify nội dung chuyển khoản: " + asStringContent + " | "+ getContentTran());
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: "+action+" | "+"Nhấn tiếp tục sang bước 3");
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Tiếp tục");
        }
    }
    @Step("Step: Click button to end trans")
    public  void clickButtonEndTran_DiffAccount(String action){
        //ReadExcelFile_InternalBank instance = new ReadExcelFile_InternalBank(driver);
        try {
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
        }
        try {
            driver.findElement(By.xpath("//input[@value='Kết thúc']")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Kết thúc ở bước 3");
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Kết thúc");
        }
    }
    @Step("Step: Click to reset_DiffAccount")
    public  void clickBtnReset_DiffAccount(String action){
        try {
            driver.findElement(By.id("reset2")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Thiết lập lại (Khác chủ)");
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Thiết lập lại (Khác chủ)");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click choose tran saved")
    public  void clickChooseTransSaved(String action, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.findElement(By.xpath("//font[@color='blue'][contains(.,'Chọn từ giao dịch mẫu')]")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút chọn Từ giao dịch mẫu (Khác chủ)");
            try {
                WebElement dialogTransSaved = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//table[1]/tbody[1]/tr[" + data + "]/td[1]/input[1]")));
                dialogTransSaved.click();
                Log.info("Step: " + action + " | " + "Tick chọn giao dịch mẫu (Khác chủ)");
                driver.findElement(By.id("submitTranTem")).click();
                Log.info("Step: " + action + " | " + "Nhấn nút tiếp tục ở dialog lưu mẫu");
                Thread.sleep(3000);
            } catch (NoSuchElementException e) {
                Log.error("Không tìm thấy dialog lưu nháp");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Chọn từ giao dịch mẫu");
        }
    }
    @Step("Step: Click button radio to save template trans")
    public  void clickOkSaveTemplateTrans(String action, String data){
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
            WebElement dialogSaveTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[5]")));
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
    @Step("Step: Click to exit dialog_DiffAccount")
    public  void closeSaveTransDialog_DiffAccount(String action){
        try {
            driver.findElement(By.id("noSave")).click();
            Log.info("Step: " + action + " | " + "Nhấn radio button 'Không' lưu mẫu giao dịch (Khác chủ)");
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút 'Không' lưu giao dịch mẫu");
        }
    }
    @Step("Step: Click end tran_Out Frame_DiffAccount")
    public  void clickButtonEndTran_OF_DiffAccount(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Log.info("Verify nội dung chuyển khoản ở bước 3");
            String asAccountNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")).getText();
            Assert.assertEquals(asAccountNo, getAccountNo_s3());
            Log.info("Verify tài khoản trích nợ: " + asAccountNo + " | " + getAccountNo_s3());

            String asAccountReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
            Assert.assertEquals(asAccountReceive, getReceiveAccount_s3());
            Log.info("Verify tài khoản thụ hưởng: " + asAccountReceive + " | " + getReceiveAccount_s3());

            String asNameAccountReceive = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[5]/td[2]")).getText();
            Assert.assertEquals(asNameAccountReceive, getNameReceiveAccount_s3());
            Log.info("Verify tên tài khoản thụ hưởng: " + asNameAccountReceive + " | " + getNameReceiveAccount_s3());

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

            driver.findElement(By.xpath("//input[@value='Kết thúc']")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Kết thúc ở bước 3");
            WebElement displayTranScreen = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='noidung']"))));
            Assert.assertTrue(displayTranScreen.isDisplayed());
            driver.switchTo().defaultContent();
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Kết thúc");
        }
    }
    @Step("Step: Click save trans_DiffAccount")
    public  void saveTrans_DiffAccount(String action){
        try {
            driver.findElement(By.id("save2")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Lưu nháp (Khác chủ)");
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//a[@class='al-close al-ok-btn'][contains(.,'OK')]")).click();
            Log.info("Step: " + action + " | " + "Nhấn Ok alert lưu mẫu thành công (Khác chủ)");
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy element (Khác chủ)");
        }
    }
    @Step("Step: Click to save receive account")
    public  void clickSaveReceiveAccount(String action){
        try {
            driver.findElement(By.id("yes")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút chọn Lưu người thụ hưởng");
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Chọn Lưu người thụ hưởng");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click button radio don't save receive account")
    public  void clickNoSaveReceiveAccount(String action){
        try {
            driver.findElement(By.id("no")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút 'Không' Lưu người thụ hưởng");
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút 'Không' Lưu người thụ hưởng");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click to choose save receive aacount")
    public  void chooseSaveReceiveAccount(String action, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.findElement(By.xpath("//span[contains(@title,'Chọn Tài khoản thụ hưởng')]")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút chọn Người thụ hưởng đã lưu");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[7]")));
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
    @Step("Step: Click to query trans")
    public  void clickBtnQueryTrans(String action){
        try {
            driver.findElement(By.xpath("//input[@value='Truy vấn']")).click();
            Log.info("Step: " + action + " | " + "Nhấn nút Truy vấn");
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy nút Truy vấn");
        }
    }
    @Step ("Step: Select type trans")
    public  void selectTransType(String action, String data){
        try {
            Select boxAccountNo = new Select(driver.findElement(By.id("tansferType")));
            switch (data) {
                case "Chuyển khoản trong hệ thống":
                    boxAccountNo.selectByValue("1");
                    Log.info("Step: " + action + " | " + "Chọn loại giao dịch: " + data);
                    break;
                case "Chuyển khoản ngoài hệ thống":
                    boxAccountNo.selectByValue("2");
                    Log.info("Step: " + action + " | " + "Chọn loại giao dịch: " + data);
                    break;
                case "Chuyển khoản định kỳ":
                    boxAccountNo.selectByValue("3");
                    Log.info("Step: " + action + " | " + "Chọn loại giao dịch: " + data);
                    break;
                case "Chuyển khoản nhanh 24/7":
                    boxAccountNo.selectByValue("6");
                    Log.info("Step: " + action + " | " + "Chọn loại giao dịch: " + data);
                    break;
                case "Bán Ngoại Tệ cho PVcomBank":
                    boxAccountNo.selectByValue("8");
                    Log.info("Step: " + action + " | " + "Chọn loại giao dịch: " + data);
                    break;
            }
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy loại giao dịch");
        }
    }
    @Step("Step: Tick choose transaction")
    public  void tickTransaction(String action, String data){
        try {
            String[] itemTrans = data.split(",\\s*"); // Split chuỗi dựa trên dấu phẩy và khoảng trắng sau dấu phẩy
            ArrayList<String> transList = new ArrayList<>();
            for (String item : itemTrans) {
                transList.add(item.trim()); // Thêm mục menu vào ArrayList và loại bỏ khoảng trắng ở hai đầu
                driver.findElement(By.xpath("//tbody[1]/tr[" + item + "]/td[1]/input[1]")).click();
            }
            Log.info("Step: " + action + " | " + "Tick chon giao dịch: " + data);
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy giao dịch");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click choose security device")
    public  void clickChooseSecurityDevice(String action, String data){
        try {
            Select boxAccountNo = new Select(driver.findElement(By.xpath("//select[@id='allCode']")));
            boxAccountNo.selectByVisibleText(data);
            Log.info("Chọn phương thức xác thực");
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            Log.error("Không tìm thấy ô chọn Phương thức xác thực");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click button approve trans")
    public  void clickBtnApproveTrans(String action){
        try {
            WebElement buttonSubmit = driver.findElement(By.xpath("//input[@id='buttonSubmit']"));
            buttonSubmit.click();
            Log.info("Step: " + action + " | " + "Nhấn nút Duyệt");
            Thread.sleep(2000);
        }catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút Duyệt");
        }
    }
    @Step("Step: Click button approve trans_Display Alert")
    public  void clickBtnApproveTrans_DisplayAlert(String action){
        try {
            WebElement buttonSubmit = driver.findElement(By.xpath("//input[@id='buttonSubmit']"));
            buttonSubmit.click();
            Log.info("Step: " + action + " | " + "Nhấn nút Duyệt");
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
            if(driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]")).isDisplayed()){
                String text = driver.findElement(By.xpath("//p[contains(.,'Vui lòng phê duyệt hoặc từ chối cùng loại giao dịch.')]")).getText();
                Log.info("Step: " + action + " | " + "Hiển thị alert thông báo: "+text);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@class='al-close al-ok-btn'][contains(.,'OK')]")).click();
                Log.info("Step: " + action + " | " + "Nhấn nút Ok alert");
            }
        }catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút Duyệt");
        }
    }
    @Step("Step: Click to send otp again ")
    public  void clickSendOtpAgain(String action){
        try{
            Thread.sleep(122000);
            WebElement btnOtp = driver.findElement(By.id("box-btnReset"));
            btnOtp.clear();
            btnOtp.click();
            Log.info("Step: "+action +" | "+"Nhấn nút Gửi lại mã OTP ");
            Thread.sleep(3000);
        }
        catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút Gửi lại mã OTP");
        }
    }
    @Step("Step: Enter reason reject")
    public  void enterReasonReject(String action, String data){
        try{
            driver.findElement(By.id("remarks")).sendKeys(data);
            Log.info("Step: "+action +" | "+"Nhập nội dung từ chối: "+data);
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy ô nhập Lý do từ chối");
        }
    }
    @Step ("Step: Click button continue step 2")
    public  void clickContinueS2_Checker(String action){
        try{
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: "+action +" | "+"Nhấn nút Tiếp tục sang bước 3");
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Kết thúc']")));
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Tiếp tục");
        }
    }
    @Step ("Step: Click enter OTP")
    public  void enterOTP(String action, String data){
        try{
            driver.findElement(By.id("OTP")).sendKeys(data);
            Log.info("Step: "+action +" | "+"Nhập mã otp: "+ data);
            Thread.sleep(2000);
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy ô nhập mã OTP");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step ("Step: Click to end approve trans")
    public  void clickEndTransApprove(String action){
        try{
            driver.findElement(By.xpath("//input[@value='Kết thúc']")).click();
            Log.info("Step: "+action +" | "+"Nhấn nút Kết thúc phê duyệt");
            Thread.sleep(2000);
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Kết thúc");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click button reject")
    public  void clickBtnReject(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            driver.findElement(By.id("buttonReject")).click();
            Log.info("Step: "+action +" | "+"Nhấn nút Từ chối");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noidung")));
            Thread.sleep(2000);
        }
        catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút Từ chối");
        }
    }
    @Step("Step: Click to display detail Trans")
    public  void showDetailTrans(String action, String data){
        try{
            driver.findElement(By.xpath("//tbody/tr["+data+"]/td[10]/a[1]")).click();
            Log.info("Step: "+action +" | "+"Tick chọn giao dịch để xem chi tiết: "+data);
            Thread.sleep(2000);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút xem Chi tiết");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click to display limit amount")
    public  void clickBtnShowDetailLimitAmount(String action, String data){
        try{
            driver.findElement(By.xpath("//a[contains(.,'Chi tiết hạn mức')]")).click();
            Log.info("Step: "+action +" | "+"Nhấn nút xem Chi tiết hạn mức: "+data);
            Thread.sleep(2000);
        }catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút xem Chi tiết");
        }
    }
    @Step("Step: Click button return_Detail Limit Amount")
    public  void clickBtnReturn_DetailLimitAmount(String action, String data){
        try{
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: "+action +" | "+"Nhấn nút Quay lại"+data);
            Thread.sleep(2000);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Quay lại");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step ("Step: Enter number page: {1} ")
    public  void enterChooseNumPage(String action, String data){
        try{
            WebElement btn = driver.findElement(By.id("gotoPageNO_pendingRemittance"));
            btn.sendKeys(data);
            Log.info("Nhập số trang: "+data);
            driver.findElement(By.xpath("//a[contains(.,'Go')]")).click();
            Log.info("Chuyển đến trang số: "+data);
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy số trang: "+data);
        }
    }
}