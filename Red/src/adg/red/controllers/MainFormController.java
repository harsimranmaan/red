/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.session.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class for MainForm.fxml
 * <p/>
 * @author hsmaan
 */
public class MainFormController implements Initializable
{

    @FXML
    private MenuItem mniClose;
    @FXML
    private AnchorPane viewArea;
    @FXML
    private Menu menFile;
    @FXML
    private Menu menHelp;
    @FXML
    private MenuItem mniAbout;
    @FXML
    private Pane searchPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
        Context.getInstance().setMainView(viewArea);
        Context.getInstance().setSearchView(searchPane);
        ViewLoader view = new ViewLoader(viewArea);
        view.loadView("Login");
    }

    /**
     * Exit the platform
     * @param event user action
     */
    @FXML
    public void close(ActionEvent event)
    {
        Platform.exit();
    }

    /**
     * Initializes all components text by locality
     */
    private void initializeComponentsByLocale()
    {
        menFile.setText(LocaleManager.get(28));
        menHelp.setText(LocaleManager.get(29));
        mniClose.setText(LocaleManager.get(30));
        mniAbout.setText(LocaleManager.get(31));
    }
}
