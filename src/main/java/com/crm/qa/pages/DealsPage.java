package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends TestBase {
    public DealsPage(){
        PageFactory.initElements(driver , this);
    }
}
