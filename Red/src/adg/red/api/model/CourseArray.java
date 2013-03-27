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
            new Course("CICS 530", "Advanced Software Engineering Project"),
           
            new Course("DENT 410", "Dentistry I"),
            new Course("DENT 420", "Dentistry II"),
            new Course("DENT 430", "Dentistry III"),
            new Course("DENT 440", "Dentistry IV"),
            new Course("DENT 504", "Endodontic Microsurgery"),
            new Course("DENT 505", "Dental Traumatology"),
            new Course("DENT 510", "Pediatric Dentistry Literature Review I"),
            new Course("DENT 511", "Pediatric Dentistry Literature Review II"),
            new Course("DENT 512", "Pediatric Dentistry Literature Review III"),
            new Course("DENT 513", "The Pediatric Patient I"),
            new Course("DENT 514", "The Pediatric Patient II"),
            new Course("DENT 515", "The Pediatric Patient III"),
            new Course("DENT 516", "Pediatric Dentistry Case Review and Treatment Planning I"),
            new Course("DENT 517", "Pediatric Dentistry Case Review and Treatment Planning II"),
            new Course("DENT 518", "Pediatric Dentistry Case Review and Treatment Planning III"),
            new Course("DENT 523", "Oral Medicine II"),
            new Course("DENT 524", "Craniofacial Growth and Development"),
            new Course("DENT 525", "Prosthodontic Literature Review I"),
            new Course("DENT 526", "Prosthodontic Literature Review II"),
            new Course("DENT 527", "Prosthodontic Treatment Planning and Outcomes Seminars I"),
            new Course("DENT 528", "Prosthodontic Treatment Planning and Outcomes Seminars II"),
            new Course("DENT 529", "Prosthodontic Treatment Planning and Outcomes Seminars III"),
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
                if (course.getCourseId().contains(dept))
                    returnArray.add(course);
            }
        
        return returnArray;
    }
}
