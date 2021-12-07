package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Utility {


        public CustomersPage() {
            PageFactory.initElements(driver, this);
        }

        @FindBy(name = "Logout")
        WebElement lcTabLogout;
        @FindBy(xpath = "//button[normalize-space()='Logout']")
        WebElement lcTabLogoutByXpath;
        @FindBy(xpath = "//button[normalize-space()='Transactions']")
        WebElement lcTabTransactions;
        @FindBy(xpath = "//button[normalize-space()='Deposit']")
        WebElement lcTabDeposit;
        @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
        WebElement lcTabWithdrawl;
        @FindBy(xpath = "//input[@placeholder='amount']")
        WebElement lcAmountInputBox;
        @FindBy(xpath = "//button[@type='submit' and contains(text(),'Deposit')]")
        WebElement lcButtonDeposit;
        @FindBy(xpath = "//span[@class='error ng-binding' and contains(text(),'Deposit Successful')]")
        WebElement lcMessageDepositSuccess;
        @FindBy(css = "input[placeholder='amount']")
        WebElement lcAmountWithdrawlInputBoxByCss;
        @FindBy(css = "button[type='submit']")
        WebElement lcButtonWithdrawalByCss;
        @FindBy(xpath = "//span[@class='error ng-binding']")
        WebElement lcMessageWithdrawalSuccessByXpath;

        public void verifyIfTextIsDisplayed(String textToBeVerified){
            verifyIfGetTextOfElementIsMatchedWithExpectedTextOfElement(lcMessageDepositSuccess,textToBeVerified);
        }

        public void verifyMessageFromPopUpAlertBoxContains(String expectedMessage){
            verifyIfActualMessageFromAlertContainsExpectedText(expectedMessage);
        }

        public void verifyLogoutTabDisplayed() throws InterruptedException {
            waitUntilVisibilityOfElementLocatedAndTextContains(lcTabLogoutByXpath,"Logout",2);
        }

        public String actualMessageOfWithdrawalTransactionSuccess() {
            return getTextFromElement(lcMessageWithdrawalSuccessByXpath);
        }

        public String expectedMessageOfWithdrawalTransactionSuccess(String text) {
            return text;
        }

        public void clickOnWithdrawalButton() {
            clickOnElement(lcButtonWithdrawalByCss);
        }

        public void fillInWithdrawalAmount(String amount) {
            sendTextToElement(lcAmountWithdrawlInputBoxByCss, amount);
        }

        public void clickOnWithdrawalTab() {
            clickOnElement(lcTabWithdrawl);
        }

        public void clickOnLogoutButton() {
            clickOnElement(lcTabLogout);
        }

        public String actualTextFromLogoutTab() {
            return getTextFromElement(lcTabLogoutByXpath);
        }

        public String expectedTextFromLogoutTab(String text) {
            return text;
        }

        public void clickOnDepositTab() {
            clickOnElement(lcTabDeposit);
        }

        public void fillInAmount(String amount) {
            sendTextToElement(lcAmountInputBox, amount);
        }

        public void clickOnDepositButton() {
            clickOnElement(lcButtonDeposit);
        }

        public String actualMessageOfDepositSuccess() {
            return getTextFromElement(lcMessageDepositSuccess);
        }

        public String expectedMessageOfDepositSuccess(String text) {
            return text;
        }

    }


