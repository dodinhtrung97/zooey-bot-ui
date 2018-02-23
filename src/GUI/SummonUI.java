package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.ModelWrapper;
import model.Summon;
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
public class SummonUI {

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final DataApplyService dataApplyService = new DataApplyServiceImpl();

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        Summon summon = modelWrapper.getSummon();

        VBox vBox = new VBox();
        vBox.setPrefWidth(500);

        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // PreferredSummon
        TextField preferredSummon = new TextField();
        preferredSummon.setText(String.valueOf(summon.getPreferredSummon()));

        grid.add(preferredSummon,1,1);
        grid.add(new Label("Preferred Summons:"), 0, 1);

        // DefaultSummonTab
        ChoiceBox<String> defaultSummonTab = new ChoiceBox<>();
        defaultSummonTab.getItems().addAll("Fire", "Water", "Earth", "Wind", "Light", "Dark", "Misc");
        defaultSummonTab.setValue(summon.getDefaultSummonTab());

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
        save.setOnAction(e -> handleSave(modelWrapper, preferredSummon.getText(), defaultSummonTab.getValue(),
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
        List<String> fileContent = null;

        summon.setRerollSummon(rerollForSummon);
        summon.setDefaultSummonTab(preferredSummonTab);
        summon.setPreferredSummon(preferredSummons);

        try {
            fileContent = fileParseService.generateFileContentFromIni();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Apply data change
        for (String prefix: Constant.SUMMON_PARAMS) {
            dataApplyService.applyData(prefix, fileContent, modelWrapper, Constant.MODE_SUMMON);
        }
    }
}
