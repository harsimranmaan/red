/*
 * The controller class for CourseListView.fxml.
 *
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class for CourseListView.fxml.
 * <p/>
 * @author Witt
 */
public class CourseListViewController implements Initializable
{

    @FXML
    private TableColumn<Course, String> courseNumberColmn;
    @FXML
    private TableColumn<Course, String> courseNameColmn;
    @FXML
    private TableView<Course> disTable;

    /**
     * The function to handle selectCourse mouse event.
     * <p/>
     * @param event the mouse event
     */
    @FXML
    private void selectCourse(MouseEvent event)
    {
        if (disTable.getSelectionModel().getSelectedItem() != null)
        {
            Context.getInstance().setSelectedCourse(disTable.getSelectionModel().getSelectedItem());
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("student/CourseView");
        }
    }

    /**
     * The function initializes all components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        courseNumberColmn.setText(LocaleManager.get(50));
        courseNameColmn.setText(LocaleManager.get(51));
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
        Context.getInstance().setTitle(LocaleManager.get(60));
        BreadCrumbController.renderBreadCrumb("student/HomeView|student/BrowseCourse|student/CourseListView");
        initializeComponentsByLocale();
        populateCourseTable(Context.getInstance().getSelectedDepartment());


    }

    /**
     * The function to populate the course table by selected department.
     * <p/>
     * @param department the department to populate the courses for
     */
    public void populateCourseTable(Department department)
    {
        List<Course> courses = Course.getByDepartment(department);
        populate(courses);
    }

    /**
     * The function populates the list of courses to the course table.
     * <p/>
     * @param courses the list of courses to be populated to the course table
     */
    private void populate(List<Course> courses)
    {
        courseNumberColmn.setCellValueFactory(new PropertyValueFactory<Course, String>("departmentIdAndCourseNumber"));
        courseNameColmn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        disTable.getItems().setAll(courses);
    }
}
