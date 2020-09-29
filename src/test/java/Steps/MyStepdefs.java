package Steps;

import Pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class MyStepdefs extends PersonalInfo {
    public WebDriver driver;

    @Before
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Shopping home page displaying")
    public void shopping_home_page_displaying() {
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
    }

    @When("Click on {string} button on home page")
    public void click_on_button_on_home_page(String string) {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSignButton();
    }

    protected String getTableValues(String headerValue, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String value = data.get(0).get(headerValue);
        return value;
    }

    @When("Enter the email id on text box")
    public void enter_the_email_id_on_text_box() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalInfo personalInfo = new PersonalInfo();
        String emailId = personalInfo.getEmail();
        registrationPage.enterEmailID(emailId);
    }

    @When("Enter the email address on text box")
    public void enter_the_email_address_on_text_box(DataTable dataTable) {
        String emailIdValue = getTableValues("email_id", dataTable);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        PersonalInfo personalInfo = new PersonalInfo();
        String emailId = personalInfo.getEmail();
        registrationPage.enterEmailID(emailId);
    }

    @When("Click on {string} button")
    public void click_on_button(String button) {
        switch (button) {
            case "create an account":
                RegistrationPage registrationPage = new RegistrationPage(driver);
                registrationPage.clickOnCreateAnAccount();
                break;
            case "Register":
                RegistrationPage registrationPage1 = new RegistrationPage(driver);
                registrationPage1.clickOnRegisterButton();
                break;
            case "Sign In":
                LoginPage loginPage = new LoginPage(driver);
                loginPage.clickLoginButton();
                break;
        }
    }

    @When("Enter the personal information for user")
    public void enter_the_personal_information_for_user(DataTable dataTable)  {
        PersonalInfo personalInfo = new PersonalInfo();
        String firstName = personalInfo.getFirstName();
        String lastName = personalInfo.getLastName();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterTitle();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        String password = getTableValues("password", dataTable);
        registrationPage.enterPassword(password);
        String dateOfBirth = getTableValues("date_of_birth", dataTable);
        String[] splittedDateOfBirth = dateOfBirth.split("/");
        String birthDay = splittedDateOfBirth[0];
        String birthMonth = splittedDateOfBirth[1];
        String birthYear = splittedDateOfBirth[2];
        int day = Integer.parseInt(birthDay);
        int month = Integer.parseInt(birthMonth);
        int year = Integer.parseInt(birthYear);
        registrationPage.selectBirthDay(day);
        registrationPage.selectBirthMonth(month);
        registrationPage.selectBirthYear(birthYear);
        String fName = getTableValues("address_First_name", dataTable);
        registrationPage.enterAddressFirstName(fName);
        String lName = getTableValues("address_Last_name", dataTable);
        registrationPage.enterAddresslastName(lName);
        String address = getTableValues("address", dataTable);
        registrationPage.enterAddress(address);
        String city = getTableValues("city", dataTable);
        registrationPage.enterAddressCity(city);
        String states = getTableValues("state", dataTable);
        registrationPage.enterAddressState(states);
        String zip = getTableValues("postal_code", dataTable);
        registrationPage.enterPostalCode(zip);
        String mobileNumber = getTableValues("mobile", dataTable);
        registrationPage.enterMobile(mobileNumber);
    }

    @Then("My account page displaying")
    public void my_account_page_displaying() {
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.isSignOutButtonDisplaying(), true);
    }

    @Given("Enter the User credentials")
    public void enter_the_User_credentials(DataTable dataTable) {
        String emailId = getTableValues("userID", dataTable);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(emailId);
        String userPassword = getTableValues("password", dataTable);
        loginPage.enterPassword(userPassword);
    }

    @When("Add the product in the cart")
    public void add_the_product_in_the_cart() {
        ProductList productList = new ProductList(driver);
        productList.clickOnMainMenu();
    }

    @Then("Verify product added in the cart")
    public void verify_product_added_in_the_cart() {
        ProductList productList = new ProductList(driver);
        boolean isAddToCardDisplaying = productList.isProductAddToCart();
        Assert.assertEquals(isAddToCardDisplaying, true);
    }

    @When("Click on checkout process button")
    public void click_on_checkout_process_button() {
        ProductList productList = new ProductList(driver);
        productList.clickOnProceedCheckout();
    }

    @Then("Verify that choose your payment method process displaying")
    public void verify_that_choose_your_payment_method_process_displaying() {
        ProductList productList = new ProductList(driver);
        boolean isPaymentDisplaying = productList.isPaymentMethodsDisplaying();
        Assert.assertEquals(isPaymentDisplaying, true);
    }

    @When("Click on user profile account button")
    public void click_on_user_profile_account_button() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnUserAccount();
    }

    @When("Click on the order list button on user profile")
    public void click_on_the_order_list_button_on_user_profile() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnOrderList();
    }

    @Then("Verify that user order list page displaying")
    public void verify_that_user_order_list_page_displaying() {
        AccountPage accountPage = new AccountPage(driver);
        boolean isOrderDisplaying = accountPage.isOrderListDisplaying();
        Assert.assertEquals(isOrderDisplaying, true);
    }

}
