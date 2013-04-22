/*
 * The Context class is to store some of the objects so that they can be
 * accessed later.
 */
package adg.red.session;

import adg.red.models.enums.FacultyAction;
import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.models.Section;
import adg.red.models.SectionTimeTable;
import adg.red.models.User;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * The Context class is to store some of the objects so that they can be
 * accessed later.
 * <p/>
 * @author Witt
 */
public class Context
{

    private final static Context instance;
    private boolean loggedIn;
    private boolean searching;
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
    private List<Course> searchResultList;
    private FacultyAction facultyAction;

    private Context()
    {
    }

    // create new instance of Context
    static
    {
        instance = new Context();
    }

    /**
     * The static function to get the instance of Context.
     * <p/>
     * @return the instance of Context
     */
    public static Context getInstance()
    {
        return instance;
    }

    /**
     * The setter function for currentUser.
     * <p/>
     * @param user the user to be set
     */
    public void setCurrentUser(User user)
    {
        currentUser = user;
    }

    /**
     * The getter function for currentUser.
     * <p/>
     * @return the currentUser variable
     */
    public User getCurrentUser()
    {
        return currentUser;
    }

    /**
     * The getter function for userSelectSection.
     * <p/>
     * @return the userSelectSection variable
     */
    public Section getSelectedSection()
    {
        return userSelectSection;
    }

    /**
     * The setter function for userSelectSection.
     * <p/>
     * @param userSelectSectionId the section to be set
     */
    public void setSelectedSection(Section userSelectSectionId)
    {
        this.userSelectSection = userSelectSectionId;
    }

    /**
     * The getter function for userSelectDepartment.
     * <p/>
     * @return the userSelectDepartment variable
     */
    public Department getSelectedDepartment()
    {
        return userSelectDepartment;
    }

    /**
     * The setter function for userSelectDepartment.
     * <p/>
     * @param userSelectDepartment the department to be set
     */
    public void setSelectedDepartment(Department userSelectDepartment)
    {
        this.userSelectDepartment = userSelectDepartment;
    }

    /**
     * The getter function for userSelectCourse.
     * <p/>
     * @return the userSelectCourse variable
     */
    public Course getSelectedCourse()
    {
        return userSelectCourse;
    }

    /**
     * The setter function for userSelectCourse.
     * <p/>
     * @param userSelectCourse the course to be set
     */
    public void setSelectedCourse(Course userSelectCourse)
    {
        this.userSelectCourse = userSelectCourse;
        // also update the deparment
        this.userSelectDepartment = userSelectCourse.getDepartment();
    }

    /**
     * The setter function for loggedIn.
     * <p/>
     * @param loggedIn the boolean value to be set
     */
    public void setWasLoggedIn(boolean loggedIn)
    {
        this.loggedIn = loggedIn;
    }

    /**
     * The getter function for loggedIn.
     * <p/>
     * @return loggedIn variable
     */
    public boolean WasLoggedIn()
    {
        return loggedIn;
    }

    /**
     * The getter function for displayView.
     * <p/>
     * @return the displayView variable
     */
    public Pane getDisplayView()
    {
        return displayView;
    }

    /**
     * The getter function for mainView.
     * <p/>
     * @return the mainView variable
     */
    public Pane getMainView()
    {
        return mainView;
    }

    /**
     * The setter function for displayView.
     * <p/>
     * @param displayView the pane to be set
     */
    public void setDisplayView(Pane displayView)
    {
        this.displayView = displayView;
    }

    /**
     * The setter function for mainView.
     * <p/>
     * @param mainView the pane to be set
     */
    public void setMainView(Pane mainView)
    {
        this.mainView = mainView;
    }

    /**
     * The getter function for searchView.
     * <p/>
     * @return the searchView variable
     */
    public Pane getSearchView()
    {
        return searchView;
    }

    /**
     * The setter function for searchView.
     * <p/>
     * @param searchPane the pane to be set
     */
    public void setSearchView(Pane searchPane)
    {
        this.searchView = searchPane;
    }

    /**
     * The setter function for breadCrumb.
     * <p/>
     * @param breadCrumbArea the pane to be set
     */
    public void setBreadCrumb(Pane breadCrumbArea)
    {
        this.breadCrumb = breadCrumbArea;
    }

    /**
     * The getter function for breadCrumb.
     * <p/>
     * @return the breadCrumb variable
     */
    public Pane getBreadCrumb()
    {
        return this.breadCrumb;
    }

    /**
     * The setter function for lblTitle.
     * <p/>
     * @param lblTitle the label to be set
     */
    public void setTitleLabel(Label lblTitle)
    {
        this.lblTitle = lblTitle;
    }

    /**
     * The function sets text of lblTitle.
     * <p/>
     * @param title the string to be set
     */
    public void setTitle(String title)
    {
        this.lblTitle.setText(title);
    }

    /**
     * The setter function for sectionTimeTableList.
     * <p/>
     * @param sectionTimeTableList the list of SectionTimeTable to be set
     */
    public void setTimeTable(List<SectionTimeTable> sectionTimeTableList)
    {
        this.sectionTimeTableList = sectionTimeTableList;
    }

    /**
     * The getter function for sectionTimeTableList.
     * <p/>
     * @return the sectionTimeTableList variable
     */
    public List<SectionTimeTable> getTimeTable()
    {
        return sectionTimeTableList;
    }

    /**
     * The setter function for facultyAction.
     * <p/>
     * @param facultyAction the FacultyAction to be set
     */
    public void setFacultyAction(FacultyAction facultyAction)
    {
        this.facultyAction = facultyAction;
    }

    /**
     * The getter function for facultyAction.
     * <p/>
     * @return the facultyAction variable
     */
    public FacultyAction getFacultyAction()
    {
        return this.facultyAction;
    }

    public boolean isSearching()
    {
        return searching;
    }

    public void setSearching(boolean isSearching)
    {
        this.searching = isSearching;
    }

    public List<Course> getSearchResultList()
    {
        return searchResultList;
    }

    public void setSearchResultList(List<Course> searchResultList)
    {
        this.searchResultList = searchResultList;
    }
}
