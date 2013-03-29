/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "Department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentId", query = "SELECT d FROM Department d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByDirectorId", query = "SELECT d FROM Department d WHERE d.directorId = :directorId"),
    @NamedQuery(name = "Department.findByPhone", query = "SELECT d FROM Department d WHERE d.phone = :phone"),
    @NamedQuery(name = "Department.findByEmail", query = "SELECT d FROM Department d WHERE d.email = :email"),
    @NamedQuery(name = "Department.findByWebsite", query = "SELECT d FROM Department d WHERE d.website = :website"),
    @NamedQuery(name = "Department.findByCreatedBy", query = "SELECT d FROM Department d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "Department.findByCreatedAt", query = "SELECT d FROM Department d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "Department.findByModifiedBy", query = "SELECT d FROM Department d WHERE d.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Department.findByModifiedAt", query = "SELECT d FROM Department d WHERE d.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "Department.findByIsActive", query = "SELECT d FROM Department d WHERE d.isActive = :isActive"),
 @NamedQuery(name = "Department.findSearchLike", query = "SELECT d FROM Department d WHERE d.name LIKE  :keyWord")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "directorId")
    private int directorId;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<CoRequisite> coRequisiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department1")
    private Collection<CoRequisite> coRequisiteCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<Section> sectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentId")
    private Collection<FacultyMember> facultyMemberCollection;
    @JoinColumn(name = "facultyId", referencedColumnName = "facultyId")
    @ManyToOne(optional = false)
    private Faculty facultyId;
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @ManyToOne
    private Address addressId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<Prerequisite> prerequisiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department1")
    private Collection<Prerequisite> prerequisiteCollection1;

    public Department() {
    }

    public Department(String departmentId) {
        this.departmentId = departmentId;
    }

    public Department(String departmentId, String name, int directorId, String phone, String email, String website, String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, boolean isActive) {
        this.departmentId = departmentId;
        this.name = name;
        this.directorId = directorId;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.isActive = isActive;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    @XmlTransient
    public Collection<CoRequisite> getCoRequisiteCollection() {
        return coRequisiteCollection;
    }

    public void setCoRequisiteCollection(Collection<CoRequisite> coRequisiteCollection) {
        this.coRequisiteCollection = coRequisiteCollection;
    }

    @XmlTransient
    public Collection<CoRequisite> getCoRequisiteCollection1() {
        return coRequisiteCollection1;
    }

    public void setCoRequisiteCollection1(Collection<CoRequisite> coRequisiteCollection1) {
        this.coRequisiteCollection1 = coRequisiteCollection1;
    }

    @XmlTransient
    public Collection<Section> getSectionCollection() {
        return sectionCollection;
    }

    public void setSectionCollection(Collection<Section> sectionCollection) {
        this.sectionCollection = sectionCollection;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<FacultyMember> getFacultyMemberCollection() {
        return facultyMemberCollection;
    }

    public void setFacultyMemberCollection(Collection<FacultyMember> facultyMemberCollection) {
        this.facultyMemberCollection = facultyMemberCollection;
    }

    public Faculty getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Faculty facultyId) {
        this.facultyId = facultyId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @XmlTransient
    public Collection<Prerequisite> getPrerequisiteCollection() {
        return prerequisiteCollection;
    }

    public void setPrerequisiteCollection(Collection<Prerequisite> prerequisiteCollection) {
        this.prerequisiteCollection = prerequisiteCollection;
    }

    @XmlTransient
    public Collection<Prerequisite> getPrerequisiteCollection1() {
        return prerequisiteCollection1;
    }

    public void setPrerequisiteCollection1(Collection<Prerequisite> prerequisiteCollection1) {
        this.prerequisiteCollection1 = prerequisiteCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.Department[ departmentId=" + departmentId + " ]";
    }
    
}
