package com.octave.octave_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpotifyPageTwo
{
    private WebDriver driver;
    private Logger logger = LoggerFactory.getLogger( this.getClass() );

    @FindBy( id = "login-username" )
    private WebElement username;

    @FindBy( id = "login-password" )
    private WebElement password;

    @FindBy( className = "ng-binding" )
    private WebElement rememberCheckbox;

    @FindBy( id = "login-button" )
    private WebElement loginButton;

    @FindBy( id = "[data-testid=\"user-widget-link\"]" )
    private WebElement profileLink;

    public SpotifyPageTwo( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( driver, this );
    }

    protected boolean enterLoginInfo( String user, String pass )
    {
        WebDriverWait wait = new WebDriverWait( driver, 60 );
        wait.until( ExpectedConditions.visibilityOf( username ) );
        username.sendKeys( user );
        password.sendKeys( pass );

        if ( rememberCheckbox.isSelected() )
        {
            rememberCheckbox.click();
        }

        loginButton.click();
        return true;

    }
}
