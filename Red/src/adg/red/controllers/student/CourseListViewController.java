/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
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
    @FXML
    private AnchorPane disView;
//    @FXML
//    private Hyperlink deptLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        initializeComponentsByLocale();
        populateCourseTable(Context.getInstance().getSelectedDepartment());
        HomeViewController.getDeptLk().setText(Context.getInstance().getSelectedDepartment().getDepartmentId() + ":");
        HomeViewController.getDeptLk().setVisible(true);

        // action when user clicked on the table
        disTable.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    //int key = disTable.getSelectionModel().getSelectedItem().
                    // Context.getInstance().setUserSelectCourseNumer(key);
                    if (disTable.getSelectionModel().getSelectedItem() != null)
                    {
                        Context.getInstance().setSelectedCourse(disTable.getSelectionModel().getSelectedItem());
                        ViewLoader view = new ViewLoader(disView);
                        view.loadView("student/CourseView");
                    }

                }
                catch (Exception ex)
                {
                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void populateCourseTable(Department department)
    {

        List<Course> courses = Course.getByDepartment(department);
        populate(courses);

    }

    private void populate(List<Course> courses)
    {
        courseNumberColmn.setCellValueFactory(new PropertyValueFactory<Course, String>("departmentIdAndCourseNumber"));
        courseNameColmn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        disTable.getItems().setAll(courses);
    }

    private void initializeComponentsByLocale()
    {
        courseNumberColmn.setText(LocaleManager.get(50));
        courseNameColmn.setText(LocaleManager.get(51));
    }
}
