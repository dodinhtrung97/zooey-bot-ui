package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelWrapper;
import model.SoloCoopMode;
import service.DataApplyService;
import service.FileParseService;
import service.PathFixService;
import service.impl.DataApplyServiceImpl;
import service.impl.FileParseServiceImpl;
import service.impl.PathFixServiceImpl;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Trung on 10/14/2017.
 */
public class SoloCoopModeUI {

    private final FileChooser fileChooser = new FileChooser();

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final DataApplyService dataApplyService = new DataApplyServiceImpl();

    private final PathFixService pathFixService = new PathFixServiceImpl();

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
        vBox.setPrefWidth(500);

        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // LuaScript
        Button eventLuaScript = new Button("Browse");
        eventLuaScript.setOnAction(e -> {
            soloCoopLua = fileChooser.showOpenDialog(primaryStage);
            if (soloCoopLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI_ABSOLUTE);
                Path p2 = Paths.get(soloCoopLua.getAbsolutePath());
                soloCoopLuaPath = pathFixService.fixPath(p1.relativize(p2).toString());
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
        List<String> fileContent = null;

        soloCoopMode.setLuaScript(soloCoopLuaPath);

        try {
            fileContent = fileParseService.generateFileContentFromIni();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Apply data change
        for (String prefix: Constant.SOLO_COOP_PARAMS) {
            dataApplyService.applyData(prefix, fileContent, modelWrapper, Constant.MODE_SOLO_COOP);
        }
    }
}
