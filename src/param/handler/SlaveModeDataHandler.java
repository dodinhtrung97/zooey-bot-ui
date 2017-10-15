package param.handler;

import constant.Constant;
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
        put(Constant.ACTIVE, () -> slaveMode.setEnabled(Boolean.parseBoolean(paramValue)));
        put(Constant.MAIN_LUA_SCRIPT, () -> slaveMode.setMainAccLua(paramValue));
        put(Constant.SLAVE_LUA_SCRIPT, () -> slaveMode.setSlaveAccLua(paramValue));
        put(Constant.MAIN_ACCOUNT_FIRST, () -> slaveMode.setMainAccFirst(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.ACTIVE, () ->
                fileParseService.applyData(fileContent, Constant.ACTIVE,
                        Constant.ACTIVE + "=" + slaveMode.isEnabled(),
                        Constant.MODE_SLAVE));
        put(Constant.MAIN_LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.MAIN_LUA_SCRIPT,
                        Constant.MAIN_LUA_SCRIPT + "=" + slaveMode.getMainAccLua(),
                        Constant.MODE_SLAVE));
        put(Constant.SLAVE_LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.SLAVE_LUA_SCRIPT,
                        Constant.SLAVE_LUA_SCRIPT + "=" + slaveMode.getSlaveAccLua(),
                        Constant.MODE_SLAVE));
        put(Constant.MAIN_ACCOUNT_FIRST, () ->
                fileParseService.applyData(fileContent, Constant.MAIN_ACCOUNT_FIRST,
                        Constant.MAIN_ACCOUNT_FIRST + "=" + slaveMode.isMainAccFirst(),
                        Constant.MODE_SLAVE));
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
