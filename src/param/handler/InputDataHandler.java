package param.handler;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import constant.Constant;
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
        put(Constant.DELAY_MOUSE_UP_DOWN, () -> input.setDelayBetweenMouseDownAndUp(Long.parseLong(paramValue)));
        put(Constant.RANDOM_DELAY_MOUSE_UP_DOWN, () -> input.setRandomDelayBetweenDownAndUp(Long.parseLong(paramValue)));
        put(Constant.MOUSE_SPEED, () -> input.setMouseSpeed(Long.parseLong(paramValue)));
        put(Constant.MOUSE_SCROLL_SPEED, () -> input.setMouseScrollSpeed(Long.parseLong(paramValue)));
        put(Constant.EXIT_KEY_CODE, () -> input.setExitKeyCode(Long.parseLong(paramValue)));
        put(Constant.WAIT_TIME_BEFORE_CLICK_INPUT, () -> input.setWaitTimeBeforeClickInput(Long.parseLong(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.DELAY_MOUSE_UP_DOWN, () ->
                fileParseService.applyData(fileContent, Constant.DELAY_MOUSE_UP_DOWN,
                        Constant.DELAY_MOUSE_UP_DOWN + "=" + input.getDelayBetweenMouseDownAndUp(),
                        Constant.MODE_INPUT));
        put(Constant.RANDOM_DELAY_MOUSE_UP_DOWN, () ->
                fileParseService.applyData(fileContent, Constant.RANDOM_DELAY_MOUSE_UP_DOWN,
                        Constant.RANDOM_DELAY_MOUSE_UP_DOWN + "=" + input.getRandomDelayBetweenDownAndUp(),
                        Constant.MODE_INPUT));
        put(Constant.MOUSE_SPEED, () ->
                fileParseService.applyData(fileContent, Constant.MOUSE_SPEED, Constant.MOUSE_SPEED + "=" + input.getMouseSpeed(),
                        Constant.MODE_INPUT));
        put(Constant.MOUSE_SCROLL_SPEED, () ->
                fileParseService.applyData(fileContent, Constant.MOUSE_SCROLL_SPEED,
                        Constant.MOUSE_SCROLL_SPEED + "=" + input.getMouseScrollSpeed(),
                        Constant.MODE_INPUT));
        put(Constant.EXIT_KEY_CODE, () ->
                fileParseService.applyData(fileContent, Constant.EXIT_KEY_CODE,
                        Constant.EXIT_KEY_CODE + "=" + input.getExitKeyCode(),
                        Constant.MODE_INPUT));
        put(Constant.WAIT_TIME_BEFORE_CLICK_INPUT, () ->
                fileParseService.applyData(fileContent, Constant.WAIT_TIME_BEFORE_CLICK_INPUT,
                        Constant.WAIT_TIME_BEFORE_CLICK_INPUT + "=" + input.getWaitTimeBeforeClickInput(),
                        Constant.MODE_INPUT));
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
