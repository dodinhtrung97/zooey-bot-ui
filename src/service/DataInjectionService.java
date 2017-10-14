package service;

import model.ModelWrapper;

/**
 * Created by Trung on 10/14/2017.
 */
public interface DataInjectionService {

    /**
     * Inject data by object type
     *
     * @param line
     * @param modelWrapper
     * @param model
     */
    void injectData(String line, ModelWrapper modelWrapper, String model);
}
