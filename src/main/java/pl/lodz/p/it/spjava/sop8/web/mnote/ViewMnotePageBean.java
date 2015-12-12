package pl.lodz.p.it.spjava.sop8.web.mnote;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

@ManagedBean(name = "viewMnotePageBean")
@RequestScoped
public class ViewMnotePageBean {

    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;

    @PostConstruct
    public void init() {
        mnote = mnoteSession.getMnoteView();
    }

    private Mnote mnote;

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }

    public Mnote getMnote() {
        return mnote;
    }
}
