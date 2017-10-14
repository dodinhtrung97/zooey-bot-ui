package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.CountdownTimer;
import model.General;
import model.ModelWrapper;

/**
 * Created by Trung on 10/14/2017.
 */
public class GeneralUI {

    /**
     * Draw General UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        General general = modelWrapper.getGeneral();
        CountdownTimer countdownTimer = modelWrapper.getCountdownTimer();

        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // Language
        ChoiceBox<String> language = new ChoiceBox<>();
        language.getItems().addAll("jp", "en");
        language.setValue(general.getLanguage());

        grid.add(language,1,1);
        grid.add(new Label("Language:"), 0, 1);

        // ChromeDevToolsWindowDockedOnTheRight
        CheckBox isDockedRight = new CheckBox();
        isDockedRight.setSelected(general.isDevToolsDockedOnTheRight());

        grid.add(isDockedRight,1,2);
        grid.add(new Label("Chrome Dev Tool docked on the right:"), 0, 2);

        // Viramate
        CheckBox useViramate = new CheckBox();
        useViramate.setSelected(general.isUseViramate());

        grid.add(useViramate,1,3);
        grid.add(new Label("Use Viramate:"), 0, 3);

        // MaxPageLoadDelayInMsBeforeRetry
        TextField maxPageLoadDelay = new TextField();
        maxPageLoadDelay.setText(String.valueOf(general.getMaxLoadDelay()));

        grid.add(maxPageLoadDelay,1,4);
        grid.add(new Label("Max page load delay before retry (ms):"), 0, 4);

        // MaxTriggerDelayInMsBeforeFallback
        TextField maxTriggerDelay = new TextField();
        maxTriggerDelay.setText(String.valueOf(general.getMaxTriggerDelay()));

        grid.add(maxTriggerDelay,1,5);
        grid.add(new Label("Max trigger delay before fallback (ms):"), 0, 5);

        // MaxResponseDelayInMs
        TextField maxResponseDelay = new TextField();
        maxResponseDelay.setText(String.valueOf(general.getMaxResponseDelay()));

        grid.add(maxResponseDelay,1,6);
        grid.add(new Label("Max response delay (ms):"), 0, 6);

        // MaxNumActionRetries
        TextField maxNumAction = new TextField();
        maxNumAction.setText(String.valueOf(general.getMaxNumAction()));

        grid.add(maxNumAction,1,7);
        grid.add(new Label("Max number of actions retries (ms):"), 0, 7);

        // MinWaitTimeInMsAfterRefresh
        TextField minWaitTime = new TextField();
        minWaitTime.setText(String.valueOf(general.getMinWaitTime()));

        grid.add(minWaitTime,1,8);
        grid.add(new Label("Min wait time after refresh (ms):"), 0, 8);

        // TimeLimitInSeconds
        TextField botRunTime = new TextField();
        botRunTime.setText(String.valueOf(general.getTimeLimit()));

        grid.add(botRunTime,1,9);
        grid.add(new Label("Bot run time (s):"), 0, 9);

        // MaxNumPotionsToUse
        TextField maxPotion = new TextField();
        maxPotion.setText(String.valueOf(general.getMaxNumPotion()));

        grid.add(maxPotion,1,10);
        grid.add(new Label("Maxium number of Potions:"), 0, 10);

        // UseFullElixirsWhenNoRemainingHalfAPPotions
        CheckBox useFullEx = new CheckBox();
        useFullEx.setSelected(general.isUseFullEx());

        grid.add(useFullEx,1,11);
        grid.add(new Label("Use Full Ex after Potions run out:"), 0, 11);

        // UseFullElixirsFirst
        CheckBox useFullExFirst = new CheckBox();
        useFullExFirst.setSelected(general.isUseFullExFirst());

        grid.add(useFullExFirst,1,12);
        grid.add(new Label("Use Full Ex before Potion:"), 0, 12);

        // CountdownTimerHorizontalPosition
        TextField countdownTimerHorizontal = new TextField();
        countdownTimerHorizontal.setText(String.valueOf(countdownTimer.getCountdownTimerHorizontalPos()));

        grid.add(countdownTimerHorizontal,1,13);
        grid.add(new Label("Coundown Timer Horizontal Position:"), 0, 13);

        // CountdownTimerHorizontalPosition
        TextField countdownTimerVertical = new TextField();
        countdownTimerVertical.setText(String.valueOf(countdownTimer.getCountdownTimerVerticalPos()));

        grid.add(countdownTimerVertical,1,14);
        grid.add(new Label("Coundown Timer Vertical Position:"), 0, 14);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, language.getValue(), isDockedRight.isSelected(), useViramate.isSelected(),
                                        maxPageLoadDelay.getText(), maxTriggerDelay.getText(), maxResponseDelay.getText(),
                                        maxNumAction.getText(), minWaitTime.getText(), botRunTime.getText(),
                                        maxPotion.getText(), useFullEx.isSelected(), useFullExFirst.isSelected(),
                                        countdownTimerHorizontal.getText(), countdownTimerVertical.getText()));
        grid.add(save, 1, 15);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle saving into General Object
     * @param modelWrapper
     * @param language
     * @param isDockedRight
     * @param useViramate
     * @param maxPageLoadDelay
     * @param maxTriggerDelay
     * @param maxResponseDelay
     * @param maxNumAction
     * @param minWaitTime
     * @param botRunTime
     * @param maxPotion
     * @param useFulEx
     * @param useFullExFirst
     * @param countdownTimerHorizontal
     * @param countdownTimerVertical
     */
    private void handleSave(ModelWrapper modelWrapper, String language, boolean isDockedRight, boolean useViramate,
                            String maxPageLoadDelay, String maxTriggerDelay, String maxResponseDelay, String maxNumAction,
                            String minWaitTime, String botRunTime, String maxPotion, boolean useFulEx, boolean useFullExFirst,
                            String countdownTimerHorizontal, String countdownTimerVertical) {
        General general = modelWrapper.getGeneral();
        CountdownTimer countdownTimer = modelWrapper.getCountdownTimer();

        general.setLanguage(language);
        general.setDevToolsDockedOnTheRight(isDockedRight);
        general.setUseViramate(useViramate);
        general.setMaxLoadDelay(Long.parseLong(maxPageLoadDelay));
        general.setMaxTriggerDelay(Long.parseLong(maxTriggerDelay));
        general.setMaxResponseDelay(Long.parseLong(maxResponseDelay));
        general.setMaxNumAction(Integer.parseInt(maxNumAction));
        general.setMinWaitTime(Long.parseLong(minWaitTime));
        general.setTimeLimit(Long.parseLong(botRunTime));
        general.setMaxNumPotion(Long.parseLong(maxPotion));
        general.setUseFullEx(useFulEx);
        general.setUseFullExFirst(useFullExFirst);

        countdownTimer.setCountdownTimerHorizontalPos(Integer.parseInt(countdownTimerHorizontal));
        countdownTimer.setCountdownTimerVerticalPos(Integer.parseInt(countdownTimerVertical));
    }
}
