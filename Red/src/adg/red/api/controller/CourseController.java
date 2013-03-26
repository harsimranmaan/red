/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.api.controller;

import adg.red.api.model.CourseArray;
import adg.red.api.model.DepartmentArray;
import java.util.ArrayList;


public class CourseController {
    
    /**
     * constructor
     */
    public CourseController(){
        
        
    }
    
    /** Filter of showing the department lists
     * input: character A/B...or All
     * output: return the departmentId(starts with "A"/"B"/...), name
     */
    public ArrayList<String> departmentFilter(String str){
        
       DepartmentArray dept = new DepartmentArray();
       return dept.filterByChar(str);
    }
    
     /** Filter of showing the course lists
     * input: departmentId
     * output: return the course list () belongs to this department
     */
    public ArrayList<String> courseFilter(String dept){
        
       CourseArray course = new CourseArray();
       return course.filterByDept(dept);
    }
    
    
    
    
}
