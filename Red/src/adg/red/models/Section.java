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
@Table(name = "Section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findBySectionId", query = "SELECT s FROM Section s WHERE s.sectionPK.sectionId = :sectionId"),
    @NamedQuery(name = "Section.findByCourseNumber", query = "SELECT s FROM Section s WHERE s.sectionPK.courseNumber = :courseNumber"),
    @NamedQuery(name = "Section.findByDepartmentId", query = "SELECT s FROM Section s WHERE s.sectionPK.departmentId = :departmentId"),
    @NamedQuery(name = "Section.findByStartDate", query = "SELECT s FROM Section s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "Section.findByEndDate", query = "SELECT s FROM Section s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "Section.findByTerm", query = "SELECT s FROM Section s WHERE s.term = :term"),
    @NamedQuery(name = "Section.findByFacultyMemberId", query = "SELECT s FROM Section s WHERE s.facultyMemberId = :facultyMemberId"),
    @NamedQuery(name = "Section.findBySectionTypeId", query = "SELECT s FROM Section s WHERE s.sectionTypeId = :sectionTypeId"),
    @NamedQuery(name = "Section.findByTeachingAssistant", query = "SELECT s FROM Section s WHERE s.teachingAssistant = :teachingAssistant"),
    @NamedQuery(name = "Section.findByCreatedBy", query = "SELECT s FROM Section s WHERE s.createdBy = :createdBy"),
    @NamedQuery(name = "Section.findByCreatedAt", query = "SELECT s FROM Section s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "Section.findByModifiedBy", query = "SELECT s FROM Section s WHERE s.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Section.findByModifiedAt", query = "SELECT s FROM Section s WHERE s.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "Section.findByIsActive", query = "SELECT s FROM Section s WHERE s.isActive = :isActive")})
public class Section implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SectionPK sectionPK;
    @Basic(optional = false)
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "term")
    private String term;
    @Basic(optional = false)
    @Column(name = "facultyMemberId")
    private String facultyMemberId;
    @Basic(optional = false)
    @Column(name = "sectionTypeId")
    private String sectionTypeId;
    @Column(name = "teachingAssistant")
    private String teachingAssistant;
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
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;
    @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;

    public Section() {
    }

    public Section(SectionPK sectionPK) {
        this.sectionPK = sectionPK;
    }

    public Section(SectionPK sectionPK, Date startDate, Date endDate, String term, String facultyMemberId, String sectionTypeId, String createdBy, Date createdAt, String modifiedBy, Date modifiedAt, boolean isActive) {
        this.sectionPK = sectionPK;
        this.startDate = startDate;
        this.endDate = endDate;
        this.term = term;
        this.facultyMemberId = facultyMemberId;
        this.sectionTypeId = sectionTypeId;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
        this.isActive = isActive;
    }

    public Section(int sectionId, int courseNumber, String departmentId) {
        this.sectionPK = new SectionPK(sectionId, courseNumber, departmentId);
    }

    public SectionPK getSectionPK() {
        return sectionPK;
    }

    public void setSectionPK(SectionPK sectionPK) {
        this.sectionPK = sectionPK;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getFacultyMemberId() {
        return facultyMemberId;
    }

    public void setFacultyMemberId(String facultyMemberId) {
        this.facultyMemberId = facultyMemberId;
    }

    public String getSectionTypeId() {
        return sectionTypeId;
    }

    public void setSectionTypeId(String sectionTypeId) {
        this.sectionTypeId = sectionTypeId;
    }

    public String getTeachingAssistant() {
        return teachingAssistant;
    }

    public void setTeachingAssistant(String teachingAssistant) {
        this.teachingAssistant = teachingAssistant;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionPK != null ? sectionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.sectionPK == null && other.sectionPK != null) || (this.sectionPK != null && !this.sectionPK.equals(other.sectionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.Section[ sectionPK=" + sectionPK + " ]";
    }
    
}
