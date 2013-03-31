/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class ProgramPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "programName")
    private String programName;
    @Basic(optional = false)
    @Column(name = "departmentId")
    private String departmentId;

    public ProgramPK()
    {
    }

    public ProgramPK(String programName, String departmentId)
    {
        this.programName = programName;
        this.departmentId = departmentId;
    }

    public String getProgramName()
    {
        return programName;
    }

    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    public String getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (programName != null ? programName.hashCode() : 0);
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
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

    @Override
    public String toString()
    {
        return "adg.red.models.ProgramPK[ programName=" + programName + ", departmentId=" + departmentId + " ]";
    }
}
