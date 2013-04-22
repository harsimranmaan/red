/*
 *
 *
 */
package adg.red.controllers;

import adg.red.controls.CustomTextBox;
import adg.red.controls.TextBoxType;
import adg.red.models.Address;
import adg.red.models.User;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
import adg.red.models.skeleton.ILocalizable;
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
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class for UserProfile.fxml
 * <p/>
 * @author jingboyu
 */
public class UserProfileController implements Initializable, ILocalizable
{

    @FXML
    private Pane paneChangePassword;
    private User currentUser;
    private CustomTextBox txtFullName;
    private CustomTextBox txtUserType;
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
    @FXML
    private Tab tabContact;
    @FXML
    private Tab tabChangePwd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        localize();
        BreadCrumbController.renderBreadCrumb(currentUser.getUserTypeId().getName().toLowerCase() + "/HomeView|UserProfile");
        ViewLoader view = new ViewLoader(paneChangePassword);
        view.loadView("ChangePassword");

        txtFullName = new CustomTextBox(TextBoxType.Any, LocaleManager.get(137) + ":", "");
        txtFullName.setText(currentUser.getFullName());
        txtFullName.setDisable(true);
        if (currentUser.getUserTypeId().getName().equals("Student"))
        {
            txtUserType = new CustomTextBox(TextBoxType.Any, LocaleManager.get(138) + ": ", "");
            txtUserType.setText(Integer.toString(currentUser.getStudent().getStudentId()));
        }
        else if (currentUser.getUserTypeId().getName().equals("Faculty"))
        {
            txtUserType = new CustomTextBox(TextBoxType.Any, LocaleManager.get(139) + ": ", "");
            txtUserType.setText(Integer.toString(currentUser.getFacultyMember().getFacultyMemberId()));
        }
        else if (currentUser.getUserTypeId().getName().equals("Admin"))
        {
            txtUserType = new CustomTextBox(TextBoxType.Any, LocaleManager.get(140) + ": ", "");
            txtUserType.setText(Integer.toString(currentUser.getAdministrator().getAdminId()));
        }
        txtUserType.setDisable(true);

        txtAddressFirst = new CustomTextBox(TextBoxType.Any, LocaleManager.get(129) + ":", LocaleManager.get(130));
        txtAddressSecond = new CustomTextBox(TextBoxType.Any, LocaleManager.get(131) + ":", LocaleManager.get(130));
        txtCity = new CustomTextBox(TextBoxType.Alpha, LocaleManager.get(122) + ":", LocaleManager.get(123));
        txtProvince = new CustomTextBox(TextBoxType.Alpha, LocaleManager.get(132) + ":", LocaleManager.get(133));
        txtCountry = new CustomTextBox(TextBoxType.Alpha, LocaleManager.get(124) + ":", LocaleManager.get(125));
        txtEmail = new CustomTextBox(TextBoxType.Email, LocaleManager.get(126) + ":", LocaleManager.get(127));
        txtPhone = new CustomTextBox(TextBoxType.Phone, LocaleManager.get(128) + ":", LocaleManager.get(134));
        txtPostalCode = new CustomTextBox(TextBoxType.PostalCode, LocaleManager.get(135) + ":", LocaleManager.get(136));
        vBoxHolder.getChildren().addAll(txtFullName, txtUserType, txtAddressFirst, txtAddressSecond, txtCity, txtProvince, txtCountry, txtPostalCode, txtPhone, txtEmail);
        showUserProfile();
    }

    /**
     * Implement CLEAR button to clear user inputs
     * <p/>
     * @param event user action: click button
     */
    @FXML
    public void clear(ActionEvent event)
    {
        showUserProfile();
        lblMessage.setVisible(true);

    }

    /**
     * Validate user inputs and implement SAVE button to commit user inputs into
     * database
     * <p/>
     * @param event user action: click button
     */
    @FXML
    public void save(ActionEvent event)
    {

        try
        {
            // modify user profile
            String errorMsg = "";
            int localityCode = -1;
            boolean isValid = true;
            String addr1 = txtAddressFirst.getText();
            if (addr1.isEmpty())
            {
                isValid = false;
                errorMsg += "Empty first address line! ";
                localityCode = 142;
            }
            String addr2 = txtAddressSecond.getText();
            if (addr2.isEmpty())
            {
                isValid = false;
                errorMsg += "Empty second address line! ";
                localityCode = 144;
            }
            String city = txtCity.getText();
            String postal = txtPostalCode.getText();
            if (postal.isEmpty())
            {
                isValid = false;
                errorMsg += "Empty postal code! ";
                localityCode = 143;
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
                localityCode = 145;
            }
            String email = txtEmail.getText();
            if (!email.contains("@"))
            {
                isValid = false;
                errorMsg += "Invalid email!";
                localityCode = 146;
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
                lblMessage.setText(LocaleManager.get(141));
            }
            else
            {
                lblMessage.setVisible(true);
                lblMessage.setText(LocaleManager.get(localityCode));
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Display current user's profile
     */
    private void showUserProfile()
    {
        displayUserProfile(currentUser);
    }

    /**
     * Display current user's profile
     * <p/>
     * @param user current user
     */
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

    @Override
    public void localize()
    {
        btnSave.setText(LocaleManager.get(54));
        btnCancel.setText(LocaleManager.get(150));
        tabChangePwd.setText(LocaleManager.get(147));
        tabContact.setText(LocaleManager.get(148));
        currentUser = Context.getInstance().getCurrentUser();
        Context.getInstance().setTitle(LocaleManager.get(15));
    }
}
