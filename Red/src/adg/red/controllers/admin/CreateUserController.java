/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.admin;

import adg.red.controllers.BreadCrumbController;
import adg.red.controllers.DownloadFileController;
import adg.red.controllers.faculty.UploadScoreController;
import adg.red.locale.LocaleManager;
import adg.red.models.Address;
import adg.red.models.Enrolment;
import adg.red.models.User;
import adg.red.models.UserType;
import adg.red.session.Context;
import adg.red.utils.DateFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class CreateUserController implements Initializable
{

    @FXML
    private Label lblHeading2;
    @FXML
    private Button btnDownloadTemp;
    @FXML
    private Label lblFile;
    @FXML
    private Label lblFilePath;
    @FXML
    private ListView<String> lsvResult;
    @FXML
    private Button btnBrowseFile;
    @FXML
    private Button btnUpload;
    private File file;
    private User newUser;
    private Address address;
    private final int numberOfFields = 14;

    /**
     * Browse the upload file
     * <p/>
     * @param event the action event
     */
    @FXML
    private void browseFile(ActionEvent event)
    {
        btnBrowseFile.setDisable(true);
        FileChooser fileChooser = new FileChooser();

        // set filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        file = fileChooser.showOpenDialog(new Stage());
        toggleLabels();
        btnBrowseFile.setDisable(false);
    }

    /**
     * Function to enable the downloading of upload score template csv
     * <p/>
     * @param event the action event
     */
    @FXML
    private void downloadTemplate(ActionEvent event)
    {
        String content = createTemplateHeader();
        DownloadFileController.saveFile(content, "csv");
    }

    /**
     * Creates the Header for the template
     * <p/>
     * @return The Header
     */
    private String createTemplateHeader()
    {
        String content = "#Template for creating a new user\r\n";
        content += "#Note: User type id,100 = student, 101 = faculty\r\n";
        content += "#Note: Date format is dd/MM/yyyy\r\n";
        content += "#Note: Username and Email has to be uniques\r\n";
        content += "#Username, Password, First name, Last name, User type id,";
        content += "Address first line, Address second line, City, Province, Postal code, Country,";
        content += "Phone number, email, Date of birth\r\n";
        return content;
    }

    @FXML
    private void createUser(ActionEvent event) throws Exception
    {
        ArrayList<String> resultList = new ArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String text = "";

            while ((text = reader.readLine()) != null)
            {
                String tempData[] = null;
                // ignore line that starts with #
                if (!text.startsWith("#"))
                {
                    text = text.trim();
                    tempData = text.split(",");

                    if (tempData != null)
                    {
                        String result = "Username: " + tempData[0];
                        try
                        {
                            // make sure that we have to correct number of input data
                            if (tempData.length != numberOfFields)
                            {
                                throw new Exception("");
                            }

                            newUser = new User(tempData[0]);
                            newUser.setPassword(tempData[1]);
                            newUser.setFirstName(tempData[2]);
                            newUser.setLastName(tempData[3]);
                            newUser.setUserTypeId(UserType.getByUserTypeId(Integer.parseInt(tempData[4])));
                            newUser.setPhoneNumber(tempData[11]);
                            newUser.setEmail(tempData[12]);
                            newUser.setDateOfBirth(DateFormatter.formatDate(tempData[13]));
                            newUser.setIsActive(true);

                            //create address
                            address = new Address();
                            address.setAddressLineFirst(tempData[5]);
                            address.setAddressLineSecond(tempData[6]);
                            address.setCity(tempData[7]);
                            address.setProvince(tempData[8]);
                            address.setPostalCode(tempData[9]);
                            address.setCountry(tempData[10]);
                            address.save();

                            newUser.setAddressId(address);
                            newUser.save();
                            result += " <Succesfully created>";
                            resultList.add(result);
                        }
                        catch (Exception ex)
                        {
                            result += " <Error:failed to create>";
                            resultList.add(result);
                        }
                    }
                }
            }
            lsvResult.getItems().setAll(resultList);
        }
        catch (IOException ex)
        {
            Logger.getLogger(CreateUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(151));
        BreadCrumbController.renderBreadCrumb("admin/HomeView|admin/CreateUser");
        initializeComponentsByLocale();
        toggleLabels();
    }

    /**
     * The function initializes all the components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        btnBrowseFile.setText(LocaleManager.get(70));
        btnUpload.setText(LocaleManager.get(82));
        btnDownloadTemp.setText(LocaleManager.get(99));
        lblHeading2.setText(LocaleManager.get(152) + ":");
        lblFile.setText(LocaleManager.get(28) + ":");
    }

    /**
     * Toggle the Upload button and label visibility, depending if the upload
     * file exists or not
     */
    private void toggleLabels()
    {
        if (file != null)
        {
            lblFilePath.setText(file.getPath());
            lblFilePath.setVisible(true);
            btnUpload.setDisable(false);
        }
        else
        {
            lblFilePath.setVisible(false);
            btnUpload.setDisable(true);
        }
    }
}
