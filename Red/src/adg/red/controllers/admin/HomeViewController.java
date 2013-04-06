/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.admin;

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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class HomeViewController implements Initializable
{

    @FXML
    private Button btnDepartments;
    @FXML
    private Button btnPrograms;
    @FXML
    private Button btnCourses;
    @FXML
    private Button btnSections;
    @FXML
    private Button btnUsers;
    @FXML
    private Button btnGo;
    @FXML
    private Label lblSearch;
    @FXML
    private AnchorPane disViewArea;
    @FXML
    private Hyperlink hplHome;
    @FXML
    private static Hyperlink hplDept;
    @FXML
    private static Hyperlink hplCourse;
    @FXML
    private AnchorPane commonButtonArea;

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
    private void showDepartments(ActionEvent event)
    {
    }

    @FXML
    private void showPrograms(ActionEvent event)
    {
    }

    @FXML
    private void showCourses(ActionEvent event)
    {
    }

    @FXML
    private void showSections(ActionEvent event)
    {
    }

    @FXML
    private void showUsers(ActionEvent event)
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
        initializeComponentsByLocale();
        Context.getInstance().setDisplayView(disViewArea);
    }

    private void initializeComponentsByLocale()
    {
        // TODO
        btnDepartments.setText(LocaleManager.get(36));
        btnPrograms.setText(LocaleManager.get(37));
        btnSections.setText(LocaleManager.get(38));
        btnCourses.setText(LocaleManager.get(39));
        btnUsers.setText(LocaleManager.get(40));
        hplHome.setText(LocaleManager.get(24) + ":");
        lblSearch.setText(LocaleManager.get(25) + ":");
        btnGo.setText(LocaleManager.get(26));
    }
}
