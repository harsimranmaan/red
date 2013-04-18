/*
 *
 *
 */
package adg.red.controllers;

import adg.red.models.EmailCode;
import adg.red.models.User;
import adg.red.session.Context;
import adg.red.utils.EmailSender;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class for ForgotPasswordController.fxml
 * <p/>
 * @author harsimran.maan
 */
public class ForgotPasswordController implements Initializable
{

    @FXML
    private Label lblEmailAddress;
    @FXML
    private TextField txtEmailId;
    @FXML
    private TextField txtCode;
    @FXML
    private VBox vBoxEmail;
    @FXML
    private VBox vBoxCode;

    /**
     * Send validation code to user email address
     * <p/>
     * @param event user action: click button
     */
    @FXML
    private void sendEmail(ActionEvent event)
    {
        String emailId = txtEmailId.getText();
        try
        {
            User user = User.getUserByEmailId(emailId);
            EmailCode code = EmailCode.deleteIfExists(user.getUsername());
            code.save();
            new EmailSender(emailId, "Password Reset Code", "Please use the following code to reset the password: "
                    + code.getCode()).send();
            vBoxCode.setVisible(true);
            vBoxEmail.setVisible(false);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Generate validation code and send to user's email address
     * <p/>
     * @param event user action: click button
     */
    @FXML
    private void validateCode(ActionEvent event)
    {
    }

    @FXML
    private void back(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getMainView());
        view.loadView("Login");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        vBoxCode.setVisible(false);
    }
}
