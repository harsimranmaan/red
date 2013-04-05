/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    @FXML //  fx:id="btnBrowseCourse"
    private Button btnBrowseCourse; // Value injected by FXMLLoader
    @FXML //  fx:id="btnMessage"
    private Button btnMessage; // Value injected by FXMLLoader
    @FXML //  fx:id="btnViewDegreeInfo"
    private Button btnViewDegreeInfo; // Value injected by FXMLLoader
    @FXML //  fx:id="btnViewEnrolment"
    private Button btnViewEnrolment; // Value injected by FXMLLoader
    @FXML //  fx:id="btnViewTimetable"
    private Button btnViewTimetable; // Value injected by FXMLLoader
    @FXML //  fx:id="btnFaq"
    private Button btnFaq; // Value injected by FXMLLoader
    @FXML //  fx:id="btnGlossary"
    private Button btnGlossary; // Value injected by FXMLLoader
    @FXML //  fx:id="btnGo"
    private Button btnGo; // Value injected by FXMLLoader
    @FXML //  fx:id="lblSearch"
    private Label lblSearch; // Value injected by FXMLLoader
    @FXML //  fx:id="lblUserType"
    private Label lblUserType; // Value injected by FXMLLoader
    @FXML //  fx:id="disBrwCourseArea"
    private AnchorPane disBrwCourseArea; // Value injected by FXMLLoader
    @FXML //  fx:id="homeLk"
    private Hyperlink hplHome; // Value injected by FXMLLoader
    @FXML //  fx:id="browseCourseLk"
    private Hyperlink hplBrowseCourse; // Value injected by FXMLLoader
    @FXML //  fx:id="homeView"
    private AnchorPane homeView; // Value injected by FXMLLoader
    @FXML //  fx:id="deptLk"
    private static Hyperlink hplDept; // Value injected by FXMLLoader
    @FXML //  fx:id="courseLk"
    private static Hyperlink hplCourse; // Value injected by FXMLLoader
    @FXML //fx:id="btnLogout"
    private Button btnLogout; // Value injected by FXMLoader
    @FXML //fx:id="userProfileBtn" // added by Jingbo Yu
    private Button btnUserProfile; // Value injected by FXMLoader

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
    private Label menuLk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
        // setOnAction when browse course button is pressed
        btnBrowseCourse.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(disBrwCourseArea);
                    view.loadView("student/BrowseCourse");
                    hplBrowseCourse.setVisible(true);
                    hplBrowseCourse.setText(LocaleManager.get(7) + ":");
                    hplDept.setVisible(false);
                    hplCourse.setVisible(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        // setOnAction when faq button is pressed
        btnFaq.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(disBrwCourseArea);
                    view.loadView("FaqView");
                    hplBrowseCourse.setVisible(true);
                    hplBrowseCourse.setText(LocaleManager.get(16));
                    hplDept.setVisible(false);
                    hplCourse.setVisible(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        btnMessage.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(disBrwCourseArea);
                    view.loadView("Message");
                    hplBrowseCourse.setVisible(true);
                    hplBrowseCourse.setText(LocaleManager.get(22));
                    hplDept.setVisible(false);
                    hplCourse.setVisible(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        // setOnAction when personal info button is pressed added by Jingbo Yu
        btnUserProfile.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(disBrwCourseArea);
                    view.loadView("student/UserProfile");
                    hplBrowseCourse.setVisible(true);
                    hplBrowseCourse.setText(LocaleManager.get(15));
                    hplDept.setVisible(false);
                    hplCourse.setVisible(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
                // setOnAction when personal info button is pressed added by Jingbo Yu
        btnGlossary.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(disBrwCourseArea);
                    view.loadView("Glossary");
                    hplBrowseCourse.setVisible(true);
                    hplBrowseCourse.setText(LocaleManager.get(17)); // to do ??? dont know which one is for glossary
                    hplDept.setVisible(false);
                    hplCourse.setVisible(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

//        // setOnAction when home link is clicked
        hplHome.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(homeView);
                    view.loadView("HomeView");
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // setOnAction when browse course link is clicked
        hplBrowseCourse.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    if (((Hyperlink) event.getSource()).getText().contains("Browse"))
                    {
                        ViewLoader view = new ViewLoader(disBrwCourseArea);
                        view.loadView("student/BrowseCourse");
                        hplDept.setVisible(false);
                        hplCourse.setVisible(false);
                        hplDept.setVisited(false);
                        hplCourse.setVisited(false);
                    }
                    if (((Hyperlink) event.getSource()).getText().contains("faq"))
                    {
                        ViewLoader view = new ViewLoader(disBrwCourseArea);
                        view.loadView("FaqView");
                    }
                    hplBrowseCourse.setVisited(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // setOnAction when dept link is clicked
        hplDept.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(disBrwCourseArea);
                    view.loadView("student/CourseListView");
                    hplCourse.setVisible(false);
                    hplDept.setVisited(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // setOnAction when course link is clicked
        hplCourse.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    ViewLoader view = new ViewLoader(disBrwCourseArea);
                    view.loadView("student/CourseView");
                    hplCourse.setVisited(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // setOnAction when logout link is clicked
        btnLogout.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {

                    ViewLoader view = new ViewLoader(homeView);
                    Context.getInstance().setWasLoggedIn(true);
                    view.loadView("Login");
                }
                catch (Exception ex)
                {
                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void initializeComponentsByLocale()
    {
        // TODO
        btnBrowseCourse.setText(LocaleManager.get(7));
        btnViewTimetable.setText(LocaleManager.get(18));
        btnViewEnrolment.setText(LocaleManager.get(19));
        btnViewDegreeInfo.setText(LocaleManager.get(20));
        btnUserProfile.setText(LocaleManager.get(21));
        btnMessage.setText(LocaleManager.get(22));
        btnGlossary.setText(LocaleManager.get(14));
        btnFaq.setText(LocaleManager.get(16));
        btnLogout.setText(LocaleManager.get(8));
        lblUserType.setText(LocaleManager.get(23) + ":");
        hplHome.setText(LocaleManager.get(24) + ":");
        lblSearch.setText(LocaleManager.get(25) + ":");
        btnGo.setText(LocaleManager.get(26));
    }
}
