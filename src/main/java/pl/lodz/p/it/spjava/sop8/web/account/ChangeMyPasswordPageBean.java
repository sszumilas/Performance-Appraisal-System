package pl.lodz.p.it.spjava.sop8.web.account;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Admin;
import pl.lodz.p.it.spjava.sop8.model.Employee;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;
import pl.lodz.p.it.spjava.sop8.web.utils.AccountUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "changeMyPasswordPageBean")
@RequestScoped
public class ChangeMyPasswordPageBean {
    
    public ChangeMyPasswordPageBean() {
    }
    
    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }
    
    private Account account = new Account();

    public Account getAccount() {
        return account;
    }
        
    private String passwordRepeat = "";

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
    
    public String oldPassword = "";

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    
    public String changePassword() {
        if (!(passwordRepeat.equals(account.getPassword()))){
            ContextUtils.emitInternationalizedMessage("changeMyPasswordForm:passwordRepeat", "passwords.not.matching");
            return null;
        }
            
        return accountSession.changeMyPassword(oldPassword, account.getPassword());
    }
    
}
