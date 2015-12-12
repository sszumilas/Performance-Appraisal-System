package pl.lodz.p.it.spjava.sop8.web.account;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Account;


@ManagedBean(name = "detailsMyAccountPageBean")
@RequestScoped
public class DetailsMyAccountPageBean {
    
    public DetailsMyAccountPageBean() {
    }
    
    @ManagedProperty(value="#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }
    
    @PostConstruct
    private void init() {
        account = accountSession.getMyAccount();
    }

    private Account account =  new Account();

    public Account getAccount() {
        return account;
    }

}
