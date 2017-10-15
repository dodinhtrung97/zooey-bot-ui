package param.handler;

import constant.Constant;
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
       put(Constant.LANGUAGE, () -> general.setLanguage(paramValue));
       put(Constant.CHROME_DEV_TOOL, () -> general.setDevToolsDockedOnTheRight(Boolean.parseBoolean(paramValue)));
       put(Constant.MAX_PAGE_LOAD_BEFORE_RETRY, () -> general.setMaxLoadDelay(Long.parseLong(paramValue)));
       put(Constant.MAX_TRIGGER_DELAY, () -> general.setMaxTriggerDelay(Long.parseLong(paramValue)));
       put(Constant.MAX_RESPONSE_DELAY, () -> general.setMaxResponseDelay(Long.parseLong(paramValue)));
       put(Constant.MAX_NUM_ACTION_RETRIES, () -> general.setMaxNumAction(Integer.parseInt(paramValue)));
       put(Constant.MIN_WAIT_TIME_AFTER_REFRESH, () -> general.setMinWaitTime(Long.parseLong(paramValue)));
       put(Constant.TIME_LIMIT, () -> general.setTimeLimit(Long.parseLong(paramValue)));
       put(Constant.USE_VIRAMATE, () -> general.setUseViramate(Boolean.parseBoolean(paramValue)));
       put(Constant.MAX_NUM_POTION_TO_USE, () -> general.setMaxNumPotion(Long.parseLong(paramValue)));
       put(Constant.USE_FULL_EX, () -> general.setUseFullEx(Boolean.parseBoolean(paramValue)));
       put(Constant.USE_FULL_EX_FIRST, () -> general.setUseFullExFirst(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.LANGUAGE, () ->
                fileParseService.applyData(fileContent, Constant.LANGUAGE,
                        Constant.LANGUAGE + "=" + general.getLanguage(),
                        Constant.MODE_GENERAL));
        put(Constant.CHROME_DEV_TOOL, () ->
                fileParseService.applyData(fileContent, Constant.CHROME_DEV_TOOL,
                        Constant.CHROME_DEV_TOOL + "=" + general.isDevToolsDockedOnTheRight(),
                        Constant.MODE_GENERAL));
        put(Constant.MAX_PAGE_LOAD_BEFORE_RETRY, () ->
                fileParseService.applyData(fileContent, Constant.MAX_PAGE_LOAD_BEFORE_RETRY,
                        Constant.MAX_PAGE_LOAD_BEFORE_RETRY + "=" + general.getMaxLoadDelay(),
                        Constant.MODE_GENERAL));
        put(Constant.MAX_TRIGGER_DELAY, () ->
                fileParseService.applyData(fileContent, Constant.MAX_TRIGGER_DELAY,
                        Constant.MAX_TRIGGER_DELAY + "=" + general.getMaxTriggerDelay(),
                        Constant.MODE_GENERAL));
        put(Constant.MAX_RESPONSE_DELAY, () ->
                fileParseService.applyData(fileContent, Constant.MAX_RESPONSE_DELAY,
                        Constant.MAX_RESPONSE_DELAY + "=" + general.getMaxResponseDelay(),
                        Constant.MODE_GENERAL));
        put(Constant.MAX_NUM_ACTION_RETRIES, () ->
                fileParseService.applyData(fileContent, Constant.MAX_NUM_ACTION_RETRIES,
                        Constant.MAX_NUM_ACTION_RETRIES + "=" + general.getMaxNumAction(),
                        Constant.MODE_GENERAL));
        put(Constant.MIN_WAIT_TIME_AFTER_REFRESH, () ->
                fileParseService.applyData(fileContent, Constant.MIN_WAIT_TIME_AFTER_REFRESH,
                        Constant.MIN_WAIT_TIME_AFTER_REFRESH + "=" + general.getMinWaitTime(),
                        Constant.MODE_GENERAL));
        put(Constant.TIME_LIMIT, () ->
                fileParseService.applyData(fileContent, Constant.TIME_LIMIT,
                        Constant.TIME_LIMIT + "=" + general.getTimeLimit(),
                        Constant.MODE_GENERAL));
        put(Constant.USE_VIRAMATE, () ->
                fileParseService.applyData(fileContent, Constant.USE_VIRAMATE,
                        Constant.USE_VIRAMATE + "=" + general.isUseViramate(),
                        Constant.MODE_GENERAL));
        put(Constant.MAX_NUM_POTION_TO_USE, () ->
                fileParseService.applyData(fileContent, Constant.MAX_NUM_POTION_TO_USE,
                        Constant.MAX_NUM_POTION_TO_USE + "=" + general.getMaxNumPotion(),
                        Constant.MODE_GENERAL));
        put(Constant.USE_FULL_EX, () ->
                fileParseService.applyData(fileContent, Constant.USE_FULL_EX,
                        Constant.USE_FULL_EX + "=" + general.isUseFullEx(),
                        Constant.MODE_GENERAL));
        put(Constant.USE_FULL_EX_FIRST, () ->
                fileParseService.applyData(fileContent, Constant.USE_FULL_EX_FIRST,
                        Constant.USE_FULL_EX_FIRST + "=" + general.isUseFullExFirst(),
                        Constant.MODE_GENERAL));
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
