//*****************************************************
 /* (INCOMPLETE)
 ProgramCourseListPK.java -- Model for ProgramCourse table

 @Contributors:  Harsimran

 @Purpose:   Generates various quesries on ProgramCourseListPK table
 *           that is used in identifying the primary key of a
 *           ProgramCourseList associated with a programCourse
 *
 @Copyright ADG (2013) - Open License
 */
//*****************************************************
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgramCourseListPK implements Serializable
{
// programName, programDepartmentId, courseNumber and courseDepartmentId
// are all attributes of programCourseListPK (non-optional)

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
     * Public default class constructor
     */
    public ProgramCourseListPK()
    {
    }

    /**
     * Public class constructor using attributes: programName,
     * programDepartmentId, courseNumber and courseDeaprtmentId. Creates an
     * instance of ProgramCourseListPK.
     * <p/>
     * @param programName         -- String containing programName attribute
     * @param programDepartmentId -- String containing programDepartmentId
     *                            attribute
     * @param courseNumber        -- Integer containing courseNumber
     * @param courseDepartmentId  -- String containing courseDepartmentId
     */
    public ProgramCourseListPK(String programName, String programDepartmentId, int courseNumber, String courseDepartmentId)
    {
        this.programName = programName;
        this.programDepartmentId = programDepartmentId;
        this.courseNumber = courseNumber;
        this.courseDepartmentId = courseDepartmentId;
    }

    /**
     * Public getter method that returns the programName attribute inside a
     * ProgramCourseListPK object
     * <p/>
     * @return -- String containing programName attribute
     */
    public String getProgramName()
    {
        return programName;
    }

    /**
     * Public setter method that sets the programName attribute inside a
     * ProgramCourseListPK object
     * <p/>
     * @param programName -- String containing programName attribute
     */
    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    /**
     * Public getter method that returns a String containing the
     * programDepartmentId inside a PrograCourseListPK object
     * <p/>
     * @return -- String containing
     */
    public String getProgramDepartmentId()
    {
        return programDepartmentId;
    }

    /**
     * Public setter method that sets the programDepartmentid attribute inside a
     * PrograCourseListPK object
     * <p/>
     * @param programDepartmentId -- String containing programDepartmentId
     */
    public void setProgramDepartmentId(String programDepartmentId)
    {
        this.programDepartmentId = programDepartmentId;
    }

    /**
     * Public method that returns the courseNumber inside a PrograCourseListPK
     * object
     * <p/>
     * @return -- Integer courseNumber attribute
     */
    public int getCourseNumber()
    {
        return courseNumber;
    }

    /**
     * Public setter method that sets the courseNumber inside a
     * PrograCourseListPK object
     * <p/>
     * @param courseNumber -- Integer containing the coursNumber attribute
     */
    public void setCourseNumber(int courseNumber)
    {
        this.courseNumber = courseNumber;
    }

    /**
     * Public getter method that returns the courseDepartmentId attribute inside
     * a PrograCourseListPK object
     * <p/>
     * @return -- String containing the courseDepartmentId attribute
     */
    public String getCourseDepartmentId()
    {
        return courseDepartmentId;
    }

    /**
     * Public setter method that sets the courseDepartmentId attribute inside a
     * PrograCourseListPK object
     * <p/>
     * @param courseDepartmentId -- String containing courseDepartmentId
     *                           attribute
     */
    public void setCourseDepartmentId(String courseDepartmentId)
    {
        this.courseDepartmentId = courseDepartmentId;
    }

    /**
     * Public method overriding hasCode() using ProgramCourseListPK specific
     * hash value. Adds programName, programDepartmendId, and courseDepartmentId
     * to make the index unique
     * <p/>
     * @return - Integer unique hashCode index value
     */
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

    /**
     * Public method overriding equals(Object object) method that returns true
     * if the given object is an instance of a ProgramCourdseListPK object and
     * is the same as current ProgramCourdseListPK object
     * <p/>
     * @param object -- Pass any Object
     * <p/>
     * @return -- true if object is of type ProgramCourdseListPK and the same as
     *         current ProgramCourdseListPK object, false otherwise
     */
    @Override
    public boolean equals(Object object)
    {
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

    /**
     * Public method overriding method for converting object to string by
     * attaching the following string to it: "adg.red.models.Prerequisite[
     * programName + programDepartmentId + courseNumber + courseDepartmentId"
     * <p/>
     * @return - String literal
     */
    @Override
    public String toString()
    {
        return "adg.red.models.ProgramCourseListPK[ programName=" + programName + ", programDepartmentId=" + programDepartmentId + ", courseNumber=" + courseNumber + ", courseDepartmentId=" + courseDepartmentId + " ]";
    }
}
