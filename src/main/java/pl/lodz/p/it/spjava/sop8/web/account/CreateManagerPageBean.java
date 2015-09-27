package pl.lodz.p.it.spjava.sop8.web.account;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pl.lodz.p.it.spjava.sop8.model.Employee;
import pl.lodz.p.it.spjava.sop8.model.Manager;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "createManagerPageBean")
@RequestScoped
public class CreateManagerPageBean {
    
    public CreateManagerPageBean() {
    }
    
    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    private Manager account =  new Manager();

    public Manager getAccount() {
        return account;
    }

    private String passwordRepeat = "";

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
    
    public String create() {
        if (!(passwordRepeat.equals(account.getPassword()))){
            ContextUtils.emitInternationalizedMessage("createManagerForm:passwordRepeat", "passwords.not.matching");
            return null;
        }
            
        return accountSession.createManager(account);
    }

}
