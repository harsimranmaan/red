/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.models.Section;
import adg.red.models.SectionTimeTable;
import adg.red.models.User;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Witt
 */
public class Context
{

    private final static Context instance;
    private boolean loggedIn;
    private Label lblTitle;
    private Course userSelectCourse;
    private Department userSelectDepartment;
    private Section userSelectSection;
    private User currentUser;
    private Pane mainView;
    private Pane displayView;
    private Pane searchView;
    private Pane breadCrumb;
    //Singleton
    private List<SectionTimeTable> sectionTimeTableList;

    private Context()
    {
    }

    static
    {
        instance = new Context();
    }

    public static Context getInstance()
    {
        return instance;
    }

    public void setCurrentUser(User user)
    {
        currentUser = user;
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public Section getSelectedSection()
    {
        return userSelectSection;
    }

    public void setSelectedSection(Section userSelectSectionId)
    {
        this.userSelectSection = userSelectSectionId;
    }

    public Department getSelectedDepartment()
    {
        return userSelectDepartment;
    }

    public void setSelectedDepartment(Department userSelectDepartment)
    {
        this.userSelectDepartment = userSelectDepartment;
    }

    public Course getSelectedCourse()
    {
        return userSelectCourse;
    }

    public void setSelectedCourse(Course userSelectCourse)
    {
        this.userSelectCourse = userSelectCourse;
        // also update the deparment
        this.userSelectDepartment = userSelectCourse.getDepartment();
    }

    public void setWasLoggedIn(boolean loggedIn)
    {
        this.loggedIn = loggedIn;
    }

    public boolean WasLoggedIn()
    {
        return loggedIn;
    }

    public Pane getDisplayView()
    {
        return displayView;
    }

    public Pane getHomeView()
    {
        return mainView;
    }

    public void setDisplayView(Pane displayView)
    {
        this.displayView = displayView;
    }

    public void setMainView(Pane mainView)
    {
        this.mainView = mainView;
    }

    public Pane getSearchView()
    {
        return searchView;
    }

    public void setSearchView(Pane searchPane)
    {
        this.searchView = searchPane;
    }

    public void setBreadCrumb(Pane breadCrumbArea)
    {
        this.breadCrumb = breadCrumbArea;
    }

    public Pane getBreadCrumb()
    {
        return this.breadCrumb;
    }

    public void setTitleLabel(Label lblTitle)
    {
        this.lblTitle = lblTitle;
    }

    public void setTitle(String title)
    {
        this.lblTitle.setText(title);
    }

    public void setTimeTable(List<SectionTimeTable> sectionTimeTableList) {
        this.sectionTimeTableList = sectionTimeTableList;
    }
    
    public List<SectionTimeTable> getTimeTable() {
        return sectionTimeTableList;
    }
    
}
