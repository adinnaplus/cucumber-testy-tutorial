package org.fasttrackit.workshop.menu;

import com.sdl.selenium.bootstrap.button.Button;
import com.sdl.selenium.web.link.WebLink;

/**
 * Created by Adina on 7/4/2015.
 */
public class MainMenuView {
    private static Button preferencesButton = new Button().setText("Preferences");
    public static WebLink logout = new WebLink().setText("Logout");

    public void logout() {
        logout.assertClick();
    }

    public void viewPrefereces() {
        preferencesButton.assertClick();
    }
}
