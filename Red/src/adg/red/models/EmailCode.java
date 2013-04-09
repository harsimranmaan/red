/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "EmailCode")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "EmailCode.findByUsername", query = "SELECT e FROM EmailCode e WHERE e.username = :username"),
    @NamedQuery(name = "EmailCode.findByCode", query = "SELECT e FROM EmailCode e WHERE e.code = :code")
})
public class EmailCode implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;

    public EmailCode()
    {
    }

    public EmailCode(String username)
    {
        this.username = username;
        this.code = Integer.toString(100000 + (int) (Math.random() * 999999));
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailCode))
        {
            return false;
        }
        EmailCode other = (EmailCode) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.EmailCode[ username=" + username + " ]";
    }

    public void save()
    {
        RedEntityManager.save(this);
    }
}
