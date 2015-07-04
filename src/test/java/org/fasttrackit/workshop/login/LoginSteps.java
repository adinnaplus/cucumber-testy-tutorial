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
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage;

    public LoginSteps() {
        initPage();
    }

    public void initPage() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    private void login(String emailValue, String passwordValue) {
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(emailValue);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordValue);
    }

    @When("^I enter email \"([^\"]*)\"$")
    public void I_enter_email(String email) {
        WebElement element = driver.findElement(By.id("email"));
        element.sendKeys(email);
        System.out.println("I enter email");
    }

    @Given("^I navigate to the login page$")
    public void I_navigate_to_the_login_page()  {
        driver.navigate().to("file:///D:/Projects/Automation/installers/backup/app-demo/login.html");
    }

    @And("^fill in valid credentials$")
    public void fill_in_valid_credentials()  {
        login("eu@fast.com", "eu.pass");
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
        login("eu@fast.com", "eroare");
    }

    @Then("^the invalid credetials error message is displayed$")
    public void the_invalid_credetials_error_message_is_displayed()  {

    }

    @When("^I enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void I_enter_email_and_password(String email, String password)  {
        login(email, password);
    }

    @Then("^the login error message \"([^\"]*)\" is displayed$")
    public void the_login_error_message_is_displayed(String errorMessage)  {
        WebElement error = driver.findElement(By.className("error-msg"));
        assertThat(error.getText(), is(errorMessage));
    }
}
