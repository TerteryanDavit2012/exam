package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileService {

    public static ArrayList<String> readFile(String url) throws IOException {
        return new ArrayList<>(Files.readAllLines(Path.of(url)));
    }

    public static void writeFile(String url, String content) throws IOException {
        Files.write(
                Paths.get(url),
                content.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }
}