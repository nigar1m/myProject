package tests;

import actions.ElementActions;
import actions.WebDriverManager;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SampleTest {
    WebDriver driver;
    WebDriverManager webDriverManager = new WebDriverManager();

    @BeforeMethod
    public void setUp() {
        driver = webDriverManager.setUpDriver("edge");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
            BasePage basePage = new BasePage(driver);
            basePage.openUrl("https://demoqa.com/");

        ElementActions elementActions = new ElementActions(driver);
        elementActions.click(By.cssSelector(".banner-image"));

    }

    @AfterMethod
    public void tearDown() {
        webDriverManager.tearDown();
    }
}
