/*
 * 
 * 
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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

    /**
     * Default constructor
     */
    public WeekDay()
    {
    }

    /**
     * Constructor
     * @param dayId table attribute
     */
    public WeekDay(Integer dayId)
    {
        this.dayId = dayId;
    }

    /**
     * Constructor
     * @param dayId table attribute
     * @param weekDay table attribute
     */
    public WeekDay(Integer dayId, String weekDay)
    {
        this.dayId = dayId;
        this.weekDay = weekDay;
    }

    /**
     * Get table attribute dayId
     * @return dayId
     */
    public Integer getDayId()
    {
        return dayId;
    }

    /**
     * Set table attribute dayId
     * @param dayId table attribute
     */
    public void setDayId(Integer dayId)
    {
        this.dayId = dayId;
    }

    /**
     * Get table attribute weekDay
     * @return weekDay
     */
    public String getWeekDay()
    {
        return weekDay;
    }

    /**
     * Set table attribute weekDay
     * @param weekDay table attribute
     */
    public void setWeekDay(String weekDay)
    {
        this.weekDay = weekDay;
    }
    
     /**
     * Get record location
     * @return hash code 
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (dayId != null ? dayId.hashCode() : 0);
        return hash;
    }

     /**
     * Comparator
     * @param object object to be compared with
     * @return true if two object equal to each other, otherwise return false
     */ 
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

    /**
     * print weekDay
     * @return weekDay as a string
     */
    @Override
    public String toString()
    {
        return "adg.red.models.WeekDay[ dayId=" + dayId + " ]";
    }
    
    public static List<WeekDay> getAllWeekDay()
    {
        return RedEntityManager.getEntityManager().createNamedQuery("WeekDay.findAll")
                .getResultList();
    }
}
