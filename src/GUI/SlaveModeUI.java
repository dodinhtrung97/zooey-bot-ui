package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelWrapper;
import model.SlaveMode;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Trung on 10/14/2017.
 */
public class SlaveModeUI {

    private final FileChooser fileChooser = new FileChooser();
    private File mainLua;
    private File slaveLua;
    private String mainLuaPath = "";
    private String slaveLuaPath = "";

    /**
     * Draw SlaveMode UI
     * @param primaryStage
     * @param modelWrapper
     * @return
     */
    @SuppressWarnings("Duplicates")
    public VBox drawMainPane(Stage primaryStage, ModelWrapper modelWrapper) {
        SlaveMode slaveMode = modelWrapper.getSlaveMode();

        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // Main Account Lua
        Button browseMainLua = new Button("Browse");
        browseMainLua.setOnAction(e -> {
            mainLua = fileChooser.showOpenDialog(primaryStage);
            if (mainLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(mainLua.getAbsolutePath());
                mainLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(browseMainLua,1,1);
        grid.add(new Label("Main Account Lua Script:"), 0, 1);

        // Slave Account Lua
        Button browseSlaveLua = new Button("Browse");
        browseSlaveLua.setOnAction(e -> {
            slaveLua = fileChooser.showOpenDialog(primaryStage);
            if (slaveLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(slaveLua.getAbsolutePath());
                slaveLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(browseSlaveLua,1,2);
        grid.add(new Label("Slave Account Lua Script:"), 0, 2);

        // ProcessMainAccountTurnFirst
        CheckBox mainAccountFirst = new CheckBox();
        mainAccountFirst.setSelected(slaveMode.isMainAccFirst());

        grid.add(mainAccountFirst,1,3);
        grid.add(new Label("Process Main Account turn first:"), 0, 3);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, mainAccountFirst.isSelected(), mainLuaPath, slaveLuaPath));
        grid.add(save, 1, 4);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save into SaveMode Object
     * @param modelWrapper
     * @param mainAccountFirst
     * @param mainAccountLua
     * @param slaveAccountLua
     */
    private void handleSave(ModelWrapper modelWrapper, boolean mainAccountFirst,
                            String mainAccountLua, String slaveAccountLua) {
        SlaveMode slaveMode = modelWrapper.getSlaveMode();

        slaveMode.setMainAccFirst(mainAccountFirst);
        slaveMode.setSlaveAccLua(slaveAccountLua);
        slaveMode.setMainAccLua(mainAccountLua);
    }
}
