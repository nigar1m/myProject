package tests;

import actions.ElementActions;
import actions.WebDriverManager;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UiTestsSearch {
    WebDriver driver;
    WebDriverManager webDriverManager = new WebDriverManager();


    @BeforeMethod
    public void setUp() {
        driver = webDriverManager.setUpDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void searchForEarphoneTest() {
        BasePage basePage = new BasePage(driver);
        basePage.openUrl("https://trendyol.com");

        ElementActions elementActions = new ElementActions(driver);
        By femaleButton = By.cssSelector("g[id='Group-38']");
        elementActions.click(femaleButton);

        By directBuyButton = By.cssSelector("button[class='az-action tr-button']");
        elementActions.click(directBuyButton);


        By loginButton = By.xpath("//div[@class='link account-user']//p[contains(text(), 'Giriş Yap')]");
        elementActions.click(loginButton);
        By emailInput = By.id("login-email");
        elementActions.sendKeys(emailInput, "tawnie@thirifara.com");
        By passwordInput = By.id("login-password-input");
        elementActions.sendKeys(passwordInput, "Testingpassword.123");
        By loginSubmitButton = By.xpath("//button[@class='q-primary q-fluid q-button-medium q-button submit']//span[contains(text(), 'Giriş Yap')]");
        elementActions.click(loginSubmitButton);

        By searchBar = By.cssSelector("input[data-testid='suggestion']");
        elementActions.sendKeysWithKeys(searchBar, "earphone", Keys.ENTER);


        By productTitleSelector = By.cssSelector("#sticky-aggregations > div > div:nth-child(1) > div > div > div.lefted-search-title");
        WebElement productTitleElement = driver.findElement(productTitleSelector);

        String productTitleText = productTitleElement.getText().toLowerCase();
        Assert.assertTrue(productTitleText.contains("earphone"), "Product title does not contain the search term 'earphone'.");
    }

    @AfterMethod
    public void tearDown() {
        webDriverManager.tearDown();
    }
}