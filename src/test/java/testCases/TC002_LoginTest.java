package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass   {

    @Test
    public void verify_login() {

        logger.info("***** Starting TC002_LoginTest *****");

        try {
            //homepage
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //loginpage
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(prop.getProperty("email"));
            lp.setPassword(prop.getProperty("password"));
            lp.clickLogin();

            //myaccountpage
            MyAccountPage macpg = new MyAccountPage(driver);
            boolean targetPage = macpg.isMyAccountPageExist();
            Assert.assertEquals(targetPage, true, "Login failed");
            // OR below
            //Assert.assertTrue(targetPage);
        }
        catch (Exception e) {
            Assert.fail();
        }

        logger.info("***** Ending TC002_LoginTest *****");

    }



}
