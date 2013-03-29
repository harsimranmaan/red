/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "FacultyMember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacultyMember.findAll", query = "SELECT f FROM FacultyMember f"),
    @NamedQuery(name = "FacultyMember.findByFacultyMemberId", query = "SELECT f FROM FacultyMember f WHERE f.facultyMemberId = :facultyMemberId"),
    @NamedQuery(name = "FacultyMember.findByTitle", query = "SELECT f FROM FacultyMember f WHERE f.title = :title"),
    @NamedQuery(name = "FacultyMember.findByDateOfJoining", query = "SELECT f FROM FacultyMember f WHERE f.dateOfJoining = :dateOfJoining"),
    @NamedQuery(name = "FacultyMember.findByHighestDegree", query = "SELECT f FROM FacultyMember f WHERE f.highestDegree = :highestDegree"),
    @NamedQuery(name = "FacultyMember.findByCreatedBy", query = "SELECT f FROM FacultyMember f WHERE f.createdBy = :createdBy"),
    @NamedQuery(name = "FacultyMember.findByCreatedAt", query = "SELECT f FROM FacultyMember f WHERE f.createdAt = :createdAt"),
    @NamedQuery(name = "FacultyMember.findByModifiedBy", query = "SELECT f FROM FacultyMember f WHERE f.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "FacultyMember.findByModifiedAt", query = "SELECT f FROM FacultyMember f WHERE f.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "FacultyMember.findByIsActive", query = "SELECT f FROM FacultyMember f WHERE f.isActive = :isActive")})
public class FacultyMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "facultyMemberId")
    private String facultyMemberId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "dateOfJoining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;
    @Column(name = "highestDegree")
    private String highestDegree;
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
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    @ManyToOne(optional = false)
    private Department departmentId;

    public FacultyMember() {
    }

    public FacultyMember(String facultyMemberId) {
        this.facultyMemberId = facultyMemberId;
    }

    public FacultyMember(String facultyMemberId, String title, Date dateOfJoining, String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, boolean isActive) {
        this.facultyMemberId = facultyMemberId;
        this.title = title;
        this.dateOfJoining = dateOfJoining;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.isActive = isActive;
    }

    public String getFacultyMemberId() {
        return facultyMemberId;
    }

    public void setFacultyMemberId(String facultyMemberId) {
        this.facultyMemberId = facultyMemberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
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

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyMemberId != null ? facultyMemberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacultyMember)) {
            return false;
        }
        FacultyMember other = (FacultyMember) object;
        if ((this.facultyMemberId == null && other.facultyMemberId != null) || (this.facultyMemberId != null && !this.facultyMemberId.equals(other.facultyMemberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.FacultyMember[ facultyMemberId=" + facultyMemberId + " ]";
    }
    
}
