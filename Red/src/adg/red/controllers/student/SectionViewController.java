/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.models.CoRequisite;
import adg.red.models.Course;
import adg.red.models.Enrolment;
import adg.red.models.EnrolmentPK;
import adg.red.models.Prerequisite;
import adg.red.models.Section;
import adg.red.models.Session;
import adg.red.models.Student;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class SectionViewController implements Initializable
{

    @FXML //  fx:id="courseDesTxt"
    private TextArea courseDesTxt; // Value injected by FXMLLoader
    @FXML //  fx:id="courseNameLbl"
    private Label courseNameLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="secLbl"
    private Label secLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="creditLbl"
    private Label creditLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="deptIdAndCourseNoLbl"
    private Label deptIdAndCourseNoLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="gradingSchmLbl"
    private Label gradingSchmLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="passRqLbl"
    private Label passRqLbl; // Value injected by FXMLLoader
    @FXML //  fx:id="btnRegister"
    private Button btnRegister; // Value injected by FXMLLoader
    @FXML //  fx:id="btnDrop"
    private Button btnDrop; // Value injected by FXMLLoader
    @FXML //  fx:id="lblResponse"
    private Label lblResponse; // Value injected by FXMLLoader
    @FXML //  fx:id="lblSecType"
    private Label lblSecType; // Value injected by FXMLLoader
    @FXML //  fx:id="lblSession"
    private Label lblSession; // Value injected by FXMLLoader
    @FXML //  fx:id="lblTermYear"
    private Label lblTermYear; // Value injected by FXMLLoader
    @FXML //  fx:id="lsvOutstandPrereq"
    private ListView<Prerequisite> lsvOutstandPrereq; // Value injected by FXMLLoader
    @FXML //  fx:id="lsvOutstandCoReq"
    private ListView<CoRequisite> lsvOutstandCoReq; // Value injected by FXMLLoader
    @FXML //  fx:id="disView"
    private AnchorPane disView; // Value injected by FXMLLoader
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
            else if (!checkStudentPrereq(section.getCourse()).isEmpty())
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
        lblSession.setText(Session.getBySessionId(Context.getInstance().getSelectedSection().getSectionPK().getSessionId()).getName());
        lblTermYear.setText(Integer.toString(Context.getInstance().getSelectedSection().getTerm().getTermPK().getTermYear()));
        populatePrereqListView(Context.getInstance().getSelectedCourse());
        populateCoReqListView(Context.getInstance().getSelectedCourse());

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

        // action when user clicked on coreq list view
        lsvOutstandCoReq.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    //handle no records click
                    if (lsvOutstandCoReq.getSelectionModel().getSelectedItem() != null)
                    {
                        Context.getInstance().setSelectedCourse(lsvOutstandCoReq.getSelectionModel().getSelectedItem().getCourse1());
                        Context.getInstance().setSelectedDepartment(lsvOutstandCoReq.getSelectionModel().getSelectedItem().getCourse1().getDepartment());
                        ViewLoader view = new ViewLoader(disView);
                        view.loadView("student/CourseView");
                    }
                }
                catch (Exception ex)
                {
                    Logger.getLogger(CourseViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // action when user clicked on prereq list view
        lsvOutstandPrereq.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    //handle no records click
                    if (lsvOutstandPrereq.getSelectionModel().getSelectedItem() != null)
                    {
                        Context.getInstance().setSelectedCourse(lsvOutstandPrereq.getSelectionModel().getSelectedItem().getCourse());
                        Context.getInstance().setSelectedDepartment(lsvOutstandPrereq.getSelectionModel().getSelectedItem().getCourse().getDepartment());
                        ViewLoader view = new ViewLoader(disView);
                        view.loadView("student/CourseView");
                    }
                }
                catch (Exception ex)
                {
                    Logger.getLogger(CourseViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private List<Prerequisite> checkStudentPrereq(Course course)
    {
        List<Prerequisite> prereqList = null;

        try
        {
            List<Enrolment> enrolList = Enrolment.getEnrolmentsByStudentId(Context.getInstance().getCurrentUser().getStudent().getStudentId());
            prereqList = Prerequisite.getByCourse(course);
            if (prereqList.isEmpty())
            {
                return prereqList;
            }

            for (int i = 0; i < prereqList.size(); i++)
            {
                for (Enrolment enrol : enrolList)
                {
                    if (prereqList.get(i).getCourse().equals(enrol.getSection().getCourse()))
                    {
                        if (enrol.getResultId() != null)
                        {
                            if (enrol.getResultId().getName().equalsIgnoreCase("pass"))
                            {
                                prereqList.remove(i);
                                if (prereqList.isEmpty())
                                {
                                    return prereqList;
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return prereqList;
    }

    private List<CoRequisite> checkStudentCoReq(Course course)
    {
        List<CoRequisite> coReqList = null;

        try
        {
            List<Enrolment> enrolList = Enrolment.getEnrolmentsByStudentId(Context.getInstance().getCurrentUser().getStudent().getStudentId());
            coReqList = CoRequisite.getByCourse(course);
            if (coReqList.isEmpty())
            {
                return coReqList;
            }
            for (int i = 0; i < coReqList.size(); i++)
            {
                for (Enrolment enrol : enrolList)
                {
                    if (coReqList.get(i).getCourse().equals(enrol.getSection().getCourse()))
                    {
                        if (enrol.getResultId() != null)
                        {

                            if (enrol.getResultId().getName().equalsIgnoreCase("pass"))
                            {
                                coReqList.remove(i);
                                if (coReqList.isEmpty())
                                {
                                    return coReqList;
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return coReqList;
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

    public void populatePrereqListView(Course selectedCourse)
    {
        final List<Prerequisite> prereq = checkStudentPrereq(selectedCourse);

        lsvOutstandPrereq.setCellFactory(new Callback<ListView<Prerequisite>, ListCell<Prerequisite>>()
        {
            @Override
            public ListCell<Prerequisite> call(ListView<Prerequisite> param)
            {
                ListCell<Prerequisite> cell = new ListCell<Prerequisite>()
                {
                    @Override
                    public void updateItem(Prerequisite pre, boolean bln)
                    {
                        super.updateItem(pre, bln);
                        if (pre != null)
                        {
                            this.setText(pre.getPrerequisitePK().getPreRequisiteDeptId() + " " + pre.getPrerequisitePK().getPreRequisiteNumber());
                        }
                    }
                };
                return cell;
            }
        });
        lsvOutstandPrereq.getItems().setAll(prereq);
    }

    public void populateCoReqListView(Course selectedCourse)
    {
        final List<CoRequisite> correq = checkStudentCoReq(selectedCourse);

        lsvOutstandCoReq.setCellFactory(new Callback<ListView<CoRequisite>, ListCell<CoRequisite>>()
        {
            @Override
            public ListCell<CoRequisite> call(ListView<CoRequisite> param)
            {
                ListCell<CoRequisite> cell = new ListCell<CoRequisite>()
                {
                    @Override
                    public void updateItem(CoRequisite co, boolean bln)
                    {
                        super.updateItem(co, bln);
                        if (co != null)
                        {
                            this.setText(co.getCoRequisitePK().getDepartmentId() + " " + co.getCoRequisitePK().getCoRequisiteNumber());
                        }
                    }
                };
                return cell;
            }
        });
        lsvOutstandCoReq.getItems().setAll(correq);
    }
}
