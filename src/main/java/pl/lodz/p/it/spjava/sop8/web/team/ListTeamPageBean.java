package pl.lodz.p.it.spjava.sop8.web.team;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.TeamEndpoint;
import pl.lodz.p.it.spjava.sop8.model.Team;

@ManagedBean(name = "listTeamPageBean")
@RequestScoped
public class ListTeamPageBean {

    public static final String GENERAL_MSG_ID = "teamListForm:teamList";

    public ListTeamPageBean() {
    }
    private List<Team> listTeam;
    
    @ManagedProperty(value="#{teamSession}")
    private TeamSession teamSession;
    
    @PostConstruct
    private void initModel() {
        listTeam = teamSession.getAllTeam();
    }

    public Team addTeam;

    public Team getAddTeam() {
        return addTeam;
    }

    public void setAddTeam(Team addTeam) {
        this.addTeam = addTeam;
    }

    public TeamSession getTeamSession() {
        return teamSession;
    }

    public void setTeamSession(TeamSession teamSession) {
        this.teamSession = teamSession;
    }
    
    public List<Team> getListTeam() {
        return listTeam;
    }
    
    public String editTeam(Team team){
        teamSession.setTeamEdit(team);
        return "editTeam";
    }
    
    public String deleteTeam(Team team){
            teamSession.deleteTeam(team);
        return "success";
    }
    
}

