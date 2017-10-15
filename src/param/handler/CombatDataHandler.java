package param.handler;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import constant.Constant;
import model.Combat;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class CombatDataHandler {

    private Combat combat;

    private String paramValue;

    private List<String> fileContent;

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final Map<String, Runnable> SET_OBJECT = new HashMap<String, Runnable>() {{
        put(Constant.MIN_WAIT_AFTER_ATTACK, () -> combat.setMinWaitTimeAfterAttack(Long.parseLong(paramValue)));
        put(Constant.MIN_WAIT_AFTER_SUMMON, () -> combat.setMinWaitTimeAfterSummon(Long.parseLong(paramValue)));
        put(Constant.MIN_WAIT_AFTER_ABILITY, () -> combat.setMinWaitTimeAfterAbility(Long.parseLong(paramValue)));
        put(Constant.LUA_SCRIPT, () -> combat.setLuaScript(paramValue));
        put(Constant.RELOAD_ON_LAST_BATTLE, () -> combat.setReloadPage(Boolean.parseBoolean(paramValue)));
        put(Constant.NOT_WAIT_FOR_SERVER_RESPONSE, () -> combat.setNotWaitForServerResponse(Boolean.parseBoolean(paramValue)));
        put(Constant.MAX_WAIT_TIME_TO_LOAD_SELECTION, () -> combat.setMaxWaitTimeToLoadCharacterSelection(Long.parseLong(paramValue)));
        put(Constant.RETRIEVE_STATUS_EFFECT, () -> combat.setRetrieveStatusEffects(Boolean.parseBoolean(paramValue)));
    }};

    private final Map<String, Runnable> SET_OBJECT_TO_FILE = new HashMap<String, Runnable>() {{
        put(Constant.MIN_WAIT_AFTER_ATTACK, () ->
                fileParseService.applyData(fileContent, Constant.MIN_WAIT_AFTER_ATTACK,
                        Constant.MIN_WAIT_AFTER_ATTACK + "=" + combat.getMinWaitTimeAfterAttack(),
                        Constant.MODE_COMBAT));
        put(Constant.MIN_WAIT_AFTER_SUMMON, () ->
                fileParseService.applyData(fileContent, Constant.MIN_WAIT_AFTER_SUMMON,
                        Constant.MIN_WAIT_AFTER_SUMMON + "=" + combat.getMinWaitTimeAfterSummon(),
                        Constant.MODE_COMBAT));
        put(Constant.MIN_WAIT_AFTER_ABILITY, () ->
                fileParseService.applyData(fileContent, Constant.MIN_WAIT_AFTER_ABILITY,
                        Constant.MIN_WAIT_AFTER_ABILITY + "=" + combat.getMinWaitTimeAfterAbility(),
                        Constant.MODE_COMBAT));
        put(Constant.LUA_SCRIPT, () ->
                fileParseService.applyData(fileContent, Constant.LUA_SCRIPT,
                        Constant.LUA_SCRIPT + "=" + combat.getLuaScript(),
                        Constant.MODE_COMBAT));
        put(Constant.RELOAD_ON_LAST_BATTLE, () ->
                fileParseService.applyData(fileContent, Constant.RELOAD_ON_LAST_BATTLE,
                        Constant.RELOAD_ON_LAST_BATTLE + "=" + combat.isReloadPage(),
                        Constant.MODE_COMBAT));
        put(Constant.NOT_WAIT_FOR_SERVER_RESPONSE, () ->
                fileParseService.applyData(fileContent, Constant.NOT_WAIT_FOR_SERVER_RESPONSE,
                        Constant.NOT_WAIT_FOR_SERVER_RESPONSE + "=" + combat.isNotWaitForServerResponse(),
                        Constant.MODE_COMBAT));
        put(Constant.MAX_WAIT_TIME_TO_LOAD_SELECTION, () ->
                fileParseService.applyData(fileContent, Constant.MAX_WAIT_TIME_TO_LOAD_SELECTION,
                        Constant.MAX_WAIT_TIME_TO_LOAD_SELECTION + "=" + combat.getMaxWaitTimeToLoadCharacterSelection(),
                        Constant.MODE_COMBAT));
        put(Constant.RETRIEVE_STATUS_EFFECT, () ->
                fileParseService.applyData(fileContent, Constant.RETRIEVE_STATUS_EFFECT,
                        Constant.RETRIEVE_STATUS_EFFECT + "=" + combat.isRetrieveStatusEffects(),
                        Constant.MODE_COMBAT));
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
