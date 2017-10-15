package param.handler;

import model.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class InputDataHandler {

    private Input input;

    private String paramValue;

    private int lineNum;

    private List<String> fileContent;

    public void setInput(Input input) {
        this.input = input;
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
        put("DelayInMsBetweenMouseDownAndUp", () -> input.setDelayBetweenMouseDownAndUp(Long.parseLong(paramValue)));
        put("RandomDelayInMsBetweenMouseDownAndUp", () -> input.setRandomDelayBetweenDownAndUp(Long.parseLong(paramValue)));
        put("MouseSpeed", () -> input.setMouseSpeed(Long.parseLong(paramValue)));
        put("MouseScrollSpeed", () -> input.setMouseScrollSpeed(Long.parseLong(paramValue)));
        put("ExitKeyCode", () -> input.setExitKeyCode(Long.parseLong(paramValue)));
        put("WaitTimeInMsBeforeClickInput", () -> input.setWaitTimeBeforeClickInput(Long.parseLong(paramValue)));
    }};

    public void handleInject(String param) {
        if (!SET_OBJECT.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        SET_OBJECT.get(param).run();
    }
}
