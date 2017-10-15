package param.handler;

import GUI.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Trung on 10/14/2017.
 */
public class ButtonTextHandler {

    private BorderPane root;

    private Stage primaryStage;

    private ModelWrapper modelWrapper;

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setModelWrapper(ModelWrapper modelWrapper) {
        this.modelWrapper = modelWrapper;
    }

    private final ModeSelectionUI modeSelectionUI = new ModeSelectionUI();
    private final GeneralUI generalUI = new GeneralUI();
    private final SlaveModeUI slaveModeUI = new SlaveModeUI();
    private final SummonUI summonUI = new SummonUI();
    private final DimensionalHaloUI dimensionalHaloUI = new DimensionalHaloUI();
    private final InputUI inputUI = new InputUI();
    private final PartySelectionUI partySelectionUI = new PartySelectionUI();
    private final EventModeUI eventModeUI = new EventModeUI();
    private final CombatUI combatUI = new CombatUI();
    private final TreasureEventModeUI treasureEventModeUI = new TreasureEventModeUI();
    private final SoloCoopModeUI soloCoopModeUI = new SoloCoopModeUI();
    private final CustomizedSchedulingUI customizedSchedulingUI = new CustomizedSchedulingUI();
    private final AlertingUI alertingUI = new AlertingUI();

    private final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>() {{
        put("Mode Select", () -> root.setRight(modeSelectionUI.drawMainPane(modelWrapper)));
        put("General", () -> root.setRight(generalUI.drawMainPane(modelWrapper)));
        put("Inputs", () -> root.setRight(inputUI.drawMainPane(modelWrapper)));
        put("Party Selection", () -> root.setRight(partySelectionUI.drawMainPane(modelWrapper)));
        put("Summons", () -> root.setRight(summonUI.drawMainPane(modelWrapper)));
        put("Combat", () -> root.setRight(combatUI.drawMainPane(primaryStage, modelWrapper)));
        put("Dimensional Halo", () -> root.setRight(dimensionalHaloUI.drawMainPane(modelWrapper)));
        put("Event Mode", () -> root.setRight(eventModeUI.drawMainPane(primaryStage, modelWrapper)));
        put("Slave Mode", () -> root.setRight(slaveModeUI.drawMainPane(primaryStage, modelWrapper)));
        put("Treasure Event Mode", () -> root.setRight(treasureEventModeUI.drawMainPane(primaryStage, modelWrapper)));
        put("Solo Coop Mode", () -> root.setRight(soloCoopModeUI.drawMainPane(primaryStage, modelWrapper)));
        put("Customized Scheduling", () -> root.setRight(customizedSchedulingUI.drawMainPane(primaryStage, modelWrapper)));
        put("Alerting", () -> root.setRight(alertingUI.drawMainPane(primaryStage, modelWrapper)));
    }};

    public void handle(String buttonName) {
        if (!FUNCTIONS.containsKey(buttonName)) {
            System.out.println("Unknown button: " + buttonName);
            return;
        }
        FUNCTIONS.get(buttonName).run();
    }
}
