/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

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
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name= "Mnote")
@TableGenerator(name = "MnoteIdGen", table = "GENERATOR", pkColumnName = "ENTITY_NAME",
        valueColumnName = "ID_RANGE", pkColumnValue = "Mnote", initialValue = 200)
@NamedQueries({
    @NamedQuery(name = "Mnote.findByUser", query = "SELECT a FROM Mnote a WHERE a.employeeIdFk.id = :x"),
    @NamedQuery(name = "Mnote.isNoted", query = "SELECT a FROM Mnote a WHERE a.employeeIdFk.id = :x AND a.noteYear = :y"),
    @NamedQuery(name = "Mnote.findByYear", query = "SELECT a FROM Mnote a WHERE a.employeeIdFk.id = :x AND a.noteYear = :y")})
public class Mnote extends AbstractEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, 
            generator = "MnoteIdGen")
    @Column(nullable = false)
    private Long id;
    
    @Size(max = 255)
    @Column(length = 255)
    private String achievements;
    
    @Size(max = 255)
    @Column(length = 255)
    private String aspiration;
    
    @Size(max = 255)
    @Column(length = 255)
    private String improvement;
    
    @Size(max = 255)
    @Column(length = 255)
    private String nactivity;
    
    @Column
    private Short note;
    
    @Column
    private Short noteA;
    
    @Column
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
    
    @Basic(optional = false)
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date modification;
    
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmation;
    
    @NotNull
    @Column(nullable = false)
    private Long noteYear;
    
    @JoinColumn(name = "MODIFICATION_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account modificationId;
    
    @JoinColumn(name = "CONFIRM_ID", referencedColumnName = "ID")
    @ManyToOne
    @NotNull
    private Account confirmId;
    
    @JoinColumn(name = "EMPLOYEE_ID_FK", referencedColumnName = "ID")
    @ManyToOne
    @NotNull
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
    
    public Short getNoteA() {
        return noteA;
    }

    public void setNoteA(Short noteA) {
        this.noteA = noteA;
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

    public Long getNoteYear() {
        return noteYear;
    }

    public void setNoteYear(Long noteYear) {
        this.noteYear = noteYear;
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
    
    
}
