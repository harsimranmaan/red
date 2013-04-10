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
public class SectionPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "sectionId")
    private int sectionId;
    @Basic(optional = false)
    @Column(name = "sectionTypeId")
    private int sectionTypeId;
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

    /**
     *
     */
    public SectionPK()
    {
    }

    /**
     *
     * @param sectionId
     * @param sectionTypeId
     * @param courseNumber
     * @param departmentId
     * @param termYear
     * @param sessionId
     */
    public SectionPK(int sectionId, int sectionTypeId, int courseNumber, String departmentId, int termYear, int sessionId)
    {
        this.sectionId = sectionId;
        this.sectionTypeId = sectionTypeId;
        this.courseNumber = courseNumber;
        this.departmentId = departmentId;
        this.termYear = termYear;
        this.sessionId = sessionId;
    }

    /**
     *
     * @return
     */
    public int getSectionId()
    {
        return sectionId;
    }

    /**
     *
     * @param sectionId
     */
    public void setSectionId(int sectionId)
    {
        this.sectionId = sectionId;
    }

    /**
     *
     * @return
     */
    public int getSectionTypeId()
    {
        return sectionTypeId;
    }

    /**
     *
     * @param sectionTypeId
     */
    public void setSectionTypeId(int sectionTypeId)
    {
        this.sectionTypeId = sectionTypeId;
    }

    /**
     *
     * @return
     */
    public int getCourseNumber()
    {
        return courseNumber;
    }

    /**
     *
     * @param courseNumber
     */
    public void setCourseNumber(int courseNumber)
    {
        this.courseNumber = courseNumber;
    }

    /**
     *
     * @return
     */
    public String getDepartmentId()
    {
        return departmentId;
    }

    /**
     *
     * @param departmentId
     */
    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    /**
     *
     * @return
     */
    public int getTermYear()
    {
        return termYear;
    }

    /**
     *
     * @param termYear
     */
    public void setTermYear(int termYear)
    {
        this.termYear = termYear;
    }

    /**
     *
     * @return
     */
    public int getSessionId()
    {
        return sessionId;
    }

    /**
     *
     * @param sessionId
     */
    public void setSessionId(int sessionId)
    {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) sectionId;
        hash += (int) sectionTypeId;
        hash += (int) courseNumber;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        hash += termYear;
        hash += (int) sessionId;
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
        if (this.sectionId != other.sectionId)
        {
            return false;
        }
        if (this.sectionTypeId != other.sectionTypeId)
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
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.SectionPK[ sectionId=" + sectionId + ", sectionTypeId=" + sectionTypeId + ", courseNumber=" + courseNumber + ", departmentId=" + departmentId + ", termYear=" + termYear + ", sessionId=" + sessionId + " ]";
    }
}
