package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(css = "No records found")
    WebElement noRecordsFound;
    @FindBy(css = "#dashboard-toolbar > div.ui.header.item.mb5.light-black")
    WebElement contactLabel;
    @FindBy(css = ".read-only > label")
    WebElement unCheckedkbox;
    @FindBy(css = ".checked > label")
    WebElement checkedCheckbox;

    public ContactsPage(){
        PageFactory.initElements(driver , this);
    }

    public String verifyContactHeaderText(){
        return contactLabel.getText();
    }
    public boolean verifyCheckboxChecked(){/*custom xpath*/
        unCheckedkbox.click();
        return checkedCheckbox.isDisplayed();
    }
}
