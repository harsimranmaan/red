/*
 *
 *
 */
package adg.red.controllers;

import adg.red.BootStrap;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import adg.red.utils.ConfigManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
     * Open about window
     * <p/>
     * @param event user action
     */
    @FXML
    public void about(ActionEvent event) throws Exception
    {
        Stage stage = new Stage();
        BootStrap boot = new BootStrap();
        Parent root = FXMLLoader.load(getClass().getResource(boot.getUserInterfaceUrl("About")));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle(LocaleManager.get(31));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/adg/red/userInterface/images/redIcon.png")));
        stage.setScene(scene);
        stage.show();
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
            view = new ViewLoader(Context.getInstance().getMainView());
            view.loadView("HomeView");
        }
    }

    private void createLanguageMenuItems()
    {
        //List<Locale> locs = Locale.findAllLocale();
        String langs[] = ConfigManager.getInstance().getPropertyValue("languageSupported").split(",");
        String path = "/adg/red/userInterface/images/";
        for (int counter = 0; counter < langs.length; counter++)
        {
            String lang[] = langs[counter].split("\\|");
            final CheckMenuItem menu = new CheckMenuItem(lang[0], new ImageView(new Image(path + lang[1])));
            menu.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent e)
                {
                    changeLang(e);
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
