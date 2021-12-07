package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends Utility {

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement lcFirstNameInputBox;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lcLastNameInputBox;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement lcPostCodeInputBox;

    @FindBy(css = "button[type='submit']")
    WebElement lcAddCustomerButtonByCss;

    @FindBy(xpath = "//label[contains(text(),'First Name :')]")
    WebElement lcFirstNameLabel;


    public void verifyMessageFromPopUpAlertBoxContains(String expectedMessage){
        verifyIfActualMessageFromAlertContainsExpectedText(expectedMessage);
    }

    public void fillInFirstName(String text) {
        sendTextToElement(lcFirstNameInputBox, text);
    }

    public void fillInLastName(String text) {
/*        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lcFirstNameLabel));*/

        sendTextToElement(lcLastNameInputBox, text);
    }

    public void fillInPostCode(String text) {
        sendTextToElement(lcPostCodeInputBox, text);
        waitUntilElementToBeClickable(lcAddCustomerButtonByCss);
    }

    public void clickOnAddCustomerButton() {
        clickOnElement(lcAddCustomerButtonByCss);
    }

    public String actualMessageInPopUp() {
        System.out.println(getTextFromAlert());
        return getTextFromAlert();
    }

    public String expectedMessageInPopUp(String text) {
        return text;
    }

    public void clickOnOkButtonFromMessagePopUp() {
        switchToAlertAndAccept();
    }



}
