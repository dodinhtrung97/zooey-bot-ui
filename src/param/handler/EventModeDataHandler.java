package param.handler;

import constant.Constant;
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
        put(Constant.ENABLE, () -> eventMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put(Constant.EVENT_RAID_URL, () -> eventMode.setEventRaidUrl(paramValue));
        put(Constant.EVENT_LUA_SCRIPT, () -> eventMode.setEventRaidScript(paramValue));
        put(Constant.NM_URL, () -> eventMode.setNightmareModeUrl(paramValue));
        put(Constant.NM_LUA_SCRIPT, () -> eventMode.setNightmareModeScript(paramValue));
        put(Constant.EVENT_PAGE_URL, () -> eventMode.setEventPageUrl(paramValue));
        put(Constant.NM_PREFERRED_SUMMON, () -> eventMode.setNightmareModePreferredSummon(paramValue));
        put(Constant.REROLL_FOR_SUMMON_NM, () -> eventMode.setRerollForSummon(Boolean.parseBoolean(paramValue)));
        put(Constant.NM_AVAILABLE_AT_START, () -> eventMode.setNightmareModeAvailableAtStart(Boolean.parseBoolean(paramValue)));
        put(Constant.WAIT_TIME_AFTER_EVENT_IS_LOADED, () -> eventMode.setWaitTimeAfterPageLoaded(Long.parseLong(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.ENABLE, () ->
                fileParseService.applyData(fileContent, Constant.ENABLE,
                        Constant.ENABLE + "=" + eventMode.isEnabled(),
                        Constant.MODE_EVENT));
        put(Constant.EVENT_RAID_URL, () ->
                fileParseService.applyData(fileContent, Constant.EVENT_RAID_URL,
                        Constant.EVENT_RAID_URL + "=" + eventMode.getEventRaidUrl(),
                        Constant.MODE_EVENT));
        put(Constant.EVENT_LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.EVENT_LUA_SCRIPT,
                        Constant.EVENT_LUA_SCRIPT + "=" + eventMode.getEventRaidScript(),
                        Constant.MODE_EVENT));
        put(Constant.NM_URL, () ->
                fileParseService.applyData(fileContent, Constant.NM_URL,
                        Constant.NM_URL + "=" + eventMode.getNightmareModeUrl(),
                        Constant.MODE_EVENT));
        put(Constant.NM_LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.NM_LUA_SCRIPT,
                        Constant.NM_LUA_SCRIPT + "=" + eventMode.getNightmareModeScript(),
                        Constant.MODE_EVENT));
        put(Constant.EVENT_PAGE_URL, () ->
                fileParseService.applyData(fileContent, Constant.EVENT_PAGE_URL,
                        Constant.EVENT_PAGE_URL + "=" + eventMode.getEventPageUrl(),
                        Constant.MODE_EVENT));
        put(Constant.NM_PREFERRED_SUMMON, () ->
                fileParseService.applyData(fileContent, Constant.NM_PREFERRED_SUMMON,
                        Constant.NM_PREFERRED_SUMMON + "=" + eventMode.getNightmareModePreferredSummon(),
                        Constant.MODE_EVENT));
        put(Constant.REROLL_FOR_SUMMON_NM, () ->
                fileParseService.applyData(fileContent, Constant.REROLL_FOR_SUMMON_NM,
                        Constant.REROLL_FOR_SUMMON_NM + "=" + eventMode.isRerollForSummon(),
                        Constant.MODE_EVENT));
        put(Constant.NM_AVAILABLE_AT_START, () ->
                fileParseService.applyData(fileContent, Constant.NM_AVAILABLE_AT_START,
                        Constant.NM_AVAILABLE_AT_START + "=" + eventMode.isNightmareModeAvailableAtStart(),
                        Constant.MODE_EVENT));
        put(Constant.WAIT_TIME_AFTER_EVENT_IS_LOADED, () ->
                fileParseService.applyData(fileContent, Constant.WAIT_TIME_AFTER_EVENT_IS_LOADED,
                        Constant.WAIT_TIME_AFTER_EVENT_IS_LOADED + "=" + eventMode.getWaitTimeAfterPageLoaded(),
                        Constant.MODE_EVENT));
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
