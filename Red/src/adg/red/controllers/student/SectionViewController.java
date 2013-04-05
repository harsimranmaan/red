/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.models.Course;
import adg.red.models.Enrolment;
import adg.red.models.EnrolmentPK;
import adg.red.models.Prerequisite;
import adg.red.models.Section;
import adg.red.models.Student;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class SectionViewController implements Initializable
{

    @FXML 
    private TextArea courseDesTxt; 
    @FXML 
    private Label courseNameLbl; 
    @FXML 
    private Label secLbl; 
    @FXML 
    private Label creditLbl; 
    @FXML 
    private Label deptIdAndCourseNoLbl; 
    @FXML 
    private Label gradingSchmLbl; 
    @FXML 
    private Label passRqLbl; 
    @FXML 
    private ListView<String> dateLv; 
    @FXML 
    private Button btnRegister; 
    @FXML 
    private Button btnDrop; 
    @FXML 
    private Label lblResponse; 
    @FXML 
    private Label lblSecType; 
    private Enrolment enrolment = null;
    private EnrolmentPK enrolmentPk;

    private void toggleRegDropButtons()
    {
        //check to see if the student has already dropped the section
        if (enrolment.getIsActive())
        {
            btnRegister.setDisable(true);
            btnDrop.setDisable(false);
        }
        else
        {
            btnRegister.setDisable(true);
            btnDrop.setDisable(true);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        try
        {
            Section section = Context.getInstance().getSelectedSection();
            enrolmentPk = new EnrolmentPK(Student.getStudentByUsername(Context.getInstance().getCurrentUser()).getStudentId(),
                    section.getSectionId(),
                    section.getCourse().getCoursePK().getCourseNumber(),
                    section.getCourse().getCoursePK().getDepartmentId(),
                    section.getTerm().getTermPK().getTermYear(),
                    section.getTerm().getTermPK().getSessionId(),
                    section.getSectionType().getSectionTypeId());

            if (checkStudentAlreadyEnrolled(enrolmentPk))
            {
                toggleRegDropButtons();
            }
            else if (!checkStudentPrereq(section.getCourse()))
            {
                btnRegister.setDisable(true);
                lblResponse.setText(LocaleManager.get(35));
                lblResponse.setVisible(true);
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        secLbl.setText("Section " + Context.getInstance().getSelectedSection().getSectionPK().getSectionId());
        creditLbl.setText(Integer.toString(Context.getInstance().getSelectedCourse().getCredits()));
        passRqLbl.setText(Context.getInstance().getSelectedCourse().getPassingRequirement());
        courseDesTxt.setText(Context.getInstance().getSelectedCourse().getDescription());
        courseNameLbl.setText(Context.getInstance().getSelectedCourse().getName());
        deptIdAndCourseNoLbl.setText(Context.getInstance().getSelectedCourse().getDepartmentIdAndCourseNumber());
        gradingSchmLbl.setText(Context.getInstance().getSelectedCourse().getGradingSchemeId().getName());
        lblSecType.setText("(" + Context.getInstance().getSelectedSection().getSectionType().getName() + ")");

        // setOnAction when register button is pressed
        btnRegister.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {

                    if (enrolment == null)
                    {
                        //first time
                        enrolment = new Enrolment(enrolmentPk);
                    }
                    enrolment.setIsActive(true);
                    enrolment.save();
                    lblResponse.setText(LocaleManager.get(10));
                    lblResponse.setVisible(true);
                    toggleRegDropButtons();
                }
                catch (Exception ex)
                {
                    Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        // setOnAction when drop button is pressed
        //should fire only when we have an enrolment selected
        btnDrop.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    enrolment.setIsActive(false);
                    enrolment.save();
                    lblResponse.setText(LocaleManager.get(32));
                    lblResponse.setVisible(true);
                    toggleRegDropButtons();
                }
                catch (Exception ex)
                {
                    Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private boolean checkStudentPrereq(Course course)
    {
        boolean hasAllPrereq = true;
        try
        {
            List<Enrolment> enrolList = Enrolment.getEnrolmentsByStudentId(Context.getInstance().getCurrentUser().getStudent().getStudentId());
            List<Prerequisite> prereqList = Prerequisite.getByCourse(course);
            if (prereqList.isEmpty())
            {
                return true;
            }
            for (Prerequisite prereq : prereqList)
            {
                for (Enrolment enrol : enrolList)
                {
                    if ((enrol.getEnrolmentPK().getCourseNumber() == prereq.getPrerequisitePK().getPreRequisiteNumber())
                            && (enrol.getEnrolmentPK().getDepartmentId().equals(prereq.getPrerequisitePK().getPreRequisiteDeptId())))
                    {
                        if (!enrol.getResultId().getName().equalsIgnoreCase("pass"))
                        {
                            hasAllPrereq = false;
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasAllPrereq;

    }

    private boolean checkStudentAlreadyEnrolled(EnrolmentPK enrolPk)
    {
        try
        {
            enrolment = Enrolment.getEnrolmentByEnrolmentPK(enrolPk);
            return true;
        }
        catch (Exception ex)
        {
            enrolment = null;
            return false;
        }
    }

    private void populateList()
    {
        dateLv.setItems(null);
    }
}
