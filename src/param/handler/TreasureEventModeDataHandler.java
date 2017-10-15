package param.handler;

import constant.Constant;
import model.TreasureEventMode;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class TreasureEventModeDataHandler {

    private TreasureEventMode treasureEventMode;

    private String paramValue;

    private List<String> fileContent;

    public void setTreasureEventMode(TreasureEventMode treasureEventMode) {
        this.treasureEventMode = treasureEventMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put(Constant.ENABLE, () -> treasureEventMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put(Constant.TREASURE_EVENT_URL, () -> treasureEventMode.setTreasureEventUrl(paramValue));
        put(Constant.DIFFICULTY, () -> treasureEventMode.setDifficulty(paramValue));
        put(Constant.AP_COST, () -> treasureEventMode.setActionPointCost(paramValue));
        put(Constant.TREASURE_EVENT_LUA_SCRIPT, () -> treasureEventMode.setTreasureEventModeScript(paramValue));
        put(Constant.NM_URL, () -> treasureEventMode.setNightmareModeUrl(paramValue));
        put(Constant.NM_LUA_SCRIPT, () -> treasureEventMode.setNightmareModeScript(paramValue));
        put(Constant.NM_PREFERRED_SUMMON, () -> treasureEventMode.setNightmareModePreferredSummon(paramValue));
        put(Constant.REROLL_FOR_SUMMON_NM, () -> treasureEventMode.setRerollForSummon(Boolean.parseBoolean(paramValue)));
        put(Constant.NM_AVAILABLE_AT_START, () -> treasureEventMode.setNightmareModeAvailableAtStart(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.ENABLE, () ->
                fileParseService.applyData(fileContent, Constant.ENABLE, Constant.ENABLE + "=" + treasureEventMode.isEnabled(),
                Constant.MODE_TREASURE_EVENT));
        put(Constant.TREASURE_EVENT_URL, () ->
                fileParseService.applyData(fileContent, Constant.TREASURE_EVENT_URL,
                        Constant.TREASURE_EVENT_URL + "=" + treasureEventMode.getTreasureEventUrl(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.DIFFICULTY, () ->
                fileParseService.applyData(fileContent, Constant.DIFFICULTY, Constant.DIFFICULTY + "=" + treasureEventMode.getDifficulty(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.AP_COST, () ->
                fileParseService.applyData(fileContent, Constant.AP_COST,
                        Constant.AP_COST + "=" + treasureEventMode.getActionPointCost(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.TREASURE_EVENT_LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.TREASURE_EVENT_LUA_SCRIPT,
                        Constant.TREASURE_EVENT_LUA_SCRIPT + "=" + treasureEventMode.getTreasureEventModeScript(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.NM_URL, () ->
                fileParseService.applyData(fileContent, Constant.NM_URL,
                        Constant.NM_URL + "=" + treasureEventMode.getNightmareModeUrl(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.NM_LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.NM_LUA_SCRIPT,
                        Constant.NM_LUA_SCRIPT + "=" + treasureEventMode.getNightmareModeScript(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.NM_PREFERRED_SUMMON, () ->
                fileParseService.applyData(fileContent, Constant.NM_PREFERRED_SUMMON,
                        Constant.NM_PREFERRED_SUMMON + "=" + treasureEventMode.getNightmareModePreferredSummon(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.REROLL_FOR_SUMMON_NM, () ->
                fileParseService.applyData(fileContent, Constant.REROLL_FOR_SUMMON_NM,
                        Constant.REROLL_FOR_SUMMON_NM + "=" + treasureEventMode.isRerollForSummon(),
                        Constant.MODE_TREASURE_EVENT));
        put(Constant.NM_AVAILABLE_AT_START, () ->
                fileParseService.applyData(fileContent, Constant.NM_AVAILABLE_AT_START,
                        Constant.NM_AVAILABLE_AT_START + "=" + treasureEventMode.isNightmareModeAvailableAtStart(),
                        Constant.MODE_TREASURE_EVENT));
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
