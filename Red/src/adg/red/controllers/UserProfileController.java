/*
 *
 *
 */
package adg.red.controllers;

import adg.red.controls.CustomTextBox;
import adg.red.controls.TextBoxType;
import adg.red.models.Address;
import adg.red.models.Administrator;
import adg.red.models.Faculty;
import adg.red.models.FacultyMember;
import adg.red.models.Student;
import adg.red.models.User;
import adg.red.session.Context;
import adg.red.locale.LocaleManager;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class for UserProfile.fxml
 * <p/>
 * @author jingboyu
 */
public class UserProfileController implements Initializable
{

    @FXML
    private Pane paneChangePassword;
    private User currentUser;
    private Label txtFullName;
    private Label txtUserType;
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
        txtFullName = new Label("Full name: " + currentUser.getFirstName() + " " + currentUser.getLastName());
        if (currentUser.getUserTypeId().getName().equals("Student"))
        {
            try {
                Student student = Student.getStudentByUsername(currentUser);
                txtUserType = new Label("Student ID: " + student.getStudentId());
            } catch (Exception ex) {
                Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (currentUser.getUserTypeId().getName().equals("Faculty"))
        {
            try {
                FacultyMember facultyMember = FacultyMember.getFacultMemberByUserName(currentUser);
                txtUserType = new Label("Faculty ID: " + facultyMember.getFacultyMemberId());
            } catch (Exception ex) {
                Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (currentUser.getUserTypeId().getName().equals("Admin"))
        {
            try {
                Administrator admin = Administrator.getAdministratorByUserName(currentUser);
                txtUserType = new Label("Admin ID: " + admin.getAdminId());
            } catch (Exception ex) {
                Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            txtUserType = new Label("Wrong user name");
        }
        txtAddressFirst = new CustomTextBox(TextBoxType.Any, "Addrees 1:", "");
        txtAddressSecond = new CustomTextBox(TextBoxType.Any, "Addrees 2:", "");
        txtCity = new CustomTextBox(TextBoxType.Alpha, "City:", "Please enter a valid City");
        txtProvince = new CustomTextBox(TextBoxType.Alpha, "Province:", "Please enter a valid Province");
        txtCountry = new CustomTextBox(TextBoxType.Alpha, "Country:", "Please enter a valid Country");
        txtEmail = new CustomTextBox(TextBoxType.Email, "Email:", "Please enter a valid Email");
        txtPhone = new CustomTextBox(TextBoxType.Phone, "Phone:", "Please enter a valid Phone");
        txtPostalCode = new CustomTextBox(TextBoxType.PostalCode, "Postal Code:", "Please enter a valid Postal Code");
        vBoxHolder.getChildren().addAll(txtFullName, txtUserType, txtAddressFirst, txtAddressSecond, txtCity, txtProvince, txtCountry, txtPostalCode, txtPhone, txtEmail);
        showUserProfile();
    }

    /**
     * Implement CLEAR button to clear user inputs
     * @param event user action: click button
     */
    @FXML
    public void clear(ActionEvent event)
    {
        showUserProfile();
        lblMessage.setVisible(true);
    }

    /**
     * Validate user inputs and implement SAVE button to commit user inputs into database
     * @param event user action: click button
     */
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

    /**
     * Display current user's profile
     */
    private void showUserProfile()
    {
        displayUserProfile(currentUser);
    }

    /**
     * Display current user's profile
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
}
