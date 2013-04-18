/*
 * The controller class for Faculty UploadScore.fxml.
 *
 */
package adg.red.controllers.faculty;

import adg.red.controllers.DownloadFileController;
import adg.red.models.Enrolment;
import adg.red.models.EnrolmentPK;
import adg.red.models.Grade;
import adg.red.models.Section;
import adg.red.models.Session;
import adg.red.session.Context;
import adg.red.utils.LocaleManager;
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
 * @author harsimran.maan
 */
public class UploadScoreController implements Initializable
{

    @FXML
    private Button btnBrowseFile;
    @FXML
    private Button btnUpload;
    @FXML
    private Label lblDeptCoureNumber;
    @FXML
    private Label lblHeading2;
    @FXML
    private Label lblSecNumber;
    @FXML
    private Label lblSection;
    @FXML
    private Label lblSession;
    @FXML
    private Label lblYear;
    @FXML
    private Label lblFile;
    @FXML
    private Label lblFilePath;
    @FXML
    private ListView<String> lsvResult;
    @FXML
    private Button btnDownloadTemp;
    private File file;

    /**
     * Function to enable the downloading of upload score template csv
     * <p/>
     * @param event the action event
     */
    @FXML
    private void downloadTemplate(ActionEvent event)
    {
        String content = createTemplateHeader();
        List<Enrolment> enrolList = Enrolment.getEnrolmentBySectionPK(Context.getInstance().getSelectedSection().getSectionPK());

        for (Enrolment enrol : enrolList)
        {
            content += Integer.toString(enrol.getStudent().getStudentId());
            content += ",";
            content += "\r\n";
        }
        DownloadFileController.saveFile(content, "csv");
    }

    /**
     * Creates the Header for the template
     * <p/>
     * @return The Header
     */
    private String createTemplateHeader()
    {
        String content = "#Template for ";
        content += Context.getInstance().getSelectedSection().getDepartmentIdAndCourseName() + " ";
        content += "Section " + Context.getInstance().getSelectedSection().getSectionId() + " ";
        content += Context.getInstance().getSelectedSection().getTerm().getSession().getName();
        content += Integer.toString(Context.getInstance().getSelectedSection().getTerm().getTermPK().getTermYear()) + "\r\n";
        content += "#Student id, Score, Grade\r\n";
        return content;
    }

    /**
     * Initializes the controller class.
     * <p/>
     * @param url is the url
     * @param rb  is the resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // data = new ArrayList();
        Context.getInstance().setTitle(LocaleManager.get(56));
        initializeComponentsByLocale();
        lblDeptCoureNumber.setText(Context.getInstance().getSelectedSection().getSectionPK().getDepartmentId() + " " + Context.getInstance().getSelectedSection().getSectionPK().getCourseNumber());
        lblSecNumber.setText(Integer.toString(Context.getInstance().getSelectedSection().getSectionId()));
        lblSession.setText(Session.getBySessionId(Context.getInstance().getSelectedSection().getSectionPK().getSessionId()).getName());
        lblYear.setText(Integer.toString(Context.getInstance().getSelectedSection().getSectionPK().getTermYear()));
        toggleLabels();
    }

    /**
     * The function initializes all the components text by locality.
     */
    private void initializeComponentsByLocale()
    {
        btnBrowseFile.setText(LocaleManager.get(70));
        btnUpload.setText(LocaleManager.get(71));
        btnDownloadTemp.setText(LocaleManager.get(99));
        lblHeading2.setText(LocaleManager.get(73) + ":");
        lblSection.setText(LocaleManager.get(74));
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

    /**
     * Browse the upload file
     * <p/>
     * @param event the action event
     */
    @FXML
    public void browseFile(ActionEvent event)
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
     * Upload the file containing all the scores
     * <p/>
     * @param event the action event
     */
    @FXML
    public void uploadScore(ActionEvent event)
    {
        upload(file);
    }

    /**
     * Check the contents of the file and upload it
     * <p/>
     * @param file the file to be uploaded
     */
    private void upload(File file)
    {
        ArrayList<String> resultList = new ArrayList();
        ArrayList<String> studentList = new ArrayList();
        ArrayList<String> scoreList = new ArrayList();
        ArrayList<String> gradeList = new ArrayList();
        boolean hasThird = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String text = "";
            while ((text = reader.readLine()) != null)
            {
                hasThird = true;
                // ignore line that starts with #
                if (!text.startsWith("#"))
                {
                    text = text.trim();
                    String tempData[] = text.split(",");
                    // check that there are three values in a line
                    if (tempData.length < 3)
                    {
                        hasThird = false;
                    }
                    for (int i = 0; i < tempData.length; i++)
                    {
                        switch (i)
                        {
                            case 0:
                                studentList.add(tempData[i].trim());
                                break;
                            case 1:
                                scoreList.add(tempData[i].trim());
                                // there is not third value, add blank
                                if (!hasThird)
                                {
                                    gradeList.add("");
                                }
                                break;
                            case 2:
                                gradeList.add(tempData[i].trim());
                                break;
                        }
                    }
                }
            }
            for (int i = 0; i < studentList.size(); i++)
            {
                String studentId = studentList.get(i).trim();
                String score = scoreList.get(i).trim();
                String grade = gradeList.get(i).trim();

                String result = "Student Id: " + studentId + " Score: " + score + " Grade: " + grade;


                EnrolmentPK enPK = new EnrolmentPK(Integer.parseInt(studentId),
                        Context.getInstance().getSelectedSection().getSectionId(),
                        Context.getInstance().getSelectedSection().getSectionPK().getCourseNumber(),
                        Context.getInstance().getSelectedSection().getSectionPK().getDepartmentId(),
                        Context.getInstance().getSelectedSection().getSectionPK().getTermYear(),
                        Context.getInstance().getSelectedSection().getSectionPK().getSessionId(),
                        Context.getInstance().getSelectedSection().getSectionPK().getSectionTypeId());
                try
                {
                    Enrolment enrol = Enrolment.getEnrolmentByEnrolmentPK(enPK);
                    if (enrol.getScore() != null)
                    {
                        throw new Exception(LocaleManager.get(77));
                    }
                    enrol.setScore(Integer.parseInt(score));
                    if (hasThird)
                    {
                        enrol.setGradeId(Grade.getByName(grade));
                    }
                    // get enrolment to not active
                    enrol.setIsActive(false);
                    enrol.save();
                    result += " <uploaded>";
                    resultList.add(result);

                }
                catch (Exception ex)
                {
                    result += " <failed: " + ex.getLocalizedMessage() + ">";
                    resultList.add(result);
                }
            }
            lsvResult.getItems().setAll(resultList);
        }
        catch (IOException ex)
        {
            Logger.getLogger(UploadScoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
