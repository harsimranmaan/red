/*
 * 
 * 
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
public class EnrolmentPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "studentId")
    private int studentId;
    @Basic(optional = false)
    @Column(name = "sectionId")
    private int sectionId;
    @Basic(optional = false)
    @Column(name = "courseNumber")
    private int courseNumber;
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;
    @Basic(optional = false)
    @Column(name = "termYear")
    private int termYear;
    @Basic(optional = false)
    @Column(name = "sessionId")
    private int sessionId;
    @Basic(optional = false)
    @Column(name = "sectionTypeId")
    private int sectionTypeId;

    public EnrolmentPK()
    {
    }

    public EnrolmentPK(int studentId, int sectionId, int courseNumber, String departmentId, int termYear, int sessionId, int sectionTypeId)
    {
        this.studentId = studentId;
        this.sectionId = sectionId;
        this.courseNumber = courseNumber;
        this.departmentId = departmentId;
        this.termYear = termYear;
        this.sessionId = sessionId;
        this.sectionTypeId = sectionTypeId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public int getSectionId()
    {
        return sectionId;
    }

    public void setSectionId(int sectionId)
    {
        this.sectionId = sectionId;
    }

    public int getCourseNumber()
    {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber)
    {
        this.courseNumber = courseNumber;
    }

    public String getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public int getTermYear()
    {
        return termYear;
    }

    public void setTermYear(int termYear)
    {
        this.termYear = termYear;
    }

    public int getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(int sessionId)
    {
        this.sessionId = sessionId;
    }

    public int getSectionTypeId()
    {
        return sectionTypeId;
    }

    public void setSectionTypeId(int sectionTypeId)
    {
        this.sectionTypeId = sectionTypeId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) sectionId;
        hash += (int) courseNumber;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        hash += termYear;
        hash += (int) sessionId;
        hash += (int) sectionTypeId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnrolmentPK))
        {
            return false;
        }
        EnrolmentPK other = (EnrolmentPK) object;
        if (this.studentId != other.studentId)
        {
            return false;
        }
        if (this.sectionId != other.sectionId)
        {
            return false;
        }
        if (this.courseNumber != other.courseNumber)
        {
            return false;
        }
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId)))
        {
            return false;
        }
        if (this.termYear != other.termYear)
        {
            return false;
        }
        if (this.sessionId != other.sessionId)
        {
            return false;
        }
        if (this.sectionTypeId != other.sectionTypeId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.EnrolmentPK[ studentId=" + studentId + ", sectionId=" + sectionId + ", courseNumber=" + courseNumber + ", departmentId=" + departmentId + ", termYear=" + termYear + ", sessionId=" + sessionId + ", sectionTypeId=" + sectionTypeId + " ]";
    }
}
