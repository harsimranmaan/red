/*
 *
 *
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author harsimran.maan
 */
@Embeddable
public class ProgramCourseListPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "programName")
    private String programName;
    @Basic(optional = false)
    @Column(name = "programDepartmentId")
    private String programDepartmentId;
    @Basic(optional = false)
    @Column(name = "courseNumber")
    private int courseNumber;
    @Basic(optional = false)
    @Column(name = "courseDepartmentId")
    private String courseDepartmentId;

    /**
     *
     */
    public ProgramCourseListPK()
    {
    }

    /**
     *
     * @param programName
     * @param programDepartmentId
     * @param courseNumber
     * @param courseDepartmentId
     */
    public ProgramCourseListPK(String programName, String programDepartmentId, int courseNumber, String courseDepartmentId)
    {
        this.programName = programName;
        this.programDepartmentId = programDepartmentId;
        this.courseNumber = courseNumber;
        this.courseDepartmentId = courseDepartmentId;
    }

    /**
     *
     * @return
     */
    public String getProgramName()
    {
        return programName;
    }

    /**
     *
     * @param programName
     */
    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    /**
     *
     * @return
     */
    public String getProgramDepartmentId()
    {
        return programDepartmentId;
    }

    /**
     *
     * @param programDepartmentId
     */
    public void setProgramDepartmentId(String programDepartmentId)
    {
        this.programDepartmentId = programDepartmentId;
    }

    /**
     *
     * @return
     */
    public int getCourseNumber()
    {
        return courseNumber;
    }

    /**
     *
     * @param courseNumber
     */
    public void setCourseNumber(int courseNumber)
    {
        this.courseNumber = courseNumber;
    }

    /**
     *
     * @return
     */
    public String getCourseDepartmentId()
    {
        return courseDepartmentId;
    }

    /**
     *
     * @param courseDepartmentId
     */
    public void setCourseDepartmentId(String courseDepartmentId)
    {
        this.courseDepartmentId = courseDepartmentId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (programName != null ? programName.hashCode() : 0);
        hash += (programDepartmentId != null ? programDepartmentId.hashCode() : 0);
        hash += (int) courseNumber;
        hash += (courseDepartmentId != null ? courseDepartmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramCourseListPK))
        {
            return false;
        }
        ProgramCourseListPK other = (ProgramCourseListPK) object;
        if ((this.programName == null && other.programName != null) || (this.programName != null && !this.programName.equals(other.programName)))
        {
            return false;
        }
        if ((this.programDepartmentId == null && other.programDepartmentId != null) || (this.programDepartmentId != null && !this.programDepartmentId.equals(other.programDepartmentId)))
        {
            return false;
        }
        if (this.courseNumber != other.courseNumber)
        {
            return false;
        }
        if ((this.courseDepartmentId == null && other.courseDepartmentId != null) || (this.courseDepartmentId != null && !this.courseDepartmentId.equals(other.courseDepartmentId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.ProgramCourseListPK[ programName=" + programName + ", programDepartmentId=" + programDepartmentId + ", courseNumber=" + courseNumber + ", courseDepartmentId=" + courseDepartmentId + " ]";
    }
}
