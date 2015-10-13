package pl.lodz.p.it.spjava.sop8.web.team;

import pl.lodz.p.it.spjava.sop8.web.enote.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.model.Team;

@ManagedBean(name = "createTeamPageBean")
@RequestScoped
public class CreateTeamPageBean {
    
    public CreateTeamPageBean() {
    }
    
    @ManagedProperty(value="#{teamSession}")
    private TeamSession teamSession;

    public void setTeamSession(TeamSession teamSession) {
        this.teamSession = teamSession;
    }

    private Team team;

    public Team getTeam() {
        return teamSession.getTeamCreate();
    }

    public String createTeam() throws AppBaseException {
        return teamSession.createTeam();
    }

    @PostConstruct
public void init() {
    team = new Team();
}
    
    
//    public String account;
//
//    /**
//     * Get the value of account
//     *
//     * @return the value of account
//     */
//    public String getAccount() {
//        return account;
//    }
//
//    /**
//     * Set the value of account
//     *
//     * @param account new value of account
//     */
//    public void setAccount(String account) {
//        this.account = account;
//    }

}
