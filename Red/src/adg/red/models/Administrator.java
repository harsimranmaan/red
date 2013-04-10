/*
 * 
 * 
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author harsimran.maan
 */
@Entity
@Table(name = "Administrator")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAdminId", query = "SELECT a FROM Administrator a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "Administrator.findByDateOfJoining", query = "SELECT a FROM Administrator a WHERE a.dateOfJoining = :dateOfJoining"),
    @NamedQuery(name = "Administrator.findByIsActive", query = "SELECT a FROM Administrator a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "Administrator.findByUserName", query = "SELECT a FROM Administrator a WHERE a.username = :username")
})
public class Administrator implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adminId")
    private Integer adminId;
    @Basic(optional = false)
    @Column(name = "dateOfJoining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;
    @JoinColumn(name = "hiringFacultyId", referencedColumnName = "facultyId")
    @ManyToOne(optional = false)
    private Faculty hiringFacultyId;

    public Administrator()
    {
    }

    public Administrator(Integer adminId)
    {
        this.adminId = adminId;
    }

    public Administrator(Integer adminId, Date dateOfJoining, boolean isActive)
    {
        this.adminId = adminId;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Integer getAdminId()
    {
        return adminId;
    }

    public void setAdminId(Integer adminId)
    {
        this.adminId = adminId;
    }

    public Date getDateOfJoining()
    {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining)
    {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public User getUsername()
    {
        return username;
    }

    public void setUsername(User username)
    {
        this.username = username;
    }

    public Faculty getHiringFacultyId()
    {
        return hiringFacultyId;
    }

    public void setHiringFacultyId(Faculty hiringFacultyId)
    {
        this.hiringFacultyId = hiringFacultyId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator))
        {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Administrator[ adminId=" + adminId + " ]";
    }
    
    public static Administrator getAdministratorByUserName(User userName) throws Exception
    {
        List<Administrator> AdministratorList = RedEntityManager.getEntityManager().createNamedQuery("Administrator.findByUserName").setParameter("username", userName).getResultList();
        if (AdministratorList.size() == 1)
        {
            return AdministratorList.get(0);
        }
        else
        {
            throw new Exception("Invalid user name in administrator");
        }
    }    
}
