package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
  
    private Map<Short, String> noteValues = new HashMap<>();
    private Map<Short, String> noteAValues = new HashMap<>();
    private Map<Short, String> potentValues = new HashMap<>();

  @PostConstruct
  public void init(){
      mnote = mnoteSession.getMnoteEdit();
      
      noteValues.put((short)1, "zbyt wcześnie na ocenę/too early to assess");
      noteValues.put((short)2, "wymaga poprawy/needs improvement");
      noteValues.put((short)3, "wartościowy człowiek/valuable person");
      noteValues.put((short)4, "wzór do naśladowania/role model");
      
      noteAValues.put((short)1, "zbyt wcześnie na ocenę/too early to assess");
      noteAValues.put((short)2, "nie spełnia postawionych wymagań/doesn't meet expectations");
      noteAValues.put((short)3, "realizuje wszystkie założenia/performs all assumptions");
      noteAValues.put((short)4, "wykracza poza stawiane wymagania/beyond the requirements");
      
      potentValues.put((short)1, "nie podlega ocenie/not applicable");
      potentValues.put((short)2, "na właściwym miejscu/proper position");
      potentValues.put((short)3, "perspektywa awansu/promotion prospects");
      potentValues.put((short)4, "awans/promotion");
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
    public Map<Short, String> getNoteValues() {
        return noteValues;
}
    public Map<Short, String> getNoteAValues() {
        return noteAValues;
}
    public Map<Short, String> getPotentValues() {
        return potentValues;
}
}
