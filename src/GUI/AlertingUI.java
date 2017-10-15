package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Alerting;
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
public class AlertingUI {

    private final FileChooser fileChooser = new FileChooser();
    private final DataApplyService dataApplyService = new DataApplyServiceImpl();
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
            notificationSound = fileChooser.showOpenDialog(primaryStage);
            if (notificationSound != null) {
                Path p1 = Paths.get(Constant.ZOOEY_BOT_INI_ABSOLUTE);
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
    private void handleSave(ModelWrapper modelWrapper, String soundPath, String numNotification,
                            String maxSummonSelection){
        Alerting alerting = modelWrapper.getAlerting();
        List<String> fileContent = null;

        alerting.setCaptchaNotificationSoundPath(soundPath);
        alerting.setNumNotification(Long.parseLong(numNotification));
        alerting.setMaxNumSummonSelectionFailuresBeforePlayingSound(Long.parseLong(maxSummonSelection));

        FileParseService fileParseService = new FileParseServiceImpl();
        try {
            fileContent = fileParseService.generateFileContentFromIni();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataApplyService.applyData("CaptchaNotificationSoundPath", fileContent, modelWrapper, "Alerting");
        dataApplyService.applyData("NumNotifications", fileContent, modelWrapper, "Alerting");
        dataApplyService.applyData("MaxNumSummonSelectionFailuresBeforePlayingSoundNotification", fileContent, modelWrapper, "Alerting");
    }
}
