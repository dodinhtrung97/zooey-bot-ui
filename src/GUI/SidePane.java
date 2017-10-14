package GUI;

import constant.Constant;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ModelWrapperContainer;
import param.handler.ButtonTextHandler;

/**
 * Created by Trung on 10/14/2017.
 */
public class SidePane {

    /**
     * Draw navigation pane
     * @return
     */
    public VBox drawSidePane(BorderPane root, Stage primaryStage) {
        VBox vBox = new VBox();
        vBox.setPrefWidth(150);

        for (int i = 0; i < Constant.NAVIGATION_ITEMS.length; i++) {
            vBox.getChildren().add(this.Item(root, primaryStage, Constant.NAVIGATION_ITEMS[i]));
        }

        vBox.setStyle("-fx-background-color: #2d3041");
        return vBox;
    }

    /**
     * Initialize object to navigate
     * @param root
     * @param name
     * @return
     */
    private HBox Item(BorderPane root, Stage primaryStage, String name){
        Button button = new Button();
        button.setPrefSize(150, 70);
        button.setText(name);

        button.setOnAction(e -> {
            ButtonTextHandler buttonTextHandler = new ButtonTextHandler();

            buttonTextHandler.setRoot(root);
            buttonTextHandler.setPrimaryStage(primaryStage);
            buttonTextHandler.setModelWrapper(ModelWrapperContainer.modelWrapper);

            buttonTextHandler.handle(name);
        });

        HBox hBox = new HBox(button);
        return hBox;
    }
}
