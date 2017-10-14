package model;

/**
 * Created by Trung on 10/14/2017.
 */
public class SlaveMode extends AbstractMode{

    private String mainAccLua;

    private String slaveAccLua;

    private boolean mainAccFirst;

    public String getMainAccLua() {
        return mainAccLua;
    }

    public void setMainAccLua(String mainAccLua) {
        this.mainAccLua = mainAccLua;
    }

    public String getSlaveAccLua() {
        return slaveAccLua;
    }

    public void setSlaveAccLua(String slaveAccLua) {
        this.slaveAccLua = slaveAccLua;
    }

    public boolean isMainAccFirst() {
        return mainAccFirst;
    }

    public void setMainAccFirst(boolean mainAccFirst) {
        this.mainAccFirst = mainAccFirst;
    }
}
