package pl.lodz.p.it.spjava.sop8.web.mnote;

import pl.lodz.p.it.spjava.sop8.web.mnote.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

/**
 *
 * @author java
 */
@ManagedBean(name = "createMnotePageBean")
@RequestScoped
public class CreateMnotePageBean {
    
    public CreateMnotePageBean() {
    }
    
    @ManagedProperty(value="#{mnoteSession}")
    private MnoteSession mnoteSession;

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }

    private Mnote mnote;

    public Mnote getMnote() {
        return mnoteSession.getMnoteCreate();
    }

    public String createMnote() {
        return mnoteSession.createMnote();
    }

    public String account;

    /**
     * Get the value of account
     *
     * @return the value of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Set the value of account
     *
     * @param account new value of account
     */
    public void setAccount(String account) {
        this.account = account;
    }

}
