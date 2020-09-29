package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private Boolean url = false;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyUrl() {
        if (driver.getCurrentUrl().contains("auth"))
            return url = true;
        return false;
    }

    @FindBy(how = How.ID, using = "email_create")
    private WebElement loginEmail;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement createAnAccount;

    @FindBy(how = How.XPATH, using = "//*[@id=\"id_gender1\"]")
    private WebElement title;

    @FindBy(how = How.ID, using = "customer_firstname")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "customer_lastname")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement password;

    @FindBy(how = How.ID, using = "days")
    private WebElement birthDay;

    @FindBy(how = How.ID, using = "months")
    private WebElement birthMonth;

    @FindBy(how = How.ID, using = "years")
    private WebElement birthYear;

    @FindBy(how = How.ID, using = "firstname")
    private WebElement addressFirstName;

    @FindBy(how = How.ID, using = "lastname")
    private WebElement addressSecondtName;

    @FindBy(how = How.ID, using = "address1")
    private WebElement address;

    @FindBy(how = How.ID, using = "city")
    private WebElement city;

    @FindBy(how = How.ID, using = "id_state")
    private WebElement state;

    @FindBy(how = How.ID, using = "postcode")
    private WebElement postalCode;

    @FindBy(how = How.ID, using = "id_country")
    private WebElement country;

    @FindBy(how = How.ID, using = "phone_mobile")
    private WebElement mobileNumber;

    @FindBy(how = How.ID, using = "submitAccount")
    private WebElement registerButton;

    public void enterEmailID(String email) {
        loginEmail.sendKeys(email);
    }

    public void clickOnCreateAnAccount() {
        createAnAccount.click();
    }

    public void enterTitle()  {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender1\"]")));
        title.click();
    }

    public void enterFirstName(String nameValue) {
        scrollAndEnterText(firstName, nameValue);
    }

    public void enterLastName(String nameValue) {
        scrollAndEnterText(lastName, nameValue);
    }

    public void enterPassword(String passwordValue) {
        scrollAndEnterText(password, passwordValue);
    }

    public void scrollAndEnterText(WebElement scrollToElement, String elementInputValue) {
        Actions actions = new Actions(driver);
        actions.moveToElement(scrollToElement).build().perform();
        scrollToElement.click();
        scrollToElement.sendKeys(elementInputValue);
    }

    public void selectBirthDay(int day) {
        birthDay.click();
        Select days = new Select(driver.findElement(By.id("days")));
        days.selectByIndex(day);
    }

    public void selectBirthMonth(int month) {
        birthMonth.click();
        Select months = new Select(driver.findElement(By.id("months")));
        months.selectByIndex(month);
    }

    public void selectBirthYear(String year) {
        birthYear.click();
        Select years = new Select(driver.findElement(By.id("years")));
        years.selectByValue(year);
    }

    public void enterAddressFirstName(String fName) {
        scrollAndEnterText(addressFirstName, fName);
    }

    public void enterAddresslastName(String lName) {
        scrollAndEnterText(addressSecondtName, lName);
    }

    public void enterAddress(String add) {
        scrollAndEnterText(address, add);
    }

    public void enterAddressCity(String cityAddress) {
        scrollAndEnterText(city, cityAddress);
    }

    public void enterAddressState(String stateAddress) {
        state.click();
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByIndex('1');
    }

    public void enterPostalCode(String zip) {
        scrollAndEnterText(postalCode, zip);
    }

    public void enterAddressCountry(String countryName) {
        country.click();
        Select state = new Select(driver.findElement(By.id("id_country")));
        state.selectByIndex('1');
    }

    public void enterMobile(String mobileNum) {
        scrollAndEnterText(mobileNumber, mobileNum);
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }
}
