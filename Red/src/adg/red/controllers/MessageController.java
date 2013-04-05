/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Course;
import adg.red.models.Message;
import adg.red.models.MessageReceiver;
import adg.red.models.User;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 * <p/>
 * @author Bahman
 */
public class MessageController implements Initializable
{

    private TableColumn<Message, String> subjectCol;
    @FXML
    private MenuItem btnDelete;
    @FXML
    private MenuItem btnMarkRead;
    @FXML
    private MenuItem btnMarkUnread;
    @FXML
    private TableColumn<Message, String> colSubject;
    @FXML
    private TableColumn<Message, Date> colDate;
    @FXML
    private TableColumn<Message, String> colSender;
    @FXML
    private TableColumn<Message, String> colStatus;
    @FXML
    private TextArea txtMessageBody;
    @FXML
    private TableView<Message> tblMessages;
    private User currentUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        currentUser = adg.red.utils.Context.getInstance().getCurrentUser();
        String userId = currentUser.getUsername();
        List<Integer> messageId;
        messageId = MessageReceiver.findMessageByReceiverId(userId);
        List<Message> messages = null;
//        for (int i = 0; i < messageId.size(); i++)
//        {
//            messages.add(Message.findMessageByMessageId(messageId.get(i)));
//        }
        populateMessageList(messages);
    }

    public void populateMessageList(List<Message> messages)
    {
        colSubject.setCellValueFactory(new PropertyValueFactory<Message, String>("subject"));
    }
}
