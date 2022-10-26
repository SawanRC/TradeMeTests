package com.nirari.acc.base;

import org.testng.*;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        ReportManager.getInstance().fail("Test failed");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.getInstance().pass("Test success");
    }
}
