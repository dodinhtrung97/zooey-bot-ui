package param.handler;

import model.General;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class GeneralDataHandler {

    private General general;

    private String paramValue;

    private List<String> fileContent;

    public void setGeneral(General general) {
        this.general = general;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
       put("Language", () -> general.setLanguage(paramValue));
       put("ChromeDevToolsWindowDockedOnTheRight", () -> general.setDevToolsDockedOnTheRight(Boolean.parseBoolean(paramValue)));
       put("MaxPageLoadDelayInMsBeforeRetry", () -> general.setMaxLoadDelay(Long.parseLong(paramValue)));
       put("MaxTriggerDelayInMsBeforeFallback", () -> general.setMaxTriggerDelay(Long.parseLong(paramValue)));
       put("MaxResponseDelayInMs", () -> general.setMaxResponseDelay(Long.parseLong(paramValue)));
       put("MaxNumActionRetries", () -> general.setMaxNumAction(Integer.parseInt(paramValue)));
       put("MinWaitTimeInMsAfterRefresh", () -> general.setMinWaitTime(Long.parseLong(paramValue)));
       put("TimeLimitInSeconds", () -> general.setTimeLimit(Long.parseLong(paramValue)));
       put("UseViramate", () -> general.setUseViramate(Boolean.parseBoolean(paramValue)));
       put("MaxNumPotionsToUse", () -> general.setMaxNumPotion(Long.parseLong(paramValue)));
       put("UseFullElixirsWhenNoRemainingHalfAPPotions", () -> general.setUseFullEx(Boolean.parseBoolean(paramValue)));
       put("UseFullElixirsFirst", () -> general.setUseFullExFirst(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("Language", () ->
                fileParseService.applyData(fileContent, "Language", "Language=" + general.getLanguage()));
        put("ChromeDevToolsWindowDockedOnTheRight", () ->
                fileParseService.applyData(fileContent, "ChromeDevToolsWindowDockedOnTheRight",
                        "ChromeDevToolsWindowDockedOnTheRight=" + general.isDevToolsDockedOnTheRight()));
        put("MaxPageLoadDelayInMsBeforeRetry", () ->
                fileParseService.applyData(fileContent, "MaxPageLoadDelayInMsBeforeRetry",
                        "MaxPageLoadDelayInMsBeforeRetry=" + general.getMaxLoadDelay()));
        put("MaxTriggerDelayInMsBeforeFallback", () ->
                fileParseService.applyData(fileContent, "MaxTriggerDelayInMsBeforeFallback",
                        "MaxTriggerDelayInMsBeforeFallback=" + general.getMaxTriggerDelay()));
        put("MaxResponseDelayInMs", () ->
                fileParseService.applyData(fileContent, "MaxResponseDelayInMs",
                        "MaxResponseDelayInMs=" + general.getMaxResponseDelay()));
        put("MaxNumActionRetries", () ->
                fileParseService.applyData(fileContent, "MaxNumActionRetries",
                        "MaxNumActionRetries=" + general.getMaxNumAction()));
        put("MinWaitTimeInMsAfterRefresh", () ->
                fileParseService.applyData(fileContent, "MinWaitTimeInMsAfterRefresh",
                        "MinWaitTimeInMsAfterRefresh=" + general.getMinWaitTime()));
        put("TimeLimitInSeconds", () ->
                fileParseService.applyData(fileContent, "TimeLimitInSeconds",
                        "TimeLimitInSeconds=" + general.getTimeLimit()));
        put("UseViramate", () ->
                fileParseService.applyData(fileContent, "UseViramate",
                        "UseViramate=" + general.isUseViramate()));
        put("MaxNumPotionsToUse", () ->
                fileParseService.applyData(fileContent, "MaxNumPotionsToUse",
                        "MaxNumPotionsToUse=" + general.getMaxNumPotion()));
        put("UseFullElixirsWhenNoRemainingHalfAPPotions", () ->
                fileParseService.applyData(fileContent, "UseFullElixirsWhenNoRemainingHalfAPPotions",
                        "UseFullElixirsWhenNoRemainingHalfAPPotions=" + general.isUseFullEx()));
        put("UseFullElixirsFirst", () ->
                fileParseService.applyData(fileContent, "UseFullElixirsFirst",
                        "UseFullElixirsFirst=" + general.isUseFullExFirst()));
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
