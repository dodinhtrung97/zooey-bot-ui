package param.handler;

import model.TreasureEventMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class TreasureEventModeDataHandler {

    private TreasureEventMode treasureEventMode;

    private String paramValue;

    public void setTreasureEventMode(TreasureEventMode treasureEventMode) {
        this.treasureEventMode = treasureEventMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("Enabled", () -> treasureEventMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put("TreasureEventUrl", () -> treasureEventMode.setTreasureEventUrl(paramValue));
        put("Difficulty", () -> treasureEventMode.setDifficulty(paramValue));
        put("ActionPointCost", () -> treasureEventMode.setActionPointCost(paramValue));
        put("TreasureEventModeScript", () -> treasureEventMode.setTreasureEventModeScript(paramValue));
        put("NightmareModeUrl", () -> treasureEventMode.setNightmareModeUrl(paramValue));
        put("NightmareModeScript", () -> treasureEventMode.setNightmareModeScript(paramValue));
        put("NightmareModePreferredSummons", () -> treasureEventMode.setNightmareModePreferredSummon(paramValue));
        put("RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode", () -> treasureEventMode.setRerollForSummon(Boolean.parseBoolean(paramValue)));
        put("NightmareModeAvailableAtStart", () -> treasureEventMode.setNightmareModeAvailableAtStart(Boolean.parseBoolean(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
