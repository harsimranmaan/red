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
@Table(name = "Day")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Day.findAll", query = "SELECT d FROM Day d"),
    @NamedQuery(name = "Day.findByDayId", query = "SELECT d FROM Day d WHERE d.dayId = :dayId"),
    @NamedQuery(name = "Day.findByDay", query = "SELECT d FROM Day d WHERE d.day = :day")
})
public class Day implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dayId")
    private Integer dayId;
    @Basic(optional = false)
    @Column(name = "day")
    private String day;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "day")
    private Collection<SectionTimeTable> sectionTimeTableCollection;

    public Day()
    {
    }

    public Day(Integer dayId)
    {
        this.dayId = dayId;
    }

    public Day(Integer dayId, String day)
    {
        this.dayId = dayId;
        this.day = day;
    }

    public Integer getDayId()
    {
        return dayId;
    }

    public void setDayId(Integer dayId)
    {
        this.dayId = dayId;
    }

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
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
        if (!(object instanceof Day))
        {
            return false;
        }
        Day other = (Day) object;
        if ((this.dayId == null && other.dayId != null) || (this.dayId != null && !this.dayId.equals(other.dayId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Day[ dayId=" + dayId + " ]";
    }
}
