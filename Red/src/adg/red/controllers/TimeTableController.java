/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.SectionTimeTable;
import adg.red.utils.LocaleManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import adg.red.utils.Context;
import java.util.List;

/**
 * FXML Controller class
 *
 * @author jayzt_000
 */
public class TimeTableController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Context.getInstance().setTitle(LocaleManager.get(24));
        BreadCrumbController.renderBreadCrumb("student/HomeView|TimeTable");
        List<SectionTimeTable> timeTableList = Context.getInstance().getTimeTable();
    }
    
}
