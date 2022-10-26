package com.nirari.acc.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private final ExtentReports extentReports;
    private ExtentTest test;
    private static ReportManager instance;

    private ReportManager() {
        this.extentReports = new ExtentReports();
        this.extentReports.attachReporter(new ExtentSparkReporter("target/report.html"));
    }

    public static ReportManager getInstance() {
        if (instance == null) {
            instance = new ReportManager();
        }

        return instance;
    }

    public void flush() {
        this.extentReports.flush();
    }

    public void createTest(String name) {
        this.test = extentReports.createTest(name);
    }

    public void fail(String string) {
        this.test.fail(string);
    }

    public void fail(Markup markup) {
        this.test.fail(markup);
    }

    public void pass(String string) {
        this.test.pass(string);
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
