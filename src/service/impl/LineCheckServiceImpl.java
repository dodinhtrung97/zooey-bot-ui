package service.impl;

import service.LineCheckService;

/**
 * Created by Trung on 10/14/2017.
 */
public class LineCheckServiceImpl implements LineCheckService{
    /**
     * Return model type
     * @param line
     * @return
     */
    public String modelType(String line) {
        return line.substring(1, line.length()-1);
    }

    /**
     * Check if current line is a comment
     * @param line
     * @return
     */
    public boolean isComment(String line) {
        return line.startsWith("#");
    }

    /**
     * Check if current line defines a model mark
     * Example: [Combat]
     * @param line
     * @return
     */
    public boolean isModel(String line) {
        return (line.startsWith("[") && line.endsWith("]"));
    }
}
