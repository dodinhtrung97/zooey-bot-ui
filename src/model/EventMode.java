package model;

/**
 * Created by Trung on 10/14/2017.
 */
public class EventMode extends AbstractEvent{

    private String eventRaidUrl;

    private String eventRaidScript;

    private String eventPageUrl;

    private long waitTimeAfterPageLoaded;

    public String getEventRaidUrl() {
        return eventRaidUrl;
    }

    public void setEventRaidUrl(String eventRaidUrl) {
        this.eventRaidUrl = eventRaidUrl;
    }

    public String getEventRaidScript() {
        return eventRaidScript;
    }

    public void setEventRaidScript(String eventRaidScript) {
        this.eventRaidScript = eventRaidScript;
    }

    public String getEventPageUrl() {
        return eventPageUrl;
    }

    public void setEventPageUrl(String eventPageUrl) {
        this.eventPageUrl = eventPageUrl;
    }

    public long getWaitTimeAfterPageLoaded() {
        return waitTimeAfterPageLoaded;
    }

    public void setWaitTimeAfterPageLoaded(long waitTimeAfterPageLoaded) {
        this.waitTimeAfterPageLoaded = waitTimeAfterPageLoaded;
    }

}
