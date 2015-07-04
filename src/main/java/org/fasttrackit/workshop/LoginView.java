package org.fasttrackit.workshop;

import com.sdl.selenium.web.WebLocator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator submitButton = new WebLocator().setId("loginButton");

    private WebLocator email = new WebLocator().setId("email");

    private WebLocator password = new WebLocator().setId("password");

    private WebLocator error = new WebLocator().setClasses("error-msg");

    public void clickOnLoginButton() {
        submitButton.click();
    }

    public void enterCredentials(String emailValue, String passwordValue) {
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
    }

    public String getErrorMessage() {
        return error.getHtmlText();
    }

}
