package service.impl;

import constant.Constant;
import model.ModelWrapper;
import model.ModelWrapperContainer;
import service.DataApplyService;
import service.DataInjectionService;
import service.FileParseService;
import service.LineCheckService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trung on 10/14/2017.
 */
public class FileParseServiceImpl implements FileParseService{

    private final LineCheckService lineCheckService = new LineCheckServiceImpl();
    private final DataInjectionService dataInjectionService = new DataInjectionServiceImpl();
    private final DataApplyService dataApplyService = new DataApplyServiceImpl();

    /**
     * Parse zooeybot.ini to object models
     * @return
     */
    public ModelWrapper parseInitFile() {
        ModelWrapper modelWrapper = new ModelWrapper();

        BufferedReader reader = null;
        FileReader file = null;

        try {
            file = new FileReader(Constant.ZOOEY_BOT_INI);
            reader = new BufferedReader(file);

            String currentLine;
            String model = "";

            while ((currentLine = reader.readLine()) != null) {
                if (!lineCheckService.isComment(currentLine) && !currentLine.equals("")) {
                    if (lineCheckService.isModel(currentLine)) model = lineCheckService.modelType(currentLine);
                    else dataInjectionService.injectData(currentLine, modelWrapper, model);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
                if (file != null) file.close();
            } catch (IOException e) { e.printStackTrace(); }
        }
        return modelWrapper;
    }

    /**
     * Apply data in object to ZooeyBot.ini
     * @param fileContent
     */
    public void applyData(List<String> fileContent, String prefix, String replaceWith) {

        for (int i = 0; i < fileContent.size(); i++) {
            String currentLine = fileContent.get(i);

            if (!lineCheckService.isComment(currentLine) && !currentLine.equals("")) {
                if (currentLine.contains(prefix)) {
                    fileContent.set(i, replaceWith);
                }
            }
        }

        try {
            Files.write(FileSystems.getDefault().getPath(Constant.ZOOEY_BOT_INI_ABSOLUTE), fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inject object data to file
     */
    public List<String> generateFileContentFromIni() {
        List<String> fileContent = null;

        try {
            fileContent = new ArrayList<>(Files.readAllLines(FileSystems.getDefault()
                            .getPath(Constant.ZOOEY_BOT_INI_ABSOLUTE), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }
}
