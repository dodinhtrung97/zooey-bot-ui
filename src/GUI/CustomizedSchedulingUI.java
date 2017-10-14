package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.CustomizedScheduling;
import model.ModelWrapper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Trung on 10/14/2017.
 */
public class CustomizedSchedulingUI {

    private final FileChooser fileChooser = new FileChooser();
    private File schedulingLua;
    private String schedulingLuaPath = "";

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    @SuppressWarnings("Duplicates")
    public VBox drawMainPane(Stage primaryStage, ModelWrapper modelWrapper) {
        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // LuaScript
        Button eventLuaScript = new Button("Browse");
        eventLuaScript.setOnAction(e -> {
            schedulingLua = fileChooser.showOpenDialog(primaryStage);
            if (schedulingLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(schedulingLua.getAbsolutePath());
                schedulingLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(eventLuaScript,1,1);
        grid.add(new Label("Scheduling Lua Script:"), 0, 1);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, schedulingLuaPath));
        grid.add(save, 1, 2);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save into SoloCoopMode
     * @param schedulingLuaPath
     */
    private void handleSave(ModelWrapper modelWrapper, String schedulingLuaPath) {
        CustomizedScheduling customizedScheduling = modelWrapper.getCustomizedScheduling();

        customizedScheduling.setLuaScript(schedulingLuaPath);
    }
}
