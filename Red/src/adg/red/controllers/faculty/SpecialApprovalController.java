/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.paint.Color;

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
        if (studentNumber.getText().length() == 0)
        {
            lblErrMsg.setText("Please enter valid student number!");  //store label in database
        }
        else
        {
            try
            {
                int studentNum = Integer.parseInt(studentNumber.getText());
                student = Student.getStudentByStudentId(studentNum);
                lblName.setDisable(false);
                lblStudentInfo.setText(student.getUsername().getLastName() + ", " + student.getUsername().getFirstName());
                btnEnrol.setDisable(false);
            }
            catch (Exception ex)
            {
                lblErrMsg.setText("Student not found!"); //store label in database
                Logger.getLogger(SpecialApprovalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void approveRequest(ActionEvent event)
    {
        try
        {
            Enrolment enrolment = new Enrolment(student.getStudentId(), sec.getSectionId(), sec.getSectionPK().getCourseNumber(), sec.getSectionPK().getDepartmentId(), sec.getSectionPK().getTermYear(), sec.getSectionPK().getSessionId(), sec.getSectionPK().getSectionTypeId());
            enrolment.save();
            lblnotification.setText("Student enroled successfully!"); //store label in database
        }
        catch (Exception ex)
        {
            lblnotification.setText("Student already registered !"); // store label in database
            Logger.getLogger(SpecialApprovalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
//        Context.getInstance().setTitle(LocaleManager.get(56));
        Context.getInstance().setTitle("Special Approval");
        initializeComponentsByLocale();
        btnEnrol.setDisable(true);
        lblName.setDisable(true);
    }

    private void initializeComponentsByLocale()
    {
//        btnApprove.setText(LocaleManager.get(70));
//        btnSubmitNumber.setText(LocaleManager.get(71));
//        lblHeading.setText(LocaleManager.get(73));
//        lblName.setText(LocaleManager.get(74));
//        lblStudentInfo.setText(LocaleManager.get(28));
        btnEnrol.setText("Enrol");
        btnSubmitNumber.setText("Submit");
        lblHeading.setText("Please enter student number: ");
        lblName.setText("Student Name:");
        selectSection();
    }

    public void selectSection()
    {
        sec = Context.getInstance().getSelectedSection();
        lblDeptCoureNumber.setText(sec.getSectionPK().getDepartmentId() + " " + sec.getSectionPK().getCourseNumber());
        lblSecNumber.setText(Integer.toString(sec.getSectionId()));
        lblSession.setText(Session.getBySessionId(sec.getSectionPK().getSessionId()).getName());
    }
}
