/*
 *
 *
 */
package adg.red.models;

import adg.red.locale.LocaleManager;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "Student")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId")
})
public class Student implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentId")
    private Integer studentId;
    @Column(name = "dateOfRegistration")
    @Temporal(TemporalType.DATE)
    private Date dateOfRegistration;
    @Column(name = "highestDegree")
    private String highestDegree;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @OneToOne(optional = false)
    private User username;

    /**
     * Default constructor
     */
    public Student()
    {
    }

    /**
     * Constructor
     * <p/>
     * @param studentId table attribute studentId
     */
    public Student(Integer studentId)
    {
        this.studentId = studentId;
    }

    /**
     * Constructor
     * <p/>
     * @param studentId table attribute studentId
     * @param isActive  table attribute isActive
     */
    public Student(Integer studentId, boolean isActive)
    {
        this.studentId = studentId;
        this.isActive = isActive;
    }

    /**
     * Get table attribute studentId
     * <p/>
     * @return studentId
     */
    public Integer getStudentId()
    {
        return studentId;
    }

    /**
     * Set table attribute studentId
     * <p/>
     * @param studentId table attribute studentId
     */
    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }

    /**
     * Get table attribute dataOfRegistration
     * <p/>
     * @return dataOfRegistration
     */
    public Date getDateOfRegistration()
    {
        return dateOfRegistration;
    }

    /**
     * Set table attribute dataOfRegistration
     * <p/>
     * @param dateOfRegistration table attribute
     */
    public void setDateOfRegistration(Date dateOfRegistration)
    {
        this.dateOfRegistration = dateOfRegistration;
    }

    /**
     * Get table attribute highestDegree
     * <p/>
     * @return highestDegree
     */
    public String getHighestDegree()
    {
        return highestDegree;
    }

    /**
     * Set table attribute highestDegree
     * <p/>
     * @param highestDegree table attribute
     */
    public void setHighestDegree(String highestDegree)
    {
        this.highestDegree = highestDegree;
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
     * @param isActive
     */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * Get table attribute username
     * <p/>
     * @return username
     */
    public User getUsername()
    {
        return username;
    }

    /**
     * Set table attribute username
     * <p/>
     * @param username table attribute username
     */
    public void setUsername(User username)
    {
        this.username = username;
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
        hash += (studentId != null ? studentId.hashCode() : 0);
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
        if (!(object instanceof Student))
        {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId)))
        {
            return false;
        }
        return true;
    }

    /**
     * print studentId
     * <p/>
     * @return studentId as a string
     */
    @Override
    public String toString()
    {
        return "adg.red.models.Student[ studentId=" + studentId + " ]";
    }

    /**
     * Save entity
     */
    public void save()
    {
        RedEntityManager.save(this);
    }

    /**
     * Get student list by username
     * <p/>
     * @param username table attribute username
     * <p/>
     * @return student list
     * <p/>
     * @throws Exception
     */
    public static Student getStudentByStudentId(int studentId) throws Exception
    {
        List<Student> studentList = RedEntityManager.getEntityManager().createNamedQuery("Student.findByStudentId").setParameter("studentId", studentId).getResultList();
        if (studentList.size() == 1)
        {
            return studentList.get(0);
        }
        else
        {
            throw new Exception(LocaleManager.get(34));
        }
    }
}
