/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.models.CoRequisite;
import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Course;
import adg.red.models.Prerequisite;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class CourseViewController implements Initializable
{

    @FXML
    private TextArea txtCourseDescription;
    @FXML
    private Label lblCourseName;
    @FXML
    private Label lblCredit;
    @FXML
    private Label lblDeptIdAndCourseNo;
    @FXML
    private TableView<Section> tabCourse;
    @FXML
    private TableColumn<Section, Date> colEndDate;
    @FXML
    private TableColumn<Section, String> instructorColmn;
    @FXML
    private TableColumn<Section, Integer> secColmn;
    @FXML
    private TableColumn<Section, Date> startDateColmn;
    @FXML
    private TableColumn<Section, String> typeColmn;
    @FXML
    private TableColumn<Section, String> colTa;
    @FXML
    private ListView<CoRequisite> lsvCoReq;
    @FXML
    private ListView<Prerequisite> lsvPrereq;
    @FXML
    private AnchorPane disView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO

        lblCredit.setText(Integer.toString(Context.getInstance().getSelectedCourse().getCredits()));
        txtCourseDescription.setText(Context.getInstance().getSelectedCourse().getDescription());
        lblCourseName.setText(Context.getInstance().getSelectedCourse().getName());
        lblDeptIdAndCourseNo.setText(Context.getInstance().getSelectedCourse().getDepartmentIdAndCourseNumber());
        HomeViewController.getDeptLk().setText(Context.getInstance().getSelectedDepartment().getDepartmentId() + ":");
        HomeViewController.getCourseLk().setText(Integer.toString(Context.getInstance().getSelectedCourse().getCoursePK().getCourseNumber()) + ":");
        HomeViewController.getCourseLk().setVisible(true);
        populatePrereqListView(Context.getInstance().getSelectedCourse());
        populateCoreqListView(Context.getInstance().getSelectedCourse());
        populateSectionTable(Context.getInstance().getSelectedCourse());


        // action when user clicked on the table
        tabCourse.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    //handle no records click
                    if (tabCourse.getSelectionModel().getSelectedItem() != null)
                    {
                        Context.getInstance().setSelectedSection(tabCourse.getSelectionModel().getSelectedItem());

                        ViewLoader view = new ViewLoader(disView);
                        view.loadView("student/SectionView");
                    }

                }
                catch (Exception ex)
                {
                    Logger.getLogger(CourseViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // action when user clicked on coreq list view
        lsvCoReq.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    //handle no records click
                    if (lsvCoReq.getSelectionModel().getSelectedItem() != null)
                    {
                        Context.getInstance().setSelectedCourse(lsvCoReq.getSelectionModel().getSelectedItem().getCourse1());
                        Context.getInstance().setSelectedDepartment(lsvCoReq.getSelectionModel().getSelectedItem().getCourse1().getDepartment());
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
        lsvPrereq.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                try
                {
                    //handle no records click
                    if (lsvPrereq.getSelectionModel().getSelectedItem() != null)
                    {
                        Context.getInstance().setSelectedCourse(lsvPrereq.getSelectionModel().getSelectedItem().getCourse());
                        Context.getInstance().setSelectedDepartment(lsvPrereq.getSelectionModel().getSelectedItem().getCourse().getDepartment());
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

    public void populatePrereqListView(Course selectedCourse)
    {
        final List<Prerequisite> prereq = Prerequisite.getByCourse(selectedCourse);

        lsvPrereq.setCellFactory(new Callback<ListView<Prerequisite>, ListCell<Prerequisite>>()
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
        lsvPrereq.getItems().setAll(prereq);


    }

    public void populateCoreqListView(Course selectedCourse)
    {
        List<CoRequisite> coReq = CoRequisite.getByCourse(selectedCourse);

        lsvCoReq.setCellFactory(new Callback<ListView<CoRequisite>, ListCell<CoRequisite>>()
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
                            this.setText(co.getCoRequisitePK().getCoRequisiteDeptId() + " " + co.getCoRequisitePK().getCoRequisiteNumber());
                        }
                    }
                };
                return cell;
            }
        });
        lsvCoReq.getItems().setAll(coReq);
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
        colTa.setCellValueFactory(new PropertyValueFactory<Section, String>("teachingAssistant"));
        tabCourse.getItems().setAll(sections);

    }
}
