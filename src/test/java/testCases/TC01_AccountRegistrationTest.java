package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() {

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(randomString().toUpperCase());
        regPage.setLastName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "@gmail.com");         //randomly generate emails
        regPage.setTelephone(randomNumber());

        String pwd =  randomAlphaNumeric();
        regPage.setPassword(pwd);
        regPage.setConfirmPassword(pwd);

        regPage.clickCheckPolicy();
        regPage.clickContinue();

        String confmsg = regPage.getMessageConfirmation();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");

    }


}
