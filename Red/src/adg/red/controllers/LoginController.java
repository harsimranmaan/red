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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import adg.red.models.User;
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

    @FXML //  fx:id="loginBtn"
    private Button btnLogin; // Value injected by FXMLLoader
    @FXML //  fx:id="viewArea"
    private AnchorPane loginViewArea; // Value injected by FXMLLoader
    @FXML //  fx:id="loginErrLbl"
    private Label loginErrLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="forgotPassBtn"
    private Button btnExit; // Value injected by FXMLLoader
    @FXML
    private TextField usernameTxt; // created by J. Yu
    @FXML
    private PasswordField passwordTxt; // created by J. Yu
    @FXML //  fx:id="passLbl"
    private Label passLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="userLbl"
    private Label userLbl; // Value injected by FXMLLoader
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
        if (Context.getInstance().WasLoggedIn())
        {
            loginErrLbl.setText(LocaleManager.get(9));
            loginErrLbl.setVisible(true);
        }



        // setOnAction when login button is pressed
        btnLogin.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
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
                    view.loadView(user.getUserTypeId().getName().toLowerCase() + "/HomeView");
                }
                catch (Exception ex)
                {
                    loginErrLbl.setText(ex.getMessage());
                    loginErrLbl.setVisible(true);
                }
            }
        });
        btnExit.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Platform.exit();
            }
        });
    }
}
