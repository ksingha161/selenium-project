package com.octave.octave_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpotifyPageOne
{
    private WebDriver driver;
    private Logger logger = LoggerFactory.getLogger( this.getClass() );

    @FindBy( css = "[data-testid=\"login-button\"]")
    private WebElement loginButton; //should always be private

    public SpotifyPageOne( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    protected boolean clickLogin()
    {
        WebDriverWait wait = new WebDriverWait( driver, 60 );
        wait.until( ExpectedConditions.elementToBeClickable( loginButton ) );
        logger.info( "Clicking on login button" );
        loginButton.click();
        return true;
    }

}
