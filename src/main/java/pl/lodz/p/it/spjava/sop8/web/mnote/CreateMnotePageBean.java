package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

@ManagedBean(name = "createMnotePageBean")
@RequestScoped
public class CreateMnotePageBean {
    
  @ManagedProperty(value="#{mnoteSession}")
    private MnoteSession mnoteSession;

  @PostConstruct
  public void init(){
      enote = mnoteSession.findEnote(mnoteSession.getNoteAccount(), (long) Calendar.getInstance().get(Calendar.YEAR));
  }
  
    private Mnote mnote = new Mnote();
    private Enote enote;

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }
    
    public Mnote getMnote() {
        return mnote;
    }

    public void setMnote(Mnote mnote) {
        this.mnote = mnote;
    }

    public Enote getEnote() {
        return enote;
    }
    
    public String createMnote() {
        Long year =(long) Calendar.getInstance().get(Calendar.YEAR);
        mnote.setNoteYear(year);
        mnote.setConfirmId(mnoteSession.getUserAccount());
        mnote.setEmployeeIdFk(mnoteSession.getNoteAccount());
        mnote.setConfirmation(new Date());
        mnoteSession.createMnote(mnote);
        return "success";
    }
}
