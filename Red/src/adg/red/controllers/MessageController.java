/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Message;
import adg.red.models.MessageReceiver;
import adg.red.models.MessageStatus;
import adg.red.models.User;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
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
    private SplitMenuButton btnMessageAction;

    private void handleActionButton(ActionEvent event)
    {
        MessageReceiver receiver = tblMessages.getSelectionModel().getSelectedItem();
        receiver.setStatusId(MessageStatus.getByStatusName(((MenuItem) event.getSource()).getText()));
        receiver.save();
        initTable();
    }

    @FXML
    public void displayMessage(MouseEvent event)
    {
        if (tblMessages.getSelectionModel().getSelectedItem() != null)
        {
            MessageReceiver messageReceiver = tblMessages.getSelectionModel().getSelectedItem();
            displayMessageText(messageReceiver.getMessage());
        }
    }

    private void displayMessageText(Message message)
    {
        if (tblMessages.getSelectionModel().getSelectedItem() == null)
        {

            txtMessageBody.setText("");
            txtSubject.setText("");
        }
        else
        {
            txtMessageBody.setText(message.getMessageBody());
            txtSubject.setText(message.getSubject());
        }
    }

    private void initTable()
    {

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
        List<MessageStatus> statusList = MessageStatus.getAll();
        List<MenuItem> menuItems = new ArrayList<>();
        for (MessageStatus status : statusList)
        {
            MenuItem item = new MenuItem(status.getName());
            item.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    handleActionButton(event);
                }
            });
            menuItems.add(item);
        }
        btnMessageAction.setText(LocaleManager.get(53));
        btnMessageAction.getItems().setAll(menuItems);
        currentUser = adg.red.utils.Context.getInstance().getCurrentUser();
        initTable();
    }

    public void populateMessageList(List<MessageReceiver> messages)
    {
        colSubject.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("subject"));
        colDate.setCellValueFactory(new PropertyValueFactory<MessageReceiver, Date>("dateTime"));
        colSender.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("senderName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<MessageReceiver, String>("statusName"));
        tblMessages.getItems().setAll(messages);
        if (messages.size() > 0)
        {

            tblMessages.getSelectionModel().selectFirst();
            btnMessageAction.setDisable(false);
        }
        else
        {
            btnMessageAction.setDisable(true);
        }
    }
}
