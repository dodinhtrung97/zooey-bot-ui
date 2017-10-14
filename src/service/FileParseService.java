package service;

import model.ModelWrapper;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Created by Trung on 10/14/2017.
 */
public interface FileParseService {

    /**
     * Parse zooeybot.ini
     * @return
     */
    ModelWrapper parseInitFile() throws URISyntaxException, FileNotFoundException;
}
