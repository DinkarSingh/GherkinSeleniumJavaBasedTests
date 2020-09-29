package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    WebDriver driver;
    Boolean url = false;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyUrl() {
        if (driver.getCurrentUrl().contains("authentication"))
            return url = true;
        return false;
    }

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Sign in')]")
    private WebElement signIn;

    public void clickOnSignButton() {
        signIn.click();
    }

    public boolean verifyIsSignInDisplayed() {
        return signIn.isDisplayed();
    }
}

