/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.api.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jingboyu
 */
public class DepartmentArray {
    
    //ArrayList<String> deptArray = new ArrayList<String>();
    ObservableList<Department> deptArray = FXCollections.observableArrayList();
    
    Department [] tmpDeptArray = {
            
            new Department("ADHE", "Adult and Higher Education"),
            new Department("BAAC", "Business Administration: Accounting"),
            new Department("CICS", "Computing Information and Cognitive Systems"),
            new Department("DENT", "Dentistry"),
            new Department("ECED", "Early Childhood Education"),
            new Department("FACT", "Faculty of Arts Commuter Transition Program"), 
            new Department("GENE", "Genetics"), 
            new Department("HEBR", "Hebrew"),
            new Department("IEST", "European Studies"),
            new Department("JAPN", "Japanese"),
            new Department("KLMN", "Korean"),
            new Department("LARC", "Landscape Architecture"),
            new Department("MATH", "Mathematics"),
            new Department("CONS", "Natural Resources Conservation"),
            new Department("NEST", "Near Eastern Studies"),
            new Department("ZOOL", "Zoology")};

   
    public DepartmentArray()
    {
        for (int i = 0; i < tmpDeptArray.length; i++)
        {
            deptArray.add(tmpDeptArray[i]);
        }
    }
            
    public ObservableList<Department> filterByChar(String str)
    {
        //ArrayList<String> returnArray = new ArrayList<String>();
        ObservableList<Department> returnArray = FXCollections.observableArrayList();
        if (str.equalsIgnoreCase("all"))
        {
            returnArray = deptArray;
        }
        else
        {
            for (Department dept : deptArray)
            {
                String tmpStr = dept.getDeptId();
                System.out.println(tmpStr);
                if (tmpStr.startsWith(str.toUpperCase()))
                {
                    returnArray.add(dept);
                }
            }
        }
        return returnArray;
    }
    

}
