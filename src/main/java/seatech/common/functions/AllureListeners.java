package seatech.common.functions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import seatech.common.baseBrowser.Base;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Properties;

public class AllureListeners implements ITestListener {
        static Base base;
        static Properties prop;
    WebDriver driver;
        @Override
        public void onFinish(ITestContext arg0) {
            // TODO Auto-generated method stub

        }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("Start");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
    //Text attachments for Allure

}

