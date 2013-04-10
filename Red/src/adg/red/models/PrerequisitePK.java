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
public class PrerequisitePK implements Serializable
{

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
     *
     */
    public PrerequisitePK()
    {
    }

    /**
     *
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
    public String getDepartmentId()
    {
        return departmentId;
    }

    /**
     *
     * @param departmentId
     */
    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    /**
     *
     * @return
     */
    public int getPreRequisiteNumber()
    {
        return preRequisiteNumber;
    }

    /**
     *
     * @param preRequisiteNumber
     */
    public void setPreRequisiteNumber(int preRequisiteNumber)
    {
        this.preRequisiteNumber = preRequisiteNumber;
    }

    /**
     *
     * @return
     */
    public String getPreRequisiteDeptId()
    {
        return preRequisiteDeptId;
    }

    /**
     *
     * @param preRequisiteDeptId
     */
    public void setPreRequisiteDeptId(String preRequisiteDeptId)
    {
        this.preRequisiteDeptId = preRequisiteDeptId;
    }

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

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
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

    @Override
    public String toString()
    {
        return "adg.red.models.PrerequisitePK[ courseNumber=" + courseNumber + ", departmentId=" + departmentId + ", preRequisiteNumber=" + preRequisiteNumber + ", preRequisiteDeptId=" + preRequisiteDeptId + " ]";
    }
}
