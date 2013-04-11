//*****************************************************
 /* (INCOMPLETE)
 ProgramPK.java -- Model for Program table

 @Contributors:  Harsimran

 @Purpose:   Generates various quesries on Program
 *           table that is used in identifying the primary key
 *           of a program associated with a course
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
public class ProgramPK implements Serializable
{
//programName and departmentId are attribute of ProgramPK(not-optional)

    @Basic(optional = false)
    @Column(name = "programName")
    private String programName;
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;

    /**
     * Public default class constructor
     */
    public ProgramPK()
    {
    }

    /**
     * Public class constructor using programName and departmentId attributes
     * <p/>
     * @param programName  -- String containing programName attribute value
     * @param departmentId -- String containing departmentId attribute value
     */
    public ProgramPK(String programName, String departmentId)
    {
        this.programName = programName;
        this.departmentId = departmentId;
    }

    /**
     * Public getter method that returns the programName inside of a ProgramPK
     * <p/>
     * @return -- String programName attribute
     */
    public String getProgramName()
    {
        return programName;
    }

    /**
     * Public setter method that sets the programName attribute inside a
     * ProgramPK
     * <p/>
     * @param programName -- String programName attribute
     */
    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    /**
     * Public getter method that returns the departmentId attribute inside a
     * programPK
     * <p/>
     * @return -- String programId attribute
     */
    public String getDepartmentId()
    {
        return departmentId;
    }

    /**
     * Public setter method that sets the departmenrId attribute inside a
     * programPK
     * <p/>
     * @param departmentId -- String programId attribute
     */
    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    /**
     * Public method overriding hasCode() using ProgramPK specific hash value.
     * Adds programName and departmendId to make the index unique
     * <p/>
     * @return - Integer unique hashCode index value
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (programName != null ? programName.hashCode() : 0);
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    /**
     * Public method overriding equals(Object object) method that returns true
     * if the given object is an instance of a ProgramPK object and is the same
     * as current ProgramPK object
     * <p/>
     * @param object -- Pass any Object
     * <p/>
     * @return -- true if object is of type ProgramPK and the same as current
     *         ProgramPK object, false otherwise
     */
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof ProgramPK))
        {
            return false;
        }
        ProgramPK other = (ProgramPK) object;
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
     * attaching the following string to it: "adg.red.models.ProgramPK[
     * programName + departmentId"
     * <p/>
     * @return - String literal
     */
    @Override
    public String toString()
    {
        return "adg.red.models.ProgramPK[ programName=" + programName + ", departmentId=" + departmentId + " ]";
    }
}
