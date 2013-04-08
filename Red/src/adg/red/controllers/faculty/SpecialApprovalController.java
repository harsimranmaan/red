/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.faculty;

import adg.red.utils.Context;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import adg.red.models.Student;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 * <p/>
 * @author Bahman
 */
public class SpecialApprovalController implements Initializable
{

    @FXML
    private Label lblHeading;
    @FXML
    private TextField studentNumber;
    @FXML
    private Button btnSubmitNumber;
    @FXML
    private Label lblName;
    @FXML
    private Label lblStudentInfo;
    @FXML
    private Button btnApprove;
    @FXML
    private Label lblErrMsg;

    @FXML
    private void pullStudentInfo(ActionEvent event)
    {
        int studentNum = Integer.parseInt(studentNumber.getText().toString());
        if (studentNumber.getText() == null)
        {
            lblErrMsg.setText("Please enter valid student number!");
        }
        else
        {
            try
            {
                Student.getStudentByUserId(studentNum);
            }
            catch (Exception ex)
            {
                lblErrMsg.setText("Student not found!");
                Logger.getLogger(SpecialApprovalController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void approveRequest(ActionEvent event)
    {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
//        Context.getInstance().setTitle(LocaleManager.get(56));
        Context.getInstance().setTitle("Special Approval");
        initializeComponentsByLocale();
        btnApprove.setDisable(true);
    }

    private void initializeComponentsByLocale()
    {
//        btnApprove.setText(LocaleManager.get(70));
//        btnSubmitNumber.setText(LocaleManager.get(71));
//        lblHeading.setText(LocaleManager.get(73));
//        lblName.setText(LocaleManager.get(74));
//        lblStudentInfo.setText(LocaleManager.get(28));
        btnApprove.setText("Approve");
        btnSubmitNumber.setText("Submit");
        lblHeading.setText("Please enter student number: ");
        lblName.setText("Student Name:");
    }
}
