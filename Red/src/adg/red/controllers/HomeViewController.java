/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Witt
 */
public class HomeViewController implements Initializable {

    @FXML //  fx:id="brwCourseBtn"
    private Button brwCourseBtn; // Value injected by FXMLLoader
    
    @FXML //  fx:id="disBrwCourseArea"
    private AnchorPane disBrwCourseArea; // Value injected by FXMLLoader
    
    @FXML //  fx:id="menuLbl"
    private Label menuLbl; // Value injected by FXMLLoader
    @FXML
    private Button logOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         // setOnAction when login button is pressed
        brwCourseBtn.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    View view = new View(disBrwCourseArea);
                    view.loadView("BrowseCourse");     
                    menuLbl.setText("Student:Browse Courses");
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
    }    

    @FXML
    private void logOut(ActionEvent event) {
    }
}
