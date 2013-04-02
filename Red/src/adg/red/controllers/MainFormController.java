/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p/>
 * @author hsmaan
 */
public class MainFormController implements Initializable
{

    @FXML //  fx:id="mnuClose"
    private MenuItem mnuClose; // Value injected by FXMLLoader
    @FXML //  fx:id="viewArea"
    private AnchorPane viewArea; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // setOnAction when close menuitem is selected
        mnuClose.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Platform.exit();
            }
        });
        ViewLoader view = new ViewLoader(viewArea);
        view.loadView("Login");
    }
}
