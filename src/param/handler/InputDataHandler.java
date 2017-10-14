package param.handler;

import model.Input;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class InputDataHandler {

    private Input input;

    private String paramValue;

    public void setInput(Input input) {
        this.input = input;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("DelayInMsBetweenMouseDownAndUp", () -> input.setDelayBetweenMouseDownAndUp(Long.parseLong(paramValue)));
        put("RandomDelayInMsBetweenMouseDownAndUp", () -> input.setRandomDelayBetweenDownAndUp(Long.parseLong(paramValue)));
        put("MouseSpeed", () -> input.setMouseSpeed(Long.parseLong(paramValue)));
        put("MouseScrollSpeed", () -> input.setMouseScrollSpeed(Long.parseLong(paramValue)));
        put("ExitKeyCode", () -> input.setExitKeyCode(Long.parseLong(paramValue)));
        put("WaitTimeInMsBeforeClickInput", () -> input.setWaitTimeBeforeClickInput(Long.parseLong(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
