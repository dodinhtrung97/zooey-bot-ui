package param.handler;

import model.SlaveMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class SlaveModeDataHandler {

    private SlaveMode slaveMode;

    private String paramValue;

    public void setSlaveMode(SlaveMode slaveMode) {
        this.slaveMode = slaveMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("Active", () -> slaveMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put("MainAccountLuaScript", () -> slaveMode.setMainAccLua(paramValue));
        put("SlaveLuaScript", () -> slaveMode.setSlaveAccLua(paramValue));
        put("ProcessMainAccountTurnFirst", () -> slaveMode.setMainAccFirst(Boolean.parseBoolean(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
