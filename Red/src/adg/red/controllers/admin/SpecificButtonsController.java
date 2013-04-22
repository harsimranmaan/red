/*
 *
 *
 */
package adg.red.controllers.admin;

import adg.red.controllers.DownloadFileController;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import adg.red.models.Enrolment;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.List;
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
    private Button btnUsers;
    @FXML
    private Button btnEnrolmentReport;

    @FXML
    private void saveEnrolments(ActionEvent event)
    {
        String content = createTemplateHeader();
        List<Enrolment> enrolList = Enrolment.getAllEnrolment();

        for (Enrolment enrol : enrolList)
        {
            content += Integer.toString(enrol.getStudent().getStudentId());
            content += ",";
            content += Integer.toString(enrol.getSection().getSectionId());
            content += ",";
            content += Integer.toString(enrol.getSection().getCourse().getCoursePK().getCourseNumber());
            content += ",";
            content += enrol.getSection().getCourse().getCoursePK().getDepartmentId();
            content += ",";
            content += Integer.toString(enrol.getSection().getTerm().getTermPK().getTermYear());
            content += ",";
            content += Integer.toString(enrol.getSection().getSectionPK().getSessionId());
            content += ",";
            content += Integer.toString(enrol.getSection().getSectionType().getSectionTypeId());
            content += ",";
            if (enrol.getScore() != null)
            {
                content += Integer.toString(enrol.getScore());
            }
            content += ",";
            if (enrol.getGradeId() != null)
            {
                content += Integer.toString(enrol.getGradeId().getGradeId());
            }
            content += ",";
            if (enrol.getResultId() != null)
            {
                content += Integer.toString(enrol.getResultId().getResultId());
            }
            content += ",";
            if (enrol.getIsActive())
            {
                content += Integer.toString(1);
            }
            else
            {
                content += Integer.toString(0);
            }
            content += "\r\n";
        }
        DownloadFileController.saveFile(content, "csv");
    }

    @FXML
    private void uploadUsers(ActionEvent event)
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
        btnUsers.setText(LocaleManager.get(40));
        btnEnrolmentReport.setText(LocaleManager.get(98));
    }

    /**
     * Creates the Header for the template
     * <p/>
     * @return The Header
     */
    private String createTemplateHeader()
    {
        String content = "#This is the report for all the enrolments in the system\r\n";
        content += "#Student id, Section id, Course number, Department id, Term year, Sesstion id, Section type id, Score, Grade id, Result id, isActive status\r\n";
        return content;
    }
}
