/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.models.Section;
import adg.red.models.User;

/**
 *
 * @author Witt
 */
public class Context
{

    private final static Context instance;
    private boolean loggedIn;

    //Singleton
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
    private Course userSelectCourse;
    private Department userSelectDepartment;
    private Section userSelectSection;
    private User currentUser;

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
    }

    public void setWasLoggedIn(boolean loggedIn)
    {
        this.loggedIn = loggedIn;
    }

    public boolean WasLoggedIn()
    {
        return loggedIn;
    }
}
