package pl.lodz.p.it.spjava.sop8.web.account;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;


@ManagedBean(name = "editAccountPageBean")
@RequestScoped
public class EditAccountPageBean {
    
    public EditAccountPageBean() {
    }
    
    @PostConstruct
    private void init() {
        account = accountSession.getAccountEdit();
        teamList = accountSession.getTeamList();
    }

    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;
    
    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    private Account account =  new Account();

    private List<Team> teamList;

    public List<Team> getTeamList() {
        return teamList;
    }
    
    public Account getAccount() {
        return account;
    }
    
    public String saveAccount() throws AppBaseException {
            accountSession.edit(account);
            return "success";
    }

}
