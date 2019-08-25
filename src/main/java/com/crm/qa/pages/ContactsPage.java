package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {
    public ContactsPage(){
        PageFactory.initElements(driver , this);
    }
}
