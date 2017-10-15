package param.handler;

import model.SlaveMode;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class SlaveModeDataHandler {

    private SlaveMode slaveMode;

    private String paramValue;

    private List<String> fileContent;

    public void setSlaveMode(SlaveMode slaveMode) {
        this.slaveMode = slaveMode;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put("Active", () -> slaveMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put("MainAccountLuaScript", () -> slaveMode.setMainAccLua(paramValue));
        put("SlaveLuaScript", () -> slaveMode.setSlaveAccLua(paramValue));
        put("ProcessMainAccountTurnFirst", () -> slaveMode.setMainAccFirst(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("Active", () ->
                fileParseService.applyData(fileContent, "Active",
                        "Active=" + slaveMode.isEnabled()));
        put("MainAccountLuaScript", () ->
                fileParseService.applyData(fileContent, "MainAccountLuaScript",
                        "MainAccountLuaScript=" + slaveMode.getMainAccLua()));
        put("SlaveLuaScript", () ->
                fileParseService.applyData(fileContent, "SlaveLuaScript",
                        "SlaveLuaScript=" + slaveMode.getSlaveAccLua()));
        put("ProcessMainAccountTurnFirst", () ->
                fileParseService.applyData(fileContent, "ProcessMainAccountTurnFirst",
                        "ProcessMainAccountTurnFirst=" + slaveMode.isMainAccFirst()));
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
