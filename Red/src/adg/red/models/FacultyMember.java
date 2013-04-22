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
@Table(name = "FacultyMember")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "FacultyMember.findAll", query = "SELECT f FROM FacultyMember f"),
    @NamedQuery(name = "FacultyMember.findByFacultyMemberId", query = "SELECT f FROM FacultyMember f WHERE f.facultyMemberId = :facultyMemberId")
})
public class FacultyMember implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "facultyMemberId")
    private Integer facultyMemberId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "dateOfJoining")
    @Temporal(TemporalType.DATE)
    private Date dateOfJoining;
    @Column(name = "highestDegree")
    private String highestDegree;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    @ManyToOne(optional = false)
    private Department departmentId;

    public FacultyMember()
    {
    }

    public FacultyMember(Integer facultyMemberId)
    {
        this.facultyMemberId = facultyMemberId;
    }

    public FacultyMember(Integer facultyMemberId, String title, Date dateOfJoining, boolean isActive)
    {
        this.facultyMemberId = facultyMemberId;
        this.title = title;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public Integer getFacultyMemberId()
    {
        return facultyMemberId;
    }

    public void setFacultyMemberId(Integer facultyMemberId)
    {
        this.facultyMemberId = facultyMemberId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getDateOfJoining()
    {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining)
    {
        this.dateOfJoining = dateOfJoining;
    }

    public String getHighestDegree()
    {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree)
    {
        this.highestDegree = highestDegree;
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

    public Department getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId)
    {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (facultyMemberId != null ? facultyMemberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacultyMember))
        {
            return false;
        }
        FacultyMember other = (FacultyMember) object;
        if ((this.facultyMemberId == null && other.facultyMemberId != null) || (this.facultyMemberId != null && !this.facultyMemberId.equals(other.facultyMemberId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.FacultyMember[ facultyMemberId=" + facultyMemberId + " ]";
    }

    public static FacultyMember getFacultMemberByName(String userName)
    {
        List<FacultyMember> facultyMemberList = RedEntityManager.getEntityManager().createNamedQuery("FacultyMember.findByUserName").setParameter("username", userName).getResultList();
        if (facultyMemberList.size() == 1)
        {
            return facultyMemberList.get(0);
        }
        else
        {
            return null;
        }
    }
}
