/*
 *
 *
 */
package adg.red.controllers;

import adg.red.locale.LocaleManager;
import adg.red.models.EmailCode;
import adg.red.models.User;
import adg.red.session.Context;
import adg.red.utils.EmailSender;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private Button btnSend;
    @FXML
    private Button btnBackUpper;
    @FXML
    private Label lblCode;
    @FXML
    private Button btnValidate;
    @FXML
    private Button btnBackLower;
    @FXML
    private AnchorPane ancMain;

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
            final Context context = Context.getInstance();
            context.setInvalidReset(true);
            context.setInvalidMessage(LocaleManager.get(116));
            back();
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

        final Context context = Context.getInstance();

        try
        {
            User user = User.validate(txtEmailId.getText(), txtCode.getText());
            context.setIsReset(true);
            context.setCurrentUser(user);
            ViewLoader view = new ViewLoader(ancMain);
            view.loadView("ChangePassword");
        }
        catch (Exception ex)
        {
            context.setInvalidReset(true);
            context.setInvalidMessage(LocaleManager.get(117));
            back();
        }

    }

    @FXML
    private void back(ActionEvent event)
    {
        back();
    }

    private void back()
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
        lblEmailAddress.setText(LocaleManager.get(111));
        lblCode.setText(LocaleManager.get(113));
        btnBackLower.setText(LocaleManager.get(115));
        btnBackUpper.setText(LocaleManager.get(115));
        btnSend.setText(LocaleManager.get(112));
        btnValidate.setText(LocaleManager.get(114));
        vBoxCode.setVisible(false);
    }
}
