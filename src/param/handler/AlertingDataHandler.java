package param.handler;

import constant.Constant;
import model.Alerting;
import model.ModelWrapper;
import model.ModelWrapperContainer;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class AlertingDataHandler {

    private Alerting alerting;

    private String paramValue;

    private List<String> fileContent;

    public void setAlerting(Alerting alerting) {
        this.alerting = alerting;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put(Constant.CAPTCHA_SOUND_PATH, () -> alerting.setCaptchaNotificationSoundPath(paramValue));
        put(Constant.NUM_NOTIFICATION, () -> alerting.setNumNotification(Long.parseLong(paramValue)));
        put(Constant.MAX_NUM_SUMMON_BEFORE_PLAYING_SOUND, () ->
                alerting.setMaxNumSummonSelectionFailuresBeforePlayingSound(Long.parseLong(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.CAPTCHA_SOUND_PATH, () ->
                fileParseService.applyData(fileContent, Constant.CAPTCHA_SOUND_PATH,
                        Constant.CAPTCHA_SOUND_PATH + "=" + alerting.getCaptchaNotificationSoundPath(),
                        Constant.MODE_ALERTING));
        put(Constant.NUM_NOTIFICATION, () ->
                fileParseService.applyData(fileContent, Constant.NUM_NOTIFICATION,
                        Constant.NUM_NOTIFICATION + "=" + alerting.getNumNotification(),
                        Constant.MODE_ALERTING));
        put(Constant.MAX_NUM_SUMMON_BEFORE_PLAYING_SOUND, () ->
                fileParseService.applyData(fileContent, Constant.MAX_NUM_SUMMON_BEFORE_PLAYING_SOUND,
                        Constant.MAX_NUM_SUMMON_BEFORE_PLAYING_SOUND + "=" + alerting.getMaxNumSummonSelectionFailuresBeforePlayingSound(),
                        Constant.MODE_ALERTING));
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
