package org.fasttrackit.workshop.login;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBaseNative;
import org.fasttrackit.workshop.pagefactory.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBaseNative {
//    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    public LoginSteps() {
        initPage();
    }

    public void initPage() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("^I navigate to the login page$")
    public void I_navigate_to_the_login_page()  {
        driver.navigate().to("file:///D:/Projects/Automation/installers/backup/app-demo/login.html");
    }

    @And("^fill in valid credentials$")
    public void fill_in_valid_credentials()  {
        loginPage.enterCredentials("eu@fast.com", "eu.pass");
    }

    @When("^clicking the login button$")
    public void clicking_the_login_button()  {
        loginPage.clickOnLoginButton();
    }

    @Then("^the user is logged in$")
    public void the_user_is_logged_in()  {
        // Cucumber doens't tell the differece between a fail on an assert and a fail on the step
        WebElement logoutText = driver.findElement(By.xpath("//*[contains(text(), 'Logout')]"));
        System.out.println(logoutText.getAttribute("class"));
    }

    @Given("^fill in invalid credentials$")
    public void fill_in_invalid_credentials()  {
        loginPage.enterCredentials("eu@fast.com", "eroare");
    }

    @When("^I enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void I_enter_email_and_password(String email, String password)  {
        loginPage.enterCredentials(email, password);
    }

    @Then("^the login error message \"([^\"]*)\" is displayed$")
    public void the_login_error_message_is_displayed(String errorMessage)  {
        assertThat(loginPage.getErrorMessage(), is(errorMessage)); // Matei ar pune si assets in LoginPage
    }
}
