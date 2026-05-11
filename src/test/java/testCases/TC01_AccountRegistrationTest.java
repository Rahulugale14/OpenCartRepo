package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() {

        logger.info("*** Starting test case TC01_AccountRegistrationTest --> to verify Account Registration Test ***");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount link");
            hp.clickRegister();
            logger.info("Clicked on Register link");

            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            logger.info("Providing customer details");
            regPage.setFirstName(randomString().toUpperCase());
            regPage.setLastName(randomString().toUpperCase());
            regPage.setEmail(randomString() + "@gmail.com");         //randomly generate emails
            regPage.setTelephone(randomNumber());

            String pwd = randomAlphaNumeric();
            regPage.setPassword(pwd);
            regPage.setConfirmPassword(pwd);

            regPage.clickCheckPolicy();
            regPage.clickContinue();

            logger.info("Validating expected message...");
            String confmsg = regPage.getMessageConfirmation();
            if(confmsg.equals("Your Account Has Been Created!!!")){     //TO FAIL TEST CASE, used two !! using if else block
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test failed...");
                logger.debug("Debug logs...");
                Assert.assertTrue(false);
            }

        }
        catch (Exception e) {
            Assert.fail();
        }

        logger.info("*** Finished test case TC01_AccountRegistrationTest ***");

    }


}
