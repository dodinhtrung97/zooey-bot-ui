package param.handler;

import model.PartySelection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class PartySelectionDataHandler {

    private PartySelection partySelection;

    private String paramValue;

    private int lineNum;

    private List<String> fileContent;

    public void setPartySelection(PartySelection partySelection) {
        this.partySelection = partySelection;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put("PreferredPartyGroup", () -> partySelection.setPreferredPartyGroup(Integer.parseInt(paramValue)));
        put("PreferredPartyDeck", () -> partySelection.setPreferredPartyDeck(Integer.parseInt(paramValue)));
        put("PreferredNightmareModePartyGroup", () -> partySelection.setPreferredNightmarePartyGroup(Integer.parseInt(paramValue)));
        put("PreferredNightmareModePartyDeck", () -> partySelection.setPreferredNightmarePartyDeck(Integer.parseInt(paramValue)));
    }};

    public void handleInject(String param) {
        if (!SET_OBJECT.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        SET_OBJECT.get(param).run();
    }
}
