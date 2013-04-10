/*
 * 
 * 
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.models.Course;
import adg.red.models.Enrolment;
import adg.red.models.Registration;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jingboyu
 */
public class EnrollmentViewController implements Initializable {

    @FXML
    private TableColumn<Enrolment, String> colSection;
    @FXML
    private TableColumn<Enrolment, String> colActivity;
    @FXML
    private TableColumn<Enrolment, String> colTerm;
    @FXML
    private TableColumn<Enrolment, String> colCredits;
    @FXML
    private TableView<Enrolment> tabDisplay;    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Context.getInstance().setTitle(LocaleManager.get(106)); 
        BreadCrumbController.renderBreadCrumb("student/HomeView|student/EnrollmentView"); 
        List<Enrolment> enrolmentList = Enrolment.getActiveEnrolmentsByStudentId(Context.getInstance().getCurrentUser().getStudent().getStudentId());
        populateEnrolmentTable(enrolmentList);
    }
    
    private void populateEnrolmentTable(List<Enrolment> enrolmentList)
    {
        colSection.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("departmentAndCourseAndSection"));
        colActivity.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("activity"));
        colTerm.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("term"));
        colCredits.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("credit"));
        tabDisplay.getItems().setAll(enrolmentList);
    }
}

