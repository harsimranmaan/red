/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "SectionTimeTable")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "SectionTimeTable.findAll", query = "SELECT s FROM SectionTimeTable s"),
    @NamedQuery(name = "SectionTimeTable.findBySectionId", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.sectionId = :sectionId"),
    @NamedQuery(name = "SectionTimeTable.findByCourseNumber", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.courseNumber = :courseNumber"),
    @NamedQuery(name = "SectionTimeTable.findByDepartmentId", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.departmentId = :departmentId"),
    @NamedQuery(name = "SectionTimeTable.findByTermYear", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.termYear = :termYear"),
    @NamedQuery(name = "SectionTimeTable.findBySessionId", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.sessionId = :sessionId"),
    @NamedQuery(name = "SectionTimeTable.findBySectionTypeId", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.sectionTypeId = :sectionTypeId"),
    @NamedQuery(name = "SectionTimeTable.findByDayId", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.dayId = :dayId"),
    @NamedQuery(name = "SectionTimeTable.findByStartTime", query = "SELECT s FROM SectionTimeTable s WHERE s.sectionTimeTablePK.startTime = :startTime"),
    @NamedQuery(name = "SectionTimeTable.findByLengthInMinutes", query = "SELECT s FROM SectionTimeTable s WHERE s.lengthInMinutes = :lengthInMinutes")
})
public class SectionTimeTable implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SectionTimeTablePK sectionTimeTablePK;
    @Basic(optional = false)
    @Column(name = "lengthInMinutes")
    private int lengthInMinutes;
    @JoinColumn(name = "dayId", referencedColumnName = "dayId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WeekDay weekDay;
    @JoinColumns(
    {
        @JoinColumn(name = "sectionId", referencedColumnName = "sectionId", insertable = false, updatable = false),
        @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false),
        @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false),
        @JoinColumn(name = "termYear", referencedColumnName = "termYear", insertable = false, updatable = false),
        @JoinColumn(name = "sessionId", referencedColumnName = "sessionId", insertable = false, updatable = false),
        @JoinColumn(name = "sectionTypeId", referencedColumnName = "sectionTypeId", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Section section;

    public SectionTimeTable()
    {
    }

    public SectionTimeTable(SectionTimeTablePK sectionTimeTablePK)
    {
        this.sectionTimeTablePK = sectionTimeTablePK;
    }

    public SectionTimeTable(SectionTimeTablePK sectionTimeTablePK, int lengthInMinutes)
    {
        this.sectionTimeTablePK = sectionTimeTablePK;
        this.lengthInMinutes = lengthInMinutes;
    }

    public SectionTimeTable(int sectionId, int courseNumber, String departmentId, Date termYear, int sessionId, int sectionTypeId, int dayId, Date startTime)
    {
        this.sectionTimeTablePK = new SectionTimeTablePK(sectionId, courseNumber, departmentId, termYear, sessionId, sectionTypeId, dayId, startTime);
    }

    public SectionTimeTablePK getSectionTimeTablePK()
    {
        return sectionTimeTablePK;
    }

    public void setSectionTimeTablePK(SectionTimeTablePK sectionTimeTablePK)
    {
        this.sectionTimeTablePK = sectionTimeTablePK;
    }

    public int getLengthInMinutes()
    {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes)
    {
        this.lengthInMinutes = lengthInMinutes;
    }

    public WeekDay getWeekDay()
    {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay)
    {
        this.weekDay = weekDay;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (sectionTimeTablePK != null ? sectionTimeTablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SectionTimeTable))
        {
            return false;
        }
        SectionTimeTable other = (SectionTimeTable) object;
        if ((this.sectionTimeTablePK == null && other.sectionTimeTablePK != null) || (this.sectionTimeTablePK != null && !this.sectionTimeTablePK.equals(other.sectionTimeTablePK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.SectionTimeTable[ sectionTimeTablePK=" + sectionTimeTablePK + " ]";
    }
}
