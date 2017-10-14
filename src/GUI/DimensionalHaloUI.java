package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.CountdownTimer;
import model.DimensionalHalo;
import model.General;
import model.ModelWrapper;

/**
 * Created by Trung on 10/14/2017.
 */
public class DimensionalHaloUI {

    /**
     * Draw General UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        DimensionalHalo dimensionalHalo = modelWrapper.getDimensionalHalo();

        VBox vBox = new VBox();
        vBox.setPrefWidth(600);

        GridPane grid = new GridPane();
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

        dimensionalHalo.setRetreatWhenNoDimensionalHaloTransform(retreatWhenNoTransform);
    }
}
