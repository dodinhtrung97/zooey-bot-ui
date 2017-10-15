package model;

import constant.Constant;

/**
 * Created by Trung on 10/14/2017.
 */
public class General {

    private String language;

    private boolean isDevToolsDockedOnTheRight;

    private long maxLoadDelay;

    private long maxTriggerDelay;

    private long maxResponseDelay;

    private int maxNumAction;

    private long minWaitTime;

    private long timeLimit;

    private boolean isUseViramate;

    private long maxNumPotion;

    private boolean useFullEx;

    private boolean useFullExFirst;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isDevToolsDockedOnTheRight() {
        return isDevToolsDockedOnTheRight;
    }

    public void setDevToolsDockedOnTheRight(boolean devToolsDockedOnTheRight) {
        isDevToolsDockedOnTheRight = devToolsDockedOnTheRight;
    }

    public long getMaxLoadDelay() {
        return maxLoadDelay;
    }

    public void setMaxLoadDelay(long maxLoadDelay) {
        this.maxLoadDelay = maxLoadDelay;
    }

    public long getMaxTriggerDelay() {
        return maxTriggerDelay;
    }

    public void setMaxTriggerDelay(long maxTriggerDelay) {
        this.maxTriggerDelay = maxTriggerDelay;
    }

    public long getMaxResponseDelay() {
        return maxResponseDelay;
    }

    public void setMaxResponseDelay(long maxResponseDelay) {
        this.maxResponseDelay = maxResponseDelay;
    }

    public int getMaxNumAction() {
        return maxNumAction;
    }

    public void setMaxNumAction(int maxNumAction) {
        this.maxNumAction = maxNumAction;
    }

    public long getMinWaitTime() {
        return minWaitTime;
    }

    public void setMinWaitTime(long minWaitTime) {
        this.minWaitTime = minWaitTime;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isUseViramate() {
        return isUseViramate;
    }

    public void setUseViramate(boolean useViramate) {
        isUseViramate = useViramate;
    }

    public long getMaxNumPotion() {
        return maxNumPotion;
    }

    public void setMaxNumPotion(long maxNumPotion) {
        this.maxNumPotion = maxNumPotion;
    }

    public boolean isUseFullEx() {
        return useFullEx;
    }

    public void setUseFullEx(boolean userFullEx) {
        this.useFullEx = userFullEx;
    }

    public boolean isUseFullExFirst() {
        return useFullExFirst;
    }

    public void setUseFullExFirst(boolean useFullExFirst) {
        this.useFullExFirst = useFullExFirst;
    }

    public String getNameByLanguage() {
        String neverHappening = "";

        for (String key: Constant.LANGUAGE.keySet()) {
            if (Constant.LANGUAGE.get(key).equals(this.getLanguage()))
                return key;
        }
        return neverHappening;
    }
}
