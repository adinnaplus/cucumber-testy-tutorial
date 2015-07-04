package org.fasttrackit.workshop.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.LoginView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    public static final String VALID_EMAIL = "eu@fast.com";
    public static String VALID_PASSWORD = "eu.pass";

//    WEBDRIVER PAGE OBJECTS
//    LoginPage loginPage;
//
//    public LoginSteps() {
//        initPage();
//    }
//
//    public void initPage() {
//        loginPage = PageFactory.initElements(driver, LoginPage.class);
//    }

//    TESTY OBJECT
    private LoginView loginView = new LoginView();

    @Given("^I navigate to the login page$")
    public void I_navigate_to_the_login_page()  {
        driver.navigate().to("file:///D:/Projects/Automation/installers/backup/app-demo/login.html");
    }

    @And("^fill in valid credentials$")
    public void fill_in_valid_credentials()  {
        loginView.enterCredentials(VALID_EMAIL, VALID_PASSWORD);
    }

    @When("^clicking the login button$")
    public void clicking_the_login_button()  {
        loginView.clickOnLoginButton();
    }

    @Then("^the user is logged in$")
    public void the_user_is_logged_in()  {
        // Cucumber doens't tell the differece between a fail on an assert and a fail on the step
        WebElement logoutText = driver.findElement(By.xpath("//*[contains(text(), 'Logout')]"));
    }

    @Given("^fill in invalid credentials$")
    public void fill_in_invalid_credentials()  {
        loginView.enterCredentials(VALID_EMAIL, "eroare");
    }

    @When("^I enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void I_enter_email_and_password(String email, String password)  {
        loginView.enterCredentials(email, password);
    }

    @Then("^the login error message \"([^\"]*)\" is displayed$")
    public void the_login_error_message_is_displayed(String errorMessage)  {
        assertThat(loginView.getErrorMessage(), is(errorMessage)); // Matei ar pune si assets in LoginPage
    }

    @Given("^I successfully login$")
    public void I_successfully_login() {
        I_navigate_to_the_login_page();
        fill_in_valid_credentials();
        clicking_the_login_button();
        the_user_is_logged_in();
    }
}
