package service.impl;

import service.PathFixService;

/**
 * Created by Trung on 10/16/2017.
 */
public class PathFixServiceImpl implements PathFixService {

    /**
     * Fix Path
     * @param path
     */
    @Override
    public String fixPath(String path) {
        path = path.substring(3, path.length()-1);
        path = path.replace("\\", "/");

        return path;
    }
}
