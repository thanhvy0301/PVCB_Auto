package seatech.uiTest.util;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import seatech.common.config.Log;
import seatech.common.config.PropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadExcelFile_Napas247 {

    static WebDriver driver;
    public Properties prop;

    public static Workbook book;
    public static Sheet sheet;

    public ReadExcelFile_Napas247(WebDriver driver){
        this.driver =driver;
    }
    String projectPath = System.getProperty("user.dir");
    static String accountNo;
    static String receiveAccount;
    static String amount;
    static String contentTran;
    static String numCard;

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getContentTran() {
        return contentTran;
    }

    public void setContentTran(String contentTran) {
        this.contentTran = contentTran;
    }
    @Step ("Step: Click link Condition 247")
    public void clickLinkCondition_247(String action){
        try{
            driver.findElement(By.xpath("//a[contains(text(),'Bản điều khoản & điều kiện Ngân hàng điện tử')]")).click();
            Log.info("Step: "+action+" | "+ "Click vào link điều khoản - điều kiện");
            Thread.sleep(3000);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy Button Kết thúc");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /*@Step ("Step: Active OTP Later")
    public void activeOTPLater(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement displayHome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[2]/div[2]/div[2]/span[1]")));
            Assert.assertTrue(displayHome.isDisplayed());
            driver.findElement(By.xpath("//button[@class='cancel awesome'][contains(.,'Kích hoạt sau')]")).click();
            Log.info("Step: "+action+" | "+"Nhấn vào button kích hoạt smart OTP sau");
            Thread.sleep(3000);
        }
        catch (NoSuchElementException | InterruptedException e){}
    }*/
    @Step ("Step: Select tab transaction: {1}")
    public void selectTabTypeTran_247(String action, String data){
        try{
            if(data.equalsIgnoreCase("Chuyển đến số thẻ")){
                WebElement typeTran = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/label[1]"));
                typeTran.click();
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Chọn loại ck: "+typeTran.getText());
            } else if (data.equalsIgnoreCase("Chuyển đến số tài khoản")) {
                WebElement typeTran = driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/label[2]"));
                typeTran.click();
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Chọn loại ck: "+typeTran.getText());
            }
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy tab loại tài khoản");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Select account number 24/7: {1}")
    public void selectAccountNo_247(String action, String data){
        if(data.isEmpty()){
            Log.error("Tài khoản trích nợ rỗng");
        }
        else {
            try{
                Select boxAccountNo = new Select(driver.findElement(By.id("source_account_list")));
                boxAccountNo.selectByValue(data);
                setAccountNo(data);
                Log.info("Step: "+action+" | "+"Chọn tk trích nợ: "+data);
                Thread.sleep(2000);
            }catch (NoSuchElementException e){
                Log.error("Không tìm thấy ô chọn TK Trích nợ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Step("Step: Enter card number _247 Card")
    public void enterCardNo_247Card(String action, String data){
        try{
            WebElement txbCardNo =driver.findElement(By.id("cardNoSML"));
            if(txbCardNo.isDisplayed()){
                txbCardNo.clear();
                txbCardNo.sendKeys(data);
                String a = txbCardNo.getAttribute("value");
                setNumCard(a);
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Nhập số thẻ: "+data);
            }
        }catch (NoSuchElementException ignored){} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step ("Enter amount _247: {1}")
    public void enterAmount_247(String action, String data){
        try{
            WebElement txbAmount =driver.findElement(By.id("amount"));
            if(txbAmount.isDisplayed()){
                txbAmount.clear();
                txbAmount.sendKeys(data);
                String am = txbAmount.getAttribute("value");
                setAmount(am);
                Thread.sleep(2000);
                Log.info("Step: "+action+" | "+"Nhập số tiền: "+data);
            }
        }catch (NoSuchElementException ignored){} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Enter content trans: {1}")
    public void enterContentTran_247(String action, String data){
        try{
            WebElement txbContent = driver.findElement(By.id("comment"));
            if(txbContent.isDisplayed()){
                txbContent.clear();
                txbContent.sendKeys(data);
                String gettextContent =txbContent.getAttribute("value");
                setContentTran(gettextContent);
                Thread.sleep(1000);
                Log.info("Step: "+action+" | "+"Nhập nội dung: "+data);
            }
        }catch (NoSuchElementException ignored){} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step ("Step: Tick agree condition")
    public void tickAgreeCondition_247(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("chkApp")));
            if (!checkbox.isSelected()) {
                checkbox.click();
                Log.info("Step: "+action+" | "+"Đã tick vào đồng ý điều khoản");// Tick vào checkbox nếu chưa được tick
            }
            else {
                Log.info("Điều khoản đã được tick chọn trước đó");
            }
            Thread.sleep(1000);
        }catch (NoSuchElementException | InterruptedException e){}
    }
    @Step ("Step: Click button to step 2")
    public void clickBtnContinueS1_247Card(String action){
        try {
            List<String> getDataList_247 = new ArrayList<>();
            getDataList_247.add(getAccountNo());
            getDataList_247.add(getAmount());
            getDataList_247.add(getContentTran());
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: " + action + " | " + "Nhấn tiếp tục để sang bước 2 (247)");
            if (driver.findElement(By.id("return1")).isDisplayed()) {
                Log.info("Chuyển sang bước 2");
            } else if (!driver.findElement(By.id("return1")).isDisplayed()) {
                try {
                    Log.info("Vào try");
                    for (int item = 1; item < getDataList_247.size(); item++) {
                        String currentItem = getDataList_247.get(item);
                        if (item == 1 && currentItem.isEmpty()) {
                            String txtErrAccountNo = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/font[1]")).getText();
                            Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrAccountNo);
                            break;
                        }
                        else if (item == 2 && currentItem.isEmpty()) {
                            String txtErrAmount = driver.findElement(By.xpath("//font[@color='red'][contains(.,'Vui lòng nhập chính xác số tiền')]")).getText();
                            Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrAmount);
                            break;
                        } else if (item == 3 && currentItem.isEmpty()) {
                            String txtErrContent = driver.findElement(By.xpath("//td[contains(.,'Vui lòng nhập Nội dung')]")).getText();
                            Log.info("Step: " + action + " | " + "Hiển thị thông báo: " + txtErrContent);
                            break;
                        }
                    }
                } catch (NoSuchElementException ignored) {
                }
            }
        }catch (NoSuchElementException ex){
            Log.error("Không tìm thấy nút Tiếp tục");
        }
    }
    @Step("Step: Click button to step 2")
    public void clickBtnContinueS1_247AccountNo(String action){
        try{
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: "+action+" | "+"Nhấn tiếp tục để sang bước 2 (247)");
            Thread.sleep(2000);
        }catch (NoSuchElementException | InterruptedException e){}
    }
    @Step("Step: Click to step 3")
    public void clickBtnContinueS2_247(String action){
        try{
            driver.findElement(By.id("submit1")).click();
            Log.info("Step: "+action+" | "+"Nhấn tiếp tục sang bước 3");
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Tiếp tục ở bước 2");
        }
    }
    @Step("Step: Click button to end trans")
    public void clickButtonEndTran_247(String action, String data){
        try{
            driver.findElement(By.xpath("//input[contains(@value,'Kết thúc')]")).click();
            Log.info("Step: "+data+" | "+ "Click kết thúc giao dịch");
            Thread.sleep(3000);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy Button Kết thúc");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Click button to end trans_Out frame: {0}")
    public void clickButtonEndTran_OF(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            driver.findElement(By.xpath("//input[contains(@value,'Kết thúc')]")).click();
            Log.info("Step: "+action+" | "+ "Click kết thúc giao dịch_Thoát khỏi frame");
            WebElement displayTranScreen =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='noidung']"))));
            Assert.assertTrue(displayTranScreen.isDisplayed());
            driver.switchTo().defaultContent();
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy Button Kết thúc");
        }
    }
    @Step("Step: Save trans: {0}")
    public void saveTrans_247(String action){
        try{
            driver.findElement(By.id("save1")).click();
            Log.info("Step: "+action+" | "+ "Nhấn nút Lưu nháp");
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//a[@class='al-close al-ok-btn'][contains(.,'OK')]")).click();
            Log.info("Step: "+action+" | "+ "Nhấn Ok alert lưu mẫu thành công");
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Lưu nháp");
        }
    }
    @Step("Step: Click button to reset: {0}")
    public void clickBtnReset_247(String action){
        try{
            driver.findElement(By.id("reset1")).click();
            Log.info("Step: "+action+" | "+ "Nhấn nút Thiết lập lại");
            Thread.sleep(3000);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Thiết lập lại");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click button to return")
    public void clickBtnReturn_247(String action){
        try{
            driver.findElement(By.id("return1")).click();
            Thread.sleep(2000);
//                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("receiveAccount"))).isDisplayed();
            Log.info("Step: "+action+" | "+ "Nhấn nút Trở về bước Nhập thông tin");
        }catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút Trở về");
        }
    }
    @Step("Step: Select bank no")
    public void selectBankNo_247AccountNo(String action, String data){
        if(data.isEmpty()){
            Log.info("Ngân hàng thụ hưởng rỗng");
        }
        else {
            try{
                Select boxAccountNo = new Select(driver.findElement(By.id("bankNo")));
                boxAccountNo.selectByVisibleText(data);
                setAccountNo(data);
                Log.info("Step: "+action+" | "+"Chọn ngân hàng thụ hưởng: "+data);
                Thread.sleep(2000);
            }catch (NoSuchElementException ignored){
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Step("Step: Enter receive account_247 Account No {1}")
    public void enterReceiveAccount_247AccountNo(String action, String data){
        try{
            WebElement txbReceive = driver.findElement(By.id("accSML"));
            txbReceive.clear();
            txbReceive.sendKeys(data);
            Thread.sleep(2000);
            Log.info("Step: "+action+" | "+ "Nhập tài khoản thụ hưởng (Đến số tk): "+data);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy ô nhập tài khoản nhận");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Click button radio to save template: {1}")
    public void clickOkSaveTemplateTrans_247(String action, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            driver.findElement(By.id("yesSave")).click();
            Log.info("Step: "+action+" | "+ "Nhấn radio button 'Có' lưu mẫu giao dịch (Khác chủ)");
            try{
                Log.info("Hiển thị alert mẫu giao dịch đã tồn tại");
                driver.switchTo().alert().accept();
                Log.info("Nhấn Ok alert");
            }catch (NoAlertPresentException e){
            }
            WebElement dialogSaveTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]")));
            if(dialogSaveTemplate.isDisplayed()){
                driver.findElement(By.id("templateNameId")).sendKeys(data);
                Log.info("Step: "+action+" | "+ "Nhập tên giao dịch mẫu: "+data);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@type='button'][contains(.,'OK')]")).click();
                Log.info("Step: "+action+" | "+ "Nhấn Ok lưu mẫu");
            }
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút 'Có' lưu giao dịch mẫu");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step ("Step: Cick to choose receive account saved: {1}")
    public void chooseSaveReceiveAccount_247Card(String action, String data){
        try{
            driver.findElement(By.xpath("//tbody/tr[8]/td[2]/div[1]/span[1]")).click();
            Log.info("Step: "+action+" | "+ "Nhấn nút chọn Người thụ hưởng đã lưu");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+data+"]/td[1]/input[1]")).click();
            Log.info("Step: "+action+" | "+ "Nhấn chọn  mẫu đã lưu: "+data);
            driver.findElement(By.id("submitBenf")).click();
            Log.info("Step: "+action+" | "+ "Nhấn Tiếp tuc");
            Thread.sleep(2000);
        }catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút Chọn Lưu người thụ hưởng");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Step("Step: Choose Saved Receive Account: {1}")
    public void chooseSaveReceiveAccount_247Account(String action, String data){

        try{
            driver.findElement(By.id("receiveAccountHis")).click();
            Log.info("Step: "+action+" | "+ "Nhấn nút chọn Người thụ hưởng đã lưu");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+data+"]/td[1]/input[1]")).click();
            Log.info("Step: "+action+" | "+ "Nhấn chọn  mẫu đã lưu: "+data);
            driver.findElement(By.id("submitBenf")).click();
            Log.info("Step: "+action+" | "+ "Nhấn Tiếp tuc");
            Thread.sleep(2000);
        }catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút Chọn Lưu người thụ hưởng");
        }
    }
    @Step("Step: Click radio button to Open Save tran")
    public void clickRadioBtnOpenSaveTrans(String action){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
            driver.findElement(By.id("yesSave")).click();
            Log.info("Step: "+action+" | "+ "Nhấn radio button 'Có' lưu mẫu giao dịch (Khác chủ)");
            WebElement dialogSaveTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]")));
            Thread.sleep(2000);
        }catch (NoSuchElementException | InterruptedException e){
            Log.error("Không tìm thấy nút 'Có' lưu giao dịch mẫu");
        }
    }
    @Step("Step: Click button exit save trans")
    public void clickBtnCancelCloseDialogSaveTrans(String action){
        try{
            driver.findElement(By.xpath("//button[@title='Close']")).click();
            Log.info("Step: "+action+" | "+ "Nhấn thoát lưu mẫu");
        }
        catch (NoSuchElementException e){
            Log.error("Không tìm thấy nút thoát dialog lưu mẫu");
        }
    }
    public void startExecution(String sheetName) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        FileInputStream file = null;
        try {
            //đường dẫn đọc file excel từ file config với key là pathExcel
            file = new FileInputStream(projectPath+PropertiesFile.getPropValue("pathExcel"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Load tệp Excel
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        int k = 0;
        for (int i = 0; i <sheet.getLastRowNum(); i++) {
            //Row row = sheet.getRow(i);
            Cell actionCell = sheet.getRow(i + 1).getCell(k + 1);
            String action = actionCell != null ? actionCell.toString().trim() : "";

            Cell dataCell = sheet.getRow(i + 1).getCell(k + 2);
            String data = dataCell != null ? dataCell.toString().trim() : "";
            switch (action) {
                /*case "url":
                    driver.get(data);
                    Log.info("Step: "+action +" | "+"Khởi tạo đường dẫn: "+data);
                    break;
                case "enterUsername":
                    driver.findElement(By.id("t_userName")).sendKeys(data);
                    Log.info("Step: " +action +" | "+"Nhập username " + data);
                    break;
                case "enterPassword":
                    driver.findElement(By.id("t_password")).sendKeys(data);
                    Log.info("Step: "+action+" | "+"Nhập password "+data);
                    Thread.sleep(10000);
                case "clickButtonLogin":
                    if(action.equalsIgnoreCase("clickButtonLogin")){
                        driver.findElement(By.xpath("//button[contains(.,'Đăng nhập')]")).click();
                        Log.info("Step: "+action+" | "+"Nhấn vào button đăng nhập");
                        *//*try {
//                            WebElement button = driver.findElement(By.xpath("//input[contains(@name,'button')]"));
                            driver.findElement(By.xpath("//input[contains(@name,'button')]")).click(); // Click the button
                            Log.info("Nhấn vào button đồng ý");
                        }catch (NoSuchElementException e){
                            Log.error("Không hiển thị btn đồng ý");
                            }*//*
                        }
                    break;*/

/*                case "activeOTPLater":
                    activeOTPLater(action);
                    break;
                case "navigateMenu":
                    if(action.equalsIgnoreCase("navigateMenu")) {
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
                    break;*/
/*                case "clickSaveReceiveAccount":

                    break;
                case "clickCancelSaveTemplateTrans":
                    try{
                        driver.findElement(By.id("yesSave")).click(); //xem lại
                        Log.info("Step: "+action+" | "+ "Nhấn radio button 'Có' lưu mẫu giao dịch (Khác chủ)");
                        try{
                            Log.info("Hiển thị alert mẫu giao dịch đã tồn tại");
                            driver.switchTo().alert().accept();
                            Log.info("Nhấn Ok alert");
                        }catch (NoAlertPresentException e){
                            Log.error("Khong hien thi alert");
                        }
                        WebElement dialogSaveTemplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[5]")));
                        if(dialogSaveTemplate.isDisplayed()){
                            driver.findElement(By.id("templateNameId")).sendKeys(data);
                            Log.info("Step: "+action+" | "+ "Nhập tên giao dịch mẫu: "+data);
                            Thread.sleep(2000);
                            driver.findElement(By.xpath("//button[@type='button'][contains(.,'Cancel')]")).click();
                            Log.info("Step: "+action+" | "+ "Nhấn Cancel lưu mẫu");
                        }
                    }catch (NoSuchElementException e){
                        Log.error("Không tìm thấy nút 'Cancel' lưu giao dịch mẫu");
                    }
                    break;*/


               /* case "clickChooseTransSaved":
                    try{
                        driver.findElement(By.xpath("//font[@color='blue'][contains(.,'Chọn từ giao dịch mẫu')]")).click();
                        Log.info("Step: "+action+" | "+ "Nhấn nút chọn Từ giao dịch mẫu (Khác chủ)");
                        try{
                            WebElement dialogTransSaved = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath("//table[1]/table[1]/tbody[1]/tr["+data+"]/td[1]/input[1]")));
                            dialogTransSaved.click();
                            Log.info("Step: "+action+" | "+ "Tick chọn giao dịch mẫu (Khác chủ)");
                            driver.findElement(By.id("submitTranTem")).click();
                            Log.info("Step: "+action+" | "+ "Nhấn nút tiếp tục ở dialog lưu mẫu");
                            Thread.sleep(3000);
                        }catch (NoSuchElementException e){
                            Log.error("Không tìm thấy dialog lưu nháp");
                        }
                    }catch (NoSuchElementException e){
                        Log.error("Không tìm thấy nút Chọn từ giao dịch mẫu");
                    }
                    break;*/


                    //=========================MÀN HÌNH LƯU NHÁP===============================
                default:
                    break;
            }
        }
    }
}