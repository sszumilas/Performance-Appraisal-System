package pl.lodz.p.it.spjava.sop8.web.account;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.web.utils.AccountUtils;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

@ManagedBean(name = "changePasswordAccountPageBean")
@RequestScoped
public class ChangePasswordAccountPageBean {

    @ManagedProperty(value = "#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    @PostConstruct
    private void init() {
        account = accountSession.getUserAccount();
        passwordRepeat="";
    }

    private Account account;

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

    public String changePassword() throws AppBaseException {
                
           if (passwordRepeat==null || !(passwordRepeat.equals(account.getPassword()))){
                ContextUtils.emitInternationalizedMessage("changePasswordAccountForm:passwordRepeat", "passwords.not.matching");
                return null;
               
//           }
                
          
        }
        account.setPassword(AccountUtils.calculateHashPassword(passwordRepeat));
        accountSession.edit(account);
        accountSession.construct();
        return "success";
    }
}


