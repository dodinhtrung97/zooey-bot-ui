package param.handler;

import model.Debug;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class DebugDataHandler {

    private Debug debug;

    private String paramValue;

    public void setDebug(Debug debug) {
        this.debug = debug;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("Clicks", () -> debug.setClicks(Boolean.parseBoolean(paramValue)));
        put("TrialBattleMode", () -> debug.setEnabled(Boolean.parseBoolean(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            throw new IllegalArgumentException("Unknown paramater: " + param);
        }
        FUNCTIONS.get(param).run();
    }
}
