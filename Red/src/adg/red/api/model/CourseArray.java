/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.api.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jingboyu
 */
public class CourseArray {
    
    ObservableList<Course> courseArray = FXCollections.observableArrayList();
    Course [] tmpCourseArray = {
            
            new Course("CICS 500", "Software Systems Internship"),
            new Course("CICS 505", "Introduction to Software Systems"),
            new Course("CICS 511", "Computational Structures"),
            new Course("CICS 520", "Database Systems"),
            new Course("CICS 530", "Advanced Software Engineering Project")
               };
    
    
    public CourseArray()
    {
        for (int i = 0; i < tmpCourseArray.length; i++)
        {
            courseArray.add(tmpCourseArray[i]);
        }
    }
            
    public ObservableList<Course> filterByDept(String dept)
    {
        ObservableList<Course> returnArray = FXCollections.observableArrayList();
            for (Course course : courseArray)
            {
                if (course.getCourseId().equals(dept))
                    returnArray.add(course);
            }
        
        return returnArray;
    }
}
