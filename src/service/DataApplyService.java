package service;

import model.ModelWrapper;

import java.util.List;

/**
 * Created by Trung on 10/15/2017.
 */
public interface DataApplyService {

    /**
     * Apply data to zooeybot.ini
     * @param line
     * @param fileContent
     * @param modelWrapper
     * @param model
     */
    void applyData(String line, List<String> fileContent, ModelWrapper modelWrapper, String model);
}
