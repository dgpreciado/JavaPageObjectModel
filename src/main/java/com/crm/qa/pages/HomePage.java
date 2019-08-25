package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    /*css class*/
    @FindBy(css = "span.user-display")
    WebElement usernameLabel;

    /*xpath inner text*/
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement HomeLink;

    /*xpath inner text*/
    @FindBy(xpath = "//a[contains(.,'Calendar')]")
    WebElement calenderLink;

    /*link text*/
    @FindBy(linkText = "Contacts")
    WebElement contactsLink;

    /*xpath href*/
    @FindBy(xpath = "//a[contains(@href, '/companies')]")
    WebElement companiesLink;

    /*css finder*/
    @FindBy(css = "#main-nav > .item:nth-child(5)")
    WebElement dealsLink;

    /*xpath id relative*/
    @FindBy(xpath = "//div[@id='main-nav']/a[6]")
    WebElement tasksLink;

    /*xpath position*/
    @FindBy(xpath = "//a[7]")
    WebElement casesLink;

    /*link text*/
    @FindBy(linkText = "Calls")
    WebElement callsLink;

    public boolean verifyUserNameAppears(){
        return usernameLabel.isDisplayed();
    }
    public HomePage(){
        PageFactory.initElements(driver , this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }
    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }

}
