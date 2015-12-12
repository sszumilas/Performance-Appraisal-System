package pl.lodz.p.it.spjava.sop8.web.account;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountEndpoint;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.TeamEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

@ManagedBean(name = "accountSession")
@SessionScoped
public class AccountSession implements Serializable {

    @EJB
    private AccountEndpoint accountEndpoint;

    @EJB
    private TeamEndpoint teamEndpoint;
    
    public String resetSession() {
        ContextUtils.invalidateSession();
        return "cancelAction";
    }

    @PostConstruct
    public void construct() {
        userAccount = getMyAccount();
    }

    private Account accountEdit;

    
    private Account userAccount;
    
    public Account getAccountEdit() {
        return accountEdit;
    }

    public List<Team> getTeamList() {
        return teamEndpoint.getAllTeam();
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void edit(Account account) throws AppBaseException {
        accountEndpoint.edit(account);
    }

    public void activateAccount(Account Account) {
        accountEndpoint.activateAccount(Account);
        ContextUtils.emitSuccessMessage(AccountsListPageBean.GENERAL_MSG_ID);
    }

    public void deactivateAccount(Account Account) {
        accountEndpoint.deactivateAccount(Account);
        ContextUtils.emitSuccessMessage(AccountsListPageBean.GENERAL_MSG_ID);
    }

    public void confirmAccount(Account Account) {
        accountEndpoint.confirmAccount(Account);
        ContextUtils.emitSuccessMessage(AccountsListPageBean.GENERAL_MSG_ID);
    }

    public String getAccountToEdit(Account Account) {
        accountEdit = accountEndpoint.getAccountToEdit(Account);
        return "editAccount";
    }

    public List<Account> getAllAccounts() {
        return accountEndpoint.getAllAccounts();
    }
    
    public List<Account> getAccounts() {
        return accountEndpoint.getAccounts(userAccount);
    }

    
    public Account getMyAccount() {
        return accountEndpoint.getMyAccount();
    }
}
