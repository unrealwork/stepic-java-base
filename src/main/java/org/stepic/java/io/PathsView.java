package org.stepic.java.io;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class PathsView {
    public static final Logger LOGGER = Logger.getLogger(PathsView.class.getName());

    public static void main(String[] args) {
        String[] paths = new String[]{
                "a/b/c/file.txt",
                "a/./b/../c/./file.txt",
                "a/b/../file.txt",
                "./a/b/../b/c/./file.txt",
                "a/../b/c/file.txt"
        };
        for (String pathString : paths) {
            try {
                Path path = Paths.get(pathString);
                String canonicalPath = new File(pathString).getAbsoluteFile().getCanonicalPath();
                new FileInputStream(path.toFile());
                Files.newInputStream(path);

                LOGGER.info(canonicalPath);
            } catch (IOException e) {
                LOGGER.severe(String.format("Incorrect path %s", pathString));
            }
        }
    }
}
