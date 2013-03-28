/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hsmaan
 */
@Entity
@Table(name = "UserType")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u"),
    @NamedQuery(name = "UserType.findByUserTypeId", query = "SELECT u FROM UserType u WHERE u.userTypeId = :userTypeId"),
    @NamedQuery(name = "UserType.findByTypeName", query = "SELECT u FROM UserType u WHERE u.typeName = :typeName")
})
public class UserType implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userTypeId")
    private Integer userTypeId;
    @Basic(optional = false)
    @Column(name = "typeName")
    private String typeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTypeId")
    private Collection<User> userCollection;

    public UserType()
    {
    }

    public UserType(Integer userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    public UserType(Integer userTypeId, String typeName)
    {
        this.userTypeId = userTypeId;
        this.typeName = typeName;
    }

    public Integer getUserTypeId()
    {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    @XmlTransient
    public Collection<User> getUserCollection()
    {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection)
    {
        this.userCollection = userCollection;
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
