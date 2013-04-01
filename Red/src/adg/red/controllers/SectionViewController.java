/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author Witt
 */
public class SectionViewController implements Initializable {

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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        secLbl.setText("Secion " + Context.getInstance().getUserSelectSectionId());
        creditLbl.setText("" + Context.getInstance().getUserSelectCourse().getCredits());
        passRqLbl.setText(Context.getInstance().getUserSelectCourse().getPassingRequirement());
        courseDesTxt.setText(Context.getInstance().getUserSelectCourse().getDescription());
        courseNameLbl.setText(Context.getInstance().getUserSelectCourse().getName());
        deptIdAndCourseNoLbl.setText(Context.getInstance().getUserSelectCourse().getDepartmentIdAndCourseNumber());
        gradingSchmLbl.setText(Context.getInstance().getUserSelectCourse().getGradingSchemeId().getName());
    }  
    
    private void populateList()
    {
            
        dateLv.setItems(null);
    }
}
