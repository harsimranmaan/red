/*
 *
 *
 */
package adg.red.controllers;

import adg.red.controls.CustomTextBox;
import adg.red.controls.TextBoxType;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 * <p/>
 * @author jingboyu
 */
public class UserProfileController implements Initializable
{

    @FXML
    private Pane paneChangePassword;
    private User currentUser;
    private CustomTextBox txtAddressFirst;
    private CustomTextBox txtAddressSecond;
    private CustomTextBox txtCity;
    private CustomTextBox txtProvince;
    private CustomTextBox txtPhone;
    private CustomTextBox txtEmail;
    private CustomTextBox txtCountry;
    private CustomTextBox txtPostalCode;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private VBox vBoxHolder;
    @FXML
    private Label lblMessage;

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
        txtAddressFirst = new CustomTextBox(TextBoxType.Any, "Addrees 1:", "");
        txtAddressSecond = new CustomTextBox(TextBoxType.Any, "Addrees 2:", "");
        txtCity = new CustomTextBox(TextBoxType.Alpha, "City:", "Please enter a valid City");
        txtProvince = new CustomTextBox(TextBoxType.Alpha, "Province:", "Please enter a valid Province");
        txtCountry = new CustomTextBox(TextBoxType.Alpha, "Country:", "Please enter a valid Country");
        txtEmail = new CustomTextBox(TextBoxType.Email, "Email:", "Please enter a valid Email");
        txtPhone = new CustomTextBox(TextBoxType.Phone, "Phone:", "Please enter a valid Phone");
        txtPostalCode = new CustomTextBox(TextBoxType.PostalCode, "Postal Code:", "Please enter a valid Postal Code");
        vBoxHolder.getChildren().addAll(txtAddressFirst, txtAddressSecond, txtCity, txtProvince, txtCountry, txtPostalCode, txtPhone, txtEmail);
        showUserProfile();





    }

    @FXML
    public void clear(ActionEvent event)
    {
        showUserProfile();
        lblMessage.setVisible(true);
    }

    @FXML
    public void save(ActionEvent event)
    {
        try
        {
            // modify user profile
            String errorMsg = "";
            boolean isValid = true;
            String addr1 = txtAddressFirst.getText();
            if (addr1.isEmpty())
            {
                isValid = false;
                errorMsg += "Empty first address line! ";
            }
            String addr2 = txtAddressSecond.getText();
            if (addr2.isEmpty())
            {
                isValid = false;
                errorMsg += "Empty second address line! ";
            }
            String city = txtCity.getText();
            String postal = txtPostalCode.getText();
            if (postal.isEmpty())
            {
                isValid = false;
                errorMsg += "Empty postal code! ";
            }
            String phone = txtPhone.getText();
            try
            {
                Integer.valueOf(phone);
            }
            catch (Exception e)
            {
                isValid = false;
                errorMsg += "Invalid phone number! ";
            }
            String email = txtEmail.getText();
            if (!email.contains("@"))
            {
                isValid = false;
                errorMsg += "Invalid email!";
            }

            String provinceChoice = txtProvince.getText();
            String countryChoice = txtCountry.getText();

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
                lblMessage.setVisible(true);
                lblMessage.setText("User profile updated!");
            }
            else
            {
                lblMessage.setVisible(true);
                lblMessage.setText(errorMsg);
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showUserProfile()
    {
        displayUserProfile(currentUser);
    }

    private void displayUserProfile(User user)
    {
        txtAddressFirst.setText(user.getAddressId().getAddressLineFirst());
        txtAddressSecond.setText(user.getAddressId().getAddressLineSecond());
        txtCity.setText(user.getAddressId().getCity());
        txtPostalCode.setText(user.getAddressId().getPostalCode());
        txtPhone.setText(user.getPhoneNumber());
        txtEmail.setText(user.getEmail());
        txtProvince.setText(user.getAddressId().getProvince());
        txtCountry.setText(user.getAddressId().getCountry());
    }
}
