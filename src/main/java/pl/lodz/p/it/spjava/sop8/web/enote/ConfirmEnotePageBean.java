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
@ManagedBean(name = "confirmEnotePageBean")
@RequestScoped
public class ConfirmEnotePageBean {
    
    public ConfirmEnotePageBean() {
    }
    
    @PostConstruct
    private void initBean() {
        enote = enoteSession.getEnoteChange();        
    }
    
    @ManagedProperty(value="#{enoteSession}")
    private EnoteSession enoteSession;

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }

    private Enote enote;

    public Enote getEnote() {
        return enote;
    }

//    public String enoteEnote() {
//        return enoteSession.confirmUploadEnote();
//    }

}
