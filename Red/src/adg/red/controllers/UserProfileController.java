/*
 * 
 * 
 */
package adg.red.controllers;

import adg.red.models.Address;
import adg.red.models.User;
import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import adg.red.utils.ViewLoader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 * <p/>
 * @author jingboyu
 */
public class UserProfileController implements Initializable
{

    @FXML
    private TextField addrTxt1;
    @FXML
    private TextField addrTxt2;
    @FXML
    private TextField cityTxt;
    @FXML
    private TextField postalTxt;
    @FXML
    private TextField phoneTxt;
    @FXML
    private TextField emailTxt;
    @FXML
    private ChoiceBox provinceChoiceBox;
    @FXML
    private ChoiceBox countryChoiceBox;
    @FXML
    private Button contactCancelBtn;
    @FXML
    private Button contactSaveBtn;
    @FXML
    private Label errorLabel;
    @FXML
    private Pane paneChangePassword;
    private User currentUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        currentUser = Context.getInstance().getCurrentUser();
        Context.getInstance().setTitle(LocaleManager.get(15));
        BreadCrumbController.renderBreadCrumb(currentUser.getUserTypeId().getName().toLowerCase() + "/HomeView|UserProfile");
        ViewLoader view = new ViewLoader(paneChangePassword);
        view.loadView("ChangePassword");
        showUserProfile();



        contactCancelBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                showUserProfile();
                errorLabel.setVisible(false);
            }
        });

        contactSaveBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    // modify user profile
                    String errorMsg = "";
                    boolean isValid = true;
                    String addr1 = addrTxt1.getText();
                    if (addr1.isEmpty())
                    {
                        isValid = false;
                        errorMsg += "Empty first address line! ";
                    }
                    String addr2 = addrTxt2.getText();
                    if (addr2.isEmpty())
                    {
                        isValid = false;
                        errorMsg += "Empty second address line! ";
                    }
                    String city = cityTxt.getText();
                    String postal = postalTxt.getText();
                    if (postal.isEmpty())
                    {
                        isValid = false;
                        errorMsg += "Empty postal code! ";
                    }
                    String phone = phoneTxt.getText();
                    try
                    {
                        Integer.valueOf(phone);
                    }
                    catch (Exception e)
                    {
                        isValid = false;
                        errorMsg += "Invalid phone number! ";
                    }
                    String email = emailTxt.getText();
                    if (!email.contains("@"))
                    {
                        isValid = false;
                        errorMsg += "Invalid email!";
                    }

                    String provinceChoice = provinceChoiceBox.getValue().toString();
                    String countryChoice = countryChoiceBox.getValue().toString();

                    if (isValid)
                    {
                        Address addr = currentUser.getAddressId();
                        addr.setAddressLineFirst(addr1);
                        addr.setAddressLineSecond(addr2);
                        addr.setCity(city);
                        addr.setProvince(provinceChoice);
                        addr.setCountry(countryChoice);
                        currentUser.setAddressId(addr);
                        currentUser.setPhoneNumber(phone);
                        currentUser.setEmail(email);
                        currentUser.save();
                        errorLabel.setVisible(true);
                        errorLabel.setText("User profile updated!");
                    }
                    else
                    {
                        errorLabel.setVisible(true);
                        errorLabel.setText(errorMsg);
                    }
                }
                catch (Exception ex)
                {
                    Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void showUserProfile()
    {
        displayUserProfile(currentUser);
    }

    private void displayUserProfile(User user)
    {
        addrTxt1.setText(user.getAddressId().getAddressLineFirst());
        addrTxt2.setText(user.getAddressId().getAddressLineSecond());
        cityTxt.setText(user.getAddressId().getCity());
        postalTxt.setText(user.getAddressId().getPostalCode());
        phoneTxt.setText(user.getPhoneNumber());
        emailTxt.setText(user.getEmail());
        provinceChoiceBox.setValue(user.getAddressId().getProvince());
        countryChoiceBox.setValue(user.getAddressId().getCountry());
    }
}
