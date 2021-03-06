package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Source https://github.com/datsoftlyngby/soft2021spring-mal/blob/main/src/main/java/dk/cphbusiness/mal/utils/FileUtility.java
 */
public class FileUtility {

    /**
     * Read all words from a file in lower case.
     * Filter away characters in a delimiter regex pattern.
     *
     * <code>
     * String[] words =
     * FileUtility.toStringArray("PathToTheFile.txt", "[^A-Za-z']+");
     * </code>
     *
     * @param path             The path to the file to read
     * @param delimiterPattern regex pattern of delimiters
     * @return an array of words from the file
     * @throws IOException if file does not exist
     */
    public static String[] toStringArray(
            String path,
            String delimiterPattern
    ) throws IOException {
        return Files.lines(Paths.get(path))
                .flatMap(line -> Stream.of(line.split(delimiterPattern)))
                .filter(word -> !word.isEmpty())
                .map(word -> word.toLowerCase())
                .toArray(String[]::new);
    }

    /**
     * A basic implementation of toStringArray utilizing the default delimiter pattern "[^A-Za-z']+"
     * @param path
     * @return
     * @throws IOException
     */
    public static String[] toStringArray(String path) throws IOException {
        return Files.lines(Paths.get(path))
                .flatMap(line -> Stream.of(line.split("[^A-Za-z]+")))
                .filter(word -> !word.isEmpty())
                .map(word -> word.toLowerCase())
                .toArray(String[]::new);
    }

}