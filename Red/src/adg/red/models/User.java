/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.Encryptor;
import adg.red.utils.LocaleManager;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByIsOnline", query = "SELECT u FROM User u WHERE u.isOnline = :isOnline"),
    @NamedQuery(name = "User.findByPhoneNumber", query = "SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "User.findByIsActive", query = "SELECT u FROM User u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "User.login", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password AND u.isActive=1")
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
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @ManyToOne
    private Address addressId;
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    @ManyToOne(optional = false)
    private UserType userTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<FacultyMember> facultyMemberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderId")
    private Collection<Message> messageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Administrator> administratorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<MessageReceiver> messageReceiverCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "username")
    private Student student;

    public User()
    {
    }

    public User(String username)
    {
        this.username = username;
    }

    public User(String username, String password, String firstName, String lastName, boolean isOnline, String email, boolean isActive)
    {
        this.username = username;
        this.password = Encryptor.encryptSHA(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.isOnline = isOnline;
        this.email = email;
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

    public void setPassword(String password)
    {
        this.password = Encryptor.encryptSHA(password);
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

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Address getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Address addressId)
    {
        this.addressId = addressId;
    }

    public UserType getUserTypeId()
    {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    @XmlTransient
    public Collection<FacultyMember> getFacultyMemberCollection()
    {
        return facultyMemberCollection;
    }

    public void setFacultyMemberCollection(Collection<FacultyMember> facultyMemberCollection)
    {
        this.facultyMemberCollection = facultyMemberCollection;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection()
    {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection)
    {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<Administrator> getAdministratorCollection()
    {
        return administratorCollection;
    }

    public void setAdministratorCollection(Collection<Administrator> administratorCollection)
    {
        this.administratorCollection = administratorCollection;
    }

    @XmlTransient
    public Collection<MessageReceiver> getMessageReceiverCollection()
    {
        return messageReceiverCollection;
    }

    public void setMessageReceiverCollection(Collection<MessageReceiver> messageReceiverCollection)
    {
        this.messageReceiverCollection = messageReceiverCollection;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
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

    /**
     * Logs-in a user
     * <p/>
     * @param username
     * @param password <p/>
     * @return <p/>
     * @throws Exception if authentication fails
     */
    public static User login(String username, String password) throws Exception
    {
        password = Encryptor.encryptSHA(password);
        List<User> userList = RedEntityManager.getEntityManager().createNamedQuery("User.login").setParameter("username", username).setParameter("password", password).getResultList();
        if (userList.size() == 1)
        {
            return userList.get(0);
        }
        else
        {
            throw new Exception(LocaleManager.get(5));
        }
    }

    public void save()
    {
        RedEntityManager.save(this);
    }

    // get user profile query added by Jingbo Yu
    public static User getUserProfileByName(String username) throws Exception
    {
        List<User> userList = RedEntityManager.getEntityManager().createNamedQuery("User.findByUsername").setParameter("username", username).getResultList();
        if (userList.size() == 1)
        {
            return userList.get(0);
        }
        else
        {
            throw new Exception(LocaleManager.get(5));
        }
    }
}
