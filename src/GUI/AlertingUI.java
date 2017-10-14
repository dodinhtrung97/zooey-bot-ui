package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Alerting;
import model.ModelWrapper;
import model.SoloCoopMode;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Trung on 10/14/2017.
 */
public class AlertingUI {

    private final FileChooser fileChooser = new FileChooser();
    private File notificationSound;
    private String notificationSoundPath = "";

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    @SuppressWarnings("Duplicates")
    public VBox drawMainPane(Stage primaryStage, ModelWrapper modelWrapper) {
        Alerting alerting = modelWrapper.getAlerting();

        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // LuaScript
        Button eventLuaScript = new Button("Browse");
        eventLuaScript.setOnAction(e -> {
            notificationSound = fileChooser.showOpenDialog(primaryStage);
            if (notificationSound != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI);
                Path p2 = Paths.get(notificationSound.getAbsolutePath());
                notificationSoundPath = p2.relativize(p1).toString();
            }
        });

        grid.add(eventLuaScript,1,1);
        grid.add(new Label("Sound File:"), 0, 1);

        // NumNotifications
        TextField numNotification = new TextField();
        numNotification.setText(String.valueOf(alerting.getNumNotification()));

        grid.add(numNotification,1,2);
        grid.add(new Label("Number of notification:"), 0, 2);


        // MaxNumSummonSelectionFailuresBeforePlayingSoundNotification
        TextField maxSummonSelectionFailure = new TextField();
        maxSummonSelectionFailure.setText(String.valueOf(alerting.getMaxNumSummonSelectionFailuresBeforePlayingSound()));

        grid.add(maxSummonSelectionFailure,1,3);
        grid.add(new Label("Number of notification:"), 0, 3);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, notificationSoundPath, numNotification.getText(),
                                        maxSummonSelectionFailure.getText()));
        grid.add(save, 1, 4);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save to Alerting
     * @param modelWrapper
     * @param soundPath
     * @param numNotification
     * @param maxSummonSelection
     */
    private void handleSave(ModelWrapper modelWrapper, String soundPath, String numNotification, String maxSummonSelection) {
        Alerting alerting = modelWrapper.getAlerting();

        alerting.setCaptchaNotificationSoundPath(soundPath);
        alerting.setNumNotification(Long.parseLong(numNotification));
        alerting.setMaxNumSummonSelectionFailuresBeforePlayingSound(Long.parseLong(maxSummonSelection));
    }
}
