/*
 * The controller class for EnrollmentView.fxml.
 *
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.models.Enrolment;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class for EnrollmentView.fxml.
 * <p/>
 * @author jingboyu
 */
public class EnrollmentViewController implements Initializable
{

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
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(19));
        BreadCrumbController.renderBreadCrumb("student/HomeView|student/EnrollmentView");
        List<Enrolment> enrolmentList = Enrolment.getEnrolmentsByStudentId(Context.getInstance().getCurrentUser().getStudent().getStudentId());

        populateEnrolmentTable(enrolmentList);
    }

    /**
     * The function populate the enrolmentList to the enrolment table.
     * <p/>
     * @param enrolmentList the list of enrolments to populate to the enrolment
     *                      table
     */
    private void populateEnrolmentTable(List<Enrolment> enrolmentList)
    {
        colSection.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("departmentAndCourseAndSection"));
        colActivity.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("activity"));
        colTerm.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("term"));
        colCredits.setCellValueFactory(new PropertyValueFactory<Enrolment, String>("credit"));
        tabDisplay.getItems().setAll(enrolmentList);
    }
}
