package com.octave.octave_demo;

import com.codeborne.selenide.testng.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.PropertiesLoader;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyTest
{

    WebDriver driver;
    SpotifyPageOne spotifyPageOne;
    SpotifyPageTwo spotifyPageTwo;
    SpotifyPageThree spotifyPageThree;
    private Logger logger = LoggerFactory.getLogger( this.getClass() );
    private final String BASE_URL = "https://open.spotify.com/";

    @BeforeClass
    private void setUp( ITestContext context )
    {
        WebDriverManager.chromedriver().setup();
        driver = BrowserUtils.resolveDriver( context );
        driver.get( BASE_URL );
//        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    private void testPageOne()
    {
        spotifyPageOne = new SpotifyPageOne( driver );
        spotifyPageOne.clickLogin();
    }

    @Test(priority = 1)
    private void testPageTwo()
    {
        spotifyPageTwo = new SpotifyPageTwo( driver );
        try
        {
            List<String> s = PropertiesLoader.getProperties();
            String email = s.get( 0 );
            logger.info( "Retrieved email: " + email );
            String password = s.get( 1 );
            logger.info( "Retrieved password: " + password );
            spotifyPageTwo.enterLoginInfo( email, password );
        }
        catch ( Exception e )
        {
            logger.info( e.getMessage() );
        }
    }

    @Test(priority = 2)
    private void testPageThree()
    {
        spotifyPageThree = new SpotifyPageThree( driver );
        spotifyPageThree.verifyElementPresence();
        spotifyPageThree.testPlaybar();
        spotifyPageThree.logout();
    }

    @AfterClass
    private void tearDown()
    {
        driver.quit();
    }
}
