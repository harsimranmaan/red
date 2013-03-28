/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hsmaan
 */
@Entity
@Table(name = "Faculty")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findById", query = "SELECT f FROM Faculty f WHERE f.id = :id"),
    @NamedQuery(name = "Faculty.findByName", query = "SELECT f FROM Faculty f WHERE f.name = :name"),
    @NamedQuery(name = "Faculty.findByAddress1", query = "SELECT f FROM Faculty f WHERE f.address1 = :address1"),
    @NamedQuery(name = "Faculty.findByAddress2", query = "SELECT f FROM Faculty f WHERE f.address2 = :address2"),
    @NamedQuery(name = "Faculty.findByPin", query = "SELECT f FROM Faculty f WHERE f.pin = :pin"),
    @NamedQuery(name = "Faculty.findByCity", query = "SELECT f FROM Faculty f WHERE f.city = :city"),
    @NamedQuery(name = "Faculty.findByHeadOfFaculty", query = "SELECT f FROM Faculty f WHERE f.headOfFaculty = :headOfFaculty"),
    @NamedQuery(name = "Faculty.findByPhone", query = "SELECT f FROM Faculty f WHERE f.phone = :phone"),
    @NamedQuery(name = "Faculty.findByWebsite", query = "SELECT f FROM Faculty f WHERE f.website = :website")
})
public class Faculty implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @Column(name = "pin")
    private String pin;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "headOfFaculty")
    private String headOfFaculty;
    @Column(name = "phone")
    private String phone;
    @Column(name = "website")
    private String website;

    public Faculty()
    {
    }

    public Faculty(String id)
    {
        this.id = id;
    }

    public Faculty(String id, String name, String address1, String address2, String pin, String city, String headOfFaculty)
    {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.pin = pin;
        this.city = city;
        this.headOfFaculty = headOfFaculty;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    public String getPin()
    {
        return pin;
    }

    public void setPin(String pin)
    {
        this.pin = pin;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getHeadOfFaculty()
    {
        return headOfFaculty;
    }

    public void setHeadOfFaculty(String headOfFaculty)
    {
        this.headOfFaculty = headOfFaculty;
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
        if (!(object instanceof Faculty))
        {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Faculty[ id=" + id + " ]";
    }
}
