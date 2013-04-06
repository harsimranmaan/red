/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.User;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class ChangePasswordController implements Initializable
{

    @FXML
    private PasswordField txtOldPassword;
    @FXML
    private PasswordField txtNewPassword;
    @FXML
    private PasswordField txtReNewPwd;
    @FXML
    private Button btnSavePassword;
    @FXML
    private Button btnClear;
    @FXML
    private Label lblError;
    private User currentUser;

    @FXML
    private void changePassword(ActionEvent event)
    {
        String oldPwd = txtOldPassword.getText();
        String newPwd = txtNewPassword.getText();
        String pwdRe = txtReNewPwd.getText();
        String pwdErrorMsg;
        //User user;
        try
        {
            //check if old password is valid
            User.login(currentUser.getUsername(), oldPwd);

            if (newPwd.equals(pwdRe))
            {
                currentUser.setPassword(newPwd);
                currentUser.save();
                pwdErrorMsg = LocaleManager.get(11);
            }
            else
            {
                pwdErrorMsg = LocaleManager.get(12);
            }
            showPasswordMessage(pwdErrorMsg);
        }
        catch (Exception ex)
        {
            pwdErrorMsg = LocaleManager.get(13);
            showPasswordMessage(pwdErrorMsg);
            // Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showPasswordMessage(String pwdErrorMsg)
    {
        lblError.setVisible(true);
        lblError.setText(pwdErrorMsg);
    }

    @FXML
    private void clear(ActionEvent event)
    {
        txtOldPassword.setText("");
        txtNewPassword.setText("");
        txtReNewPwd.setText("");
        lblError.setVisible(false);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        currentUser = Context.getInstance().getCurrentUser();
    }
}