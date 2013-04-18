/*
 * The controller class for HomeView.fxml.
 *
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.session.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class for HomeView.fxml.
 * <p/>
 * @author Witt
 */
public class HomeViewController implements Initializable
{

    /**
     * Initializes the controller class.
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(24));
        BreadCrumbController.renderBreadCrumb("student/HomeView");
    }
}
