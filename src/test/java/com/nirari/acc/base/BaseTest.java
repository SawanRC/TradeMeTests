package com.nirari.acc.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nirari.acc.TMVisitor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    private ExtentReports extentReports;

    private ExtentTest test;

    protected TMVisitor visitor;

    @BeforeTest
    public void initializeTest() {
        this.extentReports = new ExtentReports();
        this.extentReports.attachReporter(new ExtentSparkReporter("target/report.html"));
        this.test = extentReports.createTest(getClass().getName());
        this.visitor = new TMVisitor();
    }

    @AfterTest
    public void flush() {
        extentReports.flush();
    }

    public void given(String message) {
        test.info("<b>Given </b>" + message);
    }

    public void then(String message) {
        test.info("<b>Then </b>" + message);
    }

    public void and(String message) {
        test.info("<b>And </b>" + message);
    }

    public void when(String message) {
        test.info("<b>When </b>" + message);
    }

}
