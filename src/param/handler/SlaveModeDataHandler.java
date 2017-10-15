package param.handler;

import model.SlaveMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class SlaveModeDataHandler {

    private SlaveMode slaveMode;

    private String paramValue;

    private int lineNum;

    private List<String> fileContent;

    public void setSlaveMode(SlaveMode slaveMode) {
        this.slaveMode = slaveMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put("Active", () -> slaveMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put("MainAccountLuaScript", () -> slaveMode.setMainAccLua(paramValue));
        put("SlaveLuaScript", () -> slaveMode.setSlaveAccLua(paramValue));
        put("ProcessMainAccountTurnFirst", () -> slaveMode.setMainAccFirst(Boolean.parseBoolean(paramValue)));
    }};

    public void handleInject(String param) {
        if (!SET_OBJECT.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        SET_OBJECT.get(param).run();
    }
}
