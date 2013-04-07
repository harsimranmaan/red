/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.faculty;

import adg.red.config.FacultyAction;
import adg.red.controllers.BreadCrumbController;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class SectionViewController implements Initializable
{

    private FacultyAction action;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        BreadCrumbController.renderBreadCrumb("faculty/HomeView|faculty/SectionView");
        Context.getInstance().setTitle(LocaleManager.get(69));
        action = Context.getInstance().getFacultyAction();
    }

    private void redirect()
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("faculty/" + action.toString());
    }
}
