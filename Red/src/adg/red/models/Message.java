/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "Message")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByMessageId", query = "SELECT m FROM Message m WHERE m.messageId = :messageId"),
    @NamedQuery(name = "Message.findBySubject", query = "SELECT m FROM Message m WHERE m.subject = :subject"),
    @NamedQuery(name = "Message.findByMessageBody", query = "SELECT m FROM Message m WHERE m.messageBody = :messageBody"),
    @NamedQuery(name = "Message.findByDateTime", query = "SELECT m FROM Message m WHERE m.dateTime = :dateTime")
})
public class Message implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "messageId")
    private Integer messageId;
    @Column(name = "subject")
    private String subject;
    @Column(name = "messageBody")
    private String messageBody;
    @Basic(optional = false)
    @Column(name = "dateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @JoinColumn(name = "senderId", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User senderId;
    @JoinColumn(name = "priorityId", referencedColumnName = "messagePriorityId")
    @ManyToOne(optional = false)
    private MessagePriority priorityId;

    public Message()
    {
    }

    public Message(Integer messageId)
    {
        this.messageId = messageId;
    }

    public Message(Integer messageId, Date dateTime)
    {
        this.messageId = messageId;
        this.dateTime = dateTime;
    }

    public Integer getMessageId()
    {
        return messageId;
    }

    public void setMessageId(Integer messageId)
    {
        this.messageId = messageId;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getMessageBody()
    {
        return messageBody;
    }

    public void setMessageBody(String messageBody)
    {
        this.messageBody = messageBody;
    }

    public Date getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(Date dateTime)
    {
        this.dateTime = dateTime;
    }

    public User getSenderId()
    {
        return senderId;
    }

    public void setSenderId(User senderId)
    {
        this.senderId = senderId;
    }

    public MessagePriority getPriorityId()
    {
        return priorityId;
    }

    public void setPriorityId(MessagePriority priorityId)
    {
        this.priorityId = priorityId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message))
        {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Message[ messageId=" + messageId + " ]";
    }
}
