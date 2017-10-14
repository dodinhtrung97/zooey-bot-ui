package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelWrapper;
import model.TreasureEventMode;

import java.io.File;

/**
 * Created by Trung on 10/14/2017.
 */
public class TreasureEventModeUI {

    private final FileChooser fileChooser = new FileChooser();
    private File treasureEventLua;
    private String treasureEventLuaPath = "";

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
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
                treasureEventLuaPath = treasureEventLua.getAbsolutePath().toString();
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

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, treasureEventRaidURL.getText(), treasureEventLuaPath,
                                        actionPointCost.getText()));
        grid.add(save, 1, 5);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save to TreasureEvent
     * @param modelWrapper
     * @param treasureEventURL
     * @param treasureEventLuaPath
     * @param actionPointCost
     */
    private void handleSave(ModelWrapper modelWrapper, String treasureEventURL, String treasureEventLuaPath,
                            String actionPointCost) {
        TreasureEventMode treasureEventMode = modelWrapper.getTreasureEventMode();

        treasureEventMode.setTreasureEventUrl(treasureEventURL);
        treasureEventMode.setTreasureEventModeScript(treasureEventLuaPath);
        treasureEventMode.setActionPointCost(actionPointCost);
    }
}