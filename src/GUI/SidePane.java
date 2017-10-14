package GUI;

import constant.Constant;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Trung on 10/14/2017.
 */
public class SidePane {

    /**
     * Draw navigation pane
     * @return
     */
    public VBox drawSidePane() {
        VBox vBox = new VBox();
        vBox.setPrefWidth(150);

        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(this.Item(Constant.NAVIGATION_ITEMS[i]));
        }

        vBox.setStyle("-fx-background-color: #2d3041");
        return vBox;
    }

    /**
     * Initialize object to navigate
     * @param name
     * @return
     */
    private HBox Item(String name){
        Button button = new Button();
        button.setPrefSize(150, 70);
        button.setText(name);

        HBox hBox = new HBox(button);
        return hBox;
    }
}
