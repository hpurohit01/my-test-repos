package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage extends Utility {
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[contains(text(),'Customer :')]")
    WebElement lcCustomerLabel;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement lcDropDownCustomer;
    @FindBy(xpath = "//select[@id='currency']")
    WebElement lcDropDownCurrency;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement lcButtonProcess;

    public void verifyMessageFromPopUpAlertBoxContains(String expectedMessage){
        verifyIfActualMessageFromAlertContainsExpectedText(expectedMessage);
    }

    public void selectCustomerFromDropDownCustomer(String name) {
        clickOnElement(lcDropDownCustomer);
        selectByVisibleTextFromDropDown(lcDropDownCustomer, name);
    }

    public void selectCurrencyFromDropDownCurrency(String currency) {
        clickOnElement(lcDropDownCurrency);
        selectByVisibleTextFromDropDown(lcDropDownCurrency, currency);
    }

    public void clickOnButtonProcess() {
        clickOnElement(lcButtonProcess);
    }

    public String actualMessageFromPopUp() {
        System.out.println(getTextFromAlert());
        return getTextFromAlert();
    }

    public String expectedMessageFromPopUp(String text) {
        return text;
    }

    public void clickOnButtonFromPopUp() {
        switchToAlertAndAccept();
    }

}
