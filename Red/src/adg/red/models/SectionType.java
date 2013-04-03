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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectionType")
    private Collection<Section> sectionCollection;

    public SectionType()
    {
    }

    public SectionType(Integer sectionTypeId)
    {
        this.sectionTypeId = sectionTypeId;
    }

    public SectionType(Integer sectionTypeId, String name)
    {
        this.sectionTypeId = sectionTypeId;
        this.name = name;
    }

    public Integer getSectionTypeId()
    {
        return sectionTypeId;
    }

    public void setSectionTypeId(Integer sectionTypeId)
    {
        this.sectionTypeId = sectionTypeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @XmlTransient
    public Collection<Section> getSectionCollection()
    {
        return sectionCollection;
    }

    public void setSectionCollection(Collection<Section> sectionCollection)
    {
        this.sectionCollection = sectionCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (sectionTypeId != null ? sectionTypeId.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString()
    {
        return "adg.red.models.SectionType[ sectionTypeId=" + sectionTypeId + " ]";
    }
}
