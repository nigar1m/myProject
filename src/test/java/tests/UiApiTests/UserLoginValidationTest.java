package tests.UiApiTests;

import actions.ApiTest;
import actions.ElementActions;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserLoginValidationTest {
    WebDriver driver;
    String baseUrl;
    ElementActions elementActions;
    ApiTest apiTest = new ApiTest();

    @BeforeClass
    public void setUp() {
        actions.WebDriverManager webDriverManager = new actions.WebDriverManager();
        driver = webDriverManager.setUpDriver("chrome");
        baseUrl = "https://automationexercise.com";
        elementActions = new ElementActions(driver);
        driver.get(baseUrl);
    }

    @Test
    public void testUserLogin() {
        elementActions.click(By.xpath("//a[contains(text(),'Login')]"));
        String email = "tawnie@thirifara.com";
        String password = "Testingpassword.123";
        elementActions.sendKeys(By.name("email"), email);
        elementActions.sendKeys(By.name("password"), password);
        elementActions.click(By.xpath("//button[contains(text(),'Login')]"));

        String endPoint = "/api/verifyLogin";
        String url = baseUrl + endPoint;
        String requestBody = "{\"email\":\"tawnie@thirifara.com\", \"password\":\"Testingpassword.123\"}";

        Response response = apiTest.postApiRequest(url, requestBody);

        apiTest.validateResponse(response, 200);

    }
}
