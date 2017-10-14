package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.EventMode;
import model.ModelWrapper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Trung on 10/14/2017.
 */
public class EventModeUI {

    private final FileChooser fileChooser = new FileChooser();
    private File eventLua;
    private String eventLuaPath = "";
    private File nightmareModeLua;
    private String nightmareModeLuaPath = "";

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    @SuppressWarnings("Duplicates")
    public VBox drawMainPane(Stage primaryStage, ModelWrapper modelWrapper) {
        EventMode eventMode = modelWrapper.getEventMode();

        VBox vBox = new VBox();
        vBox.setPrefWidth(500);

        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // EventRaidUrl
        TextField eventRaidURL = new TextField();
        eventRaidURL.setText(String.valueOf(eventMode.getEventRaidUrl()));

        grid.add(eventRaidURL,1,1);
        grid.add(new Label("Event raid URL:"), 0, 1);

        // LuaScript
        Button eventLuaScript = new Button("Browse");
        eventLuaScript.setOnAction(e -> {
            eventLua = fileChooser.showOpenDialog(primaryStage);
            if (eventLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(eventLua.getAbsolutePath());
                eventLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(eventLuaScript,1,2);
        grid.add(new Label("Event Lua Script:"), 0, 2);

        // NightMareRaidUrl
        TextField nightmareModeURL = new TextField();
        nightmareModeURL.setText(String.valueOf(eventMode.getNightmareModeUrl()));

        grid.add(nightmareModeURL,1,3);
        grid.add(new Label("Nightmare mode URL:"), 0, 3);

        // Nightmare LuaScript
        Button nightmareModeLuaScript = new Button("Browse");
        nightmareModeLuaScript.setOnAction(e -> {
            nightmareModeLua = fileChooser.showOpenDialog(primaryStage);
            if (nightmareModeLua != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(nightmareModeLua.getAbsolutePath());
                nightmareModeLuaPath = p2.relativize(p1).toString();
            }
        });

        grid.add(nightmareModeLuaScript,1,4);
        grid.add(new Label("Nightmare mode Lua Script:"), 0, 4);

        // EventRaidUrl
        TextField eventPageURL = new TextField();
        eventPageURL.setText(String.valueOf(eventMode.getEventPageUrl()));

        grid.add(eventPageURL,1,5);
        grid.add(new Label("Event Page URL:"), 0, 5);

        // NightmareModePreferredSummon
        TextField nightmareModePreferredSummon = new TextField();
        nightmareModePreferredSummon.setText(String.valueOf(eventMode.getNightmareModePreferredSummon()));

        grid.add(nightmareModePreferredSummon,1,6);
        grid.add(new Label("Nightmare Mode Preferred Summon:"), 0, 6);

        // RerollSummonWhenNoPreferredSummonWasFoundForNightmareMode
        CheckBox rerollForSummon = new CheckBox();
        rerollForSummon.setSelected(eventMode.isRerollForSummon());

        grid.add(rerollForSummon,1,7);
        grid.add(new Label("Reroll For Summon during nightmare:"), 0, 7);

        // NightmareModeAvailableAtStart
        CheckBox nightmareAtStart = new CheckBox();
        nightmareAtStart.setSelected(eventMode.isNightmareModeAvailableAtStart());

        grid.add(nightmareAtStart,1,8);
        grid.add(new Label("Nightmare Mode available at start:"), 0, 8);

        // WaitTimeInMsAfterEventPageIsLoaded
        TextField waitTimeAfterEventPageIsLoaded = new TextField();
        waitTimeAfterEventPageIsLoaded.setText(String.valueOf(eventMode.getWaitTimeAfterPageLoaded()));

        grid.add(waitTimeAfterEventPageIsLoaded,1,9);
        grid.add(new Label("Wait time after event page is loaded (ms):"), 0, 9);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, eventRaidURL.getText(), eventLuaPath, nightmareModeURL.getText(),
                                        nightmareModeLuaPath, eventPageURL.getText(), nightmareModePreferredSummon.getText(),
                                        rerollForSummon.isSelected(), nightmareAtStart.isSelected(), waitTimeAfterEventPageIsLoaded.getText()));
        grid.add(save, 1, 10);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save into EventMode
     * @param modelWrapper
     * @param eventRaidURL
     * @param eventLuaPath
     * @param nightmareModeURL
     * @param nightmareModeLuaPath
     * @param eventPageURL
     * @param nightmareModePreferredSummon
     * @param rerollForSummon
     * @param nightmareAtStart
     * @param waitTimeAfterEventPageIsLoaded
     */
    private void handleSave(ModelWrapper modelWrapper, String eventRaidURL, String eventLuaPath, String nightmareModeURL,
                            String nightmareModeLuaPath, String eventPageURL, String nightmareModePreferredSummon,
                            boolean rerollForSummon, boolean nightmareAtStart, String waitTimeAfterEventPageIsLoaded) {
        EventMode eventMode = modelWrapper.getEventMode();

        eventMode.setEventRaidUrl(eventRaidURL);
        eventMode.setEventRaidScript(eventLuaPath);
        eventMode.setNightmareModeUrl(nightmareModeURL);
        eventMode.setNightmareModeScript(nightmareModeLuaPath);
        eventMode.setEventPageUrl(eventPageURL);
        eventMode.setNightmareModePreferredSummon(nightmareModePreferredSummon);
        eventMode.setRerollForSummon(rerollForSummon);
        eventMode.setNightmareModeAvailableAtStart(nightmareAtStart);
        eventMode.setWaitTimeAfterPageLoaded(Long.parseLong(waitTimeAfterEventPageIsLoaded));
    }
}
