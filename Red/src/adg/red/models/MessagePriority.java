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
 * @author harsimran.maan
 */
@Entity
@Table(name = "MessagePriority")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "MessagePriority.findAll", query = "SELECT m FROM MessagePriority m"),
    @NamedQuery(name = "MessagePriority.findByMessagePriorityId", query = "SELECT m FROM MessagePriority m WHERE m.messagePriorityId = :messagePriorityId"),
    @NamedQuery(name = "MessagePriority.findByName", query = "SELECT m FROM MessagePriority m WHERE m.name = :name")
})
public class MessagePriority implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "messagePriorityId")
    private Integer messagePriorityId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priorityId")
    private Collection<Message> messageCollection;

    public MessagePriority()
    {
    }

    public MessagePriority(Integer messagePriorityId)
    {
        this.messagePriorityId = messagePriorityId;
    }

    public MessagePriority(Integer messagePriorityId, String name)
    {
        this.messagePriorityId = messagePriorityId;
        this.name = name;
    }

    public Integer getMessagePriorityId()
    {
        return messagePriorityId;
    }

    public void setMessagePriorityId(Integer messagePriorityId)
    {
        this.messagePriorityId = messagePriorityId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection()
    {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection)
    {
        this.messageCollection = messageCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (messagePriorityId != null ? messagePriorityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessagePriority))
        {
            return false;
        }
        MessagePriority other = (MessagePriority) object;
        if ((this.messagePriorityId == null && other.messagePriorityId != null) || (this.messagePriorityId != null && !this.messagePriorityId.equals(other.messagePriorityId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.MessagePriority[ messagePriorityId=" + messagePriorityId + " ]";
    }
}
