package com.pages;

import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsNewContact extends TestBase {

    @FindBy(name = "source")
    WebElement sourceDropDown;
    @FindBy(name = "first_name")
    WebElement firstName;
    @FindBy(name = "last_name")
    WebElement lastName;
    @FindBy(xpath = "//div[@name='company']/input")
    WebElement company;
    @FindBy(css = "button.linkedin")
    WebElement saveButton;

    //to toggle - document.getElementsByName("do_not_call")[0].click()
    //@FindBy(xpath = "//input[@type ='submit' and @value = 'Save']")
    //WebElement multi;
    //-xpath > //div[text() [contains(.,'test test')]]
    //-xpath > //div[text()='test test']

    public ContactsNewContact(){
        PageFactory.initElements(driver,this);
    }

    public boolean sourceDropDownSelectable(String sourceText){
//        below doesnt work because menu uses divs
//        Select select = new Select(driver.findElement(sourceDropDown));
//        select.deselectByVisibleText("Google");
        sourceDropDown.click();
        driver.findElement(By.xpath("//span[text()='"+sourceText+"']")).click();
        return driver.findElement(By.xpath("//div[text()='"+sourceText+"']")).isDisplayed();
    }
    public void createNewContact(String ftName, String ltName, String comp) throws InterruptedException {
        //Select select = new Select(driver.findElement(By.name("title")));
        //select.selectByVisibleText(title);
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        System.out.println("name done ");
        company.sendKeys(comp);
        //send to company field: document.getElementsByName("company")[0].getElementsByTagName("input")[0].value  = "test";
        System.out.println("company done ");
        saveButton.click();
        //Thread.sleep(6000);
    }
}
