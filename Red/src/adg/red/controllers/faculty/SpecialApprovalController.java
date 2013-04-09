/*
 * 
 * 
 */
package adg.red.controllers.faculty;

import adg.red.models.Enrolment;
import adg.red.models.Section;
import adg.red.models.Session;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import adg.red.models.Student;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * FXML Controller class
 * <p/>
 * @author Bahman
 */
public class SpecialApprovalController implements Initializable
{

    @FXML
    private Label lblHeading;
    @FXML
    private TextField studentNumber;
    @FXML
    private Button btnSubmitNumber;
    @FXML
    private Label lblName;
    @FXML
    private Label lblStudentInfo;
    private Section sec;
    @FXML
    private Label lblErrMsg;
    @FXML
    private Button btnEnrol;
    private Student student;
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
    private Label lblnotification;

    @FXML
    private void pullStudentInfo(ActionEvent event)
    {
        transitionEffect(lblnotification, "OFF");
        transitionEffect(lblErrMsg, "OFF");

        if (studentNumber.getText().length() == 0)
        {
            lblErrMsg.setText(LocaleManager.get(78));
            transitionEffect(lblErrMsg, "ON");
            btnEnrol.setDisable(true);
        }
        else
        {
            try
            {
                transitionEffect(lblErrMsg, "OFF");
                int studentNum = Integer.parseInt(studentNumber.getText());
                student = Student.getStudentByStudentId(studentNum);
                lblName.setDisable(false);
                transitionEffect(lblName, "ON");
                lblStudentInfo.setText(student.getUsername().getLastName() + ", " + student.getUsername().getFirstName());
                transitionEffect(lblStudentInfo, "ON");
                btnEnrol.setDisable(false);
            }
            catch (Exception ex)
            {
                lblErrMsg.setText(LocaleManager.get(34));
                transitionEffect(lblErrMsg, "ON");
                Logger.getLogger(SpecialApprovalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void approveRequest(ActionEvent event)
    {
        try
        {
            transitionEffect(lblnotification, "OFF");
            Enrolment enrolment = new Enrolment(student.getStudentId(), sec.getSectionId(), sec.getSectionPK().getCourseNumber(), sec.getSectionPK().getDepartmentId(), sec.getSectionPK().getTermYear(), sec.getSectionPK().getSessionId(), sec.getSectionPK().getSectionTypeId());
            enrolment.save();
            lblnotification.setText(LocaleManager.get(79));
            transitionEffect(lblnotification, "ON");
            btnEnrol.setDisable(true);
        }
        catch (Exception ex)
        {
            lblnotification.setText(LocaleManager.get(80));
            transitionEffect(lblnotification, "ON");
            btnEnrol.setDisable(true);
            transitionEffect(btnEnrol, "ON");
            lblName.setDisable(true);
            transitionEffect(lblName, "ON");
            Logger.getLogger(SpecialApprovalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        Context.getInstance().setTitle(LocaleManager.get(58));
        initializeComponentsByLocale();
        btnEnrol.setDisable(true);
        lblName.setDisable(true);
    }

    private void initializeComponentsByLocale()
    {
        btnEnrol.setText(LocaleManager.get(81));
        btnSubmitNumber.setText(LocaleManager.get(82));
        lblHeading.setText(LocaleManager.get(83));
        lblName.setText(LocaleManager.get(84));
        selectSection();
    }

    public void selectSection()
    {
        sec = Context.getInstance().getSelectedSection();
        lblDeptCoureNumber.setText(sec.getSectionPK().getDepartmentId() + " " + sec.getSectionPK().getCourseNumber());
        lblSecNumber.setText(Integer.toString(sec.getSectionId()));
        lblSession.setText(Session.getBySessionId(sec.getSectionPK().getSessionId()).getName());
    }

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
