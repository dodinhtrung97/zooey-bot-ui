package model;

/**
 * Created by Trung on 10/14/2017.
 */
public class Combat {

    private long minWaitTimeAfterAttack;

    private long minWaitTimeAfterSummon;

    private long minWaitTimeAfterAbility;

    private String luaScript;

    private boolean reloadPage;

    private boolean notWaitForServerResponse;

    private long maxWaitTimeToLoadCharacterSelection;

    private boolean retrieveStatusEffects;

    public long getMinWaitTimeAfterAttack() {
        return minWaitTimeAfterAttack;
    }

    public void setMinWaitTimeAfterAttack(long minWaitTimeAfterAttack) {
        this.minWaitTimeAfterAttack = minWaitTimeAfterAttack;
    }

    public long getMinWaitTimeAfterSummon() {
        return minWaitTimeAfterSummon;
    }

    public void setMinWaitTimeAfterSummon(long minWaitTimeAfterSummon) {
        this.minWaitTimeAfterSummon = minWaitTimeAfterSummon;
    }

    public long getMinWaitTimeAfterAbility() {
        return minWaitTimeAfterAbility;
    }

    public void setMinWaitTimeAfterAbility(long minWaitTimeAfterAbility) {
        this.minWaitTimeAfterAbility = minWaitTimeAfterAbility;
    }

    public String getLuaScript() {
        return luaScript;
    }

    public void setLuaScript(String luaScript) {
        this.luaScript = luaScript;
    }

    public boolean isReloadPage() {
        return reloadPage;
    }

    public void setReloadPage(boolean reloadPage) {
        this.reloadPage = reloadPage;
    }

    public boolean isNotWaitForServerResponse() {
        return notWaitForServerResponse;
    }

    public void setNotWaitForServerResponse(boolean notWaitForServerResponse) {
        this.notWaitForServerResponse = notWaitForServerResponse;
    }

    public long getMaxWaitTimeToLoadCharacterSelection() {
        return maxWaitTimeToLoadCharacterSelection;
    }

    public void setMaxWaitTimeToLoadCharacterSelection(long maxWaitTimeToLoadCharacterSelection) {
        this.maxWaitTimeToLoadCharacterSelection = maxWaitTimeToLoadCharacterSelection;
    }

    public boolean isRetrieveStatusEffects() {
        return retrieveStatusEffects;
    }

    public void setRetrieveStatusEffects(boolean retrieveStatusEffects) {
        this.retrieveStatusEffects = retrieveStatusEffects;
    }
}
