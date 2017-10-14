package model;

/**
 * Created by Trung on 10/14/2017.
 */
public class Summon {

    private String preferredSummon;

    private String defaultSummonTab;

    private boolean rerollSummon;

    public String getPreferredSummon() {
        return preferredSummon;
    }

    public void setPreferredSummon(String preferredSummon) {
        this.preferredSummon = preferredSummon;
    }

    public String getDefaultSummonTab() {
        return defaultSummonTab;
    }

    public void setDefaultSummonTab(String defaultSummonTab) {
        this.defaultSummonTab = defaultSummonTab;
    }

    public boolean isRerollSummon() {
        return rerollSummon;
    }

    public void setRerollSummon(boolean rerollSummon) {
        this.rerollSummon = rerollSummon;
    }
}
