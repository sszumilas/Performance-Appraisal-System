package pl.lodz.p.it.spjava.sop8.web.account;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import pl.lodz.p.it.spjava.sop8.model.Employee;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "registerEmployeePageBean")
@RequestScoped
public class RegisterEmployeePageBean {
    
    public RegisterEmployeePageBean() {
    }
    
    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    private Employee account =  new Employee();

    public Employee getAccount() {
        return account;
    }
    
    private String passwordRepeat = "";

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
    
    public String confirmRegistration() {
        if (!(passwordRepeat.equals(account.getPassword()))){
            ContextUtils.emitInternationalizedMessage("registerEmployeeForm:passwordRepeat", "passwords.not.matching");
            return null;
        }
            
        return accountSession.confirmRegistrationEmployee(account);
    }

}
