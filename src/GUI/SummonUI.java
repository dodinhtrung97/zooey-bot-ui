package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.ModelWrapper;
import model.Summon;

/**
 * Created by Trung on 10/14/2017.
 */
public class SummonUI {

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        Summon summon = modelWrapper.getSummon();

        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // PreferredPartyGroup
        TextField preferredSummon = new TextField();
        preferredSummon.setText(String.valueOf(summon.getPreferredSummon()));

        grid.add(preferredSummon,1,1);
        grid.add(new Label("Preferred Summons:"), 0, 1);

        // PreferredPartyDeck
        TextField defaultSummonTab = new TextField();
        defaultSummonTab.setText(String.valueOf(summon.getDefaultSummonTab()));

        grid.add(defaultSummonTab,1,2);
        grid.add(new Label("Default summon tab:"), 0, 2);

        // RerollSummon
        CheckBox rerollSummon = new CheckBox();
        rerollSummon.setSelected(summon.isRerollSummon());

        grid.add(rerollSummon,1,3);
        grid.add(new Label("Reroll for summon:"), 0, 3);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, preferredSummon.getText(), defaultSummonTab.getText(),
                                        rerollSummon.isSelected()));
        grid.add(save, 1, 4);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save to summon object
     * @param modelWrapper
     * @param preferredSummons
     * @param preferredSummonTab
     * @param rerollForSummon
     */
    private void handleSave(ModelWrapper modelWrapper, String preferredSummons, String preferredSummonTab,
                            boolean rerollForSummon) {
        Summon summon = modelWrapper.getSummon();

        summon.setRerollSummon(rerollForSummon);
        summon.setDefaultSummonTab(preferredSummonTab);
        summon.setPreferredSummon(preferredSummons);
    }
}
