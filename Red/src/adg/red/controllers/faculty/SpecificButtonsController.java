/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.faculty;

import adg.red.config.FacultyAction;
import adg.red.models.SectionTimeTable;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
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
        Context.getInstance().setFacultyAction(FacultyAction.UploadScore);
        renderSectionView();
    }

    @FXML
    private void specialRequest(ActionEvent event)
    {
        Context.getInstance().setFacultyAction(FacultyAction.SpecialApproval);
        renderSectionView();
    }

    @FXML
    private void viewTimeTable(ActionEvent event)
    {
        Context.getInstance().setTimeTable(SectionTimeTable.getByFacultyMember(Context.getInstance().getCurrentUser().getFacultyMember()));
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("TimeTable");
    }

    @FXML
    private void generateReport(ActionEvent event)
    {
        Context.getInstance().setFacultyAction(FacultyAction.Reports);
        renderSectionView();
    }

    private void renderSectionView()
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("faculty/SectionView");
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
