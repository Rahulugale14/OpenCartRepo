package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)      //getting data provider from different class
    public void verify_LoginDDT(String email, String pwd, String exp) {

        logger.info("***** Starting TC003_LoginDDT *****");

        try {
            //HomePage
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLogin();

            //MyAccountPage
            MyAccountPage macpg = new MyAccountPage(driver);
            boolean targetPage = macpg.isMyAccountPageExist();



        /*
        Data is valid - login successful - Test passed - logout
        Data is valid - login unsuccessful - Test failed

        Data is invalid - Test failed

        */

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage) {
                    macpg.clickLogout();
                } else {
                    Assert.fail("Valid login failed for email: " + email);
                }
            }
            else if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    macpg.clickLogout();
                }
                Assert.fail("Invalid login data from Excel should fail. Email: " + email);
            }
            else {
                Assert.fail("Unknown expected result in Excel for email " + email + ": " + exp);
            }

        }
        catch (Exception e) {
           Assert.fail("Login DDT test failed due to exception: " + e.getMessage());
        }

        logger.info("***** Ending TC003_LoginDDT *****");

    }

}
