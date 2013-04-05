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

    @FXML
    private Button btnBrowseCourse;
    @FXML
    private Button btnMessage;
    @FXML
    private Button btnViewDegreeInfo;
    @FXML
    private Button btnViewEnrolment;
    @FXML
    private Button btnViewTimetable;
    @FXML
    private Button btnFaq;
    @FXML
    private Button btnGlossary;
    @FXML
    private Button btnGo;
    @FXML
    private Label lblSearch;
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
    private Button btnLogout;
    @FXML  // added by Jingbo Yu
    private Button btnUserProfile;

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

//                // setOnAction when personal info button is pressed added by Jingbo Yu
//        glossaryBtn.setOnAction(new EventHandler<ActionEvent>()
//        {
//            @Override
//            public void handle(ActionEvent event)
//            {
//                try
//                {
//                    ViewLoader view = new ViewLoader(disBrwCourseArea);
//                    view.loadView("Glossary");
//                    browseCourseLk.setVisible(true);
//                    browseCourseLk.setText(LocaleManager.get(14));
//                    deptLk.setVisible(false);
//                    courseLk.setVisible(false);
//                }
//                catch (Exception ex)
//                {
//                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });
//
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
        hplHome.setText(LocaleManager.get(24) + ":");
        lblSearch.setText(LocaleManager.get(25) + ":");
        btnGo.setText(LocaleManager.get(26));
    }
}
