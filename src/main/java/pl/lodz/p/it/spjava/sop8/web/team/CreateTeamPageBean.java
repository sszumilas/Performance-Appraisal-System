package pl.lodz.p.it.spjava.sop8.web.team;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Team;

@ManagedBean(name = "createTeamPageBean")
@RequestScoped
public class CreateTeamPageBean {

    public CreateTeamPageBean() {
    }

    @ManagedProperty(value = "#{teamSession}")
    private TeamSession teamSession;

    public void setTeamSession(TeamSession teamSession) {
        this.teamSession = teamSession;
    }
    private Team team = new Team();
//    @PostConstruct
//    public void init() {
//        team = new Team();
//        
//    }
    public Team getTeam() {
        return team;
    }
    
    public String createTeam() {
        try {
            return teamSession.createTeam();
        } catch (AppBaseException ex) {
            Logger.getLogger(CreateTeamPageBean.class.getName()).log(Level.SEVERE, null, ex);
        return null;
            
        }
    }
}

