package param.handler;

import model.Combat;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class CombatDataHandler {

    private Combat combat;

    private String paramValue;

    private List<String> fileContent;

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put("MinWaitTimeInMsAfterAttack", () -> combat.setMinWaitTimeAfterAttack(Long.parseLong(paramValue)));
        put("MinWaitTimeInMsAfterSummon", () -> combat.setMinWaitTimeAfterSummon(Long.parseLong(paramValue)));
        put("MinWaitTimeInMsAfterAbility", () -> combat.setMinWaitTimeAfterAbility(Long.parseLong(paramValue)));
        put("LuaScript", () -> combat.setLuaScript(paramValue));
        put("ReloadPageOnLastBattle", () -> combat.setReloadPage(Boolean.parseBoolean(paramValue)));
        put("DoNotWaitForServerResponse", () -> combat.setNotWaitForServerResponse(Boolean.parseBoolean(paramValue)));
        put("MaxWaitTimeToLoadCharacterSelectionMenuInMs", () -> combat.setMaxWaitTimeToLoadCharacterSelection(Long.parseLong(paramValue)));
        put("RetrieveStatusEffects", () -> combat.setRetrieveStatusEffects(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("MinWaitTimeInMsAfterAttack", () ->
                fileParseService.applyData(fileContent, "MinWaitTimeInMsAfterAttack",
                        "MinWaitTimeInMsAfterAttack=" + combat.getMinWaitTimeAfterAttack()));
        put("MinWaitTimeInMsAfterSummon", () ->
                fileParseService.applyData(fileContent, "MinWaitTimeInMsAfterSummon",
                        "MinWaitTimeInMsAfterSummon=" + combat.getMinWaitTimeAfterSummon()));
        put("MinWaitTimeInMsAfterAbility", () ->
                fileParseService.applyData(fileContent, "MinWaitTimeInMsAfterAbility",
                        "MinWaitTimeInMsAfterAbility=" + combat.getMinWaitTimeAfterAbility()));
        put("LuaScript", () ->
                fileParseService.applyData(fileContent, "LuaScript", "LuaScript=" + combat.getLuaScript()));
        put("ReloadPageOnLastBattle", () ->
                fileParseService.applyData(fileContent, "ReloadPageOnLastBattle",
                        "ReloadPageOnLastBattle=" + combat.isReloadPage()));
        put("DoNotWaitForServerResponse", () ->
                fileParseService.applyData(fileContent, "DoNotWaitForServerResponse",
                        "DoNotWaitForServerResponse=" + combat.isNotWaitForServerResponse()));
        put("MaxWaitTimeToLoadCharacterSelectionMenuInMs", () ->
                fileParseService.applyData(fileContent, "MaxWaitTimeToLoadCharacterSelectionMenuInMs",
                        "MaxWaitTimeToLoadCharacterSelectionMenuInMs=" + combat.getMaxWaitTimeToLoadCharacterSelection()));
        put("RetrieveStatusEffects", () ->
                fileParseService.applyData(fileContent, "RetrieveStatusEffects",
                        "RetrieveStatusEffects=" + combat.isRetrieveStatusEffects()));
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
