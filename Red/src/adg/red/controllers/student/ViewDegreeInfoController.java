/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.models.Enrolment;
import adg.red.models.Program;
import adg.red.models.Registration;
import adg.red.models.Student;
import adg.red.utils.Context;
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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 * <p/>
 * @author jayzt_000
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

    /**
     * Initializes the controller class.
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

    public void populateEnrolmentTable(Student student)
    {
        List<Enrolment> enrolments = Enrolment.getActiveEnrolmentsByStudentId(student.getStudentId());
        populate(enrolments);
    }

    private void populate(List<Enrolment> enrolments)
    {
        colCourse.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("departmentIdAndCourseNumber"));
        colTerm.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("termYearAndSession"));
        colScore.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("scoreAsString"));
        colGrade.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("grade"));
        colResult.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("result"));
        tabViewDegree.getItems().setAll(enrolments);
    }

    private void initializeComponentsByLocale()
    {
        colCourse.setText(LocaleManager.get(93));
        colTerm.setText(LocaleManager.get(94));
        colScore.setText(LocaleManager.get(95));
        colGrade.setText(LocaleManager.get(96));
        colResult.setText(LocaleManager.get(97));
    }
}
