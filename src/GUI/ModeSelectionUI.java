package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.*;
import service.DataApplyService;
import service.FileParseService;
import service.impl.DataApplyServiceImpl;
import service.impl.FileParseServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Trung on 10/14/2017.
 */
public class ModeSelectionUI {

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final DataApplyService dataApplyService = new DataApplyServiceImpl();

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    @SuppressWarnings("Duplicates")
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        EventMode eventMode1 = modelWrapper.getEventMode();
        TreasureEventMode treasureEventMode1 = modelWrapper.getTreasureEventMode();
        SoloCoopMode soloCoopMode1 = modelWrapper.getSoloCoopMode();
        CustomizedScheduling customizedScheduling1 = modelWrapper.getCustomizedScheduling();
        SlaveMode slaveMode1 = modelWrapper.getSlaveMode();

        VBox vBox = new VBox();
        vBox.setPrefWidth(500);

        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 20, 5, 10));

        final ToggleGroup toggleGroup = new ToggleGroup();

        // Event Mode
        RadioButton eventMode = new RadioButton("Event Mode");
        eventMode.setSelected(eventMode1.isEnabled());
        eventMode.setToggleGroup(toggleGroup);
        grid.add(eventMode, 0, 1);

        // Treasure Event Mode
        RadioButton treasureEventMode = new RadioButton("Treasure Event Mode");
        treasureEventMode.setSelected(treasureEventMode1.isEnabled());
        treasureEventMode.setToggleGroup(toggleGroup);
        grid.add(treasureEventMode, 1, 1);

        // Solo Coop Mode
        RadioButton soloCoopMode = new RadioButton("Solo Coop Mode");
        soloCoopMode.setSelected(soloCoopMode1.isEnabled());
        soloCoopMode.setToggleGroup(toggleGroup);
        grid.add(soloCoopMode, 0, 2);

        // Customized Scheduling
        RadioButton customizedScheduling = new RadioButton("Customized Scheduling");
        customizedScheduling.setSelected(customizedScheduling1.isEnabled());
        customizedScheduling.setToggleGroup(toggleGroup);
        grid.add(customizedScheduling, 1, 2);

        // Slave Mode
        RadioButton slaveMode = new RadioButton("Slave Mode");
        slaveMode.setSelected(slaveMode1.isEnabled());
        slaveMode.setToggleGroup(toggleGroup);
        grid.add(slaveMode, 0, 3);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, eventMode.isSelected(), treasureEventMode.isSelected(),
                                        soloCoopMode.isSelected(), customizedScheduling.isSelected(), slaveMode.isSelected()));
        grid.add(save, 1, 4);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle Mode Selection
     * @param modelWrapper
     * @param eventMode
     * @param treasureEventMode
     * @param soloCoopMode
     * @param customizedScheduling
     * @param slaveMode
     */
    private void handleSave(ModelWrapper modelWrapper, boolean eventMode, boolean treasureEventMode, boolean soloCoopMode,
                            boolean customizedScheduling, boolean slaveMode) {
        EventMode eventMode1 = modelWrapper.getEventMode();
        TreasureEventMode treasureEventMode1 = modelWrapper.getTreasureEventMode();
        SoloCoopMode soloCoopMode1 = modelWrapper.getSoloCoopMode();
        CustomizedScheduling customizedScheduling1 = modelWrapper.getCustomizedScheduling();
        SlaveMode slaveMode1 = modelWrapper.getSlaveMode();
        List<String> fileContent = null;

        eventMode1.setEnabled(false);
        treasureEventMode1.setEnabled(false);
        soloCoopMode1.setEnabled(false);
        customizedScheduling1.setEnabled(false);
        slaveMode1.setEnabled(false);

        if (eventMode) eventMode1.setEnabled(true);
        if (treasureEventMode) treasureEventMode1.setEnabled(true);
        if (soloCoopMode)soloCoopMode1.setEnabled(true);
        if (customizedScheduling) customizedScheduling1.setEnabled(true);
        if (slaveMode) slaveMode1.setEnabled(true);

        try {
            fileContent = fileParseService.generateFileContentFromIni();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataApplyService.applyData(Constant.ENABLE, fileContent, modelWrapper, Constant.MODE_EVENT);
        dataApplyService.applyData(Constant.ENABLE, fileContent, modelWrapper, Constant.MODE_TREASURE_EVENT);
        dataApplyService.applyData(Constant.ENABLE, fileContent, modelWrapper, Constant.MODE_SOLO_COOP);
        dataApplyService.applyData(Constant.ENABLE, fileContent, modelWrapper, Constant.MODE_CUSTOMIZED_SCHEDULING);
        dataApplyService.applyData(Constant.ACTIVE, fileContent, modelWrapper, Constant.MODE_SLAVE);
    }
}
