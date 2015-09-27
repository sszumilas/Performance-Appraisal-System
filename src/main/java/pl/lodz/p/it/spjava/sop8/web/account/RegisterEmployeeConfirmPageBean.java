package pl.lodz.p.it.spjava.sop8.web.account;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Employee;

/**
 *
 * @author java
 */
@ManagedBean(name = "registerEmployeeConfirmPageBean")
@RequestScoped
public class RegisterEmployeeConfirmPageBean {
    
    public RegisterEmployeeConfirmPageBean() {
    }
    
    @PostConstruct
    private void initBean() {
        account = accountSession.getEmployeeRegistration();        
    }
    
    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    private Employee account;

    public Employee getAccount() {
        return account;
    }
        
    public String register() {
        return accountSession.registerEmployee();
    }

}
