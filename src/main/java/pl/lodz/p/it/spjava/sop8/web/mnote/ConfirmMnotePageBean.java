package pl.lodz.p.it.spjava.sop8.web.mnote;

import pl.lodz.p.it.spjava.sop8.web.mnote.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Mnote;


@ManagedBean(name = "confirmMnotePageBean")
@RequestScoped
public class ConfirmMnotePageBean {
    
    public ConfirmMnotePageBean() {
    }
    
//    @PostConstruct
//    private void initBean() {
//        mnote = mnoteSession.getMnoteChange();        
//    }
//    
//    @ManagedProperty(value="#{mnoteSession}")
//    private MnoteSession mnoteSession;
//
//    public void setMnoteSession(MnoteSession mnoteSession) {
//        this.mnoteSession = mnoteSession;
//    }
//
//    private Mnote mnote;
//
//    public Mnote getMnote() {
//        return mnote;
//    }
//
//    public String mnoteMnote() {
//        return mnoteSession.confirmUploadMnote();
//    }

}
