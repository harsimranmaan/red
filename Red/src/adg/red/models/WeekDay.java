/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "WeekDay")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "WeekDay.findAll", query = "SELECT w FROM WeekDay w"),
    @NamedQuery(name = "WeekDay.findByDayId", query = "SELECT w FROM WeekDay w WHERE w.dayId = :dayId"),
    @NamedQuery(name = "WeekDay.findByWeekDay", query = "SELECT w FROM WeekDay w WHERE w.weekDay = :weekDay")
})
public class WeekDay implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dayId")
    private Integer dayId;
    @Basic(optional = false)
    @Column(name = "weekDay")
    private String weekDay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weekDay")
    private Collection<SectionTimeTable> sectionTimeTableCollection;

    public WeekDay()
    {
    }

    public WeekDay(Integer dayId)
    {
        this.dayId = dayId;
    }

    public WeekDay(Integer dayId, String weekDay)
    {
        this.dayId = dayId;
        this.weekDay = weekDay;
    }

    public Integer getDayId()
    {
        return dayId;
    }

    public void setDayId(Integer dayId)
    {
        this.dayId = dayId;
    }

    public String getWeekDay()
    {
        return weekDay;
    }

    public void setWeekDay(String weekDay)
    {
        this.weekDay = weekDay;
    }

    @XmlTransient
    public Collection<SectionTimeTable> getSectionTimeTableCollection()
    {
        return sectionTimeTableCollection;
    }

    public void setSectionTimeTableCollection(Collection<SectionTimeTable> sectionTimeTableCollection)
    {
        this.sectionTimeTableCollection = sectionTimeTableCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (dayId != null ? dayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeekDay))
        {
            return false;
        }
        WeekDay other = (WeekDay) object;
        if ((this.dayId == null && other.dayId != null) || (this.dayId != null && !this.dayId.equals(other.dayId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.WeekDay[ dayId=" + dayId + " ]";
    }
}
