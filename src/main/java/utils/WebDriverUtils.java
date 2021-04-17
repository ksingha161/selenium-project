package utils;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils
{
    private WebDriverUtils()
    {
    }

    public static void waitUntil( WebDriver driver,
                                  ExpectedCondition<?> expectedCondition,
                                  int timeoutSeconds )
    {
        WebDriverWait driverWait = new WebDriverWait( driver, timeoutSeconds );
        driverWait.until( expectedCondition );
    }

    public static void jsClick( WebDriver driver, WebElement element )
    {
        JavascriptExecutor js = ( JavascriptExecutor ) driver;
        js.executeScript( "arguments[0].click();", element );
    }

    public static void waitAndJsClick( WebDriver driver, WebElement element, int timeoutSeconds )
    {
        waitUntil( driver, ExpectedConditions.elementToBeClickable( element ), timeoutSeconds );
        jsClick( driver, element );
    }

    public static void getInnerText( WebDriver driver, WebElement element )
    {
        JavascriptExecutor js = ( JavascriptExecutor ) driver ;
        js.executeScript( "document.documentElement.innerText", element );
    }

    public static void verifyIsDisplayed( WebElement element )
    {
        Assert.assertTrue( element.isDisplayed() );
    }

    public static void verifyIsEnabled( WebElement element )
    {
        Assert.assertTrue( element.isEnabled() );
    }
}
