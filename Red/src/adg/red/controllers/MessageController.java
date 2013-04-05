/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 * <p/>
 * @author Bahman
 */
public class MessageController implements Initializable
{

    @FXML
    private TableColumn<?, ?> subjectCol;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private TableColumn<?, ?> senderCol;
    @FXML
    private TableColumn<?, ?> statusCol;
    @FXML
    private TextArea messageBody;
    @FXML
    private SplitMenuButton btnMessageAction;
    @FXML
    private MenuItem btnDelete;
    @FXML
    private MenuItem btnMarkRead;
    @FXML
    private MenuItem btnMarkUnread;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
}
