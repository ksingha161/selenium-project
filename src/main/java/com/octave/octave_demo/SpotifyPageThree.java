package com.octave.octave_demo;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WebDriverUtils;

public class SpotifyPageThree
{
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger( this.getClass() );
    Actions actions;

    @FindBy( css = "section[aria-label='Recently played'] div:nth-child(1) div:nth-child(1) div:nth-child(3)" )
    private WebElement firstItemHover;

    @FindBy( css = "[data-testid=\"playback-progressbar\"]" )
    private WebElement playbackBar;

    @FindBy( css = "[data-testid=\"playback-position\"]" )
    private WebElement playbackPosition;

    @FindBy( css = "[data-testid=\"playback-duration\"]" )
    private WebElement playbackDuration;

    @FindBy( css = "[data-testid=\"nowplaying-track-link\"]")
    private WebElement nowplayingTrack;

    @FindBy( css = "[data-testid=\"control-button-shuffle\"]")
    private WebElement shuffleButton;

    @FindBy( css = "[data-testid^=\"control-button-p\"]")
    private WebElement pauseButton;

    @FindBy( css = "[data-testid=\"control-button-skip-forward\"]")
    private WebElement nextButton;

    @FindBy( css = "footer[class='_82a78ff58d3fcba0cb9b8083fe6dd05c-scss'] button[title='Previous']")
    private WebElement prevButton;

    @FindBy( css = "[data-testid=\"control-button-repeat\"]" )
    private WebElement repeatButton;

    @FindBy( id = "onetrust-close-btn-container")
    private WebElement cookie;

    @FindBy( css = "footer[class='_82a78ff58d3fcba0cb9b8083fe6dd05c-scss'] button[aria-label='Change progress']")
    private WebElement slider;

    @FindBy( css = "[data-testid=\"user-widget-link\"]" )
    private WebElement profileDropdown;

    @FindBy( css = "[data-testid=\"user-widget-dropdown-logout\"]" )
    private WebElement logoutButton;

    @FindBy( css = "[data-testid=\"login-button\"]")
    private WebElement loginButton;

    @FindBy( css = "[data-testid=\"pip-toggle-button\"]")
    private WebElement pipToggle;

    @FindBy( css = "footer[class='_82a78ff58d3fcba0cb9b8083fe6dd05c-scss'] button[title='Save to Your Library']")
    private WebElement saveToLibrary;

    @FindBy( xpath = "//button[@aria-label='Remove from Your Library']")
    private WebElement removeFromLibrary;

    @FindBy( css = "[data-testid=\"control-button-undefined\"]")
    private WebElement controlButton;

    @FindBy( xpath = "//button[@aria-label='Connect to a device']" )
    private WebElement connectDevice;

    @FindBy( css = "div[class='connect-device-list-content']" )
    private WebElement connectDeviceContainer;

    @FindBy( css = "[data-testid=\"volume-bar\"]")
    private WebElement volumeBar;

    @FindBy( css = "footer[class='_82a78ff58d3fcba0cb9b8083fe6dd05c-scss'] button[aria-label='Change volume']")
    private WebElement volumeSlider;

    @FindBy( css = "[data-testid=\"progress-bar\"]")
    private WebElement progressBar;

    public SpotifyPageThree( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    protected boolean verifyElementPresence()
    {
        WebDriverWait wait = new WebDriverWait( driver, 100 );
        wait.until( ExpectedConditions.visibilityOf( firstItemHover ) );
        if ( cookie.isDisplayed() )
        {
            cookie.click();
        }
        wait.until( ExpectedConditions.visibilityOf( nowplayingTrack ) );
        logger.info( "Asserting that playback bar is displayed" );
        WebDriverUtils.verifyIsDisplayed( playbackBar );
        logger.info( "Asserting that playback position is 0" );
        logger.info( playbackPosition.getText() );
        Assert.assertTrue( playbackPosition.getText().equals( "0:00" ) );
        logger.info( "Asserting that playback duration is greater than 0" );
        logger.info( playbackDuration.getText() );
        Assert.assertTrue( playbackDuration.getText().length() > 0 );
        logger.info( "Asserting that now playing track is enabled" );
        WebDriverUtils.verifyIsEnabled( nowplayingTrack );
        logger.info( "Asserting that shuffle button is displayed" );
        WebDriverUtils.verifyIsDisplayed( shuffleButton );
        logger.info( "Asserting that pause button is displayed" );
        WebDriverUtils.verifyIsDisplayed( pauseButton );
        logger.info( "Asserting that next button is displayed" );
        WebDriverUtils.verifyIsDisplayed( nextButton );
        logger.info( "Asserting that previous button button is displayed" );
        WebDriverUtils.verifyIsDisplayed( prevButton );
        logger.info( "Asserting that repeat button is enabled" );
        WebDriverUtils.verifyIsEnabled( repeatButton );
        logger.info( "Asserting that save to library button is enabled" );
        WebDriverUtils.verifyIsEnabled( saveToLibrary );
        logger.info( "Asserting that control button is enabled" );
        WebDriverUtils.verifyIsEnabled( controlButton );
        logger.info( "Asserting volume bar track is enabled" );
        WebDriverUtils.verifyIsEnabled( volumeBar );
        return true;
    }

    protected boolean testPlaybar()
    {
        WebDriverUtils.jsClick( driver, nowplayingTrack );
        WebDriverUtils.jsClick( driver, shuffleButton );
        WebDriverUtils.jsClick( driver, pauseButton );
        // click again to pause the song, unless you want to listen
        WebDriverUtils.jsClick( driver, pauseButton );
        WebDriverUtils.jsClick( driver, nextButton );
        WebDriverUtils.jsClick( driver, prevButton );
        WebDriverUtils.jsClick( driver, repeatButton );

        //moves the now playing slider
        actions = new Actions( driver );
        actions.moveToElement( slider ).dragAndDropBy( slider, 300, 0 ).build().perform();
        WebDriverUtils.jsClick( driver, saveToLibrary );
        WebDriverUtils.jsClick( driver, removeFromLibrary );
        WebDriverUtils.jsClick( driver, controlButton );
        WebDriverUtils.jsClick( driver, connectDevice );
        try
        {
        wait.until( ExpectedConditions.visibilityOf( connectDeviceContainer ) );
        } catch ( Exception e ) {
            logger.warn( e.getMessage() );
            logger.warn( "Element not present, skipping step" );
        }
        // click again to close connectDeviceContainer
        WebDriverUtils.jsClick( driver, connectDevice );
        actions.moveToElement( progressBar ).build().perform();
        return true;
    }

    protected boolean logout()
    {
        WebDriverWait wait = new WebDriverWait( driver, 100 );
        wait.until( ExpectedConditions.visibilityOf( profileDropdown ) );
        WebDriverUtils.jsClick( driver, profileDropdown );
        wait.until( ExpectedConditions.visibilityOf( logoutButton ) );
        WebDriverUtils.jsClick( driver, logoutButton );
        wait.until( x -> loginButton.isDisplayed() );
        return true;
    }
}
