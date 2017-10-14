package param.handler;

import model.General;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class GeneralDataHandler {

    private General general;

    private String paramValue;

    public void setGeneral(General general) {
        this.general = general;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
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

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}