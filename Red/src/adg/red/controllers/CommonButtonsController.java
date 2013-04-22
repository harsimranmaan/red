/*
 *
 *
 */
package adg.red.controllers;

import adg.red.controllers.student.HomeViewController;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class for buttons shared by roles: Student, Faculty, Admin
 * <p/>
 * @author harsimran.maan
 */
public class CommonButtonsController implements Initializable
{

    @FXML
    private Button btnLogout;
    @FXML
    private Button btnUserProfile;
    @FXML
    private Button btnFaq;
    @FXML
    private Button btnGlossary;
    @FXML
    private Button btnMessage;

    /**
     * Initializes the controller class
     */
    private void initializeComponentsByLocale()
    {
        btnUserProfile.setText(LocaleManager.get(21));
        btnMessage.setText(LocaleManager.get(22));
        btnGlossary.setText(LocaleManager.get(14));
        btnFaq.setText(LocaleManager.get(16));
        btnLogout.setText(LocaleManager.get(8));
    }

    /**
     * Implement logout button
     * <p/>
     * @param event user action: click button
     */
    public void logout(ActionEvent event)
    {
        try
        {
            ViewLoader view = new ViewLoader(Context.getInstance().getMainView());
            Context.getInstance().setWasLoggedIn(true);
            Context.getInstance().setAtLoginScreen(true);
            view.loadView("Login");
        }
        catch (Exception ex)
        {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Implement messages button
     * <p/>
     * @param event user action: click button
     */
    public void message(ActionEvent event)
    {
        try
        {
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("Message");

        }
        catch (Exception ex)
        {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Implement user profile button
     * <p/>
     * @param event user action: click button
     */
    public void userProfile(ActionEvent event)
    {
        try
        {
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("UserProfile");
        }
        catch (Exception ex)
        {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Implement Glossary button
     * <p/>
     * @param event user action: click button
     */
    public void glossary(ActionEvent event)
    {
        try
        {
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("Glossary");
        }
        catch (Exception ex)
        {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Implement FAQ button
     * <p/>
     * @param event user action: click button
     */
    public void faq(ActionEvent event)
    {
        try
        {
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("FaqView");
        }
        catch (Exception ex)
        {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
    }
}
