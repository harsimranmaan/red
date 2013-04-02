/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

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
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "Registration")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findByStudentId", query = "SELECT r FROM Registration r WHERE r.registrationPK.studentId = :studentId"),
    @NamedQuery(name = "Registration.findByProgramName", query = "SELECT r FROM Registration r WHERE r.registrationPK.programName = :programName"),
    @NamedQuery(name = "Registration.findByDepartmentId", query = "SELECT r FROM Registration r WHERE r.registrationPK.departmentId = :departmentId"),
    @NamedQuery(name = "Registration.findByStartDate", query = "SELECT r FROM Registration r WHERE r.startDate = :startDate"),
    @NamedQuery(name = "Registration.findByGraduationDate", query = "SELECT r FROM Registration r WHERE r.graduationDate = :graduationDate"),
    @NamedQuery(name = "Registration.findByIsActive", query = "SELECT r FROM Registration r WHERE r.isActive = :isActive")
})
public class Registration implements Serializable
{
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

    public Registration()
    {
    }

    public Registration(RegistrationPK registrationPK)
    {
        this.registrationPK = registrationPK;
    }

    public Registration(RegistrationPK registrationPK, Date startDate, Date graduationDate, boolean isActive)
    {
        this.registrationPK = registrationPK;
        this.startDate = startDate;
        this.graduationDate = graduationDate;
        this.isActive = isActive;
    }

    public Registration(int studentId, String programName, String departmentId)
    {
        this.registrationPK = new RegistrationPK(studentId, programName, departmentId);
    }

    public RegistrationPK getRegistrationPK()
    {
        return registrationPK;
    }

    public void setRegistrationPK(RegistrationPK registrationPK)
    {
        this.registrationPK = registrationPK;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getGraduationDate()
    {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate)
    {
        this.graduationDate = graduationDate;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Program getProgram()
    {
        return program;
    }

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
}
