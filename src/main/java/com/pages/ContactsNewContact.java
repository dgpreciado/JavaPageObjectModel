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
    WebElement companyInput;
    @FindBy(css = "button.linkedin")
    WebElement saveButton;



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
}
