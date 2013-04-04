/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.LocaleManager;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;

import java.util.List;
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
    @NamedQuery(name = "Enrolment.findByTermYear", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.termYear = :termYear"),
    @NamedQuery(name = "Enrolment.findBySessionId", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.sessionId = :sessionId"),
    @NamedQuery(name = "Enrolment.findBySectionTypeId", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK.sectionTypeId = :sectionTypeId"),
    @NamedQuery(name = "Enrolment.findByIsActive", query = "SELECT e FROM Enrolment e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "Enrolment.findByEnrolmentPK", query = "SELECT e FROM Enrolment e WHERE e.enrolmentPK=:enrolmentPK")
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
        @JoinColumn(name = "termYear", referencedColumnName = "termYear", insertable = false, updatable = false),
        @JoinColumn(name = "sessionId", referencedColumnName = "sessionId", insertable = false, updatable = false),
        @JoinColumn(name = "sectionTypeId", referencedColumnName = "sectionTypeId", insertable = false, updatable = false)
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

    public Enrolment(int studentId, int sectionId, int courseNumber, String departmentId, int termYear, int sessionId, int sectionTypeId)
    {
        this.enrolmentPK = new EnrolmentPK(studentId, sectionId, courseNumber, departmentId, termYear, sessionId, sectionTypeId);
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

    public void save()
    {
        RedEntityManager.save(this);
    }

    public static Enrolment getEnrolmentByEnrolmentPK(EnrolmentPK enrolmentPK) throws Exception
    {
        List<Enrolment> enrolList = RedEntityManager.getEntityManager()
                .createNamedQuery("Enrolment.findByEnrolmentPK")
                .setParameter("enrolmentPK", enrolmentPK)
                .getResultList();
        if (enrolList.size() == 1)
        {
            return enrolList.get(0);
        }
        else
        {
            throw new Exception(LocaleManager.get(33));
        }
    }

    public static List<Enrolment> getEnrolmentsByStudentId(int studentId)
    {
        return RedEntityManager.getEntityManager()
                .createNamedQuery("Enrolment.findByStudentId")
                .setParameter("studentId", studentId)
                .getResultList();

    }
}
