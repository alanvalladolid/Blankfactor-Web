package tests;

import commons.BaseTest;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.PostPage;

public class BlankfactorTest extends BaseTest
{
    @BeforeMethod
    public void setUpTest()
    {
        openChrome();
    }

    @Test
    public void BlankfactorTA()
    {
        try
        {
            PostPage post = new PostPage(driver);
            post.validateURL();
            post.validateTitle();
            post.subscribeNewsletter("alan@gmail.com");
            post.backToBlog();

            BlogPage blog = new BlogPage(driver);
            blog.printPostTitles();
        }

        catch(AssertionError | InterruptedException | TimeoutException error)
        {
            error.printStackTrace();
        }
    }

    @AfterMethod
    public void closeTest()
    {
        closeChrome();
    }
}
