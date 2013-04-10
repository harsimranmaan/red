/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.models.EmailCode;
import adg.red.models.User;
import adg.red.utils.EmailSender;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class for ForgotPassword.fxml
 * <p/>
 * @author harsimran.maan
 */
public class ForgotPassword implements Initializable
{

    @FXML
    private Label lblEmailAddress;
    @FXML
    private TextField txtEmailId;
    @FXML
    private TextField txtCode;

    /**
     * Send validation code to user email address 
     * @param event user action: click button
     */
    @FXML
    private void sendEmail(ActionEvent event)
    {
        String emailId = txtEmailId.getText();
        try
        {
            User user = User.getUserByEmailId(emailId);
            EmailCode code = new EmailCode(user.getUsername());
            code.save();
            new EmailSender(emailId, "Password Reset Code", "Please use the following code to reset the password: "
                    + code.getCode()).send();
        }
        catch (Exception ex)
        {
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Generate validation code and send to user's email address
     * @param event user action: click button
     */
    @FXML
    private void validateCode(ActionEvent event)
    {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
}
