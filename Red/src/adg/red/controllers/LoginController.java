/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import adg.red.models.User;
import adg.red.utils.EmailSender;
import adg.red.utils.LocaleManager;
import javafx.application.Platform;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Witt
 */
public class LoginController implements Initializable
{

    @FXML
    private Button btnLogin;
    @FXML
    private AnchorPane loginViewArea;
    @FXML
    private Label loginErrLbl;
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        // bind resourceDictionary
        btnLogin.setText(LocaleManager.get(1));
        btnExit.setText(LocaleManager.get(27));
        userLbl.setText(LocaleManager.get(3));
        passLbl.setText(LocaleManager.get(4));
        hpForgotPassword.setText(LocaleManager.get(2) + "?");
        loginErrLbl.setVisible(false);
        Context.getInstance().getSearchView().setVisible(false);
        if (Context.getInstance().WasLoggedIn())
        {
            loginErrLbl.setText(LocaleManager.get(9));
            loginErrLbl.setVisible(true);
        }
    }

    public void exit(ActionEvent event)
    {
        Platform.exit();
    }

    public void forgotPassword(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getHomeView());
        view.loadView("ForgotPassword");
    }

    public void login(ActionEvent event)
    {
        Context.getInstance().setWasLoggedIn(false);
        // get userid and password input from gui by J. Yu
        String uid = usernameTxt.getText().toString();
        String pwd = passwordTxt.getText().toString();

        //LOGIN
        try
        {
            User user = User.login(uid, pwd);
            Context.getInstance().setCurrentUser(user);
            ViewLoader view = new ViewLoader((AnchorPane) loginViewArea.getParent());
            view.loadView("HomeView");
        }
        catch (Exception ex)
        {
            loginErrLbl.setText(ex.getMessage());
            loginErrLbl.setVisible(true);
        }
    }
}
