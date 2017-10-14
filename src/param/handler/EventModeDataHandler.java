package param.handler;

import model.EventMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class EventModeDataHandler {

    private EventMode eventMode;

    private String paramValue;

    public void setEventMode(EventMode eventMode) {
        this.eventMode = eventMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("Enabled", () -> eventMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put("EventRaidUrl", () -> eventMode.setEventRaidUrl(paramValue));
        put("EventRaidScript", () -> eventMode.setEventRaidScript(paramValue));
        put("NightmareModeUrl", () -> eventMode.setNightmareModeUrl(paramValue));
        put("NightmareModeScript", () -> eventMode.setNightmareModeScript(paramValue));
        put("EventPageUrl", () -> eventMode.setEventPageUrl(paramValue));
        put("NightmareModePreferredSummons", () -> eventMode.setNightmareModePreferredSummon(paramValue));
        put("RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode", () -> eventMode.setRerollForSummon(Boolean.parseBoolean(paramValue)));
        put("NightmareModeAvailableAtStart", () -> eventMode.setNightmareModeAvailableAtStart(Boolean.parseBoolean(paramValue)));
        put("WaitTimeInMsAfterEventPageIsLoaded", () -> eventMode.setWaitTimeAfterPageLoaded(Long.parseLong(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
