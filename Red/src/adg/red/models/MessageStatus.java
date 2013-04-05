/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

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
@Table(name = "MessageStatus")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "MessageStatus.findAll", query = "SELECT m FROM MessageStatus m"),
    @NamedQuery(name = "MessageStatus.findByStatusId", query = "SELECT m FROM MessageStatus m WHERE m.statusId = :statusId"),
    @NamedQuery(name = "MessageStatus.findByName", query = "SELECT m FROM MessageStatus m WHERE m.name = :name")
})
public class MessageStatus implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "statusId")
    private Integer statusId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public MessageStatus()
    {
    }

    public MessageStatus(Integer statusId)
    {
        this.statusId = statusId;
    }

    public MessageStatus(Integer statusId, String name)
    {
        this.statusId = statusId;
        this.name = name;
    }

    public Integer getStatusId()
    {
        return statusId;
    }

    public void setStatusId(Integer statusId)
    {
        this.statusId = statusId;
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
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageStatus))
        {
            return false;
        }
        MessageStatus other = (MessageStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.MessageStatus[ statusId=" + statusId + " ]";
    }
}
