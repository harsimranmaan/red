/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Enrolment;
import adg.red.models.Student;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.RedEntityManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
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
    @FXML //  fx:id="dateLv"
    private ListView<String> dateLv; // Value injected by FXMLLoader
    @FXML //  fx:id="btnRegister"
    private Button btnRegister; // Value injected by FXMLLoader
    @FXML //  fx:id="btnDrop"
    private Button btnDrop; // Value injected by FXMLLoader
    @FXML //  fx:id="lblResponse"
    private Label lblResponse; // Value injected by FXMLLoader
    
    private Enrolment enrolment = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        try
        {
            enrolment = new Enrolment(Student.getStudentByUsername(Context.getInstance().getCurrentUser()).getStudentId(), 
                            Context.getInstance().getSelectedSection().getSectionId(), 
                            Context.getInstance().getSelectedSection().getCourse().getCoursePK().getCourseNumber(),
                            Context.getInstance().getSelectedDepartment().getDepartmentId(),
                            Context.getInstance().getSelectedSection().getTerm().getTermId()
                            );           
        }
        catch (Exception ex)
        {
            Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(checkUserAlreadyEnrolled(enrolment))
        {
            btnRegister.setDisable(true);
            btnDrop.setDisable(false);
        }
        
        secLbl.setText("Secion " + Context.getInstance().getSelectedSection().getSectionPK().getSectionId());
        creditLbl.setText("" + Context.getInstance().getSelectedCourse().getCredits());
        passRqLbl.setText(Context.getInstance().getSelectedCourse().getPassingRequirement());
        courseDesTxt.setText(Context.getInstance().getSelectedCourse().getDescription());
        courseNameLbl.setText(Context.getInstance().getSelectedCourse().getName());
        deptIdAndCourseNoLbl.setText(Context.getInstance().getSelectedCourse().getDepartmentIdAndCourseNumber());
        gradingSchmLbl.setText(Context.getInstance().getSelectedCourse().getGradingSchemeId().getName());
        
        // setOnAction when register button is pressed
        btnRegister.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
//                    ViewLoader view = new ViewLoader(disBrwCourseArea);
//                    view.loadView("FaqView");
//                    browseCourseLk.setVisible(true);
//                    browseCourseLk.setText("Faq");
//                    deptLk.setVisible(false);
//                    courseLk.setVisible(false);                   
                   
                    RedEntityManager.save(enrolment);
                    lblResponse.setText(LocaleManager.get(10));
                    lblResponse.setVisible(true);
                    btnRegister.setDisable(true);
                    btnDrop.setDisable(false);
                }
                catch (Exception ex)
                {
                    Logger.getLogger(SectionViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    private boolean checkUserAlreadyEnrolled(Enrolment enrol)
    {
        try
        {
            Enrolment.getEnrolmentByEnrolmentPK(enrol);
            return true;
        }
        catch (Exception ex)
        {
           return false;
        }
    }
    private void populateList()
    {

        dateLv.setItems(null);
    }
}
