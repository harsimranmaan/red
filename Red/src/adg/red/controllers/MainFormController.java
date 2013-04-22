/*
 *
 *
 */
package adg.red.controllers;

import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import adg.red.models.Locale;
import adg.red.utils.ConfigManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
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
    private Menu menLang;
    @FXML
    private Pane searchPane;
    @FXML
    private AnchorPane mainForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initializeComponentsByLocale();
        Context.getInstance().setMainForm(mainForm);
        Context.getInstance().setMainView(viewArea);
        Context.getInstance().setSearchView(searchPane);
        if (Context.getInstance().isAtLoginScreen())
        {
            ViewLoader view = new ViewLoader(viewArea);
            view.loadView("Login");
        }
        createLanguageMenuItems();
    }

    /**
     * Exit the platform
     * <p/>
     * @param event user action
     */
    @FXML
    public void close(ActionEvent event)
    {
        Platform.exit();
    }

    /**
     * Change language
     * <p/>
     * @param event user action
     */
    @FXML
    public void changeLang(ActionEvent event)
    {
        CheckMenuItem item = ((CheckMenuItem) event.getSource());
        LocaleManager.changeLocale(item.getText());
        //item.setSelected(true);


        ViewLoader view = new ViewLoader(Context.getInstance().getMainForm());
        view.loadView("MainForm");
        if (!Context.getInstance().isAtLoginScreen())
        {
            ViewLoader view1 = new ViewLoader(Context.getInstance().getMainView());
            view1.loadView("HomeView");
        }
    }

    private void createLanguageMenuItems()
    {
        List<Locale> locs = Locale.findAllLocale();
        for (Locale loc : locs)
        {
            final CheckMenuItem menu = new CheckMenuItem();
            menu.setText(loc.getName());
            menu.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    changeLang(e);
                }
            });
            menu.selectedProperty().addListener(new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue ov, Boolean old_val, Boolean new_val)
                {
                    menu.setSelected(new_val);
                }
            });
            if (menu.getText().equalsIgnoreCase(LocaleManager.getLoc().getName()))
            {
                menu.setSelected(true);
            }
            menLang.getItems().add(menu);
        }
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
        menLang.setText(LocaleManager.get(118));
    }
}
