/*
 * 
 * 
 */
package adg.red.controllers.admin;

import adg.red.controllers.BreadCrumbController;
import adg.red.session.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class HomeViewController implements Initializable
{

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(24));
        BreadCrumbController.renderBreadCrumb("admin/HomeView");
    }
}
