package param.handler;

import model.CountdownTimer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class CountdownTimerDataHandler {

    private CountdownTimer countdownTimer;

    private String paramValue;

    public void setCountdownTimer(CountdownTimer countdownTimer) {
        this.countdownTimer = countdownTimer;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("CountdownTimerHorizontalPosition", () -> countdownTimer.setCountdownTimerHorizontalPos(Integer.parseInt(paramValue)));
        put("CountdownTimerVerticalPosition", () -> countdownTimer.setCountdownTimerVerticalPos(Integer.parseInt(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
