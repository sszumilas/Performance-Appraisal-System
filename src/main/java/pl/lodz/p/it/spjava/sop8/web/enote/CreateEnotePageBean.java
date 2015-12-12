package pl.lodz.p.it.spjava.sop8.web.enote;

import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Enote;


@ManagedBean(name = "createEnotePageBean")
@RequestScoped
public class CreateEnotePageBean {
    
  @ManagedProperty(value="#{enoteSession}")
    private EnoteSession enoteSession;

    private Enote enote = new Enote();

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }
    
    public Enote getEnote() {
        return enote;
    }

    public void setEnote(Enote enote) {
        this.enote = enote;
    }
    
    public boolean renderEnote(){
        return enoteSession.renderEnote();
    }

    public String createEnote() {
        Long year =(long) Calendar.getInstance().get(Calendar.YEAR);
        enote.setNoteYear(year);
        enote.setSaved(new Date());
        enoteSession.createEnote(enote);
        return "success";
    }
}
