package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
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
    public void selectContactsByName(String name){
        /* attempted to check a checkbox by targeting the customer name afterwards.
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
                + "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
         */
    }
}
