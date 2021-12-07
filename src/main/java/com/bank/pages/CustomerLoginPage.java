package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends Utility {

        public CustomerLoginPage() {
            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "userSelect")
        WebElement lcDropDownYourName;

        @FindBy(xpath = "//button[contains(text(),'Login')]")
        WebElement lcButtonLogin;

        @FindBy(xpath = "//label[normalize-space()='Your Name :']")
        WebElement lcLabelYourName;


        public void verifyIfTextIsDisplayed(String textToBeVerified) {
            verifyIfGetTextOfElementIsMatchedWithExpectedTextOfElement(lcLabelYourName, textToBeVerified);
        }

        public void selectCustomerFromYourNameDropDown(String text) {
            selectByVisibleTextFromDropDown(lcDropDownYourName, text);
            waitUntilVisibilityOfElementLocated(lcButtonLogin, 2);
        }

        public void clickOnLoginButton() {
            clickOnElement(lcButtonLogin);
        }

        public String actualTextFromYourNameLabel() {
            return getTextFromElement(lcLabelYourName);
        }

        public String expectedTextFromYourNameLabel(String text) {
            return text;
        }


    }



