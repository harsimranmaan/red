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
@Table(name = "Administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAdminId", query = "SELECT a FROM Administrator a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "Administrator.findByDateOfJoining", query = "SELECT a FROM Administrator a WHERE a.dateOfJoining = :dateOfJoining"),
    @NamedQuery(name = "Administrator.findByCreatedBy", query = "SELECT a FROM Administrator a WHERE a.createdBy = :createdBy"),
    @NamedQuery(name = "Administrator.findByCreatedAt", query = "SELECT a FROM Administrator a WHERE a.createdAt = :createdAt"),
    @NamedQuery(name = "Administrator.findByModifiedBy", query = "SELECT a FROM Administrator a WHERE a.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Administrator.findByModifiedAt", query = "SELECT a FROM Administrator a WHERE a.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "Administrator.findByIsActive", query = "SELECT a FROM Administrator a WHERE a.isActive = :isActive")})
public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "adminId")
    private Integer adminId;
    @Basic(optional = false)
    @Column(name = "dateOfJoining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;
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
    @JoinColumn(name = "hiringFacultyId", referencedColumnName = "facultyId")
    @ManyToOne(optional = false)
    private Faculty hiringFacultyId;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;

    public Administrator() {
    }

    public Administrator(Integer adminId) {
        this.adminId = adminId;
    }

    public Administrator(Integer adminId, Date dateOfJoining, String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, boolean isActive) {
        this.adminId = adminId;
        this.dateOfJoining = dateOfJoining;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.isActive = isActive;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
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

    public Faculty getHiringFacultyId() {
        return hiringFacultyId;
    }

    public void setHiringFacultyId(Faculty hiringFacultyId) {
        this.hiringFacultyId = hiringFacultyId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.Administrator[ adminId=" + adminId + " ]";
    }
    
}
