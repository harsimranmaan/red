/*
 * The controller class for Faculty Reports.fxml.
 *
 */
package adg.red.controllers.faculty;

import adg.red.controllers.DownloadFileController;
import adg.red.controllers.BreadCrumbController;
import adg.red.models.Enrolment;
import adg.red.models.Section;
import adg.red.models.Session;
import adg.red.models.Student;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class ReportsController implements Initializable
{

    @FXML
    private Label lblHeading2;
    @FXML
    private Label lblDeptCoureNumber;
    @FXML
    private Label lblSection;
    @FXML
    private Label lblSecNumber;
    @FXML
    private Label lblSession;
    @FXML
    private Label lblYear;
    @FXML
    private Label lblHeading;
    @FXML
    private CheckBox btnStudentNumber;
    @FXML
    private CheckBox btnFullName;
    @FXML
    private CheckBox btnEmail;
    @FXML
    private CheckBox btnScores;
    @FXML
    private Button btnGenerate;
    @FXML
    private Label lblnotification;
    private Section sec;
    private Student student;

    /**
     * Triggered on the mouse action event. Generates Reports for the viewing of
     * Faculty. Allows the faculty to download a report.
     * <p/>
     * @param event The action event
     */
    @FXML
    private void generateReport(ActionEvent event)
    {
        String content = createTemplateHeader();
        List<Enrolment> enrolList = Enrolment.getEnrolmentBySectionPK(Context.getInstance().getSelectedSection().getSectionPK());

        for (Enrolment enrol : enrolList)
        {
            content += "\r\n";
            if (btnFullName.isSelected())
            {
                content += enrol.getStudent().getUsername().getFirstName() + " " + enrol.getStudent().getUsername().getLastName() + ",";
            }
            if (btnStudentNumber.isSelected())
            {
                content += enrol.getStudent().getStudentId() + ",";
            }
            if (btnScores.isSelected())
            {
                content += enrol.getScore() + ",";
            }
            if (btnEmail.isSelected())
            {
                content += enrol.getStudent().getUsername().getEmail() + ",";
            }
            content += "\r\n";
        }
        DownloadFileController.saveFile(content, "csv");
        lblnotification.setText("Report successfully generated !");
        transitionEffect(lblnotification, "ON");
    }

    /**
     * Creates the Header for the template
     * <p/>
     * @return The Header
     */
    private String createTemplateHeader()
    {
        String header = new String();
        header += "This report request is generated by: " + ",";
        header += Context.getInstance().getSelectedSection().getFacultyMemberName() + "\r\n";
        header += "for the following Course: " + ",";
        header += Context.getInstance().getSelectedSection().getDepartmentIdAndCourseName() + ",";
        header += Context.getInstance().getSelectedSection().getTerm().getSession().getName() + ",";
        header += Context.getInstance().getSelectedSection().getTerm().getTermPK().getTermYear() + "\r\n" + "\r\n";

        if (btnFullName.isSelected())
        {
            header += "Full Name" + ",";
        }
        if (btnStudentNumber.isSelected())
        {
            header += "Student Number" + ",";
        }
        if (btnScores.isSelected())
        {
            header += "Score" + ",";
        }
        if (btnEmail.isSelected())
        {
            header += "Email" + ",";
        }
        header += "\r\n";
        return header;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        BreadCrumbController.renderBreadCrumb("faculty/HomeView|faculty/SectionView|faculty/Reports");
        Context.getInstance().setTitle(LocaleManager.get(57));
        initializeComponentsByLocale();
    }

    /**
     * The function initializes all the components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        btnEmail.setText(LocaleManager.get(86));
        btnFullName.setText(LocaleManager.get(87));
        btnScores.setText(LocaleManager.get(88));
        btnStudentNumber.setText(LocaleManager.get(89));
        btnGenerate.setText(LocaleManager.get(90));
        lblHeading.setText(LocaleManager.get(91));
        lblHeading2.setText(LocaleManager.get(92));
        selectSection();
    }

    /**
     * Fetches the data for the selected section and populates the report.
     */
    public void selectSection()
    {
        sec = Context.getInstance().getSelectedSection();
        lblDeptCoureNumber.setText(sec.getSectionPK().getDepartmentId() + " " + sec.getSectionPK().getCourseNumber());
        lblSecNumber.setText(Integer.toString(sec.getSectionId()));
        lblSession.setText(Session.getBySessionId(sec.getSectionPK().getSessionId()).getName());
    }

    /**
     * Operates and adds effect on the node depending on the action requested
     * <p/>
     * @param objectName is the node being updated
     * @param action     is the requested action
     */
    public void transitionEffect(Node objectName, String action)
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), objectName);
        if ("ON".equals(action))
        {
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        }
        else if ("OFF".equals(action))
        {
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.play();
        }
    }
}
