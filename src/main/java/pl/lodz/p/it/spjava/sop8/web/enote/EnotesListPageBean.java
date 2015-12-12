package pl.lodz.p.it.spjava.sop8.web.enote;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Enote;

@ManagedBean(name = "enotesListPageBean")
@RequestScoped
public class EnotesListPageBean {
    
    @ManagedProperty(value = "#{enoteSession}")
    private EnoteSession enoteSession;
    
    @PostConstruct
    private void initModel() {
        enoteList = enoteSession.pullEnoteList();
    }
    
    private List<Enote> enoteList;

    public List<Enote> getEnoteList() {
        return enoteList;
    }

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }

    public String edit(Enote enote){
        enoteSession.setEnoteEdit(enote);
        return "editEnote";
    }
    
    public String view(Enote enote){
        enoteSession.setEnoteView(enote);
        return "viewEnote";
    }
    
}
