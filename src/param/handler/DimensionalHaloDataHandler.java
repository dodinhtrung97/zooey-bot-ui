package param.handler;

import model.DimensionalHalo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class DimensionalHaloDataHandler {

    private DimensionalHalo dimensionalHalo;

    private String paramValue;

    public void setDimensionalHalo(DimensionalHalo dimensionalHalo) {
        this.dimensionalHalo = dimensionalHalo;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("RetreatWhenNoDimensionalHaloTransformation", () ->
                dimensionalHalo.setRetreatWhenNoDimensionalHaloTransform(Boolean.parseBoolean(paramValue)));
    }};

    public void handle(String param) {
        if (!FUNCTIONS.containsKey(param)) {
            System.out.println("Unknown paramater: " + param);
            return;
        }
        FUNCTIONS.get(param).run();
    }
}
