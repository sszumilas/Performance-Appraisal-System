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
@ManagedBean(name = "changePasswordAccountPageBean")
@RequestScoped
public class ChangePasswordAccountPageBean {
    
    public ChangePasswordAccountPageBean() {
    }
    
    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }
    
    private Account account;

    public Account getAccount() {
        return account;
    }
    
    @PostConstruct
    private void init(){
        account = accountSession.getAccountChangePassword();
        account.setPassword(new String());
    }
    
    private String passwordRepeat = "";

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepat) {
        this.passwordRepeat = passwordRepeat;
    }
    
    public String changePassword() {
        if (!(passwordRepeat.equals(account.getPassword()))){
            ContextUtils.emitInternationalizedMessage("changePasswordAccountForm:passwordRepeat", "passwords.not.matching");
            return null;
        }
            
        return accountSession.changePasswordAccount(account.getPassword());
    }
    
}
