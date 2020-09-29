package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private WebDriver driver;
    private Boolean url = false;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/h1")
    private WebElement accountTitle;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign out')]")
    private WebElement signOut;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'account')]")
    private WebElement account;

    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Order')]")
    private WebElement orders;

    @FindBy(how = How.XPATH, using = " //span[contains(text(),'Order history')]")
    private WebElement ordersList;

    public String myAccountLabel() {
        return accountTitle.getText();
    }

    public boolean isSignOutButtonDisplaying() {
        return signOut.isDisplayed();
    }

    public void clickOnUserAccount() {
        Actions actions = new Actions(driver);
        actions.moveToElement(account).build().perform();
        account.click();
    }

    public void clickOnOrderList() {
        Actions actions = new Actions(driver);
        actions.moveToElement(orders).build().perform();
        orders.click();
    }

    public boolean isOrderListDisplaying() {
        return ordersList.isDisplayed();
    }
}
