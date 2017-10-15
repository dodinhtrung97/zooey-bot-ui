package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Input;
import model.ModelWrapper;
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
public class InputUI {

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final DataApplyService dataApplyService = new DataApplyServiceImpl();

    /**
     * Draw Input UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        Input input = modelWrapper.getInput();

        VBox vBox = new VBox();
        vBox.setPrefWidth(500);

        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // DelayInMsBetweenMouseDownAndUp
        TextField delayBetweenMouseDownAndUp = new TextField();
        delayBetweenMouseDownAndUp.setText(String.valueOf(input.getDelayBetweenMouseDownAndUp()));

        grid.add(delayBetweenMouseDownAndUp,1,1);
        grid.add(new Label("Delay between mouse down and up (ms):"), 0, 1);

        // RandomDelayInMsBetweenMouseDownAndUp
        TextField randomDelayBetweenMouseDownAndUp = new TextField();
        randomDelayBetweenMouseDownAndUp.setText(String.valueOf(input.getRandomDelayBetweenDownAndUp()));

        grid.add(randomDelayBetweenMouseDownAndUp,1,2);
        grid.add(new Label("Random delay between mouse down and up (ms):"), 0, 2);

        // MouseSpeed
        TextField mouseSpeed = new TextField();
        mouseSpeed.setText(String.valueOf(input.getMouseSpeed()));

        grid.add(mouseSpeed,1,3);
        grid.add(new Label("Mouse Speed:"), 0, 3);

        // MouseScrollSpeed
        TextField mouseScrollSpeed = new TextField();
        mouseScrollSpeed.setText(String.valueOf(input.getMouseScrollSpeed()));

        grid.add(mouseScrollSpeed,1,4);
        grid.add(new Label("Mouse Scroll Speed:"), 0, 4);

        // ExitKeyCode
        TextField exitKeyCode = new TextField();
        exitKeyCode.setText(String.valueOf(input.getExitKeyCode()));

        grid.add(exitKeyCode,1,5);
        grid.add(new Label("Exit key code:"), 0, 5);

        // WaitTimeInMsBeforeClickInput
        TextField waitTime = new TextField();
        waitTime.setText(String.valueOf(input.getWaitTimeBeforeClickInput()));

        grid.add(waitTime,1,6);
        grid.add(new Label("Wait time before click input (ms):"), 0, 6);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, delayBetweenMouseDownAndUp.getText(),
                                        randomDelayBetweenMouseDownAndUp.getText(), mouseSpeed.getText(),
                                        mouseScrollSpeed.getText(), exitKeyCode.getText(), waitTime.getText()));
        grid.add(save, 1, 7);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle saving into Input Object
     * @param modelWrapper
     * @param delayBetweenMouseDownAndUp
     * @param randomDelayBetweenMouseDownAndUp
     * @param mouseSpeed
     * @param mouseScollSpeed
     * @param exitKeyCode
     * @param waitTimeBeforeInput
     */
    private void handleSave(ModelWrapper modelWrapper, String delayBetweenMouseDownAndUp, String randomDelayBetweenMouseDownAndUp,
                            String mouseSpeed, String mouseScollSpeed, String exitKeyCode, String waitTimeBeforeInput) {
        Input input = modelWrapper.getInput();
        List<String> fileContent = null;

        input.setDelayBetweenMouseDownAndUp(Long.parseLong(delayBetweenMouseDownAndUp));
        input.setRandomDelayBetweenDownAndUp(Long.parseLong(randomDelayBetweenMouseDownAndUp));
        input.setMouseSpeed(Long.parseLong(mouseSpeed));
        input.setMouseScrollSpeed(Long.parseLong(mouseScollSpeed));
        input.setExitKeyCode(Long.parseLong(exitKeyCode));
        input.setWaitTimeBeforeClickInput(Long.parseLong(waitTimeBeforeInput));

        try {
            fileContent = fileParseService.generateFileContentFromIni();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Apply data change
        for (String prefix: Constant.INPUT_PARAMS) {
            dataApplyService.applyData(prefix, fileContent, modelWrapper, Constant.MODE_INPUT);
        }
    }
}
