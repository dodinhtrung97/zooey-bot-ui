package service;

/**
 * Created by Trung on 10/14/2017.
 */
public interface LineCheckService {

    /**
     * Return model type
     * @param line
     * @return
     */
    String modelType(String line);

    /**
     * Check if current line is a comment
     * @param line
     * @return
     */
    boolean isComment(String line);

    /**
     * Check if current line defines a model mark
     * Example: [Combat]
     * @param line
     * @return
     */
    boolean isModel(String line);

}
