/*
 * 
 * 
 */
package adg.red.models;

import java.io.Serializable;
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
@Table(name = "SectionType")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "SectionType.findAll", query = "SELECT s FROM SectionType s"),
    @NamedQuery(name = "SectionType.findBySectionTypeId", query = "SELECT s FROM SectionType s WHERE s.sectionTypeId = :sectionTypeId"),
    @NamedQuery(name = "SectionType.findByName", query = "SELECT s FROM SectionType s WHERE s.name = :name")
})
public class SectionType implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sectionTypeId")
    private Integer sectionTypeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    /**
     * Default constructor
     */
    public SectionType()
    {
    }

    /**
     * Constructor
     * @param sectionTypeId table attribute sectionTypeId
     */
    public SectionType(Integer sectionTypeId)
    {
        this.sectionTypeId = sectionTypeId;
    }

    /**
     * Constructor
     * @param sectionTypeId table attribute sectionTypeId
     * @param name table attribute name
     */
    public SectionType(Integer sectionTypeId, String name)
    {
        this.sectionTypeId = sectionTypeId;
        this.name = name;
    }

    /**
     * Get table attribute sectionTypeId
     * @return sectionTypeId
     */
    public Integer getSectionTypeId()
    {
        return sectionTypeId;
    }

    /**
     * Set table attribute sectionTypeId
     * @param sectionTypeId 
     */
    public void setSectionTypeId(Integer sectionTypeId)
    {
        this.sectionTypeId = sectionTypeId;
    }

    /**
     * Get table attribute name
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set table attribute name
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get record location
     * @return hash code 
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (sectionTypeId != null ? sectionTypeId.hashCode() : 0);
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
        if (!(object instanceof SectionType))
        {
            return false;
        }
        SectionType other = (SectionType) object;
        if ((this.sectionTypeId == null && other.sectionTypeId != null) || (this.sectionTypeId != null && !this.sectionTypeId.equals(other.sectionTypeId)))
        {
            return false;
        }
        return true;
    }

    /**
     * print sectionTypeId
     * @return sectionTypeId as a string
     */
    @Override
    public String toString()
    {
        return "adg.red.models.SectionType[ sectionTypeId=" + sectionTypeId + " ]";
    }
}
