/*
 *
 *
 */
package adg.red.controllers;

import adg.red.models.SectionTimeTable;
import adg.red.models.WeekDay;
import adg.red.locale.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import adg.red.session.Context;
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
 * FXML Controller class for TimeTable.fxml
 * <p/>
 * @author Jaspreet Thind
 */
public class TimeTableController implements Initializable
{

    @FXML
    private GridPane gdpTimeTable;
    private String lastLabelText = "";

    /**
     * Initialize grid pane
     * <p/>
     * @param dayListSize size of the days
     */
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

    /**
     * Position the time labels
     * <p/>
     * @param length course durations
     * @param table  section timetable
     * @param cols   the column that the time label positioned
     * @param row    the row that the time label positioned
     */
    private void pasteLabels(int length, SectionTimeTable table, int cols, int row, int overlap)
    {
        String labelText = "";
        System.out.println(overlap);
        for (int rowLength = 0; rowLength < length / 30; rowLength++)
        {
            labelText = table.getSectionTimeTablePK().getDepartmentId() + " " + table.getSectionTimeTablePK().getCourseNumber();
            Label label = new Label();
            if (overlap > rowLength)
            {
                label.setText(lastLabelText + " " + labelText);
                label.getStyleClass().add("timeTableView-overlap-label");
            }
            else
            {
                label.setText(labelText);
                label.getStyleClass().add("timeTableView-label");
            }
            label.setTextFill(Color.WHITESMOKE);
            gdpTimeTable.add(label, cols, row++);
        }
        lastLabelText = labelText;
    }

    /**
     * Initialize the weekday headers of the timetable
     * <p/>
     * @param dayList week days
     */
    private void initHeader(List<WeekDay> dayList)
    {
        int col = 1;
        for (WeekDay weekDay : dayList)
        {
            Label label = new Label(weekDay.getWeekDay());
            gdpTimeTable.add(label, col++, 0);
        }
    }

    /**
     * Initialize the time labels in grid pane
     */
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

    /**
     * Populate section timetable with the input timetable list
     * <p/>
     * @param timeTableList the timetable list that initialized by the context
     * <p/>
     * @throws NumberFormatException
     */
    private void populateTimeTable(List<SectionTimeTable> timeTableList) throws NumberFormatException
    {
        if (timeTableList != null)
        {
            int cols, lastCol = 1;
            int toRow = 0;
            for (SectionTimeTable table : timeTableList)
            {
                int overlap = 0;

                cols = table.getSectionTimeTablePK().getDayId() % 100 + 1;
                int hour = Integer.parseInt(DateFormatter.formatHour(table.getSectionTimeTablePK().getStartTime()));
                int mins = Integer.parseInt(DateFormatter.formatMins(table.getSectionTimeTablePK().getStartTime()));
                int length = table.getLengthInMinutes();

                int baseHr = 8;
                for (int row = 1; row < 25; baseHr++)
                {
                    if (hour == baseHr && mins < 30)
                    {
                        if (cols == lastCol && row <= toRow)
                        {
                            overlap = toRow - row + 1;
                        }
                        lastCol = cols;

                        pasteLabels(length, table, cols, row, overlap);
                        toRow = row + (length / 30) - 1;
                        break;
                    }
                    else
                    {
                        row++;
                    }

                    if (hour == baseHr && mins >= 30)
                    {
                        if (cols == lastCol && row <= toRow)
                        {
                            overlap = toRow - row + 1;
                        }
                        lastCol = cols;

                        pasteLabels(length, table, cols, row, overlap);
                        toRow = row + (length / 30) - 1;
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

    /**
     * Initializes the controller class.
     * <p/>
     * @param url the URL
     * @param rb  the ResourceBundle
     */
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
