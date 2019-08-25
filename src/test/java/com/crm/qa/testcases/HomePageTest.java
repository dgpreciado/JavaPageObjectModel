package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("userEmail") , prop.getProperty("password"));
    }
    @Test
    public void verifyHomePageTitleTest(){
        Assert.assertEquals(homePage.verifyHomePageTitle(),"CRM","Home Page title did not match");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
