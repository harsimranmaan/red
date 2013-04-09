/*
 * 
 * 
 */
package adg.red.controllers.admin;

import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class SpecificButtonsController implements Initializable
{

    @FXML
    private Button btnDepartments;
    @FXML
    private Button btnPrograms;
    @FXML
    private Button btnCourses;
    @FXML
    private Button btnSections;
    @FXML
    private Button btnUsers;

    @FXML
    private void showDepartments(ActionEvent event)
    {
    }

    @FXML
    private void showPrograms(ActionEvent event)
    {
    }

    @FXML
    private void showCourses(ActionEvent event)
    {
    }

    @FXML
    private void showSections(ActionEvent event)
    {
    }

    @FXML
    private void showUsers(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("admin/User");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
    }

    private void initializeComponentsByLocale()
    {

        btnDepartments.setText(LocaleManager.get(36));
        btnPrograms.setText(LocaleManager.get(37));
        btnSections.setText(LocaleManager.get(38));
        btnCourses.setText(LocaleManager.get(39));
        btnUsers.setText(LocaleManager.get(40));
    }
}
