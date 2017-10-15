package param.handler;

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

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("Enabled", () ->
                fileParseService.applyData(fileContent, "Enabled", "Enabled=" + treasureEventMode.isEnabled()));
        put("TreasureEventUrl", () ->
                fileParseService.applyData(fileContent, "TreasureEventUrl",
                        "TreasureEventUrl=" + treasureEventMode.getTreasureEventUrl()));
        put("Difficulty", () ->
                fileParseService.applyData(fileContent, "Difficulty", "Difficulty=" + treasureEventMode.getDifficulty()));
        put("ActionPointCost", () ->
                fileParseService.applyData(fileContent, "ActionPointCost",
                        "ActionPointCost=" + treasureEventMode.getActionPointCost()));
        put("TreasureEventModeScript", () ->
                fileParseService.applyData(fileContent, "TreasureEventModeScript",
                        "TreasureEventModeScript=" + treasureEventMode.getTreasureEventModeScript()));
        put("NightmareModeUrl", () ->
                fileParseService.applyData(fileContent, "NightmareModeUrl",
                        "NightmareModeUrl=" + treasureEventMode.getNightmareModeUrl()));
        put("NightmareModeScript", () ->
                fileParseService.applyData(fileContent, "NightmareModeScript",
                        "NightmareModeScript=" + treasureEventMode.getNightmareModeScript()));
        put("NightmareModePreferredSummons", () ->
                fileParseService.applyData(fileContent, "NightmareModePreferredSummons",
                        "NightmareModePreferredSummons=" + treasureEventMode.getNightmareModePreferredSummon()));
        put("RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode", () ->
                fileParseService.applyData(fileContent, "RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode",
                        "RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode=" + treasureEventMode.isRerollForSummon()));
        put("NightmareModeAvailableAtStart", () ->
                fileParseService.applyData(fileContent, "NightmareModeAvailableAtStart",
                        "NightmareModeAvailableAtStart=" + treasureEventMode.isNightmareModeAvailableAtStart()));
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
