/*
 * 
 * 
 */
package adg.red.controllers.student;

import adg.red.models.SectionTimeTable;
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

    @FXML
    private void viewTimeTable(ActionEvent event)
    {
        Context.getInstance().setTimeTable(SectionTimeTable.getByStudent(Context.getInstance().getCurrentUser().getStudent()));
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("TimeTable");
    }

    @FXML
    private void viewEnrolment(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("student/EnrollmentView");
    }

    @FXML
    private void viewDegreeInfo(ActionEvent event)
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("student/ViewDegreeInfo");
    }

    private void initializeComponentsByLocale()
    {
        btnBrowseCourse.setText(LocaleManager.get(7));
        btnViewTimetable.setText(LocaleManager.get(18));
        btnViewEnrolment.setText(LocaleManager.get(19));
        btnViewDegreeInfo.setText(LocaleManager.get(20));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
    }
}
