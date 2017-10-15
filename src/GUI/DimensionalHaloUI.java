package GUI;

import constant.Constant;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.DimensionalHalo;
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
public class DimensionalHaloUI {

    private final FileParseService fileParseService = new FileParseServiceImpl();

    private final DataApplyService dataApplyService = new DataApplyServiceImpl();

    /**
     * Draw General UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        DimensionalHalo dimensionalHalo = modelWrapper.getDimensionalHalo();

        VBox vBox = new VBox();
        vBox.setPrefWidth(500);

        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // RetreatWhenNoDimensionalHaloTransformation
        CheckBox retreatWhenNoTransform = new CheckBox();
        retreatWhenNoTransform.setSelected(dimensionalHalo.isRetreatWhenNoDimensionalHaloTransform());

        grid.add(retreatWhenNoTransform,1,1);
        grid.add(new Label("Retreat when no Halo Transformation:"), 0, 1);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, retreatWhenNoTransform.isSelected()));
        grid.add(save, 1, 2);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * Handle save to DimensionalHalo
     * @param modelWrapper
     * @param retreatWhenNoTransform
     */
    private void handleSave(ModelWrapper modelWrapper, boolean retreatWhenNoTransform) {
        DimensionalHalo dimensionalHalo = modelWrapper.getDimensionalHalo();
        List<String> fileContent = null;

        dimensionalHalo.setRetreatWhenNoDimensionalHaloTransform(retreatWhenNoTransform);

        try {
            fileContent = fileParseService.generateFileContentFromIni();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Apply data change
        for (String prefix: Constant.DIMENSIONAL_HALO_PARAMS) {
            dataApplyService.applyData(prefix, fileContent, modelWrapper, Constant.MODE_DIMENSIONAL_HALO);
        }
    }
}
