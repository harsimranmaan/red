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
public class Department {
    
    private StringProperty deptId;

    
    private StringProperty deptName;

    public Department(String deptId, String deptName) {
        this.deptId = new SimpleStringProperty(deptId);
        this.deptName = new SimpleStringProperty(deptName);
    }

    public StringProperty deptIdProperty() { return deptId; }
    public StringProperty deptNameProperty() { return deptName; }
    
    public String getDeptId() {
        return deptId.get();
    }

    public String getDeptName() {
        return deptName.get();
    }
}
