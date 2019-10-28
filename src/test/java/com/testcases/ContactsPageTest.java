package com.testcases;

import com.base.TestBase;
import com.pages.ContactsNewContact;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.TestUtil;
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
    ContactsNewContact contactsNewContact;

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
        contactsNewContact = new ContactsNewContact();
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
    public void select_a_contact() {
        Assert.assertTrue( contactsPage.selectContactsByName("fname") );
    }
    @Test
    public void validateNewContact() throws InterruptedException {
        contactsPage.clickNewButton();
        contactsNewContact.createNewContact("ftest1", "ltest1", "ctest1");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
