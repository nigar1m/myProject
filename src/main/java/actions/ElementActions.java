package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ElementActions {
    WebDriver driver;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeysWithKeys(By locator, String text, Keys key) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(key);
    }

    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public boolean isDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    public void assertText(By locator, String expectedText) {
        String actualText = getText(locator);
        Assert.assertEquals(actualText, expectedText, "Text does not match");
    }

    public void selectDropdown(By locator, String option) {
        WebElement element = driver.findElement(locator);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(option);
    }

    public void checkCheckbox(By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckCheckbox(By locator) {
        WebElement element = driver.findElement(locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void hover(WebElement locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(locator).click(locator).build().perform();
    }
}
