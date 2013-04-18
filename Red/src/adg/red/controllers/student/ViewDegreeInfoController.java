/*
 * The controller class for ViewDegreeInfo.fxml.
 *
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.models.Enrolment;
import adg.red.models.Program;
import adg.red.models.Registration;
import adg.red.models.Student;
import adg.red.session.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class for ViewDegreeInfo.fxml.
 * <p/>
 * @author Jaspreet Thind
 */
public class ViewDegreeInfoController implements Initializable
{

    @FXML
    private TableColumn<Enrolment, String> colCourse;
    @FXML
    private TableView<Enrolment> tabViewDegree;
    @FXML
    private TableColumn<Enrolment, String> colTerm;
    @FXML
    private TableColumn<Enrolment, String> colScore;
    @FXML
    private TableColumn<Enrolment, String> colGrade;
    @FXML
    private TableColumn<Enrolment, String> colResult;
    @FXML
    private Label lblProgramName;
    @FXML
    private ProgressBar pbCreditProgress;
    @FXML
    private Label lblCredits;
    @FXML
    private TableColumn<Enrolment, Integer> colCourseCredit;

    /**
     * Initializes the controller class.
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        BreadCrumbController.renderBreadCrumb("student/HomeView|student/ViewDegreeInfo");
        Context.getInstance().setTitle(LocaleManager.get(85));
        initializeComponentsByLocale();

        Student student = Context.getInstance().getCurrentUser().getStudent();
        int sumCreditsByStudentId = Enrolment.getSumCreditsByStudentId(student.getStudentId());
        Program program = Registration.getCurrentRegistration(student).getProgram();
        lblProgramName.setText(program.getProgramPK().getProgramName());
        lblCredits.setText(sumCreditsByStudentId + "/" + program.getCreditsRequired());
        pbCreditProgress.setProgress((1.0 * sumCreditsByStudentId) / program.getCreditsRequired());
        populateEnrolmentTable(student);

    }

    /**
     * The function gets the list of enrolments of the student and populates to
     * the enrolment table.
     * <p/>
     * @param student the student to populate the enrolment table for
     */
    public void populateEnrolmentTable(Student student)
    {
        List<Enrolment> enrolments = Enrolment.getActiveEnrolmentsByStudentId(student.getStudentId());
        populate(enrolments);
    }

    /**
     * The functions populate the list of enrolments to the enrolment table.
     * <p/>
     * @param enrolments the list of enrolments
     */
    private void populate(List<Enrolment> enrolments)
    {
        colCourse.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("departmentIdAndCourseNumber"));
        colCourseCredit.setCellValueFactory(new PropertyValueFactory<Enrolment, Integer>("credits"));
        colTerm.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("termYearAndSession"));
        colScore.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("scoreAsString"));
        colGrade.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("grade"));
        colResult.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("result"));
        tabViewDegree.getItems().setAll(enrolments);
    }

    /**
     * The function initializes all components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        colCourse.setText(LocaleManager.get(93));
        colCourseCredit.setText(LocaleManager.get(103));
        colTerm.setText(LocaleManager.get(94));
        colScore.setText(LocaleManager.get(95));
        colGrade.setText(LocaleManager.get(96));
        colResult.setText(LocaleManager.get(97));
    }
}
