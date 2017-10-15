package param.handler;

import model.Input;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class InputDataHandler {

    private Input input;

    private String paramValue;

    private List<String> fileContent;

    public void setInput(Input input) {
        this.input = input;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put("DelayInMsBetweenMouseDownAndUp", () -> input.setDelayBetweenMouseDownAndUp(Long.parseLong(paramValue)));
        put("RandomDelayInMsBetweenMouseDownAndUp", () -> input.setRandomDelayBetweenDownAndUp(Long.parseLong(paramValue)));
        put("MouseSpeed", () -> input.setMouseSpeed(Long.parseLong(paramValue)));
        put("MouseScrollSpeed", () -> input.setMouseScrollSpeed(Long.parseLong(paramValue)));
        put("ExitKeyCode", () -> input.setExitKeyCode(Long.parseLong(paramValue)));
        put("WaitTimeInMsBeforeClickInput", () -> input.setWaitTimeBeforeClickInput(Long.parseLong(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("DelayInMsBetweenMouseDownAndUp", () ->
                fileParseService.applyData(fileContent, "DelayInMsBetweenMouseDownAndUp",
                        "DelayInMsBetweenMouseDownAndUp=" + input.getDelayBetweenMouseDownAndUp()));
        put("RandomDelayInMsBetweenMouseDownAndUp", () ->
                fileParseService.applyData(fileContent, "RandomDelayInMsBetweenMouseDownAndUp",
                        "RandomDelayInMsBetweenMouseDownAndUp=" + input.getRandomDelayBetweenDownAndUp()));
        put("MouseSpeed", () ->
                fileParseService.applyData(fileContent, "MouseSpeed", "MouseSpeed=" + input.getMouseSpeed()));
        put("MouseScrollSpeed", () ->
                fileParseService.applyData(fileContent, "MouseScrollSpeed",
                        "MouseScrollSpeed=" + input.getMouseScrollSpeed()));
        put("ExitKeyCode", () ->
                fileParseService.applyData(fileContent, "ExitKeyCode",
                        "ExitKeyCode=" + input.getExitKeyCode()));
        put("WaitTimeInMsBeforeClickInput", () ->
                fileParseService.applyData(fileContent, "WaitTimeInMsBeforeClickInput",
                        "WaitTimeInMsBeforeClickInput=" + input.getWaitTimeBeforeClickInput()));
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
