/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XXX
 */
@MappedSuperclass
@Table(catalog = "", schema = "SOP")
@XmlRootElement
public class Mnote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(length = 255)
    private String achievements;
    @Size(max = 255)
    @Column(length = 255)
    private String aspiration;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 255)
    @Column(length = 255)
    private String improvement;
    @Size(max = 255)
    @Column(length = 255)
    private String nactivity;
    private Short note;
    private Short potent;
    @Size(max = 255)
    @Column(length = 255)
    private String promises;
    @Size(max = 255)
    @Column(length = 255)
    private String summary;
    @Size(max = 255)
    @Column(length = 255)
    private String target;
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modification;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmation;
    @JoinColumn(name = "MODIFICATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account modificationId;
    @JoinColumn(name = "CONFIRM_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account confirmId;
    @JoinColumn(name = "EMPLOYEE_ID_FK", referencedColumnName = "ID")
    @ManyToOne
    private Account employeeIdFk;

    public Mnote() {
    }

    public Mnote(Long id) {
        this.id = id;
    }

    public Mnote(Long id, Date modification, Date confirmation) {
        this.id = id;
        this.modification = modification;
        this.confirmation = confirmation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getAspiration() {
        return aspiration;
    }

    public void setAspiration(String aspiration) {
        this.aspiration = aspiration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImprovement() {
        return improvement;
    }

    public void setImprovement(String improvement) {
        this.improvement = improvement;
    }

    public String getNactivity() {
        return nactivity;
    }

    public void setNactivity(String nactivity) {
        this.nactivity = nactivity;
    }

    public Short getNote() {
        return note;
    }

    public void setNote(Short note) {
        this.note = note;
    }

    public Short getPotent() {
        return potent;
    }

    public void setPotent(Short potent) {
        this.potent = potent;
    }

    public String getPromises() {
        return promises;
    }

    public void setPromises(String promises) {
        this.promises = promises;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Date getModification() {
        return modification;
    }

    public void setModification(Date modification) {
        this.modification = modification;
    }

    public Date getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Date confirmation) {
        this.confirmation = confirmation;
    }

    public Account getModificationId() {
        return modificationId;
    }

    public void setModificationId(Account modificationId) {
        this.modificationId = modificationId;
    }

    public Account getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(Account confirmId) {
        this.confirmId = confirmId;
    }

    public Account getEmployeeIdFk() {
        return employeeIdFk;
    }

    public void setEmployeeIdFk(Account employeeIdFk) {
        this.employeeIdFk = employeeIdFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mnote)) {
            return false;
        }
        Mnote other = (Mnote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.Mnote[ id=" + id + " ]";
    }
    
}
