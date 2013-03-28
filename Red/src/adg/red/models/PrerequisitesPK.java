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
 * @author hsmaan
 */
@Embeddable
public class PrerequisitesPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "course")
    private int course;
    @Basic(optional = false)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @Column(name = "preRequisite")
    private int preRequisite;
    @Basic(optional = false)
    @Column(name = "preRequisiteDept")
    private String preRequisiteDept;

    public PrerequisitesPK()
    {
    }

    public PrerequisitesPK(int course, String department, int preRequisite, String preRequisiteDept)
    {
        this.course = course;
        this.department = department;
        this.preRequisite = preRequisite;
        this.preRequisiteDept = preRequisiteDept;
    }

    public int getCourse()
    {
        return course;
    }

    public void setCourse(int course)
    {
        this.course = course;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public int getPreRequisite()
    {
        return preRequisite;
    }

    public void setPreRequisite(int preRequisite)
    {
        this.preRequisite = preRequisite;
    }

    public String getPreRequisiteDept()
    {
        return preRequisiteDept;
    }

    public void setPreRequisiteDept(String preRequisiteDept)
    {
        this.preRequisiteDept = preRequisiteDept;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) course;
        hash += (department != null ? department.hashCode() : 0);
        hash += (int) preRequisite;
        hash += (preRequisiteDept != null ? preRequisiteDept.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrerequisitesPK))
        {
            return false;
        }
        PrerequisitesPK other = (PrerequisitesPK) object;
        if (this.course != other.course)
        {
            return false;
        }
        if ((this.department == null && other.department != null) || (this.department != null && !this.department.equals(other.department)))
        {
            return false;
        }
        if (this.preRequisite != other.preRequisite)
        {
            return false;
        }
        if ((this.preRequisiteDept == null && other.preRequisiteDept != null) || (this.preRequisiteDept != null && !this.preRequisiteDept.equals(other.preRequisiteDept)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.PrerequisitesPK[ course=" + course + ", department=" + department + ", preRequisite=" + preRequisite + ", preRequisiteDept=" + preRequisiteDept + " ]";
    }
}
