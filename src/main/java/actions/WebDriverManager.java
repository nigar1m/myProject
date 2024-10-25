package actions;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;


public class WebDriverManager {
    WebDriver driver;
    public WebDriver setUpDriver(String browser) {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.createDriver(browser);
        return driver;
    }

    public void tearDown(){
        driver.quit();
    }
}