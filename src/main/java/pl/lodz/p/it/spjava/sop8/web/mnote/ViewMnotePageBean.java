package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

@ManagedBean(name = "viewMnotePageBean")
@RequestScoped
public class ViewMnotePageBean {

    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;
    
    private Map<Short, String> noteValues = new HashMap<>();
    private Map<Short, String> noteAValues = new HashMap<>();
    private Map<Short, String> potentValues = new HashMap<>();

    @PostConstruct
    public void init() {
        mnote = mnoteSession.getMnoteView();

        noteValues.put((short) 1, "[-] zbyt wcześnie na ocenę/too early to assess");
        noteValues.put((short) 2, "[C] wymaga poprawy/needs improvement");
        noteValues.put((short) 3, "[B] wartościowy człowiek/valuable person");
        noteValues.put((short) 4, "[A] wzór do naśladowania/role model");

        noteAValues.put((short) 1, "[-] zbyt wcześnie na ocenę/too early to assess");
        noteAValues.put((short) 2, "[C] nie spełnia postawionych wymagań/doesn't meet expectations");
        noteAValues.put((short) 3, "[B] realizuje wszystkie założenia/performs all assumptions");
        noteAValues.put((short) 4, "[A] wykracza poza stawiane wymagania/beyond the requirements");

        potentValues.put((short) 1, "[-] nie podlega ocenie/not applicable");
        potentValues.put((short) 2, "[C] na właściwym miejscu/proper position");
        potentValues.put((short) 3, "[B] perspektywa awansu/promotion prospects");
        potentValues.put((short) 4, "[A] awans/promotion");

    }

    private Mnote mnote;

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }

    public Mnote getMnote() {
        return mnote;
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
