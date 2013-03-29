/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Department;
import adg.red.utils.RedEntityManager;
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
    @FXML //  fx:id="disView"
    private AnchorPane disView; // Value injected by FXMLLoader
    @FXML //  fx:id="hBox"
    private HBox hBox; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateDeptTable("all");

        // action when user clicked on the table
        disTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    String key = disTable.getSelectionModel().getSelectedItem().getDepartmentId();
                    System.out.println(key);
                    Context.getInstance().setUserSelect(key);
                    View view = new View(disView);
                    view.loadView("CourseView");

                } catch (Exception ex) {
                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Iterator<Node> nodes = hBox.getChildren().iterator();
        while (nodes.hasNext()) {
            ((Hyperlink) nodes.next()).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String beginsWith = ((Hyperlink) event.getSource()).getText();
                    List< Department> departments = RedEntityManager.getEntityManager().createNamedQuery("Department.findSearchLike").setParameter("keyWord", beginsWith+"%").getResultList();
                    populate(departments);
                }
            });
        }

//        // setOnAction when all hyperlink is pressed
//        allLink.setOnAction(new EventHandler<ActionEvent>()  {                        
//            @Override
//            public void handle(ActionEvent event) {                   
//                try {                                    
//                    populateDeptTable("all");
//                } 
//                catch (Exception ex) {
//                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.WARNING, null, ex);
//                }                 
//            }
//        });
//        
//        // setOnAction when a hyperlink is pressed
//        aLink.setOnAction(new EventHandler<ActionEvent>()  {                        
//            @Override
//            public void handle(ActionEvent event) {                   
//                try {                                    
//                    populateDeptTable("a");
//                } 
//                catch (Exception ex) {
//                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.WARNING, null, ex);
//                }                 
//            }
//        });
//        
//        // setOnAction when b hyperlink is pressed
//        bLink.setOnAction(new EventHandler<ActionEvent>()  {                        
//            @Override
//            public void handle(ActionEvent event) {                   
//                try {                                    
//                    populateDeptTable("b");
//                } 
//                catch (Exception ex) {
//                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.WARNING, null, ex);
//                }                 
//            }
//        });
//        
//        // setOnAction when c hyperlink is pressed
//        cLink.setOnAction(new EventHandler<ActionEvent>()  {                        
//            @Override
//            public void handle(ActionEvent event) {                   
//                try {                                    
//                    populateDeptTable("c");
//                } 
//                catch (Exception ex) {
//                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.WARNING, null, ex);
//                }                 
//            }
//        });
    }
    
    

    public void populateDeptTable(String key) {
        List< Department> departments = RedEntityManager.getEntityManager().createNamedQuery("Department.findAll").getResultList();
        populate(departments);
    }

    private void populate(List<Department> departments) {
        deptIdColmn.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentId"));
        deptNameColmn.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        disTable.getItems().setAll(departments);
    }
}
