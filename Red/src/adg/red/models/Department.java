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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Department")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentId", query = "SELECT d FROM Department d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByIsActive", query = "SELECT d FROM Department d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "Department.findByDepartmentIdBeginsWith", query = "SELECT d FROM Department d WHERE d.departmentId LIKE  :keyWord")
})
public class Department implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
//    @JoinColumn(name = "facultyId", referencedColumnName = "facultyId")
//    @ManyToOne(optional = false)
//    private Faculty facultyId;
    @Basic(optional = false)
    @Column(name = "facultyId")
    private Integer facultyId;

    public Department()
    {
    }

    public Department(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public Department(String departmentId, String name, boolean isActive)
    {
        this.departmentId = departmentId;
        this.name = name;
        this.isActive = isActive;
    }

    public String getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Faculty getFacultyId()
    {
        return Faculty.getByFacultyId(this.facultyId);
    }

    public void setFacultyId(Faculty facultyId)
    {
        this.facultyId = facultyId.getFacultyId();
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department))
        {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Department[ departmentId=" + departmentId + " ]";
    }

    public static List<Department> getByDepartmnetIdBeginsWith(String beginsWith)
    {
        return RedEntityManager.getEntityManager().createNamedQuery("Department.findByDepartmentIdBeginsWith").setParameter("keyWord", beginsWith + "%").getResultList();
    }

    public static List<Department> getAll()
    {
        return RedEntityManager.getEntityManager().createNamedQuery("Department.findAll").getResultList();
    }

    public static Department getDepartmentById(String departmentId)
    {
        return (Department) RedEntityManager.getEntityManager().createNamedQuery("Department.findByDepartmentId").setParameter("departmentId", departmentId).getSingleResult();
    }
}
