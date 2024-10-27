package tests;

import actions.ElementActions;
import actions.WebDriverManager;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UITogglePreviouslyViewedTest {
    WebDriver driver;
    WebDriverManager webDriverManager = new WebDriverManager();
    ElementActions elementActions = new ElementActions(driver);


    @BeforeMethod
    public void setUp() {
        driver = webDriverManager.setUpDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testChangeDeliveryCountry() {
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

        elementActions.hover(By.xpath("//p[@class='link-text' and text()='Hesabım']"));

        By userInfo = By.cssSelector("a.loggedin-account-item[href='/Hesabim/KullaniciBilgileri']");
        elementActions.click(userInfo);

        By firstName = By.cssSelector("input[name='firstname']");
        elementActions.sendKeys(firstName, "Nergiz");
    }
}
