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
    @NamedQuery(name = "Program.findByEmail", query = "SELECT p FROM Program p WHERE p.email = :email"),
    @NamedQuery(name = "Program.findByPhone", query = "SELECT p FROM Program p WHERE p.phone = :phone"),
    @NamedQuery(name = "Program.findByIsActive", query = "SELECT p FROM Program p WHERE p.isActive = :isActive")
})
public class Program implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramPK programPK;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @ManyToOne
    private Address addressId;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;

    public Program()
    {
    }

    public Program(ProgramPK programPK)
    {
        this.programPK = programPK;
    }

    public Program(ProgramPK programPK, String email, String phone, boolean isActive)
    {
        this.programPK = programPK;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Program(String programName, String departmentId)
    {
        this.programPK = new ProgramPK(programName, departmentId);
    }

    public ProgramPK getProgramPK()
    {
        return programPK;
    }

    public void setProgramPK(ProgramPK programPK)
    {
        this.programPK = programPK;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Address getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Address addressId)
    {
        this.addressId = addressId;
    }

    public Department getDepartment()
    {
        return department;
    }

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
}
