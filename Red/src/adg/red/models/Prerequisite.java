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
@Table(name = "Prerequisite")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Prerequisite.findAll", query = "SELECT p FROM Prerequisite p"),
    @NamedQuery(name = "Prerequisite.findByCourseNumber", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.courseNumber = :courseNumber"),
    @NamedQuery(name = "Prerequisite.findByDepartmentId", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.departmentId = :departmentId"),
    @NamedQuery(name = "Prerequisite.findByPreRequisiteNumber", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.preRequisiteNumber = :preRequisiteNumber"),
    @NamedQuery(name = "Prerequisite.findByPreRequisiteDeptId", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.preRequisiteDeptId = :preRequisiteDeptId"),
    @NamedQuery(name = "Prerequisite.findByIsActive", query = "SELECT p FROM Prerequisite p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Prerequisite.findByIsMust", query = "SELECT p FROM Prerequisite p WHERE p.isMust = :isMust")
})
public class Prerequisite implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrerequisitePK prerequisitePK;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "isMust")
    private boolean isMust;
    @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "preRequisiteNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course1;
    @JoinColumn(name = "preRequisiteDeptId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course2;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course3;

    public Prerequisite()
    {
    }

    public Prerequisite(PrerequisitePK prerequisitePK)
    {
        this.prerequisitePK = prerequisitePK;
    }

    public Prerequisite(PrerequisitePK prerequisitePK, boolean isActive, boolean isMust)
    {
        this.prerequisitePK = prerequisitePK;
        this.isActive = isActive;
        this.isMust = isMust;
    }

    public Prerequisite(int courseNumber, String departmentId, int preRequisiteNumber, String preRequisiteDeptId)
    {
        this.prerequisitePK = new PrerequisitePK(courseNumber, departmentId, preRequisiteNumber, preRequisiteDeptId);
    }

    public PrerequisitePK getPrerequisitePK()
    {
        return prerequisitePK;
    }

    public void setPrerequisitePK(PrerequisitePK prerequisitePK)
    {
        this.prerequisitePK = prerequisitePK;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public boolean getIsMust()
    {
        return isMust;
    }

    public void setIsMust(boolean isMust)
    {
        this.isMust = isMust;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public Course getCourse1()
    {
        return course1;
    }

    public void setCourse1(Course course1)
    {
        this.course1 = course1;
    }

    public Course getCourse2()
    {
        return course2;
    }

    public void setCourse2(Course course2)
    {
        this.course2 = course2;
    }

    public Course getCourse3()
    {
        return course3;
    }

    public void setCourse3(Course course3)
    {
        this.course3 = course3;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (prerequisitePK != null ? prerequisitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prerequisite))
        {
            return false;
        }
        Prerequisite other = (Prerequisite) object;
        if ((this.prerequisitePK == null && other.prerequisitePK != null) || (this.prerequisitePK != null && !this.prerequisitePK.equals(other.prerequisitePK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Prerequisite[ prerequisitePK=" + prerequisitePK + " ]";
    }
}
