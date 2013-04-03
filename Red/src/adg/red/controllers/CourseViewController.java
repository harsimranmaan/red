/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Course;
import adg.red.models.Section;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class CourseViewController implements Initializable
{

    @FXML //  fx:id="txtCourseArea"
    private TextArea txtCourseDescription; // Value injected by FXMLLoader
    @FXML //  fx:id="courseNameLbl"
    private Label lblCourseName; // Value injected by FXMLLoader
    @FXML //  fx:id="creditLbl"
    private Label lblCredit; // Value injected by FXMLLoader
    @FXML //  fx:id="deptIdAndCourseNoLbl"
    private Label lblDeptIdAndCourseNo; // Value injected by FXMLLoader
    @FXML //  fx:id="disTable"
    private TableView<Section> tabCourse; // Value injected by FXMLLoader
    @FXML //  fx:id="endDateColmn"
    private TableColumn<Section, Date> colEndDate; // Value injected by FXMLLoader
    @FXML //  fx:id="gradingSchmLbl"
    private Label lblGradingScheme; // Value injected by FXMLLoader
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
    @FXML //  fx:id="disView"
    private AnchorPane disView; // Value injected by FXMLLoader

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO

        populateSectionTable(Context.getInstance().getSelectedCourse());
        lblCredit.setText("" + Context.getInstance().getSelectedCourse().getCredits());
        passRqLbl.setText(Context.getInstance().getSelectedCourse().getPassingRequirement());
        txtCourseDescription.setText(Context.getInstance().getSelectedCourse().getDescription());
        lblCourseName.setText(Context.getInstance().getSelectedCourse().getName());
        lblDeptIdAndCourseNo.setText(Context.getInstance().getSelectedCourse().getDepartmentIdAndCourseNumber());
        lblGradingScheme.setText(Context.getInstance().getSelectedCourse().getGradingSchemeId().getName());
        HomeViewController.getCourseLk().setText("" + Context.getInstance().getSelectedCourse().getCoursePK().getCourseNumber() + ":");
        HomeViewController.getCourseLk().setVisible(true);

        // action when user clicked on the table
        tabCourse.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    Context.getInstance().setSelectedSection(tabCourse.getSelectionModel().getSelectedItem());
                    //Context.getInstance().setSelectedCourse(disTable.getSelectionModel().getSelectedItem());
                    ViewLoader view = new ViewLoader(disView);
                    view.loadView("SectionView");

                }
                catch (Exception ex)
                {
                    Logger.getLogger(BrowseCourseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void populateSectionTable(Course selectedCourse)
    {

        List<Section> sections = Section.getByCourse(selectedCourse);
        populate(sections);

    }

    private void populate(List<Section> sections)
    {
        secColmn.setCellValueFactory(new PropertyValueFactory<Section, Integer>("sectionId"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<Section, Date>("endDate"));
        startDateColmn.setCellValueFactory(new PropertyValueFactory<Section, Date>("startDate"));
        typeColmn.setCellValueFactory(new PropertyValueFactory<Section, String>("sectionTypeName"));
        instructorColmn.setCellValueFactory(new PropertyValueFactory<Section, String>("facultyMemberName"));
        tabCourse.getItems().setAll(sections);

    }
}
