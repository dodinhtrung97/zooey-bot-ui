package param.handler;

import constant.Constant;
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
        put(Constant.PREFERRED_SUMMONS, () -> summon.setPreferredSummon(paramValue));
        put(Constant.DEFAULT_SUMMON_TAB, () -> summon.setDefaultSummonTab(paramValue));
        put(Constant.REROLL_FOR_SUMMON, () -> summon.setRerollSummon(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.PREFERRED_SUMMONS, () ->
                fileParseService.applyData(fileContent, Constant.PREFERRED_SUMMONS,
                        Constant.PREFERRED_SUMMONS + "=" + summon.getPreferredSummon(),
                        Constant.MODE_SUMMON));
        put(Constant.DEFAULT_SUMMON_TAB, () ->
                fileParseService.applyData(fileContent, Constant.DEFAULT_SUMMON_TAB,
                        Constant.DEFAULT_SUMMON_TAB + "=" + summon.getDefaultSummonTab(),
                        Constant.MODE_SUMMON));
        put(Constant.REROLL_FOR_SUMMON, () ->
                fileParseService.applyData(fileContent, Constant.REROLL_FOR_SUMMON,
                        Constant.REROLL_FOR_SUMMON + "=" + summon.isRerollSummon(),
                        Constant.MODE_SUMMON));
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
