/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
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
    private MenuItem mniClose; // Value injected by FXMLLoader
    @FXML //  fx:id="viewArea"
    private AnchorPane viewArea; // Value injected by FXMLLoader
    @FXML //  fx:id="menFile"
    private Menu menFile; // Value injected by FXMLLoader
    @FXML //  fx:id="menHelp"
    private Menu menHelp; // Value injected by FXMLLoader
    @FXML //  fx:id="mniAbout"
    private MenuItem mniAbout; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
        // setOnAction when close menuitem is selected
        mniClose.setOnAction(new EventHandler<ActionEvent>()
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

    private void initializeComponentsByLocale()
    {
        menFile.setText(LocaleManager.get(28));
        menHelp.setText(LocaleManager.get(29));
        mniClose.setText(LocaleManager.get(30));
        mniAbout.setText(LocaleManager.get(31));
    }
}
