/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "UserType")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u"),
    @NamedQuery(name = "UserType.findByUserTypeId", query = "SELECT u FROM UserType u WHERE u.userTypeId = :userTypeId"),
    @NamedQuery(name = "UserType.findByName", query = "SELECT u FROM UserType u WHERE u.name = :name")
})
public class UserType implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userTypeId")
    private Integer userTypeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public UserType()
    {
    }

    public UserType(Integer userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    public UserType(Integer userTypeId, String name)
    {
        this.userTypeId = userTypeId;
        this.name = name;
    }

    public Integer getUserTypeId()
    {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (userTypeId != null ? userTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserType))
        {
            return false;
        }
        UserType other = (UserType) object;
        if ((this.userTypeId == null && other.userTypeId != null) || (this.userTypeId != null && !this.userTypeId.equals(other.userTypeId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.UserType[ userTypeId=" + userTypeId + " ]";
    }
}
