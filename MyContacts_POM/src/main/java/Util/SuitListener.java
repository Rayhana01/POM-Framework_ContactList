package Util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import Base.baseTest;

public class SuitListener implements ITestListener, IAnnotationTransformer {

    public void onTestFailure(ITestResult result) {
        String screenshotsDir = System.getProperty("user.dir") + File.separator + "screenshots";
        File dir = new File(screenshotsDir);
        if (!dir.exists()) {
            dir.mkdir();  // Create the directory if it doesn't exist
        }

        String filename = screenshotsDir + File.separator + result.getMethod().getMethodName();
        File screenshotFile = ((TakesScreenshot) baseTest.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File(filename + ".png"));
            System.out.println("Screenshot saved at: " + filename + ".png");
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ReTryAnalyzer.class);  // Set the retry logic for all test methods
    }

}
