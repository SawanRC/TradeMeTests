package com.nirari.acc.base;

import com.nirari.acc.TMVisitor;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private final ReportManager reportManager = ReportManager.getInstance();
    protected TMVisitor visitor;

    @BeforeMethod
    public void initializeTest() {
        this.visitor = new TMVisitor();
        this.reportManager.createTest(getClass().getName());
    }

    @AfterMethod
    public void flush(ITestResult result) {
        this.reportManager.flush();
    }

    public void given(String message) {
        reportManager.given(message);
    }

    public void then(String message) {
        reportManager.then(message);
    }

    public void and(String message) {
        reportManager.and(message);
    }

    public void when(String message) {
        reportManager.when(message);
    }

}
