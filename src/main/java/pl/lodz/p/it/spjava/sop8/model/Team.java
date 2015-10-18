/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author XXX
 */
@Entity
//@MappedSuperclass
@Table(name = "Team")
//@NamedQueries({
//    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
////    @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id"),
//    @NamedQuery(name = "Team.findByTeamName", query = "SELECT t FROM Team t WHERE t.teamName = :teamName")})



@TableGenerator(name = "TeamIdGen", table = "GENERATOR", pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", pkColumnValue = "Team", initialValue = 300)
//@XmlRootElement
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TeamIdGen")
    private Long id;
    @Size(min = 1, max = 255)
    @Column(name = "team_name", nullable = false, length = 255)
    private String teamName;
    @OneToMany(mappedBy = "teamIdFk")
    private List<Personaldata> personaldataList;
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

    @XmlTransient
    public List<Personaldata> getPersonaldataList() {
        return personaldataList;
    }

    public void setPersonaldataList(List<Personaldata> personaldataList) {
        this.personaldataList = personaldataList;
    }

    public Account getTeamManagerIdFk() {
        return teamManagerIdFk;
    }

    public void setTeamManagerIdFk(Account teamManagerIdFk) {
        this.teamManagerIdFk = teamManagerIdFk;
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
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.Team[ id=" + id + " ]";
    }

}
