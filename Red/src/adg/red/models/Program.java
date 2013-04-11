 //*****************************************************
 /* (INCOMPLETE)
 Program.java -- Model for Program table

 @Contributors:  Harsimran

 @Purpose:   Generates various quesries on Program table
 *
 @Copyright ADG (2013) - Open License
 */
//*****************************************************
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Creating queries to be used in methods followed
 */
@Entity
@Table(name = "Program")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByProgramName", query = "SELECT p FROM Program p WHERE p.programPK.programName = :programName"),
    @NamedQuery(name = "Program.findByDepartmentId", query = "SELECT p FROM Program p WHERE p.programPK.departmentId = :departmentId"),
    @NamedQuery(name = "Program.findByIsActive", query = "SELECT p FROM Program p WHERE p.isActive = :isActive")
})
public class Program implements Serializable
{
    //programPK, creditsRequired, and departmentId are attribute of
    //Program and setting program by default to be active

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPK programPK;
    @Basic(optional = false)
    @Column(name = "creditsRequired")
    private int creditsRequired;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;

    /**
     * Public class constructor
     */
    public Program()
    {
    }

    /**
     * Public constructor that sets the primary key values (programPK) of a
     * program object
     * <p/>
     * @param programPK -- Object of type programPK that consists of programName
     *                  and departmentId
     */
    public Program(ProgramPK programPK)
    {
        this.programPK = programPK;
    }

    /**
     * Public constructor that sets the primary key values (programPK) of a
     * program object plus sets the attribute isActive
     * <p/>
     * @param programPK -- Object of type programPK that consists of programName
     *                  and departmentId
     * @param isActive  -- Boolean indicating whether Program is active(true) or
     *                  not(false)
     */
    public Program(ProgramPK programPK, boolean isActive)
    {
        this.programPK = programPK;
        this.isActive = isActive;
    }

    /**
     * Public constructor that sets the programName and the departmentId program
     * attributes of a Program object
     * <p/>
     * @param programName  -- String value containing departmentName
     * @param departmentId -- String value containing departmentId
     */
    public Program(String programName, String departmentId)
    {
        this.programPK = new ProgramPK(programName, departmentId);
    }

    /**
     * Public constructor that creates an object of type ProgramPK
     * <p/>
     * @return -- Object type ProgramPK
     */
    public ProgramPK getProgramPK()
    {
        return programPK;
    }

    /**
     * Public setter method that sets the programPK for a Program object
     * <p/>
     * @param programPK -- Object type ProgramPK
     */
    public void setProgramPK(ProgramPK programPK)
    {
        this.programPK = programPK;
    }

    /**
     * Public getter method that returns the isActive attribute of a Program
     * object
     * <p/>
     * @return -- Boolean attribute isActive
     */
    public boolean getIsActive()
    {
        return isActive;
    }

    /**
     * Public setter method that sets the isActive attribute of a Program object
     * <p/>
     * @param isActive -- Boolean attribute isActive
     */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * Public getter method that returns the Department object (which contains
     * departmentId, name and facultyId) for a Program
     * <p/>
     * @return -- Object type Department
     */
    public Department getDepartment()
    {
        return department;
    }

    /**
     * Public setter method that sets the Department object (which contains
     * departmentId, name and facultyId) for a Program
     * <p/>
     * @param department -- Object type Department
     */
    public void setDepartment(Department department)
    {
        this.department = department;
    }

    /**
     * Public method overriding hasCode() using ProgramPK specific hash value.
     * Adds programPK to make the index unique
     * <p/>
     * @return - Integer unique hashCode index value
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (programPK != null ? programPK.hashCode() : 0);
        return hash;
    }

    /**
     * Public method overriding equals(Object object) method that returns true
     * if the given object is an instance of a Program object and is the same as
     * current Program object
     * <p/>
     * @param object -- Pass any Object
     * <p/>
     * @return -- true if object is of type Program and the same as current
     *         Program object, false otherwise
     */
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof Program))
        {
            return false;
        }
        Program other = (Program) object;
        if ((this.programPK == null && other.programPK != null) || (this.programPK != null && !this.programPK.equals(other.programPK)))
        {
            return false;
        }
        return true;
    }

    /**
     * Public method overriding method for converting object to string by
     * attaching the following string to it: "adg.red.models.Prerequisite[
     * programPK"
     * <p/>
     * @return - String literal
     */
    @Override
    public String toString()
    {
        return "adg.red.models.Program[ programPK=" + programPK + " ]";
    }

    /**
     * Public getter method that returns the crediteRequired attribute onside a
     * Program object
     * <p/>
     * @return -- Integer creditsRequired attribute
     */
    public int getCreditsRequired()
    {
        return creditsRequired;
    }

    /**
     * Public setter method that sets the creditsRequired attribute inside a
     * program object
     * <p/>
     * @param creditsRequired -- Integer creditsRequired attribute
     */
    public void setCreditsRequired(int creditsRequired)
    {
        this.creditsRequired = creditsRequired;
    }
}
