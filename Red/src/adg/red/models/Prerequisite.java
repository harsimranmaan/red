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
@Table(name = "Prerequisite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prerequisite.findAll", query = "SELECT p FROM Prerequisite p"),
    @NamedQuery(name = "Prerequisite.findByCourseNumber", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.courseNumber = :courseNumber"),
    @NamedQuery(name = "Prerequisite.findByDepartmentId", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.departmentId = :departmentId"),
    @NamedQuery(name = "Prerequisite.findByPreRequisiteNumber", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.preRequisiteNumber = :preRequisiteNumber"),
    @NamedQuery(name = "Prerequisite.findByPreRequisiteDeptId", query = "SELECT p FROM Prerequisite p WHERE p.prerequisitePK.preRequisiteDeptId = :preRequisiteDeptId"),
    @NamedQuery(name = "Prerequisite.findByCreatedBy", query = "SELECT p FROM Prerequisite p WHERE p.createdBy = :createdBy"),
    @NamedQuery(name = "Prerequisite.findByCreatedAt", query = "SELECT p FROM Prerequisite p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Prerequisite.findByModifiedBy", query = "SELECT p FROM Prerequisite p WHERE p.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Prerequisite.findByModifiedAt", query = "SELECT p FROM Prerequisite p WHERE p.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "Prerequisite.findByIsActive", query = "SELECT p FROM Prerequisite p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "Prerequisite.findByIsMust", query = "SELECT p FROM Prerequisite p WHERE p.isMust = :isMust")})
public class Prerequisite implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrerequisitePK prerequisitePK;
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
    @JoinColumn(name = "preRequisiteNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course1;
    @JoinColumn(name = "preRequisiteDeptId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department1;

    public Prerequisite() {
    }

    public Prerequisite(PrerequisitePK prerequisitePK) {
        this.prerequisitePK = prerequisitePK;
    }

    public Prerequisite(PrerequisitePK prerequisitePK, String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, boolean isActive, boolean isMust) {
        this.prerequisitePK = prerequisitePK;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.isActive = isActive;
        this.isMust = isMust;
    }

    public Prerequisite(int courseNumber, String departmentId, int preRequisiteNumber, String preRequisiteDeptId) {
        this.prerequisitePK = new PrerequisitePK(courseNumber, departmentId, preRequisiteNumber, preRequisiteDeptId);
    }

    public PrerequisitePK getPrerequisitePK() {
        return prerequisitePK;
    }

    public void setPrerequisitePK(PrerequisitePK prerequisitePK) {
        this.prerequisitePK = prerequisitePK;
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
        hash += (prerequisitePK != null ? prerequisitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prerequisite)) {
            return false;
        }
        Prerequisite other = (Prerequisite) object;
        if ((this.prerequisitePK == null && other.prerequisitePK != null) || (this.prerequisitePK != null && !this.prerequisitePK.equals(other.prerequisitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.Prerequisite[ prerequisitePK=" + prerequisitePK + " ]";
    }
    
}
