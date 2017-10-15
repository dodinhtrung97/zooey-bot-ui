package param.handler;

import constant.Constant;
import model.CountdownTimer;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class CountdownTimerDataHandler {

    private CountdownTimer countdownTimer;

    private String paramValue;

    private List<String> fileContent;

    public void setCountdownTimer(CountdownTimer countdownTimer) {
        this.countdownTimer = countdownTimer;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put(Constant.COUNTDOWN_HORIZONTAL, () -> countdownTimer.setCountdownTimerHorizontalPos(Integer.parseInt(paramValue)));
        put(Constant.COUNTDOWN_VERTICAL, () -> countdownTimer.setCountdownTimerVerticalPos(Integer.parseInt(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.COUNTDOWN_HORIZONTAL, () ->
                fileParseService.applyData(fileContent, Constant.COUNTDOWN_HORIZONTAL,
                        Constant.COUNTDOWN_HORIZONTAL + "=" + countdownTimer.getCountdownTimerHorizontalPos(),
                        Constant.MODE_GENERAL));
        put(Constant.COUNTDOWN_VERTICAL, () ->
                fileParseService.applyData(fileContent, Constant.COUNTDOWN_VERTICAL,
                        Constant.COUNTDOWN_VERTICAL + "=" + countdownTimer.getCountdownTimerVerticalPos(),
                        Constant.MODE_GENERAL));
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
