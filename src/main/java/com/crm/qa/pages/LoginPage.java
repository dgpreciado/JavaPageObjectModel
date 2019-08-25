package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory or object repository
    @FindBy(name = "email")
    WebElement userEmailAddress;

    @FindBy(name = "password")
    WebElement userPassword;

    @FindBy(css = ".fluid")//.submit
    WebElement loginBtn;

    @FindBy(linkText = "Forgot your password?")
    WebElement forgotYourPassword;

    @FindBy(linkText = "Classic CRM")
    WebElement loginToClassicCrmLink;

    //@FindBy(linkText = "Sign Up")
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpLink;

    @FindBy(css = "i.user")
    WebElement emailIcon;

    @FindBy(css = "i.lock")
    WebElement passwordIcon;

    /*initialize the page object*/
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    /*Actions:*/
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean validateEmailIcon(){
        return emailIcon.isDisplayed();
    }
    public boolean validatePasswordIcon(){
        return passwordIcon.isDisplayed();
    }
    public HomePage login(String un , String pwd){
        userEmailAddress.sendKeys(un);
        userPassword.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }
}
