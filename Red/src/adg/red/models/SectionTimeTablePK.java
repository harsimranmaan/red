/*
 *
 *
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author harsimran.maan
 */
@Embeddable
public class SectionTimeTablePK implements Serializable
{

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
    @Basic(optional = false)
    @Column(name = "dayId")
    private int dayId;
    @Basic(optional = false)
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    /**
     *
     */
    public SectionTimeTablePK()
    {
    }

    /**
     *
     * @param sectionId
     * @param courseNumber
     * @param departmentId
     * @param termYear
     * @param sessionId
     * @param sectionTypeId
     * @param dayId
     * @param startTime
     */
    public SectionTimeTablePK(int sectionId, int courseNumber, String departmentId, int termYear, int sessionId, int sectionTypeId, int dayId, Date startTime)
    {
        this.sectionId = sectionId;
        this.courseNumber = courseNumber;
        this.departmentId = departmentId;
        this.termYear = termYear;
        this.sessionId = sessionId;
        this.sectionTypeId = sectionTypeId;
        this.dayId = dayId;
        this.startTime = startTime;
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
    public int getDayId()
    {
        return dayId;
    }

    /**
     *
     * @param dayId
     */
    public void setDayId(int dayId)
    {
        this.dayId = dayId;
    }

    /**
     *
     * @return
     */
    public Date getStartTime()
    {
        return startTime;
    }

    /**
     *
     * @param startTime
     */
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) sectionId;
        hash += (int) courseNumber;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        hash += (int) termYear;
        hash += (int) sessionId;
        hash += (int) sectionTypeId;
        hash += (int) dayId;
        hash += (startTime != null ? startTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectionTimeTablePK))
        {
            return false;
        }
        SectionTimeTablePK other = (SectionTimeTablePK) object;
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
        if (this.dayId != other.dayId)
        {
            return false;
        }
        if ((this.startTime == null && other.startTime != null) || (this.startTime != null && !this.startTime.equals(other.startTime)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.SectionTimeTablePK[ sectionId=" + sectionId + ", courseNumber=" + courseNumber + ", departmentId=" + departmentId + ", termYear=" + termYear + ", sessionId=" + sessionId + ", sectionTypeId=" + sectionTypeId + ", dayId=" + dayId + ", startTime=" + startTime + " ]";
    }
}
