/*
 *
 *
 */
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
 *
 * @author harsimran.maan
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

    private static final long serialVersionUID = 1L;
    /**
     *
     */
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
     *
     */
    public Program()
    {
    }

    /**
     *
     * @param programPK
     */
    public Program(ProgramPK programPK)
    {
        this.programPK = programPK;
    }

    /**
     *
     * @param programPK
     * @param isActive
     */
    public Program(ProgramPK programPK, boolean isActive)
    {
        this.programPK = programPK;
        this.isActive = isActive;
    }

    /**
     *
     * @param programName
     * @param departmentId
     */
    public Program(String programName, String departmentId)
    {
        this.programPK = new ProgramPK(programName, departmentId);
    }

    /**
     *
     * @return
     */
    public ProgramPK getProgramPK()
    {
        return programPK;
    }

    /**
     *
     * @param programPK
     */
    public void setProgramPK(ProgramPK programPK)
    {
        this.programPK = programPK;
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
    public Department getDepartment()
    {
        return department;
    }

    /**
     *
     * @param department
     */
    public void setDepartment(Department department)
    {
        this.department = department;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (programPK != null ? programPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
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

    @Override
    public String toString()
    {
        return "adg.red.models.Program[ programPK=" + programPK + " ]";
    }

    /**
     *
     * @return
     */
    public int getCreditsRequired()
    {
        return creditsRequired;
    }

    /**
     *
     * @param creditsRequired
     */
    public void setCreditsRequired(int creditsRequired)
    {
        this.creditsRequired = creditsRequired;
    }
}
