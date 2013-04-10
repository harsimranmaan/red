/*
 *
 *
 */
package adg.red.models;

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
@Table(name = "CoRequisite")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "CoRequisite.findAll", query = "SELECT c FROM CoRequisite c"),
    @NamedQuery(name = "CoRequisite.findByCourseNumber", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.courseNumber = :courseNumber"),
    @NamedQuery(name = "CoRequisite.findByDepartmentId", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.departmentId = :departmentId"),
    @NamedQuery(name = "CoRequisite.findByCoRequisiteNumber", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.coRequisiteNumber = :coRequisiteNumber"),
    @NamedQuery(name = "CoRequisite.findByCoRequisiteDeptId", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.coRequisiteDeptId = :coRequisiteDeptId"),
    @NamedQuery(name = "CoRequisite.findByIsActive", query = "SELECT c FROM CoRequisite c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CoRequisite.findByIsMust", query = "SELECT c FROM CoRequisite c WHERE c.isMust = :isMust"),
    @NamedQuery(name = "CoRequisite.findByCourseNumberAndDepartmentId", query = "SELECT c FROM CoRequisite c LEFT JOIN FETCH c.course LEFT JOIN FETCH c.course1 WHERE c.coRequisitePK.courseNumber = :courseNumber AND c.coRequisitePK.departmentId = :departmentId")
})
public class CoRequisite implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoRequisitePK coRequisitePK;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "isMust")
    private boolean isMust;
    @JoinColumns(
            {
        @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false),
        @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumns(
            {
        @JoinColumn(name = "coRequisiteDeptId", referencedColumnName = "departmentId", insertable = false, updatable = false),
        @JoinColumn(name = "coRequisiteNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Course course1;

    public CoRequisite()
    {
    }

    public CoRequisite(CoRequisitePK coRequisitePK)
    {
        this.coRequisitePK = coRequisitePK;
    }

    public CoRequisite(CoRequisitePK coRequisitePK, boolean isActive, boolean isMust)
    {
        this.coRequisitePK = coRequisitePK;
        this.isActive = isActive;
        this.isMust = isMust;
    }

    public CoRequisite(int courseNumber, String departmentId, int coRequisiteNumber, String coRequisiteDeptId)
    {
        this.coRequisitePK = new CoRequisitePK(courseNumber, departmentId, coRequisiteNumber, coRequisiteDeptId);
    }

    public CoRequisitePK getCoRequisitePK()
    {
        return coRequisitePK;
    }

    public void setCoRequisitePK(CoRequisitePK coRequisitePK)
    {
        this.coRequisitePK = coRequisitePK;
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

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (coRequisitePK != null ? coRequisitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoRequisite))
        {
            return false;
        }
        CoRequisite other = (CoRequisite) object;
        if ((this.coRequisitePK == null && other.coRequisitePK != null) || (this.coRequisitePK != null && !this.coRequisitePK.equals(other.coRequisitePK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.CoRequisite[ coRequisitePK=" + coRequisitePK + " ]";
    }

    public static List<CoRequisite> getByCourse(Course course)
    {
        return RedEntityManager.getEntityManager().createNamedQuery("CoRequisite.findByCourseNumberAndDepartmentId").setParameter("departmentId", course.getCoursePK().getDepartmentId()).setParameter("courseNumber", course.getCoursePK().getCourseNumber()).getResultList();
    }
}
