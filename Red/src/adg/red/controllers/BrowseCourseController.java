/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.api.model.DepartmentArray;
import adg.red.api.model.Department;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Witt
 */
public class BrowseCourseController implements Initializable {

     @FXML //  fx:id="aLink"
    private Hyperlink aLink; // Value injected by FXMLLoader

    @FXML //  fx:id="allLink"
    private Hyperlink allLink; // Value injected by FXMLLoader

    @FXML //  fx:id="bLink"
    private Hyperlink bLink; // Value injected by FXMLLoader

    @FXML //  fx:id="cLink"
    private Hyperlink cLink; // Value injected by FXMLLoader

    @FXML //  fx:id="dLink"
    private Hyperlink dLink; // Value injected by FXMLLoader

    @FXML //  fx:id="disTable"
    private TableView<Department> disTable; // Value injected by FXMLLoader

    @FXML //  fx:id="deptIdColmn"
    private TableColumn<Department, String> deptIdColmn; // Value injected by FXMLLoader

    @FXML //  fx:id="deptNameColm"
    private TableColumn<Department, String> deptNameColmn; // Value injected by FXMLLoader
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateTable("all");
        
        // setOnAction when all hyperlink is pressed
        allLink.setOnAction(new EventHandler<ActionEvent>()  {                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                                    
                    populateTable("all");
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.WARNING, null, ex);
                }                 
            }
        });
        
        // setOnAction when a hyperlink is pressed
        aLink.setOnAction(new EventHandler<ActionEvent>()  {                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                                    
                    populateTable("a");
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.WARNING, null, ex);
                }                 
            }
        });
        
        // setOnAction when b hyperlink is pressed
        bLink.setOnAction(new EventHandler<ActionEvent>()  {                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                                    
                    populateTable("b");
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.WARNING, null, ex);
                }                 
            }
        });
        
        // setOnAction when c hyperlink is pressed
        cLink.setOnAction(new EventHandler<ActionEvent>()  {                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                                    
                    populateTable("c");
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.WARNING, null, ex);
                }                 
            }
        });
    }
    
    public void populateTable(String key) {
        
        DepartmentArray deptArry = new DepartmentArray();
        deptIdColmn.setCellValueFactory(new PropertyValueFactory<Department, String>("deptId"));
        deptNameColmn.setCellValueFactory(new PropertyValueFactory<Department, String>("deptName"));
        disTable.getItems().setAll(deptArry.filterByChar(key));
    }
            
    
        
        
}
