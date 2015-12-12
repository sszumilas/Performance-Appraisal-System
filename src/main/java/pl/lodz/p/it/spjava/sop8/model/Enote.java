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
//@Cacheable(false)
@Table(name = "Enote")
@TableGenerator(name = "EnoteIdGen", table = "GENERATOR", pkColumnName = "ENTITY_NAME",
        valueColumnName = "ID_RANGE", pkColumnValue = "Enote", initialValue = 200)
@NamedQueries({
    @NamedQuery(name = "Enote.findByUser", query = "SELECT a FROM Enote a WHERE a.employeeIdFk.id = :x"),
    @NamedQuery(name = "Enote.findByYear", query = "SELECT a FROM Enote a WHERE a.employeeIdFk.id = :x AND a.noteYear = :y")})
public class Enote extends AbstractEntity implements Serializable {

    public Enote() {
    }

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "EnoteIdGen")
    private Long id;

    @Size(max = 255)
    @Column(length = 255)
    private String achievements;

    @Size(max = 255)
    @Column(length = 255)
    private String aspiration;
    
    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;

    @Size(max = 255)
    @Column(length = 255)
    private String improvement;

    @Column
    private Short mobility;

    @Size(max = 255)
    @Column(length = 255)
    private String nactivity;

    @Size(max = 255)
    @Column(length = 255)
    private String promises;

    @Size(max = 255)
    @Column(length = 255)
    private String target;

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date saved;
    
    @NotNull
    @Column(nullable = false)
    private Long noteYear;

    @JoinColumn(name = "EMPLOYEE_ID_FK", referencedColumnName = "ID")
    @ManyToOne
    private Account employeeIdFk;

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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getImprovement() {
        return improvement;
    }

    public Long getNoteYear() {
        return noteYear;
    }

    public void setNoteYear(Long year) {
        this.noteYear = year;
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

}
