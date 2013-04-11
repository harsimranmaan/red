 //*****************************************************
 /* (INCOMPLETE)
 Registration.java -- Model for Registration table

 @Contributors:  Harsimran

 @Purpose:   Generates various quesries on Registration table
 *
 @Copyright ADG (2013) - Open License
 */
//*****************************************************
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Creating queries to be used in methods followed
 */
@Entity
@Table(name = "Registration")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findByStudentId", query = "SELECT r FROM Registration r WHERE r.registrationPK.studentId = :studentId AND r.isActive = 1"),
    @NamedQuery(name = "Registration.findByProgramName", query = "SELECT r FROM Registration r WHERE r.registrationPK.programName = :programName"),
    @NamedQuery(name = "Registration.findByDepartmentId", query = "SELECT r FROM Registration r WHERE r.registrationPK.departmentId = :departmentId"),
    @NamedQuery(name = "Registration.findByStartDate", query = "SELECT r FROM Registration r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "Registration.findByGraduationDate", query = "SELECT r FROM Registration r WHERE r.graduationDate = :graduationDate"),
    @NamedQuery(name = "Registration.findByIsActive", query = "SELECT r FROM Registration r WHERE r.isActive = :isActive")
})
public class Registration implements Serializable
{
// registrationPK, startDate, graduationDate, program and isActive are
// attributes of Registration table - studentId is a join attribute from
// the Student table, programName and departmentId are join attributes from
// Department table

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistrationPK registrationPK;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "graduationDate")
    @Temporal(TemporalType.DATE)
    private Date graduationDate;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "studentId", referencedColumnName = "studentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumns(
            {
        @JoinColumn(name = "programName", referencedColumnName = "programName", insertable = false, updatable = false),
        @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Program program;

    /**
     * Public default constructor
     */
    public Registration()
    {
    }

    /**
     * Public constructor method using RegistrationPK (which includes studentId,
     * programName and departmentId) and creates an instance of object
     * Registration
     * <p/>
     * @param registrationPK -- Object type RegistrationPK
     */
    public Registration(RegistrationPK registrationPK)
    {
        this.registrationPK = registrationPK;
    }

    /**
     * Public constructor method using registrationPK, startDate, graduationDate
     * and isActive attributes, returns an instance of Object Registration
     * <p/>
     * @param registrationPK -- Object type RegistrationPK
     * @param startDate      -- Date type object containing startDate attribute
     * @param graduationDate -- Date type object containing graduationtDate
     *                       attribute
     * @param isActive       -- Boolean containing isActive attribute
     */
    public Registration(RegistrationPK registrationPK, Date startDate, Date graduationDate, boolean isActive)
    {
        this.registrationPK = registrationPK;
        this.startDate = startDate;
        this.graduationDate = graduationDate;
        this.isActive = isActive;
    }

    /**
     * Public constructor method using studentId, programName and departmentId
     * attributes that returns an instance of object type Registration
     * <p/>
     * @param studentId    -- Integer containing studentId attribute
     * @param programName  -- String containing programName attribute
     * @param departmentId -- String containing programId attribute
     */
    public Registration(int studentId, String programName, String departmentId)
    {
        this.registrationPK = new RegistrationPK(studentId, programName, departmentId);
    }

    /**
     * Public getter method that returns an object type RegistrationPK of the
     * current Registration object
     * <p/>
     * @return -- Object type RegistrationPK
     */
    public RegistrationPK getRegistrationPK()
    {
        return registrationPK;
    }

    /**
     * Public setter method that sets the RegistrationPK set of attributes
     * inside an object of type Registration
     * <p/>
     * @param registrationPK -- Object type RegistrationPK
     */
    public void setRegistrationPK(RegistrationPK registrationPK)
    {
        this.registrationPK = registrationPK;
    }

    /**
     * Public getter method that returns the startDate attribute of a
     * Registration object
     * <p/>
     * @return -- Date type object containing startDate attribute
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /**
     * Public setter method that sets the startDate attribute of a Registration
     * object
     * <p/>
     * @param startDate -- Date type object containing the startDate attribute
     */
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    /**
     * Public getter method that returns the graduationDate attribute of a
     * Registration object
     * <p/>
     * @return -- Date type object containing the graduationDate attribute
     */
    public Date getGraduationDate()
    {
        return graduationDate;
    }

    /**
     * Public setter method that sets the graduationDate attribute of a
     * Resgistration object
     * <p/>
     * @param graduationDate -- Date type object containing graduationDate
     *                       attribute
     */
    public void setGraduationDate(Date graduationDate)
    {
        this.graduationDate = graduationDate;
    }

    /**
     * Public method that gets the active/inactive value of a Registration
     * <p/>
     * @return -- A boolean indicating Registration is active = "true" /
     *         inactive = "false"
     */
    public boolean getIsActive()
    {
        return isActive;
    }

    /**
     * Public method that sets the active/inactive value of a Registration
     * <p/>
     * @param isActive -- A boolean indicating Registration course is active =
     *                 "true" / inactive = "false"
     */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     *
     * <p/>
     * @return
     */
    public Student getStudent()
    {
        return student;
    }

    /**
     *
     * @param student
     */
    public void setStudent(Student student)
    {
        this.student = student;
    }

    /**
     *
     * @return
     */
    public Program getProgram()
    {
        return program;
    }

    /**
     *
     * @param program
     */
    public void setProgram(Program program)
    {
        this.program = program;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (registrationPK != null ? registrationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration))
        {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.registrationPK == null && other.registrationPK != null) || (this.registrationPK != null && !this.registrationPK.equals(other.registrationPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Registration[ registrationPK=" + registrationPK + " ]";
    }

    /**
     *
     * @param student <p/>
     * @return
     */
    public static Registration getCurrentRegistration(Student student)
    {
        return (Registration) RedEntityManager.getEntityManager().createNamedQuery("Registration.findByStudentId")
                .setParameter("studentId", student.getStudentId())
                .getSingleResult();
    }
}
