package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Combat;
import model.ModelWrapper;
import model.Summon;

import java.io.File;

/**
 * Created by Trung on 10/14/2017.
 */
public class CombatUI {

    private final FileChooser fileChooser = new FileChooser();
    private File luaFile;
    private String luaPath = "";

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(Stage primaryStage, ModelWrapper modelWrapper) {
        Combat combat = modelWrapper.getCombat();

        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // MinWaitTimeInMsAfterAttack
        TextField minWaitTimeAfterAttack = new TextField();
        minWaitTimeAfterAttack.setText(String.valueOf(combat.getMinWaitTimeAfterAttack()));

        grid.add(minWaitTimeAfterAttack,1,1);
        grid.add(new Label("Min wait time after attack (ms):"), 0, 1);

        // MinWaitTimeInMsAfterSummon
        TextField minWaitTimeAfterSummon = new TextField();
        minWaitTimeAfterSummon.setText(String.valueOf(combat.getMinWaitTimeAfterSummon()));

        grid.add(minWaitTimeAfterSummon,1,2);
        grid.add(new Label("Min wait time after summon (ms):"), 0, 2);
        
        // MinWaitTimeInMsAfterSummon
        TextField minWaitTimeAfterAbility = new TextField();
        minWaitTimeAfterAbility.setText(String.valueOf(combat.getMinWaitTimeAfterAbility()));

        grid.add(minWaitTimeAfterAbility,1,3);
        grid.add(new Label("Min wait time after ability (ms):"), 0, 3);

        // LuaScript
        Button luaScript = new Button("Browse");
        luaScript.setOnAction(e -> {
            luaFile = fileChooser.showOpenDialog(primaryStage);
            if (luaFile != null) {
                luaPath = luaFile.getAbsolutePath().toString();
            }
        });

        grid.add(luaScript,1,4);
        grid.add(new Label("Lua Script:"), 0, 4);

        // ReloadPageOnLastBattle
        CheckBox reloadPageOnLastBattle = new CheckBox();
        reloadPageOnLastBattle.setSelected(combat.isReloadPage());

        grid.add(reloadPageOnLastBattle,1,5);
        grid.add(new Label("Reload page on last battle:"), 0, 5);

        // DoNotWaitForServerResponse
        CheckBox notWaitForServerResponse = new CheckBox();
        notWaitForServerResponse.setSelected(combat.isNotWaitForServerResponse());

        grid.add(notWaitForServerResponse,1,6);
        grid.add(new Label("Not wait for server response:"), 0, 6);

        // MaxWaitTimeToLoadCharacterSelectionMenuInMs
        TextField maxWaitTimeToLoadCharacterSelectionMenu = new TextField();
        maxWaitTimeToLoadCharacterSelectionMenu.setText(String.valueOf(combat.getMaxWaitTimeToLoadCharacterSelection()));

        grid.add(maxWaitTimeToLoadCharacterSelectionMenu,1,7);
        grid.add(new Label("Max wait time to load character selection menu (ms):"), 0, 7);

        // DoNotWaitForServerResponse
        CheckBox retrieveStatusEffects = new CheckBox();
        retrieveStatusEffects.setSelected(combat.isRetrieveStatusEffects());

        grid.add(retrieveStatusEffects,1,8);
        grid.add(new Label("Retrieve status effect:"), 0, 8);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, minWaitTimeAfterAttack.getText(), minWaitTimeAfterSummon.getText(),
                                        minWaitTimeAfterAbility.getText(), luaPath, reloadPageOnLastBattle.isSelected(),
                                        notWaitForServerResponse.isSelected(), maxWaitTimeToLoadCharacterSelectionMenu.getText(),
                                        retrieveStatusEffects.isSelected()));
        grid.add(save, 1, 9);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handles save to Combat object
     * @param modelWrapper
     * @param minWaitTimeAfterAttack
     * @param minWaitTimeAfterSummon
     * @param minWaitTimeAfterAbility
     * @param luaPath
     * @param reloadPageOnLastBattle
     * @param notWaitForServerResponse
     * @param maxWaitTimeToLoadCharacterSelection
     * @param retrieveStatusEffect
     */
    private void handleSave(ModelWrapper modelWrapper, String minWaitTimeAfterAttack, String minWaitTimeAfterSummon,
                            String minWaitTimeAfterAbility, String luaPath, boolean reloadPageOnLastBattle,
                            boolean notWaitForServerResponse, String maxWaitTimeToLoadCharacterSelection,
                            boolean retrieveStatusEffect) {
        Combat combat = modelWrapper.getCombat();

        combat.setMinWaitTimeAfterAbility(Long.parseLong(minWaitTimeAfterAbility));
        combat.setMinWaitTimeAfterSummon(Long.parseLong(minWaitTimeAfterSummon));
        combat.setMinWaitTimeAfterAttack(Long.parseLong(minWaitTimeAfterAttack));
        combat.setLuaScript(luaPath);
        combat.setReloadPage(reloadPageOnLastBattle);
        combat.setNotWaitForServerResponse(notWaitForServerResponse);
        combat.setMaxWaitTimeToLoadCharacterSelection(Long.parseLong(maxWaitTimeToLoadCharacterSelection));
        combat.setRetrieveStatusEffects(retrieveStatusEffect);
    }
}
