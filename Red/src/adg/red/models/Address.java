/*
 * 
 * 
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
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
@Table(name = "Address")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId"),
    @NamedQuery(name = "Address.findByAddressLineFirst", query = "SELECT a FROM Address a WHERE a.addressLineFirst = :addressLineFirst"),
    @NamedQuery(name = "Address.findByAddressLineSecond", query = "SELECT a FROM Address a WHERE a.addressLineSecond = :addressLineSecond"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByProvince", query = "SELECT a FROM Address a WHERE a.province = :province"),
    @NamedQuery(name = "Address.findByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")
})
public class Address implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressId")
    private Integer addressId;
    @Basic(optional = false)
    @Column(name = "addressLineFirst")
    private String addressLineFirst;
    @Column(name = "addressLineSecond")
    private String addressLineSecond;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Basic(optional = false)
    @Column(name = "postalCode")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;

    public Address()
    {
    }

    public Address(Integer addressId)
    {
        this.addressId = addressId;
    }

    public Address(Integer addressId, String addressLineFirst, String city, String postalCode, String country)
    {
        this.addressId = addressId;
        this.addressLineFirst = addressLineFirst;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Integer getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Integer addressId)
    {
        this.addressId = addressId;
    }

    public String getAddressLineFirst()
    {
        return addressLineFirst;
    }

    public void setAddressLineFirst(String addressLineFirst)
    {
        this.addressLineFirst = addressLineFirst;
    }

    public String getAddressLineSecond()
    {
        return addressLineSecond;
    }

    public void setAddressLineSecond(String addressLineSecond)
    {
        this.addressLineSecond = addressLineSecond;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address))
        {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Address[ addressId=" + addressId + " ]";
    }

    public void save()
    {
        RedEntityManager.save(this);
    }
}
