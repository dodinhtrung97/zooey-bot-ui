package param.handler;

import model.EventMode;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class EventModeDataHandler {

    private EventMode eventMode;

    private String paramValue;

    private List<String> fileContent;

    public void setEventMode(EventMode eventMode) {
        this.eventMode = eventMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
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

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("Enabled", () ->
                fileParseService.applyData(fileContent, "Enabled", "Enabled=" + eventMode.isEnabled()));
        put("EventRaidUrl", () ->
                fileParseService.applyData(fileContent, "EventRaidUrl",
                        "EventRaidUrl=" + eventMode.getEventRaidUrl()));
        put("EventRaidScript", () ->
                fileParseService.applyData(fileContent, "EventRaidScript",
                        "EventRaidScript=" + eventMode.getEventRaidScript()));
        put("NightmareModeUrl", () ->
                fileParseService.applyData(fileContent, "NightmareModeUrl",
                        "NightmareModeUrl=" + eventMode.getNightmareModeUrl()));
        put("NightmareModeScript", () ->
                fileParseService.applyData(fileContent, "NightmareModeScript",
                        "NightmareModeScript=" + eventMode.getNightmareModeScript()));
        put("EventPageUrl", () ->
                fileParseService.applyData(fileContent, "EventPageUrl", "EventPageUrl=" + eventMode.getEventPageUrl()));
        put("NightmareModePreferredSummons", () ->
                fileParseService.applyData(fileContent, "NightmareModePreferredSummons",
                        "NightmareModePreferredSummons=" + eventMode.getNightmareModePreferredSummon()));
        put("RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode", () ->
                fileParseService.applyData(fileContent, "RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode",
                        "RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode=" + eventMode.isRerollForSummon()));
        put("NightmareModeAvailableAtStart", () ->
                fileParseService.applyData(fileContent, "NightmareModeAvailableAtStart",
                        "NightmareModeAvailableAtStart=" + eventMode.isNightmareModeAvailableAtStart()));
        put("WaitTimeInMsAfterEventPageIsLoaded", () ->
                fileParseService.applyData(fileContent, "WaitTimeInMsAfterEventPageIsLoaded",
                        "WaitTimeInMsAfterEventPageIsLoaded=" + eventMode.getWaitTimeAfterPageLoaded()));
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
