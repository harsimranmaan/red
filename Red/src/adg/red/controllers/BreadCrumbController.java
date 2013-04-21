/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class for the path names of each user interface
 * <p/>
 * @author harsimran.maan
 */
public class BreadCrumbController implements Initializable
{

    private static String[] paths;
    @FXML
    private HBox hBoxBreadCrumb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        int length = paths.length;
        int looper = 0;
        hBoxBreadCrumb.getChildren().clear();
        for (; looper < length - 1; looper++)
        {
            String filePath = paths[looper];
            Hyperlink link = new Hyperlink();
            link.setId(filePath);
            link.setText(getDisplayNameByKey(filePath));
            link.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
                    view.loadView(((Hyperlink) event.getSource()).getId());
                }
            });
            hBoxBreadCrumb.getChildren().add(link);
            hBoxBreadCrumb.getChildren().add(new Label(" > "));
        }
        Hyperlink link = new Hyperlink();
        link.setText(getDisplayNameByKey(paths[looper]));
        hBoxBreadCrumb.getChildren().add(link);
    }

    /**
     * initializes the name of views by locality.
     * @param key the name displayed on each view
     * @return name of each view
     */
    private String getDisplayNameByKey(String key)
    {
        String name = "";
        switch (key)
        {
            case "student/HomeView":
            case "admin/HomeView":
            case "faculty/HomeView":
                name = LocaleManager.get(24);
                break;
            case "FaqView":
                name = LocaleManager.get(16);
                break;
            case "Glossary":
                name = LocaleManager.get(14);
                break;
            case "Message":
                name = LocaleManager.get(22);
                break;
            case "UserProfile":
                name = LocaleManager.get(15);
                break;
            case "student/BrowseCourse":
                name = LocaleManager.get(59);
                break;
            case "student/CourseListView":
                name = Context.getInstance().getSelectedDepartment().getDepartmentId();
                break;
            case "student/CourseView":
                name = Integer.toString(Context.getInstance().getSelectedCourse().getCoursePK().getCourseNumber());
                break;
            case "student/SectionView":
                name = "Section " + Integer.toString(Context.getInstance().getSelectedSection().getSectionId());
                break;
            case "student/EnrollmentView":
                name = LocaleManager.get(98);
                break;
            case "faculty/SectionView":
                name = LocaleManager.get(69);
                break;
            case "faculty/Reports":
                name = LocaleManager.get(57);
                break;
            case "faculty/UploadScore":
                name = LocaleManager.get(56);
                break;
            case "faculty/SpecialApproval":
                name = LocaleManager.get(58);
                break;
            case "TimeTable":
                name = LocaleManager.get(68);
                break;
            case "student/ViewDegreeInfo":
                name = LocaleManager.get(85);
                break;

            default:
                break;
        }
        return name;
    }

    /**
     * get path name and load the view
     * @param path path of the view name
     */
    public static void renderBreadCrumb(String path)
    {
        paths = path.split("\\|");

        ViewLoader view = new ViewLoader(Context.getInstance().getBreadCrumb());
        view.loadView("BreadCrumb");
    }
}
