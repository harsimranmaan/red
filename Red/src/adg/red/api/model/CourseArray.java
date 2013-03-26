/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.api.model;

import java.util.ArrayList;

/**
 *
 * @author jingboyu
 */
public class CourseArray {
    
    ArrayList<String> courseArray = new ArrayList<String>();
    String [] tmpCourseArray = {
            
            "CICS 500", "Software Systems Internship",
            "CICS 505", "Introduction to Software Systems",
            "CICS 511", "Computational Structures",
            "CICS 520", "Database Systems",
            "CICS 530", "Advanced Software Engineering Project"
               };
    
    
    public CourseArray()
    {
        for (int i = 0; i < tmpCourseArray.length; i++)
        {
            courseArray.add(tmpCourseArray[i]);
        }
    }
            
    public ArrayList<String> filterByDept(String str)
    {
        ArrayList<String> returnArray = new ArrayList<String>();
        int i = 0;
        boolean flag = false;
            for (String tmpStr : courseArray)
            {
                if (i++%2 == 0)
                {
                    if (tmpStr.startsWith(str))
                    {
                        returnArray.add(tmpStr);
                        flag = true;
                    }
                }
                else
                {
                    if (flag)
                    {
                        returnArray.add(tmpStr);
                        flag = false;
                    }
                }
            }
        
        return returnArray;
    }
}
