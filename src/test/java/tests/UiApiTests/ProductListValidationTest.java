package tests.UiApiTests;

import actions.ApiTest;
import actions.ElementActions;
import actions.WebDriverManager;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductListValidationTest {
    WebDriver driver;
    ApiTest apiTest = new ApiTest();
    String baseUrl;
    ElementActions elementActions;

    @BeforeClass
    public void setUp() {
        WebDriverManager webDriverManager = new WebDriverManager();
        driver = webDriverManager.setUpDriver("chrome");
        baseUrl = "https://automationexercise.com";
        driver.get(baseUrl);

        elementActions = new ElementActions(driver);
    }

    @Test
    public void testCompareProductNameFromUIAndAPI() {
        String apiUrl = "https://automationexercise.com/api/productsList";
        driver.get(baseUrl + "/products");

        String uiProductName = elementActions.getText(By.cssSelector(".productinfo p"));
        Response response = apiTest.getApiResponse(apiUrl);

        String apiProductName = response.jsonPath().getString("products[0].name");

        Assert.assertEquals(uiProductName, apiProductName, "Product name does not match between UI and API.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
