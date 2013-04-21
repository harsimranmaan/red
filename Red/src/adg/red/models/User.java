/*
 *
 *
 */
package adg.red.models;

import adg.red.encryptor.Encryptor;
import adg.red.utils.LocaleManager;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u  LEFT JOIN FETCH u.student LEFT JOIN FETCH u.administrator LEFT JOIN FETCH u.facultyMember LEFT JOIN FETCH u.addressId LEFT JOIN FETCH u.userTypeId "),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u  LEFT JOIN FETCH u.student LEFT JOIN FETCH u.administrator LEFT JOIN FETCH u.facultyMember LEFT JOIN FETCH u.addressId LEFT JOIN FETCH u.userTypeId WHERE u.username = :username"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u LEFT JOIN FETCH u.student LEFT JOIN FETCH u.administrator LEFT JOIN FETCH u.facultyMember LEFT JOIN FETCH u.addressId LEFT JOIN FETCH u.userTypeId  WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u LEFT JOIN FETCH u.student LEFT JOIN FETCH u.administrator LEFT JOIN FETCH u.facultyMember LEFT JOIN FETCH u.addressId LEFT JOIN FETCH u.userTypeId  WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u  LEFT JOIN FETCH u.student LEFT JOIN FETCH u.administrator LEFT JOIN FETCH u.facultyMember LEFT JOIN FETCH u.addressId LEFT JOIN FETCH u.userTypeId WHERE u.email = :email AND u.isActive = 1"),
    @NamedQuery(name = "User.login", query = "SELECT u FROM User u LEFT JOIN FETCH u.student LEFT JOIN FETCH u.administrator LEFT JOIN FETCH u.facultyMember LEFT JOIN FETCH u.addressId LEFT JOIN FETCH u.userTypeId  WHERE u.username = :username AND u.password = :password AND u.isActive=1")
})
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    @NotNull
    @Size(min = 3, max = 15)
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "username")
    private Student student;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "username")
    private FacultyMember facultyMember;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "username")
    private Administrator administrator;

    /**
     * Default constructor
     */
    public User()
    {
    }

    /**
     * Constructor
     * <p/>
     * @param username table attribute username
     */
    public User(String username)
    {
        this.username = username;
    }

    /**
     * Constructor
     * <p/>
     * @param username  table attribute
     * @param password  table attribute
     * @param firstName table attribute
     * @param lastName  table attribute
     * @param isOnline  table attribute
     * @param email     table attribute
     * @param isActive  table attribute
     */
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

    /**
     * Get table attribute username
     * <p/>
     * @return username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Set table attribute username
     * <p/>
     * @param username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Set table attribute password
     * <p/>
     * @param password table attribute
     */
    public void setPassword(String password)
    {
        this.password = Encryptor.encryptSHA(password);
    }

    /**
     * Get table attribute firstName
     * <p/>
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set table attribute firstName
     * <p/>
     * @param firstName table attribute
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Get table attribute lastName
     * <p/>
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set table attribute lastName
     * <p/>
     * @param lastName table attribute
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get table attribute isOnline
     * <p/>
     * @return isOnline
     */
    public boolean getIsOnline()
    {
        return isOnline;
    }

    /**
     * Set table attribute isOnline
     * <p/>
     * @param isOnline table attribute
     */
    public void setIsOnline(boolean isOnline)
    {
        this.isOnline = isOnline;
    }

    /**
     * Get table attribute phoneNumber
     * <p/>
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * Set table attribute phoneNumber
     * <p/>
     * @param phoneNumber table attribute
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get table attribute email
     * <p/>
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Set table attribute email
     * <p/>
     * @param email table attribute
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Get table attribute dateOfBirth
     * <p/>
     * @return dateOfBirth
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Set table attribute dateOfBirth
     * <p/>
     * @param dateOfBirth table attribute
     */
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get table attribute isActive
     * <p/>
     * @return isActive
     */
    public boolean getIsActive()
    {
        return isActive;
    }

    /**
     * Set table attribute isActive
     * <p/>
     * @param isActive table attribute
     */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * Get table attribute addressId
     * <p/>
     * @return addressId
     */
    public Address getAddressId()
    {
        return addressId;
    }

    /**
     * Set table attribute addressId
     * <p/>
     * @param addressId table attribute
     */
    public void setAddressId(Address addressId)
    {
        this.addressId = addressId;
    }

    /**
     * Get table attribute userTypeId
     * <p/>
     * @return userTypeId
     */
    public UserType getUserTypeId()
    {
        return userTypeId;
    }

    /**
     * Set table attribute userTypeId
     * <p/>
     * @param userTypeId table attribute
     */
    public void setUserTypeId(UserType userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    /**
     * Get table attribute student
     * <p/>
     * @return student
     */
    public Student getStudent()
    {
        return student;
    }

    /**
     * Set table attribute student
     * <p/>
     * @param student table attribute
     */
    public void setStudent(Student student)
    {
        this.student = student;
    }

    /**
     * Get record location
     * <p/>
     * @return hash code
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    /**
     * Comparator
     * <p/>
     * @param object object to be compared with
     * <p/>
     * @return true if two object equal to each other, otherwise return false
     */
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

    /**
     * print username
     * <p/>
     * @return username as a string
     */
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
    public static User getUserByUsername(String username) throws Exception
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

    public FacultyMember getFacultyMember()
    {
        return facultyMember;
    }

    public void setFacultyMember(FacultyMember facultyMember)
    {
        this.facultyMember = facultyMember;
    }

    public Administrator getAdministrator()
    {
        return administrator;
    }

    public void setAdministrator(Administrator administrator)
    {
        this.administrator = administrator;
    }

    public static User getUserByEmailId(String emailId) throws Exception
    {
        List<User> userList = RedEntityManager.getEntityManager().createNamedQuery("User.findByEmail").setParameter("email", emailId).getResultList();
        if (userList.size() == 1)
        {
            return userList.get(0);
        }
        else
        {
            throw new Exception("Invalid email Id");
        }
    }
}
