package pl.lodz.p.it.spjava.sop8.web.enote;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Enote;

/**
 *
 * @author java
 */
@ManagedBean(name = "createEnotePageBean")
@RequestScoped
public class CreateEnotePageBean {
    
    public CreateEnotePageBean() {
    }
    
    @ManagedProperty(value="#{enoteSession}")
    private EnoteSession enoteSession;

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }

    private Enote enote = new Enote();

    public Enote getEnote() {
        return enote;
    }

    public String createEnote() {
        return enoteSession.createEnote();
    }

    public String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
