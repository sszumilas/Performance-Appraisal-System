package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

@ManagedBean(name = "createMnotePageBean")
@RequestScoped
public class CreateMnotePageBean {

    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;

    private Map<Short, String> mobilityValues = new HashMap<>();
    private Map<Short, String> noteValues = new HashMap<>();
    private Map<Short, String> noteAValues = new HashMap<>();
    private Map<Short, String> potentValues = new HashMap<>();

    @PostConstruct
    public void init() {
        enote = mnoteSession.findEnote(mnoteSession.getNoteAccount(), (long) Calendar.getInstance().get(Calendar.YEAR));

        mobilityValues.put((short) 1, "Miasto/City");
        mobilityValues.put((short) 2, "Kraj/Country");
        mobilityValues.put((short) 3, "Kontynent/Continent");
        mobilityValues.put((short) 4, "Świat/World");

        noteValues.put((short) 1, "zbyt wcześnie na ocenę/too early to assess");
        noteValues.put((short) 2, "wymaga poprawy/needs improvement");
        noteValues.put((short) 3, "wartościowy człowiek/valuable person");
        noteValues.put((short) 4, "wzór do naśladowania/role model");

        noteAValues.put((short) 1, "zbyt wcześnie na ocenę/too early to assess");
        noteAValues.put((short) 2, "nie spełnia postawionych wymagań/doesn't meet expectations");
        noteAValues.put((short) 3, "realizuje wszystkie założenia/performs all assumptions");
        noteAValues.put((short) 4, "wykracza poza stawiane wymagania/beyond the requirements");

        potentValues.put((short) 1, "nie podlega ocenie/not applicable");
        potentValues.put((short) 2, "na właściwym miejscu/proper position");
        potentValues.put((short) 3, "perspektywa awansu/promotion prospects");
        potentValues.put((short) 4, "awans/promotion");

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
        Long year = (long) Calendar.getInstance().get(Calendar.YEAR);
        mnote.setNoteYear(year);
        mnote.setConfirmId(mnoteSession.getUserAccount());
        mnote.setEmployeeIdFk(mnoteSession.getNoteAccount());
        mnote.setConfirmation(new Date());
        mnoteSession.createMnote(mnote);
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

    public Map<Short, String> getMobilityValues() {
        return mobilityValues;
    }
}
