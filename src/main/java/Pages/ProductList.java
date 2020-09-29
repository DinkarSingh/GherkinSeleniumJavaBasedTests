package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductList {

    private WebDriver driver;
    private Boolean url = false;

    public ProductList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement productMainMenu;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement product;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Add to cart')]")
    private WebElement addToCart;

    @FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
    private WebElement productConfirmationPop;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedCheckout;

    @FindBy(how = How.XPATH, using = "//a[contains(@class,'standard-checkout button-medium')]")
    private WebElement summeryCheckout;

    @FindBy(how = How.XPATH, using = "//*[contains(@name,'processAddress')]")
    private WebElement addressCheckout;

    @FindBy(how = How.ID, using = "cgv")
    private WebElement agreeCheckBox;

    @FindBy(how = How.XPATH, using = "//*[contains(@name,'processCarrier')]")
    private WebElement shippingCheckout;

    @FindBy(how = How.ID, using = "step_end")
    private WebElement payment;

    public void clickOnMainMenu() {
        productMainMenu.click();
        product.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add to cart')]")));
        addToCart.click();
    }

    public boolean isProductAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")));
        return productConfirmationPop.isDisplayed();
    }

    public void clickOnProceedCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Proceed to checkout')]")));
        proceedCheckout.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(summeryCheckout).build().perform();
        summeryCheckout.click();
        actions.moveToElement(addressCheckout).build().perform();
        addressCheckout.click();
        actions.moveToElement(agreeCheckBox).build().perform();
        agreeCheckBox.click();
        shippingCheckout.click();
    }

    public boolean isPaymentMethodsDisplaying() {
        return payment.isDisplayed();
    }

}
