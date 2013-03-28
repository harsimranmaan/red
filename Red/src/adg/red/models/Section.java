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
 * @author hsmaan
 */
@Entity
@Table(name = "section")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findByNumber", query = "SELECT s FROM Section s WHERE s.sectionPK.number = :number"),
    @NamedQuery(name = "Section.findByCourse", query = "SELECT s FROM Section s WHERE s.sectionPK.course = :course"),
    @NamedQuery(name = "Section.findByDepartment", query = "SELECT s FROM Section s WHERE s.sectionPK.department = :department"),
    @NamedQuery(name = "Section.findByStartDate", query = "SELECT s FROM Section s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "Section.findByEndDate", query = "SELECT s FROM Section s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "Section.findByTerm", query = "SELECT s FROM Section s WHERE s.term = :term"),
    @NamedQuery(name = "Section.findByTeacher", query = "SELECT s FROM Section s WHERE s.teacher = :teacher"),
    @NamedQuery(name = "Section.findByType", query = "SELECT s FROM Section s WHERE s.type = :type"),
    @NamedQuery(name = "Section.findByTeachingAssistant", query = "SELECT s FROM Section s WHERE s.teachingAssistant = :teachingAssistant"),
    @NamedQuery(name = "Section.findByCreatedBy", query = "SELECT s FROM Section s WHERE s.createdBy = :createdBy"),
    @NamedQuery(name = "Section.findByCreatedDateTime", query = "SELECT s FROM Section s WHERE s.createdDateTime = :createdDateTime"),
    @NamedQuery(name = "Section.findByModifiedBy", query = "SELECT s FROM Section s WHERE s.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Section.findByModifiedDateTime", query = "SELECT s FROM Section s WHERE s.modifiedDateTime = :modifiedDateTime"),
    @NamedQuery(name = "Section.findByIsActive", query = "SELECT s FROM Section s WHERE s.isActive = :isActive")
})
public class Section implements Serializable
{
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
    @Column(name = "teacher")
    private String teacher;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "teachingAssistant")
    private String teachingAssistant;
    @Basic(optional = false)
    @Column(name = "createdBy")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "createdDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Basic(optional = false)
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Basic(optional = false)
    @Column(name = "modifiedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDateTime;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "department", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department1;

    public Section()
    {
    }

    public Section(SectionPK sectionPK)
    {
        this.sectionPK = sectionPK;
    }

    public Section(SectionPK sectionPK, Date startDate, Date endDate, String term, String teacher, String type, String createdBy, Date createdDateTime, String modifiedBy, Date modifiedDateTime, boolean isActive)
    {
        this.sectionPK = sectionPK;
        this.startDate = startDate;
        this.endDate = endDate;
        this.term = term;
        this.teacher = teacher;
        this.type = type;
        this.createdBy = createdBy;
        this.createdDateTime = createdDateTime;
        this.modifiedBy = modifiedBy;
        this.modifiedDateTime = modifiedDateTime;
        this.isActive = isActive;
    }

    public Section(int number, int course, String department)
    {
        this.sectionPK = new SectionPK(number, course, department);
    }

    public SectionPK getSectionPK()
    {
        return sectionPK;
    }

    public void setSectionPK(SectionPK sectionPK)
    {
        this.sectionPK = sectionPK;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public String getTerm()
    {
        return term;
    }

    public void setTerm(String term)
    {
        this.term = term;
    }

    public String getTeacher()
    {
        return teacher;
    }

    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTeachingAssistant()
    {
        return teachingAssistant;
    }

    public void setTeachingAssistant(String teachingAssistant)
    {
        this.teachingAssistant = teachingAssistant;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public Date getCreatedDateTime()
    {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime)
    {
        this.createdDateTime = createdDateTime;
    }

    public String getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDateTime()
    {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime)
    {
        this.modifiedDateTime = modifiedDateTime;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Department getDepartment1()
    {
        return department1;
    }

    public void setDepartment1(Department department1)
    {
        this.department1 = department1;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (sectionPK != null ? sectionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section))
        {
            return false;
        }
        Section other = (Section) object;
        if ((this.sectionPK == null && other.sectionPK != null) || (this.sectionPK != null && !this.sectionPK.equals(other.sectionPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Section[ sectionPK=" + sectionPK + " ]";
    }
}
