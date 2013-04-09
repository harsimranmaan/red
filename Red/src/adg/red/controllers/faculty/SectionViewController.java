/*
 * 
 * 
 */
package adg.red.controllers.faculty;

import adg.red.config.FacultyAction;
import adg.red.controllers.BreadCrumbController;
import adg.red.models.Section;
import adg.red.models.Session;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class SectionViewController implements Initializable
{

    private FacultyAction action;
    @FXML
    private TableView<Section> tabSection;
    @FXML
    private TableColumn<Section, String> colDept;
    @FXML
    private TableColumn<Section, String> colEnd;
    @FXML
    private TableColumn<Section, Integer> colSection;
    @FXML
    private TableColumn<Section, String> colStart;
    @FXML
    private TableColumn<Section, String> colTA;
    @FXML
    private TableColumn<Section, String> colType;
    @FXML
    private AnchorPane actionView;

    @FXML
    private void selectSection(MouseEvent event)
    {
        if (tabSection.getSelectionModel().getSelectedItem() != null)
        {
            Section sec = tabSection.getSelectionModel().getSelectedItem();
            Context.getInstance().setSelectedSection(sec);

        }
        loadSection();
    }

    private void initializeByLocale()
    {
        colDept.setText(LocaleManager.get(38));
        colEnd.setText(LocaleManager.get(45));
        colSection.setText(LocaleManager.get(74));
        colStart.setText(LocaleManager.get(46));
        colTA.setText(LocaleManager.get(49));
        colType.setText(LocaleManager.get(47));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeByLocale();
        action = Context.getInstance().getFacultyAction();
        BreadCrumbController.renderBreadCrumb("faculty/HomeView|faculty/" + action.toString());
        Context.getInstance().setTitle(LocaleManager.get(69));
        action = Context.getInstance().getFacultyAction();
        populateSectionTable();
    }

    private void loadSection()
    {
        ViewLoader view = new ViewLoader(actionView);
        view.loadView("faculty/" + action.toString());
    }

    public void populateSectionTable()
    {
        List<Section> sections = null;
        if (action.toString().equalsIgnoreCase("UploadScore"))
        {
            // only display section of lecture for upload score action
            sections = Section.getByFacultyMemberIdAndSectionTypeId100(Context.getInstance().getCurrentUser().getFacultyMember());
        }
        else
        {
            sections = Section.getByFacultyMemberId(Context.getInstance().getCurrentUser().getFacultyMember());
        }

        populate(sections);

    }

    private void populate(List<Section> sections)
    {
        colDept.setCellValueFactory(new PropertyValueFactory<Section, String>("departmentIdAndCourseName"));
        colSection.setCellValueFactory(new PropertyValueFactory<Section, Integer>("sectionId"));
        colEnd.setCellValueFactory(new PropertyValueFactory<Section, String>("formattedEndDate"));
        colStart.setCellValueFactory(new PropertyValueFactory<Section, String>("formattedStartDate"));
        colType.setCellValueFactory(new PropertyValueFactory<Section, String>("sectionTypeName"));
        colTA.setCellValueFactory(new PropertyValueFactory<Section, String>("teachingAssistant"));
        tabSection.getItems().setAll(sections);


    }
}
