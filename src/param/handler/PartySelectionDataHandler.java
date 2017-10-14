package param.handler;

import model.PartySelection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class PartySelectionDataHandler {

    private PartySelection partySelection;

    private String paramValue;

    public void setPartySelection(PartySelection partySelection) {
        this.partySelection = partySelection;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("PreferredPartyGroup", () -> partySelection.setPreferredPartyGroup(Integer.parseInt(paramValue)));
        put("PreferredPartyDeck", () -> partySelection.setPreferredPartyDeck(Integer.parseInt(paramValue)));
        put("PreferredNightmareModePartyGroup", () -> partySelection.setPreferredNightmarePartyGroup(Integer.parseInt(paramValue)));
        put("PreferredNightmareModePartyDeck", () -> partySelection.setPreferredNightmarePartyDeck(Integer.parseInt(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
