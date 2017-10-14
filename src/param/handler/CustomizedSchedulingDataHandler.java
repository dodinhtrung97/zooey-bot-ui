package param.handler;

import model.CustomizedScheduling;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class CustomizedSchedulingDataHandler {

    private CustomizedScheduling customizedScheduling;

    private String paramValue;

    public void setCustomizedScheduling(CustomizedScheduling customizedScheduling) {
        this.customizedScheduling = customizedScheduling;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("Enabled", () -> customizedScheduling.setEnabled(Boolean.parseBoolean(paramValue)));
        put("SchedulingLuaScript", () -> customizedScheduling.setLuaScript(paramValue));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
