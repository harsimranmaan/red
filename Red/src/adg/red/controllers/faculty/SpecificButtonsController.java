/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.faculty;

import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class SpecificButtonsController implements Initializable
{

    @FXML
    private Button btnUpdateScores;
    @FXML
    private Button btnSpecialApproval;
    @FXML
    private Button btnViewTimetable;
    @FXML
    private Button btnReports;

    @FXML
    private void uploadScore(ActionEvent event)
    {
    }

    @FXML
    private void specialRequest(ActionEvent event)
    {
    }

    @FXML
    private void viewTimeTable(ActionEvent event)
    {
    }

    @FXML
    private void generateReport(ActionEvent event)
    {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
    }

    private void initializeComponentsByLocale()
    {
        btnUpdateScores.setText(LocaleManager.get(56));
        btnSpecialApproval.setText(LocaleManager.get(58));
        btnViewTimetable.setText(LocaleManager.get(18));
        btnReports.setText(LocaleManager.get(57));
    }
}
