/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "Student")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Student.findByDateOfRegistration", query = "SELECT s FROM Student s WHERE s.dateOfRegistration = :dateOfRegistration"),
    @NamedQuery(name = "Student.findByHighestDegree", query = "SELECT s FROM Student s WHERE s.highestDegree = :highestDegree"),
    @NamedQuery(name = "Student.findByIsActive", query = "SELECT s FROM Student s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "Student.findByUsername", query = "SELECT s FROM Student s WHERE s.username = :username")
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Registration> registrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Enrolment> enrolmentCollection;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @OneToOne(optional = false)
    private User username;

    public Student()
    {
    }

    public Student(Integer studentId)
    {
        this.studentId = studentId;
    }

    public Student(Integer studentId, boolean isActive)
    {
        this.studentId = studentId;
        this.isActive = isActive;
    }

    public Integer getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }

    public Date getDateOfRegistration()
    {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration)
    {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getHighestDegree()
    {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree)
    {
        this.highestDegree = highestDegree;
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
    public Collection<Registration> getRegistrationCollection()
    {
        return registrationCollection;
    }

    public void setRegistrationCollection(Collection<Registration> registrationCollection)
    {
        this.registrationCollection = registrationCollection;
    }

    @XmlTransient
    public Collection<Enrolment> getEnrolmentCollection()
    {
        return enrolmentCollection;
    }

    public void setEnrolmentCollection(Collection<Enrolment> enrolmentCollection)
    {
        this.enrolmentCollection = enrolmentCollection;
    }

    public User getUsername()
    {
        return username;
    }

    public void setUsername(User username)
    {
        this.username = username;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString()
    {
        return "adg.red.models.Student[ studentId=" + studentId + " ]";
    }
    
    public static Student getStudentByUsername(User username) throws Exception
    {
        List<Student> studentList = RedEntityManager.getEntityManager().createNamedQuery("Student.findByUsername").setParameter("username", username).getResultList();
        if (studentList.size() == 1)
        {
            return studentList.get(0);
        }
        else
        {
            throw new Exception(LocaleManager.get(5));
        }
    }
}
