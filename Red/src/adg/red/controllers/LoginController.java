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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import adg.red.BootStrap;

/**
 *
 * @author Witt
 */
public class LoginController implements Initializable {
    
    @FXML //  fx:id="close"
    private MenuItem close; // Value injected by FXMLLoader
    @FXML //  fx:id="loginBtn"
    private Button loginBtn; // Value injected by FXMLLoader
    
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
                Parent root = null;
                try {
                    BootStrap boot = new BootStrap();
                    root = FXMLLoader.load(getClass().getResource(boot.getUserInterfaceUrl("HomeStudent")));
                }
                catch (Exception ex){
                    //handle error??
                }
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
    }    
}
