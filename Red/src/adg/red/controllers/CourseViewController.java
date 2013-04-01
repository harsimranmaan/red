/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.models.Section;
import adg.red.models.SectionPK;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Witt
 */
public class CourseViewController implements Initializable {

     @FXML //  fx:id="courseDesTxt"
    private TextArea courseDesTxt; // Value injected by FXMLLoader

    @FXML //  fx:id="courseNameLbl"
    private Label courseNameLbl; // Value injected by FXMLLoader

    @FXML //  fx:id="creditLbl"
    private Label creditLbl; // Value injected by FXMLLoader

    @FXML //  fx:id="deptIdAndCourseNoLbl"
    private Label deptIdAndCourseNoLbl; // Value injected by FXMLLoader

    @FXML //  fx:id="disTable"
    private TableView<Section> disTable; // Value injected by FXMLLoader

    @FXML //  fx:id="endDateColmn"
    private TableColumn<Section, Date> endDateColmn; // Value injected by FXMLLoader

    @FXML //  fx:id="gradingSchmLbl"
    private Label gradingSchmLbl; // Value injected by FXMLLoader

    @FXML //  fx:id="instructorColmn"
    private TableColumn<Section, String> instructorColmn; // Value injected by FXMLLoader

    @FXML //  fx:id="passRqLbl"
    private Label passRqLbl; // Value injected by FXMLLoader

    @FXML //  fx:id="secColmn"
    private TableColumn<Section, Integer> secColmn; // Value injected by FXMLLoader

    @FXML //  fx:id="startDateColmn"
    private TableColumn<Section, Date> startDateColmn; // Value injected by FXMLLoader

    @FXML //  fx:id="typeColmn"
    private TableColumn<Section, String> typeColmn; // Value injected by FXMLLoader
    
    @FXML //  fx:id="courseLbl"
    private Hyperlink courseLbl; // Value injected by FXMLLoader

    @FXML //  fx:id="deptLbl"
    private Hyperlink deptLbl; // Value injected by FXMLLoader
    
    @FXML //  fx:id="disView"
    private AnchorPane disView; // Value injected by FXMLLoader
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        courseLbl.setText("" + Context.getInstance().getUserSelectCourseNumer());
        deptLbl.setText(Context.getInstance().getUserSelectDeptId());
        populateSectionTable(Context.getInstance().getUserSelectDeptId(), Context.getInstance().getUserSelectCourseNumer());
        creditLbl.setText("" + Context.getInstance().getUserSelectCourse().getCredits());
        passRqLbl.setText(Context.getInstance().getUserSelectCourse().getPassingRequirement());
        courseDesTxt.setText(Context.getInstance().getUserSelectCourse().getDescription());
        courseNameLbl.setText(Context.getInstance().getUserSelectCourse().getName());
        deptIdAndCourseNoLbl.setText(Context.getInstance().getUserSelectCourse().getDepartmentIdAndCourseNumber());
        gradingSchmLbl.setText(Context.getInstance().getUserSelectCourse().getGradingSchemeId().getName());
        
        // action when dept hyperlink is clicked
        deptLbl.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                    View view = new View(disView);
                    view.loadView("CourseListView");
                }
            });
    }   
    
     public void populateSectionTable(String departmentId, int courseNumber)
    {

        List<Section> sections = Section.getByDepartmentAndCourseNumber(Department.getDepartmentById(departmentId), Course.getCourseByCourseNumer(courseNumber));
        populate(sections);

    }

    private void populate(List<Section> sections)
    {        
        secColmn.setCellValueFactory(new PropertyValueFactory<Section, Integer>("sectionId"));  
        endDateColmn.setCellValueFactory(new PropertyValueFactory<Section, Date>("endDate"));
        startDateColmn.setCellValueFactory(new PropertyValueFactory<Section, Date>("startDate"));
        typeColmn.setCellValueFactory(new PropertyValueFactory<Section, String>("sectionType"));
        instructorColmn.setCellValueFactory(new PropertyValueFactory<Section, String>("facultyMemberName"));
        disTable.getItems().setAll(sections);
       
    }
}
