package com.pages;

import com.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends TestBase {
    public DealsPage(){
        PageFactory.initElements(driver , this);
    }
}
