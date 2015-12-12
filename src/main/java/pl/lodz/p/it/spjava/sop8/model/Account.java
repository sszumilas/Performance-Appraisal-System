package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Account")
@SecondaryTable(name = "PersonalData")
@TableGenerator(name = "AccountIdGen", table = "GENERATOR", 
        pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", 
        pkColumnValue = "Account", initialValue = 100)
@NamedQueries({
    @NamedQuery(name = "Account.findByType", query = "SELECT a FROM Account a WHERE a.type = :x"),
    @NamedQuery(name = "Account.findAccounts", query = "SELECT a FROM Account a WHERE a.teamIdFk.id = :x")})
public class Account extends AbstractEntity implements Serializable {

    public Account() {
    }

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, 
            generator = "AccountIdGen")
    private Long id;

    @NotNull(message = "{constraint.notnull.login}")
    @Size(min = 6, message = "{constraint.string.length.tooshort}")
    @Column(name = "login", length = 32, nullable = false, unique = true, 
            updatable = false)
    private String login;
    
    @NotNull(message = "{constraint.notnull.password}")
    @Size(min = 8, message = "{constraint.string.length.tooshort}")
    @Column(name = "password", length = 255, nullable = false)
    private String password;
    
    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;

    @Column(name = "active", nullable = false)
    private boolean active;

    @NotNull(message = "{constraint.notnull}")
    @Column(name = "types", updatable = false, nullable = false)
    private String type;
    
    @JoinColumn(name = "TEAM_ID_FK", referencedColumnName = "ID")
    @ManyToOne
    private Team teamIdFk;

    @OneToMany(mappedBy = "employeeIdFk")
    private List<Enote> enoteList;
    
    @OneToMany(mappedBy = "teamManagerIdFk")
    private List<Team> teamList;
    
    @OneToMany(mappedBy = "modificationId")
    private List<Mnote> mnoteListModifier;
    
    @OneToMany(mappedBy = "confirmId")
    private List<Mnote> mnoteListConfirm;
    
    @OneToMany(mappedBy = "employeeIdFk")
    private List<Mnote> mnoteListEmployee;
    
    @NotNull(message="{constraint.notnull.name}")
    @Size(min=3,max=32,message="{constraint.string.length.notinrange}")
    @Column(name = "named", table = "PersonalData", length = 32, nullable = false)
    private String name;

    @NotNull(message="{constraint.notnull.surname}")
    @Size(min=3,max=32,message="{constraint.string.length.notinrange}")
    @Column(name = "surname", table = "PersonalData", length = 32, nullable = false)
    private String surname;

    @NotNull(message="{constraint.notnull.email}")
    @Size(min=6,max=64,message="{constraint.string.length.notinrange}")
    @Pattern(regexp="^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$",message="{constraint.string.incorrectemail}")
    @Column(name = "email", table = "PersonalData", length = 64, nullable = false)
    private String email;
        
    @Size(max=12,message="{constraint.string.length.toolong}")
    @Column(name = "telephone", table = "PersonalData", length = 12, nullable = true)
    private String telephone;
    
    
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Account(Long id) {
        this.id = id;
    }

    @XmlTransient
    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @XmlTransient
    public List<Mnote> getMnoteListModifier() {
        return mnoteListModifier;
    }

    public void setMnoteListModifier(List<Mnote> mnoteList) {
        this.mnoteListModifier = mnoteList;
    }

    @XmlTransient
    public List<Mnote> getMnoteListConfirm() {
        return mnoteListConfirm;
    }

    public void setMnoteListConfirm(List<Mnote> mnoteListConfirm) {
        this.mnoteListConfirm = mnoteListConfirm;
    }

    @XmlTransient
    public List<Mnote> getMnoteListEmployee() {
        return mnoteListEmployee;
    }

    public void setMnoteListEmployee(List<Mnote> mnoteListEmployee) {
        this.mnoteListEmployee = mnoteListEmployee;
    }

    public Team getTeamIdFk() {
        return teamIdFk;
    }

    public void setTeamIdFk(Team teamIdFk) {
        this.teamIdFk = teamIdFk;
    }

    public List<Enote> getEnoteList() {
        return enoteList;
    }

    public void setEnoteList(List<Enote> enoteList) {
        this.enoteList = enoteList;
    }
    
}
