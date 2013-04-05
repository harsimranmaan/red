/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Message;
import adg.red.models.MessageReceiver;
import adg.red.models.MessageStatus;
import adg.red.models.User;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

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
    private Text txtMessageBody;
    @FXML
    private TableView<MessageReceiver> tblMessages;
    private User currentUser;
    @FXML
    private Text txtSubject;

    @FXML
    private void deleteMessage(ActionEvent event)
    {
        MessageReceiver receiver = tblMessages.getSelectionModel().getSelectedItem();
        receiver.setStatusId(MessageStatus.getByStatusName("Deleted"));
        receiver.save();
        initTable();
    }

    @FXML
    private void markMessageRead(ActionEvent event)
    {
        MessageReceiver receiver = tblMessages.getSelectionModel().getSelectedItem();
        receiver.setStatusId(MessageStatus.getByStatusName("Read"));
        receiver.save();
        initTable();
    }

    @FXML
    private void markMessageUnread(ActionEvent event)
    {
        MessageReceiver receiver = tblMessages.getSelectionModel().getSelectedItem();
        receiver.setStatusId(MessageStatus.getByStatusName("Unread"));
        receiver.save();
        initTable();
    }

    @FXML
    private void displayMessage(MouseEvent event)
    {
        if (tblMessages.getSelectionModel().getSelectedItem() != null)
        {
            displayMessageText(tblMessages.getSelectionModel().getSelectedItem().getMessage());
        }
    }

    private void displayMessageText(Message message)
    {
        txtMessageBody.setText(message.getMessageBody());
        txtSubject.setText(message.getSubject());
    }

    private void initTable()
    {
        currentUser = adg.red.utils.Context.getInstance().getCurrentUser();
        String userId = currentUser.getUsername();
        List<MessageReceiver> messagesReceived = MessageReceiver.findMessagesReceivedByReceiverId(userId);
        populateMessageList(messagesReceived);
        if (messagesReceived.size() > 0)
        {
            displayMessageText(messagesReceived.get(0).getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        initTable();
    }

    public void populateMessageList(List<MessageReceiver> messages)
    {
        colSubject.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("subject"));
        colDate.setCellValueFactory(new PropertyValueFactory<MessageReceiver, Date>("dateTime"));
        colSender.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("senderName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("statusName"));
        tblMessages.getItems().setAll(messages);
        tblMessages.getSelectionModel().selectFirst();
    }
}
