/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "ProgramCourseList")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "ProgramCourseList.findAll", query = "SELECT p FROM ProgramCourseList p"),
    @NamedQuery(name = "ProgramCourseList.findByProgramName", query = "SELECT p FROM ProgramCourseList p WHERE p.programCourseListPK.programName = :programName"),
    @NamedQuery(name = "ProgramCourseList.findByProgramDepartmentId", query = "SELECT p FROM ProgramCourseList p WHERE p.programCourseListPK.programDepartmentId = :programDepartmentId"),
    @NamedQuery(name = "ProgramCourseList.findByCourseNumber", query = "SELECT p FROM ProgramCourseList p WHERE p.programCourseListPK.courseNumber = :courseNumber"),
    @NamedQuery(name = "ProgramCourseList.findByCourseDepartmentId", query = "SELECT p FROM ProgramCourseList p WHERE p.programCourseListPK.courseDepartmentId = :courseDepartmentId"),
    @NamedQuery(name = "ProgramCourseList.findByIsActive", query = "SELECT p FROM ProgramCourseList p WHERE p.isActive = :isActive")
})
public class ProgramCourseList implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramCourseListPK programCourseListPK;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;

    public ProgramCourseList()
    {
    }

    public ProgramCourseList(ProgramCourseListPK programCourseListPK)
    {
        this.programCourseListPK = programCourseListPK;
    }

    public ProgramCourseList(ProgramCourseListPK programCourseListPK, boolean isActive)
    {
        this.programCourseListPK = programCourseListPK;
        this.isActive = isActive;
    }

    public ProgramCourseList(String programName, String programDepartmentId, int courseNumber, String courseDepartmentId)
    {
        this.programCourseListPK = new ProgramCourseListPK(programName, programDepartmentId, courseNumber, courseDepartmentId);
    }

    public ProgramCourseListPK getProgramCourseListPK()
    {
        return programCourseListPK;
    }

    public void setProgramCourseListPK(ProgramCourseListPK programCourseListPK)
    {
        this.programCourseListPK = programCourseListPK;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (programCourseListPK != null ? programCourseListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramCourseList))
        {
            return false;
        }
        ProgramCourseList other = (ProgramCourseList) object;
        if ((this.programCourseListPK == null && other.programCourseListPK != null) || (this.programCourseListPK != null && !this.programCourseListPK.equals(other.programCourseListPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.ProgramCourseList[ programCourseListPK=" + programCourseListPK + " ]";
    }
}
