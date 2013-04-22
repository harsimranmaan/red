/*
 * The controller class for SpecificButtons.fxml.
 *
 */
package adg.red.controllers.student;

import adg.red.models.SectionTimeTable;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class for SpecificButtons.fxml.
 * <p/>
 * @author harsimran.maan
 */
public class SpecificButtonsController implements Initializable
{

    @FXML
    private Button btnBrowseCourse;
    @FXML
    private Button btnViewTimetable;
    @FXML
    private Button btnViewEnrolment;
    @FXML
    private Button btnViewDegreeInfo;

    @FXML
    private void browseCourse(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("student/BrowseCourse");
    }

    /**
     * The function to handle viewTimeTable action event.
     * <p/>
     * @param event the action event
     */
    @FXML
    private void viewTimeTable(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("TimeTable");
    }

    /**
     * The function to handle viewEnrolment action event.
     * <p/>
     * @param event the action event
     */
    @FXML
    private void viewEnrolment(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("student/EnrollmentView");
    }

    /**
     * The function to handle viewDegreeInfo action event.
     * <p/>
     * @param event the action event
     */
    @FXML
    private void viewDegreeInfo(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("student/ViewDegreeInfo");
    }

    /**
     * The function initializes all components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        btnBrowseCourse.setText(LocaleManager.get(7));
        btnViewTimetable.setText(LocaleManager.get(18));
        btnViewEnrolment.setText(LocaleManager.get(19));
        btnViewDegreeInfo.setText(LocaleManager.get(20));
    }

    /**
     * Initializes the controller class.
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTimeTable(SectionTimeTable.getByStudent(Context.getInstance().getCurrentUser().getStudent()));
        initializeComponentsByLocale();
    }
}
