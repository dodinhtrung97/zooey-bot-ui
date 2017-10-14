package param.handler;

import model.Summon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class SummonDataHandler {

    private Summon summon;

    private String paramValue;

    public void setSummon(Summon summon) {
        this.summon = summon;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("PreferredSummons", () -> summon.setPreferredSummon(paramValue));
        put("DefaultSummonAttributeTab", () -> summon.setDefaultSummonTab(paramValue));
        put("RerollSummonWhenNoPreferredSummonWasFound", () -> summon.setRerollSummon(Boolean.parseBoolean(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
