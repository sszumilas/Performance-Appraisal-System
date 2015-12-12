package pl.lodz.p.it.spjava.sop8.web.account;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountEndpoint;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.TeamEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AccountException;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.utils.AccountUtils;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

@ManagedBean(name = "createAccountPageBean")
@RequestScoped
public class CreateAccountPageBean {

    @EJB
    private AccountEndpoint accountEndpoint;

    @EJB
    private TeamEndpoint teamEndpoint;

    @PostConstruct
    public void init() {
        teamList = teamEndpoint.getAllTeam();
    }

    private Account account = new Account();

    private List<Team> teamList;

    public List<Team> getTeamList() {
        return teamList;
    }

    public Account getAccount() {
        return account;
    }

    private String passwordRepeat;

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String create() throws AppBaseException {
        try {
                
                           if (passwordRepeat==null || !(passwordRepeat.equals(account.getPassword()))){
                ContextUtils.emitInternationalizedMessage("createAccountForm:passwordRepeat", "passwords.not.matching");
                return null;
                
                
                
            }
            account.setPassword(AccountUtils.calculateHashPassword(passwordRepeat));
            accountEndpoint.createAccount(account);
            return "success";
        } catch (AccountException ae) {
            if (AccountException.KEY_DB_CONSTRAINT.equals(ae.getMessage())) {
                ContextUtils.emitInternationalizedMessage("createAccountForm:login", "login");
            } else {
                Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createAccount wyjatku: ", ae);
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createAccount wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null, abe.getMessage());
            }
            return null;
        }
    }

}
