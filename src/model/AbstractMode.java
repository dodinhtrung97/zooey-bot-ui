package model;

/**
 * Created by Trung on 10/14/2017.
 */
public abstract class AbstractMode {

    private boolean isEnabled;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
