/*
 * The controller class for Faculty SpecialButtons.fxml.
 *
 */
package adg.red.controllers.faculty;

import adg.red.models.enums.FacultyAction;
import adg.red.models.SectionTimeTable;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
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

    /**
     * Handles Upload Score button press event
     * <p/>
     * @param event The Action event
     */
    @FXML
    private void uploadScore(ActionEvent event)
    {
        Context.getInstance().setFacultyAction(FacultyAction.UploadScore);
        renderSectionView();
    }

    /**
     * Handles Special Request button press event
     * <p/>
     * @param event The Action event
     */
    @FXML
    private void specialRequest(ActionEvent event)
    {
        Context.getInstance().setFacultyAction(FacultyAction.SpecialApproval);
        renderSectionView();
    }

    /**
     * Handles View Time Table button press event
     * <p/>
     * @param event The Action event
     */
    @FXML
    private void viewTimeTable(ActionEvent event)
    {
        Context.getInstance().setTimeTable(SectionTimeTable.getByFacultyMember(Context.getInstance().getCurrentUser().getFacultyMember()));
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("TimeTable");
    }

    /**
     * Handles Generate Report button press event
     * <p/>
     * @param event The Action event
     */
    @FXML
    private void generateReport(ActionEvent event)
    {
        Context.getInstance().setFacultyAction(FacultyAction.Reports);
        renderSectionView();
    }

    /**
     * Renders the section view on all button events
     */
    private void renderSectionView()
    {
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("faculty/SectionView");
    }

    /**
     * Initializes the controller class.
     * <p/>
     * @param url the url
     * @param rb  the resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
    }

    /**
     * The function initializes all the components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        btnUpdateScores.setText(LocaleManager.get(56));
        btnSpecialApproval.setText(LocaleManager.get(58));
        btnViewTimetable.setText(LocaleManager.get(18));
        btnReports.setText(LocaleManager.get(57));
    }
}
