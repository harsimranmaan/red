 //*****************************************************
 /* (INCOMPLETE)
 RegistrationPK.java -- Model for Registration table

 @Contributors:  Harsimran

 @Purpose:   Generates various quesries on Registration table
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
public class RegistrationPK implements Serializable
{
// studentId, programName and departmentId are all attributes in the primary
// keys for Registration and elements of RegistrationPK set

    @Basic(optional = false)
    @Column(name = "studentId")
    private int studentId;
    @Basic(optional = false)
    @Column(name = "programName")
    private String programName;
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;

    /**
     * Public default class constructor
     */
    public RegistrationPK()
    {
    }

    /**
     * Public class constructor using studentId, programName and departmentId
     * attributes and returns an Object of type RegistrationPK
     * <p/>
     * @param studentId    -- Integer containing studentId
     * @param programName  -- String containing programName
     * @param departmentId -- String containing departmentId
     */
    public RegistrationPK(int studentId, String programName, String departmentId)
    {
        this.studentId = studentId;
        this.programName = programName;
        this.departmentId = departmentId;
    }

    /**
     * Public getter method that returns attribute studentId
     * <p/>
     * @return -- Integer containing studentId attribute
     */
    public int getStudentId()
    {
        return studentId;
    }

    /**
     * Public setter method that sets the studentId attribute
     * <p/>
     * @param studentId -- Integer containing studentId attribute
     */
    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    /**
     * Public getter method that returns the programName attribute
     * <p/>
     * @return -- String containing programName attribute
     */
    public String getProgramName()
    {
        return programName;
    }

    /**
     * Public setter method that sets the programName attribute
     * <p/>
     * @param programName -- String containing programName attribute
     */
    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    /**
     * Public getter method that returns the departmentId attribute
     * <p/>
     * @return -- String containing the departmentId attribute
     */
    public String getDepartmentId()
    {
        return departmentId;
    }

    /**
     * Public setter method that sets the departmentId attribute
     * <p/>
     * @param departmentId -- String containing the departmentId attribute
     */
    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    /**
     * Public method overriding hasCode() using RegistrationPK specific hash
     * value. Adds studentId, departmentId to make the index unique
     * <p/>
     * @return - Integer unique hashCode index value
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) studentId;
        hash += (programName != null ? programName.hashCode() : 0);
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    /**
     * Public method overriding equals(Object object) method that returns true
     * if the given object is an instance of a RegistrationPK object and is the
     * same as current RegistrationPK object
     * <p/>
     * @param object -- Pass any Object
     * <p/>
     * @return -- true if object is of type RegistrationPK and the same as
     *         current RegistrationPK object, false otherwise
     */
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof RegistrationPK))
        {
            return false;
        }
        RegistrationPK other = (RegistrationPK) object;
        if (this.studentId != other.studentId)
        {
            return false;
        }
        if ((this.programName == null && other.programName != null) || (this.programName != null && !this.programName.equals(other.programName)))
        {
            return false;
        }
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId)))
        {
            return false;
        }
        return true;
    }

    /**
     * Public method overriding method for converting object to string by
     * attaching the following string to it: "adg.red.models.RegistrationPK[
     * studentId + programName + departmentId"
     * <p/>
     * @return - String literal
     */
    @Override
    public String toString()
    {
        return "adg.red.models.RegistrationPK[ studentId=" + studentId + ", programName=" + programName + ", departmentId=" + departmentId + " ]";
    }
}
