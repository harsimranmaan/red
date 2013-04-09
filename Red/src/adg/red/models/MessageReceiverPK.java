/*
 * 
 * 
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author harsimran.maan
 */
@Embeddable
public class MessageReceiverPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "messageId")
    private int messageId;
    @Basic(optional = false)
    @Column(name = "receiverId")
    private String receiverId;

    public MessageReceiverPK()
    {
    }

    public MessageReceiverPK(int messageId, String receiverId)
    {
        this.messageId = messageId;
        this.receiverId = receiverId;
    }

    public int getMessageId()
    {
        return messageId;
    }

    public void setMessageId(int messageId)
    {
        this.messageId = messageId;
    }

    public String getReceiverId()
    {
        return receiverId;
    }

    public void setReceiverId(String receiverId)
    {
        this.receiverId = receiverId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) messageId;
        hash += (receiverId != null ? receiverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessageReceiverPK))
        {
            return false;
        }
        MessageReceiverPK other = (MessageReceiverPK) object;
        if (this.messageId != other.messageId)
        {
            return false;
        }
        if ((this.receiverId == null && other.receiverId != null) || (this.receiverId != null && !this.receiverId.equals(other.receiverId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.MessageReceiverPK[ messageId=" + messageId + ", receiverId=" + receiverId + " ]";
    }
}
