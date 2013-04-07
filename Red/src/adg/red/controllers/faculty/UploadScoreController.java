/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.faculty;

import adg.red.controllers.BreadCrumbController;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class UploadScoreController implements Initializable
{

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        BreadCrumbController.renderBreadCrumb("faculty/HomeView|faculty/SectionView|faculty/UploadScore");
        Context.getInstance().setTitle(LocaleManager.get(56));
    }
}
