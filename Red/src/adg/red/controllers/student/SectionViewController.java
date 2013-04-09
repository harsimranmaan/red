/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import adg.red.utils.DateFormatter;
import java.util.Date;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
    private Label lblCreditName;
    @FXML
    private Label lblGrading;
    @FXML
    private Label lblPassReq;
    @FXML
    private Label lblTerm;
    @FXML
    private Label lblEnd;
    @FXML
    private Label lblStart;
    @FXML
    private Label lblOutPrereq;
    @FXML
    private Label lblOutCoReq;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnDrop;
    @FXML
    private Label lblResponse;
    @FXML
    private Label lblSecType;
    @FXML
    private Label lblSession;
    @FXML
    private Label lblTermYear;
    @FXML
    private Label lblStartDate;
    @FXML
    private Label lblEndDate;
    @FXML
    private Label lblRegisDL;
    @FXML
    private Label lblRegisDLDate;
    @FXML
    private Label lblDropDL;
    @FXML
    private Label lblDropDLDate;
    @FXML
    private ListView<Prerequisite> lsvOutstandPrereq;
    @FXML
    private ListView<CoRequisite> lsvOutstandCoReq;
    private Enrolment enrolment = null;
    private EnrolmentPK enrolmentPk;
    @FXML
    private Font x1;
    @FXML
    private Font x2;
    @FXML
    private Color x3;
    @FXML
    private Label lblRegDLResponse;
    @FXML
    private Label lblDropDLResponse;

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

    @FXML
    private void showPreReq(MouseEvent event)
    {
        if (lsvOutstandPrereq.getSelectionModel().getSelectedItem() != null)
        {
            Context.getInstance().setSelectedCourse(lsvOutstandPrereq.getSelectionModel().getSelectedItem().getCourse());
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("student/CourseView");
        }
    }

    @FXML
    private void showCoReq(MouseEvent event)
    {
        if (lsvOutstandCoReq.getSelectionModel().getSelectedItem() != null)
        {
            Context.getInstance().setSelectedCourse(lsvOutstandCoReq.getSelectionModel().getSelectedItem().getCourse1());
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("student/CourseView");
        }
    }

    @FXML
    private void register(ActionEvent event)
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

    @FXML
    private void drop(ActionEvent event)
    {
        enrolment.setIsActive(false);
        enrolment.save();
        lblResponse.setText(LocaleManager.get(32));
        lblResponse.setVisible(true);
        toggleRegDropButtons();
    }

    private void initializeComponentsByLocale()
    {
        lblCreditName.setText(LocaleManager.get(42) + ":");
        lblGrading.setText(LocaleManager.get(63) + ":");
        lblPassReq.setText(LocaleManager.get(64) + ":");
        lblTerm.setText(LocaleManager.get(65) + ":");
        lblStart.setText(LocaleManager.get(46) + ":");
        lblEnd.setText(LocaleManager.get(45) + ":");
        lblOutPrereq.setText(LocaleManager.get(66));
        lblOutCoReq.setText(LocaleManager.get(67));
        lblRegisDL.setText(LocaleManager.get(101) + ":");
        lblDropDL.setText(LocaleManager.get(102) + ":");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(62));
        BreadCrumbController.renderBreadCrumb("student/HomeView|student/BrowseCourse|student/CourseListView|student/CourseView|student/SectionView");
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
                checkAllDeadlines();
            }
            else if (!checkStudentPrereq(section.getCourse()).isEmpty())
            {
                btnRegister.setDisable(true);
                lblResponse.setText(LocaleManager.get(35));
                lblResponse.setVisible(true);
            }
            else
            {
                checkAllDeadlines();
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeComponentsByLocale();
        secLbl.setText(LocaleManager.get(74) + " " + Context.getInstance().getSelectedSection().getSectionPK().getSectionId());
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
        lblStartDate.setText(DateFormatter.formatDate(Context.getInstance().getSelectedSection().getStartDate()));
        lblEndDate.setText(DateFormatter.formatDate(Context.getInstance().getSelectedSection().getEndDate()));
        lblRegisDLDate.setText(DateFormatter.formatDate(Context.getInstance().getSelectedSection().getRegisterDeadline()));
        lblDropDLDate.setText(DateFormatter.formatDate(Context.getInstance().getSelectedSection().getDropDeadline()));
    }

    private boolean checkDeadLinePassed(Date deadline)
    {
        Date current = new Date();
        // after a deadline
        if (current.compareTo(deadline) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
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
                                i--;
                                if (prereqList.isEmpty())
                                {
                                    return prereqList;
                                }
                                break;
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
                                i--;
                                if (coReqList.isEmpty())
                                {
                                    return coReqList;
                                }
                                break;
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

    private boolean checkAllDeadlines()
    {
        boolean result = true;
        if (checkDeadLinePassed(Context.getInstance().getSelectedSection().getRegisterDeadline()))
        {
            btnRegister.setDisable(true);
            lblRegDLResponse.setText(LocaleManager.get(104));
            lblRegDLResponse.setVisible(true);
            result = false;
        }
        if (checkDeadLinePassed(Context.getInstance().getSelectedSection().getDropDeadline()))
        {
            btnDrop.setDisable(true);
            lblDropDLResponse.setText(LocaleManager.get(104));
            lblDropDLResponse.setVisible(true);
            result = false;
        }
        return result;
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
