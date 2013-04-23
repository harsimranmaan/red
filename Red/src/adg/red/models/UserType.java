/*
 *
 *
 */
package adg.red.models;

import adg.red.locale.LocaleManager;
import adg.red.utils.RedEntityManager;
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

    /**
     * Default constructor
     */
    public UserType()
    {
    }

    /**
     * Constructor
     * <p/>
     * @param userTypeId table attribute
     */
    public UserType(Integer userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    /**
     * Constructor
     * <p/>
     * @param userTypeId table attribute
     * @param name       table attribute
     */
    public UserType(Integer userTypeId, String name)
    {
        this.userTypeId = userTypeId;
        this.name = name;
    }

    /**
     * Get table attribute userTypeId
     * <p/>
     * @return userTypeId
     */
    public Integer getUserTypeId()
    {
        return userTypeId;
    }

    /**
     * Set table attribute userTypeId
     * <p/>
     * @param userTypeId table attribute
     */
    public void setUserTypeId(Integer userTypeId)
    {
        this.userTypeId = userTypeId;
    }

    /**
     * Get table attribute name
     * <p/>
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set table attribute name
     * <p/>
     * @param name table attribute
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get record location
     * <p/>
     * @return hash code
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (userTypeId != null ? userTypeId.hashCode() : 0);
        return hash;
    }

    /**
     * Comparator
     * <p/>
     * @param object object to be compared with
     * <p/>
     * @return true if two object equal to each other, otherwise return false
     */
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

    /**
     * print userTypeId
     * <p/>
     * @return userTypeId as a string
     */
    @Override
    public String toString()
    {
        return "adg.red.models.UserType[ userTypeId=" + userTypeId + " ]";
    }

    /**
     * Get UserType by userType id
     * <p/>
     * @param userTypeId <p/>
     * @return UserType of the input userType id
     * <p/>
     * @throws Exception
     */
    public static UserType getByUserTypeId(int userTypeId) throws Exception
    {
        UserType temp = (UserType) RedEntityManager.getEntityManager().createNamedQuery("UserType.findByUserTypeId").setParameter("userTypeId", userTypeId).getSingleResult();
        if (temp != null)
        {
            return temp;
        }
        else
        {
            throw new Exception("");
        }
    }
}
