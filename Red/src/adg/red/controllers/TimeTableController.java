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
import adg.red.utils.DateFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * FXML Controller class
 * <p/>
 * @author jayzt_000
 */
public class TimeTableController implements Initializable
{

    @FXML
    private GridPane gdpTimeTable;

    private void initGrid(int dayListSize)
    {
        int width = 100 / (dayListSize + 1);

        for (int counter = 0; counter <= dayListSize; counter++)
        {
            ColumnConstraints constraints = new ColumnConstraints();
            constraints.setPercentWidth(width);
            constraints.setHgrow(Priority.ALWAYS);
            constraints.setHalignment(HPos.CENTER);
            gdpTimeTable.getColumnConstraints().add(constraints);
        }

        int numberOfRows = 25;
        int height = 100 / numberOfRows;
        for (int row = 0; row < numberOfRows; row++)
        {
            RowConstraints constraints = new RowConstraints();
            constraints.setPercentHeight(height);
            constraints.setVgrow(Priority.ALWAYS);
            constraints.setValignment(VPos.CENTER);
            gdpTimeTable.getRowConstraints().add(constraints);
        }

        gdpTimeTable.setSnapToPixel(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Context.getInstance().setTitle(LocaleManager.get(24));
        BreadCrumbController.renderBreadCrumb("student/HomeView|TimeTable");
        Context.getInstance().setTitle(LocaleManager.get(68));
        List<SectionTimeTable> timeTableList = Context.getInstance().getTimeTable();

        List<WeekDay> dayList = WeekDay.getAllWeekDay();
        int dayListSize = dayList.size();
        initGrid(dayListSize);

        int col = 1;
        for (WeekDay weekDay : dayList)
        {
            Label label = new Label(weekDay.getWeekDay());
            gdpTimeTable.add(label, col++, 0);
        }

        int hrs = 8;
        for (int row = 1; row < 25; hrs++)
        {
            Label label = new Label(hrs + ":00");
            gdpTimeTable.add(label, 0, row++);
            row++;
        }

        int cols = 1;
        int rows = 1;
        if (timeTableList != null)
        {
            for (SectionTimeTable table : timeTableList)
            {
                cols = table.getSectionTimeTablePK().getDayId() % 100 + 1;
                int hour = Integer.parseInt(DateFormatter.formatHour(table.getSectionTimeTablePK().getStartTime()));
                int mins = Integer.parseInt(DateFormatter.formatMins(table.getSectionTimeTablePK().getStartTime()));

//                int baseHr = 8;
//                for (int row = 1; row < 25; baseHr++)
//                {
//                    Label label = new Label(hrs + ":00");
//                    gdpTimeTable.add(label, 0, row++);
//                    row++;
//                }

                Label label = new Label(table.getSectionTimeTablePK().getDepartmentId() + " " + table.getSectionTimeTablePK().getCourseNumber());
                gdpTimeTable.add(label, cols, rows++);
                System.out.println("" + table.getSectionTimeTablePK().getDayId() + " " + DateFormatter.formatTime(table.getSectionTimeTablePK().getStartTime()) + " " + table.getLengthInMinutes());
            }
        }


    }
}
