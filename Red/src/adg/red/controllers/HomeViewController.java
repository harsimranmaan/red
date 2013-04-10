/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.utils.Context;
import adg.red.utils.DateFormatter;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class for HomeView.fxml
 * <p/>
 * @author harsimran.maan
 */
public class HomeViewController implements Initializable
{

    @FXML
    private Label lblDay;
    @FXML
    private AnchorPane commonButtonArea;
    @FXML
    private AnchorPane paneMain;
    @FXML
    private AnchorPane specificButtonArea;
    @FXML
    private AnchorPane breadCrumbArea;
    @FXML
    private Label lblPageTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ViewLoader view = new ViewLoader(commonButtonArea);
        view.loadView("CommonButtons");
        view = new ViewLoader(Context.getInstance().getSearchView());
        Context.getInstance().getSearchView().setVisible(true);
        view.loadView("SearchBox");
        view = new ViewLoader(specificButtonArea);
        String userType = Context.getInstance().getCurrentUser().getUserTypeId().getName().toLowerCase();
        view.loadView(userType + "/SpecificButtons");
        Context.getInstance().setDisplayView(paneMain);
        Context.getInstance().setBreadCrumb(breadCrumbArea);
        Context.getInstance().setTitleLabel(lblPageTitle);
        Context.getInstance().setTitle(LocaleManager.get(24));
        view = new ViewLoader(paneMain);
        view.loadView(userType + "/HomeView");
        lblDay.setText(DateFormatter.getCurrentDayDate());
    }
}
