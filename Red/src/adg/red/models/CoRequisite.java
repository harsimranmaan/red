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
@Table(name = "CoRequisite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoRequisite.findAll", query = "SELECT c FROM CoRequisite c"),
    @NamedQuery(name = "CoRequisite.findByCourseNumber", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.courseNumber = :courseNumber"),
    @NamedQuery(name = "CoRequisite.findByDepartmentId", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.departmentId = :departmentId"),
    @NamedQuery(name = "CoRequisite.findByCoRequisiteNumber", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.coRequisiteNumber = :coRequisiteNumber"),
    @NamedQuery(name = "CoRequisite.findByCoRequisiteDeptId", query = "SELECT c FROM CoRequisite c WHERE c.coRequisitePK.coRequisiteDeptId = :coRequisiteDeptId"),
    @NamedQuery(name = "CoRequisite.findByCreatedBy", query = "SELECT c FROM CoRequisite c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CoRequisite.findByCreatedAt", query = "SELECT c FROM CoRequisite c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CoRequisite.findByModifiedBy", query = "SELECT c FROM CoRequisite c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CoRequisite.findByModifiedAt", query = "SELECT c FROM CoRequisite c WHERE c.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "CoRequisite.findByIsActive", query = "SELECT c FROM CoRequisite c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CoRequisite.findByIsMust", query = "SELECT c FROM CoRequisite c WHERE c.isMust = :isMust")})
public class CoRequisite implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoRequisitePK coRequisitePK;
    @Basic(optional = false)
    @Column(name = "createdBy")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Basic(optional = false)
    @Column(name = "modifiedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "isMust")
    private boolean isMust;
    @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "coRequisiteNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course1;
    @JoinColumn(name = "coRequisiteDeptId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department1;

    public CoRequisite() {
    }

    public CoRequisite(CoRequisitePK coRequisitePK) {
        this.coRequisitePK = coRequisitePK;
    }

    public CoRequisite(CoRequisitePK coRequisitePK, String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, boolean isActive, boolean isMust) {
        this.coRequisitePK = coRequisitePK;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.isActive = isActive;
        this.isMust = isMust;
    }

    public CoRequisite(int courseNumber, String departmentId, int coRequisiteNumber, String coRequisiteDeptId) {
        this.coRequisitePK = new CoRequisitePK(courseNumber, departmentId, coRequisiteNumber, coRequisiteDeptId);
    }

    public CoRequisitePK getCoRequisitePK() {
        return coRequisitePK;
    }

    public void setCoRequisitePK(CoRequisitePK coRequisitePK) {
        this.coRequisitePK = coRequisitePK;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsMust() {
        return isMust;
    }

    public void setIsMust(boolean isMust) {
        this.isMust = isMust;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment1() {
        return department1;
    }

    public void setDepartment1(Department department1) {
        this.department1 = department1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coRequisitePK != null ? coRequisitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoRequisite)) {
            return false;
        }
        CoRequisite other = (CoRequisite) object;
        if ((this.coRequisitePK == null && other.coRequisitePK != null) || (this.coRequisitePK != null && !this.coRequisitePK.equals(other.coRequisitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.CoRequisite[ coRequisitePK=" + coRequisitePK + " ]";
    }
    
}
