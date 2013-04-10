/*
 * The ViewLoader class is responsible for loading a new view.
 *
 */
package adg.red.utils;

import adg.red.BootStrap;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * The ViewLoader class is responsible for loading a new view.
 * <p/>
 * @author Witt
 */
public class ViewLoader
{

    private Pane viewArea;

    /**
     * The constructor.
     * <p/>
     * @param viewArea the Pane that will load new view to
     */
    public ViewLoader(Pane viewArea)
    {
        this.viewArea = viewArea;
    }

    /**
     * The function loads a new view.
     * <p/>
     * @param fxmlView the String of fxml file name of the view to be loaded.
     */
    public void loadView(String fxmlView)
    {
        // load home view
        try
        {
            BootStrap boot = new BootStrap();
            URL location = getClass().getResource(boot.getUserInterfaceUrl(fxmlView));
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            Node view = (Node) fxmlLoader.load();
            viewArea.getChildren().setAll(view);
            // set anchors
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ViewLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
