package Base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Util.Constants;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseTest {
    public static WebDriver driver;
    protected static ExtentReports extentReports;
    private ExtentTest logger;
    
    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver(); // Ensure WebDriver is initialized
        }
        return driver;
    }


    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("firefox") String browser) {
        // Initialize Extent Reports
        extentReports = new ExtentReports();
        logger = extentReports.createTest("Test Setup");

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                System.out.println("Error: Unsupported browser - " + browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(Constants.url);
            System.out.println("Browser launched successfully: " + browser);
            logger.log(Status.INFO, "Browser launched successfully: " + browser);

        } catch (Exception e) {
            System.out.println("Error during browser setup: " + e.getMessage());
            logger.log(Status.FAIL, "Error during browser setup: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testExample() {
        logger.log(Status.INFO, "This is a My Contact Website!");
        // Your test logic here
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, "Test Failed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, "Test Passed: " + result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
            logger.log(Status.INFO, "Driver quit successfully.");
        }
    }
}
