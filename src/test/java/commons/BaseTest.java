package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PostPage;
import java.util.concurrent.TimeUnit;

public class BaseTest
{
    public static WebDriver driver;

    public void openChrome()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blankfactor.com/insights/blog/fintech-in-latin-america/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        PostPage post = new PostPage(driver);
        post.clickAcceptCookie();
    }

    public void closeChrome()
    {
        driver.close();
        driver.quit();
    }
}
