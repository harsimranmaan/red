/*
 *
 *
 */
package adg.red;

import adg.red.locale.LocaleManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author hsmaan
 */
public class BootStrap extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource(getUserInterfaceUrl("MainForm")));
        Scene scene = new Scene(root);
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setTitle(LocaleManager.get(107));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("userInterface/images/redIcon.png")));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Gets the URI for the fxml file
     * <p/>
     * @param fileName <p/>
     * @return
     */
    public String getUserInterfaceUrl(String fileName)
    {
        return "/adg/red/userInterface/" + fileName + ".fxml";
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     * <p/>
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
