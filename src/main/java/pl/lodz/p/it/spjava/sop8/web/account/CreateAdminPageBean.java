package pl.lodz.p.it.spjava.sop8.web.account;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pl.lodz.p.it.spjava.sop8.model.Admin;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "createAdminPageBean")
@RequestScoped
public class CreateAdminPageBean {
    
    public CreateAdminPageBean() {
    }
    
    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    private Admin account =  new Admin();

    public Admin getAccount() {
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
            ContextUtils.emitInternationalizedMessage("createAdminForm:passwordRepeat", "passwords.not.matching");
            return null;
        }
            
        return accountSession.createAdmin(account);
    }

}
