/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.models.Message;
import adg.red.models.MessageReceiver;
import adg.red.models.MessageStatus;
import adg.red.models.User;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class for Message.fxml
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
    private TextArea txtMessageBody;
    @FXML
    private TableView<MessageReceiver> tblMessages;
    private User currentUser;
    @FXML
    private TextArea txtSubject;
    @FXML
    private SplitMenuButton btnMessageAction;

    /**
     * Handle user selected actions
     * @param event handle actions that user selected
     */
    private void handleActionButton(ActionEvent event)
    {
        MessageReceiver receiver = tblMessages.getSelectionModel().getSelectedItem();
        receiver.setStatusId(MessageStatus.getByStatusName(((MenuItem) event.getSource()).getText()));
        receiver.save();
        initTable();
    }

    /**
     * Get user selected message items
     * @param event user action
     */
    @FXML
    public void displayMessage(MouseEvent event)
    {
        if (tblMessages.getSelectionModel().getSelectedItem() != null)
        {
            MessageReceiver messageReceiver = tblMessages.getSelectionModel().getSelectedItem();
            displayMessageText(messageReceiver.getMessage());
        }
    }

    /**
     * Display messages selected by the user
     * @param message 
     */
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

    /**
     * Get message items that the current user received.
     */
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
        currentUser = adg.red.session.Context.getInstance().getCurrentUser();
        Context.getInstance().setTitle(LocaleManager.get(22));
        BreadCrumbController.renderBreadCrumb(currentUser.getUserTypeId().getName().toLowerCase() + "/HomeView|Message");
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

        initTable();
    }

    /**
     * Populate message lists with the message items that current user received.
     * @param messages 
     */
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
