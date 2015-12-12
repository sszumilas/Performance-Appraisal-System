package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Mnote;


@ManagedBean(name = "editMnotePageBean")
@RequestScoped
public class EditMnotePageBean {
    
  @ManagedProperty(value="#{mnoteSession}")
    private MnoteSession mnoteSession;

  @PostConstruct
  public void init(){
      mnote = mnoteSession.getMnoteEdit();
  }
  
    private Mnote mnote;

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }
    
    public Mnote getMnote() {
        return mnote;
    }

    public void setMnote(Mnote mnote) {
        this.mnote = mnote;
    }

    public String editMnote() throws AppBaseException {
        mnote.setModification(new Date());
        mnoteSession.editMnote(mnote);
        return "success";
    }
}
