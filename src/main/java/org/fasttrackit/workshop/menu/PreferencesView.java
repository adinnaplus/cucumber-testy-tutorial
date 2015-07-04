package org.fasttrackit.workshop.menu;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Adina on 7/4/2015.
 */
public class PreferencesView {
    private WebLocator preferencesWindow = new WebLocator().setId("preferences-win");
    private TextField currentPassword = new TextField().setLabel("Current Password");
    private TextField newPassword = new TextField().setLabel("New Password");
    private TextField confirmPassword = new TextField().setLabel("Repeat Password");
    // set container
    private Button save = new Button().setText("Save").setContainer(preferencesWindow); // sau
    private Button close = new Button(preferencesWindow).setText("Close");
    private WebLocator message = new WebLocator(preferencesWindow).setClasses("status-msg");
//    private TextField currentPassword = new TextField().setElPath("//label[text()='Current Password']//following-sibling::*//input");

    public static void main(String[] args) {
        PreferencesView preferencesView = new PreferencesView();
        System.out.println(preferencesView.message.getPath());
    }

    public void typeCurrentPassword(String validPassword) {
        currentPassword.setValue(validPassword);
    }

    public void typeNewPassword(String password) {
        newPassword.setValue(password);
    }

    public void typeConfirmPassword(String password) {
        confirmPassword.setValue(password);
    }

    public void save() {
        save.assertClick();
    }

    public void expectMessage(String expectedMessage) {
        assertThat(message.getHtmlText(), is(expectedMessage));
    }

    public void close() {
        close.assertClick();
    }
}
