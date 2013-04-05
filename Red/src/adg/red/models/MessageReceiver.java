/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.DateFormatter;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "MessageReceiver")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "MessageReceiver.findAll", query = "SELECT m FROM MessageReceiver m"),
    @NamedQuery(name = "MessageReceiver.findByMessageId", query = "SELECT m FROM MessageReceiver m WHERE m.messageReceiverPK.messageId = :messageId"),
    @NamedQuery(name = "MessageReceiver.findByReceiverId", query = "SELECT m FROM MessageReceiver m WHERE m.messageReceiverPK.receiverId = :receiverId AND m.statusId.name!='Deleted' ORDER BY m.statusId.statusId DESC, m.message.dateTime DESC"),
    @NamedQuery(name = "MessageReceiver.findByModifiedAt", query = "SELECT m FROM MessageReceiver m WHERE m.modifiedAt = :modifiedAt")
})
public class MessageReceiver implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MessageReceiverPK messageReceiverPK;
    @Basic(optional = false)
    @Column(name = "modifiedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    @ManyToOne(optional = false)
    private MessageStatus statusId;
    @JoinColumn(name = "receiverId", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "messageId", referencedColumnName = "messageId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Message message;

    public MessageReceiver()
    {
    }

    public MessageReceiver(MessageReceiverPK messageReceiverPK)
    {
        this.messageReceiverPK = messageReceiverPK;
    }

    public MessageReceiver(MessageReceiverPK messageReceiverPK, Date modifiedAt)
    {
        this.messageReceiverPK = messageReceiverPK;
        this.modifiedAt = modifiedAt;
    }

    public MessageReceiver(int messageId, String receiverId)
    {
        this.messageReceiverPK = new MessageReceiverPK(messageId, receiverId);
    }

    public MessageReceiverPK getMessageReceiverPK()
    {
        return messageReceiverPK;
    }

    public void setMessageReceiverPK(MessageReceiverPK messageReceiverPK)
    {
        this.messageReceiverPK = messageReceiverPK;
    }

    public Date getModifiedAt()
    {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt)
    {
        this.modifiedAt = modifiedAt;
    }

    public MessageStatus getStatusId()
    {
        return statusId;
    }

    public void setStatusId(MessageStatus statusId)
    {
        this.statusId = statusId;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Message getMessage()
    {
        return message;
    }

    public void setMessage(Message message)
    {
        this.message = message;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (messageReceiverPK != null ? messageReceiverPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageReceiver))
        {
            return false;
        }
        MessageReceiver other = (MessageReceiver) object;
        if ((this.messageReceiverPK == null && other.messageReceiverPK != null) || (this.messageReceiverPK != null && !this.messageReceiverPK.equals(other.messageReceiverPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.MessageReceiver[ messageReceiverPK=" + messageReceiverPK + " ]";
    }

    public static List<MessageReceiver> findMessagesReceivedByReceiverId(String receiverId)
    {
        List<MessageReceiver> messagesReceived = RedEntityManager.getEntityManager().createNamedQuery("MessageReceiver.findByReceiverId").setParameter("receiverId", receiverId).getResultList();

        return messagesReceived;
    }

    public String getSenderName()
    {
        return (message.getSenderId().getLastName() + ", " + message.getSenderId().getFirstName());
    }

    public String getDateTime()
    {
        return DateFormatter.formatDateTime(message.getDateTime());
    }

    public String getSubject()
    {
        return message.getSubject();
    }

    public String getBody()
    {
        return message.getMessageBody();
    }

    public String getStatusName()
    {
        return statusId.getName();
    }

    public static void refresh()
    {
        RedEntityManager.getEntityManager().refresh(RedEntityManager.getEntityByName("MessageReceiver"));
    }

    public void save()
    {
        RedEntityManager.save(this);
    }
}
