/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.BootStrap;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Witt
 */
public class HomeViewController implements Initializable {

    @FXML //  fx:id="brwCourseBtn"
    private Button brwCourseBtn; // Value injected by FXMLLoader    
    @FXML //  fx:id="faqBtn"
    private Button faqBtn; // Value injected by FXMLLoader
    @FXML //  fx:id="disBrwCourseArea"
    private AnchorPane disBrwCourseArea; // Value injected by FXMLLoader    
    @FXML //  fx:id="homeLk"
    private Hyperlink homeLk; // Value injected by FXMLLoader    
    @FXML //  fx:id="browseCourseLk"
    private Hyperlink browseCourseLk; // Value injected by FXMLLoader
    @FXML //  fx:id="homeView"
    private AnchorPane homeView; // Value injected by FXMLLoader
    @FXML //  fx:id="deptLk"
    private static Hyperlink deptLk; // Value injected by FXMLLoader
    @FXML //  fx:id="courseLk"
    private static Hyperlink courseLk; // Value injected by FXMLLoader
    @FXML //fx:id="logOut"
    private Button logOut; // Value injected by FXMLoader
    @FXML //fx:id="userProfileBtn" // added by Jingbo Yu
    private Button userProfileBtn; // Value injected by FXMLoader

    
    public static Hyperlink getCourseLk() {
        return courseLk;
    }

    public static void setCourseLk(Hyperlink courseLk) {
        HomeViewController.courseLk = courseLk;
    }
    
    public static Hyperlink getDeptLk() {
        return deptLk;
    }

    public static void setDeptLk(Hyperlink deptLk) {
        HomeViewController.deptLk = deptLk;
    }
    @FXML
    private Label menuLk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         // setOnAction when browse course button is pressed
        brwCourseBtn.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    View view = new View(disBrwCourseArea);
                    view.loadView("BrowseCourse");     
                    browseCourseLk.setVisible(true);
                    browseCourseLk.setText("Browse Course:");
                    deptLk.setVisible(false);
                    courseLk.setVisible(false);
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
        
         // setOnAction when faq button is pressed
        faqBtn.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    View view = new View(disBrwCourseArea);
                    view.loadView("FaqView");     
                    browseCourseLk.setVisible(true);
                    browseCourseLk.setText("Faq");
                    deptLk.setVisible(false);
                    courseLk.setVisible(false);
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
        
         // setOnAction when browse course button is pressed added by Jingbo Yu
        userProfileBtn.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    View view = new View(disBrwCourseArea);
                    view.loadView("UserProfile");     
                    browseCourseLk.setVisible(true);
                    browseCourseLk.setText("User Profile:");
                    deptLk.setVisible(false);
                    courseLk.setVisible(false);
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
        
        // setOnAction when home link is clicked
        homeLk.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    View view = new View(homeView);
                    view.loadView("HomeView");     
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }                 
            }
        });
        
        // setOnAction when browse course link is clicked
        browseCourseLk.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {      
                    if(((Hyperlink)event.getSource()).getText().contains("Browse")) {
                        View view = new View(disBrwCourseArea);
                        view.loadView("BrowseCourse");  
                        deptLk.setVisible(false);
                        courseLk.setVisible(false);
                        deptLk.setVisited(false);
                        courseLk.setVisited(false);
                    }
                    if(((Hyperlink)event.getSource()).getText().contains("faq")) {
                        View view = new View(disBrwCourseArea);
                        view.loadView("FaqView");  
                    }                    
                    browseCourseLk.setVisited(false);                    
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }                 
            }
        });
        
        // setOnAction when dept link is clicked
        deptLk.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    View view = new View(disBrwCourseArea);
                    view.loadView("CourseListView"); 
                    courseLk.setVisible(false);
                    deptLk.setVisited(false);
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }                 
            }
        });
        
        // setOnAction when course link is clicked
        courseLk.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    View view = new View(disBrwCourseArea);
                    view.loadView("CourseView"); 
                    courseLk.setVisited(false);
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }                 
            }
        });    

    // setOnAction when course link is clicked
        logOut.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                   
                try {                    
                    System.out.println("Log Out Button Pressed");
                    
                    View view = new View(homeView);
                    view.loadView("LoggedOut");
                } 
                catch (Exception ex) {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }                 
            }
        });    
    }
}
