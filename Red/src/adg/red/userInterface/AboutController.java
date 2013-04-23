/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.userInterface;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;

/**
 * FXML Controller class
 * <p/>
 * @author harsimran.maan
 */
public class AboutController implements Initializable
{

    @FXML
    private void linkGithub(ActionEvent event)
    {
        try
        {
            java.awt.Desktop.getDesktop().browse(new URI(((Hyperlink) event.getSource()).getId()));
        }
        catch (Exception ex)
        {
            Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    }
}
