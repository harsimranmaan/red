/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hsmaan
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentId", query = "SELECT d FROM Department d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByAddress", query = "SELECT d FROM Department d WHERE d.address = :address"),
    @NamedQuery(name = "Department.findByPin", query = "SELECT d FROM Department d WHERE d.pin = :pin"),
    @NamedQuery(name = "Department.findByDirector", query = "SELECT d FROM Department d WHERE d.director = :director"),
    @NamedQuery(name = "Department.findByPhone", query = "SELECT d FROM Department d WHERE d.phone = :phone"),
    @NamedQuery(name = "Department.findByEmail", query = "SELECT d FROM Department d WHERE d.email = :email"),
    @NamedQuery(name = "Department.findByWebsite", query = "SELECT d FROM Department d WHERE d.website = :website"),
    @NamedQuery(name = "Department.findByCreatedBy", query = "SELECT d FROM Department d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "Department.findByCreatedDateTime", query = "SELECT d FROM Department d WHERE d.createdDateTime = :createdDateTime"),
    @NamedQuery(name = "Department.findByModifiedBy", query = "SELECT d FROM Department d WHERE d.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Department.findByModifiedDateTime", query = "SELECT d FROM Department d WHERE d.modifiedDateTime = :modifiedDateTime"),
    @NamedQuery(name = "Department.findByIsActive", query = "SELECT d FROM Department d WHERE d.isActive = :isActive")
})
public class Department implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "pin")
    private String pin;
    @Basic(optional = false)
    @Column(name = "director")
    private String director;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @Column(name = "createdBy")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "createdDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Basic(optional = false)
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Basic(optional = false)
    @Column(name = "modifiedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDateTime;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department1")
    private Collection<Prerequisites> prerequisitesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department2")
    private Collection<Prerequisites> prerequisitesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department1")
    private Collection<Section> sectionCollection;

    public Department()
    {
    }

    public Department(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public Department(String departmentId, String name, String address, String pin, String director, String phone, String email, String website, String createdBy, Date createdDateTime, String modifiedBy, Date modifiedDateTime, boolean isActive)
    {
        this.departmentId = departmentId;
        this.name = name;
        this.address = address;
        this.pin = pin;
        this.director = director;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.createdBy = createdBy;
        this.createdDateTime = createdDateTime;
        this.modifiedBy = modifiedBy;
        this.modifiedDateTime = modifiedDateTime;
        this.isActive = isActive;
    }

    public String getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPin()
    {
        return pin;
    }

    public void setPin(String pin)
    {
        this.pin = pin;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public Date getCreatedDateTime()
    {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime)
    {
        this.createdDateTime = createdDateTime;
    }

    public String getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDateTime()
    {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime)
    {
        this.modifiedDateTime = modifiedDateTime;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Prerequisites> getPrerequisitesCollection()
    {
        return prerequisitesCollection;
    }

    public void setPrerequisitesCollection(Collection<Prerequisites> prerequisitesCollection)
    {
        this.prerequisitesCollection = prerequisitesCollection;
    }

    @XmlTransient
    public Collection<Prerequisites> getPrerequisitesCollection1()
    {
        return prerequisitesCollection1;
    }

    public void setPrerequisitesCollection1(Collection<Prerequisites> prerequisitesCollection1)
    {
        this.prerequisitesCollection1 = prerequisitesCollection1;
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
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department))
        {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Department[ departmentId=" + departmentId + " ]";
    }
}
