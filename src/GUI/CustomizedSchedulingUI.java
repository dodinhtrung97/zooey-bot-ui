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
import model.CustomizedScheduling;
import model.ModelWrapper;
import service.DataApplyService;
import service.FileParseService;
import service.impl.DataApplyServiceImpl;
import service.impl.FileParseServiceImpl;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Trung on 10/14/2017.
 */
public class CustomizedSchedulingUI {

    private final FileChooser fileChooser = new FileChooser();

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final DataApplyService dataApplyService = new DataApplyServiceImpl();

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
            schedulingLua = fileChooser.showOpenDialog(primaryStage);
            if (schedulingLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI_ABSOLUTE);
                Path p2 = Paths.get(schedulingLua.getAbsolutePath());
                schedulingLuaPath = p1.relativize(p2).toString();
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
        List<String> fileContent = null;

        customizedScheduling.setLuaScript(schedulingLuaPath);

        try {
            fileContent = fileParseService.generateFileContentFromIni();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Apply data change
        for (String prefix: Constant.CUSTOMIZED_SCHEDULING_PARAMS) {
            dataApplyService.applyData(prefix, fileContent, modelWrapper, Constant.MODE_CUSTOMIZED_SCHEDULING);
        }
    }
}
