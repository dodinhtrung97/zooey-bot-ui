package runner;

import GUI.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ModelWrapper;
import model.PartySelection;
import service.FileParseService;
import service.impl.FileParseServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {

    private final SidePane sidePane = new SidePane();
    private final GeneralUI generalUI = new GeneralUI();
    private final SlaveModeUI slaveModeUI = new SlaveModeUI();
    private final InputUI inputUI = new InputUI();
    private final PartySelectionUI partySelectionUI = new PartySelectionUI();
    private final FileParseService fileParseService = new FileParseServiceImpl();

    @Override
    public void start(Stage primaryStage) throws Exception{
        ModelWrapper modelWrapper = fileParseService.parseInitFile();

        BorderPane root = new BorderPane();
        root.setLeft(sidePane.drawSidePane());
        root.setRight(partySelectionUI.drawMainPane(modelWrapper));
//        root.setRight(generalUI.drawMainPane(modelWrapper));
//        root.setRight(slaveModeUI.drawMainPane(primaryStage, modelWrapper));
//        root.setRight(inputUI.drawMainPane(modelWrapper));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(650);
        primaryStage.setHeight(550);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Zooey Ini Simple UI");
        primaryStage.show();
    }

    public static void main(String[] args) throws URISyntaxException, IOException{
        launch(args);
    }
}
