/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.api.model.Department;
import adg.red.api.model.DepartmentArray;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Witt
 */
public class CourseViewController implements Initializable {

    @FXML //  fx:id="courseIdColmn"
    private TableColumn<Department, String> courseIdColmn; // Value injected by FXMLLoader

    @FXML //  fx:id="courseNameColmn"
    private TableColumn<Department, String> courseNameColmn; // Value injected by FXMLLoader

    @FXML //  fx:id="disTable"
    private TableView<Department> disTable; // Value injected by FXMLLoader
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO   
        populateCourseTable(Context.getInstance().getUserSelect());            
    }    
    
        public void populateCourseTable(String key) {
        
        DepartmentArray deptArry = new DepartmentArray();
        courseIdColmn.setCellValueFactory(new PropertyValueFactory<Department, String>("deptId"));
        courseNameColmn.setCellValueFactory(new PropertyValueFactory<Department, String>("deptName"));
        disTable.getItems().setAll(deptArry.filterByChar(key));
    }
}
