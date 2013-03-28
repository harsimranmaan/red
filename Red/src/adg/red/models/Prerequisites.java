/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hsmaan
 */
@Entity
@Table(name = "prerequisites")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Prerequisites.findAll", query = "SELECT p FROM Prerequisites p"),
    @NamedQuery(name = "Prerequisites.findByCourse", query = "SELECT p FROM Prerequisites p WHERE p.prerequisitesPK.course = :course"),
    @NamedQuery(name = "Prerequisites.findByDepartment", query = "SELECT p FROM Prerequisites p WHERE p.prerequisitesPK.department = :department"),
    @NamedQuery(name = "Prerequisites.findByPreRequisite", query = "SELECT p FROM Prerequisites p WHERE p.prerequisitesPK.preRequisite = :preRequisite"),
    @NamedQuery(name = "Prerequisites.findByPreRequisiteDept", query = "SELECT p FROM Prerequisites p WHERE p.prerequisitesPK.preRequisiteDept = :preRequisiteDept"),
    @NamedQuery(name = "Prerequisites.findByCreatedBy", query = "SELECT p FROM Prerequisites p WHERE p.createdBy = :createdBy"),
    @NamedQuery(name = "Prerequisites.findByCreatedDateTime", query = "SELECT p FROM Prerequisites p WHERE p.createdDateTime = :createdDateTime"),
    @NamedQuery(name = "Prerequisites.findByModifiedBy", query = "SELECT p FROM Prerequisites p WHERE p.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Prerequisites.findByModifiedDateTime", query = "SELECT p FROM Prerequisites p WHERE p.modifiedDateTime = :modifiedDateTime"),
    @NamedQuery(name = "Prerequisites.findByIsActive", query = "SELECT p FROM Prerequisites p WHERE p.isActive = :isActive")
})
public class Prerequisites implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrerequisitesPK prerequisitesPK;
    @Basic(optional = false)
    @Column(name = "createdBy")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "createdDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Basic(optional = false)
    @Column(name = "modifiedBy")
    private String modifiedBy;
    @Basic(optional = false)
    @Column(name = "modifiedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDateTime;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "department", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department1;
    @JoinColumn(name = "preRequisiteDept", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department2;

    public Prerequisites()
    {
    }

    public Prerequisites(PrerequisitesPK prerequisitesPK)
    {
        this.prerequisitesPK = prerequisitesPK;
    }

    public Prerequisites(PrerequisitesPK prerequisitesPK, String createdBy, Date createdDateTime, String modifiedBy, Date modifiedDateTime, boolean isActive)
    {
        this.prerequisitesPK = prerequisitesPK;
        this.createdBy = createdBy;
        this.createdDateTime = createdDateTime;
        this.modifiedBy = modifiedBy;
        this.modifiedDateTime = modifiedDateTime;
        this.isActive = isActive;
    }

    public Prerequisites(int course, String department, int preRequisite, String preRequisiteDept)
    {
        this.prerequisitesPK = new PrerequisitesPK(course, department, preRequisite, preRequisiteDept);
    }

    public PrerequisitesPK getPrerequisitesPK()
    {
        return prerequisitesPK;
    }

    public void setPrerequisitesPK(PrerequisitesPK prerequisitesPK)
    {
        this.prerequisitesPK = prerequisitesPK;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public Date getCreatedDateTime()
    {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime)
    {
        this.createdDateTime = createdDateTime;
    }

    public String getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDateTime()
    {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime)
    {
        this.modifiedDateTime = modifiedDateTime;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Department getDepartment1()
    {
        return department1;
    }

    public void setDepartment1(Department department1)
    {
        this.department1 = department1;
    }

    public Department getDepartment2()
    {
        return department2;
    }

    public void setDepartment2(Department department2)
    {
        this.department2 = department2;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (prerequisitesPK != null ? prerequisitesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prerequisites))
        {
            return false;
        }
        Prerequisites other = (Prerequisites) object;
        if ((this.prerequisitesPK == null && other.prerequisitesPK != null) || (this.prerequisitesPK != null && !this.prerequisitesPK.equals(other.prerequisitesPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Prerequisites[ prerequisitesPK=" + prerequisitesPK + " ]";
    }
}
