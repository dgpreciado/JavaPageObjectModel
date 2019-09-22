package com.pages;

import com.base.TestBase;
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
    WebElement unCheckedbox;
    @FindBy(css = ".checked > label")
    WebElement checkedCheckbox;
    @FindBy(css = "a[href='/contacts/new']")
    WebElement newButton;

    public ContactsPage(){
        PageFactory.initElements(driver , this);
    }

    public String verifyContactHeaderText(){
        return contactLabel.getText();
    }
    public boolean verifyCheckboxChecked(){/*custom xpath*/
        unCheckedbox.click();
        return checkedCheckbox.isDisplayed();
    }
    public boolean findContactByName(String name){
        return driver.findElement(By.xpath("//td[contains(text(),"+ name +")]")).isDisplayed();
    }
    public boolean selectContactsByName(String name){
        driver.findElement(By.xpath("//td[contains(text(),"+ name +
                ")]//parent::tr//preceding-sibling::td/div")).click();
        return driver.findElement(By.xpath("//td[contains(text(),"+ name +
                ")]//parent::tr//preceding-sibling::td/div/input")).isSelected();
    }
    public void clickNewButton(){
        newButton.click();
    }
}
