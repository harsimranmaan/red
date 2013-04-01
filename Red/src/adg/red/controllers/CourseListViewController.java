/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Course;
import adg.red.models.Department;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
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

    @FXML //  fx:id="courseIdColmn"
    private TableColumn<Course, String> courseNumberColmn; // Value injected by FXMLLoader
    @FXML //  fx:id="courseNameColmn"
    private TableColumn<Course, String> courseNameColmn; // Value injected by FXMLLoader
    @FXML //  fx:id="disTable"
    private TableView<Course> disTable; // Value injected by FXMLLoader
    @FXML //  fx:id="disView"
    private AnchorPane disView; // Value injected by FXMLLoader
    @FXML //  fx:id="deptLbl"
    private Hyperlink deptLbl; // Value injected by FXMLLoader
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        populateCourseTable(Context.getInstance().getUserSelectDeptId());
        deptLbl.setText(Context.getInstance().getUserSelectDeptId());
        
        // action when user clicked on the table
        disTable.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    int key = disTable.getSelectionModel().getSelectedItem().getCourseNumber();
                    Context.getInstance().setUserSelectCourseNumer(key);
                    Context.getInstance().setUserSelectCourse(disTable.getSelectionModel().getSelectedItem());
                    View view = new View(disView);
                    view.loadView("CourseView");

                }
                catch (Exception ex)
                {
                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void populateCourseTable(String departmentId)
    {

        List<Course> courses = Course.getByDepartment(Department.getDepartmentById(departmentId));
        populate(courses);

    }

    private void populate(List<Course> courses)
    {
        courseNumberColmn.setCellValueFactory(new PropertyValueFactory<Course, String>("departmentIdAndCourseNumber"));
        courseNameColmn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));        
        disTable.getItems().setAll(courses);
    }
}
