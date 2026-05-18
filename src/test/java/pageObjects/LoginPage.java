package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement textEmailAddress;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement textPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement buttonLogin;

    public void setEmail(String email){
        textEmailAddress.sendKeys(email);
    }

    public void setPassword(String pwd){
        textPassword.sendKeys(pwd);
    }

    public void clickLogin(){
        buttonLogin.click();
    }


}
