package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.model.Mnote;
import pl.lodz.p.it.spjava.sop8.web.enote.EnoteSession;


@ManagedBean(name = "mnotesListPageBean")
@RequestScoped
public class MnotesListPageBean {
    
    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;
    
    @ManagedProperty(value = "#{enoteSession}")
    private EnoteSession enoteSession;
    
    @PostConstruct
    private void initModel() {
        mnoteList = mnoteSession.pullMnoteList();
        enoteList = mnoteSession.pullEnoteList();
    }
    
    private List<Mnote> mnoteList;
    private List<Enote> enoteList;

    public List<Enote> getEnoteList() {
        return enoteList;
    }
    
    public List<Mnote> getMnoteList() {
        return mnoteList;
    }

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }
    
    public boolean disabled(Mnote mnote){
       Long currentYear =(long) Calendar.getInstance().get(Calendar.YEAR);
        return !Objects.equals(mnote.getNoteYear(), currentYear);
    }

    public String edit(Mnote mnote){
        mnoteSession.setMnoteEdit(mnote);
        return "editMnote";
    }
    
    public String viewMnote(Mnote mnote){
        mnoteSession.setMnoteView(mnote);
        return "viewMnote";
    }
    
    public String viewEnote(Enote enote){
        enoteSession.setEnoteView(enote);
        return "viewEnote";
    }
    
    public String report(Mnote mnote){
        mnoteSession.setMnoteReport(mnote);
        enoteSession.pullEnote(mnote.getEmployeeIdFk(), mnote.getNoteYear());
        return "viewReport";
    }
}


