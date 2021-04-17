package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;

public class BrowserUtils
{
    private BrowserUtils() {}

    private static final String CHROME = "chrome";
    private static final String SAFARI = "safari";
    private static final String EDGE = "edge";
    private static final String IE = "ie";
    private static final String INTERNET_EXPLORER = "internetexplorer";
    private static final Logger logger = LoggerFactory.getLogger( BrowserUtils.class );
    
    public static WebDriver resolveDriver( ITestContext context )
    {
        WebDriver driver;
        String browser = context.getCurrentXmlTest().getParameter( "browser" );
        switch ( browser.toLowerCase() )
        {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case INTERNET_EXPLORER:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
