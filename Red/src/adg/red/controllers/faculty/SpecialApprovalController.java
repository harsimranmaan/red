/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.faculty;

import adg.red.controllers.BreadCrumbController;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class SpecialApprovalController implements Initializable
{

    @FXML
    private Label lblHeading2;
    @FXML
    private Label lblDeptCoureNumber;
    @FXML
    private Label lblSection;
    @FXML
    private Label lblSecNumber;
    @FXML
    private Label lblSession;
    @FXML
    private Label lblYear;
    @FXML
    private Label lblFile;
    @FXML
    private Label lblFilePath;
    @FXML
    private ListView<?> lsvResult;
    @FXML
    private Label lblResponse;
    @FXML
    private Button btnBrowseFile;
    @FXML
    private Button btnUpload;

    @FXML
    private void browseFile(ActionEvent event)
    {
    }

    @FXML
    private void uploadScore(ActionEvent event)
    {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        BreadCrumbController.renderBreadCrumb("faculty/HomeView|faculty/SectionView|faculty/SpecialApproval");
        Context.getInstance().setTitle(LocaleManager.get(58));
    }
}
