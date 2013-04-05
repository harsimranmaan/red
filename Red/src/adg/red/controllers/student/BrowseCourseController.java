/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Department;
import adg.red.utils.LocaleManager;
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

    @FXML
    private TableView<Department> tabDisplayDepartment;
    @FXML
    private TableColumn<Department, String> colDeptId;
    @FXML
    private TableColumn<Department, String> colDeptName;
    @FXML
    private AnchorPane disView;
    @FXML
    private HBox hBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        initializeComponentsByLocale();
        populateDeptTable("All");

        // action when user clicked on the table
        tabDisplayDepartment.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    if (tabDisplayDepartment.getSelectionModel().getSelectedItem() != null)
                    {
                        Context.getInstance().setSelectedDepartment(tabDisplayDepartment.getSelectionModel().getSelectedItem());
                        ViewLoader view = new ViewLoader(disView);
                        view.loadView("student/CourseListView");
                    }
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

    private void initializeComponentsByLocale()
    {
        colDeptId.setText(LocaleManager.get(41));
        colDeptName.setText(LocaleManager.get(52));
    }
}
