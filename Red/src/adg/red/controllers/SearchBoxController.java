/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class SearchBoxController implements Initializable
{

    @FXML
    private Button btnGo;
    @FXML
    private Label lblSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        lblSearch.setText(LocaleManager.get(25) + ":");
        btnGo.setText(LocaleManager.get(26));
    }
}
