/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.SectionTimeTable;
import adg.red.models.WeekDay;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import adg.red.utils.Context;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 * <p/>
 * @author jayzt_000
 */
public class TimeTableController implements Initializable
{

    @FXML
    private GridPane gdpTimeTable;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(24));
        BreadCrumbController.renderBreadCrumb("student/HomeView|TimeTable");
        Context.getInstance().setTitle(LocaleManager.get(68));
        List<SectionTimeTable> timeTableList = Context.getInstance().getTimeTable();

        List<WeekDay> dayList = WeekDay.getAllWeekDay();
        int col = 1;
        for (WeekDay weekDay : dayList)
        {
            Label label = new Label(weekDay.getWeekDay());
            gdpTimeTable.add(label, col++, 0);
        }

        int hrs = 8;
        for (int rows = 1; rows < 25; hrs++)
        {
            Label label = new Label(hrs + ":00");
            gdpTimeTable.add(label, 0, rows++);
            rows++;
//            Label label1 = new Label(hrs + ":30");
//            gdp.add(label1, 0, rows++);
        }


//            if (SectionTimeTable.getBySectionPK() != null){
//                List<SectionTimeTable> list = SectionTimeTable.getBySectionPK();//enrol.getSection().getSectionPK());
//                for (SectionTimeTable table : list)
//                {
//                    for(int col = 1 ; col < 8; col++)
//                        for(int row = 1; row <25; row++ )
//                    Label label = new Label(table.getSectionTimeTablePK().getDepartmentId() + " " + table.getSectionTimeTablePK().getCourseNumber());
//                    gdp.add(label, 0, i++);
//                    System.out.println("" + table.getSectionTimeTablePK().getDayId() + " " + DateFormatter.formatTime(table.getSectionTimeTablePK().getStartTime()) + " " + table.getLengthInMinutes());
//                }
//            }


    }
}
