/*
 *
 *
 */
package adg.red.models;

import adg.red.utils.DateFormatter;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@NamedQueries(
        {
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s LEFT JOIN FETCH s.course LEFT JOIN FETCH s.sectionType  LEFT JOIN FETCH s.term  LEFT JOIN FETCH s.facultyMemberId "),
    // @NamedQuery(name = "Section.findBySectionId", query = "SELECT s FROM Section s WHERE s.sectionPK.sectionId = :sectionId"),
    @NamedQuery(name = "Section.findBySectionTypeId", query = "SELECT s FROM Section s LEFT JOIN FETCH s.course LEFT JOIN FETCH s.sectionType  LEFT JOIN FETCH s.term  LEFT JOIN FETCH s.facultyMemberId WHERE s.sectionPK.sectionTypeId = :sectionTypeId"),
//    @NamedQuery(name = "Section.findByCourseNumber", query = "SELECT s FROM Section s WHERE s.sectionPK.courseNumber = :courseNumber"),
//    @NamedQuery(name = "Section.findByDepartmentId", query = "SELECT s FROM Section s WHERE s.sectionPK.departmentId = :departmentId"),
//    @NamedQuery(name = "Section.findByTermYear", query = "SELECT s FROM Section s WHERE s.sectionPK.termYear = :termYear"),
//    @NamedQuery(name = "Section.findBySessionId", query = "SELECT s FROM Section s WHERE s.sectionPK.sessionId = :sessionId"),
//    @NamedQuery(name = "Section.findByStartDate", query = "SELECT s FROM Section s WHERE s.startDate = :startDate"),
//    @NamedQuery(name = "Section.findByEndDate", query = "SELECT s FROM Section s WHERE s.endDate = :endDate"),
    //  @NamedQuery(name = "Section.findByTeachingAssistant", query = "SELECT s FROM Section s WHERE s.teachingAssistant = :teachingAssistant"),
    // @NamedQuery(name = "Section.findByIsActive", query = "SELECT s FROM Section s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "Section.findByDepartmentAndCourseNumber", query = "SELECT s FROM Section s LEFT JOIN FETCH s.course LEFT JOIN FETCH s.sectionType  LEFT JOIN FETCH s.term  LEFT JOIN FETCH s.facultyMemberId WHERE s.sectionPK.departmentId = :departmentId AND s.sectionPK.courseNumber = :courseNumber"),
    @NamedQuery(name = "Section.findByFacultyMemberIdAndSectionTypeId100", query = "SELECT s FROM Section s LEFT JOIN FETCH s.course LEFT JOIN FETCH s.sectionType  LEFT JOIN FETCH s.term  LEFT JOIN FETCH s.facultyMemberId  WHERE s.sectionPK.sectionTypeId = 100 AND s.facultyMemberId = :facultyMemberId"),
    @NamedQuery(name = "Section.findByFacultyMemberId", query = "SELECT s FROM Section s LEFT JOIN FETCH s.course LEFT JOIN FETCH s.sectionType  LEFT JOIN FETCH s.term  LEFT JOIN FETCH s.facultyMemberId  WHERE s.facultyMemberId = :facultyMemberId"),
    @NamedQuery(name = "Section.findByDepartmentAndCourseNumberAndTermYearAndNextYear", query = "SELECT s FROM Section s LEFT JOIN FETCH s.course LEFT JOIN FETCH s.sectionType  LEFT JOIN FETCH s.term  LEFT JOIN FETCH s.facultyMemberId  WHERE s.sectionPK.departmentId = :departmentId AND s.sectionPK.courseNumber = :courseNumber AND s.term.termPK.termYear >= :termYear"),
})
public class Section implements Serializable
{

    private static final long serialVersionUID = 1L;
    /**
     *
     */
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
    @JoinColumn(name = "sectionTypeId", referencedColumnName = "sectionTypeId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SectionType sectionType;
    @JoinColumn(name = "facultyMemberId", referencedColumnName = "facultyMemberId")
    @ManyToOne(optional = false)
    private FacultyMember facultyMemberId;
    @JoinColumns(
            {
        @JoinColumn(name = "termYear", referencedColumnName = "termYear", insertable = false, updatable = false),
        @JoinColumn(name = "sessionId", referencedColumnName = "sessionId", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Term term;
    @JoinColumns(
            {
        @JoinColumn(name = "courseNumber", referencedColumnName = "courseNumber", insertable = false, updatable = false),
        @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Course course;
    @Basic(optional = false)
    @Column(name = "registerDeadline")
    @Temporal(TemporalType.DATE)
    private Date registerDeadline;
    @Basic(optional = false)
    @Column(name = "dropDeadline")
    @Temporal(TemporalType.DATE)
    private Date dropDeadline;
    @Basic(optional = false)
    @Column(name = "totalSeats")
    private int totalSeats;

    /**
     *
     */
    public Section()
    {
    }

    /**
     *
     * @param sectionPK
     */
    public Section(SectionPK sectionPK)
    {
        this.sectionPK = sectionPK;
    }

    /**
     *
     * @param sectionPK
     * @param startDate
     * @param endDate
     * @param isActive
     */
    public Section(SectionPK sectionPK, Date startDate, Date endDate, boolean isActive)
    {
        this.sectionPK = sectionPK;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    /**
     *
     * @param sectionId
     * @param sectionTypeId
     * @param courseNumber
     * @param departmentId
     * @param termYear
     * @param sessionId
     */
    public Section(int sectionId, int sectionTypeId, int courseNumber, String departmentId, int termYear, int sessionId)
    {
        this.sectionPK = new SectionPK(sectionId, sectionTypeId, courseNumber, departmentId, termYear, sessionId);
    }

    /**
     *
     * @return
     */
    public SectionPK getSectionPK()
    {
        return sectionPK;
    }

    /**
     *
     * @return
     */
    public int getSectionId()
    {
        return this.sectionPK.getSectionId();
    }

    /**
     *
     * @param sectionPK
     */
    public void setSectionPK(SectionPK sectionPK)
    {
        this.sectionPK = sectionPK;
    }

    /**
     *
     * @return
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /**
     *
     * @return
     */
    public String getFormattedEndDate()
    {
        return DateFormatter.formatDate(this.endDate);
    }

    /**
     *
     * @return
     */
    public String getFormattedStartDate()
    {
        return DateFormatter.formatDate(this.startDate);
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Date getEndDate()
    {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     */
    public String getTeachingAssistant()
    {
        return teachingAssistant;
    }

    /**
     *
     * @param teachingAssistant
     */
    public void setTeachingAssistant(String teachingAssistant)
    {
        this.teachingAssistant = teachingAssistant;
    }

    /**
     *
     * @return
     */
    public boolean getIsActive()
    {
        return isActive;
    }

    /**
     *
     * @param isActive
     */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     *
     * @return
     */
    public String getSectionTypeName()
    {
        return sectionType.getName();
    }

    /**
     *
     * @return
     */
    public SectionType getSectionType()
    {
        return sectionType;
    }

    /**
     *
     * @param sectionType
     */
    public void setSectionType(SectionType sectionType)
    {
        this.sectionType = sectionType;
    }

    /**
     *
     * @return
     */
    public FacultyMember getFacultyMemberId()
    {
        return facultyMemberId;
    }

    /**
     *
     * @param facultyMemberId
     */
    public void setFacultyMemberId(FacultyMember facultyMemberId)
    {
        this.facultyMemberId = facultyMemberId;
    }

    /**
     *
     * @return
     */
    public String getDepartmentIdAndCourseName()
    {
        return this.getSectionPK().getDepartmentId() + " " + this.getSectionPK().getCourseNumber();
    }

    /**
     *
     * @return
     */
    public Term getTerm()
    {
        return term;
    }

    /**
     *
     * @param term
     */
    public void setTerm(Term term)
    {
        this.term = term;
    }

    /**
     *
     * @return
     */
    public Course getCourse()
    {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(Course course)
    {
        this.course = course;
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

    /**
     *
     * @param fac
     * <p/>
     * @return
     */
    public static List<Section> getByFacultyMemberId(FacultyMember fac)
    {
        return RedEntityManager.getEntityManager().createNamedQuery("Section.findByFacultyMemberId").setParameter("facultyMemberId", fac).getResultList();
    }

    /**
     *
     * @param fac
     * <p/>
     * @return
     */
    public static List<Section> getByFacultyMemberIdAndSectionTypeId100(FacultyMember fac)
    {
        return RedEntityManager.getEntityManager().createNamedQuery("Section.findByFacultyMemberIdAndSectionTypeId100").setParameter("facultyMemberId", fac).getResultList();
    }

    /**
     *
     * @param course
     * <p/>
     * @return
     */
    public static List<Section> getByCourse(Course course)
    {

        return RedEntityManager.getEntityManager().createNamedQuery("Section.findByDepartmentAndCourseNumber").setParameter("departmentId", course.getCoursePK().getDepartmentId()).setParameter("courseNumber", course.getCoursePK().getCourseNumber()).getResultList();
    }

    /**
     *
     * @param course
     * <p/>
     * @return
     */
    public static List<Section> getByCourseAndTermYearAndMore(Course course)
    {

        return RedEntityManager.getEntityManager().createNamedQuery("Section.findByDepartmentAndCourseNumberAndTermYearAndNextYear")
                .setParameter("departmentId", course.getCoursePK().getDepartmentId())
                .setParameter("courseNumber", course.getCoursePK().getCourseNumber())
                .setParameter("termYear", Calendar.getInstance().get(Calendar.YEAR))
                .getResultList();
    }

    /**
     * Get faculty member name and last name
     * <p/>
     * @return the full name of faculty
     */
    public String getFacultyMemberName()
    {
        return facultyMemberId.getUsername().getFirstName() + " " + facultyMemberId.getUsername().getLastName();
    }

    /**
     *
     * @return
     */
    public Date getRegisterDeadline()
    {
        return registerDeadline;
    }

    /**
     *
     * @param registerDeadline
     */
    public void setRegisterDeadline(Date registerDeadline)
    {
        this.registerDeadline = registerDeadline;
    }

    /**
     *
     * @return
     */
    public Date getDropDeadline()
    {
        return dropDeadline;
    }

    /**
     *
     * @param dropDeadline
     */
    public void setDropDeadline(Date dropDeadline)
    {
        this.dropDeadline = dropDeadline;
    }

    /**
     *
     * @return
     */
    public int getTotalSeats()
    {
        return totalSeats;
    }

    /**
     *
     * @param totalSeats
     */
    public void setTotalSeats(int totalSeats)
    {
        this.totalSeats = totalSeats;
    }
}
