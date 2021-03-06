/*
 * The controller class for Faculty HomeView.fxml.
 *
 */
package adg.red.controllers.faculty;

import adg.red.controllers.BreadCrumbController;
import adg.red.models.MessageReceiver;
import adg.red.models.User;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * FXML Controller class for HomeView.fxml.
 * <p/>
 * @author Witt
 */
public class HomeViewController implements Initializable
{
    @FXML
    private Label nameLabel;
    @FXML
    private Label msgLabel;
    private User currentUser;
    /**
     * Initializes the controller class.
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        currentUser = Context.getInstance().getCurrentUser();
        Context.getInstance().setTitle(LocaleManager.get(24));
        BreadCrumbController.renderBreadCrumb("faculty/HomeView");
        nameLabel.setText("Hi " + currentUser.getFirstName() + ", welcome to the RED enrolment system.");

        int nUnread = MessageReceiver.getUnreadMessageByReceiverId(currentUser.getUsername());
        if (nUnread <= 1)
            msgLabel.setText("You have " + nUnread + " unread message.");
        else
            msgLabel.setText("You have " + nUnread + " unread messages.");

    }
}
