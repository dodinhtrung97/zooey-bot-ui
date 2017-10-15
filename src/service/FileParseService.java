package service;

import model.ModelWrapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Trung on 10/14/2017.
 */
public interface FileParseService {

    /**
     * Parse zooeybot.ini
     * @return
     */
    ModelWrapper parseInitFile() throws URISyntaxException, FileNotFoundException;

    /**
     * Inject object to file
     * @throws URISyntaxException
     * @throws FileNotFoundException
     */
    List<String> generateFileContentFromIni() throws URISyntaxException, IOException;

    /**
     * Apply data in object to ZooeyBot.ini
     * @param fileContent
     * @param prefix
     * @param fullLine
     * @param model
     */
    void applyData(List<String> fileContent, String prefix, String fullLine, String model);
}
