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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "Faculty")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findByFacultyId", query = "SELECT f FROM Faculty f WHERE f.facultyId = :facultyId"),
    @NamedQuery(name = "Faculty.findByName", query = "SELECT f FROM Faculty f WHERE f.name = :name"),
    @NamedQuery(name = "Faculty.findByHeadOfFacultyId", query = "SELECT f FROM Faculty f WHERE f.headOfFacultyId = :headOfFacultyId"),
    @NamedQuery(name = "Faculty.findByPhone", query = "SELECT f FROM Faculty f WHERE f.phone = :phone"),
    @NamedQuery(name = "Faculty.findByWebsite", query = "SELECT f FROM Faculty f WHERE f.website = :website")
})
public class Faculty implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "facultyId")
    private Integer facultyId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "headOfFacultyId")
    private Integer headOfFacultyId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "website")
    private String website;
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @ManyToOne
    private Address addressId;
    @JoinColumn(name = "facultyId", referencedColumnName = "facultyMemberId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private FacultyMember facultyMember;

    public Faculty()
    {
    }

    public Faculty(Integer facultyId)
    {
        this.facultyId = facultyId;
    }

    public Faculty(Integer facultyId, String name)
    {
        this.facultyId = facultyId;
        this.name = name;
    }

    public Integer getFacultyId()
    {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId)
    {
        this.facultyId = facultyId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getHeadOfFacultyId()
    {
        return headOfFacultyId;
    }

    public void setHeadOfFacultyId(Integer headOfFacultyId)
    {
        this.headOfFacultyId = headOfFacultyId;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }

    public Address getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Address addressId)
    {
        this.addressId = addressId;
    }

    public FacultyMember getFacultyMember()
    {
        return facultyMember;
    }

    public void setFacultyMember(FacultyMember facultyMember)
    {
        this.facultyMember = facultyMember;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (facultyId != null ? facultyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty))
        {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facultyId == null && other.facultyId != null) || (this.facultyId != null && !this.facultyId.equals(other.facultyId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Faculty[ facultyId=" + facultyId + " ]";
    }
}
