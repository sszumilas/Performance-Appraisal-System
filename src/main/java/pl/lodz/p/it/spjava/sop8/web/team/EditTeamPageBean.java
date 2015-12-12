package pl.lodz.p.it.spjava.sop8.web.team;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.TeamException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

@ManagedBean(name = "editTeamPageBean")
@RequestScoped
public class EditTeamPageBean {

    public EditTeamPageBean() {
    }

    @ManagedProperty(value = "#{teamSession}")
    private TeamSession teamSession;

    @PostConstruct
    public void construct() {
        team = teamSession.getTeamEdit();
        accountList = teamSession.getAllOfType("Manager");
    }

    private Team team;

    private List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TeamSession getTeamSession() {
        return teamSession;
    }

    public void setTeamSession(TeamSession teamSession) {
        this.teamSession = teamSession;
    }

    public String editTeam() {
        try {
            teamSession.editTeam(team);
            return "success";
        } catch (AppBaseException ex) {
            if (TeamException.KEY_DB_CONSTRAINT.equals(ex.getMessage())) {
                ContextUtils.emitInternationalizedMessage("teamName", TeamException.KEY_DB_CONSTRAINT);
            } else {
                Logger.getLogger(TeamSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createTeam wyjatku: ", ex);
            }
            return null;
        }
    }
}
