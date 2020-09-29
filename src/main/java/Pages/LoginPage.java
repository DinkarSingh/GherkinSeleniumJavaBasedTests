package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    private WebDriver driver;
    private Boolean url = false;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyUrl() {

        if (driver.getCurrentUrl().contains("auth"))
            return url = true;
        return false;
    }

    @FindBy(how = How.ID, using = "email")
    private WebElement loginEmail;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement loginPassword;

    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement loginButton;

    public void enterEmail(String name) {
        loginEmail.clear();
        loginEmail.sendKeys(name);
    }

    public void enterPassword(String pasword) {
        loginPassword.clear();
        loginPassword.sendKeys(pasword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean verifyLoginButtonIsVisible() {
        return loginButton.isDisplayed();
    }

}
