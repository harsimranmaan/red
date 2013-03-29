/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author harsimran.maan
 */
@Embeddable
public class CoRequisitePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "courseNumber")
    private int courseNumber;
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;
    @Basic(optional = false)
    @Column(name = "coRequisiteNumber")
    private int coRequisiteNumber;
    @Basic(optional = false)
    @Column(name = "coRequisiteDeptId")
    private String coRequisiteDeptId;

    public CoRequisitePK() {
    }

    public CoRequisitePK(int courseNumber, String departmentId, int coRequisiteNumber, String coRequisiteDeptId) {
        this.courseNumber = courseNumber;
        this.departmentId = departmentId;
        this.coRequisiteNumber = coRequisiteNumber;
        this.coRequisiteDeptId = coRequisiteDeptId;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public int getCoRequisiteNumber() {
        return coRequisiteNumber;
    }

    public void setCoRequisiteNumber(int coRequisiteNumber) {
        this.coRequisiteNumber = coRequisiteNumber;
    }

    public String getCoRequisiteDeptId() {
        return coRequisiteDeptId;
    }

    public void setCoRequisiteDeptId(String coRequisiteDeptId) {
        this.coRequisiteDeptId = coRequisiteDeptId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) courseNumber;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        hash += (int) coRequisiteNumber;
        hash += (coRequisiteDeptId != null ? coRequisiteDeptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoRequisitePK)) {
            return false;
        }
        CoRequisitePK other = (CoRequisitePK) object;
        if (this.courseNumber != other.courseNumber) {
            return false;
        }
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        if (this.coRequisiteNumber != other.coRequisiteNumber) {
            return false;
        }
        if ((this.coRequisiteDeptId == null && other.coRequisiteDeptId != null) || (this.coRequisiteDeptId != null && !this.coRequisiteDeptId.equals(other.coRequisiteDeptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.CoRequisitePK[ courseNumber=" + courseNumber + ", departmentId=" + departmentId + ", coRequisiteNumber=" + coRequisiteNumber + ", coRequisiteDeptId=" + coRequisiteDeptId + " ]";
    }
    
}
