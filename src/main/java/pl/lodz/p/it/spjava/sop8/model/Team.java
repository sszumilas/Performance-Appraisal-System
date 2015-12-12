package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Team")
@NamedQueries({
    @NamedQuery(name = "Team.findManager", query = "SELECT t FROM Team t WHERE t.teamManagerIdFk.id = :x")})



@TableGenerator(name = "TeamIdGen", table = "GENERATOR", pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", pkColumnValue = "Team", initialValue = 300)
public class Team extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TeamIdGen")
    private Long id;
    
    @Size(min = 1, max = 255)
    @Column(name = "team_name", nullable = false, length = 255, unique = true)
    @NotNull(message="{constraint.notnull.team}")
    private String teamName;
    
    @OneToMany(mappedBy = "teamIdFk")
    private List<Account> accountList;
    
    @JoinColumn(name = "team_manager_id_fk", referencedColumnName = "id")
    @ManyToOne
    private Account teamManagerIdFk;

    public Team() {
    }

    public Team(Long id) {
        this.id = id;
    }

    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Account getTeamManagerIdFk() {
        return teamManagerIdFk;
    }

    public void setTeamManagerIdFk(Account teamManagerIdFk) {
        this.teamManagerIdFk = teamManagerIdFk;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    
}
