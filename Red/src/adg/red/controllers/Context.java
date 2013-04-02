/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.controllers;

import adg.red.models.Course;
import adg.red.models.Department;
import adg.red.models.Section;

/**
 *
 * @author Witt
 */
public class Context
{

    private final static Context instance = new Context();

    public static Context getInstance()
    {
        return instance;
    }
    private Course userSelectCourse;
    private Department userSelectDepartment;
    private Section userSelectSection;

    public Section getUserSelectSection()
    {
        return userSelectSection;
    }

    public void setUserSelectSection(Section userSelectSectionId)
    {
        this.userSelectSection = userSelectSectionId;
    }

    public Department getUserSelectDepartment()
    {
        return userSelectDepartment;
    }

    public void setUserSelectDepartment(Department userSelectDepartment)
    {
        this.userSelectDepartment = userSelectDepartment;
    }

    public Course getUserSelectCourse()
    {
        return userSelectCourse;
    }

    public void setUserSelectCourse(Course userSelectCourse)
    {
        this.userSelectCourse = userSelectCourse;
    }
//    public int getUserSelectCourseNumer() {
//        return userSelectCourseNumer;
//    }
//
//    public void setUserSelectCourseNumer(int courseNumer) {
//        this.userSelectCourseNumer = courseNumer;
//    }
//    public String getUserSelectDeptId() {
//        return userSelectDeptId;
//    }
//
//    public void setUserSelectDeptId(String userSelect) {
//        this.userSelectDeptId = userSelect;
//    }
}
