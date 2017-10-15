package runner;

import GUI.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ModelWrapperContainer;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {

    private final SidePane sidePane = new SidePane();

    private final FileParseService fileParseService = new FileParseServiceImpl();
    private final GeneralUI generalUI = new GeneralUI();

    @Override
    public void start(Stage primaryStage) throws Exception{
        ModelWrapperContainer.modelWrapper = fileParseService.parseInitFile();

        BorderPane root = new BorderPane();
        root.setLeft(sidePane.drawSidePane(root, primaryStage));
        root.setRight(generalUI.drawMainPane(ModelWrapperContainer.modelWrapper));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(650);
        primaryStage.setHeight(550);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Zooey Ini Simple UI");
        primaryStage.getIcons().add(new Image("https://img.fireden.net/vg/image/1460/35/1460352961515.jpg"));
        primaryStage.show();
    }

    public static void main(String[] args) throws URISyntaxException, IOException{
        launch(args);
    }
}
