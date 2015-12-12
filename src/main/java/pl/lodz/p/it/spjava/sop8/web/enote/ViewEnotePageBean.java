package pl.lodz.p.it.spjava.sop8.web.enote;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Enote;


@ManagedBean(name = "viewEnotePageBean")
@RequestScoped
public class ViewEnotePageBean {
    
  @ManagedProperty(value="#{enoteSession}")
    private EnoteSession enoteSession;

  @PostConstruct
  public void init(){
      enote = enoteSession.getEnoteView();
  }
  
    private Enote enote;

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }
    
    public Enote getEnote() {
        return enote;
    }
}
