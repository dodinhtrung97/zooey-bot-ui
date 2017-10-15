package param.handler;

import model.PartySelection;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class PartySelectionDataHandler {

    private PartySelection partySelection;

    private String paramValue;

    private List<String> fileContent;

    public void setPartySelection(PartySelection partySelection) {
        this.partySelection = partySelection;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put("PreferredPartyGroup", () -> partySelection.setPreferredPartyGroup(Integer.parseInt(paramValue)));
        put("PreferredPartyDeck", () -> partySelection.setPreferredPartyDeck(Integer.parseInt(paramValue)));
        put("PreferredNightmareModePartyGroup", () -> partySelection.setPreferredNightmarePartyGroup(Integer.parseInt(paramValue)));
        put("PreferredNightmareModePartyDeck", () -> partySelection.setPreferredNightmarePartyDeck(Integer.parseInt(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("PreferredPartyGroup", () ->
                fileParseService.applyData(fileContent, "PreferredPartyGroup",
                        "PreferredPartyGroup=" + partySelection.getPreferredPartyGroup()));
        put("PreferredPartyDeck", () ->fileParseService.applyData(fileContent, "PreferredPartyDeck",
                "PreferredPartyDeck=" + partySelection.getPreferredPartyDeck()));
        put("PreferredNightmareModePartyGroup", () ->fileParseService.applyData(fileContent, "PreferredNightmareModePartyGroup",
                "PreferredNightmareModePartyGroup=" + partySelection.getPreferredNightmarePartyGroup()));
        put("PreferredNightmareModePartyDeck", () ->fileParseService.applyData(fileContent, "PreferredNightmareModePartyDeck",
                "PreferredNightmareModePartyDeck=" + partySelection.getPreferredNightmarePartyDeck()));
    }};

    public void handleInject(String param) {
        if (!SET_OBJECT.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        SET_OBJECT.get(param).run();
    }

    public void handleApplyData(String param) {
        if (!SET_OBJECT_TO_FILE.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        SET_OBJECT_TO_FILE.get(param).run();
    }
}
