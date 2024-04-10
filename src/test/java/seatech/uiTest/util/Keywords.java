package seatech.uiTest.util;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import seatech.common.config.PropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Keywords {
    WebDriver driver;
    public Properties prop;

    public static Workbook book;
    public static Sheet sheet;

    public Keywords(WebDriver driver){
        this.driver =driver;
    }
    public String getActionExcel() {
        return actionExcel;
    }

    public void setActionExcel(String actionExcel) {
        this.actionExcel = actionExcel;
    }

    public static String getDataExcel() {
        return dataExcel;
    }

    public void setDataExcel(String dataExcel) {
        Keywords.dataExcel = dataExcel;
    }
    String projectPath = System.getProperty("user.dir");
    SoftAssert softAssert = new SoftAssert();
    static String dataExcel;
    String actionExcel;

    public void ReadFile(String sheetName) throws InterruptedException {
        FileInputStream file = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            //đường dẫn đọc file excel từ file config với key là pathExcel
            file = new FileInputStream(projectPath+ PropertiesFile.getPropValue("pathExcel"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Load tệp Excel
        try {
            assert file != null;
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        int k = 0;
        for (int i = 0; i <sheet.getLastRowNum(); i++) {
            Cell actionCell = sheet.getRow(i + 1).getCell(k + 1);
            String action = actionCell != null ? actionCell.toString().trim() : "";
            setActionExcel(action);
            Cell dataCell = sheet.getRow(i + 1).getCell(k + 2);
            String data = dataCell != null ? dataCell.toString().trim() : "";
            setDataExcel(data);
            ReadExcelFile_InternalBank internalBank = new ReadExcelFile_InternalBank(driver);
            ReadExcelFile_Napas247 napas247 = new ReadExcelFile_Napas247(driver);
            ReadExcelFile_Interbank interbank = new ReadExcelFile_Interbank(driver);
            switch (action) {
                case "url":
                    try {
                        internalBank.enterUrl(data, data);
                    }catch (NoSuchElementException e) {
                        Log.error("Invalid url");
                    }
                    break;
                case "enterUsername":
                    try {
                        internalBank.enterUserName(action, data);
                    }catch (NoSuchElementException ignored){}
                    break;
                case "enterPassword":
                    try {
                        internalBank.enterPassword(action, data);
                    }catch (NoSuchElementException ignored){} catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "clickButtonLogin":
                    internalBank.btnLogin(action);
                    break;
                case "activeOTPLater":
                    internalBank.clickVerifyOTPLater(action);
                    break;
                case "navigateMenu":
                    internalBank.navigateMenu(action, data);
                    break;
                case "selectTabTypeTran":
                    internalBank.selectTabTrans(action, data);
                    break;
                case "selectAccountNo":
                    internalBank.selAccountNo(action, data);
                    break;
                case "selectReceiveAccount_SameAccount":
                    internalBank.selectReceiveAcc_SA(action,data);
                    break;
                case "enterAmount_SameAccount":
                    internalBank.enterAmount_SameAccount(action,data);
                    break;
                case "enterContentTran_SameAccount":
                    internalBank.enterContent_SA(action, data);
                    break;
                case "tickAgreeCondition_SameAccount":
                    internalBank.tickAgreeCondition(action);
                    break;
                case "clickBtnContinueS1_SameAccount":
                    internalBank.clickBtnContinueS1_SameAccount(action);
                    break;
                case "clickBtnContinueS2_SameAccount":
                    internalBank.clickBtnContinueS2_SameAccount(action);
                    break;
                case "clickButtonEndTran_SameAccount":
                    internalBank.clickButtonEndTran_SameAccount(action);
                    break;
                case "clickButtonEndTran_OF_SameAccount":
                    internalBank.clickButtonEndTran_OF_SameAccount(action);
                    break;
                case "clickLinkCondition":
                    internalBank.clickLinkCondition(action);
                    break;
                case "clickAcceptLogout":
                    internalBank.clickAcceptLogout(action);
                    break;
                case "saveTrans_SameAccount":
                    internalBank.saveTrans_SameAccount(action);
                    break;
                case "clickBtnReset_SameAccount":
                    internalBank.clickBtnReset_SameAccount(action);
                    break;
                case "clickBtnReturn":
                    internalBank.clickBtnReturn(action);
                    break;
                    //=========================KHÁC CHỦ=============================
                case "enterReceiveAccount_DiffAccount":
                    internalBank.enterReceiveAccount_DiffAccount(action, data);
                    break;
                case "enterAmount_DiffAccount":
                    internalBank.enterAmount_DiffAccount(action, data);
                    break;
                case "enterContentTrans_DiffAccount":
                    internalBank.enterContentTrans_DiffAccount(action, data);
                    break;
                case "tickAgreeCondition_DiffAccount":
                    internalBank.tickAgreeCondition_DiffAccount(action);
                    break;
                case "clickBtnContinueS1_DiffAccount":
                    internalBank.clickBtnContinueS1_DiffAccount(action);
                    break;
                case "clickBtnContinueS2_DiffAccount":
                    Log.info("Verify nội dung chuyển khoản ở bước 2");
                    internalBank.clickBtnContinueS2_DiffAccount(action);
                    break;
                case "clickButtonEndTran_DiffAccount":
                    internalBank.clickButtonEndTran_DiffAccount(action);
                    break;
                case "clickButtonEndTran_OF_DiffAccount":
                    internalBank.clickButtonEndTran_OF_DiffAccount(action);
                    break;
                case "saveTrans_DiffAccount":
                    internalBank.saveTrans_DiffAccount(action);
                    break;
                case "clickBtnReset_DiffAccount":
                    internalBank.clickBtnReset_DiffAccount(action);
                    break;
                case "clickChooseTransSaved":
                    internalBank.clickChooseTransSaved(action, data);
                    break;
                case "clickOkSaveTemplateTrans":
                    internalBank.clickOkSaveTemplateTrans(action, data);
                    break;
                case "closeSaveTransDialog_DiffAccount":
                    internalBank.closeSaveTransDialog_DiffAccount(action);
                    break;
                case "clickSaveReceiveAccount":
                    internalBank.clickSaveReceiveAccount(action);
                    break;
                case "clickNoSaveReceiveAccount":
                    internalBank.clickNoSaveReceiveAccount(action);
                    break;
                case "chooseSaveReceiveAccount":
                    internalBank.chooseSaveReceiveAccount(action, data);
                    break;
                    //===================================CHECKER=======================
                case "clickBtnQueryTrans":
                    internalBank.clickBtnQueryTrans(action);
                    break;
                case "selectTransType":
                    internalBank.selectTransType(action, data);
                    break;
                case "tickTransaction":
                    internalBank.tickTransaction(action, data);
                    break;
                case "clickChooseSecurityDevice":
                    internalBank.clickChooseSecurityDevice(action, data);
                    break;
                case "clickBtnApproveTrans":
                    internalBank.clickBtnApproveTrans(action);
                    break;
                case "clickBtnApproveTrans_DisplayAlert":
                    internalBank.clickBtnApproveTrans_DisplayAlert(action);
                    break;
                case "clickSendOtpAgain":
                    internalBank.clickSendOtpAgain(action);
                    break;
                case "enterReasonReject":
                    internalBank.enterReasonReject(action, data);
                    break;
                case "clickContinueS2_Checker":
                    internalBank.clickContinueS2_Checker(action);
                    break;
                case "enterOTP":
                    internalBank.enterOTP(action, data);
                    break;
                case "clickEndTransApprove":
                    internalBank.clickEndTransApprove(action);
                    break;
                case "clickBtnReject":
                    internalBank.clickBtnReject(action);
                    break;
                case "showDetailTrans":
                    internalBank.showDetailTrans(action, data);
                    break;
                case "clickBtnShowDetailLimitAmount":
                    internalBank.clickBtnShowDetailLimitAmount(action, data);
                    break;
                case "clickBtnReturn_DetailLimitAmount":
                    internalBank.clickBtnReturn_DetailLimitAmount(action, data);
                    break;
                case "clickChooseNumPage":
                    internalBank.enterChooseNumPage(action, data);
                    break;
                    //=========================================NHANH 24/7============================
                case "clickLinkCondition_247":
                    napas247.clickLinkCondition_247(action);
                    break;
                case "selectTabTypeTran_247":
                    napas247.selectTabTypeTran_247(action, data);
                    break;
                case "selectAccountNo_247":
                    napas247.selectAccountNo_247(action, data);
                    break;
                case "enterCardNo_247Card":
                    napas247.enterCardNo_247Card(action, data);
                    break;
                case "enterAmount_247":
                    napas247.enterAmount_247(action, data);
                    break;
                case "enterContentTran_247":
                    napas247.enterContentTran_247(action,data);
                    break;
                case "tickAgreeCondition_247":
                    napas247.tickAgreeCondition_247(action);
                    break;
                case "clickBtnContinueS1_247Card":
                    napas247.clickBtnContinueS1_247Card(action);
                    break;
                case "clickBtnContinueS1_247AccountNo":
                    napas247.clickBtnContinueS1_247AccountNo(action);
                    break;
                case "clickBtnContinueS2_247":
                    napas247.clickBtnContinueS2_247(action);
                    break;
                case "clickButtonEndTran_247":
                    napas247.clickButtonEndTran_247(action, data);
                    break;
                case "clickButtonEndTran_OF":
                    napas247.clickButtonEndTran_OF(action);
                    break;
                case "saveTrans_247":
                    napas247.saveTrans_247(action);
                    break;
                case "clickBtnReset_247":
                    napas247.clickBtnReset_247(action);
                    break;
                case "clickBtnReturn_247":
                    napas247.clickBtnReturn_247(action);
                    break;
                case "selectBankNo_247AccountNo":
                    napas247.selectBankNo_247AccountNo(action, data);
                    break;
                case "enterReceiveAccount_247AccountNo":
                    napas247.enterReceiveAccount_247AccountNo(action, data);
                    break;
                case "chooseSaveReceiveAccount_247Card":
                    napas247.chooseSaveReceiveAccount_247Card(action, data);
                    break;
                case "chooseSaveReceiveAccount_247Account":
                    napas247.chooseSaveReceiveAccount_247Account(action, data);
                    break;
                case "clickRadioBtnOpenSaveTrans":
                    napas247.clickRadioBtnOpenSaveTrans(action);
                    break;
                case "clickBtnCancelCloseDialogSaveTrans":
                    napas247.clickBtnCancelCloseDialogSaveTrans(action);
                    break;
                    //===========================================NGOÀI HỆ THỐNG====================================
                case "selectAccountNo_interBank":
                    interbank.selectAccountNo_interBank(action,data);
                    break;
                case "enterReceiveAccount_interBank":
                    interbank.enterReceiveAccount_interBank(action,data);
                    break;
                case "enterReceiveName_interBank":
                    interbank.enterReceiveName_interBank(action, data);
                    break;
                case "selectBankNo_interBank":
                    interbank.selectBankNo_interBank(action, data);
                    break;
                case"enterAmount_interBank":
                    interbank.enterAmount_interBank(action, data);
                    break;
                case "enterContent_interBank":
                    interbank.enterContent_interBank(action, data);
                    break;
                case "tickAgreeCondition_interBank":
                    interbank.tickAgreeCondition_interBank(action);
                    break;
                case "clickLinkCondition_interBank":
                    interbank.clickLinkCondition_interBank(action);
                    break;
                case"clickOkSaveTemplateTrans_interBank":
                    interbank.clickOkSaveTemplateTrans_interBank(action, data);
                    break;
                case "chooseSaveReceiveAccount_interBank":
                    interbank.chooseSaveReceiveAccount_interBank(action, data);
                    break;
                case "clickBtnContinueS1_interBank":
                    interbank.clickBtnContinueS1_interBank(action);
                    break;
                case"clickBtnContinueS2_interBank":
                    interbank.clickBtnContinueS2_interBank(action);
                    break;
                case"clickButtonEndTran_interBank":
                    interbank.clickButtonEndTran_interBank(action);
                default:
                    break;
            }
        }
        softAssert.assertAll();
        }
    }
