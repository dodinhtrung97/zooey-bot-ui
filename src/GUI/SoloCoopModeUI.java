package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.EventMode;
import model.ModelWrapper;
import model.SoloCoopMode;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Trung on 10/14/2017.
 */
public class SoloCoopModeUI {

    private final FileChooser fileChooser = new FileChooser();
    private File soloCoopLua;
    private String soloCoopLuaPath = "";

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
            soloCoopLua = fileChooser.showOpenDialog(primaryStage);
            if (soloCoopLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(soloCoopLua.getAbsolutePath());
                soloCoopLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(eventLuaScript,1,1);
        grid.add(new Label("Solo Coop Lua Script:"), 0, 1);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, soloCoopLuaPath));
        grid.add(save, 1, 2);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save into SoloCoopMode
     * @param soloCoopLuaPath
     */
    private void handleSave(ModelWrapper modelWrapper, String soloCoopLuaPath) {
        SoloCoopMode soloCoopMode = modelWrapper.getSoloCoopMode();

        soloCoopMode.setLuaScript(soloCoopLuaPath);
    }
}
