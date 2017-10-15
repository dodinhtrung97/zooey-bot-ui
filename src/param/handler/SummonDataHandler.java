package param.handler;

import model.Summon;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class SummonDataHandler {

    private Summon summon;

    private String paramValue;

    private List<String> fileContent;

    public void setSummon(Summon summon) {
        this.summon = summon;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put("PreferredSummons", () -> summon.setPreferredSummon(paramValue));
        put("DefaultSummonAttributeTab", () -> summon.setDefaultSummonTab(paramValue));
        put("RerollSummonWhenNoPreferredSummonWasFound", () -> summon.setRerollSummon(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put("PreferredSummons", () ->
                fileParseService.applyData(fileContent, "PreferredSummons",
                        "PreferredSummons=" + summon.getPreferredSummon()));
        put("DefaultSummonAttributeTab", () ->
                fileParseService.applyData(fileContent, "DefaultSummonAttributeTab",
                        "DefaultSummonAttributeTab=" + summon.getDefaultSummonTab()));
        put("RerollSummonWhenNoPreferredSummonWasFound", () ->
                fileParseService.applyData(fileContent, "RerollSummonWhenNoPreferredSummonWasFound",
                        "RerollSummonWhenNoPreferredSummonWasFound=" + summon.isRerollSummon()));
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
