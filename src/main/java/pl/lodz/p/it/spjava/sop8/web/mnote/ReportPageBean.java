package pl.lodz.p.it.spjava.sop8.web.mnote;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.model.Mnote;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.enote.EnoteSession;


@ManagedBean(name = "reportPageBean")
@RequestScoped
public class ReportPageBean {
    
    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;
    
    @ManagedProperty(value = "#{enoteSession}")
    private EnoteSession enoteSession;
    
    @PostConstruct
    private void initModel() {
        mnote = mnoteSession.getMnoteReport();
        enote = enoteSession.getEnoteReport();
        account = mnote.getEmployeeIdFk();
        team = account.getTeamIdFk();
    }
    
    private Account account;
    private Mnote mnote;
    private Enote enote;
    private Team team;
    
    public Mnote getMnote() {
        return mnote;
    }

    public Enote getEnote() {
        return enote;
    }

    public Account getAccount() {
        return account;
    }

    public Team getTeam() {
        return team;
    }
    
    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }
    
    
}


