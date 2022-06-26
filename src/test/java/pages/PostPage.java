package pages;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PostPage extends BasePage
{
    public PostPage(WebDriver driver)
    {
            super(driver);
    }

    public static By acceptCookieBtn = By.id("hs-eu-confirmation-button");
    public static By titleText = By.xpath("//h1[@class='heading-3 post-title']");

    public static String URL = "/blog/fintech-in-latin-america";

    public static String Title = "Why Fintech in Latin America Is Having a Boom";

    public static By emailInput = By.name("Email");

    public static By subscribeBtn = By.id("form-newsletter-blog-submit-btn");

    public static By subscribeSuccess = By.className("mc4wp-response");

    public static String subscribeSuccessTxt = "Thank you for subscribing! Stay tuned.";

    public static By returnBlog = By.className("back-to-blog");

    public static By postTitle = By.xpath("//h2[@class='heading-4 post-title']/a");

    public void clickAcceptCookie()
    {
        waitForElement(acceptCookieBtn);
        click(acceptCookieBtn);
    }

    public void validateURL()
    {
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(URL));
    }

    public void validateTitle()
    {
        String actualTitle = getText(titleText);
        Assert.assertTrue(actualTitle.contains(Title));
    }

    public void subscribeNewsletter(String email)
    {
        click(emailInput);
        type(email, emailInput);
        click(subscribeBtn);
        waitForElement(subscribeSuccess);
        String actualSuccessSubscribeTxt = getText(subscribeSuccess);
        Assert.assertTrue(actualSuccessSubscribeTxt.contains(subscribeSuccessTxt));
    }

    public void backToBlog() throws InterruptedException
    {
        click(returnBlog);
        waitForElement(postTitle);
        Thread.sleep(20000);
    }

}
