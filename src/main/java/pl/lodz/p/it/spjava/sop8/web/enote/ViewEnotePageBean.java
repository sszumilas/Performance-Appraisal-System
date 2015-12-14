package pl.lodz.p.it.spjava.sop8.web.enote;

import java.util.HashMap;
import java.util.Map;
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
  
  private Map<Short, String> mobilityValues = new HashMap<>();

  @PostConstruct
  public void init(){
      enote = enoteSession.getEnoteView();
      
      mobilityValues.put((short)1, "Miasto/City");
      mobilityValues.put((short)2, "Kraj/Country");
      mobilityValues.put((short)3, "Kontynent/Continent");
      mobilityValues.put((short)4, "Świat/World");
  }
  
    private Enote enote;

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }
    
    public Enote getEnote() {
        return enote;
    }
    
        public Map<Short, String> getMobilityValues() {        
        return mobilityValues;
    }
}
