/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers.student;

import adg.red.models.Enrolment;
import adg.red.models.SectionTimeTable;
import adg.red.utils.Context;
import adg.red.utils.DateFormatter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 * <p/>
 * @author Witt
 */
public class TimeTableViewController implements Initializable
{

    @FXML
    private GridPane gdp;
    private ArrayList<SectionTimeTable> timeTableRows;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        timeTableRows = new ArrayList<>();
        List<Enrolment> enrolList = Enrolment.getEnrolmentsByStudentId(Context.getInstance().getCurrentUser().getStudent().getStudentId());

        for (Enrolment enrol : enrolList)
        {
            if (SectionTimeTable.getBySectionPK(enrol.getSection().getSectionPK()) != null)
            {

                List<SectionTimeTable> list = SectionTimeTable.getBySectionPK(enrol.getSection().getSectionPK());
                int i = 0;
                for (SectionTimeTable table : list)
                {
                    Label label = new Label(table.getSectionTimeTablePK().getDepartmentId() + " " + table.getSectionTimeTablePK().getCourseNumber());
                    gdp.add(label, 0, i++);
                    System.out.println("" + table.getSectionTimeTablePK().getDayId() + " " + DateFormatter.formatTime(table.getSectionTimeTablePK().getStartTime()) + " " + table.getLengthInMinutes());
                }
            }
        }
    }
}
