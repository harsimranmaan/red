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
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Witt
 */
public class LoginController implements Initializable {
    
    @FXML //  fx:id="close"
    private MenuItem close; // Value injected by FXMLLoader
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        close.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
            Platform.exit();
          }
        });
    }    
}
