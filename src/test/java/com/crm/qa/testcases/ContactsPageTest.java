package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;

    public ContactsPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();/*might not be needed*/
        homePage = loginPage.login(prop.getProperty("userEmail") , prop.getProperty("password"));
        homePage.clickOnContactsLink();
    }
    @Test
    public void contactLabel(){
        Assert.assertEquals( contactsPage.verifyContactHeaderText(),"Contacts");
    }
    @Test
    public void find_a_contact(){
        Assert.assertTrue( contactsPage.findContactByName("fname") );
    }
    @Test
    public void select_a_contact() throws InterruptedException {
        Assert.assertTrue( contactsPage.selectContactsByName("fname") );

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
