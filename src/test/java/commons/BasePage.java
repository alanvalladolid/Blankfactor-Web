package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage
{
    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public List<WebElement> findElements(By locator)
    {
        return driver.findElements(locator);
    }

    public void click(By locator)
    {
        driver.findElement(locator).click();
    }

    public void type(String inputText, By locator)
    {
        driver.findElement(locator).sendKeys(inputText);
    }

    public String getText(By locator)
    {
        return driver.findElement(locator).getText();
    }

    public void waitForElement(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
