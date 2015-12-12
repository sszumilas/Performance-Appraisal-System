package pl.lodz.p.it.spjava.sop8.web.enote;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Enote;


@ManagedBean(name = "editEnotePageBean")
@RequestScoped
public class EditEnotePageBean {
    
  @ManagedProperty(value="#{enoteSession}")
    private EnoteSession enoteSession;

  @PostConstruct
  public void init(){
      enote = enoteSession.getEnoteEdit();
  }
  
    private Enote enote;

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }
    
    public Enote getEnote() {
        return enote;
    }

    public void setEnote(Enote enote) {
        this.enote = enote;
    }

    public String editEnote() throws AppBaseException {
        enote.setSaved(new Date());
        enoteSession.editEnote(enote);
        return "success";
    }
}
