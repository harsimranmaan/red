 //*****************************************************
 /* (INCOMPLETE)
 PrerequisuitePK.java -- Model for Prerequisuite table

 @Contributors:  Harsimran

 @Purpose:   Generates various quesries on PrerequisitePK
 *           table that is used in identifying the primary key of a
 *           prereq course associated with a course
 *
 @Copyright ADG (2013) - Open License
 */
//*****************************************************
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Class Prerequisite manages queries of instances of PrerequisitePK
 */
@Embeddable
public class PrerequisitePK implements Serializable
{
//courseNumber, departmentId, prerequisiteNumber and prerequisiteDepartmentId
//are attribute of Prerequisuite Course (not-optional)

    @Basic(optional = false)
    @Column(name = "courseNumber")
    private int courseNumber;
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;
    @Basic(optional = false)
    @Column(name = "preRequisiteNumber")
    private int preRequisiteNumber;
    @Basic(optional = false)
    @Column(name = "preRequisiteDeptId")
    private String preRequisiteDeptId;

    /**
     * Public class constructor for PrerequisitePK
     */
    public PrerequisitePK()
    {
    }

    /**
     * Public class constructor creates an instance of object PrerequisitePK
     * that consists of all the attributes that make the primary key of a
     * Prerequisite Course
     * <p/>
     * @param courseNumber
     * @param departmentId
     * @param preRequisiteNumber
     * @param preRequisiteDeptId
     */
    public PrerequisitePK(int courseNumber, String departmentId, int preRequisiteNumber, String preRequisiteDeptId)
    {
        this.courseNumber = courseNumber;
        this.departmentId = departmentId;
        this.preRequisiteNumber = preRequisiteNumber;
        this.preRequisiteDeptId = preRequisiteDeptId;
    }

    /**
     * Public getter method that returns the courseNumber of a PrerequisitePK
     * <p/>
     * @return -- Integer attribute courseNumber
     */
    public int getCourseNumber()
    {
        return courseNumber;
    }

    /**
     * Public setter method that sets the value of the courseNumber attribute
     * inside a PrerequisitePK
     * <p/>
     * @param courseNumber -- Integer attribute courseNumber
     */
    public void setCourseNumber(int courseNumber)
    {
        this.courseNumber = courseNumber;
    }

    /**
     * Public getter method that returns the departmentId of a PrerequisitePK
     * <p/>
     * @return -- String attribute departmentId
     */
    public String getDepartmentId()
    {
        return departmentId;
    }

    /**
     * Public setter method that sets the value of the departmentId attribute
     * inside a PrerequisitePK
     * <p/>
     * @param departmentId -- String attribute departmentId
     */
    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    /**
     * Public getter method that returns the prerequisiteNumber of a
     * PrerequisitePk
     * <p/>
     * @return -- Integer attribute prerequisiteNumber
     */
    public int getPreRequisiteNumber()
    {
        return preRequisiteNumber;
    }

    /**
     * Public setter method that sets the integer value of a prerequisiteNumber
     * inside the PrerequisitePK
     * <p/>
     * @param preRequisiteNumber -- Integer attribute prerequisitePK
     */
    public void setPreRequisiteNumber(int preRequisiteNumber)
    {
        this.preRequisiteNumber = preRequisiteNumber;
    }

    /**
     * Public getter method that returns the string value prerequisiteDeptId of
     * a PrerequisitePK
     * <p/>
     * @return -- String attribute prerequisiteDeptId
     */
    public String getPreRequisiteDeptId()
    {
        return preRequisiteDeptId;
    }

    /**
     * Public setter method that sets the prerequisiteDeptId inside a
     * PrerequisitePK
     * <p/>
     * @param preRequisiteDeptId -- String attribute prerequisiteDeptId
     */
    public void setPreRequisiteDeptId(String preRequisiteDeptId)
    {
        this.preRequisiteDeptId = preRequisiteDeptId;
    }

    /**
     * Public method overriding hasCode() using PrerequisitePK specific hash
     * value. Adds courseNumber, departmendId and prerequisiteNumber to make the
     * index unique
     * <p/>
     * @return - Integer unique hashCode index value
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) courseNumber;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        hash += (int) preRequisiteNumber;
        hash += (preRequisiteDeptId != null ? preRequisiteDeptId.hashCode() : 0);
        return hash;
    }

    /**
     * Public method overriding equals(Object object) method that returns true
     * if the given object is an instance of a PrerequisitePK object and is the
     * same as current PrerequisitePK object
     * <p/>
     * @param object -- Pass any Object
     * <p/>
     * @return -- true if object is of type PrerequisitePK and the same as
     *         current PrerequisitePK object, false otherwise
     */
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof PrerequisitePK))
        {
            return false;
        }
        PrerequisitePK other = (PrerequisitePK) object;
        if (this.courseNumber != other.courseNumber)
        {
            return false;
        }
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId)))
        {
            return false;
        }
        if (this.preRequisiteNumber != other.preRequisiteNumber)
        {
            return false;
        }
        if ((this.preRequisiteDeptId == null && other.preRequisiteDeptId != null) || (this.preRequisiteDeptId != null && !this.preRequisiteDeptId.equals(other.preRequisiteDeptId)))
        {
            return false;
        }
        return true;
    }

    /**
     * Public method overriding method for converting object to string by
     * attaching the following string to it: "adg.red.models.Prerequisite[
     * courseNumber + departmentId + prerequisiteNumber + prerequisiteDeptId"
     * <p/>
     * @return - String literal
     */
    @Override
    public String toString()
    {
        return "adg.red.models.PrerequisitePK[ courseNumber=" + courseNumber + ", departmentId=" + departmentId + ", preRequisiteNumber=" + preRequisiteNumber + ", preRequisiteDeptId=" + preRequisiteDeptId + " ]";
    }
}
