package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.LoginView;
import org.fasttrackit.workshop.menu.MainMenuView;
import org.fasttrackit.workshop.menu.PreferencesView;

/**
 * Created by Adina on 7/4/2015.
 */
public class PreferencesSteps extends TestBase{

    public static final String NEW_PASSWORD = "new.pass";
    private PreferencesView preferences = new PreferencesView();
    LoginView loginView = new LoginView();
    LoginSteps loginSteps = new LoginSteps();
    MainMenuView mainMenuView = new MainMenuView();


    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() {
        mainMenuView.viewPrefereces();
        Utils.sleep(1000);
    }

    @And("^I input current password$")
    public void I_input_current_password() {
        preferences.typeCurrentPassword(LoginSteps.VALID_PASSWORD);
    }

    @And("^I input new password$")
    public void I_input_new_password() {
        preferences.typeNewPassword(NEW_PASSWORD);
    }

    @And("^I retype password$")
    public void I_retype_password() {
        preferences.typeConfirmPassword(NEW_PASSWORD);
    }

    @And("^I click on Save Change Password button$")
    public void I_click_on_Save_Change_Password_button() {
        preferences.save();
    }

    @Then("^I will see the message \"([^\"]*)\"$")
    public void I_will_see_the_message(String message) {
        preferences.expectMessage(message);
        LoginSteps.VALID_PASSWORD = NEW_PASSWORD;
    }

    @Then("^I can relogin with the new password$")
    public void I_can_relogin_with_the_new_password() {
        preferences.close();
        Utils.sleep(1000);
        mainMenuView.logout();
        loginSteps.I_successfully_login();
    }
}
