package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    /* This is a utility method to switch to a frame in the page that *
    *  contains a element we need (not used in this instance)*/
    /*in the Page that uses this method, add a "TestUtil testUtil" global variable.
    * then add in the @BeforeMethod "testUtil = new TestUtil();" */
    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }
}
