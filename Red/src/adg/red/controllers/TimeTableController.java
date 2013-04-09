/*
 * 
 * 
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
import java.util.List;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

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

    private void pasteLabels(int length, SectionTimeTable table, int cols, int row)
    {
        for (int rowLength = 0; rowLength < length / 30; rowLength++)
        {
            Label label = new Label(table.getSectionTimeTablePK().getDepartmentId() + " " + table.getSectionTimeTablePK().getCourseNumber());
            label.setTextFill(Color.RED);
            label.setStyle("-fx-background-color: #FFE4E4;");
            gdpTimeTable.add(label, cols, row++);
        }
    }

    private void initHeader(List<WeekDay> dayList)
    {
        int col = 1;
        for (WeekDay weekDay : dayList)
        {
            Label label = new Label(weekDay.getWeekDay());
            gdpTimeTable.add(label, col++, 0);
        }
    }

    private void initTimeLabels()
    {
        int hrs = 8;
        for (int row = 1; row < 25; hrs++)
        {
            Label label = new Label(hrs + ":00");
            gdpTimeTable.add(label, 0, row++);
            row++;
        }
    }

    private void populateTimeTable(List<SectionTimeTable> timeTableList) throws NumberFormatException
    {
        if (timeTableList != null)
        {
            int cols;

            for (SectionTimeTable table : timeTableList)
            {
                cols = table.getSectionTimeTablePK().getDayId() % 100 + 1;
                int hour = Integer.parseInt(DateFormatter.formatHour(table.getSectionTimeTablePK().getStartTime()));
                int mins = Integer.parseInt(DateFormatter.formatMins(table.getSectionTimeTablePK().getStartTime()));
                int length = table.getLengthInMinutes();

                int baseHr = 8;
                for (int row = 1; row < 25; baseHr++)
                {
                    if (hour == baseHr && mins < 30)
                    {
                        pasteLabels(length, table, cols, row);
                        break;
                    }
                    else
                    {
                        row++;
                    }

                    if (hour == baseHr && mins >= 30)
                    {
                        pasteLabels(length, table, cols, row);
                        break;
                    }
                    else
                    {
                        row++;
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        BreadCrumbController.renderBreadCrumb(Context.getInstance().getCurrentUser().getUserTypeId().getName().toLowerCase() + "/HomeView|TimeTable");
        Context.getInstance().setTitle(LocaleManager.get(68));
        List<SectionTimeTable> timeTableList = Context.getInstance().getTimeTable();

        List<WeekDay> dayList = WeekDay.getAllWeekDay();
        int dayListSize = dayList.size();
        initGrid(dayListSize);
        initHeader(dayList);
        initTimeLabels();
        populateTimeTable(timeTableList);


    }
}
