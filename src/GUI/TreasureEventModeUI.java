package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelWrapper;
import model.TreasureEventMode;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Trung on 10/14/2017.
 */
public class TreasureEventModeUI {

    private final FileChooser fileChooser = new FileChooser();
    private File treasureEventLua;
    private String treasureEventLuaPath = "";
    private File treasureEventNightmareLua;
    private String treasureEventNightmareLuaPath = "";

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    @SuppressWarnings("Duplicates")
    public VBox drawMainPane(Stage primaryStage, ModelWrapper modelWrapper) {
        TreasureEventMode treasureEventMode = modelWrapper.getTreasureEventMode();

        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // EventRaidUrl
        TextField treasureEventRaidURL = new TextField();
        treasureEventRaidURL.setText(String.valueOf(treasureEventMode.getTreasureEventUrl()));

        grid.add(treasureEventRaidURL,1,1);
        grid.add(new Label("Treasure Event raid URL:"), 0, 1);

        // LuaScript
        Button eventLuaScript = new Button("Browse");
        eventLuaScript.setOnAction(e -> {
            treasureEventLua = fileChooser.showOpenDialog(primaryStage);
            if (treasureEventLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(treasureEventLua.getAbsolutePath());
                treasureEventLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(eventLuaScript,1,2);
        grid.add(new Label("Treasure Event Lua Script:"), 0, 2);

        // Difficulty
        ChoiceBox<String> difficulty = new ChoiceBox<>();
        difficulty.getItems().addAll(Constant.TREASURE_RAIDS.keySet());
        difficulty.setValue(treasureEventMode.getNameByDifficulty(treasureEventMode.getDifficulty()));

        grid.add(difficulty,1,3);
        grid.add(new Label("Difficulty:"), 0, 3);

        // AP Cost
        TextField actionPointCost = new TextField();
        actionPointCost.setText(String.valueOf(treasureEventMode.getActionPointCost()));

        grid.add(actionPointCost,1,4);
        grid.add(new Label("Action Points Cost:"), 0, 4);

        // NightmareModeUrl
        TextField nightmareModeURL = new TextField();
        nightmareModeURL.setText(String.valueOf(treasureEventMode.getNightmareModeUrl()));

        grid.add(nightmareModeURL,1,5);
        grid.add(new Label("Treasure Event Nightmare raid URL:"), 0, 5);

        // LuaScript
        Button treasureEventNightmareLuaScript = new Button("Browse");
        eventLuaScript.setOnAction(e -> {
            treasureEventNightmareLua = fileChooser.showOpenDialog(primaryStage);
            if (treasureEventNightmareLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(treasureEventNightmareLua.getAbsolutePath());
                treasureEventNightmareLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(treasureEventNightmareLuaScript,1,6);
        grid.add(new Label("Treasure Event Nightmare Lua Script:"), 0, 6);

        // NightmareModePreferredSummon
        TextField nightmareModePreferredSummon = new TextField();
        nightmareModePreferredSummon.setText(treasureEventMode.getNightmareModePreferredSummon());

        grid.add(nightmareModePreferredSummon,1,7);
        grid.add(new Label("Treasure Event Preferred Summon:"), 0, 7);

        // RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode
        CheckBox rerollForSummon = new CheckBox();
        rerollForSummon.setSelected(treasureEventMode.isRerollForSummon());

        grid.add(rerollForSummon,1,8);
        grid.add(new Label("Reroll For Summon during nightmare:"), 0, 8);

        // NightmareModeAvailableAtStart
        CheckBox nightmareAtStart = new CheckBox();
        nightmareAtStart.setSelected(treasureEventMode.isNightmareModeAvailableAtStart());

        grid.add(nightmareAtStart,1,9);
        grid.add(new Label("Nightmare Mode available at start:"), 0, 9);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, nightmareModeURL.getText(), treasureEventLuaPath,
                                        actionPointCost.getText(), nightmareModeURL.getText(), treasureEventNightmareLuaPath,
                                        nightmareModePreferredSummon.getText(), rerollForSummon.isSelected(),
                                        nightmareAtStart.isSelected()));
        grid.add(save, 1, 10);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save to TreasureEventMode
     * @param modelWrapper
     * @param treasureEventURL
     * @param treasureEventLuaPath
     * @param actionPointCost
     * @param nightmareModeURL
     * @param nightmareLuaPath
     * @param nightmareModePreferredSummon
     * @param rerollForSummon
     * @param nightmareAtStart
     */
    private void handleSave(ModelWrapper modelWrapper, String treasureEventURL, String treasureEventLuaPath,
                            String actionPointCost, String nightmareModeURL, String nightmareLuaPath,
                            String nightmareModePreferredSummon, boolean rerollForSummon, boolean nightmareAtStart) {
        TreasureEventMode treasureEventMode = modelWrapper.getTreasureEventMode();

        treasureEventMode.setTreasureEventUrl(treasureEventURL);
        treasureEventMode.setTreasureEventModeScript(treasureEventLuaPath);
        treasureEventMode.setActionPointCost(actionPointCost);
        treasureEventMode.setNightmareModeUrl(nightmareModeURL);
        treasureEventMode.setNightmareModeScript(nightmareLuaPath);
        treasureEventMode.setNightmareModePreferredSummon(nightmareModePreferredSummon);
        treasureEventMode.setRerollForSummon(rerollForSummon);
        treasureEventMode.setNightmareModeAvailableAtStart(nightmareAtStart);
    }
}
