/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.api.model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author jingboyu
 */
public class Course {
   private StringProperty courseId;
    private StringProperty courseName;

    public Course(String courseId, String courseName) {
        this.courseId = new SimpleStringProperty(courseId);
        this.courseName = new SimpleStringProperty(courseName);
    }

    public StringProperty courseIdProperty() { return courseId; }
    public StringProperty courseNameProperty() { return courseName; }
    
    public String getCourseId() {
        return courseId.get();
    }

    public String getCourseName() {
        return courseName.get();
    }   
}
