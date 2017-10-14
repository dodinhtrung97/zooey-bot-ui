package model;

/**
 * Created by Trung on 10/14/2017.
 */
public class Alerting {

    private String captchaNotificationSoundPath;

    private long numNotification;

    private long maxNumSummonSelectionFailuresBeforePlayingSound;

    public String getCaptchaNotificationSoundPath() {
        return captchaNotificationSoundPath;
    }

    public void setCaptchaNotificationSoundPath(String captchaNotificationSoundPath) {
        this.captchaNotificationSoundPath = captchaNotificationSoundPath;
    }

    public long getNumNotification() {
        return numNotification;
    }

    public void setNumNotification(long numNotification) {
        this.numNotification = numNotification;
    }

    public long getMaxNumSummonSelectionFailuresBeforePlayingSound() {
        return maxNumSummonSelectionFailuresBeforePlayingSound;
    }

    public void setMaxNumSummonSelectionFailuresBeforePlayingSound(long maxNumSummonSelectionFailuresBeforePlayingSound) {
        this.maxNumSummonSelectionFailuresBeforePlayingSound = maxNumSummonSelectionFailuresBeforePlayingSound;
    }
}
