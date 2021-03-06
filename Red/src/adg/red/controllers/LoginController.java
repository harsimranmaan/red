/*
 *
 *
 */
package adg.red.controllers;

import adg.red.controls.MessageStyleManager;
import adg.red.session.Context;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import adg.red.models.User;
import adg.red.locale.LocaleManager;
import adg.red.models.skeleton.ILocalizable;
import javafx.application.Platform;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class for Login.fxml
 * <p/>
 * @author Witt
 */
public class LoginController implements Initializable, ILocalizable
{

    @FXML
    private Button btnLogin;
    @FXML
    private AnchorPane loginViewArea;
    @FXML
    private Label lblError;
    @FXML
    private Button btnExit;
    @FXML
    private TextField usernameTxt; // created by J. Yu
    @FXML
    private PasswordField passwordTxt; // created by J. Yu
    @FXML
    private Label passLbl;
    @FXML
    private Label userLbl;
    @FXML
    private Hyperlink hpForgotPassword;

    /**
     * Initialize all the action events.
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        // bind resourceDictionary
        localize();
        lblError.setVisible(false);
        final Context context = Context.getInstance();
        context.getSearchView().setVisible(false);
        // set at login screen to true
        context.setAtLoginScreen(true);
        //from logout
        if (context.WasLoggedIn())
        {
            MessageStyleManager.setSuccess(lblError);
            lblError.setText(LocaleManager.get(9));
            lblError.setVisible(true);
        }
        //from password reset flow
        if (context.isInvalidReset())
        {
            MessageStyleManager.setError(lblError);
            lblError.setText(context.getInvalidMessage());
            lblError.setVisible(true);
        }
        //reset context
        context.setWasLoggedIn(false);
        context.setInvalidReset(false);
        context.setIsReset(false);
    }

    /**
     * Exit the platform
     * <p/>
     * @param event user action
     */
    public void exit(ActionEvent event)
    {
        Platform.exit();
    }

    /**
     * Load ForgotPassword.fxml view
     * <p/>
     * @param event user action: click button
     */
    public void forgotPassword(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getMainView());
        view.loadView("ForgotPassword");
    }

    /**
     * Get the user account id and password to login Load Login.fxml view
     * <p/>
     * @param event
     */
    public void login(ActionEvent event)
    {
        final Context context = Context.getInstance();
        context.setWasLoggedIn(false);
        // get userid and password input from gui by J. Yu
        String uid = usernameTxt.getText();
        String pwd = passwordTxt.getText();
        try
        {
            if (uid.trim().equals("") || pwd.equals(""))
            {
                throw new Exception(LocaleManager.get(110));
            }
            else
            {
                //LOGIN

                User user = User.login(uid, pwd);
                context.setCurrentUser(user);
                context.setAtLoginScreen(false);
                ViewLoader view = new ViewLoader(Context.getInstance().getMainView());
                view.loadView("HomeView");
            }
        }
        catch (Exception ex)
        {
            MessageStyleManager.setError(lblError);
            lblError.setText(ex.getMessage());
            lblError.setVisible(true);
        }
    }

    @Override
    public void localize()
    {
        btnLogin.setText(LocaleManager.get(1));
        btnExit.setText(LocaleManager.get(27));
        userLbl.setText(LocaleManager.get(3));
        passLbl.setText(LocaleManager.get(4));
        hpForgotPassword.setText(LocaleManager.get(2) + "?");
    }
}
