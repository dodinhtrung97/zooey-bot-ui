package model;

import constant.Constant;

/**
 * Created by Trung on 10/14/2017.
 */
public class TreasureEventMode extends AbstractEvent{

    private String treasureEventUrl;

    private String difficulty;

    private String actionPointCost;

    private String treasureEventModeScript;

    public String getTreasureEventUrl() {
        return treasureEventUrl;
    }

    public void setTreasureEventUrl(String treasureEventUrl) {
        this.treasureEventUrl = treasureEventUrl;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getActionPointCost() {
        return actionPointCost;
    }

    public void setActionPointCost(String actionPointCost) {
        this.actionPointCost = actionPointCost;
    }

    public String getTreasureEventModeScript() {
        return treasureEventModeScript;
    }

    public void setTreasureEventModeScript(String treasureEventModeScript) {
        this.treasureEventModeScript = treasureEventModeScript;
    }

    public String getNameByDifficulty() {

        String neverHappening = "";

        for (String key: Constant.TREASURE_RAIDS.keySet()) {
            if (Constant.TREASURE_RAIDS.get(key).equals(this.getDifficulty()))
                return key;
        }
        return neverHappening;
    }
}
