package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement textFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement textLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement textEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement textTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement textPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement textPasswordConfirm;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkedPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement messageConfirmation;

    public void setFirstName(String firstName) {
        textFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        textLastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        textEmail.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        textTelephone.sendKeys(telephone);
    }

    public void setPassword(String password) {
        textPassword.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        textPasswordConfirm.sendKeys(confirmPassword);
    }

    public void clickCheckPolicy() {
        checkedPolicy.click();
    }

    public void clickContinue() {
        btnContinue.click();

        /*

        Solution1 -->
        btnContinue.submit();

        Solution2 -->
        Actions act = new Actions(driver)
        act.moveToElement(btnContinue).click().perform();

        Solution3 -->
        JavascriptExecutor js = (JavascriptExecutor)driver;
        s.executeScript("arguments[0].click();", btnContinue);

        Solution4 -->
        btnContinue.sendKeys(Keys.RETURN);

        Solution5 -->
        WebDriverWait myWait = new WebDriverWait(driver, DurationOfSeconds(10))
        myWait.until(ExpectedConditions.elemntToBeClickable(btnContinue)).click();

         */
    }

    public String getMessageConfirmation() {
        messageConfirmation.click();

        try {
            return (messageConfirmation.getText());
        }
        catch (Exception e) {
            return (e.getMessage());
        }

    }


}
