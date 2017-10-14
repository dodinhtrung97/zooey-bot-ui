package service.impl;

import constant.Constant;
import model.ModelWrapper;
import service.DataInjectionService;
import service.FileParseService;
import service.LineCheckService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Trung on 10/14/2017.
 */
public class FileParseServiceImpl implements FileParseService{

    private final LineCheckService lineCheckService = new LineCheckServiceImpl();
    private final DataInjectionService dataInjectionService = new DataInjectionServiceImpl();

    /**
     * Parse zooeybot.ini to object models
     * @return
     */
    public ModelWrapper parseInitFile()  {
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
}
