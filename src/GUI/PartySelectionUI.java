package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.ModelWrapper;
import model.PartySelection;

/**
 * Created by Trung on 10/14/2017.
 */
public class PartySelectionUI {

    /**
     * Draw Party Selection UI
     * @param modelWrapper
     * @return
     */
    public VBox drawMainPane(ModelWrapper modelWrapper) {
        PartySelection partySelection = modelWrapper.getPartySelection();

        VBox vBox = new VBox();
        vBox.setPrefWidth(500);

        GridPane grid = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(-7, 10, 5, 10));

        // PreferredPartyGroup
        TextField preferredPartyGroup = new TextField();
        preferredPartyGroup.setText(String.valueOf(partySelection.getPreferredPartyGroup()));

        grid.add(preferredPartyGroup,1,1);
        grid.add(new Label("Preferred party group:"), 0, 1);

        // PreferredPartyDeck
        TextField preferredPartyDeck = new TextField();
        preferredPartyDeck.setText(String.valueOf(partySelection.getPreferredPartyDeck()));

        grid.add(preferredPartyDeck,1,2);
        grid.add(new Label("Preferred party deck:"), 0, 2);

        // PreferredPartyDeck
        TextField preferredNightmareModePartyGroup = new TextField();
        preferredNightmareModePartyGroup.setText(String.valueOf(partySelection.getPreferredNightmarePartyGroup()));

        grid.add(preferredNightmareModePartyGroup,1,3);
        grid.add(new Label("Preferred nightmare party deck:"), 0, 3);

        // PreferredPartyDeck
        TextField preferredNightmareModePartyDeck = new TextField();
        preferredNightmareModePartyDeck.setText(String.valueOf(partySelection.getPreferredNightmarePartyDeck()));

        grid.add(preferredNightmareModePartyDeck,1,4);
        grid.add(new Label("Preferred nightmare party deck:"), 0, 4);

        // Save
        Button save = new Button();
        save.setText("SAVE");
        save.setPrefSize(180, 40);
        save.setOnAction(e -> handleSave(modelWrapper, preferredPartyGroup.getText(), preferredPartyDeck.getText(),
                                        preferredNightmareModePartyGroup.getText(), preferredNightmareModePartyDeck.getText()));
        grid.add(save, 1, 5);

        vBox.getChildren().addAll(grid);
        vBox.setStyle("-fx-background-color: white");
        return vBox;
    }

    /**
     * handle saving into PartySelection Object
     * @param modelWrapper
     * @param preferredPartyGroup
     * @param preferredPartyDeck
     * @param preferredNMPartyGroup
     * @param preferredNMPartyDeck
     */
    private void handleSave(ModelWrapper modelWrapper, String preferredPartyGroup, String preferredPartyDeck,
                            String preferredNMPartyGroup, String preferredNMPartyDeck) {
        PartySelection partySelection = modelWrapper.getPartySelection();

        partySelection.setPreferredPartyGroup(Integer.parseInt(preferredPartyGroup));
        partySelection.setPreferredPartyDeck(Integer.parseInt(preferredPartyDeck));
        partySelection.setPreferredNightmarePartyGroup(Integer.parseInt(preferredNMPartyGroup));
        partySelection.setPreferredNightmarePartyDeck(Integer.parseInt(preferredNMPartyDeck));
    }
}
