/*
 * Controller class for CourseView.fxml.
 */
package adg.red.controllers.student;

import adg.red.controllers.BreadCrumbController;
import adg.red.models.CoRequisite;
import adg.red.utils.Context;
import adg.red.utils.ViewLoader;
import adg.red.models.Course;
import adg.red.models.Prerequisite;
import adg.red.models.Section;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.util.Callback;

/**
 * FXML Controller class for CourseView.fxml
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
    private Label lblCreditName;
    @FXML
    private Label lblPrereq;
    @FXML
    private Label lblCoReq;
    @FXML
    private TableView<Section> tabCourse;
    @FXML
    private TableColumn<Section, String> colEndDate;
    @FXML
    private TableColumn<Section, String> instructorColmn;
    @FXML
    private TableColumn<Section, Integer> secColmn;
    @FXML
    private TableColumn<Section, String> startDateColmn;
    @FXML
    private TableColumn<Section, String> typeColmn;
    @FXML
    private TableColumn<Section, String> colTa;
    @FXML
    private ListView<CoRequisite> lsvCoReq;
    @FXML
    private ListView<Prerequisite> lsvPrereq;

    /**
     * The function to handle selectSection mouse event
     * <p/>
     * @param event the mouse event
     */
    @FXML
    private void selectSection(MouseEvent event)
    {
        if (tabCourse.getSelectionModel().getSelectedItem() != null)
        {
            Context.getInstance().setSelectedSection(tabCourse.getSelectionModel().getSelectedItem());
            ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
            view.loadView("student/SectionView");
        }
    }

    /**
     * The function to handle showPreq mouse event
     * <p/>
     * @param event the mouse event
     */
    @FXML
    private void showPreq(MouseEvent event)
    {
        if (lsvPrereq.getSelectionModel().getSelectedItem() != null)
        {
            Course course = lsvPrereq.getSelectionModel().getSelectedItem().getCourse();
            selectCourse(course);
        }
    }

    /**
     * The function to handle showCoReq mouse event
     * <p/>
     * @param event the mouse event
     */
    @FXML
    private void showCoReq(MouseEvent event)
    {

        if (lsvCoReq.getSelectionModel().getSelectedItem() != null)
        {
            Course course = lsvCoReq.getSelectionModel().getSelectedItem().getCourse1();
            selectCourse(course);
        }
    }

    /**
     * The function to load the CourseView of selected course
     * <p/>
     * @param course the course to load the CourseView for
     */
    private void selectCourse(Course course)
    {
        Context.getInstance().setSelectedCourse(course);
        ViewLoader view = new ViewLoader(Context.getInstance().getDisplayView());
        view.loadView("student/CourseView");
    }

    /**
     * The function initializes all the components text by locality.
     */
    private void initializeComponentsByLocale()
    {

        lblCreditName.setText(LocaleManager.get(42) + ":");
        lblPrereq.setText(LocaleManager.get(43));
        lblCoReq.setText(LocaleManager.get(44));
        secColmn.setText(LocaleManager.get(39));
        colEndDate.setText(LocaleManager.get(45));
        startDateColmn.setText(LocaleManager.get(46));
        typeColmn.setText(LocaleManager.get(47));
        instructorColmn.setText(LocaleManager.get(48));
        colTa.setText(LocaleManager.get(49));
    }

    /**
     * Initializes the controller class.
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(61));
        BreadCrumbController.renderBreadCrumb("student/HomeView|student/BrowseCourse|student/CourseListView|student/CourseView");
        initializeComponentsByLocale();

        lblCredit.setText(Integer.toString(Context.getInstance().getSelectedCourse().getCredits()));
        txtCourseDescription.setText(Context.getInstance().getSelectedCourse().getDescription());
        lblCourseName.setText(Context.getInstance().getSelectedCourse().getName());
        lblDeptIdAndCourseNo.setText(Context.getInstance().getSelectedCourse().getDepartmentIdAndCourseNumber());
        populatePrereqListView(Context.getInstance().getSelectedCourse());
        populateCoreqListView(Context.getInstance().getSelectedCourse());
        populateSectionTable(Context.getInstance().getSelectedCourse());
    }

    /**
     * The function to populate the list of all prerequisite courses for the
     * selected course on list view.
     * <p/>
     * @param selectedCourse the course to populate prerequisite courses on the
     *                       list view for
     */
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

    /**
     * The function to populate the list of all corequisite courses for the
     * selected course on list view.
     * <p/>
     * @param selectedCourse the course to populate corequisite courses on the
     *                       list view for
     */
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

    /**
     * The function to populate the section table.
     * <p/>
     * @param selectedCourse the course to populate section table for
     */
    public void populateSectionTable(Course selectedCourse)
    {

        List<Section> sections = Section.getByCourseAndTermYearAndMore(selectedCourse);
        populate(sections);

    }

    /**
     * The function populate a list of section to the section table.
     * <p/>
     * @param sections the list of sections
     */
    private void populate(List<Section> sections)
    {
        secColmn.setCellValueFactory(new PropertyValueFactory<Section, Integer>("sectionId"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<Section, String>("formattedEndDate"));
        startDateColmn.setCellValueFactory(new PropertyValueFactory<Section, String>("formattedStartDate"));
        typeColmn.setCellValueFactory(new PropertyValueFactory<Section, String>("sectionTypeName"));
        instructorColmn.setCellValueFactory(new PropertyValueFactory<Section, String>("facultyMemberName"));
        colTa.setCellValueFactory(new PropertyValueFactory<Section, String>("teachingAssistant"));
        tabCourse.getItems().setAll(sections);

    }
}
