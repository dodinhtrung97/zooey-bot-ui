package param.handler;

import constant.Constant;
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
        put(Constant.PREFERRED_PARTY_GROUP, () -> partySelection.setPreferredPartyGroup(Integer.parseInt(paramValue)));
        put(Constant.PREFERRED_PARTY_DECK, () -> partySelection.setPreferredPartyDeck(Integer.parseInt(paramValue)));
        put(Constant.PREFERRED_NM_PARTY_GROUP, () -> partySelection.setPreferredNightmarePartyGroup(Integer.parseInt(paramValue)));
        put(Constant.PREFERRED_NM_PARTY_DECK, () -> partySelection.setPreferredNightmarePartyDeck(Integer.parseInt(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.PREFERRED_PARTY_GROUP, () ->
                fileParseService.applyData(fileContent, Constant.PREFERRED_PARTY_GROUP,
                        Constant.PREFERRED_PARTY_GROUP + "=" + partySelection.getPreferredPartyGroup(),
                        Constant.MODE_PARTY_SELECTION));
        put(Constant.PREFERRED_PARTY_DECK, () -> fileParseService.applyData(fileContent, Constant.PREFERRED_PARTY_DECK,
                Constant.PREFERRED_PARTY_DECK + "=" + partySelection.getPreferredPartyDeck(),
                Constant.MODE_PARTY_SELECTION));
        put(Constant.PREFERRED_NM_PARTY_GROUP, () -> fileParseService.applyData(fileContent, Constant.PREFERRED_NM_PARTY_GROUP,
                Constant.PREFERRED_NM_PARTY_GROUP + "=" + partySelection.getPreferredNightmarePartyGroup(),
                Constant.MODE_PARTY_SELECTION));
        put(Constant.PREFERRED_NM_PARTY_DECK, () -> fileParseService.applyData(fileContent, Constant.PREFERRED_NM_PARTY_DECK,
                Constant.PREFERRED_NM_PARTY_DECK + "=" + partySelection.getPreferredNightmarePartyDeck(),
                Constant.MODE_PARTY_SELECTION));
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
