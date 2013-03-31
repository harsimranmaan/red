/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
@Table(name = "Locale")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Locale.findAll", query = "SELECT l FROM Locale l"),
    @NamedQuery(name = "Locale.findById", query = "SELECT l FROM Locale l WHERE l.id = :id"),
    @NamedQuery(name = "Locale.findByName", query = "SELECT l FROM Locale l WHERE l.name = :name")
})
public class Locale implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locale")
    private Collection<ResourceDictionary> resourceDictionaryCollection;

    public Locale()
    {
    }

    public Locale(Integer id)
    {
        this.id = id;
    }

    public Locale(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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
    public Collection<ResourceDictionary> getResourceDictionaryCollection()
    {
        return resourceDictionaryCollection;
    }

    public void setResourceDictionaryCollection(Collection<ResourceDictionary> resourceDictionaryCollection)
    {
        this.resourceDictionaryCollection = resourceDictionaryCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locale))
        {
            return false;
        }
        Locale other = (Locale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Locale[ id=" + id + " ]";
    }

    public static Locale findByName(String localeName)
    {
        List<Locale> localeList = RedEntityManager.getEntityManager().createNamedQuery("Locale.findByName").setParameter("name", localeName).getResultList();
        return localeList.get(0);
    }
}
