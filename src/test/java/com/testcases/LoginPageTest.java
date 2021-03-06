package com.testcases;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        //calls TestBase constructor so setUp() can call initialization.
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        driver.navigate().to("https://ui.freecrm.com/");
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals( title , "CRM");
    }

    @Test(priority = 2)
    public void loginPageEmailIconDisplayedTest(){
        //Assert.assertEquals(loginPage.validateEmailIcon() , true);
        boolean eIcon = loginPage.validateEmailIcon();
        Assert.assertTrue(eIcon);
    }

    @Test(priority = 3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("userEmail") , prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
