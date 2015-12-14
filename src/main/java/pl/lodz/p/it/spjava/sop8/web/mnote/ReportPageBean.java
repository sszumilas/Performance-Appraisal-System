package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.model.Mnote;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.enote.EnoteSession;

@ManagedBean(name = "reportPageBean")
@RequestScoped
public class ReportPageBean {

    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;

    @ManagedProperty(value = "#{enoteSession}")
    private EnoteSession enoteSession;

    private Map<Short, String> mobilityValues = new HashMap<>();
    private Map<Short, String> noteValues = new HashMap<>();
    private Map<Short, String> noteAValues = new HashMap<>();
    private Map<Short, String> potentValues = new HashMap<>();

    @PostConstruct
    private void initModel() {
        mnote = mnoteSession.getMnoteReport();
        enote = enoteSession.getEnoteReport();
        account = mnote.getEmployeeIdFk();
        team = account.getTeamIdFk();

        mobilityValues.put((short) 1, "Miasto/City");
        mobilityValues.put((short) 2, "Kraj/Country");
        mobilityValues.put((short) 3, "Kontynent/Continent");
        mobilityValues.put((short) 4, "Świat/World");

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

    private Account account;
    private Mnote mnote;
    private Enote enote;
    private Team team;

    public Mnote getMnote() {
        return mnote;
    }

    public Enote getEnote() {
        return enote;
    }

    public Account getAccount() {
        return account;
    }

    public Team getTeam() {
        return team;
    }

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }

    public Map<Short, String> getMobilityValues() {
        return mobilityValues;
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
