package model;

/**
 * Created by Trung on 10/14/2017.
 */
public class Input {

    private long delayBetweenMouseDownAndUp;

    private long randomDelayBetweenDownAndUp;

    private long mouseSpeed;

    private long mouseScrollSpeed;

    private long exitKeyCode;

    private long waitTimeBeforeClickInput;

    public long getDelayBetweenMouseDownAndUp() {
        return delayBetweenMouseDownAndUp;
    }

    public void setDelayBetweenMouseDownAndUp(long delayBetweenMouseDownAndUp) {
        this.delayBetweenMouseDownAndUp = delayBetweenMouseDownAndUp;
    }

    public long getRandomDelayBetweenDownAndUp() {
        return randomDelayBetweenDownAndUp;
    }

    public void setRandomDelayBetweenDownAndUp(long randomDelayBetweenDownAndUp) {
        this.randomDelayBetweenDownAndUp = randomDelayBetweenDownAndUp;
    }

    public long getMouseSpeed() {
        return mouseSpeed;
    }

    public void setMouseSpeed(long mouseSpeed) {
        this.mouseSpeed = mouseSpeed;
    }

    public long getMouseScrollSpeed() {
        return mouseScrollSpeed;
    }

    public void setMouseScrollSpeed(long mouseScrollSpeed) {
        this.mouseScrollSpeed = mouseScrollSpeed;
    }

    public long getExitKeyCode() {
        return exitKeyCode;
    }

    public void setExitKeyCode(long exitKeyCode) {
        this.exitKeyCode = exitKeyCode;
    }

    public long getWaitTimeBeforeClickInput() {
        return waitTimeBeforeClickInput;
    }

    public void setWaitTimeBeforeClickInput(long waitTimeBeforeClickInput) {
        this.waitTimeBeforeClickInput = waitTimeBeforeClickInput;
    }
}
