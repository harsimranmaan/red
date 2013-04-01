/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "FAQ")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Faq.findAll", query = "SELECT f FROM Faq f"),
    @NamedQuery(name = "Faq.findByQuestion", query = "SELECT f FROM Faq f WHERE f.question = :question"),
    @NamedQuery(name = "Faq.findByAnswer", query = "SELECT f FROM Faq f WHERE f.answer = :answer")
})
public class Faq implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @Column(name = "answer")
    private String answer;

    public Faq()
    {
    }

    public Faq(String question)
    {
        this.question = question;
    }

    public Faq(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (question != null ? question.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faq))
        {
            return false;
        }
        Faq other = (Faq) object;
        if ((this.question == null && other.question != null) || (this.question != null && !this.question.equals(other.question)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Faq[ question=" + question + " ]";
    }
    
    public static List<Faq> getAllFaq() 
    {
       return RedEntityManager.getEntityManager().createNamedQuery("Faq.findAll").getResultList();
    }
}
