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
public class SectionPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @Column(name = "course")
    private int course;
    @Basic(optional = false)
    @Column(name = "department")
    private String department;

    public SectionPK()
    {
    }

    public SectionPK(int number, int course, String department)
    {
        this.number = number;
        this.course = course;
        this.department = department;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) number;
        hash += (int) course;
        hash += (department != null ? department.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectionPK))
        {
            return false;
        }
        SectionPK other = (SectionPK) object;
        if (this.number != other.number)
        {
            return false;
        }
        if (this.course != other.course)
        {
            return false;
        }
        if ((this.department == null && other.department != null) || (this.department != null && !this.department.equals(other.department)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.SectionPK[ number=" + number + ", course=" + course + ", department=" + department + " ]";
    }
}
