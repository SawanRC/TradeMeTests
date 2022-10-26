package com.nirari.acc.base;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        ReportManager.getInstance().fail("Test failed");
        ReportManager.getInstance().fail(result.getThrowable().getMessage());
        ReportManager.getInstance().fail(MarkupHelper.createCodeBlock(result.getThrowable().toString()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.getInstance().pass("Test success");
    }
}
