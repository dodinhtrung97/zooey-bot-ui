package param.handler;

import constant.Constant;
import model.CustomizedScheduling;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class CustomizedSchedulingDataHandler {

    private CustomizedScheduling customizedScheduling;

    private String paramValue;

    private List<String> fileContent;

    public void setCustomizedScheduling(CustomizedScheduling customizedScheduling) {
        this.customizedScheduling = customizedScheduling;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put(Constant.ENABLE, () -> customizedScheduling.setEnabled(Boolean.parseBoolean(paramValue)));
        put(Constant.SCHEDULING_LUA_SCRIPT, () -> customizedScheduling.setLuaScript(paramValue));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.ENABLE, () ->
                fileParseService.applyData(fileContent, Constant.ENABLE,
                        Constant.ENABLE + "=" + customizedScheduling.isEnabled(),
                        Constant.MODE_CUSTOMIZED_SCHEDULING));
        put(Constant.SCHEDULING_LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.SCHEDULING_LUA_SCRIPT,
                        Constant.SCHEDULING_LUA_SCRIPT + "=" + customizedScheduling.getLuaScript(),
                        Constant.MODE_CUSTOMIZED_SCHEDULING));
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
