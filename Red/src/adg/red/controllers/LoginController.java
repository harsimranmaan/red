/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import adg.red.BootStrap;
import javafx.scene.layout.AnchorPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Witt
 */
public class LoginController implements Initializable {
    
    @FXML //  fx:id="close"
    private MenuItem close; // Value injected by FXMLLoader
    @FXML //  fx:id="loginBtn"
    private Button loginBtn; // Value injected by FXMLLoader
    @FXML //  fx:id="viewArea"
    private AnchorPane viewArea; // Value injected by FXMLLoader
    @FXML //  fx:id="loginErrLbl"
    private Label loginErrLbl; // Value injected by FXMLLoader
    @FXML
    private TextField usernameTxt; // created by J. Yu
    @FXML
    private PasswordField passwordTxt; // created by J. Yu
    
    /**
     * Initialize all the action events.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // setOnAction when close menuitem is selected
        close.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        // setOnAction when login button is pressed
        loginBtn.setOnAction(new EventHandler<ActionEvent>()  {
                        
            @Override
            public void handle(ActionEvent event) {                                
                // get userid and password input from gui by J. Yu
                String uid = usernameTxt.getText().toString();
                System.out.println(uid);
                String pwd = passwordTxt.getText().toString();
                System.out.println(pwd);

                // create a api login controller and execute the query to db, created by J. Yu
                adg.red.api.controller.LoginController login = new adg.red.api.controller.LoginController();
                try {
                    System.out.println("Login return: " + login.login(uid, pwd));
                    if(login.login(uid, pwd) == 0) {
                        View view = new View(viewArea);
                        view.loadView("HomeView");
                    }
                    else {
                        loginErrLbl.setVisible(true);
                        loginErrLbl.setText("Invalid Username/Password!");
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
    }
   
//    /**
//     * Load new view.
//     * @param fxmlView the fxml file name to be loaded.
//     */
//    public void loadView(String fxmlView) {
//        // load home view
//                try {
//                    BootStrap boot = new BootStrap();
//                    Node view = FXMLLoader.load(getClass().getResource(boot.getUserInterfaceUrl(fxmlView)));
//                    viewArea.getChildren().setAll(view);
//                    // set anchors
//                    AnchorPane.setLeftAnchor(view, 0.0);
//                    AnchorPane.setRightAnchor(view, 0.0);
//                    AnchorPane.setTopAnchor(view, 0.0);
//                    AnchorPane.setBottomAnchor(view, 0.0);
//                }
//                catch (Exception ex){
//                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//                }   
//    } 
}
