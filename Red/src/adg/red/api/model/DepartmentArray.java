/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author jingboyu
 */
public class DepartmentArray {
    
    ArrayList<String> deptArray = new ArrayList<String>();
    
    String [] tmpDeptArray = {
            
            "ADHE", "Adult and Higher Education",
            "BAAC", "Business Administration: Accounting",
            "CICS", "Computing Information and Cognitive Systems",
            "DENT", "Dentistry",
            "ECED", "Early Childhood Education",
            "FACT", "Faculty of Arts Commuter Transition Program", 
            "GENE", "Genetics", 
            "HEBR", "Hebrew",
            "IEST", "European Studies",
            "JAPN", "Japanese",
            "KLMN", "Korean",
            "LARC", "Landscape Architecture",
            "MATH", "Mathematics",
            "CONS", "Natural Resources Conservation",
            "NEST", "Near Eastern Studies",
            "ZOOL", "Zoology"   };

    public DepartmentArray()
    {
        for (int i = 0; i < tmpDeptArray.length; i++)
        {
            deptArray.add(tmpDeptArray[i]);
        }
    }
            
    public ArrayList<String> filterByChar(String str)
    {
        ArrayList<String> returnArray = new ArrayList<String>();
        if (str.equalsIgnoreCase("all"))
        {
            returnArray = deptArray;
        }
        else
        {
            for (String tmpStr : deptArray)
            {
                if (tmpStr.startsWith(str))
                {
                    returnArray.add(tmpStr);
                }
            }
        }
        return returnArray;
    }
}
