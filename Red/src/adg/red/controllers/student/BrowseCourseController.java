/*
 * The controller class for BrowseCourse.fxml.
 *
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.session.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Department;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
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
 * FXML Controller class for BrowseCourse.fxml.
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

    @FXML
    private void selectDepartment(MouseEvent event)
    {
        if (tabDisplayDepartment.getSelectionModel().getSelectedItem() != null)
        {
            Context.getInstance().setSelectedDepartment(tabDisplayDepartment.getSelectionModel().getSelectedItem());
            ViewLoader view = new ViewLoader(disView);
            view.loadView("student/CourseListView");
        }
    }

    /**
     * The function initializes all components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        colDeptId.setText(LocaleManager.get(41));
        colDeptName.setText(LocaleManager.get(52));
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
        Context.getInstance().setTitle(LocaleManager.get(59));
        BreadCrumbController.renderBreadCrumb("student/HomeView|student/BrowseCourse");
        initializeComponentsByLocale();
        populateDeptTable("All");

        // add handle to each component in hbox
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

    /**
     * The function gets the list of department by the input String from
     * database. It will then populate the department table with that list.
     * <p/>
     * @param beginsWith the String at the start of department id
     */
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

    /**
     * The function populates the list of departments to the department table.
     * <p/>
     * @param departments the list of department to be populated
     */
    private void populate(List<Department> departments)
    {
        colDeptId.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentId"));
        colDeptName.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        tabDisplayDepartment.getItems().setAll(departments);
    }
}
