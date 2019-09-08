package com.testcases;

import com.base.TestBase;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();/*might not be needed*/
        homePage = loginPage.login(prop.getProperty("userEmail") , prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        Assert.assertEquals(homePage.verifyHomePageTitle(),"CRM","Home Page title did not match");
    }
    @Test(priority = 2)
    public void verifyUserNameAppears(){
        Assert.assertTrue(homePage.verifyUserNameAppears());
    }
    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        contactsPage = homePage.clickOnContactsLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://ui.freecrm.com/contacts");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
