/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Department;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class BrowseCourseController implements Initializable
{

    @FXML //  fx:id="disTable"
    private TableView<Department> tabDisplayDepartment; // Value injected by FXMLLoader
    @FXML //  fx:id="deptIdColmn"
    private TableColumn<Department, String> colDeptId; // Value injected by FXMLLoader
    @FXML //  fx:id="deptNameColm"
    private TableColumn<Department, String> colDeptName; // Value injected by FXMLLoader
    @FXML //  fx:id="disView"
    private AnchorPane disView; // Value injected by FXMLLoader
    @FXML //  fx:id="hBox"
    private HBox hBox; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        populateDeptTable("All");

        // action when user clicked on the table
        tabDisplayDepartment.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
//                    String key = tabDisplayCourse.getSelectionModel().getSelectedItem().getDepartmentId();
//                    Context.getInstance().setUserSelectDeptId(key);
                    Context.getInstance().setSelectedDepartment(tabDisplayDepartment.getSelectionModel().getSelectedItem());
                    ViewLoader view = new ViewLoader(disView);
                    view.loadView("student/CourseListView");

                }
                catch (Exception ex)
                {
                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Iterator<Node> nodes = hBox.getChildren().iterator();
        while (nodes.hasNext())
        {
            ((Hyperlink) nodes.next()).setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    String beginsWith = ((Hyperlink) event.getSource()).getText();
                    populateDeptTable(beginsWith);
                }
            });
        }
    }

    public void populateDeptTable(String beginsWith)
    {
        List< Department> departments;
        if (beginsWith.equals("All"))
        {
            departments = Department.getAll();
        }
        else
        {
            departments = Department.getByDepartmnetIdBeginsWith(beginsWith);
        }
        populate(departments);
    }

    private void populate(List<Department> departments)
    {
        colDeptId.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentId"));
        colDeptName.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        tabDisplayDepartment.getItems().setAll(departments);
    }
}
