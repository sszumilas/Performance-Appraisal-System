/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XXX
 */
@Entity
@Cacheable(false)
@Table(name= "ENOTE", schema = "SOP")

@TableGenerator(name = "EnoteIdGen", table = "GENERATOR", pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", pkColumnValue = "Enote", initialValue = 200)
//@XmlRootElement
public class Enote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
//    @Column(nullable = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "EnoteIdGen")
    private Long id;
    @Size(max = 255)
//    @Column(length = 255)
    @Column(name = "ACHIEVEMENTS")
    private String achievements;
    @Size(max = 255)
//    @Column(length = 255)
    @Column(name = "ASPIRATION")
    private String aspiration;
//    @Temporal(TemporalType.DATE)
//    private Date date;
    @Size(max = 255)
//    @Column(length = 255)
    @Column(name = "IMPROVEMENT")
    private String improvement;
    @Column(name = "MOBILITY")
    private Short mobility;
    @Size(max = 255)
//    @Column(length = 255)
    @Column(name = "NACTIVITY")
    private String nactivity;
    @Size(max = 255)
//    @Column(length = 255)
    @Column(name = "PROMISES")
    private String promises;
    @Size(max = 255)
//    @Column(length = 255)
    @Column(name = "TARGET")
    private String target;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date saved;
    @JoinColumn(name = "EMPLOYEE_ID_FK", referencedColumnName = "ID")
    @ManyToOne
    private Account employeeIdFk;

    public Enote() {
    }

    public Enote(Long id) {
        this.id = id;
    }

    public Enote(Long id, Date saved) {
        this.id = id;
        this.saved = saved;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public String getImprovement() {
        return improvement;
    }

    public void setImprovement(String improvement) {
        this.improvement = improvement;
    }

    public Short getMobility() {
        return mobility;
    }

    public void setMobility(Short mobility) {
        this.mobility = mobility;
    }

    public String getNactivity() {
        return nactivity;
    }

    public void setNactivity(String nactivity) {
        this.nactivity = nactivity;
    }

    public String getPromises() {
        return promises;
    }

    public void setPromises(String promises) {
        this.promises = promises;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getSaved() {
        return saved;
    }

    public void setSaved(Date saved) {
        this.saved = saved;
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
        if (!(object instanceof Enote)) {
            return false;
        }
        Enote other = (Enote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.Enote[ id=" + id + " ]";
    }

    public boolean isConfirmed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setWhoCreate(Employee myAccountEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setWhoConfirmed(Manager myAccountManager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setConfirmed(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
