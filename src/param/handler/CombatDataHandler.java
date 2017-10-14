package param.handler;

import model.Combat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class CombatDataHandler {

    private Combat combat;

    private String paramValue;

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("MinWaitTimeInMsAfterAttack", () -> combat.setMinWaitTimeAfterAttack(Long.parseLong(paramValue)));
        put("MinWaitTimeInMsAfterSummon", () -> combat.setMinWaitTimeAfterSummon(Long.parseLong(paramValue)));
        put("MinWaitTimeInMsAfterAbility", () -> combat.setMinWaitTimeAfterAbility(Long.parseLong(paramValue)));
        put("LuaScript", () -> combat.setLuaScript(paramValue));
        put("ReloadPageOnLastBattle", () -> combat.setReloadPage(Boolean.parseBoolean(paramValue)));
        put("DoNotWaitForServerResponse", () -> combat.setNotWaitForServerResponse(Boolean.parseBoolean(paramValue)));
        put("MaxWaitTimeToLoadCharacterSelectionMenuInMs", () -> combat.setMaxWaitTimeToLoadCharacterSelection(Long.parseLong(paramValue)));
        put("RetrieveStatusEffects", () -> combat.setRetrieveStatusEffects(Boolean.parseBoolean(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
