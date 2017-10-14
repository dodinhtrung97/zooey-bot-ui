package param.handler;

import model.SoloCoopMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class SoloCoopModeDataHandler {

    private SoloCoopMode soloCoopMode;

    private String paramValue;

    public void setSoloCoopMode(SoloCoopMode soloCoopMode) {
        this.soloCoopMode = soloCoopMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("Enabled", () -> soloCoopMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put("LuaScript", () -> soloCoopMode.setLuaScript(paramValue));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
