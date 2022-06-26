package pages;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BlogPage extends BasePage
{
    public BlogPage(WebDriver driver)
    {
        super(driver);
    }

    public static By postTitleTxt = By.xpath("//h2[@class='heading-4 post-title']/a");
    public static String print = "POST TITLES WITH RELATED LINKS: ";

    public void printPostTitles() {
        waitForElement(postTitleTxt);
        List<WebElement> postTitles = findElements(postTitleTxt);
        System.out.println(print + "\n");
        for (WebElement postTitle : postTitles) {
            System.out.println(postTitle.getText());
            System.out.println(postTitle.getAttribute("href"));
            System.out.println("\n");
        }
    }
}

