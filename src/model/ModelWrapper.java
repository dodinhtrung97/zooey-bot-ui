package model;

/**
 * Created by Trung on 10/14/2017.
 */
public class ModelWrapper {

    private General general;

    private CountdownTimer countdownTimer;

    private SlaveMode slaveMode;

    private Input input;

    private PartySelection partySelection;

    private Summon summon;

    private Combat combat;

    private EventMode eventMode;

    private TreasureEventMode treasureEventMode;

    private SoloCoopMode soloCoopMode;

    private CustomizedScheduling customizedScheduling;

    private Debug debug;

    private Alerting alerting;

    private DimensionalHalo dimensionalHalo;

    public ModelWrapper() {
        this.general = new General();
        this.countdownTimer = new CountdownTimer();
        this.slaveMode = new SlaveMode();
        this.input = new Input();
        this.partySelection = new PartySelection();
        this.summon = new Summon();
        this.combat = new Combat();
        this.eventMode = new EventMode();
        this.treasureEventMode = new TreasureEventMode();
        this.soloCoopMode = new SoloCoopMode();
        this.customizedScheduling = new CustomizedScheduling();
        this.debug = new Debug();
        this.alerting = new Alerting();
        this.dimensionalHalo = new DimensionalHalo();
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public CountdownTimer getCountdownTimer() {
        return countdownTimer;
    }

    public void setCountdownTimer(CountdownTimer countdownTimer) {
        this.countdownTimer = countdownTimer;
    }

    public SlaveMode getSlaveMode() {
        return slaveMode;
    }

    public void setSlaveMode(SlaveMode slaveMode) {
        this.slaveMode = slaveMode;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public PartySelection getPartySelection() {
        return partySelection;
    }

    public void setPartySelection(PartySelection partySelection) {
        this.partySelection = partySelection;
    }

    public Summon getSummon() {
        return summon;
    }

    public void setSummon(Summon summon) {
        this.summon = summon;
    }

    public Combat getCombat() {
        return combat;
    }

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    public EventMode getEventMode() {
        return eventMode;
    }

    public void setEventMode(EventMode eventMode) {
        this.eventMode = eventMode;
    }

    public TreasureEventMode getTreasureEventMode() {
        return treasureEventMode;
    }

    public void setTreasureEventMode(TreasureEventMode treasureEventMode) {
        this.treasureEventMode = treasureEventMode;
    }

    public SoloCoopMode getSoloCoopMode() {
        return soloCoopMode;
    }

    public void setSoloCoopMode(SoloCoopMode soloCoopMode) {
        this.soloCoopMode = soloCoopMode;
    }

    public CustomizedScheduling getCustomizedScheduling() {
        return customizedScheduling;
    }

    public void setCustomizedScheduling(CustomizedScheduling customizedScheduling) {
        this.customizedScheduling = customizedScheduling;
    }

    public Debug getDebug() {
        return debug;
    }

    public void setDebug(Debug debug) {
        this.debug = debug;
    }

    public Alerting getAlerting() {
        return alerting;
    }

    public void setAlerting(Alerting alerting) {
        this.alerting = alerting;
    }

    public DimensionalHalo getDimensionalHalo() {
        return dimensionalHalo;
    }

    public void setDimensionalHalo(DimensionalHalo dimensionalHalo) {
        this.dimensionalHalo = dimensionalHalo;
    }
}
