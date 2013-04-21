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
@Table(name = "Course")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByDepartmentAndCourseNumber", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId WHERE c.coursePK.courseNumber = :courseNumber AND c.coursePK.departmentId = :departmentId"),
    @NamedQuery(name = "Course.findByCourseNumber", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId  WHERE c.coursePK.courseNumber = :courseNumber"),
    @NamedQuery(name = "Course.findByDepartmentId", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId  WHERE c.coursePK.departmentId = :departmentId"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId WHERE c.description = :description"),
    @NamedQuery(name = "Course.findByCredits", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId WHERE c.credits = :credits"),
    @NamedQuery(name = "Course.findByPassingRequirement", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId WHERE c.passingRequirement = :passingRequirement"),
    @NamedQuery(name = "Course.findByIsActive", query = "SELECT c FROM Course c LEFT JOIN FETCH c.gradingSchemeId WHERE c.isActive = :isActive")
})
public class Course implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoursePK coursePK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "credits")
    private int credits;
    @Basic(optional = false)
    @Column(name = "passingRequirement")
    private String passingRequirement;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
//    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
    //  private Department department;
    @JoinColumn(name = "gradingSchemeId", referencedColumnName = "gradingSchemeId")
    @ManyToOne(optional = false)
    private GradingScheme gradingSchemeId;

    public Course()
    {
    }

    public Course(CoursePK coursePK)
    {
        this.coursePK = coursePK;
    }

    public Course(CoursePK coursePK, String name, String description, int credits, String passingRequirement, boolean isActive)
    {
        this.coursePK = coursePK;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.passingRequirement = passingRequirement;
        this.isActive = isActive;
    }

    public Course(int courseNumber, String departmentId)
    {
        this.coursePK = new CoursePK(courseNumber, departmentId);
    }

    public CoursePK getCoursePK()
    {
        return coursePK;
    }

    public void setCoursePK(CoursePK coursePK)
    {
        this.coursePK = coursePK;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCredits()
    {
        return credits;
    }

    public void setCredits(int credits)
    {
        this.credits = credits;
    }

    public String getPassingRequirement()
    {
        return passingRequirement;
    }

    public void setPassingRequirement(String passingRequirement)
    {
        this.passingRequirement = passingRequirement;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Department getDepartment()
    {
        return Department.getDepartmentById(this.coursePK.getDepartmentId());
    }

//    public void setDepartment(Department department)
//    {
//        this.department = department;
//    }
    public GradingScheme getGradingSchemeId()
    {
        return gradingSchemeId;
    }

    public void setGradingSchemeId(GradingScheme gradingSchemeId)
    {
        this.gradingSchemeId = gradingSchemeId;
    }

    public String getDepartmentIdAndCourseNumber()
    {
        return this.coursePK.getDepartmentId() + " " + this.coursePK.getCourseNumber();
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (coursePK != null ? coursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course))
        {
            return false;
        }
        Course other = (Course) object;
        if ((this.coursePK == null && other.coursePK != null)
                || (this.coursePK != null
                && !this.coursePK.equals(other.coursePK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Course[ coursePK=" + coursePK + " ]";
    }

    public static List<Course> getByDepartment(Department department)
    {
        return RedEntityManager.getEntityManager()
                .createNamedQuery("Course.findByDepartmentId")
                .setParameter("departmentId", department.getDepartmentId())
                .getResultList();
    }

    public static List<Course> getByDepartmentId(String deptId)
    {
        return RedEntityManager.getEntityManager()
                .createNamedQuery("Course.findByDepartmentId")
                .setParameter("departmentId", deptId)
                .getResultList();
    }

    public static List<Course> getByDepartmentIdAndCourseNumber(String deptId, int courseNumber)
    {
        return RedEntityManager.getEntityManager()
                .createNamedQuery("Course.findByDepartmentAndCourseNumber")
                .setParameter("departmentId", deptId)
                .setParameter("courseNumber", courseNumber)
                .getResultList();
    }

    public static List<Course> getCourseByCourseNumer(int courseNumber)
    {
        return RedEntityManager.getEntityManager()
                .createNamedQuery("Course.findByCourseNumber")
                .setParameter("courseNumber", courseNumber)
                .getResultList();
    }
}
