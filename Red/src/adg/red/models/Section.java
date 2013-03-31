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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Section")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findBySectionId", query = "SELECT s FROM Section s WHERE s.sectionPK.sectionId = :sectionId"),
    @NamedQuery(name = "Section.findByCourseNumber", query = "SELECT s FROM Section s WHERE s.sectionPK.courseNumber = :courseNumber"),
    @NamedQuery(name = "Section.findByDepartmentId", query = "SELECT s FROM Section s WHERE s.sectionPK.departmentId = :departmentId"),
    @NamedQuery(name = "Section.findByStartDate", query = "SELECT s FROM Section s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "Section.findByEndDate", query = "SELECT s FROM Section s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "Section.findByTermId", query = "SELECT s FROM Section s WHERE s.sectionPK.termId = :termId"),
    @NamedQuery(name = "Section.findByTeachingAssistant", query = "SELECT s FROM Section s WHERE s.teachingAssistant = :teachingAssistant"),
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
    @Column(name = "teachingAssistant")
    private String teachingAssistant;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section")
//    private Collection<Enrolment> enrolmentCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section1")
//    private Collection<Enrolment> enrolmentCollection1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section2")
//    private Collection<Enrolment> enrolmentCollection2;
    @JoinColumn(name = "termId", referencedColumnName = "termId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Term term;
    @JoinColumn(name = "sectionTypeId", referencedColumnName = "sectionTypeId")
    @ManyToOne(optional = false)
    private SectionType sectionTypeId;
    @JoinColumn(name = "facultyMemberId", referencedColumnName = "facultyMemberId")
    @ManyToOne(optional = false)
    private FacultyMember facultyMemberId;
    @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section")
//    private Collection<SectionTimeTable> sectionTimeTableCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section1")
//    private Collection<SectionTimeTable> sectionTimeTableCollection1;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section2")
//    private Collection<SectionTimeTable> sectionTimeTableCollection2;

    public Section()
    {
    }

    public Section(SectionPK sectionPK)
    {
        this.sectionPK = sectionPK;
    }

    public Section(SectionPK sectionPK, Date startDate, Date endDate, boolean isActive)
    {
        this.sectionPK = sectionPK;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public Section(int sectionId, int courseNumber, String departmentId, String termId)
    {
        this.sectionPK = new SectionPK(sectionId, courseNumber, departmentId, termId);
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

    public String getTeachingAssistant()
    {
        return teachingAssistant;
    }

    public void setTeachingAssistant(String teachingAssistant)
    {
        this.teachingAssistant = teachingAssistant;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

//    @XmlTransient
//    public Collection<Enrolment> getEnrolmentCollection()
//    {
//        return enrolmentCollection;
//    }
//
//    public void setEnrolmentCollection(Collection<Enrolment> enrolmentCollection)
//    {
//        this.enrolmentCollection = enrolmentCollection;
//    }
//
//    @XmlTransient
//    public Collection<Enrolment> getEnrolmentCollection1()
//    {
//        return enrolmentCollection1;
//    }
//
//    public void setEnrolmentCollection1(Collection<Enrolment> enrolmentCollection1)
//    {
//        this.enrolmentCollection1 = enrolmentCollection1;
//    }
//
//    @XmlTransient
//    public Collection<Enrolment> getEnrolmentCollection2()
//    {
//        return enrolmentCollection2;
//    }
//
//    public void setEnrolmentCollection2(Collection<Enrolment> enrolmentCollection2)
//    {
//        this.enrolmentCollection2 = enrolmentCollection2;
//    }
    public Term getTerm()
    {
        return term;
    }

    public void setTerm(Term term)
    {
        this.term = term;
    }

    public SectionType getSectionTypeId()
    {
        return sectionTypeId;
    }

    public void setSectionTypeId(SectionType sectionTypeId)
    {
        this.sectionTypeId = sectionTypeId;
    }

    public FacultyMember getFacultyMemberId()
    {
        return facultyMemberId;
    }

    public void setFacultyMemberId(FacultyMember facultyMemberId)
    {
        this.facultyMemberId = facultyMemberId;
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

//    @XmlTransient
//    public Collection<SectionTimeTable> getSectionTimeTableCollection()
//    {
//        return sectionTimeTableCollection;
//    }
//
//    public void setSectionTimeTableCollection(Collection<SectionTimeTable> sectionTimeTableCollection)
//    {
//        this.sectionTimeTableCollection = sectionTimeTableCollection;
//    }
//
//    @XmlTransient
//    public Collection<SectionTimeTable> getSectionTimeTableCollection1()
//    {
//        return sectionTimeTableCollection1;
//    }
//
//    public void setSectionTimeTableCollection1(Collection<SectionTimeTable> sectionTimeTableCollection1)
//    {
//        this.sectionTimeTableCollection1 = sectionTimeTableCollection1;
//    }
//
//    @XmlTransient
//    public Collection<SectionTimeTable> getSectionTimeTableCollection2()
//    {
//        return sectionTimeTableCollection2;
//    }
//
//    public void setSectionTimeTableCollection2(Collection<SectionTimeTable> sectionTimeTableCollection2)
//    {
//        this.sectionTimeTableCollection2 = sectionTimeTableCollection2;
//    }
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
