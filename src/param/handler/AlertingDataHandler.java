package param.handler;

import model.Alerting;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class AlertingDataHandler {

    private Alerting alerting;

    private String paramValue;

    public void setAlerting(Alerting alerting) {
        this.alerting = alerting;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("CaptchaNotificationSoundPath", () -> alerting.setCaptchaNotificationSoundPath(paramValue));
        put("NumNotifications", () -> alerting.setNumNotification(Long.parseLong(paramValue)));
        put("MaxNumSummonSelectionFailuresBeforePlayingSoundNotification", () ->
                alerting.setMaxNumSummonSelectionFailuresBeforePlayingSound(Long.parseLong(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
