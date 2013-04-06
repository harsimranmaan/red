/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.faculty;

import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class HomeViewController implements Initializable
{

    @FXML
    private Button btnViewTimetable;
    @FXML
    private AnchorPane disBrwCourseArea;
    @FXML
    private Hyperlink hplHome;
    @FXML
    private Hyperlink hplBrowseCourse;
    @FXML
    private AnchorPane homeView;
    @FXML
    private static Hyperlink hplDept;
    @FXML
    private static Hyperlink hplCourse;
    @FXML
    private AnchorPane commonButtonArea;
    @FXML
    private Button btnUpdateScores;
    @FXML
    private Button btnSpecialApproval;
    @FXML
    private Button btnReports;

    public static Hyperlink getCourseLk()
    {

        return hplCourse;
    }

    public static void setCourseLk(Hyperlink courseLk)
    {
        HomeViewController.hplCourse = courseLk;
    }

    public static Hyperlink getDeptLk()
    {
        return hplDept;
    }

    public static void setDeptLk(Hyperlink deptLk)
    {
        HomeViewController.hplDept = deptLk;
    }

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
        ViewLoader view = new ViewLoader(commonButtonArea);
        view.loadView("CommonButtons");
        view = new ViewLoader(Context.getInstance().getSearchView());
        view.loadView("SearchBox");
        initializeComponentsByLocale();
        Context.getInstance().setDisplayView(disBrwCourseArea);
    }

    private void initializeComponentsByLocale()
    {
        // TODO
        btnUpdateScores.setText(LocaleManager.get(56));
        btnSpecialApproval.setText(LocaleManager.get(58));
        btnViewTimetable.setText(LocaleManager.get(18));
        btnReports.setText(LocaleManager.get(57));
        hplHome.setText(LocaleManager.get(24) + ":");
    }
}
