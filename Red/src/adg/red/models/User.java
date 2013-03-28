/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hsmaan
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByIsOnline", query = "SELECT u FROM User u WHERE u.isOnline = :isOnline"),
    @NamedQuery(name = "User.findByAddress1", query = "SELECT u FROM User u WHERE u.address1 = :address1"),
    @NamedQuery(name = "User.findByAddress2", query = "SELECT u FROM User u WHERE u.address2 = :address2"),
    @NamedQuery(name = "User.findByCity", query = "SELECT u FROM User u WHERE u.city = :city"),
    @NamedQuery(name = "User.findByPin", query = "SELECT u FROM User u WHERE u.pin = :pin"),
    @NamedQuery(name = "User.findByPhoneNumber", query = "SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "User.findByEmailAddress", query = "SELECT u FROM User u WHERE u.emailAddress = :emailAddress"),
    @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "User.findByCreatedBy", query = "SELECT u FROM User u WHERE u.createdBy = :createdBy"),
    @NamedQuery(name = "User.findByCreatedDateTime", query = "SELECT u FROM User u WHERE u.createdDateTime = :createdDateTime"),
    @NamedQuery(name = "User.findByLastModifiedBy", query = "SELECT u FROM User u WHERE u.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "User.findByModifiedDateTime", query = "SELECT u FROM User u WHERE u.modifiedDateTime = :modifiedDateTime"),
    @NamedQuery(name = "User.findByIsActive", query = "SELECT u FROM User u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "User.login", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
})
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "isOnline")
    private boolean isOnline;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "pin")
    private String pin;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "emailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "createdBy")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "createdDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Basic(optional = false)
    @Column(name = "lastModifiedBy")
    private String lastModifiedBy;
    @Basic(optional = false)
    @Column(name = "modifiedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDateTime;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    @ManyToOne(optional = false)
    private UserType userTypeId;

    public User()
    {
    }

    public User(String username)
    {
        this.username = username;
    }

    public User(String username, String password, String firstName, String lastName, boolean isOnline, String pin, String emailAddress, Date dateOfBirth, String createdBy, Date createdDateTime, String lastModifiedBy, Date modifiedDateTime, boolean isActive)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isOnline = isOnline;
        this.pin = pin;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.createdBy = createdBy;
        this.createdDateTime = createdDateTime;
        this.lastModifiedBy = lastModifiedBy;
        this.modifiedDateTime = modifiedDateTime;
        this.isActive = isActive;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public boolean getIsOnline()
    {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline)
    {
        this.isOnline = isOnline;
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

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPin()
    {
        return pin;
    }

    public void setPin(String pin)
    {
        this.pin = pin;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
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

    public String getLastModifiedBy()
    {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy)
    {
        this.lastModifiedBy = lastModifiedBy;
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

    public UserType getUserTypeId()
    {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User))
        {
            return false;
        }
        User other = (User) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.User[ username=" + username + " ]";
    }
}
