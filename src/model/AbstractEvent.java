package model;

/**
 * Created by Trung on 10/14/2017.
 */
public abstract class AbstractEvent extends AbstractMode{

    private String nightmareModeUrl;

    private String nightmareModeScript;

    private String nightmareModePreferredSummon;

    private boolean rerollForSummon;

    private boolean nightmareModeAvailableAtStart;

    public String getNightmareModeUrl() {
        return nightmareModeUrl;
    }

    public void setNightmareModeUrl(String nightmareModeUrl) {
        this.nightmareModeUrl = nightmareModeUrl;
    }

    public String getNightmareModeScript() {
        return nightmareModeScript;
    }

    public void setNightmareModeScript(String nightmareModeScript) {
        this.nightmareModeScript = nightmareModeScript;
    }

    public String getNightmareModePreferredSummon() {
        return nightmareModePreferredSummon;
    }

    public void setNightmareModePreferredSummon(String nightmareModePreferredSummon) {
        this.nightmareModePreferredSummon = nightmareModePreferredSummon;
    }

    public boolean isRerollForSummon() {
        return rerollForSummon;
    }

    public void setRerollForSummon(boolean rerollForSummon) {
        this.rerollForSummon = rerollForSummon;
    }

    public boolean isNightmareModeAvailableAtStart() {
        return nightmareModeAvailableAtStart;
    }

    public void setNightmareModeAvailableAtStart(boolean nightmareModeAvailableAtStart) {
        this.nightmareModeAvailableAtStart = nightmareModeAvailableAtStart;
    }
}
