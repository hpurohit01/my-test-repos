package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

    public class BankTest extends TestBase {

        AccountPage accountPage;
        AddCustomerPage addCustomerPage;
        BankManagerLoginPage bankManagerLoginPage;
        CustomerLoginPage customerLoginPage;
        CustomersPage customersPage;
        HomePage homePage;
        OpenAccountPage openAccountPage;

        @BeforeMethod
        public void inIt() {
            accountPage = new AccountPage();
            addCustomerPage = new AddCustomerPage();
            bankManagerLoginPage = new BankManagerLoginPage();
            customerLoginPage = new CustomerLoginPage();
            customersPage = new CustomersPage();
            homePage = new HomePage();
            openAccountPage = new OpenAccountPage();
        }

        //1.bankManagerShouldAddCustomerSuccessfully.
        @Test(groups = {"smoke", "sanity","regression"})
        public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {

            //click On "Bank Manager Login" Tab
            homePage.clickOnBankManagerLoginTab();
            Thread.sleep(1000);
            //click On "Add Customer" Tab
            bankManagerLoginPage.clickOnAddCustomerTab();
            Thread.sleep(1000);
            //enter FirstName
            addCustomerPage.fillInFirstName("Tom");
            Thread.sleep(1000);
            //enter LastName
            addCustomerPage.fillInLastName("Jerry");
            Thread.sleep(1000);
            //enter PostCode
            addCustomerPage.fillInPostCode("GL13ED");
            Thread.sleep(1000);
            //click On "Add Customer" Button
            addCustomerPage.clickOnAddCustomerButton();
            Thread.sleep(1000);
            //popup display
            //verify message "Customer added successfully"
            addCustomerPage.verifyMessageFromPopUpAlertBoxContains("Customer added successfully");
            Thread.sleep(1000);
            //click on "ok" button on popup.
            addCustomerPage.clickOnOkButtonFromMessagePopUp();
            Thread.sleep(1000);
        }

        //2. bankManagerShouldOpenAccountSuccessfully.
        @Test (groups = {"sanity","regression"}, priority = 1)
        @Parameters({"currency1", "currency2", "currency3"})
        public void bankManagerShouldOpenAccountSuccessfully(String currency1, String currency2, String currency3) throws InterruptedException {
            //click On "Bank Manager Login" Tab
            homePage.clickOnBankManagerLoginTab();
            //click On "Open Account" Tab
            bankManagerLoginPage.clickOnOpenAccountTab();
            //Search customer that created in first test
            openAccountPage.selectCustomerFromDropDownCustomer("micky mouse");
            // openAccountPage.selectCustomerFromDropDownCustomer("Ron Weasly");
            Thread.sleep(1000);
            //Select currency "Pound"
            openAccountPage.selectCurrencyFromDropDownCurrency(currency2);
            Thread.sleep(1000);
            //click on "process" button
            openAccountPage.clickOnButtonProcess();
            //popup displayed
            //verify message "Account created successfully"
            openAccountPage.verifyMessageFromPopUpAlertBoxContains("Account created successfully");
            //click on "ok" button on popup.
            openAccountPage.clickOnButtonFromPopUp();
            Thread.sleep(3000);
        }

        //3. customerShouldLoginAndLogoutSuccessfully.
        @Test (groups = {"sanity","regression"}, priority = 2)
        public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
            //click on "Customer Login" Tab
            homePage.clickOnCustomerLoginTab();
            Thread.sleep(1000);
            //search customer that you created.
            customerLoginPage.selectCustomerFromYourNameDropDown("micky mouse");
            Thread.sleep(1000);
            //click on "Login" Button
            customerLoginPage.clickOnLoginButton();
            Thread.sleep(1000);
            //verify "Logout" Tab displayed.
            customersPage.verifyLogoutTabDisplayed();
            Thread.sleep(1000);
            //click on "Logout"
            customersPage.clickOnLogoutButton();
            Thread.sleep(1000);
            //verify "Your Name" text displayed.
            customerLoginPage.verifyIfTextIsDisplayed("Your Name :");

        }

        //4. customerShouldDepositMoneySuccessfully.
        @Test (groups = {"regression"}, priority = 3)
        public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
            //click on "Customer Login" Tab
            homePage.clickOnCustomerLoginTab();
            Thread.sleep(1000);
            //search customer that you created.
            customerLoginPage.selectCustomerFromYourNameDropDown("micky mouse");
            Thread.sleep(1000);
            //click on "Login" Button
            customerLoginPage.clickOnLoginButton();
            Thread.sleep(1000);
            //click on "Deposit" Tab
            customersPage.clickOnDepositTab();
            Thread.sleep(1000);
            //Enter amount 100
            customersPage.fillInAmount("100");
            Thread.sleep(1000);
            //click on "Deposit" Button
            customersPage.clickOnDepositButton();
            Thread.sleep(1000);
            //verify message "Deposit Successful"
            customersPage.verifyIfTextIsDisplayed("Deposit Successful");
        }

        //5. customerShouldWithdrawMoneySuccessfully
        @Test (groups = {"regression"}, priority = 4)
        public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
            //click on "Customer Login" Tab
            homePage.clickOnCustomerLoginTab();
            Thread.sleep(1000);
            //search customer that you created.
            customerLoginPage.selectCustomerFromYourNameDropDown("micky mouse");
            Thread.sleep(1000);
            //click on "Login" Button
            customerLoginPage.clickOnLoginButton();
            Thread.sleep(1000);
            //click on "Withdrawl" Tab
            customersPage.clickOnWithdrawalTab();
            Thread.sleep(1000);
            //Enter amount 50
            customersPage.fillInWithdrawalAmount("50");
            Thread.sleep(1000);
            //click on "Deposit" Button
            customersPage.clickOnWithdrawalButton();
            Thread.sleep(1000);
            //verify message "Transaction Successful"
            customersPage.verifyIfTextIsDisplayed("Transaction successful");
        }

    }

