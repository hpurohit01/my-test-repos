package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement lcTabCustomerLogin;
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement lcTabBankManagerLogin;
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement lcTabAddCustomer;


    public void clickOnBankManagerLoginTab() {
        clickOnElement(lcTabBankManagerLogin);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(lcTabAddCustomer));
    }

    public void clickOnCustomerLoginTab() {
        clickOnElement(lcTabCustomerLogin);
    }


}
