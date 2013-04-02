/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "Enrolment")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Enrolment.findAll", query = "SELECT e FROM Enrolment e"),
    @NamedQuery(name = "Enrolment.findByStudentId", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.studentId = :studentId"),
    @NamedQuery(name = "Enrolment.findBySectionId", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.sectionId = :sectionId"),
    @NamedQuery(name = "Enrolment.findByCourseNumber", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.courseNumber = :courseNumber"),
    @NamedQuery(name = "Enrolment.findByDepartmentId", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.departmentId = :departmentId"),
    @NamedQuery(name = "Enrolment.findByTermId", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.termId = :termId"),
    @NamedQuery(name = "Enrolment.findByIsActive", query = "SELECT e FROM Enrolment e WHERE e.isActive = :isActive")
})
public class Enrolment implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnrolmentPK enrolmentPK;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumns(
    {
        @JoinColumn(name = "sectionId", referencedColumnName = "sectionId", insertable = false, updatable = false),
        @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false),
        @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false),
        @JoinColumn(name = "termId", referencedColumnName = "termId", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Section section;
    @JoinColumn(name = "studentId", referencedColumnName = "studentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public Enrolment()
    {
    }

    public Enrolment(EnrolmentPK enrolmentPK)
    {
        this.enrolmentPK = enrolmentPK;
    }

    public Enrolment(EnrolmentPK enrolmentPK, boolean isActive)
    {
        this.enrolmentPK = enrolmentPK;
        this.isActive = isActive;
    }

    public Enrolment(int studentId, int sectionId, int courseNumber, String departmentId, String termId)
    {
        this.enrolmentPK = new EnrolmentPK(studentId, sectionId, courseNumber, departmentId, termId);
    }

    public EnrolmentPK getEnrolmentPK()
    {
        return enrolmentPK;
    }

    public void setEnrolmentPK(EnrolmentPK enrolmentPK)
    {
        this.enrolmentPK = enrolmentPK;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Section getSection()
    {
        return section;
    }

    public void setSection(Section section)
    {
        this.section = section;
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
        hash += (enrolmentPK != null ? enrolmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enrolment))
        {
            return false;
        }
        Enrolment other = (Enrolment) object;
        if ((this.enrolmentPK == null && other.enrolmentPK != null) || (this.enrolmentPK != null && !this.enrolmentPK.equals(other.enrolmentPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Enrolment[ enrolmentPK=" + enrolmentPK + " ]";
    }
}
