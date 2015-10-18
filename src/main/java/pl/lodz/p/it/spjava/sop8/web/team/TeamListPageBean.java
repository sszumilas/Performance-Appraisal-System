package pl.lodz.p.it.spjava.sop8.web.team;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.account.AccountSession;
import pl.lodz.p.it.spjava.sop8.web.enote.EnoteSession;

/**
 *
 * @author java
 */
@ManagedBean(name = "teamListPageBean")
@RequestScoped
public class TeamListPageBean {
    public static final String GENERAL_MSG_ID="teamListForm:teamList";

    public TeamListPageBean() {
    }
        private String requestTeamName = "";

    public String getRequestTeamName() {
        return requestTeamName;
    }
    public void setRequestTeamName(String requestTeamName) {
        this.requestTeamName = requestTeamName;
    }
    public void refresh() {
        initModel();
    }

    public void clear() {
        requestTeamName = "";
    }
    
    
    @PostConstruct
    private void initModel() {
        team = teamSession.matchTeam(requestTeamName);
        teamDataModel = new ListDataModel<Team>(team);
    }
    @ManagedProperty(value = "#{teamSession}")
    private TeamSession teamSession;

    public void setTeamSession(TeamSession teamSession) {
        this.teamSession = teamSession;
    }
    private List<Team> team;
    private DataModel<Team> teamDataModel;

    public DataModel<Team> getTeamsDataModel() {
        return teamDataModel;
    }
    
}
    
    
    
//        private String teamDataModel;

    /**
     * Get the value of teamDataModel
     *
     * @return the value of teamDataModel
     */
//    public String getTeamDataModel() {
//        return teamDataModel;
//    }
//
//    /**
//     * Set the value of teamDataModel
//     *
//     * @param teamDataModel new value of teamDataModel
//     */
//    public void setTeamDataModel(String teamDataModel) {
//        this.teamDataModel = teamDataModel;
//    }

//@PostConstruct
//public void init() {
//    teamDataModel = new TeamListPageBean() teamListModel<Team>(teams);
//    teams = new team();
//}    
 
    
    
    
    
//        @PostConstruct
//public void init() {
//    teamName = new TeamName();

//    public TeamListPageBean(String teamDataModel) {
//        this.teamDataModel = teamDataModel;
//    }
//}
    
    
//    @PostConstruct
//    private void initModel() {
//        produkty = produktSession.znajdzBedaceNaStanie();
//        produktyDataModel = new ListDataModel<Produkt>(produkty);
//    }
//    @ManagedProperty(value = "#{teamSession}")
//    private TeamSession teamSession;
//
//    @ManagedProperty(value = "#{enoteeSession}")
//    private EnoteSession enoteSession;
//
//    public void setTeamSession(TeamSession teamSession) {
//        this.teamSession = teamSession;
//    }
//
//    public void setEnoteSession(EnoteSession enoteSession) {
//        this.enoteSession = enoteSession;
//    }
//    
//    private List<Team> teams;
//    private DataModel<Team> teamsDataModel;
//
//    public DataModel<Team> getTeamsDataModel() {
//        return teamsDataModel;
//    }
//    
//    public void dodajDoZamowienia() {
//        zamowienieSession.dodajPozycjeDoZamowienia(produktyDataModel.getRowData());
//    }


