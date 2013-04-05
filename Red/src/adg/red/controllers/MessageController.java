/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Message;
import adg.red.models.MessageReceiver;
import adg.red.models.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
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

    @FXML
    private MenuItem btnDelete;
    @FXML
    private MenuItem btnMarkRead;
    @FXML
    private MenuItem btnMarkUnread;
    @FXML
    private TableColumn<MessageReceiver, String> colSubject;
    @FXML
    private TableColumn<MessageReceiver, Date> colDate;
    @FXML
    private TableColumn<MessageReceiver, String> colSender;
    @FXML
    private TableColumn<MessageReceiver, String> colStatus;
    @FXML
    private TextArea txtMessageBody;
    @FXML
    private TableView<MessageReceiver> tblMessages;
    private User currentUser;

    @FXML
    private void deleteMessage(ActionEvent event)
    {
    }

    @FXML
    private void markMessageRead(ActionEvent event)
    {
    }

    @FXML
    private void markMessageUnread(ActionEvent event)
    {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        currentUser = adg.red.utils.Context.getInstance().getCurrentUser();
        String userId = currentUser.getUsername();
        List<MessageReceiver> messagesReceived = MessageReceiver.findMessagesReceivedByReceiverId(userId);
        populateMessageList(messagesReceived);

    }

    public void populateMessageList(List<MessageReceiver> messages)
    {
        colSubject.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("subject"));
        colDate.setCellValueFactory(new PropertyValueFactory<MessageReceiver, Date>("dateTime"));
        colSender.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("senderName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("statusName"));
        tblMessages.getItems().setAll(messages);

    }
}
